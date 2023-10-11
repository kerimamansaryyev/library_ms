package domain.library_system.exceptions;

public class UserNotFoundException extends LibrarySystemException{

    private static final String displayableMessage = "Sorry, either the username or the password is incorrect";
    public UserNotFoundException() {
        super(displayableMessage);
    }
}
