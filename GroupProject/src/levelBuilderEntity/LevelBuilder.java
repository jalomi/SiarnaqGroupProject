package levelBuilderEntity;

import java.sql.Time;
import java.util.HashMap ;

public class LevelBuilder {
	int number;
	int type;
	HashMap<Integer, Boolean> tilesActive = new HashMap<Integer, Boolean>() ;
	boolean allowReset;
	boolean allowSwap;
	boolean allowRemove;
    double percents[] = new double[7];

	double percentM[] = new double[4];
	int oneStarScore;
	int twoStarScore;
	int threeStarScore;
	int minutes;
	int seconds;
	int moves;
	boolean[] bucketFor6s=new boolean[9];
	
	
	//CONSTRUCTOR 
	public LevelBuilder(){
		for(int i = 11; i <= 99; i++)
			if(i % 10 != 0){
				tilesActive.put(i, true) ;
		}
		
		for(int i=0; i<9; i++)
		{
			this.bucketFor6s[i]=false;
		}
		
		for(int i=1;i<=6;i++){
			this.percents[i] = 0;
		}
		
		for(int i=1;i<=3;i++){
			this.percentM[i] = 0;
		}
		
		this.oneStarScore = 0;
		this.twoStarScore = 0;
		this.threeStarScore = 0;
		
		this.allowReset=false;
		this.allowSwap=false;
		this.allowRemove=false;

		//bad dummy values
		percents[1] = .2 ;
		percents[2] = .2 ;
		percents[3] = .2 ;
		percents[4] = .2 ;
		percents[5] = .1 ;
		percents[6] = .1 ;
		
		percentM[1] = .89 ;
		percentM[2] = .1 ;
		percentM[3] = .01 ;
		
		this.allowReset = false;
		this.allowSwap = false;
		this.allowRemove = false;
	}
	

	
	public void setTileActive(int row, int col){
		int key = col*10+row ;
		tilesActive.put(key, true) ;
	}
	
	public void setTileDeactive(int row, int col){
		int key = col*10+row ;
		tilesActive.put(key, false) ;
	}
	
	public void setBucketFor6sActive(int col){
		bucketFor6s[col]=true;
	}
	
	public void setBucketFor6sDeactive(int col){
		bucketFor6s[col] = false;
	}
	
	public void allowSpecials(int i){
		//1: allow reset, 2:allow swap, 3: allow remove.
		if(i==1){
			allowReset = true;			
		}
		else if(i==2){
			allowSwap = true;
		}
		else if(i==3){
			allowRemove = true;
		}
		
	}
	
	public void disallowSpecials(int i){
		//1: disallow reset, 2:disallow swap, 3: disallow remove.
		if(i==1){
			allowReset = false;			
		}
		else if(i==2){
			allowSwap = false;
		}
		else if(i==3){
			allowRemove = false;
		}
	}
	
	public void setPercents(int n, int p){
		percents[n] = p;
	}
	
	public void setPercentM(int m, int p){
		percentM[m] = p;
	}
	
	public void setStarScore(int n,int s){
		//n = star number, s = score 
		if(n==1){
		oneStarScore = s;
		}
	
		else if(n==2){
		twoStarScore = s;
		}
	
		else if(n==3){
		threeStarScore = s; 
		}
	}
	
	public void setLevelNumber(int l){
		number = l;
	}
	
	public void setLevelType(int t){
		type = t; 
	}
	
	public void setMoves(int n){
		moves = n;
	}
	
	public void setMinutes(int n){
		minutes=n;
	}
	
	public void setSeconds(int n){
		seconds=n;
	}
	
	public boolean entriesValid()
	{
		return false;
	}
	
	void generateLevel()
	{
		System.out.println("hi");
	}
	
	void preview()
	{
		System.out.println("hi");
	}


	public boolean getTileActiveAt(int col, int row) {
		int key = col*10+row ;
		return tilesActive.get(key) ;
	}
	
	public double getPercent(int i){
		return percents[i] ;
	}
	
	public double getPercentM(int i){
		return percentM[i] ;
	}
	
	public int getLevelNumber(){
		return number;
	}
	
	public int getLevelType(){
		return type; 
	}
	
	public int getMoves(){
		return moves;
	}
	
	public int getOneStarScore(){
		return oneStarScore;
	}
	
	public int getTwoStarScore(){
		return twoStarScore;
	}
	
	public int getThreeStarScore(){
		return threeStarScore; 
	}
	
	public int getMinutes()
	{
		return minutes;
	}
	
	public int getSeconds()
	{
		return seconds;
	}
}

