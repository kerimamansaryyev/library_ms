package domain.library_system.exceptions;

public class MemberNotFoundException extends  LibrarySystemException{

    private static final String displayableMessage = "Sorry, couldn't find the member";

    public MemberNotFoundException() {
        super(displayableMessage);
    }
}
