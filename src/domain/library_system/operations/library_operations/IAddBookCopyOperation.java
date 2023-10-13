package domain.library_system.operations.library_operations;

import domain.library_system.exceptions.BookNotFoundException;

public interface IAddBookCopyOperation extends ILibraryOperation {

    int addBookCopy(String isbnNumber, int numOfCopies) throws BookNotFoundException;
}
