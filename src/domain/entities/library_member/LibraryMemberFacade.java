package domain.entities.library_member;

import domain.entities.Address;
import domain.entities.PersonalData;
import domain.entities.book.BookCopy;

import java.time.LocalDate;

public class LibraryMemberFacade {


    public static CheckoutRecord checkoutBookCopy(LibraryMember libraryMember, BookCopy copy){
        final  var checkoutRecord = libraryMember.getCheckoutRecord();
        checkoutRecord.addCheckoutEntry(copy, LocalDate.now());
        return libraryMember.readCheckoutRecord();
    }

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
