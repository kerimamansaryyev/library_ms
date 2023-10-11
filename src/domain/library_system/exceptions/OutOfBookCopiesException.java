package domain.library_system.exceptions;

public class OutOfBookCopiesException  extends  LibrarySystemException{
    private static final String displayableMessage = "Sorry, there are not enough copies of this book";
    public OutOfBookCopiesException() {
        super(displayableMessage);
    }
}
