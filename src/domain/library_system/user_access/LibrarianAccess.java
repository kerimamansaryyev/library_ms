package domain.library_system.user_access;

import domain.entities.library_member.CheckoutRecord;
import domain.library_system.LibrarySystem;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.MemberNotFoundException;
import domain.library_system.exceptions.OutOfBookCopiesException;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;

public class LibrarianAccess extends Access implements ICheckoutBookOperation {
    protected LibrarianAccess(LibrarySystem system) {
        super(system);
    }

    @Override
    public CheckoutRecord checkoutBook(String memberId, String isbnNumber) throws MemberNotFoundException,
            BookNotFoundException,
            OutOfBookCopiesException{
       return system.checkoutBook(memberId, isbnNumber);
    }
}
