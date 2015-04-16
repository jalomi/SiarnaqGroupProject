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
	boolean enabled;
	boolean[][] enabledTiles = new boolean[9][9];

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
	
	//chance for each multiplier to appear on each tile
	double percentM1;
	double percentM2;
	double percentM3;
	double rangeM1;
	double rangeM2;
	double rangeM3;
	
	int score;
	int startNumber;
	int firstStarScore;
	int secondStarScore;
	int thirdStarScore;
	
	boolean swapEnabled;
	boolean resetEnabled;
	boolean removeEnabled;
	
	//this contructor is for test now
	public Level(int number) {
		this.id = UUID.randomUUID();
		this.levelNumber = number;
		
		range1 = 0.1;
		range2 = 0.2;
		range3 = 0.3;
		range4 = 0.4;
		range5 = 0.5;
		range6 = 1.0;
		rangeM1 = 0.1;
		rangeM2 = 0.2;
		rangeM3 = 1.0;
		
		firstStarScore = 10;
		secondStarScore = 20;
		thirdStarScore = 30;
		
		score = 0;
		startNumber = 0;
	}
	
	//this contructor
	//is not finished yet
	public Level(int number, 
				  double p1, double p2, double p3, double p4, double p5, double p6,
				  double m1, double m2, double m3) throws Exception {
		if(this.checkPercentageCorrectnes(p1, p2, p3, p4, p5, p6, m1, m2, m3)) {
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
			range6 = 1.0;
			
			this.percentM1 = m1;
			this.percentM1 = m1;
			this.percentM1 = m1;
			rangeM1 = m1;
			rangeM2 = m2 + rangeM1;
			rangeM3 = 1.0;
			
			firstStarScore = 10;
			secondStarScore = 20;
			thirdStarScore = 30;
			
			score = 0;
			startNumber = 0;
		} else {
			System.out.print("The percentage is not correct");
			throw new Exception();
		}

		
	}
	
	public int getLevelNumber() {
		return levelNumber;
	}

	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}

	public double getPercentB1() {
		return percentM1;
	}

	public void setPercentB1(double percentB1) {
		this.percentM1 = percentB1;
	}

	public double getRangeB1() {
		return rangeM1;
	}

	public void setRangeB1(double rangeB1) {
		this.rangeM1 = rangeB1;
	}

	public double getRangeB2() {
		return rangeM2;
	}

	public void setRangeB2(double rangeB2) {
		this.rangeM2 = rangeB2;
	}

	public double getRangeB3() {
		return rangeM3;
	}

	public void setRangeB3(double rangeB3) {
		this.rangeM3 = rangeB3;
	}

	public int getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}

	public boolean isSwapEnabled() {
		return swapEnabled;
	}

	public void setSwapEnabled(boolean swapEnabled) {
		this.swapEnabled = swapEnabled;
	}

	public boolean isResetEnabled() {
		return resetEnabled;
	}

	public void setResetEnabled(boolean resetEnabled) {
		this.resetEnabled = resetEnabled;
	}

	public boolean isRemoveEnabled() {
		return removeEnabled;
	}

	public void setRemoveEnabled(boolean removeEnabled) {
		this.removeEnabled = removeEnabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
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

	public double getPercentB2() {
		return percentM2;
	}

	public void setPercentB2(double percentB2) {
		this.percentM2 = percentB2;
	}

	public double getPercentB3() {
		return percentM3;
	}

	public void setPercentB3(double percentB3) {
		this.percentM3 = percentB3;
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
	
	//they must add to 1
	private boolean checkPercentageCorrectnes (
			double p1, double p2, double p3, double p4, double p5, double p6,
			double m1, double m2, double m3){
		if(p1 + p2 + p3 + p4 + p5 + p6 == 1 && m1 + m2 + m3 == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	Square generateSquare() {
		int value = 0;
		int multi = 0;
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
		
		if(random < rangeM1) {
			multi = 1;
		} else if(random <= rangeM2 && random > rangeM1) {
			multi = 2;
		} else {
			multi = 3;
		}
		
		return new Square(value, multi);
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
