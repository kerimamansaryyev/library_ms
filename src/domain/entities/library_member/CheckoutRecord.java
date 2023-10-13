package domain.entities.library_member;

import domain.entities.book.BookCopy;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements  Cloneable, Serializable {
    private final List<CheckoutEntry> checkoutEntries;

    CheckoutRecord (){
        this.checkoutEntries = new ArrayList<>();
    }

    List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }

    void addCheckoutEntry(BookCopy copy, LocalDate checkoutDate){
        checkoutEntries.add(
                new CheckoutEntry(
                        checkoutDate,
                        copy
                )
        );
    }
    public List<CheckoutEntry> readCheckoutEntries() {
        return List.copyOf(getCheckoutEntries());
    }

    @Override
    public CheckoutRecord clone() {
        try {
            return (CheckoutRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
