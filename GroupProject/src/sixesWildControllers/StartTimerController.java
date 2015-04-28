package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

import sixesWildBoundary.LevelSelectApplication;
import sixesWildBoundary.SixesWildLevelPanel;
import sixesWildEntity.LTimer;

public class StartTimerController implements ActionListener{
	
	LevelSelectApplication app ;
	SixesWildLevelPanel panel ;
	
	public StartTimerController(LevelSelectApplication app, SixesWildLevelPanel l){
		this.app = app ;
		this.panel = l ;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		LTimer t = LTimer.getInstance();
		
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				// HACK. Should be in a model someplace
				//int val = Integer.valueOf(app.getTimerLabel().getText());
				//val += 1;
				//app.getTimerLabel().setText("" + val);
			}
			
		};
		
		t.schedule(task, 1000);
	}

}
