package Week3.web.Controllers;
import com.rev.web.Services.TodoService;
import com.rev.web.model.Todo;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TodoController {


    private final TodoService todoService = new TodoService();


    // 1. GET All Todos
    public void getAllTodos(Context ctx) {
        ctx.json(todoService.getAllTodos());
    }

    // 2. GET ONE : Read 1 Todo
    public  void getTodoById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Todo todo = todoService.getTodoById(id);
        ctx.json(todo);
    }

    // 3. Create todo
    public  void createTodo(Context ctx) {
        Todo payload =ctx.bodyAsClass(Todo.class);
        Todo newTodo = todoService.createTodo(payload);
        ctx.status(201);
        ctx.json(newTodo);

    }


    //4. update todo
    public void updateTodoById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Todo payload = ctx.bodyAsClass(Todo.class);
        ctx.json(todoService.updateTodo(id, payload));
    }


    // 5. Delete Todo
    public  void deleteTodoById(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        todoService.deleteTodo(id);
        ctx.status(204); // No Content
    }
}
