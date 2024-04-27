package HrApp;

import java.awt.Color;
//import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

    private static final long serialVersionUID = 1L;

    public static final int H_FRAME = 360;
    public static final int W_FRAME = 540;
    private JPanel contentPane;
    private JButton button_login; //, button_register;
    private JLabel label_username, label_password, label_icon, label_errorText;
    private JTextField textField_username;
    private JPasswordField passwordField_password;
    private Insets insets;
    String errorText = "ErrorText";
    private Person user;

    public LoginPage() {

        super("Login");
        setIconImage(Toolkit.getDefaultToolkit()
                .getImage(
                        "HrApp\\Hello World HR App Logo Idea.png"));
        setResizable(false);
        setLayout(null);
        setSize(W_FRAME, H_FRAME);
        setLocationRelativeTo(null);
        setLocation(getX() - 80, getY() - 80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        insets = this.getInsets();

        GUI();

        //button_register = new JButton("Register");
        //button_register.setBounds(textField_username.getX() + 20, label_username.getY() + 120, 80, 22);
        //button_register.setFocusPainted(false);
        //button_register.addActionListener(new ActionListener() {
            //@Override
            //public void actionPerformed(ActionEvent e) {
               // openRegistrationForm();
            //}
        //});
        //contentPane.add(button_register);

        button_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateUser();
            }
        });

    }

    private void authenticateUser() {
        String enteredUsername = textField_username.getText();
        char[] enteredPassword = passwordField_password.getPassword();

        // Validate login using Helper class
        user = Helper.validateLogin(enteredUsername, enteredPassword);

        // Checks if returned user is in system
        if (user != null) {
            JOptionPane.showMessageDialog(null, "Login successful");
            System.out.println("Login Successful");

            this.dispose();

            GUI gui = new GUI(user); //It doesn't know what person you are......

            // Perform further actions upon successful login
            // if user cannot be found then show invalid username or password
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username or password");
            System.out.println("Login Invalid");
        }
    }

    private void GUI() {

        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBounds(insets.left, insets.top, W_FRAME - insets.left - insets.right,
                H_FRAME - insets.bottom - insets.top);

        label_username = new JLabel("Username");
        label_username.setFont(new Font("Tahoma", Font.PLAIN, 14));
        label_username.setBounds(120, 140, 70, 20);
        contentPane.add(label_username);

        label_password = new JLabel("Password");
        label_password.setFont(label_username.getFont());
        label_password.setBounds(label_username.getX(), label_username.getY() + 40,
                label_username.getWidth(), label_username.getHeight());
        contentPane.add(label_password);

        textField_username = new JTextField();
        textField_username.setBounds(label_username.getX() + label_username.getWidth() + 30,
                label_username.getY(), 120, label_username.getHeight());
        textField_username.addActionListener(e -> passwordField_password.requestFocus());
        contentPane.add(textField_username);

        passwordField_password = new JPasswordField();
        passwordField_password.setBounds(textField_username.getX(), label_password.getY(),
                120, label_password.getHeight());
        passwordField_password.addActionListener(e-> button_login.doClick());
        contentPane.add(passwordField_password);

        button_login = new JButton("Login");
        button_login.setBounds(textField_username.getX() + 20, label_username.getY() + 80, 80, 22);
        button_login.setFocusPainted(false);
        button_login.addActionListener(e-> {
                if (textField_username.getText().equals("")
                        || String.valueOf(passwordField_password.getPassword()).equals("")) {

                    label_errorText.setText(errorText);

                } else {

                    label_errorText.setText("");

                } });
        contentPane.add(button_login);

        label_icon = new JLabel(
                new ImageIcon(
                        "HrApp\\Hello World HR App Logo Idea small.png"));
        label_icon.setBounds(textField_username.getX() + 20, textField_username.getY() - 100, 72, 72);
        contentPane.add(label_icon);

        label_errorText = new JLabel();
        label_errorText.setForeground(Color.RED);
        label_errorText.setBounds(button_login.getX() - 45, button_login.getY() + 30, 170, 30);
        label_errorText.setFont(new Font("Tahoma", Font.PLAIN + Font.BOLD, 11));
        contentPane.add(label_errorText);

        setContentPane(contentPane);

    }

    // creates function that adds a register button and allows a user to register
    //private void openRegistrationForm() {
        //JFrame registerFrame = new JFrame("Register");
        //registerFrame.setSize(300, 250);
        //registerFrame.setLocationRelativeTo(null);
        //registerFrame.setLayout(new FlowLayout());

        // Create labels and text fields for name, age, email, and password
        //JLabel label_name = new JLabel("Name:");
        //JTextField textField_name = new JTextField(20);
        //JLabel label_age = new JLabel("Age:");
        //JTextField textField_age = new JTextField(20);
        //JLabel label_email = new JLabel("Email:");
        //JTextField textField_email = new JTextField(20);
        //JLabel label_password = new JLabel("Password:");
        //JPasswordField passwordField_password = new JPasswordField(20);

        // Create register button
        //JButton button_register = new JButton("Register");
        //button_register.addActionListener(new ActionListener() {
            //@Override
            //public void actionPerformed(ActionEvent e) {
                //String name = textField_name.getText();
                //int age = Integer.parseInt(textField_age.getText());
                //String email = textField_email.getText();
                //char[] password = passwordField_password.getPassword();
                //registerUser(name, age, email, password);
                //registerFrame.dispose();
            //}
        //});

        // Add components to registration form
        //registerFrame.add(label_name);
        //registerFrame.add(textField_name);
        //registerFrame.add(label_age);
        //registerFrame.add(textField_age);
        //registerFrame.add(label_email);
        //registerFrame.add(textField_email);
        //registerFrame.add(label_password);
        //registerFrame.add(passwordField_password);
        //registerFrame.add(button_register);

        //registerFrame.setVisible(true);
    //}

    // Method to register a new user
    //private void registerUser(String name, int age, String email, char[] password) {
        // Create a new Person object with the provided email and password

        //Person newUser = new Person(name, age, email, password);

        // Add the new user to TempArrays
        //TempArrays.addUser(newUser);

        // Display a success message
        //JOptionPane.showMessageDialog(null, "Registration successful");
    //}
}

// }

// create login functions to take data and compare