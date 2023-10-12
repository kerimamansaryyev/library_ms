package domain.library_system.operations.library_operations;

import domain.entities.book.BookCopy;
import domain.library_system.exceptions.BookNotFoundException;

import java.util.List;

public interface IAddBookCopyOperation extends ILibraryOperation {

    int addBookCopy(String isbnNumber, int numOfCopies) throws BookNotFoundException;
}
