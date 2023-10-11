package domain.entities;

import java.util.List;

public class BookType {

    private List <Book> bookType;
    private int maxCheckOutdays;

    public BookType(List<Book> bookType, int maxCheckOutdays) {
        this.bookType = bookType;
        this.maxCheckOutdays = maxCheckOutdays;
    }

    public void setBookType(List<Book> bookType) {
        this.bookType = bookType;
    }

    public void setMaxCheckOutdays(int maxCheckOutdays) {
        this.maxCheckOutdays = maxCheckOutdays;
    }

    public List<Book> getBookType() {
        return bookType;
    }

    public int getMaxCheckOutdays() {
        return maxCheckOutdays;
    }
}
