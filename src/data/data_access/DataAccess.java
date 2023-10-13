package data.data_access;



import domain.entities.book.Book;
import domain.entities.library_member.LibraryMember;
import domain.library_system.auth.User;


import java.util.HashMap;

public interface DataAccess { 
	HashMap<String, Book> readBooksMap();
	HashMap<String, User> readUserMap();
	HashMap<String, LibraryMember> readMemberMap();
	void saveNewMember(LibraryMember member);
	void saveBook(Book book);
}
