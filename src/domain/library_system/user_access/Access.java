package domain.library_system.user_access;

import domain.library_system.LibrarySystem;

public abstract class Access {
    protected final LibrarySystem system;

    protected Access(LibrarySystem system){
        this.system = system;
    }

    public static LibrarianAccess createLibrarianAccess(LibrarySystem system){
        return  new LibrarianAccess(system);
    }

    public static  AdministratorAccess createAdministratorAccess(LibrarySystem system){
        return  new AdministratorAccess(system);
    }

    public static  SuperAdminAccess createSuperAdminAccess(LibrarySystem system){
        return  new SuperAdminAccess(system);
    }

}
