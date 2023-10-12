package domain.library_system.exceptions;

public class BookAlreadyExistsException extends  LibrarySystemException  {
    private static final String displayableMessage = "Sorry, this book already exists in the system";
    public BookAlreadyExistsException() {
        super(displayableMessage);
    }
}
