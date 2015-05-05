package sixesWildEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * The information that the board uses to generate a game
 * @author John
 * @author Kyle
 * @author Xuanzhe 
 *
 */
public abstract class Level {
	/** TAG for this class */
	public static final String TAG = "Level";
	
	/** the number of the level */
	int levelNumber;

	/** the tiles that are enabled */
	boolean[][] enabledTiles = new boolean[9][9];

	/** the percentages for generating square values */
	double percent[] = new double[6] ;
	
	/** the percentages for generating square multipliers */
	double percentM[] = new double[3] ;
		
	/** highest score on this level */
	int highestScore;
	
	/** highest star earned on this level */
	int starNumber = 0;
	
	/** score you need to get 1 star */
	int oneStarScore;
	
	/** score you need to get 2 stars */
	int twoStarScore;
	
	/** score you need to get 3 stars */
	int threeStarScore;
	
	/** flag to tell if level is unlocked yet */
	boolean unlocked ;
	
	/** flag to enable the swap move */
	boolean swapEnabled;
	
	/** flag to enable the shuffle move */
	boolean resetEnabled;
	
	/** flag to enable the remove move */
	boolean removeEnabled;
	
	/**
	 * Constructor for JSON loading
	 * @param json
	 * @throws JSONException
	 */
	public Level(JSONObject json) throws JSONException {
        levelNumber = json.getInt("levelNumber");
        
        for(int i = 0; i < 9; i++) {
        	for(int j = 0; j < 9; j++){
        		enabledTiles[i][j] = json.getJSONArray("enabledTiles").getJSONArray(i).getBoolean(j); //!
        	}
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
	
	/**
	 * Constructor	
	 * @param number
	 * @param p1
	 * @param p2
	 * @param p3
	 * @param p4
	 * @param p5
	 * @param p6
	 * @param m1
	 * @param m2
	 * @param m3
	 * @param first
	 * @param second
	 * @param third
	 * @param unlocked
	 * @param swap
	 * @param reset
	 * @param remove
	 * @param enabledTiles
	 */
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
	
	/**
	 * makes a JSONObject out of this object
	 * @return
	 * @throws JSONException
	 */
    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        //json.put("id", id.toString());
        json.put("levelNumber", levelNumber);
        
        json.put("enabledTiles", enabledTiles); //!
        
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

    /**
     * generates a square based on level parameters
     * @return
     */
	Square generateSquare() {
		int value = 6;
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
	
	/**
	 * gets array of enabled tiles
	 * @return
	 */
	public boolean[][] getEnabledTiles() {
		return enabledTiles;
	}
	
	/**
	 * gets score needed for 1 star
	 * @return
	 */
	public int getFirstStarScore() {
		return this.oneStarScore;
	}
	
	/**
	 * gets score needed for 2 stars
	 * @return
	 */
	public int getSecondStarScore() {
		return this.twoStarScore;
	}
	
	/**
	 * gets score needed for 3 stars
	 * @return
	 */
	public int getThirdStarScore() {
		return this.threeStarScore;
	}
	
	/**
	 * updates the score
	 * @param s
	 */
	public void updateScore(int s) {
		highestScore = highestScore + s ;
	}
	
	/**
	 * gets the highest score
	 * @return
	 */
	public int getHighestScore() {
		return highestScore;
	}
	
	/**
	 * gets the level number
	 * @return
	 */
	public int getLevelNumber() {
		return levelNumber;
	}
	
	/**
	 * gets the number of stars earned
	 * @return
	 */
	public int getStarNumber() {
		return starNumber;
	}
	
	/**
	 * checks if level is unlocked
	 * @return
	 */
	public boolean getUnlocked(){
		return unlocked ;
	}
	
	/**
	 * sets the unlocked state of the level
	 * @param unlocked
	 */
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked ;
	}

	/**
	 * gets the percents for values
	 * @return
	 */
	public double[] getPercent() {
		return percent;
	}

	/**
	 * gets the percents for multipliers
	 * @return
	 */
	public double[] getPercentM() {
		return percentM;
	}

	/**
	 * gets the score needed for 1 star
	 * @return
	 */
	public int getOneStarScore() {
		return oneStarScore;
	}

	/**
	 * gets the score needed for 2 stars
	 * @return
	 */
	public int getTwoStarScore() {
		return twoStarScore;
	}

	/** 
	 * gets the score needed for 3 stars
	 * @return
	 */
	public int getThreeStarScore() {
		return threeStarScore;
	}

	/**
	 * gets the flag for enabling swap moves
	 * @return
	 */
	public boolean isSwapEnabled() {
		return swapEnabled;
	}

	/**
	 * gets the flag for enabling shuffle moves
	 * @return
	 */
	public boolean isResetEnabled() {
		return resetEnabled;
	}

	/**
	 * gets the flag for enabling remove moves
	 * @return
	 */
	public boolean isRemoveEnabled() {
		return removeEnabled;
	}

	/**
	 * sets the number of the level
	 * @param levelNumber
	 */
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	/**
	 * sets the enabled tiles
	 * @param enabledTiles
	 */
	public void setEnabledTiles(boolean[][] enabledTiles) {
		this.enabledTiles = enabledTiles;
	}

	/**
	 * sets the percentages for values
	 * @param percent
	 */
	public void setPercent(double[] percent) {
		this.percent = percent;
	}

	/**
	 * sets the percentages for multipliers
	 * @param percentM
	 */
	public void setPercentM(double[] percentM) {
		this.percentM = percentM;
	}

	/**
	 * sets the high score
	 * @param score
	 */
	public void setHighestScore(int score) {
		this.highestScore = score;
	}

	/**
	 * sets the number of stars earned
	 * @param starNumber
	 */
	public void setStarNumber(int starNumber) {
		this.starNumber = starNumber;
	}

	/**
	 * sets the score needed for 1 star
	 * @param oneStarScore
	 */
	public void setOneStarScore(int oneStarScore) {
		this.oneStarScore = oneStarScore;
	}

	/**
	 * sets the score needed for 2 stars
	 * @param twoStarScore
	 */
	public void setTwoStarScore(int twoStarScore) {
		this.twoStarScore = twoStarScore;
	}

	/**
	 * sets the score needed for 3 stars
	 * @param threeStarScore
	 */
	public void setThreeStarScore(int threeStarScore) {
		this.threeStarScore = threeStarScore;
	}

	/**
	 * sets the flag for enabling swap moves
	 * @param swapEnabled
	 */
	public void setSwapEnabled(boolean swapEnabled) {
		this.swapEnabled = swapEnabled;
	}

	/**
	 * sets the flag for enabling shuffle moves
	 * @param resetEnabled
	 */
	public void setResetEnabled(boolean resetEnabled) {
		this.resetEnabled = resetEnabled;
	}

	/**
	 * sets the flag for enabling remove moves
	 * @param removeEnabled
	 */
	public void setRemoveEnabled(boolean removeEnabled) {
		this.removeEnabled = removeEnabled;
	}
	
	/** gets the type of level */
	public abstract String getLevelType();
	
	/** gets the moves left */
	public abstract String getMovesRemainingString();
	
	/** gets the time left */
	public abstract String getTimeRemainingString();
	
	/** gets the moves left */
	public abstract int getMovesRemaining();
	
	/** gets the time left */
	public abstract int getTimeRemaining();
	
	/** decrements the moves left */
	public abstract void updateMovesLeft(int m);
	
	/** decrements the time left */
	public abstract void updateTimeLeft(int t);
	
	/** checks to see if the game is over */
	public abstract boolean gameOver();
	
	/** checks to see if the player has won the game */
	public abstract boolean hasWon();
	
	/** gets the buckets for release */
	public abstract boolean[] getBuckets();
	
}
