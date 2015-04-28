package sixesWildEntity;

public class Square {
	private int value;
	private int multiplier;
	
	public Square(int value, int multiplier) {
		this.value=value;
		this.multiplier=multiplier;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
}
