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

public class LevelBuilder {
	
	public static final String TAG = "LevelBuilder";
	
	
	/*    The Configuration of a Level    */
	int number;
	String type;
	
	boolean unlocked;
	boolean allowReset;
	boolean allowSwap;
	boolean allowRemove;
	boolean [][] tilesActive = new boolean[9][9];
	boolean[] bucketFor6s=new boolean[9]; //Haven't been added to the constructor yet!
	
    double percents[] = new double[6];
	double percentM[] = new double[3];
	
	int oneStarScore;
	int twoStarScore;
	int threeStarScore;
	
	int second;
	int moves;
	/*    End The Configuration of a Level    */
	
	/*    Current Editing Level    */
	//Must do cast after you do type checking!!!
	static ArrayList<String> levelList = new ArrayList<String>();
	static Level level;
	/*    End Current Editing Level    */
	
	
	/*    The info LevelBuilder keeps for itself    */
	Stack<Move> moveStack = new Stack<Move>();
	Stack<Move> redoStack = new Stack<Move>();
	/*    End The info LevelBuilder keeps for itself    */
	
	//CONSTRUCTOR 
	public LevelBuilder() throws IOException, JSONException{
		//first loading the level
		LevelJSONSerializer json = new LevelJSONSerializer("Level List.json");
		LevelBuilder.levelList = json.loadLevelList();
		
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				tilesActive[i][j] = false ;
			}
		}
		
		
		for(int i=0; i<9; i++)
		{
			this.bucketFor6s[i]=false;
		}
		
		for(int i=0;i<6;i++){
			this.percents[i] = 0;
		}
		
		for(int i=0;i<3;i++){
			this.percentM[i] = 0;
		}
		
		this.oneStarScore = 0;
		this.twoStarScore = 0;
		this.threeStarScore = 0;
		
		this.allowReset=false;
		this.allowSwap=false;
		this.allowRemove=false;

		//bad dummy values
		percents[0] = .2 ;
		percents[1] = .2 ;
		percents[2] = .2 ;
		percents[3] = .2 ;
		percents[4] = .1 ;
		percents[5] = .1 ;
		
		percentM[0] = .89 ;
		percentM[1] = .1 ;
		percentM[2] = .01 ;
		
		this.allowReset = false;
		this.allowSwap = false;
		this.allowRemove = false;
		this.type= "Puzzle";
	}
	
	/**
	 * @return Level
	 * @throws Exception 
	 */
	public Level generateLevel(String type) throws Exception {
		System.out.println(TAG + " type:" + type);
		if(type.equals("Elimination")) {
			return new Elimination(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getOneStarScore(), this.getTwoStarScore(), this.getThreeStarScore(),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Lightning")) {
			return new Lightning(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getOneStarScore(), this.getTwoStarScore(), this.getThreeStarScore(),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Puzzle")) {
			return new Puzzle(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getOneStarScore(), this.getTwoStarScore(), this.getThreeStarScore(),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Release")) {
			return new Release(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getOneStarScore(), this.getTwoStarScore(), this.getThreeStarScore(),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
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

	public void setTileActive(int row, int col){
		tilesActive[col][row] = true ;
	}
	
	public void setTileDeactive(int row, int col){
		tilesActive[col][row] = false ;
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
	
	public void setPercents(int n, double p){
		percents[n] = p/100;
	}
	
	public void setPercentM(int m, double p){
		percentM[m] = p/100;
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
	
	public void setLevelType(String t){
		type = t; 
	}
	
	public void setMoves(int n){
		moves = n;
	}
	
	public boolean entriesValid()
	{
		return false;
	}
	
	public void generateLevel()
	{
		System.out.println("hi");
	}
	
	void preview()
	{
		System.out.println("hi");
	}


	public boolean getTileActiveAt(int col, int row) {
		return tilesActive[col][row] ;
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
	
	public String getLevelType(){
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
	
	public boolean getSpecialEnabled(int i)
	{
		if(i==1)
			return allowReset;
		else if(i==2)
			return allowSwap;
		else
			return allowRemove;
	}

	public void setSpecialEnabled(int i, boolean enabled) {
		// TODO Auto-generated method stub
		if(i==1)
			allowReset=enabled;
		else if(i==2)
			allowSwap=enabled;
		else
			allowRemove=enabled;
	}
	
	public static ArrayList<String> getLevelList() {
		return levelList;
	}

	public static void setLevelList(ArrayList<String> levelList) {
		LevelBuilder.levelList = levelList;
	}

	public static Level getLevel() {
		return level;
	}

	public static void setLevel(Level level) {
		LevelBuilder.level = level;
	}
	
	public boolean getBucketEnabled(int i)
	{
		return bucketFor6s[i];
	}
	
	public void setBucketEnabled(int i, boolean b)
	{
		bucketFor6s[i]=b;
	}
}

