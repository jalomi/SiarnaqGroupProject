package sixesWildControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import org.json.JSONException;
import JSONSerializer.LevelJSONSerializer;
import sixesWildEntity.SixesWild;

/**
 * exits the application
 * @author Xuanzhe 
 *
 */
public class ExitController implements ActionListener {
	/** current frame that the controller is initiated in */
	JFrame frame;

	/**
	 * Constructor
	 * @param frame
	 */
	public ExitController(JFrame frame){
		this.frame=frame;
	}
	
	/**
	 * close the current frame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			process();
		} catch (JSONException | IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Stores progress with JSON
	 * @throws JSONException
	 * @throws IOException
	 */
	public void process() throws JSONException, IOException
	{
		SixesWild sw  = SixesWild.newInstance();
		for(int i = 0; i < sw.getLevels().size(); i++) {
			LevelJSONSerializer json = new LevelJSONSerializer(sw.getLevelNames().get(i));
			json.saveSingleLevel(sw.getLevels().get(i));
		}
		if(frame!=null)
			frame.dispose();
	}
}