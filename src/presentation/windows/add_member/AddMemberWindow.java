package presentation.windows.add_member;

import domain.library_system.LibrarySystemFacade;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import presentation.navigation.AppNavigationWindow;
import presentation.windows.utils.validators.EmptyStringValidator;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.*;

public class AddMemberWindow implements AppNavigationWindow {



	private final IAddMemberOperation operation;
	private JFrame frame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private JTextField cityTextField;
	private JTextField stateTextField;
	private JTextField streetTextField;
	private JTextField zipCodeTextField;


	public static void main(String[] args) {
		EventQueue.invokeLater(
				() -> {
					try {
						AddMemberWindow window = new AddMemberWindow((
								firstName,
								lastName,
								street,
								city,
								state,
								zipCode,
								phoneNumber) -> null);
						window.frame.setVisible(
								true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}


	public AddMemberWindow(IAddMemberOperation addMemberOperation) {
		this.operation = addMemberOperation;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		overrideWindowClosing();
		frame.setBounds(
				100,
				100,
				433,
				487);
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

		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel.setBounds(
				55,
				69,
				93,
				16);
		frame.getContentPane().add(
				lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Personal Data");
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

		JLabel lblNewLabel_2 = new JLabel("Last Name:");
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

		JLabel lblNewLabel_1_1 = new JLabel("ADDRESS");
		lblNewLabel_1_1.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(
				new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(
				152,
				188,
				110,
				33);
		frame.getContentPane().add(
				lblNewLabel_1_1);

		JLabel lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblCity.setBounds(
				65,
				238,
				93,
				16);
		frame.getContentPane().add(
				lblCity);

		cityTextField = new JTextField();
		cityTextField.setColumns(
				10);
		cityTextField.setBounds(
				160,
				233,
				163,
				26);
		frame.getContentPane().add(
				cityTextField);

		JLabel lblState = new JLabel("State:");
		lblState.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblState.setBounds(
				65,
				276,
				93,
				16);
		frame.getContentPane().add(
				lblState);

		stateTextField = new JTextField();
		stateTextField.setColumns(
				10);
		stateTextField.setBounds(
				160,
				271,
				163,
				26);
		frame.getContentPane().add(
				stateTextField);

		JLabel lblStreet = new JLabel("Street:");
		lblStreet.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblStreet.setBounds(
				65,
				314,
				93,
				16);
		frame.getContentPane().add(
				lblStreet);

		streetTextField = new JTextField();
		streetTextField.setColumns(
				10);
		streetTextField.setBounds(
				160,
				309,
				163,
				26);
		frame.getContentPane().add(
				streetTextField);

		JLabel lblZipCode = new JLabel("Zip Code:");
		lblZipCode.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblZipCode.setBounds(
				65,
				347,
				93,
				16);
		frame.getContentPane().add(
				lblZipCode);

		zipCodeTextField = new JTextField();
		zipCodeTextField.setColumns(
				10);
		zipCodeTextField.setBounds(
				160,
				342,
				163,
				26);
		frame.getContentPane().add(
				zipCodeTextField);

		JButton addMemberButton = new JButton("Add Member");
		addMemberButton.setBounds(
				141,
				401,
				138,
				38);
		addMemberButton.addActionListener(
				(action) -> addMember()
		);
		frame.getContentPane().add(
				addMemberButton);
		frame.setResizable(false);
	}


	private void addMember(){
		if(!inputsAreValid()){
			JOptionPane.showMessageDialog(
					frame,
					"Fill in all the inputs correctly!"
			);
			return;
		}
		final var addedMember = LibrarySystemFacade.addLibraryMember(
				operation,
				firstNameTextField.getText(),
				lastNameTextField.getText(),
				streetTextField.getText(),
				cityTextField.getText(),
				stateTextField.getText(),
				zipCodeTextField.getText(),
				phoneNumberTextField.getText()
		);
		JOptionPane.showMessageDialog(
				frame,
				String.format("""
							New member has been created:
							Id: %s
							First Name: %s
							Last Name: %s
							Phone Number: %s
							City: %s
							State: %s
							Street: %s
							Zip code: %s""",
						addedMember.getMemberId(),
						addedMember.getFirstName(),
						addedMember.getLastName(),
						addedMember.getPhoneNumber(),
						addedMember.getAddress().getCity(),
						addedMember.getAddress().getState(),
						addedMember.getAddress().getStreet(),
						addedMember.getAddress().getZip()
				)
		);
		clear();

	}

	private void clear () {

		final JTextField [] textFields = {
				firstNameTextField,
				lastNameTextField,
				streetTextField,
				cityTextField,
				stateTextField,
				zipCodeTextField,
				phoneNumberTextField,
		};

		for (final var textField: textFields){
			textField.setText("");
		}
	}


	private boolean inputsAreValid(){
		final String[] values = {
				firstNameTextField.getText(),
				lastNameTextField.getText(),
				phoneNumberTextField.getText(),
				cityTextField.getText(),
				stateTextField.getText(),
				streetTextField.getText(),
				zipCodeTextField.getText(),
		};

		return  new EmptyStringValidator().areValuesValid(Arrays.asList(values));
	}

	@Override
	public JFrame getJFrame() {
		return  frame;
	}
}
