import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Notespage {
    JFrame window;
    JMenuBar menuBar;
    JMenu settingsSection;

    public static void main(String[] args) {
        new Notespage();
    }

    public Notespage() {
        createWindow();
        createMenuBar();

        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notes");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        // Create the menu bar
        menuBar = new JMenuBar();//homeicon
        window.getContentPane().add(menuBar, BorderLayout.NORTH);
    }


    public void createMenuBar() {
        settingsSection = new JMenu();

        // Create the home icon
        ImageIcon homeIcon = new ImageIcon("homeicon.png");
        Image resizedHomeIcon = homeIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedHomeIcon);

        settingsSection.setIcon(resizedIcon);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(settingsSection);

        // Add a mouse listener to the home icon button
        settingsSection.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //need user Home Page to go back
                UserHomePage userHomePage = new UserHomePage();
                userHomePage.setVisible(true);
                window.dispose();
            }
        });
    }
}

