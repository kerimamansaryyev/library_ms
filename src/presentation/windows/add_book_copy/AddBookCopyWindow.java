package presentation.windows.add_book_copy;

import domain.library_system.LibrarySystemFacade;
import domain.library_system.exceptions.LibrarySystemException;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import presentation.navigation.AppNavigationWindow;
import presentation.windows.utils.validators.EmptyStringValidator;
import presentation.windows.utils.validators.NumericInputValidator;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.*;

public class AddBookCopyWindow implements AppNavigationWindow {


	private  final IAddBookCopyOperation operation;
	private JFrame frame;
	private JTextField isbnTextField;
	private JTextField numberOfCopiesTextField;

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

		JLabel lblNewLabel = new JLabel("ISBN:");
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

		isbnTextField = new JTextField();
		isbnTextField.setHorizontalAlignment(
				SwingConstants.CENTER);
		isbnTextField.setBounds(
				217,
				76,
				106,
				38);
		frame.getContentPane().add(
				isbnTextField);
		isbnTextField.setColumns(
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

		numberOfCopiesTextField = new JTextField();
		numberOfCopiesTextField.setHorizontalAlignment(
				SwingConstants.CENTER);
		numberOfCopiesTextField.setBounds(
				217,
				141,
				106,
				38);
		frame.getContentPane().add(
				numberOfCopiesTextField);
		numberOfCopiesTextField.setColumns(
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

		JButton addCopyButton = new JButton("Add Copy");
		addCopyButton.addActionListener(
				(action) -> addBookCopy()
		);
		addCopyButton.setFont(
				new Font("Lucida Sans", Font.PLAIN, 15));
		addCopyButton.setBounds(
				155,
				205,
				118,
				35);
		frame.getContentPane().add(
				addCopyButton);
	}

	private boolean inputsAreValid(){
		if(!new EmptyStringValidator().areValuesValid(
				Arrays.asList(
						isbnTextField.getText(),
						numberOfCopiesTextField.getText()
				))){
			JOptionPane.showMessageDialog(frame, "Please, fill in all the fields correctly!");
			return  false;
		}
		if(!new NumericInputValidator().areValuesValid(Collections.singletonList(numberOfCopiesTextField.getText()))){
			JOptionPane.showMessageDialog(frame, "Enter a numeric value into the field of number of copies");
			return false;
		}

		final int numberOfCopies = Integer.parseInt(numberOfCopiesTextField.getText().trim());

		if(numberOfCopies <= 0){

			JOptionPane.showMessageDialog(frame, "Number of copies must be greater than 0");
			return  false;
		}

		return  true;
	}

	private void addBookCopy(){
		if(!inputsAreValid()){

			return;
		}

		final int numberOfCopies = Integer.parseInt(numberOfCopiesTextField.getText().trim());

		try {
			final var newCopiesNum = LibrarySystemFacade.addBookCopy(
					operation,
					isbnTextField.getText().trim(),
					numberOfCopies
			);
			JOptionPane.showMessageDialog(
					frame,
					"Successfully added the copy of the book. New number of copies is: " + newCopiesNum
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
