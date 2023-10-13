package domain.library_system.auth;

import domain.library_system.operations.library_operations.ILibraryOperation;
import domain.library_system.user_access.Access;

public final class AuthFacade {

    public  static  User createUser(String username, String password){
        return  new User(username, password);
    }
    public static void setAccessForUser(User user,Access access){
        user.setAccess(access);
    }

    public static  void logoutUser(User user){
        user.setAccess(null);
    }

    public static  boolean isPasswordCorrect(User user, String password){
        return  user.isItsPassword(password);
    }

    public static <T extends ILibraryOperation> T tryGetOperation(User user,Class<T> clazz){
        return user.tryGetOperation(clazz);
    }

}
