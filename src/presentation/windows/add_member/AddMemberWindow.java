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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;


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

		textField_3 = new JTextField();
		textField_3.setColumns(
				10);
		textField_3.setBounds(
				160,
				233,
				163,
				26);
		frame.getContentPane().add(
				textField_3);

		JLabel lblState = new JLabel("State");
		lblState.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblState.setBounds(
				65,
				276,
				93,
				16);
		frame.getContentPane().add(
				lblState);

		textField_4 = new JTextField();
		textField_4.setColumns(
				10);
		textField_4.setBounds(
				160,
				271,
				163,
				26);
		frame.getContentPane().add(
				textField_4);

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

		textField_5 = new JTextField();
		textField_5.setColumns(
				10);
		textField_5.setBounds(
				160,
				309,
				163,
				26);
		frame.getContentPane().add(
				textField_5);

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

		textField_6 = new JTextField();
		textField_6.setColumns(
				10);
		textField_6.setBounds(
				160,
				342,
				163,
				26);
		frame.getContentPane().add(
				textField_6);

		JButton btnNewButton = new JButton("Add member");
		btnNewButton.setBounds(
				141,
				401,
				138,
				38);
		btnNewButton.addActionListener(
				(action) -> addMember()
		);
		frame.getContentPane().add(
				btnNewButton);
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
				textField.getText(),
				textField_1.getText(),
				textField_5.getText(),
				textField_3.getText(),
				textField_4.getText(),
				textField_6.getText(),
				textField_2.getText()
		);
		JOptionPane.showMessageDialog(
				frame,
				String.format("""
							New member has been created:
							Id: %s
							First name: %s
							Last name: %s
							Phone number: %s
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
	}


	private boolean inputsAreValid(){
		final String[] values = {
				textField.getText(),
				textField_1.getText(),
				textField_2.getText(),
				textField_3.getText(),
				textField_4.getText(),
				textField_5.getText(),
				textField_6.getText(),
		};

		return  new EmptyStringValidator().areValuesValid(Arrays.asList(values));
	}

	@Override
	public JFrame getJFrame() {
		return  frame;
	}
}
