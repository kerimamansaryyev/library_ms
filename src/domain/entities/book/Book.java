package domain.entities.book;

import java.io.Serializable;
import java.util.*;

@SuppressWarnings({"FieldMayBeFinal", "CanBeFinal"})
public class Book implements  Cloneable, Serializable {

    private final String isbnNumber;
    private String title;
    private BookType bookType;
    private final List<Author> authors = new ArrayList<>();
    private final List<BookCopy> bookCopies = new ArrayList<>();


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

    public boolean isAvailable(){
        return getAvailableCopy() != null;
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
        int preferredCopyNumber = 0;
        for(var i=0;i<bookCopies.size();i++){
            if(i>=preferredCopyNumber){
                preferredCopyNumber = bookCopies.get(i).copyNumber;
            }
        }

        for(int i=0;i<numberOfCopies;i++){
            bookCopies.add(new BookCopy(this,++preferredCopyNumber));
        }

        return  bookCopies.size();
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
