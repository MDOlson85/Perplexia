package perplexia;

import javax.swing.*;

public class CharacterControl extends Character
{
	/**
	 * This class generates the character's controls
	 */
	private static final long serialVersionUID = 1L;
	 
	private int ctrlUp; //integer values for control directions
	private int ctrlDown;
	private int ctrlLeft;
	private int ctrlRight;
	private ReadSaveFile sav; //receives values for controls from save file
	
	//constructor for character control class, subclass of character class
	public CharacterControl( int x, int y, int direction, JPanel panel, int chara )
	{
		super( x, y, direction, panel, "images", chara ); //character class is super class
		
		sav = new ReadSaveFile(); //reads from save file
		
		ctrlUp = sav.getCtrlUp(); //retrieves values from save file
		ctrlDown = sav.getCtrlDown();
		ctrlLeft = sav.getCtrlLeft();
		ctrlRight = sav.getCtrlRight();
	}
	
	//checks to see if directional key for left is pressed
	public int left()
	{		
		return ctrlLeft;
	}
	
	//checks to see if directional key for right is pressed
	public int right()
	{
		return ctrlRight;
	}
	
	//checks to see if directional key for down is pressed
	public int down()
	{
		return ctrlDown;
	}
	
	//checks to see if directional key for up is pressed
	public int up()
	{
		return ctrlUp;
	}

	//character starts at idle, so idle image displays when game starts
	@Override
	public int idle() 
	{
		return 0;
	}
}