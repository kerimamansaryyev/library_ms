package domain.entities.book;

public enum BookType{
    LONG_TERM_BORROW(21),
    SHORT_TERM_BORROW(7);

    public final int borrowDaysLimit;

     BookType(int borrowDaysLimit){
        this.borrowDaysLimit = borrowDaysLimit;
    }

    @Override
    public String toString() {
        return borrowDaysLimit + " days";
    }
}
