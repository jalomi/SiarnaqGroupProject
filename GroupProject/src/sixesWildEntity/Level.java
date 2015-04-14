package sixesWildEntity;

public class Level {
	//variables and data store in level.
	int levelNumber;
	int score;
	boolean[][] tileActive;
	int firstStarScore;
	int secondStarScore;
	int thirdStarScore;
	//chance for each number to appear on each tile.
	float percent1;
	float percent2;
	float percent3;
	float percent4;
	float percent5;
	float percent6;
	//chance for each multiplier to appear on each tile
	float percentB2;
	float percentB3;
	//special moves
	boolean allowRest;
	boolean allowSwap;
	boolean allowRemove;
	//columns that has 6s on the top at the beginning of the game(release only)
	boolean[] columnForSixes;
	
	public Level(){
		//counters for initialize variables
		int i;
		int j;
		//variables and data store in level.
		this.levelNumber = 0;
		 this.score = 0;
		this.tileActive = new boolean[9][9];
		for(i=0;i<9;i++){
			for(j=0;j<9;j++){
				this.tileActive[i][j] = false; 
			}
		}
		this.firstStarScore = 0;
		this.secondStarScore = 0;
		this.thirdStarScore = 0;
		//chance for each number to appear on each tile.
		this.percent1 = 0;
		this.percent2 = 0;
		this.percent3 = 0;
		this.percent4 = 0;
		this.percent5 = 0;
		this.percent6 = 0;
		//chance for each multiplier to appear on each tile
		this.percentB2 = 0;
		this.percentB3 = 0;
		//special moves
		this.allowRest = false;
		this.allowSwap = false;
		this.allowRemove= false;;
		//columns that has 6s on the top at the beginning of the game(release only)
		this.columnForSixes = new boolean [9];
		for(i=0;i<9;i++){
			this.columnForSixes[i] = false;
		}
		
	}
//getter and setter for all the variables(we can change them later) 
	public int getScore(){
		return this.score;
	}
	
	public void updateScore(int s){
		this.score = s;
	}
	
	public void setFirstStarScore(int s){
		this.firstStarScore = s;
	}
	 public int getFirstSarScore(){
		 return this.firstStarScore;
	 }
	 
	 public void setSecondStarScore(int s){
		 this.secondStarScore = s;
	 }
	 public int getSecondSarScore(){
		 return this.secondStarScore;
	 }

	 public void setThirdStarScore(int s){
		 this.thirdStarScore = s;
	 }
	 public int getThirdSarScore(){
		 return this.thirdStarScore;
	 }
	 
	 public float getPercent1(){
		 return this.percent1;
	 }
	 public void setPercent1(float s){
		 this.percent1 = s;
	 }

	 public float getPercent2(){
		 return this.percent2;
	 }
	 public void setPercent2(float s){
		 this.percent2 = s;
	 }

	 public float getPercent3(){
		 return this.percent3;
	 }
	 public void setPercent3(float s){
		 this.percent3 = s;
	 }

	 public float getPercent4(){
		 return this.percent4;
	 }
	 public void setPercent4(float s){
		 this.percent4 = s;
	 }

	 public float getPercent5(){
		 return this.percent5;
	 }
	 public void setPercent5(float s){
		 this.percent5 = s;
	 }
	 
	 public float getPercent6(){
		 return this.percent6;
	 }
	 public void setPercent6(float s){
		 this.percent6 = s;
	 }
	 
	 public void setAllowReset(boolean b){
		 this.allowRest = b;
	 }
	 public boolean getAllowReset(boolean b){
		 return this.allowRest;
	 }
	 
	 public void setAllowSwap(boolean b){
		 this.allowRest = b;
	 }
	 public boolean getAllowSwap(boolean b){
		 return this.allowRest;
	 }
	 
	 public void setAllowRemove(boolean b){
		 this.allowRest = b;
	 }
	 public boolean getAllowRemove(boolean b){
		 return this.allowRemove;
	 }
	 public void setTileActive(int col, int row){
		 this.tileActive[col][row] = true;
	 }
	 public void setTileDeactive(int col, int row){
		 this.tileActive[col][row] = false;
	 }
	 public boolean isTileActive(int col, int row){
		 return this.tileActive[col][row];
	 }
	 
	 public void activecolumnForSixes(int col){
		 this.columnForSixes[col] = true;
	 }
	 public void deactiveColumnForSixes(int col){
		 this.columnForSixes[col] = false;
	 }
	 public boolean isColumnActive(int col){
		 return this.columnForSixes[col];
	 }
}
