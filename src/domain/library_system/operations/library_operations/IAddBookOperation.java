package domain.library_system.operations.library_operations;

public interface IAddBookOperation extends  ILibraryOperation{

    void addBook(
            String isbnNumber,
            String title,
            String authors,
            int maxCheckoutLength,
            int numberOfCopies
    );
}
