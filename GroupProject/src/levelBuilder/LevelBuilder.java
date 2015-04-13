package levelBuilder;

import java.sql.Time;

public class LevelBuilder {
	int number;
	int type;
	boolean[][] tilesActive = new boolean[9][9];
	boolean allowReset;
	boolean allowSwap;
	boolean allowRemove;
	float percent1;
	float percent2;
	float percent3;
	float percent4;
	float percent5;
	float percent6;
	float percentB2;
	float percentB3;
	int oneStarScore;
	int twoStarScore;
	int threeStarScore;
	Time time;
	int moves;
	boolean[] bucketFor6s = new boolean[9];
	
	public LevelBuilder()
	{
		for(int i=0; i<9; i++)
		{
			for(int j=0; j<9; j++)
			{
				tilesActive[i][j]=false;
			}
		}
		
		for(int i=0; i<9; i++)
		{
			bucketFor6s[i]=false;
		}
		
		boolean allowReset=false;
		boolean allowSwap=false;
		boolean allowRemove=false;
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
}
