package scene.view;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * The history score table builder.
 * This class only accepts two array lists which are nameList in String and scoreList in Integer.
 * In uses two array lists to constructs a GridPane which presents all information about two array lists in a table.
 * It is used for history scene to show score list.
 * 
 * @author ryan
 *
 */
public class ScoreTable extends GridPane {
	
	/**
	 * Creates a GridPane.
	 * 
	 * @param nameList the name list of players
	 * @param scoreList the score list of players
	 */
	public ScoreTable(ArrayList<String> nameList, ArrayList<Integer> scoreList) {
		super();
		createRankBox(this, nameList, scoreList);
	}
	
	/**
	 * Creates a table with 3 columns: rank, name, score.
	 * 
	 * @param gridPane the score table
	 * @param nameList the name list of players
	 * @param scoreList the score list of players
	 */
	@SuppressWarnings("exports")
	public void createRankBox(GridPane gridPane, ArrayList<String> nameList, ArrayList<Integer> scoreList) {
		gridPane.setHgap(50);
		gridPane.setVgap(20);
		for (int i = 0; i < nameList.size(); i++) {
			Text rank = new Text(String.valueOf(i + 1));
			Text name = new Text(nameList.get(i));
			Text score = new Text(scoreList.get(i).toString());
			rank.setFill(Color.YELLOW);
			name.setFill(Color.YELLOW);
			score.setFill(Color.YELLOW);
			gridPane.add(rank, 0, i);
			gridPane.add(name, 1, i);
			gridPane.add(score, 2, i);
		}
	}
}
