package data.library_system;

import data.data_access.DataAccess;
import data.data_access.DataAccessFacade;
import domain.entities.book.*;
import domain.entities.library_member.LibraryMember;
import domain.entities.library_member.LibraryMemberFacade;
import domain.library_system.LibrarySystem;
import domain.library_system.User;
import domain.library_system.exceptions.*;
import domain.library_system.operations.auth_operations.AccessType;

import java.util.List;


public class LibrarySystemImpl extends LibrarySystem {

    private static final DataAccess dataAccess = new DataAccessFacade();



    public static void injectAsSingleton(){
        setSingleton(new LibrarySystemImpl());
    }



    private  LibrarySystemImpl(){}

    @Override
    public List<BookCopy> addBookCopy(String isbnNumber) throws BookNotFoundException {
        return  null;
    }

    @Override
    public LibraryMember addMember(
            String firstName,
            String lastName,
            String street,
            String city,
            String state,
            String zipCode,
            String phoneNumber) {

        int preferredId = 1;

        final var allMembers = dataAccess.readMemberMap();

        if(!allMembers.isEmpty()){
            final var keys = allMembers.keySet();
            for(final var key: keys){
                final var keyAsInt = Integer.parseInt(key);
                if(keyAsInt >= preferredId){
                    preferredId = keyAsInt;
                }
            }
            preferredId++;
        }

        final var newMember = LibraryMemberFacade.createLibraryMember(
                preferredId,
                firstName,
                lastName,
                street,
                city,
                 state,
                zipCode,
                phoneNumber
        );

        dataAccess.saveNewMember(
                newMember
        );

        return  newMember;
    }

    @Override
    public void checkoutBook(String memberId, String isbnNumber)
            throws MemberNotFoundException,
            BookNotFoundException,
            OutOfBookCopiesException,
            OutOfCheckoutsLimitException {

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

    @Override
    public Book addBook(
            String isbnNumber,
            String title,
            List<Author> authors,
            BookType bookType,
            int maxCheckoutLength,
            int numberOfCopies
    ) throws  BookAlreadyExistsException {
        final var allMembers = dataAccess.readBooksMap();
        final var keys = allMembers.keySet();
        for(final var key: keys){
            if(key.equals(isbnNumber)){
                throw new BookAlreadyExistsException();
            }
        }
        final var book = BookFacade.createBook(
                title,
                isbnNumber,
                bookType,
                authors,
                numberOfCopies
        );
        dataAccess.saveBook(book);

        return  book;
    }
}
