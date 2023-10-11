package domain.entities;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
    private LibraryMember libraryMember;
    private List<CheckoutEntry> checkoutEntries;

    public CheckoutRecord (LibraryMember libraryMember){

        this.libraryMember = libraryMember;
        this.checkoutEntries = new ArrayList<>();
    }
    public LibraryMember getLibraryMember() {
        return libraryMember;
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutEntries;
    }

    public void addEntry(CheckoutEntry checkoutEntry){
        if(checkoutEntries == null){
            checkoutEntries.add(checkoutEntry);
        }
    }
}
