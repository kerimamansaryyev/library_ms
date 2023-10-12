package domain.entities.book;

import java.io.Serializable;
import java.util.*;

public class Book implements  Cloneable, Serializable {

    private final String isbnNumber;
    private String title;
    private BookType bookType;
    private final List<Author> authors = new ArrayList<>();
    private final Stack<BookCopy> bookCopies = new Stack<>();


    Book(String title, String isbnNumber, BookType bookType, int numOfCopies) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.bookType = bookType;
        addNewBookCopies(numOfCopies);
    }



    public String getTitle() {
        return title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public List <Author> getAuthors () {
        return List.copyOf(authors);
    }

    public BookType getBookType () {
        return bookType;
    }

    void setTitle(String title) {
        this.title = title;
    }

    void setBookType(BookType bookType) {
        this.bookType = bookType;
    }


    BookCopy takeBookCopy(){
        return bookCopies.pop();
    }


    boolean canTakeBookCopy(){
        return  bookCopies.size() > 0;
    }

    List<BookCopy> addNewBookCopies(int numberOfCopies){
        List<BookCopy> newBookCopies = new LinkedList<>();
        for(int i=0;i<numberOfCopies;i++){
            newBookCopies.add(new BookCopy(this.clone(), bookCopies.size() + i + 1));
        }
        for(final var newCopy: newBookCopies){
            bookCopies.push(newCopy);
        }

        return  new ArrayList<>(newBookCopies);
    }


    void addAuthors(List<Author> authors){
        this.authors.addAll(authors);
    }

    @Override
    public Book clone() {
        try {
            return (Book) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
