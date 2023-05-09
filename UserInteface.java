import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserInteface {
    private String name;
    private String email;
    private JPanel myPanel;

    public UserInteface(String theName, String theEmail) {
        name = theName;
        email = theEmail;
        myPanel = new JPanel();
    }

}
