package sixesWildEntity;

/**
 * Game pieces that go in the tiles of the board
 * @author John
 * @author Xuanzhe 
 *
 */
public class Square {
	/** value of the square */
	private int value;
	
	/** multiplier assigned to the square */
	private int multiplier;
	
	/**
	 * Constructor
	 * @param value
	 * @param multiplier
	 */
	public Square(int value, int multiplier) {
		this.value=value;
		this.multiplier=multiplier;
	}

	/**
	 * gets the square's value
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * gets the value of the square
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * gets the multiplier of the square
	 * @return
	 */
	public int getMultiplier() {
		return multiplier;
	}

	/**
	 * set the square's multiplier
	 * @param multiplier
	 */
	public void setMultiplier(int multiplier) {
		this.multiplier = multiplier;
	}
}
