//About
//Soe Lin

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About {
	
    private static final String VERSIONNUMBER = " 0.1";
	private String firstname;
	private String email;
	private JPanel myPanel;

	
	public About(String theName, String theEmail) {
		firstname = theName;
		email = theEmail;
		myPanel = new JPanel();
	}
<<<<<<< Updated upstream
	
	public void setup() {
=======

    public void display() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        JLabel titleLabel = new JLabel("About");
        titleLabel.setFont(new Font("", Font.BOLD, 24));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        this.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(myPanel, gbc);

        JButton backButton = new JButton("Back");
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        this.add(backButton, gbc);

>>>>>>> Stashed changes
        JLabel line0 = new JLabel("Version Number:" + VERSIONNUMBER);
		JLabel line1 = new JLabel("This app is registered to: " + firstname);
		JLabel line2 = new JLabel("Email address of the user: " + email);
        JLabel line3 = new JLabel("This app is provided by Team Periwinkle.");
        JLabel line4 = new JLabel("Members of Team Periwinkle:");
        JLabel line5 = new JLabel("Soe Lin, nickname: redpanda1222");
        JLabel line6 = new JLabel("Alex Garcia, nickname: froabble");
        JLabel line7 = new JLabel("Mahiliet Awasso, nickname: mahi"); 
        JLabel line8 = new JLabel("Mey Vo, nickname: meyww");
        JLabel line9 = new JLabel("Charmel Mbala, nickname: luckycharms0");
        
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(line0);
        myPanel.add(line1);
        myPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        myPanel.add(line2);
        myPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        myPanel.add(line3);
        myPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        myPanel.add(line4);
        myPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        myPanel.add(line5);
        myPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        myPanel.add(line6);
        myPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        myPanel.add(line7);
        myPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        myPanel.add(line8);
        myPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        myPanel.add(line9);
<<<<<<< Updated upstream
	}
	
	public JPanel getPanel() {
		return myPanel;
	}
=======
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                //need user Home Page to go back
                UserHomePage userHomePage = new UserHomePage();
                userHomePage.setVisible(true);
            
            }
        });

        this.setLocationRelativeTo(null);
        this.setVisible(true);

	}

    public static void main(String[] theArgs) {
        About a = new About("Soe", "soehtet2002@gmail.com");
        a.display();
    }
>>>>>>> Stashed changes
}
