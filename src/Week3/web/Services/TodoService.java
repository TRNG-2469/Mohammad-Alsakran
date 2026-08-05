package Week3.web.Services;

import com.rev.web.DAOs.TodoDAO;
import com.rev.web.DAOs.TodoDAOImpl;
import com.rev.web.model.Todo;
import io.javalin.http.NotFoundResponse;

import java.util.List;

public class TodoService {
    private final TodoDAO todoDAO = new TodoDAOImpl();

    public List<Todo> getAllTodos() {
        return todoDAO.findAll();
    }

    public Todo getTodoById(int id) {
        Todo todo = todoDAO.findById(id);
        if (todo == null) {
            throw new NotFoundResponse("Todo with id " + id + " not found");
        }
        return todo;
    }

    public Todo createTodo(Todo todo) {
        if (todo.getTitle() == null || todo.getTitle().isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        return todoDAO.createTodo(todo);
    }

    public Todo updateTodo(int id, Todo payload) {
        getTodoById(id); // throws 404 if it doesn't exist
        Todo updated = new Todo(id, payload.getTitle(), payload.isCompleted());
        todoDAO.updateTodo(updated);
        return updated;
    }

    public void deleteTodo(int id) {
        getTodoById(id); // throws 404 if it doesn't exist
        todoDAO.deleteTodo(id);
    }
}