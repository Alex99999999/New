package application.exception.db;

public class ResourceClosingFailureException extends RuntimeException {

    public ResourceClosingFailureException(String message) {
        super(message);
    }

}
