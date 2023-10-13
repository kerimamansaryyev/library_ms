package domain.entities.book;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings({"FieldMayBeFinal", "CanBeFinal"})
public class Book implements  Cloneable, Serializable {

    private final String isbnNumber;
    private String title;
    private BookType bookType;
    private final List<Author> authors = new ArrayList<>();
    private final HashSet<BookCopy> bookCopies = new HashSet<>();


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

    public  int getNumberOfCopies(){
        return  bookCopies.size();
    }

    BookCopy getAvailableCopy(){
        for(final var copy:bookCopies){
            if(copy.isAvailable()){
                return  copy;
            }
        }
        return  null;
    }


    int addNewBookCopies(int numberOfCopies){
        for(int i=0;i<numberOfCopies;i++){
            bookCopies.add(new BookCopy(this, bookCopies.size() + i + 1));
        }
        return bookCopies.size();
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
