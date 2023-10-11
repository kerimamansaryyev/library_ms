package domain.library_system;

import domain.library_system.operations.*;
import domain.library_system.user_access.Access;

public abstract class LibrarySystem implements
        ILoginOperation,
        ICheckoutBookOperation,
        IAddBookCopyOperation,
        IAddMemberOperation {


    private static LibrarySystem singleton;

    protected static void setSingleton(LibrarySystem librarySystem){
        singleton = librarySystem;
    }

    static LibrarySystem getInstance(){
        return  singleton;
    }


    protected void grantAccessForUser(User user, AccessType accessType){

        if(accessType == null){
            user.setAccess(null);
        }

        assert accessType != null;

        user.setAccess(
                switch (accessType){

                    case LIBRARIAN -> Access.createLibrarianAccess(this);
                    case ADMIN -> Access.createAdministratorAccess(this);
                    case SUPER_ADMIN -> Access.createSuperAdminAccess(this);

                }
        );
    }

}
