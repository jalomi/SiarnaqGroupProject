package levelBuilder;

import java.sql.Time;

public class LevelBuilder {
	int number;
	int type;
	boolean[][] tilesActive=new boolean[9][9];
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
	boolean[] bucketFor6s=new boolean[9];
	
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
