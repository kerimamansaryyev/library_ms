package domain.library_system.user_access;

import domain.entities.book.Author;
import domain.entities.book.Book;
import domain.entities.book.BookCopy;
import domain.entities.book.BookType;
import domain.entities.library_member.LibraryMember;
import domain.library_system.LibrarySystem;
import domain.library_system.exceptions.*;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;

import java.util.List;

public class SuperAdminAccess extends Access implements IAddBookCopyOperation, IAddBookOperation, IAddMemberOperation, ICheckoutBookOperation {
    protected SuperAdminAccess(LibrarySystem system) {
        super(system);
    }

    @Override
    public List<BookCopy> addBookCopy(String isbnNumber) throws BookNotFoundException {
       return  system.addBookCopy(isbnNumber);
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
    public void checkoutBook(String memberId, String isbnNumber) throws MemberNotFoundException, BookNotFoundException, OutOfBookCopiesException, OutOfCheckoutsLimitException {
        system.checkoutBook(
                memberId,
                isbnNumber
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
