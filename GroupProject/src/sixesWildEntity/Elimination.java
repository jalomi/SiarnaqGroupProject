package sixesWildEntity;

public class Elimination extends Level {
	int movesRemaining;
	
	public Elimination(int levelNumber, int movesRemaining) {
		super(levelNumber);
		this.movesRemaining=movesRemaining;
	}
	
	public String getMovesRemainingString() {
		return String.valueOf(movesRemaining);
	}
	
	public String getTimeRemainingString() {
		return "Unlimited";
	}
	
	public void updateMovesLeft(int m){
		movesRemaining += m ;
	}
	
	public boolean hasWon(){
//		if(movesRemaining == 0){
//			if(score >= oneStarScore){
//				if(score >= threeStarScore){
//					starNumber = 3 ;
//				}
//				else if(score >= twoStarScore){
//					starNumber = 2 ;
//				}
//				else{
//					starNumber = 1 ;
//				}			
//				
//				return true ;
//			}
//		}
//		
//		return false ;
		return false ;
	}
	
}
