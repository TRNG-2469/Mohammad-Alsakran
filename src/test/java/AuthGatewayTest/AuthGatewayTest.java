package AuthGatewayTest;

import Week2.Friday.SQLInjection.VulnerableAuthGateway;
import static org.junit.jupiter.api.Assertions.*;import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AuthGatewayTest {


    private static Connection connection;
    private final VulnerableAuthGateway authGateway = new VulnerableAuthGateway();

    @BeforeAll
    public static void setup() throws SQLException {
        connection = DriverManager.getConnection(
                System.getenv("DB_URL"),
                System.getenv("DB_USERNAME"),
                System.getenv("DB_PASSWORD")
        );
    }

    @Test
    public void testValidLogin() throws SQLException{
        assertTrue(authGateway.authenticateUser("john@email.com", "testpass123", connection));
        // Add assertions to verify the expected behavior for a valid login
    }

    @Test
    public void testInvalidLogin() throws SQLException{
        assertFalse(authGateway.authenticateUser("invalid@email.com", "invalidpassword", connection));
    }



    @Test
    public void testSQLInjection() throws SQLException {
        assertFalse(authGateway.authenticateUser("' OR '1'='1", "' OR '1'='1", connection));
    }
}
