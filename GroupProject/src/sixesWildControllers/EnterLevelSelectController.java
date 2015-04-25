package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.MainMenuApplication;
import sixesWildEntity.SixesWild;

public class EnterLevelSelectController implements ActionListener {
	
	public static final String TAG = "EnterLevelSelectController";
	
	MainMenuApplication m;
	
	public EnterLevelSelectController(MainMenuApplication menu) {
		this.m = menu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(TAG);
		
		m.dispose();
		LevelSelectApplication levelSelectApp = new LevelSelectApplication(SixesWild.newInstance());
		levelSelectApp.setVisible(true);	
	}  
}
