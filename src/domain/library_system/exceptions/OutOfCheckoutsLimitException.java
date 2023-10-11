package domain.library_system.exceptions;

public class OutOfCheckoutsLimitException extends LibrarySystemException{
    private static final String displayableMessage = "Sorry, you exceeded a checkout limit for this book";
    public OutOfCheckoutsLimitException() {
        super(displayableMessage);
    }
}
