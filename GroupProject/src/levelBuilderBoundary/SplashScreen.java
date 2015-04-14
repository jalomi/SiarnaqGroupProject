package levelBuilderBoundary;

import java.awt.*;

import javax.swing.*;

public class SplashScreen extends JWindow {
  private int duration;
  /**
   * constructor 
   * @param d input int for how long you want for splash screen to stay in ms.
   */
  public SplashScreen(int d) {
    this.duration = d;
  }

  /**
   * the splash function 
   */
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);

    // Set the window's bounds, centering the window
    int width = 450;
    int height =300;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);

    // Build the splash screen with team name and game name label.
    
	JLabel lblNewLabel = new JLabel("Team Siarnaq Presents:");
	lblNewLabel.setBounds(34, 44, 241, 45);
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
  }

  public void showSplashAndExit() {
    showSplash();
    System.exit(0);
  }

  public static void main(String[] args) {
    // Throw a nice little title page up on the screen first
    SplashScreen splash = new SplashScreen(5000);
    splash.showSplash();
	try {
		LevelBuilderApplication frame = new LevelBuilderApplication();
		frame.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
    
  }
}
