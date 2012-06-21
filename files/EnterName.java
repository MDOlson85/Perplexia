package perplexia;

import javax.swing.*;

public class EnterName extends JFrame
{
	/**
	 * class used for entering name to be placed on high scores list
	 */
	private static final long serialVersionUID = 1L;
	
	private String name = "Jo Mama"; //variables used to temporarily hold values
	private String topName;
	private String middleName;
	private String bottomName;
	private int topScore;
	private int middleScore;
	private int bottomScore;
		
	public EnterName( int num, int score )
	{		
		ReadSaveFile saveFile = new ReadSaveFile();

		//j option pane for name prompt
		name = JOptionPane.showInputDialog( "Enter your name (no longer than 20 characters):" );
		
		if( name == null)
		{
			return; //if cancel selected, go straight to high scores menu
		}
		
		name = name.replaceAll( " ", "_" ); //replaces spaces with underscores to create one string for save file
		
		if( name.length() > 20 ) //recursive function if name is too long
		{
			JOptionPane.showMessageDialog( EnterName.this,
				"The name you entered was too long, please try again.",
				"Enter Your Name", JOptionPane.PLAIN_MESSAGE );
				
			EnterName eName = new EnterName( num, score );
			eName.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			score = -10000; //sets score to close last opened entername class
		}
		else if( name.length() < 1 ) //recursive function if name is too short
		{
			JOptionPane.showMessageDialog( EnterName.this,
				"The name you entered was too short, please try again.",
				"Enter Your Name", JOptionPane.PLAIN_MESSAGE );
				
			EnterName eName = new EnterName( num, score );
			eName.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			score = -10000;
		}
		
		if( num == 1) //if statement if square maps was chosen
		{
			topName = saveFile.getTopScorer(); //receive files from save file
			middleName = saveFile.getMiddleScorer();
			setBottomName(saveFile.getBottomScorer());
		
			topScore = saveFile.getTopScore();
			middleScore = saveFile.getMiddleScore();
			bottomScore = saveFile.getBottomScore();
			
			if( score > topScore ) //checks to see where new name is going to be placed
			{
				saveFile.setTopScorer( name );
				saveFile.setTopScore( score );
				saveFile.setMiddleScorer( topName );
				saveFile.setMiddleScore( topScore );
				saveFile.setBottomScorer( middleName );
				saveFile.setBottomScore( middleScore );
			}
			else if( score > middleScore )
			{
				saveFile.setTopScorer( topName );
				saveFile.setTopScore( topScore );
				saveFile.setMiddleScorer( name );
				saveFile.setMiddleScore( score );
				saveFile.setBottomScorer( middleName );
				saveFile.setBottomScore( middleScore );
			}
			else if( score > bottomScore )
			{
				saveFile.setTopScorer( topName );
				saveFile.setTopScore( topScore );
				saveFile.setMiddleScorer( middleName );
				saveFile.setMiddleScore( middleScore );
				saveFile.setBottomScorer( name );
				saveFile.setBottomScore( score );
			}
		}
		else if( num == 2) //if statement if tall maps was chosen
		{
			topName = saveFile.getTopScorer2();
			middleName = saveFile.getMiddleScorer2();
			setBottomName(saveFile.getBottomScorer2());
		
			topScore = saveFile.getTopScore2();
			middleScore = saveFile.getMiddleScore2();
			bottomScore = saveFile.getBottomScore2();
			
			if( score > topScore ) //checks to see where new name is going to be placed
			{
				saveFile.setTopScorer2( name );
				saveFile.setTopScore2( score );
				saveFile.setMiddleScorer2( topName );
				saveFile.setMiddleScore2( topScore );
				saveFile.setBottomScorer2( middleName );
				saveFile.setBottomScore2( middleScore );
			}
			else if( score > middleScore )
			{
				saveFile.setTopScorer2( topName );
				saveFile.setTopScore2( topScore );
				saveFile.setMiddleScorer2( name );
				saveFile.setMiddleScore2( score );
				saveFile.setBottomScorer2( middleName );
				saveFile.setBottomScore2( middleScore );
			}
			else if( score > bottomScore )
			{
				saveFile.setTopScorer2( topName );
				saveFile.setTopScore2( topScore );
				saveFile.setMiddleScorer2( middleName );
				saveFile.setMiddleScore2( middleScore );
				saveFile.setBottomScorer2( name );
				saveFile.setBottomScore2( score );
			}
		}
		else if( num == 3) //if statement if wide maps was chosen
		{
			topName = saveFile.getTopScorer3();
			middleName = saveFile.getMiddleScorer3();
			setBottomName(saveFile.getBottomScorer3());
		
			topScore = saveFile.getTopScore3();
			middleScore = saveFile.getMiddleScore3();
			bottomScore = saveFile.getBottomScore3();
			
			if( score > topScore ) //checks to see where new name is going to be placed
			{
				saveFile.setTopScorer3( name );
				saveFile.setTopScore3( score );
				saveFile.setMiddleScorer3( topName );
				saveFile.setMiddleScore3( topScore );
				saveFile.setBottomScorer3( middleName );
				saveFile.setBottomScore3( middleScore );
			}
			else if( score > middleScore )
			{
				saveFile.setTopScorer3( topName );
				saveFile.setTopScore3( topScore );
				saveFile.setMiddleScorer3( name );
				saveFile.setMiddleScore3( score );
				saveFile.setBottomScorer3( middleName );
				saveFile.setBottomScore3( middleScore );
			}
			else if( score > bottomScore )
			{
				saveFile.setTopScorer3( topName );
				saveFile.setTopScore3( topScore );
				saveFile.setMiddleScorer3( middleName );
				saveFile.setMiddleScore3( middleScore );
				saveFile.setBottomScorer3( name );
				saveFile.setBottomScore3( score );
			}
		}
		
	}

	public void setBottomName(String bottomName)
	{
		this.bottomName = bottomName;
	}

	public String getBottomName()
	{
		return bottomName;
	}
}