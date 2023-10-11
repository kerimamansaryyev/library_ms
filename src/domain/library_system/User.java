package domain.library_system;

import domain.library_system.user_access.Access;

public class User {
    private Access access;

    User(){}

    public void logout(){
        setAccess(null);
    }


    public <T extends Access> boolean hasAccess(){
        final var access = this.<T>tryGetAccess();

        return  access != null;
    }


    @SuppressWarnings("unchecked")
    <T extends Access> T  tryGetAccess(){

        if(access == null){
            return  null;
        }

        try {
            return  (T) access;
        } catch (Exception exc){
            return null;
        }
    }

    void setAccess(Access access){
        this.access = access;
    }
}
