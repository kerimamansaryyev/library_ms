package domain.entities;

import java.time.LocalDate;

public class CheckoutEntry {
    private BookCopy bookCopy;
    private LocalDate checkoutDate;
    private LocalDate dueDate;

    public CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, BookCopy bookCopy) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.bookCopy = bookCopy;
    }
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}
