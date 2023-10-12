package domain.entities.book;

import domain.library_system.exceptions.OutOfBookCopiesException;

import java.util.List;

public final class BookFacade {

    public static List<BookCopy> addBookCopies(Book book,int numOfCopies){
        if(numOfCopies <= 0){
            return  null;
        }
        return book.addNewBookCopies(numOfCopies);
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
        if(!book.canTakeBookCopy()){
            throw new OutOfBookCopiesException();
        }
        return book.takeBookCopy();
    }
}
