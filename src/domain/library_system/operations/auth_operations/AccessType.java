package domain.library_system.operations.auth_operations;

import java.io.Serializable;

public enum AccessType implements Serializable {
    LIBRARIAN("Librarian"),
    ADMIN("Admin"),
    SUPER_ADMIN("Superadmin");

    private final String displayName;


    AccessType(String displayName){
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
