package domain.library_system;

import domain.library_system.user_access.Access;

import java.io.Serializable;

public class User implements Serializable {
    private Access access;
    private  String userName;
    private  String password;


    User(String userName, String password){
        this.userName = userName;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public boolean isItsPassword(String password){
        return  this.password.equals(password);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
