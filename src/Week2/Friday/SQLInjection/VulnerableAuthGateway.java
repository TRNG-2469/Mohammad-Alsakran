package Week2.Friday.SQLInjection;

import java.sql.*;

public class VulnerableAuthGateway {

    public boolean authenticateUser(String emailInput, String passwordInput,Connection conn) throws SQLException {
        // VULNERABLE: Direct string concatenation of variables into a Statement
        String query = "SELECT * FROM members WHERE email = ? AND password = ?";
        // A user passing something like ' OR '1'='1 in the emailInput or passwordInput could bypass authentication
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, emailInput);
            stmt.setString(2, passwordInput);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        }
    }
}