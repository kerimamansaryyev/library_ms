package domain.library_system.exceptions;

public class PasswordIncorrectException extends  LibrarySystemException{

    private static final String displayableMessage = "Your password is incorrect";
    public PasswordIncorrectException() {
        super(displayableMessage);
    }
}
