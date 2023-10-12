package domain.entities.library_member;

import domain.entities.Address;
import domain.entities.PersonalData;

import java.io.Serializable;
import java.util.List;

public class LibraryMember implements Serializable {


    private final CheckoutRecord checkoutRecord;

    private final String memberId;

    private PersonalData personalData;

    LibraryMember(String memberId) {
        this.memberId = memberId;
        checkoutRecord = new CheckoutRecord();
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
        return personalData.getAddress();
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return checkoutRecord.getCheckoutEntries();
    }

    void setFirstName(String firstName) {
        personalData.setFirstName(firstName);
    }

    void setLastName(String lastName) {
        personalData.setLastName(lastName);
    }

    void setPhoneNumber(String phoneNumber) {
        personalData.setPhoneNumber(phoneNumber);
    }

    void setAddress(Address address) {
        personalData.setAddress(address);
    }

    void setPersonalData(PersonalData personalData){
        this.personalData = personalData;
    }





}
