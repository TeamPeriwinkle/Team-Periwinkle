import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DIYControl extends JFrame {

    private JLabel titleLabel;
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel emailLabel;
    private JTextField emailField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JPanel buttonsPanel;
    private JButton loginButton;
    private JButton signUpButton;
    private JButton backButton;
    private JButton createButton;
    private JButton exitButton;
    private String username;
    private String email;
    private String password;

    public DIYControl() {
        super("DIYControl");
    }

    public void display() {
        setSize(500, 500);

        // Set layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        setup();

        // Title label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(titleLabel, gbc);

        // Username label and field
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(usernameLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(usernameField, gbc);

        // Password label and field
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(passwordLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(passwordField, gbc);

        // Buttons Panel
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        add(buttonsPanel, gbc);

        // Adding to the panel

        buttonsPanel.add(loginButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(signUpButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        buttonsPanel.add(exitButton);

        // Buttons action section

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                username = usernameField.getText();
                password = String.valueOf(passwordField.getPassword());

                if (username.compareTo("") == 0 || password.compareTo("") == 0) {
                    JOptionPane.showMessageDialog(getParent(), "Please enter your Username and Password.");
                } else {
                    if (checkCredentials(username, password)) {
                        dispose();
                        JOptionPane.showMessageDialog(getParent(),
                            "Login Success.");
                    } else {
                        JOptionPane.showMessageDialog(getParent(), "Wrong Username or Password.");
                    }
                    
                    // create user Home Page
                }

            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                usernameField.setText("");
                passwordField.setText("");
                titleLabel.setText("Create an account");

                remove(passwordLabel);
                remove(passwordField);
                remove(buttonsPanel);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);

                // Email label and field
                emailLabel = new JLabel("Email Address:");
                gbc.gridx = 0;
                gbc.gridy = 2;
                add(emailLabel, gbc);
                emailField = new JTextField(20);
                gbc.gridx = 1;
                gbc.gridy = 2;
                add(emailField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 3;
                add(passwordLabel, gbc);
                gbc.gridx = 1;
                gbc.gridy = 3;
                add(passwordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 5;
                gbc.gridwidth = 4;
                add(buttonsPanel, gbc);

                buttonsPanel.removeAll();
                buttonsPanel.add(createButton);
                buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                buttonsPanel.add(backButton);
                buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                buttonsPanel.add(exitButton);
            }
        });

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                username = usernameField.getText();
                email = emailField.getText();
                password = String.valueOf(passwordField.getPassword());

                if (username.compareTo("") == 0 || email.compareTo("") == 0 || password.compareTo("") == 0) {
                    JOptionPane.showMessageDialog(getParent(),
                            "Please enter your Username, Email Address, and Password.", "DIYControl",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    if (checkUsername(username)) {
                        JOptionPane.showMessageDialog(getParent(), "Username already exists. Please try again.");
                    } else {
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Data/users.csv", true))) {
                            String line = username + "," + password + "," + email;
                            writer.write(line);
                            writer.newLine();
                            JOptionPane.showMessageDialog(getParent(), "Signup successful!");
                            dispose();
                        } catch (IOException theE) {
                            theE.printStackTrace();
                        }
                    }
                    //dispose();
                    // create user Home Page
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                usernameField.setText("");
                emailField.setText("");
                passwordField.setText("");

                titleLabel.setText("Welcome to DIY Control");

                remove(emailField);
                remove(emailLabel);
                remove(passwordLabel);
                remove(passwordField);
                remove(buttonsPanel);

                GridBagConstraints gbc = new GridBagConstraints();
                gbc.insets = new Insets(10, 10, 10, 10);

                gbc.gridx = 0;
                gbc.gridy = 2;
                add(passwordLabel, gbc);
                gbc.gridx = 1;
                gbc.gridy = 2;
                add(passwordField, gbc);

                gbc.gridx = 0;
                gbc.gridy = 4;
                gbc.gridwidth = 4;
                add(buttonsPanel, gbc);

                buttonsPanel.removeAll();
                buttonsPanel.add(loginButton);
                buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                buttonsPanel.add(signUpButton);
                buttonsPanel.add(Box.createRigidArea(new Dimension(0, 10)));
                buttonsPanel.add(exitButton);
                revalidate();
                repaint();
            }
        });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    private boolean checkUsername(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader("Data/users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkCredentials(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader("Data/users.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void setup() {
        titleLabel = new JLabel("Welcome to DIYControl");
        titleLabel.setFont(new Font("", Font.BOLD, 24));

        usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);
        emailLabel = new JLabel("Email Address:");
        emailField = new JTextField(20);
        passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        buttonsPanel = new JPanel();
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        backButton = new JButton("Back");
        exitButton = new JButton("Exit");
        createButton = new JButton("Create");

        Dimension buttonSize = new Dimension(100, 50);
        signUpButton.setMaximumSize(buttonSize);
        loginButton.setMaximumSize(buttonSize);
        backButton.setMaximumSize(buttonSize);
        exitButton.setMaximumSize(buttonSize);
        createButton.setMaximumSize(buttonSize);
    }

}
