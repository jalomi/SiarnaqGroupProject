package sixesWildControllers;

import junit.framework.TestCase;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class TestRemoveSquareBtnController extends TestCase{
	SixesWildApplication swa;
	Board board;
	SixesWild sw;

	@Override
	protected void setUp() {
		sw = SixesWild.newInstance();
		board = Board.newInstance();
	}

	@Override
	protected void tearDown() {
		if(swa != null) {
			swa.dispose();
		}
	}

	public void testRemove()
	{
		Level l = sw.getLevels().get(0);
		board.setLevel(l);
		swa = new SixesWildApplication(sw);
		RemoveSquareButtonController rbc=new RemoveSquareButtonController(swa, board);
		rbc.process();
		assertEquals(board.getRemoveMove(), true);
		
		board.setCurrentScore(500);
		board.setCurrentMoves(0);
		TileLabelController tlc=new TileLabelController(swa, sw);
		tlc.pressed(swa.getGamePanel().getTileLabel(5, 5));
		tlc.released();
		assertEquals(l.hasWon(), true);	
	}
}
