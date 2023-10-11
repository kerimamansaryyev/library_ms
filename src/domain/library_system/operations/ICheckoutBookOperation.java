package domain.library_system.operations;

import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.MemberNotFoundException;
import domain.library_system.exceptions.OutOfBookCopiesException;
import domain.library_system.exceptions.OutOfCheckoutsLimitException;

public interface ICheckoutBookOperation {

    void checkoutBook(String memberId, String isbnNumber)
            throws
            MemberNotFoundException,
            BookNotFoundException,
            OutOfBookCopiesException,
            OutOfCheckoutsLimitException;
}
