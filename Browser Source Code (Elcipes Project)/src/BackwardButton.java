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
 * purpose: to create a button to go backward on the Browser
 */


public class BackwardButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352227016934312497L;

	private Browser jEditorPane;
	
	/**
	 *  - to create backward button, the class take reference of the Browser and behaves accordingly
	 * @param Browser myB
	 */
	public BackwardButton(Browser myB) {

		super("Back");
		jEditorPane = myB;
		this.addActionListener(this);
		setBackwardButton();
	}

	/**
	 * @param void
	 * To set the backward button features.
	 */
	private void setBackwardButton() {

		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"Backward.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Go Back");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}
	/**
	 * To return one page at the time each time the button is been clicked.
	 *  
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			int temp = jEditorPane.getHistoryCounterBack();
			String url = jEditorPane.getURL_HisotryList().get(temp);
			jEditorPane.setPage(url);
			jEditorPane.setURL_Field(url);
		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
					"Can not go back further...");
		}
	}

}
