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
	
	public LevelBuilder()
	{
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