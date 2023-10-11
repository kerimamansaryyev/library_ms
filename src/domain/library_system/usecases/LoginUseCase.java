package domain.library_system.usecases;

import domain.library_system.LibrarySystem;
import domain.library_system.User;
import domain.library_system.exceptions.UserNotFoundException;
import domain.library_system.operations.AccessType;
import domain.library_system.operations.ILoginOperation;

public final class LoginUseCase {


    public static User loginUser(ILoginOperation loginOperation,String userName, String password, AccessType accessType) throws UserNotFoundException {
        return loginOperation.loginUser(userName, password, accessType);
    }


}
