package ecp_usecases;


import presentation.navigation.AppNavigationWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;




public class ListCheckOutRecordEntry implements AppNavigationWindow {
    

    ControllerInterface ci = new SystemController();

    public JButton submitButton;
    JTextField memberIDField;

    public static  DefaultTableModel model =new DefaultTableModel(new Object[][]{}, new String[]{"Book Copy" , "Due Date" ,"First Name", "Last Name","Member ID"});
    SystemController systemController = new SystemController();
    List<CheckOutRecordAllMember> checkoutRecordEntries;
    public static  JTable table = new JTable(model);
    public static JScrollPane scrollPane = new JScrollPane(table);
    public void ListCheckOutRecordEntryPanel() {

        submitButton = new JButton("🔍 Search");
        JLabel jLabel = new JLabel("Please enter MemberID : ");
        memberIDField = new JTextField(15);
        JPanel lookup = new JPanel(new FlowLayout());
        lookup.add(jLabel);
        lookup.add(memberIDField);
        lookup.add(submitButton);
        add(lookup);

        getListCheckOutRecord();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    checkoutRecordEntries = systemController.getCheckOutRecordEntry(memberIDField.getText());
                    model.setRowCount(0);
                    for (CheckOutRecordAllMember checkoutRecordEntry:checkoutRecordEntries){
                        model.addRow(new Object[]{
                                checkoutRecordEntry.getBookCopy().getBook().getTitle(),
                                checkoutRecordEntry.getDueDate(),
                                checkoutRecordEntry.getLibraryMember().getFirstName(),
                                checkoutRecordEntry.getLibraryMember().getLastName(),
                                checkoutRecordEntry.getLibraryMember().getMemberId()
                        });
                    }
                    setColumnWidths(table);
                }catch (NullPointerException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    private void getListCheckOutRecord(){
        checkoutRecordEntries = systemController.getCheckOutRecordEntryAllMembers();
        model.setRowCount(0);
        for (CheckOutRecordAllMember checkoutRecordEntry:checkoutRecordEntries){
            model.addRow(new Object[]{
                    checkoutRecordEntry.getBookCopy().getBook().getTitle(),
                    checkoutRecordEntry.getDueDate(),
                    checkoutRecordEntry.getLibraryMember().getFirstName(),
                    checkoutRecordEntry.getLibraryMember().getLastName(),
                    checkoutRecordEntry.getLibraryMember().getMemberId()
            });
        }




        add(scrollPane);
        setColumnWidths(table);

    }

    private void setColumnWidths(JTable table) {
        // Set the preferred width for each column
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(750); // Book Copy
        columnModel.getColumn(1).setPreferredWidth(500); // Due Date
        columnModel.getColumn(2).setPreferredWidth(300); // First Name
        columnModel.getColumn(3).setPreferredWidth(300); // Last Name
        columnModel.getColumn(4).setPreferredWidth(300); // Member ID
    }

    @Override
    public void initialize() {
        getListCheckOutRecord();
    }
}
