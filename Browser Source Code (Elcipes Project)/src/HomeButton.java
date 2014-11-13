import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * 
 * @author Abdul Al-Faraj, Student Number: b1014963
 * @version v1, 13/12/2012
 * 
 * purpose: to create a button to redirect the Browser to a home page.
 */

@SuppressWarnings("serial")
public class HomeButton extends JButton implements ActionListener {

	private Browser jEditorPane;
	
	/**
	 * 
	 * @param take Browser as parameter.
	 */
	public HomeButton(Browser myB) {

		super("Home");
		jEditorPane = myB;
		setHomeIcon();
		this.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		try {

			jEditorPane.setURL_Field(jEditorPane.getHomePage());
			jEditorPane.setPage(jEditorPane.getHomePage());
			jEditorPane.addURL_HisotryList(jEditorPane.getHomePage());

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Problem, Can not be redircted to home page.");
		}
	}

	/**
	 * @param void
	 * To set the features of the home icon.
	 */
	private void setHomeIcon() {


		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"Home.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Home Button");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

}
