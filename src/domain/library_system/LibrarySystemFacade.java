package domain.library_system;

import domain.entities.library_member.LibraryMember;
import domain.library_system.exceptions.PasswordIncorrectException;
import domain.library_system.exceptions.UserNotFoundException;
import domain.library_system.operations.auth_operations.AccessType;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.usecases.LoginUseCase;

public final class LibrarySystemFacade {


    public static User loginUser(String username, String password, AccessType accessType) throws UserNotFoundException, PasswordIncorrectException {
        return LoginUseCase.loginUser(LibrarySystem.getInstance(), username, password, accessType);
    }

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

    public static void logoutUser(User user){
        user.setAccess(null);
    }

}
