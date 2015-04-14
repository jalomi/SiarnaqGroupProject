package sixesWildEntity;

import java.util.UUID;

/*
 * For now I assume that every tile is enabled
 * 
 * 
 */

public class Level {
	
	UUID id;
	
	int number;
	boolean enabled;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
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
	
	//chance for each multiplier to appear on each tile
	float percentB2;
	float percentB3;
	
	public double getRange1() {
		return range1;
	}

	public void setRange1(double range1) {
		this.range1 = range1;
	}

	public double getRange2() {
		return range2;
	}

	public void setRange2(double range2) {
		this.range2 = range2;
	}

	public double getRange3() {
		return range3;
	}

	public void setRange3(double range3) {
		this.range3 = range3;
	}

	public double getRange4() {
		return range4;
	}

	public void setRange4(double range4) {
		this.range4 = range4;
	}

	public double getRange5() {
		return range5;
	}

	public void setRange5(double range5) {
		this.range5 = range5;
	}

	public double getRange6() {
		return range6;
	}

	public void setRange6(double range6) {
		this.range6 = range6;
	}

	public boolean[][] getEnabledTiles() {
		return enabledTiles;
	}

	public void setEnabledTiles(boolean[][] enabledTiles) {
		this.enabledTiles = enabledTiles;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getFirstStarScore() {
		return firstStarScore;
	}

	public void setFirstStarScore(int firstStarScore) {
		this.firstStarScore = firstStarScore;
	}

	public int getSecondStarScore() {
		return secondStarScore;
	}

	public void setSecondStarScore(int secondStarScore) {
		this.secondStarScore = secondStarScore;
	}

	public int getThirdStarScore() {
		return thirdStarScore;
	}

	public void setThirdStarScore(int thirdStarScore) {
		this.thirdStarScore = thirdStarScore;
	}

	public float getPercentB2() {
		return percentB2;
	}

	public void setPercentB2(float percentB2) {
		this.percentB2 = percentB2;
	}

	public float getPercentB3() {
		return percentB3;
	}

	public void setPercentB3(float percentB3) {
		this.percentB3 = percentB3;
	}

	public boolean[] getColumnForSixes() {
		return columnForSixes;
	}

	public void setColumnForSixes(boolean[] columnForSixes) {
		this.columnForSixes = columnForSixes;
	}
	//columns that has 6s on the top at the beginning of the game(release only)
	boolean[] columnForSixes;
	
	public Level() {
		
	}
	
	//this contructor is for test now
	public Level(int number) {
		this.id = UUID.randomUUID();
		this.number = number;
	}
	
	//this contructor should never be called by other Class
	private Level(int number, double p1, double p2, double p3, double p4, double p5, double p6) {
		this.id = UUID.randomUUID();
		this.number = number;
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
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
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
