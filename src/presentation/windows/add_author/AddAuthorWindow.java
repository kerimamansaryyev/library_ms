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

	private JCheckBox chckbxNewCheckBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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

		textField = new JTextField();
		textField.setBounds(
				160,
				64,
				163,
				26);
		frame.getContentPane().add(
				textField);
		textField.setColumns(
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

		textField_1 = new JTextField();
		textField_1.setBounds(
				160,
				102,
				163,
				26);
		frame.getContentPane().add(
				textField_1);
		textField_1.setColumns(
				10);

		textField_2 = new JTextField();
		textField_2.setColumns(
				10);
		textField_2.setBounds(
				160,
				140,
				163,
				26);
		frame.getContentPane().add(
				textField_2);

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

		textField_3 = new JTextField();
		textField_3.setColumns(
				10);
		textField_3.setBounds(
				160,
				321,
				163,
				26);
		frame.getContentPane().add(
				textField_3);

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

		textField_4 = new JTextField();
		textField_4.setColumns(
				10);
		textField_4.setBounds(
				160,
				359,
				163,
				26);
		frame.getContentPane().add(
				textField_4);

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

		textField_5 = new JTextField();
		textField_5.setColumns(
				10);
		textField_5.setBounds(
				160,
				397,
				163,
				26);
		frame.getContentPane().add(
				textField_5);

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

		textField_6 = new JTextField();
		textField_6.setColumns(
				10);
		textField_6.setBounds(
				160,
				430,
				163,
				26);
		frame.getContentPane().add(
				textField_6);

		JButton btnNewButton = new JButton("Add Author");
		btnNewButton.setBounds(
				139,
				484,
				138,
				38);
		btnNewButton.addActionListener(
				(action) -> addMember());
		frame.getContentPane().add(
				btnNewButton);

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

		textField_7 = new JTextField();
		textField_7.setColumns(
				10);
		textField_7.setBounds(
				160,
				178,
				163,
				26);
		frame.getContentPane().add(
				textField_7);

		chckbxNewCheckBox = new JCheckBox("Credentials");
		chckbxNewCheckBox.setHorizontalAlignment(
				SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(
				139,
				223,
				128,
				23);
		frame.getContentPane().add(
				chckbxNewCheckBox);
	}

	private void addMember() {
		 if (!inputsAreValid()) {
		 	JOptionPane.showMessageDialog(
		 	frame,
		 	"Fill in all the inputs correctly!");
		 	return;
		 }
		 final var addedAuthor = LibrarySystemFacade.addBookAuthor(
				 textField_7.getText(),
				 chckbxNewCheckBox.isSelected(),
				 textField.getText(),
				 textField_1.getText(),
				 textField_5.getText(),
				 textField_3.getText(),
				 textField_4.getText(),
				 textField_6.getText(),
				 textField_2.getText()
		 );
		 JOptionPane.showMessageDialog(
		 	frame, "Successfully added an author!"
		 );
		 clear();
		 handler.onAuthorAdded(addedAuthor);
	}

	private void clear(){
		final JTextField[] textFields = {
				textField,
				textField_1,
				textField_2,
				textField_3,
				textField_4,
				textField_5,
				textField_6,
				textField_7,
		};
		for(final var textField: textFields){
			textField.setText("");
		}
		chckbxNewCheckBox.setSelected(false);
	}

	private boolean inputsAreValid() {
		final String[] values = {
				textField.getText(),
				textField_1.getText(),
				textField_2.getText(),
				textField_3.getText(),
				textField_4.getText(),
				textField_5.getText(),
				textField_6.getText(),
				textField_7.getText()};

		return new EmptyStringValidator().areValuesValid(
				Arrays.asList(
						values));
	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}
}
