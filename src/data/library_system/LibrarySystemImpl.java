package data.library_system;

import data.data_access.DataAccess;
import data.data_access.DataAccessFacade;
import domain.entities.book.*;
import domain.entities.library_member.CheckoutRecord;
import domain.entities.library_member.LibraryMember;
import domain.entities.library_member.LibraryMemberFacade;
import domain.library_system.LibrarySystem;
import domain.library_system.auth.AuthFacade;
import domain.library_system.auth.User;
import domain.library_system.exceptions.*;
import domain.library_system.operations.auth_operations.AccessType;

import java.util.List;


public class LibrarySystemImpl extends LibrarySystem {

    private static final DataAccess dataAccess = new DataAccessFacade();



    public static void injectAsSingleton(){
        setSingleton(new LibrarySystemImpl());
    }


    private Book findBook(String isbnNumber) {
        final var allMembers = dataAccess.readBooksMap();
        return  allMembers.get(isbnNumber);
    }

    private LibraryMember findMember(String memberID) {
        final var allMembers = dataAccess.readMemberMap();
        return  allMembers.get(memberID);
    }



    private  LibrarySystemImpl(){}

    @Override
    public int addBookCopy(String isbnNumber, int numOfCopies) throws BookNotFoundException {
        final var book = findBook(isbnNumber);
        if(book == null){
            throw  new BookNotFoundException();
        }
        final int newListOfCopies = BookFacade.addBookCopies(book, numOfCopies);
        dataAccess.saveBook(book);
        return  newListOfCopies;
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
    public CheckoutRecord checkoutBook(String memberId, String isbnNumber)
            throws MemberNotFoundException,
            BookNotFoundException,
            OutOfBookCopiesException{
        final var member = findMember(memberId);
        if(member == null){
            throw new MemberNotFoundException();
        }
        final var book = findBook(isbnNumber);
        if(book == null){
            throw new BookNotFoundException();
        }

        final var bookCopy = BookFacade.borrowBookCopy(book);

        final var checkoutRecord = LibraryMemberFacade.checkoutBookCopy(member, bookCopy);

        dataAccess.saveNewMember(member);
        dataAccess.saveBook(book);

        return checkoutRecord;
    }

    @Override
    public User loginUser(String userName, String password, AccessType desiredAccessType)
            throws UserNotFoundException, PasswordIncorrectException {

        final var userMap = dataAccess.readUserMap();
        if(!userMap.containsKey(userName)){
            throw new UserNotFoundException();
        }

        final var foundUser = userMap.get(userName);

        if(!AuthFacade.isPasswordCorrect(foundUser, password)){
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
            int numberOfCopies
    ) throws  BookAlreadyExistsException {

        if(findBook(isbnNumber) != null){
            throw new BookAlreadyExistsException();
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
