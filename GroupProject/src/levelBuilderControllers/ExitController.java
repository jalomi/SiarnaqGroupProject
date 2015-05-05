package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import levelBuilderEntity.LevelBuilder;
import JSONSerializer.LevelJSONSerializer;
/**
 * A controller that close the level builder frame and terminates the program,
 * and also saves the levels that have been made to a level list
 * @author Yuheng
 *
 */
public class ExitController implements ActionListener{
	JFrame frame ;
	
	public ExitController(JFrame frame){
		this.frame = frame ;
	}
	/**
	 * the action performed when the exit button selected
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	/**
	 * saves the levels to a level list
	 * close the level builder window, and terminates the program
	 */
	public void process()
	{
		if(frame != null){
			LevelJSONSerializer json = new LevelJSONSerializer("Level List.json");
			try {
				json.saveLevelList(LevelBuilder.getLevelList());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			frame.dispose() ;
		}
	}

}
