package presentation.windows.dashboard;

import domain.library_system.LibrarySystemFacade;
import domain.library_system.User;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;
import presentation.navigation.AppNavigationFacade;
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
				() -> {
					try {
						DashboardWindow window = new DashboardWindow(null);
						window.frame.setVisible(
								true);
					} catch (Exception e) {
						e.printStackTrace();
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
			JButton addMemberButton = new JButton("Add Member");
			addMemberButton.addActionListener(
					(action) -> AppNavigationFacade.navigateToAddMemberWindow(
							user.tryGetOperation(IAddMemberOperation.class)
					)
			);
			addMemberButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);
			verticalOffset+=gap;
			frame.getContentPane().add(
					addMemberButton);
		}
		if(user.supportsOperation(ICheckoutBookOperation.class)){
			JButton checkoutButton = new JButton("Checkout Book");
			checkoutButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);
			checkoutButton.addActionListener(
					(action) -> AppNavigationFacade.navigateToCheckoutBookWindow(
							user.tryGetOperation(ICheckoutBookOperation.class)
					)
			);
			verticalOffset+=gap;
			frame.getContentPane().add(
					checkoutButton);
		}
		if(user.supportsOperation(IAddBookOperation.class)){
			JButton addBookButton = new JButton("Add Book");
			addBookButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);
			addBookButton.addActionListener(
					(actionEvent) -> AppNavigationFacade.navigateToAddBookWindow(
							user.tryGetOperation(IAddBookOperation.class)
					)
			);
			verticalOffset+=gap;
			frame.getContentPane().add(
					addBookButton);
		}

		if(user.supportsOperation(IAddBookCopyOperation.class)){
			JButton addBookCopyButton = new JButton("Add Book Copy");

			addBookCopyButton.addActionListener(
					(action) -> AppNavigationFacade.navigateToAddBookCopyWindow(
							user.tryGetOperation(IAddBookCopyOperation.class)
					)
			);

			addBookCopyButton.setBounds(
					horizontalOffset,
					verticalOffset,
					buttonWidth,
					buttonHeight);

			verticalOffset+=gap;
			frame.getContentPane().add(
					addBookCopyButton);
		}


		JButton logoutButton = new JButton("Logout");
		logoutButton.setBounds(
				horizontalOffset,
				verticalOffset,
				buttonWidth,
				buttonHeight);
		logoutButton.addActionListener(
				(action) -> {
					LibrarySystemFacade.logoutUser(user);
					AppNavigationFacade.goBack();
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

		frame.getContentPane().setLayout(
				null);
		overrideWindowClosing();

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
