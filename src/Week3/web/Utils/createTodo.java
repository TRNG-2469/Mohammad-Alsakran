package Week3.web.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class createTodo {

    private createTodo() {}

    public static void insertTodo(String title, String description) {
        String sql = "INSERT INTO todos(title, description) VALUES (?, ?)";
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, description);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert todo", e);
        }
    }

    // small helper to verify connectivity during development
    public static void printAllTodos() {
        String sql = "SELECT id, title, description FROM todos";
        try (Connection conn = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("title") + " : " + rs.getString("description"));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to read todos", e);
        }
    }
}
