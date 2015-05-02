package sixesWildBoundary;

import java.awt.*;

import javax.swing.*;

import sixesWildEntity.SixesWild;

/**
 * Initial Splash screen that displays Group member names
 * @author 
 *
 */
@SuppressWarnings("serial")
public class SplashScreen extends JWindow {
	/** duration that the splash screen will be visible for */
	private int duration;
	
	/**
	 * constructor 
	 * @param d input int for how long you want for splash screen to stay in ms.
	 */
	public SplashScreen(int d) {
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
	    this.duration = d;
	}
	
	/**
	 * function for splash screen
	 */
	public void showSplash() {
	    JPanel content = (JPanel)getContentPane();
	    content.setBackground(UIManager.getColor("textHighlight"));
	
	    // Set the window's bounds, centering the window
	    int width = 450;
	    int height =300;
	    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	    int x = (screen.width-width)/2;
	    int y = (screen.height-height)/2;
	    setBounds(x,y,width,height);
	
	    // Build the splash screen
		JLabel lblNewLabel = new JLabel("Team Siarnaq Presents:");
		lblNewLabel.setBounds(34, 44, 236, 26);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Sixes Wild");
		lblNewLabel_1.setBounds(65, 82, 365, 119);
		lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 60));
		
		JLabel lblBykevinSpect = new JLabel(" By: John Lomi, Kevin Specht, Kyle Young, Xuanzhe Wang, Yuheng Huo ");
		lblBykevinSpect.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBykevinSpect.setBounds(22, 213, 422, 16);
			
		content.setLayout(null);
		content.add(lblBykevinSpect);
	    content.add(lblNewLabel);
	    content.add(lblNewLabel_1);
	    content.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.blue));
	
	    // Display it
	    setVisible(true);
	
	    // Wait a little while, maybe while loading resources
	    try { Thread.sleep(duration); } catch (Exception e) {}
	
	    setVisible(false);
	    this.dispose() ;
	}
	
	/**
	 * make the splash screen then exit when duration is over
	 */
	public void showSplashAndExit() {
	    showSplash();
	    System.exit(0);
	}
	
	/**
	 * main for Sixes Wild
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
	    // Throw a nice little title page up on the screen first
	    SplashScreen splash = new SplashScreen(1000);
	    splash.showSplash();
	    
	    //makes the singleton for SixesWild
	    @SuppressWarnings("unused")
		SixesWild game = SixesWild.newInstance() ;
	    
		MainMenuApplication frame = new MainMenuApplication();
		frame.setVisible(true);
	}
}
