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
	
	public void setup() {
        JLabel line0 = new JLabel("Version Number:" + VERSIONNUMBER);
		JLabel line1 = new JLabel("This app is registered to: " + firstname);
		JLabel line2 = new JLabel("Email address of the user: " + email);
        JLabel line3 = new JLabel("This app is provided by Team Periwinkle.");
        JLabel line4 = new JLabel("Members of Team Periwinkle:");
        JLabel line5 = new JLabel("Soe Lin, nickname: redpanda1222");
        JLabel line6 = new JLabel("Alex Garcia");
        JLabel line7 = new JLabel("Mahiliet Awasso"); 
        JLabel line8 = new JLabel("Mey Vo");
        JLabel line9 = new JLabel("Charmel Mbala, nickname: LuckyCharms");
        
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
	}
	
	public JPanel getPanel() {
		return myPanel;
	}
}
