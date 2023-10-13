package domain.library_system;

import domain.entities.book.*;
import domain.entities.library_member.CheckoutRecord;
import domain.entities.library_member.LibraryMember;
import domain.library_system.auth.AuthFacade;
import domain.library_system.auth.User;
import domain.library_system.exceptions.*;
import domain.library_system.operations.auth_operations.AccessType;
import domain.library_system.operations.library_operations.*;
import domain.library_system.usecases.*;

import java.util.List;

public final class LibrarySystemFacade {

    public static User loginUser(String username, String password, AccessType accessType) throws UserNotFoundException, PasswordIncorrectException {
        return LoginUseCase.loginUser(LibrarySystem.getInstance(), username, password, accessType);
    }

    public static CheckoutRecord checkoutBook(
            ICheckoutBookOperation checkoutBookOperation,
            String memberId,
            String isbnNumber
    ) throws OutOfBookCopiesException, BookNotFoundException, MemberNotFoundException {
        return CheckoutBookUseCase.checkoutBook(checkoutBookOperation,memberId,isbnNumber);
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


    public  static Author addBookAuthor(
            String bio,
            boolean credentials,
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber
    ){
        return BookFacade.createAuthor(
                bio,
                credentials,
                firstName,
                lastName,
                street,
                city,
                state,
                zipCode,
                phoneNumber
        );
    }

    public static Book addBook(
            IAddBookOperation addBookOperation,
            String isbnNumber,
            String title,
            List<Author> authors,
            int numberOfCopies,
            BookType bookType

    ) throws BookAlreadyExistsException {
       return AddBookUseCase.addBook(
                addBookOperation,
                isbnNumber,
                title,
                authors,
                numberOfCopies,
                bookType
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
        AuthFacade.logoutUser(user);
    }

    public static <T extends ILibraryOperation> T tryGetOperationForUser(User user, Class<T> clazz){
        return AuthFacade.tryGetOperation(user,clazz);
    }

    public static <T extends ILibraryOperation> boolean isOperationSupportedForUser(User user,Class<T> clazz){
        return tryGetOperationForUser(user,clazz) != null;
    }

}
