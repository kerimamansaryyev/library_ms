package domain.library_system.exceptions;

public class BookNotFoundException extends  LibrarySystemException {

    private static final String displayableMessage = "Sorry, couldn't find the book";

    public BookNotFoundException() {
        super(displayableMessage);
    }
}
