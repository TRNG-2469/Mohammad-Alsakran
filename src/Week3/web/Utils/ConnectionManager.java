package Week3.web.Utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static volatile ConnectionManager INSTANCE;
    private final String url;
    private final String user;
    private final String pass;

    private ConnectionManager() {
        url = requireEnv("JDBC_URL");
        user = requireEnv("DB_USER");
        pass = requireEnv("DB_PASS");
    }

    private static String requireEnv(String key) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("Missing required environment variable: " + key);
        }
        return value;
    }

    public static ConnectionManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ConnectionManager.class) {
                if (INSTANCE == null) INSTANCE = new ConnectionManager();
            }
        }
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
