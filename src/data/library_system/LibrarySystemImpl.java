package data.library_system;

import domain.library_system.LibrarySystem;
import domain.library_system.User;
import domain.library_system.exceptions.*;
import domain.library_system.operations.AccessType;

public class LibrarySystemImpl extends LibrarySystem {

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
    public User loginUser(String userName, String password, AccessType desiredAccessType) throws UserNotFoundException {
        throw new UserNotFoundException();
    }
}
