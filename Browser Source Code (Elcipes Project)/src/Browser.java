import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
/**
 * 
 * @author Abdul Al-Faraj, Student ID b1014963
 * @version v3, 13/12/2012
 * 
 * This is the class where it implements and includes all the other class, buttons or Tool Bar
 * It extends from JEditor Pane, and it behaves as basic HTML page browser.
 *
 */


public class Browser extends JEditorPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6030691123934444964L;
	
	private String homePageURL; 
	private JFrame webFrame;
	private JTextField urlLinkTextField;
	private ActiveHyperLinkListner hyperListner;
	private ArrayList<String> urlHistoryList;
	private int url_HistoryIndex;

	/**
	 * To create browser with default homePage
	 */
	public Browser() {

		homePageURL = "http://www.java2s.com";
		urlLinkTextField = new JTextField(homePageURL);
		urlHistoryList = new ArrayList<String>();
		iniatBrowser();
	}

	/**
	 * To create browser with specified homePage
	 */
	public Browser(String url) throws IOException {
		super(url);
		urlLinkTextField = new JTextField(homePageURL);
		homePageURL = url;
		iniatBrowser();

	}

	/**
	 * @param void
	 * 
	 * It will create the main body of the JFrame, which is called the WebFrame.
	 * 
	 */
	void iniatBrowser() {

		// Creating Web Frame.
		webFrame = new JFrame("Abdul Al-Faraj: Simple Java HTML Broswer");
		setJFrameIcon();
		setMenuBar();
		webFrame.setLayout(new BorderLayout());

		JPanel webPanel = getWebPanel();

		// To create 2 main area in the browser.
		JPanel northPanel = getNorthPanel();

		webFrame.add(webPanel, BorderLayout.CENTER);
		webFrame.add(northPanel, BorderLayout.NORTH);

		webFrame.getContentPane();

		webFrame.pack();
		webFrame.setSize(1170, 610);
		webFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		webFrame.setVisible(true);

	}

	/**
	 * To return JPanel to be inserted in the North side of the JFrame.
	 * This Panel will include all the buttons and the search engine.
	 * @param  void
	 * @return JPanel 
	 */
	private JPanel getNorthPanel() {

		JPanel north = new JPanel();
		JPanel northWest = new JPanel();
		JPanel northEast = new JPanel();

		FlowLayout northWestLayout = new FlowLayout();
		north.setSize(new Dimension(200, 10));

		north.setLayout(northWestLayout);
		northWest.setLayout(northWestLayout);
		northEast.setLayout(northWestLayout);

		HomeButton homePageButton = new HomeButton(this);
		GoButton goButton = new GoButton(this);
		ReloadButton refresh = new ReloadButton(this);
		YahooSearchEngin temp = new YahooSearchEngin(this);
		BackwardButton backButton = new BackwardButton(this);
		ForwardButton frothButton = new ForwardButton(this);
		urlLinkTextField.setPreferredSize(new Dimension(300, 25));
		urlLinkTextField.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				setpage(urlLinkTextField.getText());
			}

		});
		north.add(northWest, BorderLayout.WEST);
		north.add(northEast, BorderLayout.EAST);

		northWest.add(homePageButton);
		northWest.add(backButton);
		northWest.add(frothButton);
		northWest.add(refresh);
		northWest.add(goButton);
		northWest.add(urlLinkTextField);
		northEast.add(temp);

		return north;

	}

	/**
	 * To return JPanel to be inserted in the Centre side of the JFrame.
	 * 
	 * @param  void
	 * @return JPanel 
	 */
	private JPanel getWebPanel() {

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());

		this.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(this);
		center.add(scrollPane, BorderLayout.CENTER);
		hyperListner = new ActiveHyperLinkListner(this);
		this.addHyperlinkListener(hyperListner);
		setpage(getHomePage());
		return center;
	}

	/**
	 * It takes a String URL and sets the browser page to it.
	 * @param url
	 */
	private void setpage(String url){

		try {
			setURL_Field(url);
			this.setPage(url);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		addURL_HisotryList(this.getPage().toString());
	}

	/**
	 * To set the look of the JFrame icon
	 */
	private void setJFrameIcon() {

		webFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("JFrameIcon.png")));

	}
	/**
	 * To set the URL text field to certain page
	 * @param newUrl
	 */
	public void setURL_Field(String newUrl) {
		urlLinkTextField.setText(newUrl);
	}

	/**
	 * To return home page to be used by other class
	 * @return String homePageURL
	 */
	public String getHomePage() {

		return homePageURL;
	}

	/**
	 * To return decremented  history counter, to be used by the backward button.
	 * @return integer history counter
	 */
	public int getHistoryCounterBack() {

		url_HistoryIndex--;
		if (url_HistoryIndex < 0){
			url_HistoryIndex = 0;
		}
		return url_HistoryIndex;

	}

	/**
	 * To return incremented  history counter, to be used by the forward button.
	 * @return History Counter
	 */
	 
	public int getHistoryCounterForth() {

		url_HistoryIndex++;
		if (url_HistoryIndex >= urlHistoryList.size()){
			url_HistoryIndex = urlHistoryList.size()-1;
		}
		return url_HistoryIndex;

	}

	/**
	 * 
	 * @return JFrame
	 */
	public JFrame getJFrame() {

		return webFrame;
	}

	/**
	 * To return the URL text field.
	 * @return urlLink 
	 */
	public JTextField getURlLink() {

		return urlLinkTextField;

	}

	/**
	 * To return history list of the browsed pages.
	 * @return urlHistoryList 
	 */
	public ArrayList<String> getURL_HisotryList() {

		return urlHistoryList;
	}

	/**
	 * To add newly browsed pages to the History List.
	 * @param element 
	 */
	public void addURL_HisotryList(String elem) {

		urlHistoryList.add(elem);
		url_HistoryIndex = urlHistoryList.size()-1;

	}
	
	/**
	 * To add a menu bar to the frame.
	 */
	private void setMenuBar(){
		
		BrowserMenu menuBar = new BrowserMenu(this);
		webFrame.setJMenuBar(menuBar);
	}

}
