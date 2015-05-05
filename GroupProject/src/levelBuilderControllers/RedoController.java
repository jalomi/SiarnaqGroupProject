package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Move;

/**
 * Controller that redoes last level that was undone
 * @author Kevin
 *
 */
public class RedoController implements ActionListener{
	
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
	 * Creates controller based on the entity and application
	 * @param m
	 * @param a
	 */
	public RedoController(LevelBuilder m, LevelBuilderApplication a){
		this.application = a;
		this.model = m;
	}
	
	/**
	 * Handles press of redo button
	 */
	@Override
	public void actionPerformed(ActionEvent e){
		process();
	}
	
	/**
	 * Executes last move that was undone
	 * @return
	 */
	public boolean process(){
		Move m = model.removeRedoMove();
		if(m==null){
			System.out.print("null!!!");
			return false;}
		
		if(m.doMove()){
			System.out.print("Redo!!!");
			model.recordRedoneMove(m);
		}
		application.repaint();
		return true;
	}
		
}

