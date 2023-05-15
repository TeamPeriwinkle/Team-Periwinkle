import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DIYControl extends JFrame {

    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    //private JPasswordField passwordField;
    private JTextField passwordField;
    private JPanel buttonsPanel;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton backButton;
    private JButton aboutButton;
    private JButton exitButton;
    private JPanel aboutPanel;
    private String firstname;
    private String email;
    private GridBagConstraints gbc;

    public DIYControl() {
        super("DIYControl");
    }
   
    public void display() {
        setSize(500, 500);

        // Set layout
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
         
        // Title label
        titleLabel = new JLabel("Welcome to DIYControl");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Username label and field
        usernameLabel = new JLabel("Firstname:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        // Password label and field
        passwordLabel = new JLabel("Email Address:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);

        passwordField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);
        
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        add(buttonsPanel, gbc);
        
        loginButton = new JButton("Create");
        signUpButton = new JButton("Sign Up");
        backButton = new JButton("Back");
        exitButton = new JButton("Exit");
        aboutButton = new JButton("About");
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
        aboutButton.setMaximumSize(buttonSize);
        //buttonsPanel.add(signUpButton);
        buttonsPanel.add(loginButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(exitButton);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                firstname = usernameField.getText();
                email = passwordField.getText();
                
                if (firstname.compareTo("") == 0 || email.compareTo("") == 0) {
                    JOptionPane.showMessageDialog(getParent(), "Please enter your Firstname and email address", "DIYControl", JOptionPane.WARNING_MESSAGE);
                } else {
                    titleLabel.setText("Welcome " + firstname + "!");
                    remove(usernameLabel);
                    remove(usernameField);
                    remove(passwordLabel);
                    remove(passwordField);
                    revalidate();
                    repaint();
                    
                    buttonsPanel.remove(loginButton);
                    buttonsPanel.add(aboutButton);
                    buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                    buttonsPanel.add(exitButton);
                }
            
            }
        });
        
        aboutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                String firstname = usernameField.getText();
                String email = passwordField.getText();
                
                titleLabel.setText("About");
                buttonsPanel.remove(aboutButton);
                buttonsPanel.remove(exitButton);
                
                About a = new About(firstname, email);
                a.setup();
                aboutPanel = a.getPanel();
                
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 1;
                add(aboutPanel, gbc);
                
                gbc.gridx = 0;
                gbc.gridy = 2;
                gbc.gridwidth = 1;
                add(buttonsPanel, gbc);
                buttonsPanel.add(backButton);
                buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                buttonsPanel.add(exitButton);
            
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                titleLabel.setText("Welcome " + firstname + "!");
                remove(aboutPanel);
                revalidate();
                repaint();
                
                gbc.gridx = 0;
                gbc.gridy = 1;
                gbc.gridwidth = 1;
                add(buttonsPanel, gbc);
                buttonsPanel.remove(backButton);
                buttonsPanel.remove(exitButton);
                buttonsPanel.add(aboutButton);
                buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                buttonsPanel.add(exitButton);
            
            }
        });
                
        //pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public static void main(String[] theArgs) {
    	DIYControl frame = new DIYControl();
    	frame.display();
    }

}
