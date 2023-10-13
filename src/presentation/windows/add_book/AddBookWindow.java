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
import presentation.windows.utils.validators.EmptyStringValidator;
import presentation.windows.utils.validators.IntegerParseValidator;

public class AddBookWindow implements AppNavigationWindow {

	private record AuthorEntry(Author author) {

		@Override
			public String toString() {
				return String.format("""
								(Bio: %s,First name: %s,Last name: %s,Phone number: %s,City: %s,State: %s,Street: %s,Zip code: %s,Credentials: %b),
								""",
						author.getBio(),
						author.getFirstName(),
						author.getLastName(),
						author.getPhoneNumber(),
						author.getAddress().getCity(),
						author.getAddress().getState(),
						author.getAddress().getStreet(),
						author.getAddress().getZip(),
						author.hasCredentials()
				);
			}
		}

	private static class AuthorsListModel extends DefaultListModel<AuthorEntry> implements  AddAuthorWindow.AddAuthorWindowHandler {
		public void clear(){
			this.setSize(0);
		}

		@Override
		public void onAuthorAdded(Author author) {
			addElement(new AuthorEntry(author));
		}
	}

	private  final AuthorsListModel authorsListModel = new AuthorsListModel();

	private final IAddBookOperation operation;

	private AppNavigationView addAuthorNavigationView;

	private JComboBox<BookType> bookTypeComboBox;

	private JFrame frame;
	private JTextField bookTitleTextField;
	private JTextField isbnNumberTextField;
	private JTextField numOfCopiesTextField;




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

		bookTitleTextField = new JTextField();
		bookTitleTextField.setColumns(
				10);
		bookTitleTextField.setBounds(
				181,
				44,
				178,
				29);
		frame.getContentPane().add(
				bookTitleTextField);

		JLabel lblNewLabel_1 = new JLabel("Max Checkout Days");
		lblNewLabel_1.setBounds(
				37,
				160,
				132,
				16);
		frame.getContentPane().add(
				lblNewLabel_1);

		JButton createButton = new JButton("Create");

		createButton.addActionListener(
				(action) -> addBook()
		);

		createButton.setBounds(
				129,
				308,
				184,
				36);
		frame.getContentPane().add(
				createButton);

		isbnNumberTextField = new JTextField();
		isbnNumberTextField.setColumns(
				10);
		isbnNumberTextField.setBounds(
				181,
				77,
				178,
				29);
		frame.getContentPane().add(
				isbnNumberTextField);

		numOfCopiesTextField = new JTextField();
		numOfCopiesTextField.setColumns(
				10);
		numOfCopiesTextField.setBounds(
				181,
				115,
				178,
				29);
		frame.getContentPane().add(
				numOfCopiesTextField);

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

		bookTypeComboBox = new JComboBox<>();
		bookTypeComboBox.setModel(
				new DefaultComboBoxModel<>(BookType.values()));
		bookTypeComboBox.setBounds(
				181,
				151,
				105,
				36);
		frame.getContentPane().add(
				bookTypeComboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(
				181,
				197,
				178,
				83);
		frame.getContentPane().add(
				scrollPane);

		final var list = new JList<AuthorEntry>();
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
		frame.setResizable(false);
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
				isbnNumberTextField.getText(),
				numOfCopiesTextField.getText(),
				bookTitleTextField.getText()
		};

		if(!new EmptyStringValidator().areValuesValid(Arrays.asList(values))){
			JOptionPane.showMessageDialog(
					frame,
					"Fill in all the inputs correctly!");
			return  false;
		}

		if(!new IntegerParseValidator().areValuesValid(Collections.singletonList(numOfCopiesTextField.getText()))){
			JOptionPane.showMessageDialog(
					frame,
					"Enter number of copies as numeric value!");
			return  false;
		}

		final int numberOfCopies = Integer.parseInt(numOfCopiesTextField.getText());

		if(numberOfCopies <= 0){

			JOptionPane.showMessageDialog(frame, "Number of copies must be greater than 0");
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
		final var bookTitle = bookTitleTextField.getText();
		final var isbnNumber = isbnNumberTextField.getText();
		final var numOfCopies = Integer.parseInt(numOfCopiesTextField.getText());
		final BookType bookType = (BookType) bookTypeComboBox.getSelectedItem();

		final List<Author> authors = new ArrayList<>(authorsListModel.size());

		for(final var entry: Collections.list(authorsListModel.elements())){
			authors.add(entry.author);
		}

		try {
			final var addedBook = LibrarySystemFacade.addBook(
					operation,
					isbnNumber,
					bookTitle,
					authors,
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
				isbnNumberTextField,
				numOfCopiesTextField,
				bookTitleTextField
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
