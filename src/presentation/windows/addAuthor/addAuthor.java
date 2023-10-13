package presentation.windows.addAuthor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class addAuthor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_1_2_2;
	private JLabel lblBio;
	private JTextField textField_7;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAuthor window = new addAuthor();
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
	public addAuthor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, -47, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Personal Info");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		lblNewLabel.setBounds(131, 0, 143, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAddressInfo = new JLabel("Address Info");
		lblAddressInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddressInfo.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		lblAddressInfo.setBounds(131, 84, 143, 16);
		frame.getContentPane().add(lblAddressInfo);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone Number:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(48, 63, 105, 16);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textField = new JTextField();
		textField.setBounds(163, 27, 96, 16);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(163, 47, 96, 16);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(163, 64, 96, 16);
		frame.getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Last Name:");
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_4.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel_1_2_4.setBounds(51, 46, 105, 16);
		frame.getContentPane().add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("First Name:");
		lblNewLabel_1_2_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_4_1.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel_1_2_4_1.setBounds(51, 27, 105, 16);
		frame.getContentPane().add(lblNewLabel_1_2_4_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(163, 120, 96, 16);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(163, 100, 96, 16);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(163, 160, 96, 16);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(163, 140, 96, 16);
		frame.getContentPane().add(textField_6);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("State:");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(48, 119, 105, 16);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("City:");
		lblNewLabel_1_2_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_4_2.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel_1_2_4_2.setBounds(48, 99, 105, 16);
		frame.getContentPane().add(lblNewLabel_1_2_4_2);
		
		lblNewLabel_1 = new JLabel("Zip Code:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(48, 159, 105, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_1_2_2 = new JLabel("Street:");
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		lblNewLabel_1_2_2.setBounds(48, 139, 105, 16);
		frame.getContentPane().add(lblNewLabel_1_2_2);
		
		lblBio = new JLabel("Bio");
		lblBio.setHorizontalAlignment(SwingConstants.CENTER);
		lblBio.setFont(new Font("Lucida Sans", Font.PLAIN, 17));
		lblBio.setBounds(138, 178, 121, 16);
		frame.getContentPane().add(lblBio);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Lucida Sans", Font.PLAIN, 13));
		textField_7.setBounds(48, 197, 351, 29);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		btnNewButton = new JButton("Add Author");
		btnNewButton.setFont(new Font("Lucida Sans", Font.PLAIN, 16));
		btnNewButton.setBounds(157, 228, 132, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
