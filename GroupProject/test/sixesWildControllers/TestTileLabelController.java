package sixesWildControllers;

import junit.framework.TestCase;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;
import sixesWildEntity.Square;

public class TestTileLabelController extends TestCase{
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
	TileLabelController tlc=new TileLabelController(swa, sw);
	tlc.pressed(swa.getGamePanel().getTileLabel(5, 5));
	tlc.entered(swa.getGamePanel().getTileLabel(5, 6));
	tlc.entered(swa.getGamePanel().getTileLabel(5, 5));
	tlc.released();
	assertEquals(board.getCurrentScore(), 0);
}

public void testNormalMove()
{
	Level l = sw.getLevels().get(0);
	board.setLevel(l);
	swa = new SixesWildApplication(sw);
	swa.getGamePanel().getTileLabel(5, 5).getModel().setSquare(new Square(5, 2));
	swa.getGamePanel().getTileLabel(5, 6).getModel().setSquare(new Square(1, 1));
	TileLabelController tlc=new TileLabelController(swa, sw);
	tlc.pressed(swa.getGamePanel().getTileLabel(5, 5));
	tlc.entered(swa.getGamePanel().getTileLabel(5, 6));
	tlc.released();
	assertEquals(board.getCurrentScore(), 40);
}

public void testRemoveMove()
{
	Level l = sw.getLevels().get(0);
	board.setLevel(l);
	swa = new SixesWildApplication(sw);
	board.setRemoveMove(true);
	TileLabelController tlc=new TileLabelController(swa, sw);
	tlc.pressed(swa.getGamePanel().getTileLabel(5, 5));
	tlc.released();
}

public void testSwapMove()
{
	Level l = sw.getLevels().get(0);
	board.setLevel(l);
	swa = new SixesWildApplication(sw);
	board.setSwapMove(true);
	TileLabelController tlc=new TileLabelController(swa, sw);
	tlc.pressed(swa.getGamePanel().getTileLabel(5, 5));
	tlc.entered(swa.getGamePanel().getTileLabel(5, 6));
	tlc.released();
}

public void testWon()
{
	Level l = sw.getLevels().get(0);
	board.setLevel(l);
	swa = new SixesWildApplication(sw);
	swa.getGamePanel().getTileLabel(5, 5).getModel().setSquare(new Square(5, 2));
	swa.getGamePanel().getTileLabel(5, 6).getModel().setSquare(new Square(1, 1));

	board.setCurrentScore(1500);
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
