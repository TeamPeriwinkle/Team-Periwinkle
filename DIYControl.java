import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DIYControl extends JFrame {

    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JLabel confirmPassLabel;
    private JPasswordField confirmPassField;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton backButton;
    private JButton exitButton;

    public DIYControl() {
        super("DIY Control");
    }
   
    public void display() {
        setSize(500, 400);

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
         
        // Title label
        titleLabel = new JLabel("Welcome to DIY Control");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Username label and field
        usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        // Password label and field
        passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);
        
       //  JLabel forgotPasswordLabel = new JLabel("Forgot Username or Password?");
//          gbc.gridx = 1;
//          gbc.gridy = 3;
//          add(forgotPasswordLabel,gbc);
// 
//         // Login and sign up buttons
        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        add(buttonsPanel, gbc);
        
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        backButton = new JButton("Back");
        exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Dimension buttonSize = new Dimension(100, 50);
        signUpButton.setMaximumSize(buttonSize);
        loginButton.setMaximumSize(buttonSize);
        backButton.setMaximumSize(buttonSize);
        exitButton.setMaximumSize(buttonSize);
        buttonsPanel.add(signUpButton);
        buttonsPanel.add(loginButton);
        buttonsPanel.add(exitButton);
        
        confirmPassField = new JPasswordField(20);
        confirmPassLabel = new JLabel("Confirm Password:");
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                titleLabel.setText("Login!!!");
                remove(usernameLabel);
                remove(usernameField);
                remove(passwordLabel);
                remove(passwordField);
                revalidate();
                repaint();
                
                buttonsPanel.remove(signUpButton);
                buttonsPanel.remove(loginButton);
            
            }
        });
        
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                titleLabel.setText("Create an account");
                usernameField.setText("");
                passwordField.setText("");
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);
                gbc.fill = GridBagConstraints.HORIZONTAL;
                
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.gridwidth = 1;
                add(confirmPassLabel, gbc);
                
                gbc.gridx = 1;
                gbc.gridy = 3;
                add(confirmPassField, gbc);
                
                buttonsPanel.remove(loginButton);
                buttonsPanel.add(backButton);
                buttonsPanel.add(exitButton);
            
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                titleLabel.setText("Welcome to DIY Control");
                usernameField.setText("");
                passwordField.setText("");
                confirmPassField.setText("");
                remove(confirmPassLabel);
                remove(confirmPassField);
                revalidate();
                repaint();
                
                buttonsPanel.remove(backButton);
                buttonsPanel.remove(exitButton);
                buttonsPanel.add(loginButton);
                buttonsPanel.add(exitButton);
            
            }
        });
                
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }

}