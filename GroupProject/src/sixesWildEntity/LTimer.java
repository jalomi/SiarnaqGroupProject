package sixesWildEntity;

import java.util.Timer;
import java.util.TimerTask;

public class LTimer {
	static LTimer timer = null ;
	static Timer realTimer = new Timer() ;
	
	/** Singleton instance is locked down. */
	LTimer(){}
	
	public static LTimer getInstance(){
		if(timer == null){
			timer = new LTimer() ;
			
			realTimer = new Timer() ;
		}
		
		return timer ;
	}
	
	
	/**
	 * Add task to the list of schedulable tasks.
	 */
	public void schedule (TimerTask task, int delayMS) {
		realTimer.scheduleAtFixedRate(task, delayMS, delayMS);
	}
	
	
	/** 
	 * Must shutdown timer so GUI applications can cleanly exit.
	 * Also this removes the timer entirely; if needed later, it will be recreated.
	 */
	public void cancel() {
		realTimer.cancel();	
		realTimer = null;
		timer = null;
	}
	
}
