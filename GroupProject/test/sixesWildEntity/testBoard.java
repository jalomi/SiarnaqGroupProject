package sixesWildEntity;

import junit.framework.TestCase;

public class testBoard extends TestCase{
Board b=new Board();

public void testBoard() throws Exception
{
	b.populateBoard();
	System.out.println("full");
}

}
