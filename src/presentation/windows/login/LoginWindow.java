package presentation.windows.login;

import domain.library_system.LibrarySystemFacade;
import domain.library_system.exceptions.LibrarySystemException;
import domain.library_system.operations.auth_operations.AccessType;
import presentation.navigation.AppNavigationFacade;
import presentation.navigation.AppNavigationWindow;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class LoginWindow implements AppNavigationWindow {

	private JFrame frame;


	private JTextField userNameTextField;
	private JPasswordField passwordField;

	private  JButton loginButton;

	private JComboBox<AccessType> accessTypeComboBox;


	public static void main(String[] args) {
		EventQueue.invokeLater(
				() -> {
					try {
						LoginWindow window = new LoginWindow();
						window.frame.setVisible(
								true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}


	public LoginWindow() {
		initialize();
		setUp();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setResizable(
				false);
		frame.setBounds(
				100,
				100,
				446,
				320);
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(
				panel);
		panel.setLayout(
				null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(
				90,
				88,
				80,
				16);
		panel.add(
				lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(
				90,
				127,
				80,
				16);
		panel.add(
				lblNewLabel_1);

		userNameTextField = new JTextField();
		userNameTextField.setBounds(
				206,
				83,
				130,
				26);
		panel.add(
				userNameTextField);
		userNameTextField.setColumns(
				10);

		accessTypeComboBox = new JComboBox<>();
		accessTypeComboBox.setModel(
				new DefaultComboBoxModel<>(
						AccessType.values()));
		accessTypeComboBox.setBounds(
				141,
				183,
				160,
				27);
		panel.add(
				accessTypeComboBox);

		JLabel lblNewLabel_2 = new JLabel("Library Management System");
		lblNewLabel_2.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel_2.setFont(
				new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(
				103,
				6,
				254,
				26);
		panel.add(
				lblNewLabel_2);

		loginButton = new JButton("Login");
		loginButton.setBounds(
				161,
				243,
				117,
				29);
		panel.add(
				loginButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(
				206,
				122,
				130,
				26);
		panel.add(
				passwordField);
	}


	private void setUp(){
		loginButton.addActionListener(
				(action) -> login()
		);
	}

	private  void login(){
		final String userName = userNameTextField.getText();
		final String password = new String(passwordField.getPassword());
		final Object accessType = accessTypeComboBox.getSelectedItem();

		if(userName == null || userName.isEmpty() || password.isEmpty() || accessType == null){
			JOptionPane.showMessageDialog(frame, "Please, fill in all the fields");
			return;
		}

		final AccessType castedAccessType = (AccessType) accessType;


		try {
			final var user = LibrarySystemFacade.loginUser(userName, password, castedAccessType);
			passwordField.setText("");
			AppNavigationFacade.navigateToDashboardWindow(user);
		} catch (LibrarySystemException e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}


	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}
}
