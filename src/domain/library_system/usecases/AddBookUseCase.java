package domain.library_system.usecases;

import domain.entities.book.Author;
import domain.entities.book.Book;
import domain.entities.book.BookFacade;
import domain.entities.book.BookType;
import domain.library_system.exceptions.BookAlreadyExistsException;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;

import java.util.List;

public class AddBookUseCase {
    public static Book addBook(
            IAddBookOperation operation,
            String isbnNumber,
            String title,
            List<Author> authors,
            int numberOfCopies,
            BookType bookType
    ) throws BookAlreadyExistsException {
        return operation.addBook(
                isbnNumber, title, authors, bookType, numberOfCopies
        );
    }
}
