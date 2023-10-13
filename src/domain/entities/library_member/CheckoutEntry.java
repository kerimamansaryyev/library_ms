package domain.entities.library_member;

import domain.entities.book.BookCopy;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {


    private final BookCopy bookCopy;
    private final LocalDate checkoutDate;
    private LocalDate dueDate;

    CheckoutEntry(LocalDate checkoutDate, BookCopy bookCopy) {
        this.checkoutDate = checkoutDate;
        this.bookCopy = bookCopy;
        setDueDate(
                checkoutDate.plusDays(bookCopy.readBook().getBookType().borrowDaysLimit)
        );
    }

    void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public String getBookIsbnNumber(){
        return  bookCopy.readBook().getIsbnNumber();
    }

    public String getBookTitle(){
        return  bookCopy.readBook().getTitle();

    }
    public LocalDate getDueDate() {
        return dueDate;
    }
}
