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