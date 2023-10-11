package domain.library_system.operations;

import domain.library_system.exceptions.BookNotFoundException;

public interface IAddBookCopyOperation {

    void addBookCopy(String isbnNumber) throws BookNotFoundException;
}
