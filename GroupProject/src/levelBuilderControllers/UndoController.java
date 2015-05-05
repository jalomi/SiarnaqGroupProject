package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Move;

/**
 * Controller that undoes the last move made in Level Builder
 * @author Kevin
 *
 */
public class UndoController implements ActionListener{
	
	/**
	 * the Level Builder entity
	 */
	LevelBuilder model;
	
	/**
	 * the Level Builder application
	 */
	LevelBuilderApplication application;
	
	/**
	 * Constructor
	 * Creates the controller based on the entity and application
	 * @param m
	 * @param a
	 */
	public UndoController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.application=a;
		this.model=m;
	}
	
	/**
	 * Handles push of undo button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		process();
	}
	
	/**
	 * Removes last move from game
	 * @return
	 */
	public boolean process()
	{
		Move m = model.removeLastMove();
		if (m == null) { return false; }
	
		if (m.undo()) {
			model.recordRedoableMove(m);
			/*if(m instanceof SetMoveNumberMove)
				((SetMoveNumberMove)m).setOldValue(model.getMoves());*/
		}
		
		application.repaint();
		return true;
	}

}
