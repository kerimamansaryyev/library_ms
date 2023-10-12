package domain.library_system.usecases;

import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;

public class AddBookCopyUseCase {

    public static int addBookCopy(
            IAddBookCopyOperation addBookCopyOperation,
            String isbnNumber,
            int numberOfCopies
    ) throws BookNotFoundException {
        return addBookCopyOperation.addBookCopy(isbnNumber,numberOfCopies);
    }
}
