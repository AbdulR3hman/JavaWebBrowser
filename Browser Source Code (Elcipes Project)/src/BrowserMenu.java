import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class BrowserMenu extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3841477989697919287L;
	
	private Browser jEditorPane;
	public BrowserMenu(Browser myB){
		jEditorPane = myB;
		creatMenuBar();
	}

	private void creatMenuBar() {


		JMenu file = new JMenu("File");
		this.add(file);
		JMenuItem newWindow = new JMenuItem("New Window",KeyEvent.VK_N);
		KeyStroke newWindKeyStroke = KeyStroke.getKeyStroke("control N");
		newWindow.setAccelerator(newWindKeyStroke);

		JMenuItem closeWindow = new JMenuItem("Exit", KeyEvent.VK_N);
		KeyStroke closeKeyStroke = KeyStroke.getKeyStroke("control X");
		closeWindow.setAccelerator(closeKeyStroke);

		file.add(newWindow);
		file.add(new JSeparator());
		file.add(closeWindow);
		
/*		JMenu features = new JMenu("Features");
		this.add(features);
		
		JMenuItem copy = new JMenuItem("Copy", KeyEvent.VK_N);
		KeyStroke copyKeyStroke = KeyStroke.getKeyStroke("control c");
		copy.setAccelerator(copyKeyStroke);

		JMenuItem past = new JMenuItem("Paste", KeyEvent.VK_N);
		KeyStroke pastKeyStroke = KeyStroke.getKeyStroke("control p");
		copy.setAccelerator(pastKeyStroke);
		
		features.add(copy);
		features.add(past);*/


		JMenu help = new JMenu("Help");
		this.add(help);
		JMenuItem about = new JMenuItem("About", KeyEvent.VK_N);
		KeyStroke aboutKeyStroke = KeyStroke.getKeyStroke("alt A");
		about.setAccelerator(aboutKeyStroke);
		help.add(about);

/*
		copy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				text.copy();
			}	
		});
		
		past.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				text.paste();
			}	
		});*/


		closeWindow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				//Display confirm dialog 
				int confirmation = JOptionPane.showConfirmDialog(jEditorPane.getJFrame(), 
						"Are you sure you want to close?", "Confirm!", 
						JOptionPane.YES_NO_OPTION); 

				//Close if user confirmed 
				if (confirmation == JOptionPane.YES_OPTION) 
				{                             
					//Close current opened Window
					jEditorPane.getJFrame().dispose(); 
				} 

			}	
		});

		newWindow.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("unused")
				Browser newBrowser = new Browser();
			}	
		});

		about.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(jEditorPane.getJFrame(),
						"This browser made by AbdulRehman Al-Faraj." +
								"\nElectronic and Computer Engineer Undergraduate" +
								"\nSecond Year." +
								"\nStudent Number: 11014963",
								"About!!",
								JOptionPane.PLAIN_MESSAGE);
			}	
		});

	}
}