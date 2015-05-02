package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

/*
 * For now I assume that every tile is enabled
 * 
 * 
 */

public abstract class Level {
	public static final String TAG = "Level";
	
	int levelNumber;

	boolean[][] enabledTiles = new boolean[9][9];
	//columns that has 6s on the top at the beginning of the game(release only)
	boolean[] columnForSixes = new boolean[9];

	double percent[] = new double[6] ;
	double percentM[] = new double[3] ;
		
	int highestScore;
	int starNumber = 0;
	int oneStarScore;
	int twoStarScore;
	int threeStarScore;
	
	boolean unlocked ;
	boolean swapEnabled;
	boolean resetEnabled;
	boolean removeEnabled;
	
	//CONSTRUCTORS
	public Level(JSONObject json) throws JSONException {
       // id = UUID.fromString(json.getString("id"));
        levelNumber = json.getInt("levelNumber");
        
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++){
        		enabledTiles[i][j] = json.getJSONArray("enabledTiles").getJSONArray(i).getBoolean(j); //!
        	}
        	columnForSixes[i] = json.getJSONArray("columnForSixes").getBoolean(i);
        }
        
        for(int i = 0; i < 6; i++){
	        percent[i] = json.getJSONArray("percent").getDouble(i);
        }
        
        for(int i = 0; i < 3; i++){
        	percentM[i] = json.getJSONArray("percentM").getDouble(i) ;
        }
        
        highestScore = json.getInt("score"); //score may not be need to store
        starNumber = json.getInt("starNumber");
        oneStarScore = json.getInt("firstStarScore");
        twoStarScore = json.getInt("secondStarScore");
        threeStarScore = json.getInt("thirdStarScore");
        
        unlocked = json.getBoolean("unlocked") ;
        swapEnabled = json.getBoolean("swapEnabled");
        resetEnabled = json.getBoolean("resetEnabled");
        removeEnabled = json.getBoolean("removeEnabled");
	}
	
	//constructor for testing *******
	public Level(int number) {
		//this.id = UUID.randomUUID();
		this.levelNumber = number;
		
		//bad dummy values
		percent[0] = .3 ;
		percent[1] = .3 ;
		percent[2] = .15 ;
		percent[3] = .1 ;
		percent[4] = .1 ;
		percent[5] = .05 ;
		
		percentM[0] = .7 ;
		percentM[1] = .2 ;
		percentM[2] = .1 ;		
		
		oneStarScore = 1000;
		twoStarScore = 4000;
		threeStarScore = 9000;
		highestScore = 0;
		starNumber = 0;
		
		unlocked = true ;
		swapEnabled = false;
		resetEnabled = false;
		removeEnabled = false;
		
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				try {
					enabledTiles[i][j] = true ;
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}
	
	public Level(int number, 
				  double p1, double p2, double p3, double p4, double p5, double p6,
				  double m1, double m2, double m3,
				  int first, int second, int third,
				  boolean unlocked, boolean swap, boolean reset, boolean remove,
				  boolean[][] enabledTiles){
		
		this.levelNumber = number;
		
		this.percent[0] = p1;
		this.percent[1] = p2;
		this.percent[2] = p3;
		this.percent[3] = p4;
		this.percent[4] = p5;
		this.percent[5] = p6;
		
		this.percentM[0] = m1;
		this.percentM[1] = m2;
		this.percentM[2] = m3;
		
		this.oneStarScore = first;
		this.twoStarScore = second;
		this.threeStarScore = third;
		this.highestScore = 0;
		this.starNumber = 0;
		
		this.unlocked = unlocked ;
		this.swapEnabled = swap;
		this.resetEnabled = reset;
		this.removeEnabled = remove;
		
		this.enabledTiles = enabledTiles;
	}
	
	//END CONSTRUCTORS
	
	
    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        //json.put("id", id.toString());
        json.put("levelNumber", levelNumber);
        
        json.put("enabledTiles", enabledTiles); //!
        json.put("columnForSixes", columnForSixes); //!
        
        json.put("percent", percent);
        json.put("percentM", percentM);
        
        json.put("score", highestScore); //score may not be need to store
        json.put("starNumber", starNumber);
        json.put("firstStarScore", oneStarScore);
        json.put("secondStarScore", twoStarScore);
        json.put("thirdStarScore", threeStarScore);
        
        json.put("unlocked", unlocked) ;
        json.put("swapEnabled", swapEnabled);
        json.put("resetEnabled", resetEnabled);
        json.put("removeEnabled", removeEnabled);
        return json;
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
	
	public boolean[][] getEnabledTiles() {
		return enabledTiles;
	}
	
	public int getFirstStarScore() {
		return this.oneStarScore;
	}
	
	public int getSecondStarScore() {
		return this.twoStarScore;
	}
	
	
	public int getThirdStarScore() {
		return this.threeStarScore;
	}
	
	public void updateScore(int s) {
		highestScore = highestScore + s ;
	}
	
	public int getHighestScore() {
		return highestScore;
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}
	
	public int getStarNumber() {
		return starNumber;
	}
	
	public boolean getUnlocked(){
		return unlocked ;
	}
	
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked ;
	}

	public boolean[] getColumnForSixes() {
		return columnForSixes;
	}

	public double[] getPercent() {
		return percent;
	}

	public double[] getPercentM() {
		return percentM;
	}

	public int getOneStarScore() {
		return oneStarScore;
	}

	public int getTwoStarScore() {
		return twoStarScore;
	}

	public int getThreeStarScore() {
		return threeStarScore;
	}

	public boolean isSwapEnabled() {
		return swapEnabled;
	}

	public boolean isResetEnabled() {
		return resetEnabled;
	}

	public boolean isRemoveEnabled() {
		return removeEnabled;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public void setEnabledTiles(boolean[][] enabledTiles) {
		this.enabledTiles = enabledTiles;
	}

	public void setColumnForSixes(boolean[] columnForSixes) {
		this.columnForSixes = columnForSixes;
	}

	public void setPercent(double[] percent) {
		this.percent = percent;
	}

	public void setPercentM(double[] percentM) {
		this.percentM = percentM;
	}

	public void setHighestScore(int score) {
		this.highestScore = score;
	}

	public void setStarNumber(int starNumber) {
		this.starNumber = starNumber;
	}

	public void setOneStarScore(int oneStarScore) {
		this.oneStarScore = oneStarScore;
	}

	public void setTwoStarScore(int twoStarScore) {
		this.twoStarScore = twoStarScore;
	}

	public void setThreeStarScore(int threeStarScore) {
		this.threeStarScore = threeStarScore;
	}

	public void setSwapEnabled(boolean swapEnabled) {
		this.swapEnabled = swapEnabled;
	}

	public void setResetEnabled(boolean resetEnabled) {
		this.resetEnabled = resetEnabled;
	}

	public void setRemoveEnabled(boolean removeEnabled) {
		this.removeEnabled = removeEnabled;
	}
	
	public abstract String getLevelType();
	public abstract String getMovesRemainingString();
	public abstract String getTimeRemainingString();
	public abstract int getMovesRemaining();
	public abstract int getTimeRemaining();
	public abstract void updateMovesLeft(int m);
	public abstract void updateTimeLeft(int t);
	public abstract boolean gameOver();
	public abstract boolean hasWon();
	
}
