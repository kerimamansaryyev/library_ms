package domain.library_system;

import domain.library_system.operations.library_operations.ILibraryOperation;
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


    public <T extends ILibraryOperation> boolean supportsOperation(Class<T> clazz){
        return this.tryGetOperation(clazz) != null;
    }

    @SuppressWarnings("unchecked")
   public  <T extends ILibraryOperation> T tryGetOperation(Class<T> clazz){

        if(access == null){
            return  null;
        }

        else if(clazz.isInstance(access)){
            return (T) access;
        }

        else{
            return  null;
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
