package domain.entities.library_member;

import domain.entities.Address;

public class LibraryMemberFactory {

    public  static LibraryMember createLibraryMember(
            int preferredId,
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber){

        final var newMember = new LibraryMember(Integer.toString(preferredId));
        newMember.setFirstName(firstName);
        newMember.setLastName(lastName);
        newMember.setPhoneNumber(phoneNumber);
        newMember.setAddress(
                new Address(
                        city, state, zipCode, street
                )
        );

        return  newMember;
    }
}
