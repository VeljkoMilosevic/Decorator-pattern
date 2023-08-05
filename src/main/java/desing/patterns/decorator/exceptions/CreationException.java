package desing.patterns.decorator.exceptions;

public class CreationException extends RuntimeException {

    public CreationException(final String msg, final Exception exception) {
        super(msg, exception);
    }
}
