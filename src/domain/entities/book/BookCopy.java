package domain.entities.book;

import java.io.Serializable;

public record BookCopy(Book book,int copyNumber) implements Serializable {

}
