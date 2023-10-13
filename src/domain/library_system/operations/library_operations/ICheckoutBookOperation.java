package domain.library_system.operations.library_operations;

import domain.entities.library_member.CheckoutRecord;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.MemberNotFoundException;
import domain.library_system.exceptions.OutOfBookCopiesException;

public interface ICheckoutBookOperation extends ILibraryOperation {

    CheckoutRecord checkoutBook(String memberId, String isbnNumber)
            throws
            MemberNotFoundException,
            BookNotFoundException,
            OutOfBookCopiesException;
}
