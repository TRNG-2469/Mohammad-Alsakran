package Week1.Friday.exceptionHandlingExcercise.Exceptions;

public class InvalidInputException extends RuntimeException{


    public InvalidInputException(String message) {
        super(message);
    }
}
