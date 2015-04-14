package sixesWildEntity;

public class Square {
	int value;
	int multiplier;
	
	private Square(int value, int multiplier) {
		this.value=value;
		this.multiplier=multiplier;
	}
	
	public static Square newInstance(int value, int multiplier) {
		if(value > 0 && value <= 6 && multiplier <= 3 && multiplier > 0) {
			return new Square(value, multiplier);
		} else {
			return null;
		}
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
