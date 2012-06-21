package perplexia;

import javax.swing.*;

public class HighScores extends JFrame
{
	/**
	 * This class displays the high scores list
	 */
	private static final long serialVersionUID = 1L;
	
	private String name1 = "Michael Olson"; //variables for high scores list
	private String name2 = "Ron Simani";
	private String name3 = "Zane Skinner";
	private String name4 = "Michael Olson";
	private String name5 = "Ron Simani";
	private String name6 = "Zane Skinner";
	private String name7 = "Michael Olson";
	private String name8 = "Ron Simani";
	private String name9 = "Zane Skinner";
	private int score3 = 1111;
	private int score2 = 2222;
	private int score1 = 3333;
	private int score6 = 1111;
	private int score5 = 2222;
	private int score4 = 3333;
	private int score9 = 1111;
	private int score8 = 2222;
	private int score7 = 3333;
		
	public HighScores()
	{		
		ReadSaveFile saveFile = new ReadSaveFile();
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		name1 = saveFile.getTopScorer(); //retrieves variables from save file
		name2 = saveFile.getMiddleScorer();
		name3 = saveFile.getBottomScorer();
		name4 = saveFile.getTopScorer2();
		name5 = saveFile.getMiddleScorer2();
		name6 = saveFile.getBottomScorer2();
		name7 = saveFile.getTopScorer3();
		name8 = saveFile.getMiddleScorer3();
		name9 = saveFile.getBottomScorer3();
		
		name1 = name1.replaceAll( "_", " " ); //replaces "_" with spaces so high scores menu only displays spaces
		name2 = name2.replaceAll( "_", " " );
		name3 = name3.replaceAll( "_", " " );
		name4 = name4.replaceAll( "_", " " );
		name5 = name5.replaceAll( "_", " " );
		name6 = name6.replaceAll( "_", " " );
		name7 = name7.replaceAll( "_", " " );
		name8 = name8.replaceAll( "_", " " );
		name9 = name9.replaceAll( "_", " " );
		
		score1 = saveFile.getTopScore();
		score2 = saveFile.getMiddleScore();
		score3 = saveFile.getBottomScore();
		score4 = saveFile.getTopScore2();
		score5 = saveFile.getMiddleScore2();
		score6 = saveFile.getBottomScore2();
		score7 = saveFile.getTopScore3();
		score8 = saveFile.getMiddleScore3();
		score9 = saveFile.getBottomScore3();
		
		JOptionPane.showMessageDialog( HighScores.this, //j option pane which houses high scores lists
			"               SQUARE MAPS HIGH SCORES\n\n" +
			"1) " + name1 + "   -   Score: " + score1 + "\n" +
			"2) " + name2 + "   -   Score: " + score2 + "\n" +
			"3) " + name3 + "   -   Score: " + score3 + "\n" +
			"\n                 TALL MAPS HIGH SCORES\n\n" +
			"1) " + name4 + "   -   Score: " + score4 + "\n" +
			"2) " + name5 + "   -   Score: " + score5 + "\n" +
			"3) " + name6 + "   -   Score: " + score6 + "\n" +
			"\n                 WIDE MAPS HIGH SCORES\n\n" +
			"1) " + name7 + "   -   Score: " + score7 + "\n" +
			"2) " + name8 + "   -   Score: " + score8 + "\n" +
			"3) " + name9 + "   -   Score: " + score9 + "\n",
			"High Scores List", JOptionPane.PLAIN_MESSAGE );
	}
}