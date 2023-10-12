package presentation.windows.add_book;

import javax.swing.*;
import java.awt.*;

public class AddBookWindow {
    private JFrame frame;
    private JTextField textField_4;
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
                    AddBookWindow window = new AddBookWindow();
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
    public AddBookWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Add New Book");
        lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 6, 450, 26);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Book Title ");
        lblNewLabel_2.setBounds(37, 44, 132, 26);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("ISBN");
        lblNewLabel_3.setBounds(37, 77, 64, 26);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Author ");
        lblNewLabel_4.setBounds(37, 111, 79, 26);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_4_1 = new JLabel("Number of Copies ");
        lblNewLabel_4_1.setBounds(37, 136, 132, 39);
        frame.getContentPane().add(lblNewLabel_4_1);

        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(181, 44, 178, 29);
        frame.getContentPane().add(textField_4);

        JLabel lblNewLabel_1 = new JLabel("Maximum Checkout Days");
        lblNewLabel_1.setBounds(37, 187, 169, 16);
        frame.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Enter");
        btnNewButton.setBounds(295, 225, 117, 29);
        frame.getContentPane().add(btnNewButton);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(181, 77, 178, 29);
        frame.getContentPane().add(textField);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(181, 111, 178, 29);
        frame.getContentPane().add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(181, 142, 178, 29);
        frame.getContentPane().add(textField_2);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(270, 182, 85, 29);
        frame.getContentPane().add(textField_3);
    }

}
