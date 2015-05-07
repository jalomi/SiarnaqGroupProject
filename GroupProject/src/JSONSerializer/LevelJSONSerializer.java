package JSONSerializer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import sixesWildEntity.Elimination;
import sixesWildEntity.Level;
import sixesWildEntity.Lightning;
import sixesWildEntity.Puzzle;
import sixesWildEntity.Release;

/**
 * loads and saves levels using JSON
 * @author Xuanzhe 
 *
 */
public class LevelJSONSerializer {
	/** TAG for this class */
	public static final String TAG = "LevelJSONSerializer";

	/** name for file folder to be stored under */
    private String fileName;

    /**
     * Constructor
     * @param fName
     */
    public LevelJSONSerializer(String fName) {
        fileName = "json/" + fName;
    }

    /**
     * Saves levels with JSON
     * @param levels
     * @throws JSONException
     * @throws IOException
     */
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
    
    /**
     * loads levels with JSON
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public ArrayList<Level> loadLevels() throws IOException, JSONException {
        ArrayList<Level> levels = new ArrayList<Level>();
        BufferedReader reader = null;
        try {
            // open and read the file into a StringBuilder
            InputStream in = new FileInputStream(fileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                // line breaks are omitted and irrelevant
                jsonString.append(line);
            }
            
            // parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // build the array of levels from JSONObjects
            for (int i = 0; i < array.length(); i++) {
            	//levels.add(new Puzzle(array.getJSONObject(i));
            }
        } catch (FileNotFoundException e) {
            //ignore this one, since it happens when we start fresh
        	//when no levels to read
        } finally {
            if (reader != null)
                reader.close();
        }
		return levels;
    }
    
    /**
     * saves one level using JSON
     * @param level
     * @throws JSONException
     * @throws IOException
     */
    public void saveSingleLevel(Level level) throws JSONException, IOException {
        JSONObject json = level.toJSON();
        Writer writer = null;
        try {
            OutputStream out = new FileOutputStream(fileName);
            writer = new OutputStreamWriter(out);
            writer.write(json.toString());
        } finally {
            if (writer != null)
                writer.close();
        }
    }
    
    /**
     * loads one level using JSON
     * @param type
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public Level loadSingleLevel(String type) throws IOException, JSONException {
        Level level = null;
        BufferedReader reader = null;
        try {
            // open and read the file into a StringBuilder
            InputStream in = new FileInputStream(fileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }
            
            // parse the JSON using JSONTokener
            JSONObject json = (JSONObject) new JSONTokener(jsonString.toString()).nextValue();
            
            System.out.println(TAG + " b" + type);
            if(type.equals("E")) {
            	System.out.println(TAG + " " + type);
            	level = new Elimination(json);
            } else if(type.equals("L")) {
            	System.out.println(TAG + " " + type);
            	level = new Lightning(json);
            } else if(type.equals("P")) {
            	System.out.println(TAG + " " + type);
            	level = new Puzzle(json);
            } else if(type.equals("R")) {
            	System.out.println(TAG + " " + type);
            	level = new Release(json);
            }
            
        } catch (FileNotFoundException e) {
            System.err.println(TAG + " not such a file: " + fileName);
        } finally {
            if (reader != null)
                reader.close();
        }
        
        if(level == null) {
        	System.out.println(TAG + "null is returned");
        }
		return level;
    }
    
    /**
     * Saves a list of levels using JSON
     * @param levelList
     * @throws IOException
     */
    public void saveLevelList(ArrayList<String> levelList) throws IOException {
        // build an array in JSON
        JSONArray array = new JSONArray();
        for (String s : levelList)
            array.put(s);

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
    
    /**
     * loads a list of levels using JSON
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public ArrayList<String> loadLevelList() throws IOException, JSONException {
        ArrayList<String> levelList = new ArrayList<String>();
        BufferedReader reader = null;
        try {
            // open and read the file into a StringBuilder
            InputStream in = new FileInputStream(fileName);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                // line breaks are omitted and irrelevant
                jsonString.append(line);
            }
            
            // parse the JSON using JSONTokener
            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            // build the array of levels from JSONObjects
            for (int i = 0; i < array.length(); i++) {
            	levelList.add(array.getString(i));
            }
        } catch (FileNotFoundException e) {
            //ignore this one, since it happens when we start fresh
        	//when no levels to read
        } finally {
            if (reader != null)
                reader.close();
        }
		return levelList;
    }
}
