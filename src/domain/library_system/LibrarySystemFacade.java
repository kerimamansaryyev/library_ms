package domain.library_system;

import domain.entities.library_member.LibraryMember;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.PasswordIncorrectException;
import domain.library_system.exceptions.UserNotFoundException;
import domain.library_system.operations.auth_operations.AccessType;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.usecases.AddBookCopyUseCase;
import domain.library_system.usecases.AddMemberUseCase;
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
        return AddMemberUseCase.addLibraryMember(
                addMemberOperation,
                firstName,
                lastName,
                street,
                city,
                state,
                zipCode,
                phoneNumber
        );
    }

    public static int addBookCopy(
            IAddBookCopyOperation addBookCopyOperation,
            String isbnNumber,
            int numberOfCopies
    ) throws BookNotFoundException {
        return AddBookCopyUseCase.addBookCopy(
                addBookCopyOperation,
                isbnNumber,
                numberOfCopies
        );
    }

    public static void logoutUser(User user){
        user.setAccess(null);
    }

}
