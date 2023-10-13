package presentation.windows.add_author;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.*;

import domain.entities.book.Author;
import domain.library_system.LibrarySystemFacade;
import presentation.navigation.AppNavigationWindow;
import presentation.windows.utils.validators.EmptyStringValidator;

public class AddAuthorWindow implements AppNavigationWindow {

	public interface AddAuthorWindowHandler{
		void onAuthorAdded(Author author);
	}

	private  final AddAuthorWindowHandler handler;

	private JFrame frame;

	private JCheckBox credentialsCheckBox;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField streetTextField;
	private JTextField zipCodeTextField;
	private JTextField bioTextField;

	public static void main(String[] args) {
		EventQueue.invokeLater(
				() -> {
					try {
						AddAuthorWindow window = new AddAuthorWindow(null);
						window.frame.setVisible(
								true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}

	public AddAuthorWindow(AddAuthorWindowHandler handler) {
		this.handler = handler;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		overrideWindowClosing();
		frame.setBounds(
				100,
				100,
				433,
				572);
		frame.getContentPane().setLayout(
				null);

		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(
				160,
				64,
				163,
				26);
		frame.getContentPane().add(
				firstNameTextField);
		firstNameTextField.setColumns(
				10);

		JLabel lblNewLabel = new JLabel("First name:");
		lblNewLabel.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel.setBounds(
				55,
				69,
				93,
				16);
		frame.getContentPane().add(
				lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Personal Info");
		lblNewLabel_1.setFont(
				new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_1.setBounds(
				152,
				19,
				110,
				33);
		frame.getContentPane().add(
				lblNewLabel_1);

		lastNameTextField = new JTextField();
		lastNameTextField.setBounds(
				160,
				102,
				163,
				26);
		frame.getContentPane().add(
				lastNameTextField);
		lastNameTextField.setColumns(
				10);

		phoneNumberTextField = new JTextField();
		phoneNumberTextField.setColumns(
				10);
		phoneNumberTextField.setBounds(
				160,
				140,
				163,
				26);
		frame.getContentPane().add(
				phoneNumberTextField);

		JLabel lblNewLabel_2 = new JLabel("Last name:");
		lblNewLabel_2.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_2.setBounds(
				65,
				107,
				83,
				16);
		frame.getContentPane().add(
				lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Phone Number:");
		lblNewLabel_3.setBounds(
				55,
				145,
				100,
				16);
		frame.getContentPane().add(
				lblNewLabel_3);

		JLabel lblNewLabel_1_1 = new JLabel("Address Info");
		lblNewLabel_1_1.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(
				new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(
				152,
				276,
				110,
				33);
		frame.getContentPane().add(
				lblNewLabel_1_1);

		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblCity.setBounds(
				65,
				326,
				93,
				16);
		frame.getContentPane().add(
				lblCity);

		cityTextField = new JTextField();
		cityTextField.setColumns(
				10);
		cityTextField.setBounds(
				160,
				321,
				163,
				26);
		frame.getContentPane().add(
				cityTextField);

		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblState.setBounds(
				65,
				364,
				93,
				16);
		frame.getContentPane().add(
				lblState);

		stateTextField = new JTextField();
		stateTextField.setColumns(
				10);
		stateTextField.setBounds(
				160,
				359,
				163,
				26);
		frame.getContentPane().add(
				stateTextField);

		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblStreet.setBounds(
				65,
				402,
				93,
				16);
		frame.getContentPane().add(
				lblStreet);

		streetTextField = new JTextField();
		streetTextField.setColumns(
				10);
		streetTextField.setBounds(
				160,
				397,
				163,
				26);
		frame.getContentPane().add(
				streetTextField);

		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblZipCode.setBounds(
				65,
				435,
				93,
				16);
		frame.getContentPane().add(
				lblZipCode);

		zipCodeTextField = new JTextField();
		zipCodeTextField.setColumns(
				10);
		zipCodeTextField.setBounds(
				160,
				430,
				163,
				26);
		frame.getContentPane().add(
				zipCodeTextField);

		JButton addAuthorButton = new JButton("Add Author");
		addAuthorButton.setBounds(
				139,
				484,
				138,
				38);
		addAuthorButton.addActionListener(
				(action) -> addMember());
		frame.getContentPane().add(
				addAuthorButton);

		JLabel lblNewLabel_3_1 = new JLabel("BIO");
		lblNewLabel_3_1.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(
				55,
				183,
				100,
				16);
		frame.getContentPane().add(
				lblNewLabel_3_1);

		bioTextField = new JTextField();
		bioTextField.setColumns(
				10);
		bioTextField.setBounds(
				160,
				178,
				163,
				26);
		frame.getContentPane().add(
				bioTextField);

		credentialsCheckBox = new JCheckBox("Credentials");
		credentialsCheckBox.setHorizontalAlignment(
				SwingConstants.CENTER);
		credentialsCheckBox.setBounds(
				139,
				223,
				128,
				23);
		frame.getContentPane().add(
				credentialsCheckBox);
	}

	private void addMember() {
		 if (!inputsAreValid()) {
		 	JOptionPane.showMessageDialog(
		 	frame,
		 	"Fill in all the inputs correctly!");
		 	return;
		 }
		 final var addedAuthor = LibrarySystemFacade.addBookAuthor(
				 bioTextField.getText(),
				 credentialsCheckBox.isSelected(),
				 firstNameTextField.getText(),
				 lastNameTextField.getText(),
				 streetTextField.getText(),
				 cityTextField.getText(),
				 stateTextField.getText(),
				 zipCodeTextField.getText(),
				 phoneNumberTextField.getText()
		 );
		 JOptionPane.showMessageDialog(
		 	frame, "Successfully added an author!"
		 );
		 clear();
		 handler.onAuthorAdded(addedAuthor);
	}

	private void clear(){
		final JTextField[] textFields = {
				firstNameTextField,
				lastNameTextField,
				phoneNumberTextField,
				cityTextField,
				stateTextField,
				streetTextField,
				zipCodeTextField,
				bioTextField,
		};
		for(final var textField: textFields){
			textField.setText("");
		}
		credentialsCheckBox.setSelected(false);
	}

	private boolean inputsAreValid() {
		final String[] values = {
				firstNameTextField.getText(),
				lastNameTextField.getText(),
				phoneNumberTextField.getText(),
				cityTextField.getText(),
				stateTextField.getText(),
				streetTextField.getText(),
				zipCodeTextField.getText(),
				bioTextField.getText()};

		return new EmptyStringValidator().areValuesValid(
				Arrays.asList(
						values));
	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}
}
