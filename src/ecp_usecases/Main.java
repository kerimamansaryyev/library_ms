package ecp_usecases;

import domain.entities.library_member.CheckoutRecord;
import domain.entities.library_member.LibraryMember;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    //// Method for Extra credit 3
    public List<BookDueDate> getListBookCopyOverdue(String isbn){
        SystemController systemController = new SystemController();
        List<LibraryMember> memberList = systemController.allMembers();

        List<BookDueDate> bookDueDates = new ArrayList<>();
        List<Book> bookList = systemController.allBooks();
        if(!bookList.contains(systemController.getBookById(isbn))){
            throw new NullPointerException("Book is not available");
        }

        for (LibraryMember member:memberList){
            if (member.getRecord()==null){
                continue;
            }
            CheckoutRecord checkoutRecords = member.getRecord();

            List<CheckoutRecordEntry> checkoutRecordEntries = checkoutRecords.getCheckoutRecordEntries();


            for (CheckoutRecordEntry entry:checkoutRecordEntries) {
                if (entry.getDueDate().isBefore(LocalDate.now())) {
                    Book book = entry.getBookCopy().getBook();
                    if (book.getIsbn().equals(isbn)) {
                        BookDueDate bookDueDate = new BookDueDate(entry.getBookCopy().getBook().getIsbn(),
                                entry.getBookCopy().getBook().getTitle(),
                                entry.getBookCopy().getCopyNum(),
                                member.getFirstName(),
                                entry.getDueDate().toString());

                        bookDueDates.add(bookDueDate);

                    }

                }
            }
        }

        return  bookDueDates;
    }

    //// Method for Extra credit 2
    public List<CheckOutRecordAllMember>  getCheckOutRecordEntry(String memberId){
        List<CheckOutRecordAllMember>  entries = new ArrayList<CheckOutRecordAllMember>();
        SystemController systemController = new SystemController();
        List<LibraryMember> memberList = systemController.allMembers();

        boolean isMember = false;
        for (LibraryMember member: memberList) {
            if (member.getMemberId().equals(memberId)) {
                isMember = true;
                continue;
            }
        }
        if (!isMember) {
            throw new NullPointerException("Member is not available");
        }

        for (LibraryMember member:memberList){
            if (member.getRecord()==null){
                continue;
            }
            if (member.getMemberId().equals(memberId)){
                List<CheckoutRecordEntry> entry = member.getRecord().getCheckoutRecordEntries();
                for (CheckoutRecordEntry checkoutRecordEntry: entry){
                    entries.add(new CheckOutRecordAllMember(member, checkoutRecordEntry.getBookCopy(),checkoutRecordEntry.getDueDate()));
                }
            }
        }
        return entries;
    }


}