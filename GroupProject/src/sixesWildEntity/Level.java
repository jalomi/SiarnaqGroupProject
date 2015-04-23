package sixesWildEntity;

import java.util.HashMap;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * For now I assume that every tile is enabled
 * 
 * 
 */

public class Level {
	public static final String TAG = "Level";
	
	UUID id;
	int levelNumber;
	
	boolean enabled;
	//boolean[][] enabledTiles = new boolean[9][9];
	HashMap<Position, Boolean> enabledTiles = new HashMap<Position, Boolean>() ;
	//columns that has 6s on the top at the beginning of the game(release only)
	boolean[] columnForSixes = new boolean[9];

	double percent[] = new double[7] ;
	double percentM[] = new double[4] ;
		
	int score;
	int starNumber;
	int firstStarScore;
	int secondStarScore;
	int thirdStarScore;
	
	boolean swapEnabled;
	boolean resetEnabled;
	boolean removeEnabled;
	
	//CONSTRUCTORS
	public Level() throws Exception {
		System.out.println("The default constructor should never be called");
		throw new Exception();
	}
	
	public Level(JSONObject json) throws JSONException {
        id = UUID.fromString(json.getString("id"));
        levelNumber = json.getInt("levelNumber");
        
        enabled = json.getBoolean("enabled");
        for(int i = 11; i <= 99; i++) {
        	if(i % 10 != 0){
        		//enabledTiles. = json.getJSONArray("enabledTiles").getJSONArray(i).getBoolean(j); //!
        	}
        	columnForSixes[i] = json.getJSONArray("columnForSixes").getBoolean(i);
        }
        
        for(int i = 0; i < 6; i++){
	        percent[i] = json.getJSONArray("percent").getDouble(i);
        }
        
        for(int i = 0; i < 3; i++){
        	percentM[i] = json.getJSONArray("percentM").getDouble(i) ;
        }
        
        score = json.getInt("score"); //score may not be need to store
        starNumber = json.getInt("starNumber");
        firstStarScore = json.getInt("firstStarScore");
        secondStarScore = json.getInt("secondStarScore");
        thirdStarScore = json.getInt("thirdStarScore");
        
        swapEnabled = json.getBoolean("swapEnabled");
        resetEnabled = json.getBoolean("resetEnabled");
        removeEnabled = json.getBoolean("removeEnabled");
	}
	
	//constructor for testing *******
	public Level(int number) {
		this.id = UUID.randomUUID();
		this.levelNumber = number;
		
		//bad dummy values
		percent[1] = .2 ;
		percent[2] = .2 ;
		percent[3] = .2 ;
		percent[4] = .2 ;
		percent[5] = .1 ;
		percent[6] = .1 ;
		
		percentM[1] = .89 ;
		percentM[2] = .1 ;
		percentM[3] = .01 ;		
		
		firstStarScore = 10;
		secondStarScore = 20;
		thirdStarScore = 30;
		score = 0;
		starNumber = 0;
		
		swapEnabled = false;
		resetEnabled = false;
		removeEnabled = false;
		
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				try {
					enabledTiles.put(new Position(i, j), true) ;
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	public Level(int number, 
				  double p1, double p2, double p3, double p4, double p5, double p6,
				  double m1, double m2, double m3,
				  int first, int second, int third,
				  boolean swap, boolean reset, boolean remove,
				  HashMap<Position, Boolean> enabledTiles) throws Exception {
		if(this.checkPercentageCorrectnes(p1, p2, p3, p4, p5, p6, m1, m2, m3)) {
			this.id = UUID.randomUUID();
			this.levelNumber = number;
			
			this.percent[0] = p1;
			this.percent[1] = p2;
			this.percent[2] = p3;
			this.percent[3] = p4;
			this.percent[4] = p5;
			this.percent[5] = p6;
			
			this.percentM[0] = m1;
			this.percentM[1] = m1;
			this.percentM[2] = m1;
			
			this.firstStarScore = first;
			this.secondStarScore = second;
			this.thirdStarScore = third;
			this.score = 0;
			this.starNumber = 0;
			
			this.swapEnabled = swap;
			this.resetEnabled = reset;
			this.removeEnabled = remove;
			
			this.enabledTiles = enabledTiles;
		} else {
			System.out.print("The percentage is not correct");
			throw new Exception();
		}
	}
	
	//END CONSTRUCTORS
	
	
    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put("id", id.toString());
        json.put("levelNumber", levelNumber);
        
        json.put("enabled", enabled);
        json.put("enabledTiles", enabledTiles); //!
        json.put("columnForSixes", columnForSixes); //!
        
        json.put("percent", percent);
        json.put("percentM", percentM);
        
        json.put("score", score); //score may not be need to store
        json.put("starNumber", starNumber);
        json.put("firstStarScore", firstStarScore);
        json.put("secondStarScore", secondStarScore);
        json.put("thirdStarScore", thirdStarScore);
        
        json.put("swapEnabled", swapEnabled);
        json.put("resetEnabled", resetEnabled);
        json.put("removeEnabled", removeEnabled);
        return json;
    }
	
	//they must add to 1
	private boolean checkPercentageCorrectnes (
			double p1, double p2, double p3, double p4, double p5, double p6,
			double m1, double m2, double m3){
		if(p1 + p2 + p3 + p4 + p5 + p6 == 1 && m1 + m2 + m3 == 1) {
			return true;
		} else {
			return false;
		}
	}

	Square generateSquare() {
		int value = 0;
		int multi = 0;
		double random = Math.random();
		if(random <= percent[0]) {
			value = 1;
		} else if(random <= percent[0] + percent[1]) {
			value = 2;
		} else if(random <= percent[0] + percent[1] + percent[2]) {
			value = 3;
		} else if(random <= percent[0] + percent[1] + percent[2] + percent[3]) {
			value = 4;
		} else if(random <= percent[0] + percent[1] + percent[2] + percent[3] + percent[4]) {
			value = 5;
		} else {
			value = 6;
		}
		
		random = Math.random() ;
		
		if(random <= percentM[0]) {
			multi = 1;
		} else if(random <= percentM[0] + percentM[1]) {
			multi = 2;
		} else {
			multi = 3;
		}
		
		return new Square(value, multi);
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}

	public HashMap<Position, Boolean> getEnabledTiles() {
		return enabledTiles;
	}
	
}
