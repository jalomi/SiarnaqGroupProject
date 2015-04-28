package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.BucketEnableMove;
import levelBuilderMoves.SpecialMoveEnableMove;

public class ActivateBucketforSixesController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int bucket;
		
		public ActivateBucketforSixesController(LevelBuilder model,
				LevelBuilderApplication application, int bucket) {
			// TODO Auto-generated constructor stub
			this.model=model;
			this.application=application;
			this.bucket=bucket;
		}

		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			JCheckBox ch=(JCheckBox)ae.getSource();
			update(ch);
		}

		private void update(JCheckBox ch) {
			// TODO Auto-generated method stub
			boolean enabled=ch.isSelected();
			BucketEnableMove m=new BucketEnableMove(model, enabled, ch, bucket);
			if(m.doMove())
			{
				if(enabled==true)
					System.out.println(bucket+" is true");
				else
					System.out.println(bucket+" is false");
				model.recordMove(m);
			}
		}
}
