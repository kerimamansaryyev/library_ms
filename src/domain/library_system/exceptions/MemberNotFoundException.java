package domain.library_system.exceptions;

public class MemberNotFoundException extends  LibrarySystemException{

    private static final String displayableMessage = "Sorry, couldn't the member";

    public MemberNotFoundException() {
        super(displayableMessage);
    }
}
