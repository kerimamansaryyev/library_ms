package domain.entities.book;

import domain.entities.Address;
import domain.entities.PersonalData;

import java.io.Serializable;

public class Author implements Serializable {

    private String bio;
    private boolean credentials;



    private PersonalData personalData;

    Author (String bio, boolean credentials, PersonalData personalData) {
        setBio(bio);
        setCredentials(credentials);
        setPersonalData(personalData);
    }


    public Address getAddress() {
        return personalData.getAddress().clone();
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



    public boolean hasCredentials () {

        return credentials;
    }

    void setBio (String bio) {

        this.bio = bio;
    }

    void setCredentials(boolean credentials) {

        this.credentials = credentials;
    }


    void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Override
    public String toString() {
        return String.format("""
			(Bio: %s,First name: %s,Last name: %s,Phone number: %s,City: %s,State: %s,Street: %s,Zip code: %s,Credentials: %b),
			""",
                getBio(),
                getFirstName(),
                getLastName(),
                getPhoneNumber(),
                getAddress().getCity(),
                getAddress().getState(),
                getAddress().getStreet(),
                getAddress().getZip(),
                hasCredentials()
		 );
    }
}
