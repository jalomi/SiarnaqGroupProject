package sixesWildEntity;

public class Board {
	Level currentLevel;
	Tile[][] theMap;
	/**
	 * The constructor for board class.
	 * @param cLevel
	 */
	public Board (Level cLevel){
		this.currentLevel = cLevel;
		this.theMap = new Tile[9][9];
		
	}
	
	void setLevel(Level newLevel){
		this.currentLevel = newLevel;
	}
	
	Level getLevel(){
		return this.currentLevel;
	}
	
	int getScore(){
		//this is just a stub
		return 0;
	}
	
	void updateBoard(){
		//I don't know what to put in here.
	}
	
	boolean hasWon(){
		//code here
		return true;
		
	}
	
	
}
