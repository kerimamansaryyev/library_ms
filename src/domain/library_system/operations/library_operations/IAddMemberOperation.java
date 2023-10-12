package domain.library_system.operations.library_operations;

import domain.entities.library_member.LibraryMember;

public interface IAddMemberOperation extends ILibraryOperation {
    LibraryMember addMember(
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber);
}
