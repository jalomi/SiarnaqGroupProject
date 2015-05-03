package sixesWildEntity;

import junit.framework.TestCase;

public class TestBoard extends TestCase{
	Board b=new Board();

	public TestBoard() throws Exception{
		b.populateBoard();
		System.out.println("full");
	}

}
