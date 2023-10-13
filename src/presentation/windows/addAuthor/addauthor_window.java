package presentation.windows.addAuthor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class addauthor_window {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addauthor_window window = new addauthor_window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addauthor_window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel.setBounds(40, 55, 100, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Author");
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(126, 11, 122, 42);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
		lblLastName.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblLastName.setBounds(40, 99, 100, 33);
		frame.getContentPane().add(lblLastName);
		
		textField = new JTextField();
		textField.setBounds(214, 59, 153, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 103, 153, 26);
		frame.getContentPane().add(textField_1);
		
		JLabel lblBio = new JLabel("Bio");
		lblBio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBio.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblBio.setBounds(40, 174, 100, 26);
		frame.getContentPane().add(lblBio);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(214, 177, 153, 33);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(214, 140, 153, 26);
		frame.getContentPane().add(textField_3);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNumber.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(40, 139, 100, 33);
		frame.getContentPane().add(lblPhoneNumber);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnNewButton.setBounds(159, 221, 100, 31);
		frame.getContentPane().add(btnNewButton);
	}
}
