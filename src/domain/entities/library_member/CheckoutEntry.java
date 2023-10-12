package domain.entities.library_member;

import domain.entities.BookCopy;

import java.time.LocalDate;

public class CheckoutEntry {


    private final BookCopy bookCopy;
    private final LocalDate checkoutDate;
    private LocalDate dueDate;

    CheckoutEntry(LocalDate checkoutDate, BookCopy bookCopy) {
        this.checkoutDate = checkoutDate;
        this.bookCopy = bookCopy;
    }

    void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
