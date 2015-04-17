package levelBuilderEntity;

import java.sql.Time;

public class LevelBuilder {
	int number;
	int type;
	boolean[][] tilesActive=new boolean[9][9];
	boolean allowReset;
	boolean allowSwap;
	boolean allowRemove;
	double percent[] = new double[6];
	double percentM[] = new double[3];
	int oneStarScore;
	int twoStarScore;
	int threeStarScore;
	Time time;
	int moves;
	boolean[] bucketFor6s=new boolean[9];
	
	//CONSTRUCTOR FOR TESTING.   ***DELETE LATER***
	public LevelBuilder(int x){
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				tilesActive[i][j]=true;
			}
		}
		
		for(int i=0; i<9; i++)
		{
			bucketFor6s[i]=false;
		}
		
		//bad dummy values
		percent[0] = .2 ;
		percent[1] = .2 ;
		percent[2] = .2 ;
		percent[3] = .2 ;
		percent[4] = .1 ;
		percent[5] = .1 ;
		
		percentM[0] = .7 ;
		percentM[1] = .2 ;
		percentM[2] = .1 ;
		
		boolean allowReset = false;
		boolean allowSwap = false;
		boolean allowRemove = false;
	}
	
	public LevelBuilder()
	{
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				tilesActive[i][j]=true;
			}
		}
		
		for(int i=0; i<9; i++)
		{
			bucketFor6s[i]=false;
		}
		
		boolean allowReset = false;
		boolean allowSwap = false;
		boolean allowRemove = false;
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
		return percent[i] ;
	}
	
	public double getPercentM(int i){
		return percentM[i] ;
	}
}
