package domain.entities.book;

import domain.entities.PersonalData;

public class Author {

    // Add the Credentials Opertion

    private String bio;
    private boolean credentials;
    private PersonalData personalData;

    public Author (String bio, boolean credentials, String firstName, String lastName, String phoneNumber) {

//        personalData = new PersonalData(firstName, lastName, phoneNumber);
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

        return personalData.getFirstName();
    }
    public String getLastName() {

        return personalData.getLastName();

    }

    public String getPhoneNumber () {

        return personalData.getPhoneNumber();
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
        return au.personalData.equals(personalData) && au.bio.equals(bio);
    }
}
