package JSONSerializer;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import sixesWildEntity.Level;

public class JSONTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelJSONSerializer j = new LevelJSONSerializer("levels.json");
		ArrayList<Level> levels = new ArrayList<Level>();
		for(int i = 0; i < 10; i++) {
			levels.add(new Level(i));
		}
		
		try {
			j.saveLevels(levels);
			ArrayList<Level> newLevels = j.loadLevels();
			/*
			 * newLevels is exact same as levels
			 */
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
