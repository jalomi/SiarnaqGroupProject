package levelBuilderBoundary;

import junit.framework.TestCase;

public class TestLevelBuilderPreviewApplication extends TestCase {
	LevelBuilderPreviewApplication prev;
	
	@Override
	protected void setUp(){
		try {
			prev=new LevelBuilderPreviewApplication();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void tearDown() {
		if (prev != null) {
			prev.dispose();
		}
	}
	
	public void testLevelBuilderPreview() {
		System.out.println("Level builder preview");
	}
}
