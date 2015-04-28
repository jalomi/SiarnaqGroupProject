package JSONSerializer;

import java.io.IOException;
import org.json.JSONException;

import sixesWildEntity.Puzzle;

public class JSONTest {

	public static void main(String[] args) {
		LevelJSONSerializer j = new LevelJSONSerializer("puzzle1.json");
//		ArrayList<Level> levels = new ArrayList<Level>();
//		for(int i = 0; i < 10; i++) {
//			levels.add(new Puzzle(i, 20));
//		}
		Puzzle p1 = new Puzzle(1, 30);
		
		try {
			j.saveSingleLevel(p1);
			Puzzle p2  = (Puzzle) j.loadSingleLevel("Puzzle");
			/*
			 * newLevels is exact same as levels
			 */
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
