package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;
import levelBuilderMoves.BucketEnableMove;
/**
 * controller of check boxes for release mode only
 * @author:
 */
public class ActivateBucketforSixesController implements ActionListener{
	LevelBuilder model;
	LevelBuilderApplication application;
	int bucket;
		/**
		 * Constructor of controller takes in entity and boundary with the location of the bucket
		 * @param model: level builder entity
		 * @param application: level builder boundary
		 * @param bucket : the location of the bucket
		 */
		public ActivateBucketforSixesController(LevelBuilder model,
				LevelBuilderApplication application, int bucket) {
			// TODO Auto-generated constructor stub
			this.model=model;
			this.application=application;
			this.bucket=bucket;
		}
		/**
		 * select a certain check box for release column
		 */
		@Override
		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			JCheckBox ch=(JCheckBox)ae.getSource();
			update(ch);
		}
		/**
		 * update entity by doing the bucketEnableMove
		 * @param ch check boxes
		 */
		public void update(JCheckBox ch) {
			// TODO Auto-generated method stub
			boolean enabled=ch.isSelected();
			BucketEnableMove m=new BucketEnableMove(model, enabled, ch, bucket);
			if(m.doMove())
			{
				if(enabled==true)
				{
					System.out.println(bucket+" is true");
					model.setTileActive(8,bucket);
					System.out.println("tile x:"+8+" y: "+ bucket +"is activated");
				}
				else
				{
					System.out.println(bucket+" is false");
					model.setTileDeactive(8,bucket);
					System.out.println("tile x:"+8+" y: "+ bucket +"is deactivated");
					
				}
				model.recordMove(m);
			}
		}
}
