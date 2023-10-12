package domain.entities;

public class PersonalData {

    private String firstName;
    private String lastName;
    private String phoneNumber;

    public PersonalData(String firstName, String lastNamme, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastNamme;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastNamme() {
        return lastName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastNamme(String lastNamme) {
        this.lastName = lastNamme;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
