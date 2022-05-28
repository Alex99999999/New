package application.exception.user;

public class UserUpdateFailureException extends RuntimeException {

    public UserUpdateFailureException(String message) {
        super(message);
    }

}
