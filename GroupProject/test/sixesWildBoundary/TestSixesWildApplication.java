package sixesWildBoundary;

import junit.framework.TestCase;
import sixesWildBoundary.SixesWildApplication;
import sixesWildEntity.Board;
import sixesWildEntity.Level;
import sixesWildEntity.SixesWild;

public class TestSixesWildApplication extends TestCase {
	SixesWildApplication s;
	Board board;
	SixesWild sw;
	
	@Override
	protected void setUp() {
		sw = SixesWild.newInstance();
		board = Board.newInstance();
	}
	
	@Override
	protected void tearDown() {
		if(s != null) {
			s.dispose();
		}
	}
	
	public void testPuzzle() {
		Level l = sw.getLevels().get(0);
		board.setLevel(l);
		s = new SixesWildApplication(sw);
		
		l = sw.getLevels().get(1);
		board.setLevel(l);
		s = new SixesWildApplication(sw);
		
		l = sw.getLevels().get(2);
		board.setLevel(l);
		s = new SixesWildApplication(sw);
		
		l = sw.getLevels().get(3);
		board.setLevel(l);
		s = new SixesWildApplication(sw);
	}
	
	public void testLightning() {
		Level l = sw.getLevels().get(1);
		board.setLevel(l);
		s = new SixesWildApplication(sw);
	}
	
	public void testElimination() {
		Level l = sw.getLevels().get(2);
		board.setLevel(l);
		s = new SixesWildApplication(sw);
	}
	
	public void testRelease() {
		Level l = sw.getLevels().get(3);
		board.setLevel(l);
		s = new SixesWildApplication(sw);
	}
}
