package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.SetLevelTypeMove;

public class SelectLevelTypeController implements ActionListener {
	LevelBuilder model;
	LevelBuilderApplication application;
	
	public SelectLevelTypeController(LevelBuilder m, LevelBuilderApplication a)
	{
		this.model=m;
		this.application=a;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		JComboBox<String> cb = (JComboBox<String>)ae.getSource();
		update(cb);
	}

	public void update(JComboBox<String> cb) {
		// TODO Auto-generated method stub
		String type=(String)cb.getSelectedItem();
		SetLevelTypeMove m=new SetLevelTypeMove(model, type, cb, this);
		if(m.doMove())
			model.recordMove(m);
	}

}
