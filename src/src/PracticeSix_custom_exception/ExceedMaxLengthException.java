package PracticeSix_custom_exception;

public class ExceedMaxLengthException extends Exception {
    public ExceedMaxLengthException (String message) {
        super(message);
    }
}
