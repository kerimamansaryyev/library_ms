package domain.entities;

public class PersonalData implements  Cloneable {

    private String firstName;
    private String lastName;
    private String phoneNumber;


    private Address address;

    public PersonalData(String firstName, String lastName, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public PersonalData clone() {
        try {
            return (PersonalData) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
