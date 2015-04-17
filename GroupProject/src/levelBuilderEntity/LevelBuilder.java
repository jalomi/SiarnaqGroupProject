package levelBuilderEntity;

import java.sql.Time;

public class LevelBuilder {
	int number;
	int type;
	boolean[][] tilesActive=new boolean[9][9];
	boolean allowReset;
	boolean allowSwap;
	boolean allowRemove;
    double percents[] = new double[7];

	double percentM[] = new double[3];
	int oneStarScore;
	int twoStarScore;
	int threeStarScore;
	Time time;
	int moves;
	boolean[] bucketFor6s=new boolean[9];
	
	//CONSTRUCTOR 
	public LevelBuilder(){
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				this.tilesActive[i][j]=false;

			}
		}
		
		for(int i=0; i<9; i++)
		{
			this.bucketFor6s[i]=false;
		}
		
		for(int i=1;i<=7;i++){
			this.percents[i] = 0;
		}
		
		for(int i=1;i<=2;i++){
			this.percentM[i] = 0;
		}
		
		this.oneStarScore = 0;
		this.twoStarScore = 0;
		this.threeStarScore = 0;
		
		this.allowReset=false;
		this.allowSwap=false;
		this.allowRemove=false;
//
//		//bad dummy values
//		percent[0] = .2 ;
//		percent[1] = .2 ;
//		percent[2] = .2 ;
//		percent[3] = .2 ;
//		percent[4] = .1 ;
//		percent[5] = .1 ;
//		
//		percentM[0] = .7 ;
//		percentM[1] = .2 ;
//		percentM[2] = .1 ;
		
		this.allowReset = false;
		this.allowSwap = false;
		this.allowRemove = false;
	}
	

	
	public void setTileActive(int row, int col){
		tilesActive[row][col] = true;
	}
	
	public void setTileDeactive(int row, int col){
		tilesActive[row][col] = false;
	}
	
	public void setBucketFor6sActive(int col){
		bucketFor6s[col]=true;
	}
	
	public void setBuckerFor6sDeactvie(int col){
		bucketFor6s[col] = false;
	}
	
	public void allowSpcials(int i){
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
	
	public void disallowSpcials(int i){
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
		return tilesActive[col][row];
	}
	
	public double getPercent(int i){
		return percents[i] ;
	}
	
	public double getPercentM(int i){
		return percentM[i] ;
	}
	
	public int getLevelNumber(int l){
		return number;
	}
	
	public int getLevelType(int t){
		return type = t; 
	}
	
	public int getMoves(){
		return moves;
	}
	
	public int getOneStarScore(int s){
		return oneStarScore;
	}
	
	public int setTwoStarScore(int s){
		return twoStarScore;
	}
	
	public int setThreeStarScore(int s){
		return threeStarScore; 
	}
	
	
	
}

