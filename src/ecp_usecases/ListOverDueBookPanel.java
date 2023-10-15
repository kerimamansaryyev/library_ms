package ecp_usecases;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;

public class ListOverDueBookPanel extends JPanel implements IPanel{

    ControllerInterface ci = new SystemController();

    JButton submitButton;
    JButton addToCollection;
    JTextField isbnField;
    JTextField copynumber;
    JTable table;
    DefaultTableModel model; // Declare the model as a class member
    SystemController systemController = new SystemController();
    List<BookDueDate> bookDueDateList;
    JPanel topPanel = new JPanel(new BorderLayout());
    JPanel insideTopPanel;
    JPanel BottomPanel;
    JPanel lookup;
    JLabel jLabel;
    JPanel main = new JPanel(new BorderLayout());
    public ListOverDueBookPanel() {
        model = new DefaultTableModel(new Object[][]{}, new String[]{"ISBN", "Title", "Copy Number", "First Name", "Due Date"});
        defineTopPanel();
        defineTopTable();
        defineBotPanel();

        main.add(topPanel,BorderLayout.NORTH);
        main.add(BottomPanel, BorderLayout.SOUTH);
        add(main);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String isbn = isbnField.getText();
                try{
                    bookDueDateList = systemController.getListBookCopyOverdue(isbn);
                    model.setRowCount(0);

                    for (BookDueDate bookDueDate:bookDueDateList){
                        model.addRow(new Object[]{bookDueDate.getIsbn(), bookDueDate.getTitle(), bookDueDate.getCopyNum(), bookDueDate.getFirstName(), bookDueDate.getDueDate()});
                    }
                    setColumnWidths(table);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });


    }
    private void defineTopPanel(){
        submitButton = new JButton("🔍 Search");
        jLabel = new JLabel("Please enter ISBN number : ");
        isbnField = new JTextField(15);
        lookup = new JPanel(new FlowLayout());
        lookup.add(jLabel);
        lookup.add(isbnField);
        lookup.add(submitButton);
        insideTopPanel = new JPanel(new BorderLayout());
        insideTopPanel.add(lookup, BorderLayout.NORTH);
    }
    private void defineTopTable(){
        table = new JTable(model);
        setColumnWidths(table); // Set column widths
        insideTopPanel.add(new JScrollPane(table),BorderLayout.SOUTH);
        topPanel.add(insideTopPanel, BorderLayout.NORTH);
    }
    private void defineBotPanel(){
        addToCollection = new JButton("Add copy to collection");
        jLabel = new JLabel("Please enter number of copy : ");
        copynumber = new JTextField(15);
        BottomPanel = new JPanel(new FlowLayout());
//        BottomPanel.add(jLabel);
//        BottomPanel.add(copynumber);
//        BottomPanel.add(addToCollection);
    }
    private void setColumnWidths(JTable table) {
        // Set the preferred width for each column
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(250); // ISBN
        columnModel.getColumn(1).setPreferredWidth(700); // Title
        columnModel.getColumn(2).setPreferredWidth(400); // Authors
        columnModel.getColumn(3).setPreferredWidth(150); // Max Checkout Length
        columnModel.getColumn(4).setPreferredWidth(650); // Is copy available
    }

    @Override
    public void initialize() {

    }
}
