package presentation.windows.checkout_book;

import domain.entities.library_member.CheckoutEntry;
import domain.entities.library_member.CheckoutRecord;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

final class CheckoutRecordTableGenerator {

    private  static final String[][] emptyData = {};

    public  static  final String[] COLUMNS = {
            "Member",
            "ISBN",
            "Title",
            "Checkout Date",
            "Due Date",
            "Copy №"
    };

    public static  String[][] generateTableData(CheckoutRecord record, String isbnNumber){

        if(record == null){
            return emptyData;
        }

        final var entries = record.readCheckoutEntries();

        if(entries.isEmpty()){
            return emptyData;
        }

        final var filtered = new ArrayList<CheckoutEntry>();

        for(final var entry: entries){
            if(entry.getBookIsbnNumber().equals(isbnNumber)){
                filtered.add(entry);
            }

        }
        final String[][] data = new String[filtered.size()][COLUMNS.length];

        for(int i=0;i<data.length;i++){
            final var entry = filtered.get(i);
            data[i][0] = entry.getLibraryMemberFullName();
            data[i][1] = entry.getBookIsbnNumber();
            data[i][2] = entry.getBookTitle();
            data[i][3] = entry.getCheckoutDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US));
            data[i][4] = entry.getDueDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US));
            data[i][5] = Integer.toString(entry.getBookCopyNumber());
        }

        return data;

    }

}
