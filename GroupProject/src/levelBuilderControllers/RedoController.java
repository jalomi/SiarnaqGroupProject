package levelBuilderControllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.Move;
public class RedoController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public RedoController(LevelBuilder m, LevelBuilderApplication a){
		this.application = a;
		this.model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		process();
	}
	
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

