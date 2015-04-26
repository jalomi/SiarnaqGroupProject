package sixesWildEntity;

import java.sql.Time;

public class Lightning extends Level {
	int timeRemaining;
	//a real countdown timer should be implemented later
	//check out Scanner, Timer, and TimerTask
	
	public Lightning(int number, int movesRemaining) {
		super(number);
		this.timeRemaining = movesRemaining;
	}
	
	public String getMovesRemainingString() {
		return "Unlimited";
	}
	
	public String getTimeRemainingString() {
		return Integer.toString(timeRemaining);
	}
	
	public void updateMovesLeft(int m){
		
	}
	
	public boolean hasWon(){
		if(timeRemaining == 0){
			if(score >= oneStarScore){
				if(score >= threeStarScore){
					starNumber = 3 ;
				}
				else if(score >= twoStarScore){
					starNumber = 2 ;
				}
				else{
					starNumber = 1 ;
				}			
				
				return true ;
			}
		}
		
		return false ;
	}
	
}
