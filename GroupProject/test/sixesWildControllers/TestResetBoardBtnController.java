package sixesWildControllers;

import junit.framework.TestCase;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class TestResetBoardBtnController extends TestCase{
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

	public void testReset()
	{
		Level l = sw.getLevels().get(0);
		board.setLevel(l);
		swa = new SixesWildApplication(sw);
		board.setCurrentScore(500);
		board.setCurrentMoves(0);
		ResetBoardButtonController rbc=new ResetBoardButtonController(swa, board);
		rbc.process();
		assertEquals(l.hasWon(), true);
		ResetProgressController rpc=new ResetProgressController(swa);
		rpc.process();
	}
}
