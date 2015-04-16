package JSONSerializer;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import sixesWildEntity.Level;

public class JSONTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LevelJSONSerializer j = new LevelJSONSerializer("levels");
		ArrayList<Level> levels = new ArrayList<Level>();
		for(int i = 0; i < 10; i++) {
			levels.add(new Level(i));
		}
		
		try {
			j.saveLevels(levels);
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
