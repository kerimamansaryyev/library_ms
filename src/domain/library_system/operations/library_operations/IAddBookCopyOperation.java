package domain.library_system.operations.library_operations;

import domain.library_system.exceptions.BookNotFoundException;

public interface IAddBookCopyOperation extends ILibraryOperation {

    void addBookCopy(String isbnNumber) throws BookNotFoundException;
}
