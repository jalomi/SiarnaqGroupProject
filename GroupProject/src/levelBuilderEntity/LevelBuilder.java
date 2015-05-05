package levelBuilderEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

import org.json.JSONException;

import JSONSerializer.LevelJSONSerializer;
import sixesWildEntity.Elimination;
import sixesWildEntity.Level;
import sixesWildEntity.Lightning;
import sixesWildEntity.Puzzle;
import sixesWildEntity.Release;
import levelBuilderMoves.Move;

/**
 * Model for the Level Builder Application
 * @author 
 *
 */
public class LevelBuilder {
	/** TAG for the class */
	public static final String TAG = "LevelBuilder";
	
	/** singleton model */
	public static LevelBuilder lb;
	
	/** the level's number */
	int number;
	
	/** the level type */
	String type;
	
	/** flag for the level being unlocked */
	boolean unlocked;
	
	/** flag for allowing reset moves */
	boolean allowReset;
	
	/** flag for allowing swap moves */
	boolean allowSwap;
	
	/** flag for allowing remove moves */
	boolean allowRemove;
	
	/** the active game tiles */
	boolean [][] tilesActive = new boolean[9][9];
	
	/** the buckets for 6s to fall into in Release */
	boolean[] bucketFor6s=new boolean[9];
	
	/** the percentages for tile values */
    double percents[] = new double[6];
    
    /** the percentages for tile multipliers */
	double percentM[] = new double[3];
	
	/** the scores needed to get 1, 2, or 3 stars */
	int starScore[] = new int[3];
	
	/** max seconds */
	int second;
	
	/** max moves */
	int moves;
	
	/** list of levels the builder can access */
	static ArrayList<String> levelList = new ArrayList<String>();
	
	/** current level being edited */
	public static Level level;	
	
	/** moves taken for use with undo */
	public Stack<Move> moveStack = new Stack<Move>();
	
	/** undos done for use with redo */
	public Stack<Move> redoStack = new Stack<Move>();
	
