package Week3.web.DAOs;
import com.rev.web.model.Todo;
import com.rev.web.Utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TodoDAOImpl implements TodoDAO {



    @Override
    public Todo createTodo(Todo todo) {
        String insertSQL = "INSERT INTO todo (title, completed) VALUES (?, ?) RETURNING id";
        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(insertSQL)) {
            ps.setString(1, todo.getTitle());
            ps.setBoolean(2, todo.isCompleted());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    todo.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create todo", e);
        }
        return todo;
    }

    @Override
    public void updateTodo(Todo todo) {
        String sql = "UPDATE todo SET title= ?, completed=? WHERE id=?";
        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, todo.getTitle());
            ps.setBoolean(2, todo.isCompleted());
            ps.setInt(3, todo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update todo", e);
        }
    }

    @Override
    public void deleteTodo(int id) {
        String sql = "DELETE FROM todo WHERE id=?";
        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete todo", e);
        }
    }

    @Override
    public Todo findById(int id) {
        String sql = "SELECT id, title, completed FROM todo WHERE id = ?";
        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Todo(rs.getInt("id"), rs.getString("title"), rs.getBoolean("completed"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch todo " + id, e);
        }
        return null;
    }

    @Override
    public List<Todo> findAll() {
        String sql = "SELECT id, title, completed FROM todo";
        List<Todo> todos = new ArrayList<>();
        try (Connection connection = ConnectionManager.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                todos.add(new Todo(rs.getInt("id"), rs.getString("title"), rs.getBoolean("completed")));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch todos", e);
        }
        return todos;
    }
}
