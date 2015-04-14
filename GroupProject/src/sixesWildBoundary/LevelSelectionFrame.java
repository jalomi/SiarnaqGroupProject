package sixesWildBoundary;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import sixesWildEntity.Level;



@SuppressWarnings("serial")
public class LevelSelectionFrame extends JFrame {
	
	public static final String TAG = "ChooseLevelFrame";

	DefaultListModel<String> listMode = new DefaultListModel<>();
	JList<String> levelList;
	
	ArrayList<Level> levels = new ArrayList<Level>();
	
	private void populateLevels() {
		for(int i = 1; i <= 16; i++) {
			Level level = new Level(i);
			levels.add(level);
		}
	}
	
	
	private void initializeList() {
		this.populateLevels();
		for(Level level : levels) {
			listMode.addElement(String.valueOf(level.getNumber()));
		}
		levelList = new JList<>(listMode);
		levelList.setVisible(true);
		
		levelList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("rawtypes")
				JList l = (JList)e.getSource();
				if(e.getClickCount() == 1) {
					int index = l.locationToIndex(e.getPoint());
					Level level = LevelSelectionFrame.this.levels.get(index);
					if(LevelSelectionFrame.this != null) {
						LevelSelectionFrame.this.dispose();
					}
					new SixesWildApplication(level);
				}
			}
		});
		
		this.add(levelList);
	}
	

	/**
	 * Create the frame.
	 */
	public LevelSelectionFrame() {
		this.initializeList();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 100, 500, 500);
		this.setLocationRelativeTo(null);
		this.setTitle(LevelSelectionFrame.TAG);
		this.setVisible(true);
	}

}
