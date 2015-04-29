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
	public static LevelBuilder lb;
	
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
	
	int starScore[] = new int[3];
	
	int second;
	int moves;
	/*    End The Configuration of a Level    */
	
	/*    Current Editing Level    */
	//Must do cast after you do type checking!!!
	static ArrayList<String> levelList = new ArrayList<String>();
	public static Level level;
	/*    End Current Editing Level    */
	
	
	/*    The info LevelBuilder keeps for itself    */
	public Stack<Move> moveStack = new Stack<Move>();
	public Stack<Move> redoStack = new Stack<Move>();
	/*    End The info LevelBuilder keeps for itself    */
	
	//CONSTRUCTOR 
	public static LevelBuilder newInstance() throws IOException, JSONException{
		if(LevelBuilder.lb == null){
			System.out.println("NuLL!!!!!");
			LevelBuilder.lb = new LevelBuilder(); 
		}
		return lb;
	}
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
		
		for(int i=0;i<6;i++){
			this.percents[i] = 0;
		}
		
		for(int i=0;i<3;i++){
			this.percentM[i] = 0;
		}
		
		for(int i=0; i<3; i++)
		{
			this.starScore[i]=0;
		}
		
		this.allowReset=false;
		this.allowSwap=false;
		this.allowRemove=false;

		//bad dummy values
		percents[0] = 0 ;
		percents[1] = 0 ;
		percents[2] = 0 ;
		percents[3] = 0 ;
		percents[4] = 0 ;
		percents[5] = 0 ;
		
		percentM[0] = 0 ;
		percentM[1] = 0 ;
		percentM[2] = 0 ;
		
		second=0;
		
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
		System.out.println(TAG + "M " + percentM[0]);
		System.out.println(TAG + "M " + percentM[1]);
		System.out.println(TAG + "M " + percentM[2]);
		//check for attributes validation
		double percent = this.getPercent(0) + this.getPercent(1) + this.getPercent(2)
				    + this.getPercent(3) + this.getPercent(4) + this.getPercent(5);
		double percentM = getPercentM(0) + this.getPercentM(1) + this.getPercentM(2);
		if(Double.compare(percent, 1.0) != 0) {
			throw new Exception(TAG + " :: Percent Sum " + percent  + " is not valid");
		}
		if(Double.compare(percentM, 1.0) != 0) {
			throw new Exception(TAG + " :: PercentM Sum is not valid");
		}
		if(this.getLevelNumber() < 1) {
			throw new Exception(TAG + " :: Level Number is Less than 1");
		}
		if(type.equals("Elimination")) {
			return new Elimination(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Lightning")) {
			return new Lightning(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Puzzle")) {
			return new Puzzle(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else if(type.equals("Release")) {
			return new Release(this.getLevelNumber(), this.moves,
					  this.getPercent(0), this.getPercent(1), this.getPercent(2),
					  this.getPercent(3), this.getPercent(4), this.getPercent(5),
					  this.getPercentM(0), this.getPercentM(1), this.getPercentM(2),
					  this.getStarScore(0), this.getStarScore(1), this.getStarScore(2),
					  this.unlocked, 
					  this.allowSwap, this.allowReset, this.allowRemove,
					  this.tilesActive);
		} else {
			throw new Exception(TAG + " :: Wrong Level Type!");
		}
	}
	
	/**
	 * Determines if a level can be generated based on the current parameters
	 * 
	 * Will set generate level and preview level buttons as enabled if entries are
	 * valid and disabled if not.
	 */
	
	public boolean canGenerate() {
		//TODO
		boolean result = false ;
		
		
		
		if(result){
			//enable buttons
		}
		else{
			//disable buttons
		}
		
		return result ;
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
		starScore[n]=s;
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
	
	public int getStarScore(int i){
		return starScore[i];
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
	
	public int getSeconds()
	{
		return second;
	}
	
	public void setSeconds(int i)
	{
		second=i;
	}
	
	public boolean getReset()
	{
		return allowReset;
	}
	
	public boolean getSwap()
	{
		return allowSwap;
	}
	
	public boolean getRemove() {
		return allowRemove;
	}
	
	public void assignEntities(String t){
		number = level.getLevelNumber();
		type = t;
		unlocked = level.getUnlocked();
		allowReset = level.isResetEnabled();
		allowSwap = level.isSwapEnabled();
		allowRemove = level.isRemoveEnabled();
		tilesActive = level.getEnabledTiles();
		bucketFor6s = level.getColumnForSixes();
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

