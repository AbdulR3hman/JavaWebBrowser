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
 * purpose: to create a button to go forward on the Browser
 */

public class ForwardButton extends JButton implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8404442305936377464L;
	
	
	private Browser jEditorPane;
	
	/**
	 * 
	 * @param Browser 'myB'
	 */
	public ForwardButton(Browser myB) {
		
		super("Forward");
		jEditorPane = myB;
		this.addActionListener(this);
		setForwardButton();
	}

	private void setForwardButton() {

		this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"Forward.png")));
		this.setRolloverEnabled(true);
		this.setToolTipText("Forward");
		this.setFocusPainted(false);
		this.setContentAreaFilled(false);

	}

	/**
	 * To go forward one page at the time each time the button is been clicked.
	 *  
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			int temp = jEditorPane.getHistoryCounterForth();
			String url = jEditorPane.getURL_HisotryList().get(temp);
			jEditorPane.setPage(url);
			jEditorPane.setURL_Field(url);

		} catch (IOException e1) {
			JOptionPane.showMessageDialog(jEditorPane.getJFrame(), "Can not go forward further...");
		}
		
		

	}


}