	/**
	 * If a level builder exists, use it.  If not, make a new one
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public static LevelBuilder newInstance() throws IOException, JSONException{
		if(LevelBuilder.lb == null){
			System.out.println("NuLL!!!!!");
			LevelBuilder.lb = new LevelBuilder(); 
		}
		return lb;
	}
	
	/**
	 * Constructor
	 * @throws IOException
	 * @throws JSONException
	 */
	public LevelBuilder() throws IOException, JSONException{
		//first loading the level
		LevelJSONSerializer json = new LevelJSONSerializer("Level List.json");
		LevelBuilder.levelList = json.loadLevelList();
		
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				tilesActive[i][j] = true ;
			}
		}
		
		
		for(int i=0; i<9; i++)
		{
			this.bucketFor6s[i]=false;
		}
		
		for(int i=0;i<5;i++){
			this.percents[i] = 0;
		}
		this.percents[5] = 1;
		for(int i=0;i<3;i++){
			this.percentM[i] = 0;
		}
	
		for(int i=0; i<3; i++)
		{
			this.starScore[i]=0;
		}
		
		second=0;
		
		this.allowReset = false;
		this.allowSwap = false;
		this.allowRemove = false;
		this.type= "Puzzle";
	}
	
	/**
	 * generates the level based on the builder's attributes
	 * @return Level
	 * @throws Exception 
	 */
	public Level generateLevel(String type) throws Exception {
		System.out.println(TAG + " type:" + type);
		System.out.println(TAG + "M " + percentM[0]);
		System.out.println(TAG + "M " + percentM[1]);
		System.out.println(TAG + "M " + percentM[2]);
		
		if(this.getLevelNumber() < 1) {
			throw new Exception(TAG + " :: Level Number is Less than 1");
		}
		if(type.equals("Elimination")) {
			return new Elimination(this.number, this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Lightning")) {
			return new Lightning(this.number, this.second,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Puzzle")) {
			return new Puzzle(this.number, this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Release")) {
			return new Release(this.number, this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive, this.bucketFor6s);
		} else {
			throw new Exception(TAG + " :: Wrong Level Type!");
		}
	}
	
	
	/**
	 * Record the move which can be undone in the future.
	 * 
	 * These are all "normal" moves, which mean that they invalidate any "undone" moves
	 * that might be currently on the redoStack, so that must be cleared.
	 * 
	 * @param move
	 */
	public void recordMove(Move move) {
		moveStack.add(move);
		redoStack.clear();
	}
	
	/** 
	 * Add this as a future move to be redone.
	 * 
	 * @param move
	 */
	public void recordRedoableMove(Move move) {
		redoStack.push(move);
	}
	
	/**
	 * If any moves have been undone, then they can be redone.
	 */
	public Move removeRedoMove() {
		if (redoStack.isEmpty()) { return null; }
		return redoStack.pop();
	}
	
	/**
	 * Redo Controller has executed a move that had previously been undone.
	 * This can go onto the move stack so it can be undone in future
	 * @param m
	 */
	public void recordRedoneMove(Move m) {
		moveStack.push(m);
	}
	
	/**
	 * Prepare for undo by getting last move.
	 */
	public Move removeLastMove() {
		if (moveStack.isEmpty()) { return null; }
		return moveStack.pop();
	}

	/**
	 * set the tile at the coordinate to be active
	 * @param row
	 * @param col
	 */
	public void setTileActive(int row, int col){
		tilesActive[col][row] = true ;
	}
	
	/**
	 * set the tile at the coordinate to be inactive
	 * @param row
	 * @param col
	 */
	public void setTileDeactive(int row, int col){
		tilesActive[col][row] = false ;
	}
	
	/**
	 * set the bucket at the inputted column to be active
	 * @param col
	 */
	public void setBucketFor6sActive(int col){
		bucketFor6s[col]=true;
	}
	
	/**
	 * set the bucket at the inputted column to be inactive
	 * @param col
	 */
	public void setBucketFor6sDeactive(int col){
		bucketFor6s[col] = false;
	}
	
	/**
	 * set allow permission for special moves
	 * @param i
	 */
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
	
	/**
	 * remove allow permission for special moves
	 * @param i
	 */
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
	
	/**
	 * set the value percentage of the given index
	 * @param n
	 * @param p
	 */
	public void setPercents(int n, double p){
		percents[n] = p/100;
	}
	
	/**
	 * set the multiplier percentage of the given index
	 * @param m
	 * @param p
	 */
	public void setPercentM(int m, double p){
		percentM[m] = p/100;
	}
	
	/**
	 * set the star score of the given index
	 * @param n
	 * @param s
	 */
	public void setStarScore(int n,int s){
		//n = star number, s = score 
		starScore[n]=s;
	}
	
	/**
	 * set the level's number
	 * @param l
	 */
	public void setLevelNumber(int l){
		number = l;
	}
	
	/**
	 * set the level's type
	 * @param t
	 */
	public void setLevelType(String t){
		type = t; 
	}
	
	/**
	 * set the maximum moves
	 * @param n
	 */
	public void setMoves(int n){
		moves = n;
	}
	
	/**
	 * check to see if tile at the coordinate is active
	 * @param col
	 * @param row
	 * @return
	 */
	public boolean getTileActiveAt(int col, int row) {
		return tilesActive[col][row] ;
	}
	
	/**
	 * get the value percentage of the given index
	 * @param i
	 * @return
	 */
	public double getPercent(int i){
		return percents[i] ;
	}
	
	/**
	 * get the multiplier percentage at the given index
	 * @param i
	 * @return
	 */
	public double getPercentM(int i){
		return percentM[i] ;
	}
	
	/**
	 * get the level's number
	 * @return
	 */
	public int getLevelNumber(){
		return number;
	}
	
	/**
	 * get the level's type
	 * @return
	 */
	public String getLevelType(){
		return type; 
	}
	
	/**
	 * get the moves
	 * @return
	 */
	public int getMoves(){
		return moves;
	}
	
	/**
	 * get the score needed for a star
	 * @param i
	 * @return
	 */
	public int getStarScore(int i){
		return starScore[i];
	}
	
	/**
	 * check if a special move is enabled
	 * @param i
	 * @return
	 */
	public boolean getSpecialEnabled(int i){
		if(i==1)
			return allowReset;
		else if(i==2)
			return allowSwap;
		else
			return allowRemove;
	}

	/**
	 * set a special move to be allowed or not
	 * @param i
	 * @param enabled
	 */
	public void setSpecialEnabled(int i, boolean enabled) {
		if(i==1)
			allowReset=enabled;
		else if(i==2)
			allowSwap=enabled;
		else
			allowRemove=enabled;
	}
	
	/**
	 * get the list of levels
	 * @return
	 */
	public static ArrayList<String> getLevelList() {
		return levelList;
	}

	/**
	 * set the list of levels
	 * @param levelList
	 */
	public static void setLevelList(ArrayList<String> levelList) {
		LevelBuilder.levelList = levelList;
	}

	/**
	 * get the current level
	 * @return
	 */
	public static Level getLevel() {
		return level;
	}

	/**
	 * set the current level
	 * @param level
	 */
	public static void setLevel(Level level) {
		LevelBuilder.level = level;
	}
	
	/**
	 * check to see if the bucket at the given column is enabled
	 * @param i
	 * @return
	 */
	public boolean getBucketEnabled(int i){
		return bucketFor6s[i];
	}
	
	/**
	 * set the bucket at the given column as enabled or disabled
	 * @param i
	 * @param b
	 */
	public void setBucketEnabled(int i, boolean b){
		bucketFor6s[i]=b;
	}
	
	/**
	 * get the seconds
	 * @return
	 */
	public int getSeconds(){
		return second;
	}
	
	/**
	 * set the seconds
	 * @param i
	 */
	public void setSeconds(int i){
		second=i;
	}
	
	/**
	 * get the reset allowed flag
	 * @return
	 */
	public boolean getReset(){
		return allowReset;
	}
	
	/**
	 * get the swap allowed flag
	 * @return
	 */
	public boolean getSwap(){
		return allowSwap;
	}
	
	/**
	 * get the remove allowed flag
	 * @return
	 */
	public boolean getRemove() {
		return allowRemove;
	}
	
	/**
	 * assigns the entries to the builder when loading a level
	 * @param t
	 */
	public void assignEntities(String t){
		number = level.getLevelNumber();
		type = t;
		unlocked = level.getUnlocked();
		allowReset = level.isResetEnabled();
		allowSwap = level.isSwapEnabled();
		allowRemove = level.isRemoveEnabled();
		tilesActive = level.getEnabledTiles();
		bucketFor6s = level.getBuckets();
		percents = level.getPercent();
		percentM = level.getPercentM();
		System.out.println(percentM[0]);
		System.out.println(percentM[1]);
		System.out.println(percentM[2]);
		starScore[0] = level.getOneStarScore();
		starScore[1] = level.getTwoStarScore();
		starScore[2] = level.getThreeStarScore();
		second = level.getTimeRemaining();
		moves = level.getMovesRemaining();
	}
	
}

