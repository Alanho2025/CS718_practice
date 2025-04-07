package PracticeSix_custom_exception;

public class InvalidWordException extends Exception {
    public InvalidWordException(String message) {
        super(message);
    }
}
