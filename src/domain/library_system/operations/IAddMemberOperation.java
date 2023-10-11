package domain.library_system.operations;

public interface IAddMemberOperation {
    void addMember(
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber);
}
