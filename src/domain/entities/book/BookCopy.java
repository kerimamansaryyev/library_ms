package domain.entities.book;

import java.io.Serializable;

public class BookCopy implements Serializable {

    public final int copyNumber;
    private final Book book;
    private  boolean isAvailable = true;

    BookCopy(Book book, int copyNumber){
        this.book = book;
        this.copyNumber = copyNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public Book readBook(){
        return book.clone();
    }

    void makeUnavailable() {
        isAvailable = false;
    }


}
