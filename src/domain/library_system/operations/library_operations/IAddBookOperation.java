package domain.library_system.operations.library_operations;

import domain.entities.book.Author;
import domain.entities.book.Book;
import domain.entities.book.BookType;
import domain.library_system.exceptions.BookAlreadyExistsException;

import java.util.List;

public interface IAddBookOperation extends  ILibraryOperation{

    Book addBook(
            String isbnNumber,
            String title,
            List<Author> authors,
            BookType bookType,
            int numberOfCopies
    ) throws BookAlreadyExistsException;
}
