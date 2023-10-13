package domain.entities.book;

import domain.entities.Address;
import domain.entities.PersonalData;
import domain.library_system.exceptions.OutOfBookCopiesException;

import java.util.List;

public final class BookFacade {

    public static int addBookCopies(Book book,int numOfCopies){
        if(numOfCopies <= 0){
            return  0;
        }
        return book.addNewBookCopies(numOfCopies);
    }

    public static  Author createAuthor(
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
        return  new Author(
            bio,
            credentials,
            new PersonalData(
                    firstName,
                    lastName,
                    phoneNumber,
                    new Address(
                            city, state, zipCode, street
                    )
            )
        );
    }

    public static Book createBook(
            String title,
            String isbnNumber,
            BookType bookType,
            List<Author> authors,
            int numOfCopies
    ){
        final var newBook = new Book(
                title, isbnNumber, bookType, numOfCopies);
        newBook.addAuthors(authors);
        return  newBook;
    }
    public static BookCopy borrowBookCopy(Book book) throws OutOfBookCopiesException {

        final var availableBookCopy = book.getAvailableCopy();

        if(availableBookCopy == null){
            throw new OutOfBookCopiesException();
        }

        availableBookCopy.makeUnavailable();

        return  availableBookCopy;
    }
}
