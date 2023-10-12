package domain.library_system.operations.library_operations;

public interface IAddMemberOperation extends ILibraryOperation {
    void addMember(
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber);
}
