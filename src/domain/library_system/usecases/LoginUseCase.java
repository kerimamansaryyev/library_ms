package domain.library_system.usecases;

import domain.library_system.auth.User;
import domain.library_system.exceptions.PasswordIncorrectException;
import domain.library_system.exceptions.UserNotFoundException;
import domain.library_system.operations.auth_operations.AccessType;
import domain.library_system.operations.auth_operations.ILoginOperation;

public final class LoginUseCase {


    public static User loginUser(ILoginOperation loginOperation,String userName, String password, AccessType accessType) throws UserNotFoundException, PasswordIncorrectException {
        return loginOperation.loginUser(userName, password, accessType);
    }


}
