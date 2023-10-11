package presentation.windows.login;

import domain.library_system.operations.AccessType;
import presentation.navigation.AppNavigationWindow;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginWindow implements AppNavigationWindow {

	private JFrame frame;


	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(
				new Runnable() {
					public void run() {
						try {
							LoginWindow window = new LoginWindow();
							window.frame.setVisible(
									true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
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

		textField = new JTextField();
		textField.setBounds(
				206,
				83,
				130,
				26);
		panel.add(
				textField);
		textField.setColumns(
				10);

		var comboBox = new JComboBox<AccessType>();
		comboBox.setModel(
				new DefaultComboBoxModel<AccessType>(
						AccessType.values()));
		comboBox.setBounds(
				141,
				183,
				160,
				27);
		panel.add(
				comboBox);

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

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(
				161,
				243,
				117,
				29);
		panel.add(
				btnNewButton);

		passwordField = new JPasswordField();
		passwordField.setBounds(
				206,
				122,
				130,
				26);
		panel.add(
				passwordField);
	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}
}
