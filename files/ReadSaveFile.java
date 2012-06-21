package perplexia;

import java.io.*;
import java.util.*;

public class ReadSaveFile
{
	/**
	 * This class is used to read and write to save file
	 */
	
	//The save file is read whenever a level is created, controls are set, or high scores are viewed or changed
	private static final long serialVersionUID = 1L;
	
   	private Scanner input;
   	private Formatter output;
   
   	private String name1 = "Michael"; //default values for save file if one is created
   	private String name2 = "Zane";
   	private String name3 = "Ron";
   	private String name4 = "Michael";
   	private String name5 = "Zane";
   	private String name6 = "Ron";
   	private String name7 = "Michael";
   	private String name8 = "Zane";
   	private String name9 = "Ron";
   	private int score1 = 3333;
   	private int score2 = 2222;
   	private int score3 = 1111;
   	private int score4 = 3333;
   	private int score5 = 2222;
   	private int score6 = 1111;
    private int score7 = 3333;
   	private int score8 = 2222;
   	private int score9 = 1111;
   	private int up = 38;
   	private int down = 40;
   	private int left = 37;
   	private int right = 39;
   	private File file = new File( "perplexia.sav" ); //name of save file

   	//checks if a save file exists and creates one if one doesn't
	public void openFile()
   	{
   		if( file.exists() )
   		{
			readFile();
   		}
   		else
   		{				
   			writeFile();
   		}
	}
   
	//class for writing to save file
    public void writeFile()
    {
   		try
      	{
     		output = new Formatter( "perplexia.sav" );
     	}
    	catch ( SecurityException securityException )
    	{
    		System.err.println( "You do not have write access to this file." );
      		System.exit( 1 );
    	} 
     	catch ( FileNotFoundException filesNotFoundException )
     	{
     		System.err.println( "Error creating file." );
       		System.exit( 1 );
     	}
     		
      	output.format( name1 );
      	output.format( " " );
      	output.format( "%d", score1 );
      	output.format( "\n" );
       	output.format( name2 );
      	output.format( " " );
   		output.format( "%d", score2 );
		output.format( "\n" );	
     	output.format( name3 );
     	output.format( " " );
     	output.format( "%d", score3 );
     	output.format( "\n" );
     	
     	output.format( name4 );
      	output.format( " " );
      	output.format( "%d", score4 );
      	output.format( "\n" );
       	output.format( name5 );
      	output.format( " " );
   		output.format( "%d", score5 );
		output.format( "\n" );	
     	output.format( name6 );
     	output.format( " " );
     	output.format( "%d", score6 );
     	output.format( "\n" );
     	
     	output.format( name7 );
      	output.format( " " );
      	output.format( "%d", score7 );
      	output.format( "\n" );
       	output.format( name8 );
      	output.format( " " );
   		output.format( "%d", score8 );
		output.format( "\n" );	
     	output.format( name9 );
     	output.format( " " );
     	output.format( "%d", score9 );
     	output.format( "\n" );
     	
     	output.format( "%d " + "%d " + "%d " + "%d", up, down, left, right );
      	output.close();
    }
    
    //class for reading from save file
    public void readFile()
    {
 		try
		{
		   	input = new Scanner( file );
		}
		catch ( FileNotFoundException fileNotFoundException )
		{
		    System.err.println( "Error opening file." );
		}
			
		name1 = input.next();
		score1 = input.nextInt();
		name2 = input.next();
		score2 = input.nextInt();
		name3 = input.next();
		score3 = input.nextInt();
		
		name4 = input.next();
		score4 = input.nextInt();
		name5 = input.next();
		score5 = input.nextInt();
		name6 = input.next();
		score6 = input.nextInt();
		
		name7 = input.next();
		score7 = input.nextInt();
		name8 = input.next();
		score8 = input.nextInt();
		name9 = input.next();
		score9 = input.nextInt();
		
		up = input.nextInt();
		down = input.nextInt();
		left = input.nextInt();
		right = input.nextInt();
		input.close();
    }
   
    //get and set functions for each variable
   	public int getCtrlUp()
   	{
   		readFile();
   		return up;
   	}

   	public void setCtrlUp( int up1 )
   	{
   		this.up = up1;
   		writeFile();
	}
   
	public int getCtrlDown()
   	{
   		readFile();
		return down;
   	}
   
   	public void setCtrlDown( int down1 )
   	{
   		this.down = down1;
   		writeFile();
  	}
      
