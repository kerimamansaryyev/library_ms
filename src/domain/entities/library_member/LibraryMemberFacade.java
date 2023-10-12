package domain.entities.library_member;

import domain.entities.Address;
import domain.entities.PersonalData;

public class LibraryMemberFacade {

    public static LibraryMember createLibraryMember(
            int preferredId,
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber){

        final var newMember = new LibraryMember(Integer.toString(preferredId));
        newMember.setPersonalData(
                new PersonalData(
                        firstName,
                        lastName,
                        phoneNumber,
                        new Address(
                                city, state, zipCode, street
                        )
                )
        );

        return  newMember;
    }
}
