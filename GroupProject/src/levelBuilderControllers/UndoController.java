package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Move;

public class UndoController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public UndoController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.application=a;
		this.model=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	public boolean process()
	{
		Move m = model.removeLastMove();
		if (m == null) { return false; }
	
		if (m.undo()) {
			model.recordRedoableMove(m);
		}
	
		application.repaint();
		return true;
	}

}