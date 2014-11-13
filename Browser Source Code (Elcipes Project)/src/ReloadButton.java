import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 * 
 * @author Abul Al-Faraj b1014963
 * @version v1, 13/12/2012
 * 
 * purpose: to create a button to reload ( refresh ) the current page on the Browser.
 */
@SuppressWarnings("serial")
public class ReloadButton extends JButton implements ActionListener {

	private Browser jEditorPane;
	
	/**
	 * 
	 * @param Browser 'myB' 
	 */
	public ReloadButton(Browser myB) {
		
		super("Refresh");
		jEditorPane = myB;
		myB.getJFrame();
		this.addActionListener(this);
		setReloadIcon();

	}

	/**
	 * To perform a refresh structure for the browser.
	 */
	public void actionPerformed(ActionEvent e) {

		try {
			
			jEditorPane.setPage(jEditorPane.getPage().toString());
			jEditorPane.setURL_Field(jEditorPane.getPage().toString());
			jEditorPane.repaint();
			
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Page Cannot Be Reloaded (Refreshed).");
		}

	}

	/**
	 * Set the features of the reload icon
	 * @param void
	 */
	private void setReloadIcon() {

		
		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"refresh.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Reload Page");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

}
