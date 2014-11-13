import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 * 
 * @author Abdul Al-Faraj, Student Number: b1014963
 * @version v1, 13/12/2012
 * 
 *          purpose: to keep track of any new hyperlinke click on by the user
 */
public class ActiveHyperLinkListner implements HyperlinkListener {

	private Browser jEditorPane;

	/**
	 * 
	 * @param Browser
	 *            'myB'
	 */
	public ActiveHyperLinkListner(Browser myB) {

		jEditorPane = myB;

	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see javax.swing.event.HyperlinkListener#hyperlinkUpdate(javax.swing.event.HyperlinkEvent)
	 */
	public void hyperlinkUpdate(HyperlinkEvent e) {

		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
			try {
				jEditorPane.setURL_Field(e.getURL().toString());
				jEditorPane.setPage(e.getURL());
				jEditorPane.addURL_HisotryList(jEditorPane.getPage().toString());

			} catch (IOException io) {
				JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
						"Input/Output Exception");
			}
		}
	}

}
