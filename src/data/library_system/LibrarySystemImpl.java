package data.library_system;

import data.data_access.DataAccess;
import data.data_access.DataAccessFacade;
import domain.library_system.LibrarySystem;
import domain.library_system.User;
import domain.library_system.exceptions.*;
import domain.library_system.operations.AccessType;


public class LibrarySystemImpl extends LibrarySystem {

    private static final DataAccess dataAccess = new DataAccessFacade();



    public static void injectAsSingleton(){
        setSingleton(new LibrarySystemImpl());
    }



    private  LibrarySystemImpl(){}

    @Override
    public void addBookCopy(String isbnNumber) throws BookNotFoundException {

    }

    @Override
    public void addMember(String firstName, String lastName, String street, String city, String state, String zipCode, String phoneNumber) {

    }

    @Override
    public void checkoutBook(String memberId, String isbnNumber) throws MemberNotFoundException, BookNotFoundException, OutOfBookCopiesException, OutOfCheckoutsLimitException {

    }

    @Override
    public User loginUser(String userName, String password, AccessType desiredAccessType)
            throws UserNotFoundException, PasswordIncorrectException {

        final var userMap = dataAccess.readUserMap();
        if(!userMap.containsKey(userName)){
            throw new UserNotFoundException();
        }

        final var foundUser = userMap.get(userName);

        if(!foundUser.isItsPassword(password)){
            throw new PasswordIncorrectException();
        }

        grantAccessForUser(foundUser, desiredAccessType);

        return  foundUser;
    }
}
