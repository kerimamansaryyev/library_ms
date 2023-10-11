package domain.entities;

import java.util.Collections;
import java.util.List;

public class Book {

    private String title;
    private String isbnNumber;
    private boolean availability;
    private List<BookType> bookType;
    private List<Author> authors;


    public Book(String title, String isbnNumber, boolean availability, List<Author> authors, List <BookType> bookType) {
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.availability = availability;
        this.authors = Collections.unmodifiableList(authors);

        // Add constructor logic

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public boolean isAvailability() {
        return availability;
    }
    public List <Author> getAuthors () {

        return authors;
    }

    public List <BookType> getBookType () {
        return bookType;
    }


}
