package domain.entities.library_member;

import domain.entities.book.BookCopy;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {


    private final BookCopy bookCopy;

    private final CheckoutRecord checkoutRecord;
    private final LocalDate checkoutDate;
    private LocalDate dueDate;

    CheckoutEntry(LocalDate checkoutDate, BookCopy bookCopy, CheckoutRecord checkoutRecord) {
        this.checkoutDate = checkoutDate;
        this.bookCopy = bookCopy;
        this.checkoutRecord = checkoutRecord;
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

    public  String getLibraryMemberId(){
        return checkoutRecord.getLibraryMember().getMemberId();
    }

    public  String getLibraryMemberName(){
        final var firstName = checkoutRecord.getLibraryMember().getFirstName();
        final var lastName = checkoutRecord.getLibraryMember().getLastName();

        return String.format("%s %s", firstName, lastName);
    }

    public String getBookTitle(){
        return  bookCopy.readBook().getTitle();

    }
    public LocalDate getDueDate() {
        return dueDate;
    }


}
