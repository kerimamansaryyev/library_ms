package domain.entities;

public class PersonData {

    private String firstName;
    private String lastNamme;
    private String phoneNumber;

    public PersonData(String firstName, String lastNamme, String phoneNumber) {
        this.firstName = firstName;
        this.lastNamme = lastNamme;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastNamme() {
        return lastNamme;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastNamme(String lastNamme) {
        this.lastNamme = lastNamme;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
