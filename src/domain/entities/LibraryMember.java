package domain.entities;

public class LibraryMember {
    CheckoutRecord checkoutRecord;

    public LibraryMember(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }
    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }
}
