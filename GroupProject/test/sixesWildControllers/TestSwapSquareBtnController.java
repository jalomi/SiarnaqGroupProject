package sixesWildControllers;

import junit.framework.TestCase;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class TestSwapSquareBtnController extends TestCase{
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

	public void testSwap()
	{
		Level l = sw.getLevels().get(0);
		board.setLevel(l);
		swa = new SixesWildApplication(sw);
		SwapSquareButtonController sbc=new SwapSquareButtonController(swa, board);
		sbc.process();
		assertEquals(board.getSwapMove(), true);
		
		board.setCurrentScore(500);
		board.setCurrentMoves(0);
		TileLabelController tlc=new TileLabelController(swa, sw);
		tlc.pressed(swa.getGamePanel().getTileLabel(5, 5));
		tlc.entered(swa.getGamePanel().getTileLabel(5, 6));
		tlc.released();
		assertEquals(l.hasWon(), true);	
		ResetProgressController rpc=new ResetProgressController(swa);
		rpc.process();
	}
}
