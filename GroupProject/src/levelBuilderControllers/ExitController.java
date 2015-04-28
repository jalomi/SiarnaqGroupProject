package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;

import levelBuilderEntity.LevelBuilder;
import JSONSerializer.LevelJSONSerializer;

public class ExitController implements ActionListener{
	JFrame frame ;
	
	public ExitController(JFrame frame){
		this.frame = frame ;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
