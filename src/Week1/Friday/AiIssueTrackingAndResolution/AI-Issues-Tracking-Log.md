# AI Issues Tracking Log


## 1) Initial code (before changes)

```java
package Week1.Friday.AiIssueTrackingAndResolution;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmailRoster {
    private List<String> emails = new ArrayList<>();

    // Insecure query builder: vulnerable to SQL Injection
    public void saveToDatabase(Connection conn, String email) throws Exception {
        Statement stmt = conn.createStatement();
        String sql = "INSERT INTO users (email) VALUES ('" + email + "')";
        stmt.executeUpdate(sql); // LINE 12: SQL Injection point!
    }

    public void addEmail(String email) {
        emails.add(email); // Allows duplicate emails
    }
}
```

---

## 2) User prompts (chronological)

- "Act as a security auditor and static analysis engine. Review this Java class and generate a list of issues..."
- "Please generate a solution to the critical issues and ONLY the critical issues for now"
- "Please generate a solution to the major and minor issues now"
- "Can you please generate a Ai-Issues-Tracking-Log.md file where you log the initial code, my prompts and your gradual solution and then the final code"

---

## 3) Gradual solution / actions taken

### Security audit (findings - critical)
- SQL injection: string concatenation into SQL.
- Resource leak: Statement not closed.
- Null/empty input edge-case: passing null/empty leads to malformed SQL or DB error.

### Applied critical fixes
- Replaced Statement + string concat with PreparedStatement parameterized query.
- Used try-with-resources to ensure PreparedStatement is closed.
- Added null/empty validation for email and throw IllegalArgumentException.

Snippet after critical fix:
```java
String sql = "INSERT INTO users (email) VALUES (?)";
try (PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setString(1, email);
    ps.executeUpdate();
}
```

### Applied major & minor fixes (requested later)
- Enforced uniqueness with a thread-safe LinkedHashSet (preserves insertion order).
- Added input validation (regex + MAX_EMAIL_LENGTH) and normalized to lowercase.
- addEmail now validates and returns boolean indicating success.
- Exposed getEmails() that returns an unmodifiable snapshot.
- Tightened exception to SQLException for DB errors and documented transaction behavior.
- Added java.util.logging for warnings/errors and JavaDoc comments.

---

## 4) Final code (after major/minor fixes)

```java
package Week1.Friday.AiIssueTrackingAndResolution;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * EmailRoster manages a collection of emails and persists them to a database.
 * Improvements: thread-safe collection, input validation, uniqueness, and safer DB usage.
 */
public class EmailRoster {
    private static final Logger LOGGER = Logger.getLogger(EmailRoster.class.getName());
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final int MAX_EMAIL_LENGTH = 254;

    // Thread-safe set to enforce uniqueness and preserve insertion order
    private final Set<String> emails = Collections.synchronizedSet(new LinkedHashSet<>());

    /**
     * Adds an email to the in-memory roster after validation.
     * Returns true if the email was added (was not already present).
     */
    public boolean addEmail(String email) {
        if (email == null) {
            LOGGER.warning("Rejected null email");
            return false;
        }
        String trimmed = email.trim().toLowerCase();
        if (trimmed.isEmpty() || trimmed.length() > MAX_EMAIL_LENGTH) {
            LOGGER.warning("Rejected email due to empty or too long: " + trimmed);
            return false;
        }
        if (!EMAIL_PATTERN.matcher(trimmed).matches()) {
            LOGGER.warning("Rejected email due to invalid format: " + trimmed);
            return false;
        }
        return emails.add(trimmed);
    }

    /**
     * Returns an unmodifiable snapshot of the current emails.
     */
    public Set<String> getEmails() {
        synchronized (emails) {
            return Collections.unmodifiableSet(new LinkedHashSet<>(emails));
        }
    }

    /**
     * Persists a validated email to the database using a PreparedStatement.
     * This method does not manage transactions; the caller is responsible for commit/rollback.
     * Throws SQLException for database errors and IllegalArgumentException for invalid input.
     */
    public void saveToDatabase(Connection conn, String email) throws SQLException {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("email must be non-null and non-empty");
        }
        String normalized = email.trim().toLowerCase();
        if (normalized.length() > MAX_EMAIL_LENGTH || !EMAIL_PATTERN.matcher(normalized).matches()) {
            throw new IllegalArgumentException("invalid email format");
        }

        String sql = "INSERT INTO users (email) VALUES (?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, normalized);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.severe("Failed to insert email into database: " + e.getMessage());
            throw e;
        }
    }
}
```

---

## 5) Notes & next steps
- Transactions: saveToDatabase does not manage conn.setAutoCommit/commit; caller should handle transactions when batch operations are needed.
- Testing: add unit tests for validation, uniqueness, and DB interactions (use an in-memory DB / mocks).
- Optional improvements: batch insert, idempotent upsert semantics, metrics on rejects.


---

End of log.
