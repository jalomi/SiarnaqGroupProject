package sixesWildEntity;

import java.util.UUID;

/*
 * For now I assume that every tile is enabled
 * 
 * 
 */

public class Level {
	
	UUID id;
	
	int levelNumber;
	
	double percent1;
	double percent2;
	double percent3;
	double percent4;
	double percent5;
	double percent6;
	
	//upper bound
	double range1;
	double range2;
	double range3;
	double range4;
	double range5;
	double range6;
	
	boolean[][] enabledTiles = new boolean[9][9];
	
	int score;
	int firstStarScore;
	int secondStarScore;
	int thirdStarScore;
	
	public Level() {
		
	}
	
	//this contructor is for test now
	public Level(int number) {
		this.id = UUID.randomUUID();
		this.levelNumber = number;
	}
	
	//this contructor should never be called by other Class
	private Level(int number, double p1, double p2, double p3, double p4, double p5, double p6) {
		this.id = UUID.randomUUID();
		this.levelNumber = number;
		this.percent1 = p1;
		this.percent2 = p2;
		this.percent3 = p3;
		this.percent4 = p4;
		this.percent5 = p5;
		this.percent6 = p6;
		
		range1 = p1;
		range2 = p2 + range1;
		range3 = p3 + range2;
		range4 = p4 + range3;
		range5 = p5 + range4;
		range6 = (float) 1.0;
	}
	
	public static Level newInstance(int number, double d, double e, double f, double g, double h, double i) {
		if(checkPercentageCorrectness(d,e,f,g,h,i)) {
			return new Level(number, d, e, f, g, h, i);
		} else {
			return null;
		}
	}
	
	//they must add to 1
	private static boolean checkPercentageCorrectness(double p1, double p2, double p3, double p4, double p5, double p6) {
		if(p1 + p2 + p3 + p4 + p5 + p6 == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	Square generateSquare() {
		int value = 0;
		double random = Math.random();
		if(random <= range1) {
			value = 1;
		} else if(random <= range2 && random > range1) {
			value = 2;
		} else if(random <= range3 && random > range2) {
			value = 3;
		} else if(random <= range4 && random > range3) {
			value = 4;
		} else if(random <= range5 && random > range4) {
			value = 5;
		} else if(random <= range6 && random > range5) {
			value = 6;
		}
		return Square.newInstance(value, 1);
	}
	
	private void initializeEnabledArray() {
		//for(int i = )
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public int getNumber() {
		return levelNumber;
	}
	public void setNumber(int number) {
		this.levelNumber = number;
	}
	public double getPercent1() {
		return percent1;
	}
	public void setPercent1(double percent1) {
		this.percent1 = percent1;
	}
	public double getPercent2() {
		return percent2;
	}
	public void setPercent2(double percent2) {
		this.percent2 = percent2;
	}
	public double getPercent3() {
		return percent3;
	}
	public void setPercent3(double percent3) {
		this.percent3 = percent3;
	}
	public double getPercent4() {
		return percent4;
	}
	public void setPercent4(double percent4) {
		this.percent4 = percent4;
	}
	public double getPercent5() {
		return percent5;
	}
	public void setPercent5(double percent5) {
		this.percent5 = percent5;
	}
	public double getPercent6() {
		return percent6;
	}
	public void setPercent6(double percent6) {
		this.percent6 = percent6;
	}
}
