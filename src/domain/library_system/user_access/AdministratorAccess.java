package domain.library_system.user_access;

import domain.entities.library_member.LibraryMember;
import domain.library_system.LibrarySystem;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;

public class AdministratorAccess extends Access implements IAddBookOperation, IAddMemberOperation, IAddBookCopyOperation {
    protected AdministratorAccess(LibrarySystem system) {
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
    public void addBook(String isbnNumber, String title, String authors, int maxCheckoutLength, int numberOfCopies) {
        system.addBook(isbnNumber, title, authors, maxCheckoutLength, numberOfCopies);
    }
}
