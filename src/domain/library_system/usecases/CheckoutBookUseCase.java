package domain.library_system.usecases;

import domain.entities.library_member.CheckoutRecord;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.MemberNotFoundException;
import domain.library_system.exceptions.OutOfBookCopiesException;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;

public final class CheckoutBookUseCase {

    public static CheckoutRecord checkoutBook(
            ICheckoutBookOperation operation,
            String memberId,
            String isbnNumber
    ) throws OutOfBookCopiesException, BookNotFoundException, MemberNotFoundException {
        return operation.checkoutBook(memberId,isbnNumber);
    }
}
