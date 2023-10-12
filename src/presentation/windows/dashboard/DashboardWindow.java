package presentation.windows.dashboard;

import domain.library_system.UseCaseFactory;
import domain.library_system.User;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;
import presentation.navigation.AppNavigationFactory;
import presentation.navigation.AppNavigationWindow;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DashboardWindow implements AppNavigationWindow {

	private JFrame frame;
	private final User user;

	public static void main(String[] args) {
		EventQueue.invokeLater(
				new Runnable() {
					public void run() {
						try {
							DashboardWindow window = new DashboardWindow(null);
							window.frame.setVisible(
									true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
	}


	public DashboardWindow(User user) {
		this.user = user;
		initialize();
	}


	private void addOperationButtons(){

		final int horizontalOffset = 294;
		final int buttonWidth = 185;
		final int buttonHeight = 35;
		final int gap = 40;

		int verticalOffset = 115;


		if(user.supportsOperation(IAddMemberOperation.class)){
			JButton btnNewButton = new JButton("Add member");
			btnNewButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);
			verticalOffset+=gap;
			frame.getContentPane().add(
					btnNewButton);
		}
		if(user.supportsOperation(ICheckoutBookOperation.class)){
			JButton btnNewButton = new JButton("CheckoutBook");
			btnNewButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);
			verticalOffset+=gap;
			frame.getContentPane().add(
					btnNewButton);
		}
		if(user.supportsOperation(IAddBookOperation.class)){
			JButton btnNewButton = new JButton("Add book");
			btnNewButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);
			verticalOffset+=gap;
			frame.getContentPane().add(
					btnNewButton);
		}

		if(user.supportsOperation(IAddBookCopyOperation.class)){
			JButton btnNewButton = new JButton("Add book copy");
			btnNewButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);
			verticalOffset+=gap;
			frame.getContentPane().add(
					btnNewButton);
		}


		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(
				horizontalOffset,
				verticalOffset,
				buttonWidth,
				buttonHeight);
		logoutButton.addActionListener(
				(action) -> {
					UseCaseFactory.logoutUser(user);
					AppNavigationFactory.goBack();
				}
		);
		frame.getContentPane().add(
				logoutButton);
	}


	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(
				100,
				100,
				801,
				506);
		frame.setDefaultCloseOperation(
				JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				null);

		addOperationButtons();

		JLabel lblNewLabel = new JLabel("Library Management System");
		lblNewLabel.setFont(
				new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(
				SwingConstants.CENTER);
		lblNewLabel.setBounds(
				278,
				16,
				231,
				35);
		frame.getContentPane().add(
				lblNewLabel);
	}

	@Override
	public JFrame getJFrame() {
		return frame;
	}
}
