package levelBuilderBoundary;

import java.awt.*;

import javax.swing.*;

public class SplashScreen extends JWindow {
  private int duration;
  public SplashScreen(int d) {
    duration = d;
  }

  // A simple little method to show a title screen in the center
  // of the screen for the amount of time given in the constructor
  public void showSplash() {
    JPanel content = (JPanel)getContentPane();
    content.setBackground(Color.white);

    // Set the window's bounds, centering the window
    int width = 450;
    int height =200;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);

    // Build the splash screen
	JLabel lblNewLabel = new JLabel("Team Siarnaq Presents:");
	lblNewLabel.setBounds(26, 48, 241, 45);
	lblNewLabel.setFont(new Font("Marlett", Font.BOLD, 20));
	
	JLabel lblNewLabel_1 = new JLabel("Sixes Wild");
	lblNewLabel_1.setBounds(45, 80, 327, 81);
	lblNewLabel_1.setFont(new Font("Matura MT Script Capitals", Font.BOLD, 60));
	content.setLayout(null);
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
