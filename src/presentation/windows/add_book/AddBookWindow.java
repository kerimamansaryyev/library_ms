package presentation.windows.add_book;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.*;

import domain.entities.book.Author;
import domain.entities.book.BookType;
import domain.library_system.LibrarySystemFacade;
import domain.library_system.exceptions.BookAlreadyExistsException;
import domain.library_system.operations.library_operations.IAddBookOperation;
import presentation.navigation.AppNavigationFacade;
import presentation.navigation.AppNavigationView;
import presentation.navigation.AppNavigationWindow;
import presentation.navigation.utils.NavigationWindowListener;
import presentation.windows.add_author.AddAuthorWindow;
import presentation.windows.utils.validators.EmptyStringValidator;
import presentation.windows.utils.validators.IntegerParseValidator;

public class AddBookWindow implements AppNavigationWindow {

	private static class AuthorsListModel extends DefaultListModel<Author> implements  AddAuthorWindow.AddAuthorWindowHandler {
		public void clear(){
			this.setSize(0);
		}

		@Override
		public void onAuthorAdded(Author author) {
			addElement(author);
		}
	}

	private  final AuthorsListModel authorsListModel = new AuthorsListModel();

	private final IAddBookOperation operation;

	private AppNavigationView addAuthorNavigationView;

	private JComboBox<BookType> comboBox;

	private JFrame frame;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_2;




	public static void main(String[] args) {
		EventQueue.invokeLater(
				() -> {
					try {
						AddBookWindow window = new AddBookWindow(null);
						window.frame.setVisible(
								true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}

	public AddBookWindow(IAddBookOperation operation) {
		this.operation = operation;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(
				100,
				100,
				450,
				395);
		overrideWindowClosing();
		frame.getContentPane().setLayout(
				null);

		JLabel lblNewLabel = new JLabel("Add New Book");
		lblNewLabel.setFont(
				new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel.setBounds(
				0,
				6,
				450,
				26);
		frame.getContentPane().add(
				lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Book Title ");
		lblNewLabel_2.setBounds(
				37,
				44,
				132,
				26);
		frame.getContentPane().add(
				lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("ISBN");
		lblNewLabel_3.setBounds(
				37,
				77,
				64,
				26);
		frame.getContentPane().add(
				lblNewLabel_3);

		JLabel lblNewLabel_4_1 = new JLabel("Number of Copies ");
		lblNewLabel_4_1.setBounds(
				37,
				116,
				132,
				26);
		frame.getContentPane().add(
				lblNewLabel_4_1);

		textField_4 = new JTextField();
		textField_4.setColumns(
				10);
		textField_4.setBounds(
				181,
				44,
				178,
				29);
		frame.getContentPane().add(
				textField_4);

		JLabel lblNewLabel_1 = new JLabel("Max Checkout Days");
		lblNewLabel_1.setBounds(
				37,
				160,
				132,
				16);
		frame.getContentPane().add(
				lblNewLabel_1);

		JButton btnNewButton = new JButton("Create");

		btnNewButton.addActionListener(
				(action) -> addBook()
		);

		btnNewButton.setBounds(
				129,
				308,
				184,
				36);
		frame.getContentPane().add(
				btnNewButton);

		textField = new JTextField();
		textField.setColumns(
				10);
		textField.setBounds(
				181,
				77,
				178,
				29);
		frame.getContentPane().add(
				textField);

		textField_2 = new JTextField();
		textField_2.setColumns(
				10);
		textField_2.setBounds(
				181,
				115,
				178,
				29);
		frame.getContentPane().add(
				textField_2);

		JButton btnAddAuthor = new JButton("Add author");

		btnAddAuthor.addActionListener(
				(action) -> showAddAuthorsDialog()
		);

		btnAddAuthor.setBounds(
				57,
				197,
				105,
				39);
		frame.getContentPane().add(
				btnAddAuthor);

		comboBox = new JComboBox<>();
		comboBox.setModel(
				new DefaultComboBoxModel<>(BookType.values()));
		comboBox.setBounds(
				181,
				151,
				105,
				36);
		frame.getContentPane().add(
				comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(
				181,
				197,
				178,
				83);
		frame.getContentPane().add(
				scrollPane);

		final var list = new JList<Author>();
		list.setModel(authorsListModel);
		scrollPane.setViewportView(
				list);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(
				(action) -> authorsListModel.clear()
		);
		btnClear.setBounds(
				57,
				245,
				105,
				35);
		frame.getContentPane().add(
				btnClear);
	}

	private void showAddAuthorsDialog(){
		if(addAuthorNavigationView == null || !addAuthorNavigationView.isVisible()){
			addAuthorNavigationView = AppNavigationFacade.navigateTo(
					new AddAuthorWindow(authorsListModel), false
			);
		}
	}

	private boolean areInputsValid(){
		final String[] values = {
				textField.getText(),
				textField_2.getText(),
				textField_4.getText()
		};

		if(!new EmptyStringValidator().areValuesValid(Arrays.asList(values))){
			JOptionPane.showMessageDialog(
					frame,
					"Fill in all the inputs correctly!");
			return  false;
		}

		if(!new IntegerParseValidator().areValuesValid(Collections.singletonList(textField_2.getText()))){
			JOptionPane.showMessageDialog(
					frame,
					"Enter number of copies as numeric value!");
			return  false;
		}

		if(authorsListModel.isEmpty()){
			JOptionPane.showMessageDialog(
					frame,
					"Add at least one author!!");
			return  false;
		}

		return  true;
	}

	private void addBook(){
		if(!areInputsValid()){
			return;
		}
		final var bookTitle = textField_4.getText();
		final var isbnNumber = textField.getText();
		final var numOfCopies = Integer.parseInt(textField_2.getText());
		final BookType bookType = (BookType) comboBox.getSelectedItem();

		try {
			final var addedBook = LibrarySystemFacade.addBook(
					operation,
					isbnNumber,
					bookTitle,
					Collections.list(authorsListModel.elements()),
					numOfCopies,
					bookType
			);
			clear();

			JOptionPane.showMessageDialog(frame,String.format("""
						Book has successfully been added:
						ISBN: %s
						Title: %s
						Max checkout days: %d
						Number of copies: %d
						Number of authors: %d
						""",
						addedBook.getIsbnNumber(),
						addedBook.getTitle(),
						addedBook.getBookType().borrowDaysLimit,
						addedBook.getNumberOfCopies(),
						addedBook.getAuthors().size()
					));
		} catch (BookAlreadyExistsException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}

	}


	private void clear(){
		final JTextField[] textFields = {
				textField,
				textField_2,
				textField_4
		};

		for(final var textField: textFields){
			textField.setText("");
		}
		authorsListModel.clear();
	}


	private void popWindow(){
		if(addAuthorNavigationView != null && addAuthorNavigationView.isVisible()){
			AppNavigationFacade.goBack();
		}
		AppNavigationFacade.goBack();
	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}


	@Override
	public void overrideWindowClosing() {
		getJFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getJFrame().addWindowListener(new NavigationWindowListener(){
			@Override
			public void windowClosing(WindowEvent e) {
				popWindow();
			}
		});
	}
}
