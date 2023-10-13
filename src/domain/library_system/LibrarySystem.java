package domain.library_system;

import domain.library_system.operations.auth_operations.AccessType;
import domain.library_system.operations.auth_operations.ILoginOperation;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;
import domain.library_system.user_access.Access;

public abstract class LibrarySystem implements
        ILoginOperation,
        ICheckoutBookOperation,
        IAddBookCopyOperation,
        IAddMemberOperation, IAddBookOperation {



    private static LibrarySystem singleton;

    protected static void setSingleton(LibrarySystem librarySystem){
        singleton = librarySystem;
    }

    public static final User[] defaultUsers = {
            new User("Kerim", "hello"),
            new User("James", "hello"),
            new User("Ivan", "hello")
    };

    static LibrarySystem getInstance(){
        return  singleton;
    }


    protected void grantAccessForUser(User user, AccessType accessType){

        if(accessType == null){
            return;
        }

        user.setAccess(
                switch (accessType){

                    case LIBRARIAN -> Access.createLibrarianAccess(this);
                    case ADMIN -> Access.createAdministratorAccess(this);
                    case SUPER_ADMIN -> Access.createSuperAdminAccess(this);

                }
        );
    }

}
