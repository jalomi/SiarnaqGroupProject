package levelBuilderControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;

import org.json.JSONException;

import JSONSerializer.LevelJSONSerializer;
import levelBuilderBoundary.LevelBuilderApplication;
import levelBuilderEntity.LevelBuilder;

public class ChoosingLevelController implements ActionListener{
	
	public static final String TAG = "ChoosingLevelController :: ";
	
	public LevelBuilder model;
	public LevelBuilderApplication app;
	
	public ChoosingLevelController(LevelBuilderApplication app) throws IOException, JSONException{
		this.model = LevelBuilder.newInstance();
		this.app = app;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		@SuppressWarnings("unchecked")
		JComboBox<String> cb = (JComboBox<String>)event.getSource();
		
		String fileNameToSave = model.getLevelType() + " " + model.getLevelNumber();
		if(fileNameToSave.equals("Puzzle 0")) {
			System.out.println(TAG + "Nothing to Save");
		} else {
			LevelJSONSerializer json = new LevelJSONSerializer(fileNameToSave);
			try {
				json.saveSingleLevel(model.generateLevel(model.getLevelType()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		String selected = (String)cb.getSelectedItem();
		if(selected.equals("New Level")) {
			System.out.println(TAG + "New Level Selected");
			//REFRESH MODEL AND BOUNDARIS WHEN CHOSSING NEW LEVEL
			model.setLevelNumber(0);
			app.getInputPanel().getLevel().setText(String.valueOf(model.getLevelNumber()));
			model.setStarScore(0, 0);
			app.getInputPanel().getScore1().setText(String.valueOf(model.getStarScore(0)));
			model.setStarScore(1,0);
			app.getInputPanel().getScore2().setText(String.valueOf(model.getStarScore(1)));
			model.setStarScore(2, 0);
			app.getInputPanel().getScore3().setText(String.valueOf(model.getStarScore(2)));
			model.setMoves(0);
			app.getInputPanel().getMaxMoves().setText(String.valueOf(model.getMoves()));
			model.setSeconds(0);
			app.getInputPanel().getSeconds().setText(String.valueOf(model.getSeconds()));
			for(int i=0;i<5;i++){
				model.setPercents(i, 0);
			}
			model.setPercents(5, 100);
			app.getInputPanel().getPercent1().setText(String.valueOf(100*model.getPercent(0)));
			app.getInputPanel().getPercent2().setText(String.valueOf(100*model.getPercent(1)));
			app.getInputPanel().getPercent3().setText(String.valueOf(100*model.getPercent(2)));
			app.getInputPanel().getPercent4().setText(String.valueOf(100*model.getPercent(3)));
			app.getInputPanel().getPercent5().setText(String.valueOf(100*model.getPercent(4)));
			app.getInputPanel().getPercent6().setText(String.valueOf(100*model.getPercent(5)));
			for(int i=1;i<=3;i++){
				model.disallowSpecials(i);
			}
			app.getInputPanel().getSwapEnabled().setSelected(model.getSpecialEnabled(2));
			app.getInputPanel().getResetEnabled().setSelected(model.getSpecialEnabled(1));
			app.getInputPanel().getRemoveEnabled().setSelected(model.getSpecialEnabled(3));
			for(int i=1;i<3;i++){
				model.setPercentM(i, 0);
			}
			model.setPercentM(0,100);
			app.getInputPanel().getPercentx1().setText(String.valueOf(100*model.getPercentM(0)));
			app.getInputPanel().getPercentx2().setText(String.valueOf(100*model.getPercentM(1)));
			app.getInputPanel().getPercentx3().setText(String.valueOf(100*model.getPercentM(2)));
			app.getGenerateBtn().setEnabled(false);
			app.getPreviewBtn().setEnabled(false);
			for(int x=0;x<9;x++){
				for(int y=0;y<9;y++){
					model.setTileActive(x, y);
				}
			}
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					model.setBucketEnabled(i, false);
					app.getGamePanel().getTile(i, j).setSelected(false);
				}
			}
			
			return;
		}
		LevelJSONSerializer load = new LevelJSONSerializer(selected);
		System.out.println(TAG + "Save:" + fileNameToSave + " Selected:" + selected.substring(0, 1));
		try {
			//Level level = LevelBuilder.getLevel(); 
			LevelBuilder.level = load.loadSingleLevel(selected.substring(0, 1));
			//System.out.println(TAG + "level: " + level.getLevelType() + " " + level.getLevelNumber());
			//assign level's values to all LevelBuilder's attributes
			model.assignEntities(selected.substring(0, selected.indexOf(" ")));
			//change boundary's values
			app.getInputPanel().getLevel().setText(String.valueOf(model.getLevelNumber()));
			app.getInputPanel().getScore1().setText(String.valueOf(model.getStarScore(0)));
			app.getInputPanel().getScore2().setText(String.valueOf(model.getStarScore(1)));
			app.getInputPanel().getScore3().setText(String.valueOf(model.getStarScore(2)));
			app.getInputPanel().getMaxMoves().setText(String.valueOf(model.getMoves()));
			app.getInputPanel().getSeconds().setText(String.valueOf(model.getSeconds()));
			
			app.getInputPanel().getPercent1().setText(String.valueOf(100*model.getPercent(0)));
			app.getInputPanel().getPercent2().setText(String.valueOf(100*model.getPercent(1)));
			app.getInputPanel().getPercent3().setText(String.valueOf(100*model.getPercent(2)));
			app.getInputPanel().getPercent4().setText(String.valueOf(100*model.getPercent(3)));
			app.getInputPanel().getPercent5().setText(String.valueOf(100*model.getPercent(4)));
			app.getInputPanel().getPercent6().setText(String.valueOf(100*model.getPercent(5)));
			
			app.getInputPanel().getSwapEnabled().setSelected(model.getSpecialEnabled(2));
			app.getInputPanel().getResetEnabled().setSelected(model.getSpecialEnabled(1));
			app.getInputPanel().getRemoveEnabled().setSelected(model.getSpecialEnabled(3));
			
			app.getInputPanel().getPercentx1().setText(String.valueOf(100*model.getPercentM(0)));
			app.getInputPanel().getPercentx2().setText(String.valueOf(100*model.getPercentM(1)));
			app.getInputPanel().getPercentx3().setText(String.valueOf(100*model.getPercentM(2)));
			
			app.getGenerateBtn().setEnabled(true);
			app.getPreviewBtn().setEnabled(true);
			
			app.getInputPanel().getType().setSelectedItem(selected.substring(0, selected.indexOf(" ")));
			System.out.println("!!!: " + selected.substring(0, selected.indexOf(" ")));
			
			//Game Panel
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					if(!model.getTileActiveAt(i, j)){
						app.getGamePanel().getTile(i, j).setSelected(true);
					}
					else{
						app.getGamePanel().getTile(i, j).setSelected(false);
					}
				}
			}
			
			if(model.getLevelType().equals("Release")){
				for(int i=0;i<9;i++){
					if(model.getBucketEnabled(i)){
						app.getCheckBoxPanel().getCheckBox(i).setSelected(true);
						model.setTileActive(8,i);
					} 
				}
			}
			//empty 2 stacks
			model.moveStack.clear();
			model.redoStack.clear();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
