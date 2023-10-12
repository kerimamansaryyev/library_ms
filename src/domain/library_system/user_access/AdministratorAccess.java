package domain.library_system.user_access;

import domain.entities.book.Author;
import domain.entities.book.Book;
import domain.entities.book.BookCopy;
import domain.entities.book.BookType;
import domain.entities.library_member.LibraryMember;
import domain.library_system.LibrarySystem;
import domain.library_system.exceptions.BookAlreadyExistsException;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;

import java.util.List;

public class AdministratorAccess extends Access implements IAddBookOperation, IAddMemberOperation, IAddBookCopyOperation {
    protected AdministratorAccess(LibrarySystem system) {
        super(system);
    }

    @Override
    public int addBookCopy(String isbnNumber, int numOfCopies) throws BookNotFoundException {
        return system.addBookCopy(isbnNumber, numOfCopies);
    }

    @Override
    public LibraryMember addMember(
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber) {
        return system.addMember(
                firstName,
                lastName,
                street,
                city,
                state,
                zipCode,
                phoneNumber
        );
    }

    @Override
    public Book addBook(
            String isbnNumber,
            String title,
            List<Author> authors,
            BookType bookType,
            int maxCheckoutLength,
            int numberOfCopies)
            throws BookAlreadyExistsException {
        return system.addBook(isbnNumber, title, authors, bookType,maxCheckoutLength, numberOfCopies);
    }
}
