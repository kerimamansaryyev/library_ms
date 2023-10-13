package presentation.windows.add_book_copy;

import domain.library_system.LibrarySystemFacade;
import domain.library_system.exceptions.BookNotFoundException;
import domain.library_system.exceptions.LibrarySystemException;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import presentation.navigation.AppNavigationWindow;
import presentation.windows.utils.validators.EmptyStringValidator;
import presentation.windows.utils.validators.InputValidator;
import presentation.windows.utils.validators.IntegerParseValidator;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;

public class AddBookCopyWindow implements AppNavigationWindow {


	private  final IAddBookCopyOperation operation;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(
				() -> {
					try {
						AddBookCopyWindow window = new AddBookCopyWindow((isbnNumber, num) -> 0);
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
	public AddBookCopyWindow(IAddBookCopyOperation addBookCopyOperation) {
		this.operation = addBookCopyOperation;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		overrideWindowClosing();
		frame.getContentPane().setFont(
				new Font("Lucida Grande", Font.PLAIN, 13));
		frame.setResizable(
				false);
		frame.setBounds(
				100,
				100,
				450,
				300);
		frame.setDefaultCloseOperation(
				JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(
				null);

		JLabel lblNewLabel = new JLabel("ISBN number:");
		lblNewLabel.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel.setFont(
				new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel.setBounds(
				94,
				76,
				106,
				38);
		frame.getContentPane().add(
				lblNewLabel);

		textField = new JTextField();
		textField.setHorizontalAlignment(
				SwingConstants.CENTER);
		textField.setBounds(
				217,
				76,
				106,
				38);
		frame.getContentPane().add(
				textField);
		textField.setColumns(
				10);

		JLabel lblNewLabel_1 = new JLabel("Number of Copies:");
		lblNewLabel_1.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_1.setFont(
				new Font("Lucida Grande", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(
				63,
				141,
				142,
				38);
		frame.getContentPane().add(
				lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(
				SwingConstants.CENTER);
		textField_1.setBounds(
				217,
				141,
				106,
				38);
		frame.getContentPane().add(
				textField_1);
		textField_1.setColumns(
				10);

		JLabel lblNewLabel_2 = new JLabel("Book Copy");
		lblNewLabel_2.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_2.setFont(
				new Font("Lucida Sans", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(
				153,
				6,
				133,
				40);
		frame.getContentPane().add(
				lblNewLabel_2);

		JButton btnNewButton = new JButton("Add copy");
		btnNewButton.addActionListener(
				(action) -> addBookCopy()
		);
		btnNewButton.setFont(
				new Font("Lucida Sans", Font.PLAIN, 15));
		btnNewButton.setBounds(
				155,
				205,
				118,
				35);
		frame.getContentPane().add(
				btnNewButton);
	}

	private boolean inputsAreValid(){
		return  new EmptyStringValidator().areValuesValid(
				Arrays.asList(
						textField.getText(),
						textField_1.getText()
				)
		) && new IntegerParseValidator().areValuesValid(Collections.singletonList(textField_1.getText()));
	}

	private void addBookCopy(){
		if(!inputsAreValid()){
			JOptionPane.showMessageDialog(frame, "Please, fill in all the fields correctly");
			return;
		}


		final int numberOfCopies = Integer.parseInt(textField_1.getText());

		if(numberOfCopies <= 0){
			JOptionPane.showMessageDialog(frame, "Number of copies must be greater than 0");
			return;
		}

		try {
			final var newCopiesNum = LibrarySystemFacade.addBookCopy(
					operation,
					textField.getText(),
					numberOfCopies
			);
			JOptionPane.showMessageDialog(
					frame,
					"Successfully added the copy for the book. New number of copies: " + newCopiesNum
			);
		} catch (LibrarySystemException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}
}
