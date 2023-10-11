package domain.entities;

public class Author {

    // Add the Credentials Opertion

    private String bio;
    private boolean credentials;
    private PersonData person;

    public Author (String bio, boolean credentials, String firstName, String lastName, String phoneNumber) {

        person = new PersonData(firstName, lastName, phoneNumber);
        this.bio = bio;
        this.credentials = credentials;

    }

    public void setBio (String bio) {

        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public String getFirstName () {

        return person.getFirstName();
    }
    public String getLastName() {

        return person.getLastNamme();

    }

    public String getPhoneNumber () {

        return person.getPhoneNumber();
    }
    public void setCredentials(boolean credentials) {

        this.credentials = credentials;
    }

    public boolean isCredentials () {

        return credentials;
    }

    public boolean equals (Object ob) {

        if (ob == null) return false;
        if (getClass() != ob.getClass()) return false;

        Author au = (Author) ob;
        return au.person.equals(person) && au.bio.equals(bio);
    }
}
