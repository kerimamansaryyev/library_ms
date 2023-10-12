package domain.library_system.user_access;

import domain.entities.library_member.LibraryMember;
import domain.library_system.LibrarySystem;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.MemberNotFoundException;
import domain.library_system.exceptions.OutOfBookCopiesException;
import domain.library_system.exceptions.OutOfCheckoutsLimitException;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;

public class SuperAdminAccess extends Access implements IAddBookCopyOperation, IAddBookOperation, IAddMemberOperation, ICheckoutBookOperation {
    protected SuperAdminAccess(LibrarySystem system) {
        super(system);
    }

    @Override
    public void addBookCopy(String isbnNumber) throws BookNotFoundException {
        system.addBookCopy(isbnNumber);
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
    public void addBook(String isbnNumber, String title, String authors, int maxCheckoutLength, int numberOfCopies) {
        system.addBook(isbnNumber, title, authors, maxCheckoutLength, numberOfCopies);
    }
}
