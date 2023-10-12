package domain.library_system;

import domain.library_system.exceptions.PasswordIncorrectException;
import domain.library_system.exceptions.UserNotFoundException;
import domain.library_system.operations.AccessType;
import domain.library_system.usecases.LoginUseCase;

public final class UseCaseFactory {


    public static User loginUser(String username, String password, AccessType accessType) throws UserNotFoundException, PasswordIncorrectException {
        return LoginUseCase.loginUser(LibrarySystem.getInstance(), username, password, accessType);
    }

    public static void logoutUser(User user){
        user.setAccess(null);
    }

}
