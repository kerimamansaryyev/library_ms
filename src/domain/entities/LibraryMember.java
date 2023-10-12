package domain.entities;

public class LibraryMember {
    private CheckoutRecord checkoutRecord;
    private String memberId;


    public LibraryMember(CheckoutRecord checkoutRecord, String memberId) {
        this.checkoutRecord = checkoutRecord;
        this.memberId = memberId;
    }
    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
}
