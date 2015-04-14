package levelBuilderBoundary;

import junit.framework.TestCase;

public class TestLevelBuilderPreviewApplication extends TestCase {
	LevelBuilderPreviewApplication prev;
	
	protected void setUp()
	{
		prev=new LevelBuilderPreviewApplication();
	}
	
	protected void tearDown() {
		if (prev != null) {
			prev.dispose();
		}
	}
	
	public void testLevelBuilderPreview() {
		System.out.println("Level builder preview");
	}
}
