package Week3.web;

import com.rev.web.Controllers.TodoController;
import com.rev.web.Exceptions.ErrorResponse;
import io.javalin.Javalin;

public class App {




    public static void main(String[] args) {


        // initialize and start Javalin
        Javalin app = Javalin.create()
                .start(8080);

        TodoController todoController = new TodoController();

        // 1. Retrieve all Todos
        app.get("/api/todos", todoController::getAllTodos);


        // 2. Retrieve a single Todo by ID
        app.get("/api/todos/{id}", todoController::getTodoById);


        //Centralized Exception Handling
        app.exception(IllegalArgumentException.class, (e, ctx) -> {
            ctx.status(400);
            ctx.json(new ErrorResponse(e.getMessage()));
        });

        app.exception(Exception.class, (e, ctx) -> {
            e.printStackTrace();
            ctx.status(500);
            ctx.json(new ErrorResponse("Internal Server Error"));
        });



        // 3. POST data -- create new Todo
        app.post("/api/todos", todoController::createTodo);


        // 4. Update todo based on id
        app.put("/api/todos/{id}", todoController::updateTodoById);



        // 5. Delete todo based on id
        app.delete("/api/todos/{id}", todoController::deleteTodoById);
    }
}
