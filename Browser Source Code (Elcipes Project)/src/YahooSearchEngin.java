
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 * 
 * @author Abdul AL-Faraj Student ID b1014963
 * @version v1, 13/12/2012
 * 
 * description: To provide search engine and search button.
 * 
 */

@SuppressWarnings("serial")
public class YahooSearchEngin extends JPanel {

	private JButton searchButton;
	private JTextField searchTextFeild;
	private String searchQuery;
	private final String YAHOO_ENGIN = "http://search.yahoo.com/bin/search?p=";
	private Browser jEditorPane;
	
	/**
	 * purpose: to make an instance of YahooSearchEngin 
	 * @param new Browser called myB
	 */
	
	
	public YahooSearchEngin(Browser myB) {

		jEditorPane = myB;

		setSearchButton();
		setSearchText();
		FlowLayout searchLayout = new FlowLayout();
		this.setLayout(searchLayout);
		this.add(searchButton);
		this.add(searchTextFeild);
		

	}

	/**
	 * To set the search text field of the search engine.
	 * @param void
	 */
	private void setSearchText() {

		searchTextFeild = new JTextField("Yahoo!");
		searchTextFeild.setPreferredSize(new Dimension(150,25));
	}

	/**
	 * To set the search button and add an action listner.
	 * @param void
	 */
	private void setSearchButton() {

		searchButton = new JButton("Search");

		searchButton.addActionListener(new ActionListener() {

			/**
			 * Implement an action perform method
			 * it will search for the current text inside the text field.
			 */
			public void actionPerformed(ActionEvent e) {

				searchQuery = searchTextFeild.getText();

				try {
					
					jEditorPane.setPage((YAHOO_ENGIN + searchQuery));
					jEditorPane.setURL_Field(jEditorPane.getPage().toString());
					jEditorPane.addURL_HisotryList((YAHOO_ENGIN + searchQuery));
		
				} catch (IOException e1) {
					JOptionPane
							.showMessageDialog(jEditorPane.getJFrame(),
									"Cannot deal with your search query, please try again");
				}

			}
		});

		/**
		 * purpose: set the look of the button
		 */
		searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("Search.png")));
		searchButton.setRolloverEnabled(true);
		searchButton.setToolTipText("Search");
		searchButton.setFocusPainted(false);
		searchButton.setContentAreaFilled(false);

	}

}
