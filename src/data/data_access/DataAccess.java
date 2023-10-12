package data.data_access;



import domain.entities.LibraryMember;
import domain.library_system.User;


import java.util.HashMap;

public interface DataAccess { 
//	public HashMap<String, Book> readBooksMap();
	HashMap<String, User> readUserMap();
	HashMap<String, LibraryMember> readMemberMap();
	void saveNewMember(LibraryMember member);
}
