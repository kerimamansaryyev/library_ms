package domain.library_system.operations;

public enum AccessType {
    LIBRARIAN("Librarian"),
    ADMIN("Admin"),
    SUPER_ADMIN("Superadmin");

    private final String displayName;


    private AccessType(String displayName){
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
