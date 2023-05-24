import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class CreateNewProject extends JFrame {

    private JPanel projectPanel;
    private JPanel projectListPanel;
    private JMenuBar menuBar;
    private JMenu settingsSection;
    private JMenu backsetting;

    public CreateNewProject() {
        super("Create New Project");
        display();
        createMenuBar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void display() {
        projectPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(-350, 10, 10, 10);

        JLabel titleLabel = new JLabel("Create New Project");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        projectPanel.add(titleLabel, gbc);

        JButton createProjectButton = new JButton("Create a new project");
        createProjectButton.setPreferredSize(new Dimension(250, 30));
        createProjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewProject();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(-300, 10, 10, 10);
        projectPanel.add(createProjectButton, gbc);

        projectListPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcList = new GridBagConstraints();
        gbcList.gridx = 0;
        gbcList.gridy = 0;
        gbcList.insets = new Insets(10, 10, 10, 10);
        projectPanel.add(projectListPanel, gbcList);
        getContentPane().add(projectPanel, BorderLayout.CENTER);
    }

    private void createNewProject() {
        JPanel projectDetailsPanel = new JPanel(new GridLayout(4, 2));
        projectDetailsPanel.add(new JLabel("Title:"));
        JTextField projectNameField = new JTextField();
        projectDetailsPanel.add(projectNameField);
        projectDetailsPanel.add(new JLabel("Budget:"));
        JTextField budgetField = new JTextField();
        projectDetailsPanel.add(budgetField);
        projectDetailsPanel.add(new JLabel("Plan (Optional):"));
        JTextField planField = new JTextField();
        projectDetailsPanel.add(planField);
        projectDetailsPanel.add(new JLabel("Description:"));
        JTextField descriptionField = new JTextField();
        projectDetailsPanel.add(descriptionField);
    
        int option = JOptionPane.showOptionDialog(this, projectDetailsPanel, "Create a new project", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);
    
        if (option == JOptionPane.OK_OPTION) {
            String projectName = projectNameField.getText();
            String budgetText = budgetField.getText();
            String plan = planField.getText();
            String description = descriptionField.getText();
    
            if (!projectName.trim().isEmpty() && !budgetText.trim().isEmpty()) {
                try {
                    double budget = Double.parseDouble(budgetText);
                    boolean saved = saveProject(projectName, budget, plan, description);
                    if (saved) {
                        JOptionPane.showMessageDialog(this, "New project created and saved: " + projectName, "Create Project", JOptionPane.INFORMATION_MESSAGE);
                        updateProjectList();
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to save the project", "Create Project", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid budget value", "Create Project", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid project name or budget", "Create Project", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    

    private boolean saveProject(String title, double budget, String plan, String description) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Data/projects.csv", true))) {
            bw.write(title + "," + budget + "," + plan + "," + description);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
    private void updateProjectList() {
        projectListPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("Data/projects.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] projectData = line.split(",");
                if (projectData.length >= 4) {
                    String projectName = projectData[0];

                    // Create the project button
                    JButton projectButton = new JButton(projectName);
                    projectButton.setHorizontalAlignment(SwingConstants.LEFT);
                    projectButton.setPreferredSize(new Dimension(220, 25));

                    // Create the delete label for each project
                    JLabel deleteLabel = new JLabel("-");
                    deleteLabel.setFont(new Font("", Font.BOLD, 20));
                    deleteLabel.setForeground(Color.RED); // Set text color to red
                    deleteLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Set cursor to hand when hovering

                    deleteLabel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e) {
                            int confirm = JOptionPane.showConfirmDialog(projectListPanel, "Are you sure you want to delete this project?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION) {
                                // Delete the project
                                boolean deleted = deleteProject(projectName);
                                if (deleted) {
                                    JOptionPane.showMessageDialog(projectListPanel, "Project deleted: " + projectName, "Delete Project", JOptionPane.INFORMATION_MESSAGE);
                                    updateProjectList(); // Update the project list on the screen
                                } else {
                                    JOptionPane.showMessageDialog(projectListPanel, "Failed to delete the project", "Delete Project", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    });

                    projectButton.setLayout(new BorderLayout());
                    projectButton.add(deleteLabel, BorderLayout.EAST);
                    projectListPanel.add(projectButton, gbc);
                    gbc.gridy++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        projectListPanel.revalidate();
        projectListPanel.repaint();
    }

    private boolean deleteProject(String projectName) {
        try {
            java.util.List<String> lines = Files.readAllLines(Paths.get("Data/projects.csv"), StandardCharsets.UTF_8);
            java.util.List<String> newLines = new ArrayList<>();

            for (String line : lines) {
                String[] projectData = line.split(",");
                if (projectData.length >= 4) {
                    String existingProjectName = projectData[0];
                    if (!existingProjectName.equals(projectName)) {
                        newLines.add(line);
                    }
                }
            }

            Files.write(Paths.get("Data/projects.csv"), newLines, StandardCharsets.UTF_8);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    private void createMenuBar() {
        menuBar = new JMenuBar();

        // back icon click to go back to UserHomePage
        backsetting = new JMenu();
        ImageIcon backIcon = new ImageIcon("backicon.png");
        Image resizedbackIcon = backIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedbackIcon);
        menuBar.add(backsetting);
        backsetting.setIcon(resizedIcon1);

        backsetting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Go back to UserHomePage
                UserHomePage userHomePage = new UserHomePage();
                userHomePage.setVisible(true);
                dispose();
            }
        });

        // Task icon opens Note and Sign Out
        settingsSection = new JMenu();

        ImageIcon taskIcon = new ImageIcon("taskicon.png");
        Image resizedTaskIcon = taskIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedTaskIcon);

        menuBar.add(Box.createRigidArea(new Dimension(400, 0)));
        settingsSection.setIcon(resizedIcon);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(settingsSection);

        // Add Sign Out task
        JMenuItem signOutMenuItem = new JMenuItem("Sign Out");
        settingsSection.add(signOutMenuItem);

        signOutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add Note task
        JMenuItem noteMenuItem = new JMenuItem("Note");
        settingsSection.add(noteMenuItem);

        noteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Notespage();
            }
        });

        settingsSection.addSeparator();
        setJMenuBar(menuBar);
    }

    public static void main(String[] theArgs) {
        CreateNewProject createNewProject = new CreateNewProject();
        createNewProject.display();    
    }
}
