package common.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class provides static methods to access to local score file and write to local score file.
 * <p>
 * To prevent duplicate instances of this class, it is set to Singleton.
 * Every scene is able to access to this class and get corresponging information.
 * 
 * @author ryan
 *
 */
public class ScoreFileProcesser {

	/**
	 * Singleton instance of ScoreFileProcesser.
	 */
	private static ScoreFileProcesser instance = null;
	
	/**
	 * Static score list. Instantialized with null.
	 */
	private static ArrayList<Integer> scoreList = null;
	
	/**
	 * Static name list. Instantialized with null.
	 */
	private static ArrayList<String> nameList = null;
	
	/**
	 * File path to 'Score.txt'.
	 */
	private static String filePath = "src/main/resources/Score.txt";
	
	/**
	 * Creates two array lists and reads score from local score file.
	 */
	private ScoreFileProcesser() {
		ScoreFileProcesser.scoreList = new ArrayList<Integer>();
		ScoreFileProcesser.nameList = new ArrayList<String>();
		readScore();
	}
	
	/**
	 * Gets ScoreFileProcesser Singleton.
	 * 
	 * @return Singleton instance of ScoreFileProcesser, if it is not instantialized, creates one
	 */
	public static ScoreFileProcesser getInstance() {
		if (instance == null) {
			instance = new ScoreFileProcesser();
		}
		return instance;
	}
	
	/**
	 * Gets the score list.
	 * 
	 * @return Singleton instance of score list, if it is not instantialized, creates one
	 */
	public static ArrayList<Integer> getScoreList(){
		if (instance == null) {
			instance = new ScoreFileProcesser();
		}
		return scoreList;
	}
	
	/**
	 * Gets the name list.
	 * 
	 * @return Singleton instance of name list, if it is not instantialized, creates one
	 */
	public static ArrayList<String> getNameList(){
		if (instance == null) {
			instance = new ScoreFileProcesser();
		}
		return nameList;
	}
	
	/**
	 * Reads local score file and saves information about score and names into score list and name list.
	 * <p>
	 * If there is no record in score file, saves nothing into two lists (null).
	 */
	public void readScore() {
		File file = new File(getFilePath());
		try (FileReader reader = new FileReader(file);
	             BufferedReader br = new BufferedReader(reader)){
			
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] strings = line.split(" ");
				if (strings.length < 2) {
					return;
				} else if (strings.length == 2) {
					nameList.add(strings[0]);
					scoreList.add(Integer.valueOf(strings[1]));
				} else {
					String aName = "";
					int length = strings.length;
					for (int i = 0; i < length; i++) {
						if (i != length - 1) {
							aName += strings[i] + " ";
						}
					}
					nameList.add(aName);
					scoreList.add(Integer.valueOf(strings[length - 1]));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Compares the score with static score list, if the score is ranked to be top 10, add it to the array list.
	 * <p>
	 * If there is more than 10 records after addition, delete the last one.
	 * 
	 * @param name the name of current player
	 * @param score the score of current player
	 */
	public static void processList(String name, int score) {
		ArrayList<Integer> tempScoreList = getScoreList();
		ArrayList<String> tempNameList = getNameList();
		boolean update = false;
		if (tempScoreList.size() == 0) {
			tempScoreList.add(0, (Integer)score);
			tempNameList.add(0, name);
			update = true;
		} else {
			for (int i = 0; i < tempScoreList.size(); i++) {
				if (score >= tempScoreList.get(i)) {
					tempScoreList.add(i,(Integer)score);
					tempNameList.add(i, name);
					if (tempScoreList.size() == 11) {
						tempScoreList.remove(10);
						tempNameList.remove(10);
					}
					update = true;
					break;
				} else if (i == tempScoreList.size() - 1 && i < 9) {
					tempScoreList.add(i + 1,(Integer)score);
					tempNameList.add(i + 1, name);
					update = true;
					break;
				}
			}
		} 
		if (update) {
			scoreList = tempScoreList;
			nameList = tempNameList;
			updateFile(getFilePath());
		}
	}
	
	/**
	 * Writes new score list and new name list into local score file.
	 * 
	 * @param filePath file path to local score file, 'Score.txt'
	 */
	private static void updateFile(String filePath) {
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			for (int i = 0; i < scoreList.size(); i++) {
				String str = nameList.get(i) + " " + scoreList.get(i) + "\n";
				out.write(str);
			}
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		ScoreFileProcesser.filePath = filePath;
	}
	
}
