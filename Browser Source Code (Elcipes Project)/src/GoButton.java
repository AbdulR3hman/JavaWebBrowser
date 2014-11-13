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
 * purpose: to create a button to redirect the Browser to a user-specified page.
 */

@SuppressWarnings("serial")
public class GoButton extends JButton implements ActionListener {

	private String goURL;
	private Browser jEditorPane;

	/**
	 * 
	 * @param Browsers 'myB' 
	 */
	public GoButton(Browser myB) {

		super("Go");
		jEditorPane = myB;
		this.addActionListener(this);
		setGoIcon();

	}

	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {

		goURL = jEditorPane.getURlLink().getText();

		if (!checkHTTP(goURL)) {
			goURL = "http://" + goURL;
		}

		try {
			jEditorPane.setURL_Field(goURL);
			jEditorPane.setPage(goURL);
			jEditorPane.addURL_HisotryList(goURL);
			jEditorPane.setURL_Field(goURL);

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Error with link..... Please try different one");
		}
	}

	private boolean checkHTTP(String s) {

		int intIndex = s.indexOf("http://");

		return (intIndex >= 0) ? true : false;

	}

	/**
	 * @param void
	 * Set the features of the go button icon
	 */
	private void setGoIcon() {

		this.setToolTipText("Go");
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource("Go.png")));
		this.setRolloverEnabled(true);
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

}
