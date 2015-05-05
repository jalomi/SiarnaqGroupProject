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
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>)ae.getSource();
		update(cb);
	}

	public void update(JComboBox<String> cb) {
		String type=(String)cb.getSelectedItem();
		SetLevelTypeMove m=new SetLevelTypeMove(model, type, cb, this);
		if(m.doMove())
		{
			if(model.getLevelType().equals("Release")){
				if((model.getLevelNumber()==0 && model.getMoves()==0)||model.getPercent(5)==1){
					application.getGenerateBtn().setEnabled(false);
					application.getPreviewBtn().setEnabled(false);
				}
			}
			else{
				if(model.getLevelNumber()==0 && model.getMoves()==0){
					application.getGenerateBtn().setEnabled(false);
					application.getPreviewBtn().setEnabled(false);
				}
			}

			model.recordMove(m);
			if(model.getLevelType()=="Release")
			{

				for(int i=0; i<9; i++)
				{
					model.setTileDeactive(8, i);
					application.getTiles(i, 8).setSelected(true);
					application.getTiles(i, 8).setEnabled(false);
					application.getCheckBoxPanel().getCheckBox(i).setEnabled(true);

				}
				
			}
			else
			{
				for(int i=0; i<9; i++)
				{
					model.setTileActive(8, i);
					application.getTiles(i, 8).setEnabled(true);
					application.getTiles(i, 8).setSelected(false);
					application.getCheckBoxPanel().getCheckBox(i).setSelected(false);
					application.getCheckBoxPanel().getCheckBox(i).setEnabled(false);
				}
			}
		}
	}

}
