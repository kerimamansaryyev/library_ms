package domain.library_system.operations.auth_operations;

import domain.library_system.User;
import domain.library_system.exceptions.PasswordIncorrectException;
import domain.library_system.exceptions.UserNotFoundException;

public interface ILoginOperation {
    User loginUser(String userName, String password, AccessType desiredAccessType)
            throws UserNotFoundException, PasswordIncorrectException;
}
