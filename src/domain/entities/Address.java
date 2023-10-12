package domain.entities;

import java.io.Serializable;

public class Address implements  Cloneable, Serializable {
    private String city;
    private String state;
    private String zip;
    private String street;

    public Address(String city, String state, String zip, String street) {
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public Address clone() {
        try {
            return  (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
