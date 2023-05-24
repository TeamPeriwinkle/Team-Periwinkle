import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import javax.swing.JFrame;

public class ItemPage extends JFrame {

    private JPanel projectPanel;
    private JMenuBar menuBar;
    private JMenu settingsSection;
    private JMenu backsetting;

    public ItemPage() {
        super("Item");
        display();
        createMenuBar();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void display() {
        projectPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(-350, 10, 10, 10);

        JLabel titleLabel = new JLabel("Items");
        titleLabel.setFont(new Font("", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        projectPanel.add(titleLabel, gbc);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        // backicon click be back UserHomePgae
        backsetting = new JMenu();
        ImageIcon backIcon = new ImageIcon("backicon.png");
        Image resizedbackIcon = backIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon1 = new ImageIcon(resizedbackIcon);
        menuBar.add(backsetting);
        backsetting.setIcon(resizedIcon1);

        backsetting.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //need user Home Page to go back
                UserHomePage userHomePage = new UserHomePage();
                userHomePage.setVisible(true);
                dispose();
            }
        });

        // taskIcon
        settingsSection = new JMenu();
        
        ImageIcon taskIcon = new ImageIcon("taskicon.png");
        Image resizedTaskIcon = taskIcon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedTaskIcon);

        menuBar.add(Box.createRigidArea(new Dimension(400, 0)));
        settingsSection.setIcon(resizedIcon);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(settingsSection);
        

        // //add sign out task
        // JMenuItem signOutMenuItem = new JMenuItem("Sign Out");
        // settingsSection.add(signOutMenuItem);

        // signOutMenuItem.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         System.exit(0);
        //     }
        // });


        // add note task
        JMenuItem noteMenuItem = new JMenuItem("Note");
        settingsSection.add(noteMenuItem);

        noteMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Notespage();
            }
        });

        // add Budget task
        JMenuItem budgetMenuItem = new JMenuItem("Budget");
        settingsSection.add(noteMenuItem);

        budgetMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                About a = new About("Soe", "soehtet2002@gmail.com");
                a.display();
                
            }
        });



        settingsSection.addSeparator();
        setJMenuBar(menuBar);
    }

    public static void main(String[] theArgs) {
        ItemPage itemPage = new ItemPage();
        itemPage.display();    
    }
}
