package data.data_access;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import domain.entities.LibraryMember;
import domain.library_system.LibrarySystem;
import domain.library_system.User;


public class DataAccessFacade implements DataAccess {

    enum StorageType {
        BOOKS, MEMBERS, USERS, STATIC_REGISTRY;
    }

    public static final String OUTPUT_DIR = System.getProperty("user.dir")
            + "/src/data/data_access/storage";

    public static final String DATE_PATTERN = "MM/dd/yyyy";

    static {
        loadUserMap(
                Arrays.asList(
                        LibrarySystem.defaultUsers
                )
        );
    }


    public void saveNewMember(LibraryMember member) {
        HashMap<String, LibraryMember> mems = readMemberMap();
        String memberId = member.getMemberId();
        mems.put(memberId, member);
        saveToStorage(StorageType.MEMBERS, mems);
    }

//    @SuppressWarnings("unchecked")
//    public  HashMap<String,Book> readBooksMap() {
//        //Returns a Map with name/value pairs being
//        //   isbn -> Book
//        return (HashMap<String,Book>) readFromStorage(StorageType.BOOKS);
//    }

    @SuppressWarnings("unchecked")
    public HashMap<String, LibraryMember> readMemberMap() {
        //Returns a Map with name/value pairs being
        //   memberId -> LibraryMember
        return (HashMap<String, LibraryMember>) readFromStorage(
                StorageType.MEMBERS);
    }


    @SuppressWarnings("unchecked")
    public HashMap<String, User> readUserMap() {
        //Returns a Map with name/value pairs being
        //   userId -> User
        return (HashMap<String, User>)readFromStorage(StorageType.USERS);
    }


    /////load methods - these place test data into the storage area
    ///// - used just once at startup


//    static void loadBookMap(List<Book> bookList) {
//        HashMap<String, Book> books = new HashMap<String, Book>();
//        bookList.forEach(book -> books.put(book.getIsbn(), book));
//        saveToStorage(StorageType.BOOKS, books);
//    }
    static void loadUserMap(List<User> userList) {
        HashMap<String, User> users = new HashMap<String, User>();
        userList.forEach(user -> users.put(user.getUserName(), user));
        saveToStorage(StorageType.USERS, users);
    }

    static void loadMemberMap(List<LibraryMember> memberList) {
        HashMap<String, LibraryMember> members = new HashMap<String, LibraryMember>();
        memberList.forEach(member -> members.put(member.getMemberId(), member));
        saveToStorage(StorageType.MEMBERS, members);
    }

    static void saveToStorage(StorageType type, Object ob) {
        ObjectOutputStream out = null;
        try {
            Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
            out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(ob);
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                try {
                    out.close();
                } catch(Exception ignored) {}
            }
        }
    }

    static Object readFromStorage(StorageType type) {
        ObjectInputStream in = null;
        Object retVal = null;
        try {
            Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
            in = new ObjectInputStream(Files.newInputStream(path));
            retVal = in.readObject();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch(Exception ignored) {}
            }
        }
        return retVal;
    }

}
