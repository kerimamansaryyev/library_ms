package domain.library_system.usecases;

import domain.entities.library_member.LibraryMember;
import domain.library_system.operations.library_operations.IAddMemberOperation;

public class AddMemberUseCase {
    public static LibraryMember addLibraryMember(
            IAddMemberOperation addMemberOperation,
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber){
        return addMemberOperation.addMember(
                firstName,
                lastName,
                street,
                city,
                state,
                zipCode,
                phoneNumber
        );
    }
}
