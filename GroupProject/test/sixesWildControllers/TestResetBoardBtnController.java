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

	public void testFail()
	{
		Level l = sw.getLevels().get(0);
		board.setLevel(l);
		swa = new SixesWildApplication(sw);
		ResetBoardButtonController rbc=new ResetBoardButtonController(swa, board);
		rbc.process();
	}
}
