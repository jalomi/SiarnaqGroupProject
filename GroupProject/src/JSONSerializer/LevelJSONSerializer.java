package JSONSerializer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import sixesWildEntity.Level;

public class LevelJSONSerializer {

    private String fileName;

    public LevelJSONSerializer(String fName) {
        fileName = fName;
    }

    public void saveLevels(ArrayList<Level> levels) throws JSONException, IOException {
        // build an array in JSON
        JSONArray array = new JSONArray();
        for (Level l : levels)
            array.put(l.toJSON());

        // write the file to disk
        Writer writer = null;
        try {
            OutputStream out = new FileOutputStream(fileName);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
    
    public ArrayList<Level> loadLevels() {
		return null;
    	
    }
}