   	public int getCtrlLeft()
   	{
     	readFile();
   		return left;
   	}
   
   	public void setCtrlLeft( int left1 )
   	{
   		this.left = left1;
   		writeFile();
   	}
      
   	public int getCtrlRight()
   	{
   		readFile();
   		return right;
   	}
   
   	public void setCtrlRight( int right1 )
   	{
   		this.right = right1;
   		writeFile();
   	}
   	
   	
   	public int getTopScore()
   	{
   		readFile();
   		return score1;
   	}
   
   	public void setTopScore( int score_1 )
   	{
   		this.score1 = score_1;
   		writeFile();
   	}
   	
   	public int getMiddleScore()
   	{
   		readFile();
   		return score2;
   	}
   
   	public void setMiddleScore( int score_2 )
   	{
   		this.score2 = score_2;
   		writeFile();
   	}
   	
   	public int getBottomScore()
   	{
   	   	readFile();
   		return score3;
   	}
   
   	public void setBottomScore( int score_3 )
   	{
   		this.score3 = score_3;
   		writeFile();
   	}
   	
   	public String getTopScorer()
   	{
   		readFile();
   		return name1;
   	}
   
   	public void setTopScorer( String name_1 )
   	{
   		this.name1 = name_1;
   		writeFile();
   	}
   	  	
   	public String getMiddleScorer()
   	{
   		readFile();
   		return name2;
   	}
   
   	public void setMiddleScorer( String name_2 )
   	{
   		this.name2 = name_2;
   		writeFile();
   	}
   	
   	public String getBottomScorer()
   	{
   		readFile();
   		return name3;
   	}
   
   	public void setBottomScorer( String name_3 )
   	{
   		this.name3 = name_3;
   		writeFile();
   	}
   	
   	
   	
   	public int getTopScore2()
   	{
   		readFile();
   		return score4;
   	}
   
   	public void setTopScore2( int score_4 )
   	{
   		this.score4 = score_4;
   		writeFile();
   	}
   	
   	public int getMiddleScore2()
   	{
   		readFile();
   		return score5;
   	}
   
   	public void setMiddleScore2( int score_5 )
   	{
   		this.score5 = score_5;
   		writeFile();
   	}
   	
   	public int getBottomScore2()
   	{
   	   	readFile();
   		return score6;
   	}
   
   	public void setBottomScore2( int score_6 )
   	{
   		this.score6 = score_6;
   		writeFile();
   	}
   	
   	public String getTopScorer2()
   	{
   		readFile();
   		return name4;
   	}
   
   	public void setTopScorer2( String name_4 )
   	{
   		this.name4 = name_4;
   		writeFile();
   	}
   	  	
   	public String getMiddleScorer2()
   	{
   		readFile();
   		return name5;
   	}
   
   	public void setMiddleScorer2( String name_5 )
   	{
   		this.name5 = name_5;
   		writeFile();
   	}
   	
   	public String getBottomScorer2()
   	{
   		readFile();
   		return name6;
   	}
   
   	public void setBottomScorer2( String name_6 )
   	{
   		this.name6 = name_6;
   		writeFile();
   	}
   	
   	
   	public int getTopScore3()
   	{
   		readFile();
   		return score7;
   	}
   
   	public void setTopScore3( int score_7 )
   	{
   		this.score7 = score_7;
   		writeFile();
   	}
   	
   	public int getMiddleScore3()
   	{
   		readFile();
   		return score8;
   	}
   
   	public void setMiddleScore3( int score_8 )
   	{
   		this.score8 = score_8;
   		writeFile();
   	}
   	
   	public int getBottomScore3()
   	{
   	   	readFile();
   		return score9;
   	}
   
   	public void setBottomScore3( int score_9 )
   	{
   		this.score9 = score_9;
   		writeFile();
   	}
   	
   	public String getTopScorer3()
   	{
   		readFile();
   		return name7;
   	}
   
   	public void setTopScorer3( String name_7 )
   	{
   		this.name7 = name_7;
   		writeFile();
   	}
   	  	
   	public String getMiddleScorer3()
   	{
   		readFile();
   		return name8;
   	}
   
   	public void setMiddleScorer3( String name_8 )
   	{
   		this.name8 = name_8;
   		writeFile();
   	}
   	
   	public String getBottomScorer3()
   	{
   		readFile();
   		return name9;
   	}
   
   	public void setBottomScorer3( String name_9 )
   	{
   		this.name9 = name_9;
   		writeFile();
   	}
}