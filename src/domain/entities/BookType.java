package domain.entities;

import java.util.List;

public class BookType {


    private int maxCheckOutdays;

    public BookType( int maxCheckOutdays) {

        this.maxCheckOutdays = maxCheckOutdays;
    }


    public void setMaxCheckOutdays(int maxCheckOutdays) {
        this.maxCheckOutdays = maxCheckOutdays;
    }


    public int getMaxCheckOutdays() {
        return maxCheckOutdays;
    }
}
