package Week3.web.DAOs;

import com.rev.web.model.Todo;
import java.util.List;

public interface TodoDAO {

    Todo createTodo(Todo todo);

    void updateTodo(Todo todo);

    void deleteTodo(int id);

    Todo findById(int id);

    List<Todo> findAll();
}