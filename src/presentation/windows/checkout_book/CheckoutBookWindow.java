package presentation.windows.checkout_book;

import domain.entities.library_member.CheckoutRecord;
import domain.entities.library_member.LibraryMemberFacade;
import domain.library_system.LibrarySystemFacade;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.LibrarySystemException;
import domain.library_system.exceptions.MemberNotFoundException;
import domain.library_system.exceptions.OutOfBookCopiesException;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;
import presentation.navigation.AppNavigationWindow;
import presentation.windows.utils.validators.EmptyStringValidator;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CheckoutBookWindow implements AppNavigationWindow {

	private final ICheckoutBookOperation operation;
	private JFrame frame;
	private JTextField memberIdTextField;
	private JTextField isbnTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(
				() -> {
					try {
						CheckoutBookWindow window = new CheckoutBookWindow(null);
						window.frame.setVisible(
								true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}

	/**
	 * Create the application.
	 */
	public CheckoutBookWindow(ICheckoutBookOperation operation) {
		this.operation = operation;
		initialize();
		initializeTable();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(
				100,
				100,
				450,
				452);
		overrideWindowClosing();
		frame.getContentPane().setLayout(
				null);

		JLabel lblNewLabel = new JLabel("Checkout book");
		lblNewLabel.setFont(
				new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel.setBounds(
				120,
				6,
				193,
				16);
		frame.getContentPane().add(
				lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Member ID");
		lblNewLabel_1.setBounds(
				78,
				74,
				91,
				35);
		frame.getContentPane().add(
				lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("ISBN No");
		lblNewLabel_1_1.setBounds(
				78,
				121,
				91,
				35);
		frame.getContentPane().add(
				lblNewLabel_1_1);

		memberIdTextField = new JTextField();
		memberIdTextField.setBounds(
				176,
				74,
				163,
				35);
		frame.getContentPane().add(
				memberIdTextField);
		memberIdTextField.setColumns(
				10);

		isbnTextField = new JTextField();
		isbnTextField.setColumns(
				10);
		isbnTextField.setBounds(
				176,
				121,
				163,
				35);
		frame.getContentPane().add(
				isbnTextField);

		JButton checkoutButton = new JButton("Checkout");
		checkoutButton.setBounds(
				154,
				168,
				114,
				35);

		checkoutButton.addActionListener(
				(action) -> checkoutBook()
		);

		frame.getContentPane().add(
				checkoutButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(
				16,
				253,
				417,
				154);
		frame.getContentPane().add(
				scrollPane);

		table = new JTable();
		scrollPane.setViewportView(
				table);
		frame.setResizable(false);
	}


	private boolean areInputsValid(){
		if(!new EmptyStringValidator().areValuesValid(Arrays.asList(
				isbnTextField.getText(),
				memberIdTextField.getText()
		))){
			JOptionPane.showMessageDialog(
					frame,
					"Fill in all the fields correctly!"
			);
			return false;
		}
		return  true;
	}

	private void checkoutBook(){
		if(!areInputsValid()){
			return;
		}
		try {
			final var memberId = memberIdTextField.getText();
			final var isbn = isbnTextField.getText();
			final var checkoutRecord = LibrarySystemFacade.checkoutBook(
				operation, memberId, isbn
			);
			setTableModel(checkoutRecord, isbn);
		} catch (LibrarySystemException e) {
			JOptionPane.showMessageDialog(frame,e.getMessage());
		}
	}
	private void setTableModel(CheckoutRecord record, String filterByIsbnNumber){
		table.setModel(
				new DefaultTableModel(
						CheckoutRecordTableGenerator.generateTableData(record, filterByIsbnNumber),
						CheckoutRecordTableGenerator.COLUMNS
				)
		);
	}

	private void initializeTable(){
		setTableModel(null, null);
		table.setEnabled(false);
	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}
}