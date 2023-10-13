package domain.entities.library_member;

import domain.entities.Address;
import domain.entities.PersonalData;

import java.io.Serializable;

public class LibraryMember implements Serializable {


    private final CheckoutRecord checkoutRecord;

    private final String memberId;

    private PersonalData personalData;

    LibraryMember(String memberId) {
        this.memberId = memberId;
        checkoutRecord = new CheckoutRecord(this);
    }

    public String getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return personalData.getFirstName();
    }

    public String getLastName() {
        return personalData.getLastName();
    }

    public String getPhoneNumber() {
        return personalData.getPhoneNumber();
    }

    public Address getAddress() {
        return personalData.getAddress().clone();
    }

    public CheckoutRecord readCheckoutRecord(){
        return  checkoutRecord.clone();
    }
    CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }

    void setPersonalData(PersonalData personalData){
        this.personalData = personalData;
    }
}
