package domain.library_system.auth;

import domain.library_system.operations.library_operations.ILibraryOperation;
import domain.library_system.user_access.Access;

import java.io.Serializable;

public class User implements Serializable {
    private Access access;
    private  String userName;
    private  String password;


    @SuppressWarnings("SameParameterValue")
    User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }




    @SuppressWarnings("unchecked")
   <T extends ILibraryOperation> T tryGetOperation(Class<T> clazz){

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

    boolean isItsPassword(String password){
        return  this.password.equals(password);
    }

    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
