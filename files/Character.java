package perplexia;

import javax.swing.*;
import java.awt.*;

public abstract class Character extends JComponent
{
	/**
	 * This class generates the character image on the panel
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int left = 0; //variable used for character arrays to determine images
	private static final int up = 1;
	private static final int right = 2;
	private static final int down = 3;
	private static final int idle = 4;
	private Image[] image = new Image[5]; //array of images used for character images
	private int myDirection = down(); //start with character facing down
	private JPanel myPanel; //empty panel
	private boolean keyPressed;
	private int chara = 0; //character is set to 0 by default
	EasyPanel panel = new EasyPanel( 1 );

	//character constructor for making new characters
	public Character( int x, int y, int direction, JPanel panel, String folder, int chara )
	{
		setSize( 16, 24 ); //size of character
		setLocation( x, y ); //location to start character at
		myPanel = panel; //panel which character is being displayed on
		myDirection = direction;
		
		if( chara == 2 ) //character images for character "Locke"
		{
			image[0] = new ImageIcon( folder + "/0.gif" ).getImage();
			image[1] = new ImageIcon( folder + "/1.gif" ).getImage();
			image[2] = new ImageIcon( folder + "/2.gif" ).getImage();
			image[3] = new ImageIcon( folder + "/3.gif" ).getImage();
			image[4] = new ImageIcon( folder + "/4.gif" ).getImage();
		}
		else if( chara == 0 ) //character images for character "Celes"
		{
			image[0] = new ImageIcon( folder + "/0a.gif" ).getImage();
			image[1] = new ImageIcon( folder + "/1a.gif" ).getImage();
			image[2] = new ImageIcon( folder + "/2a.gif" ).getImage();
			image[3] = new ImageIcon( folder + "/3a.gif" ).getImage();
			image[4] = new ImageIcon( folder + "/4a.gif" ).getImage();
		}
		else if( chara == 1 ) //character images for character "Gau"
		{
			image[0] = new ImageIcon( folder + "/0b.gif" ).getImage();
			image[1] = new ImageIcon( folder + "/1b.gif" ).getImage();
			image[2] = new ImageIcon( folder + "/2b.gif").getImage();
			image[3] = new ImageIcon( folder + "/3b.gif" ).getImage();
			image[4] = new ImageIcon( folder + "/4b.gif" ).getImage();
		}
		else if( chara == 5 ) //character images for character "Ghost"
		{
			image[0] = new ImageIcon( folder + "/0c.gif" ).getImage();
			image[1] = new ImageIcon( folder + "/1c.gif" ).getImage();
			image[2] = new ImageIcon( folder + "/2c.gif" ).getImage();
			image[3] = new ImageIcon( folder + "/3c.gif" ).getImage();
			image[4] = new ImageIcon( folder + "/4c.gif" ).getImage();
		}
		else if( chara == 3 ) //character images for character "Terra"
		{
			image[0] = new ImageIcon( folder + "/0d.gif" ).getImage();
			image[1] = new ImageIcon( folder + "/1d.gif" ).getImage();
			image[2] = new ImageIcon( folder + "/2d.gif" ).getImage();
			image[3] = new ImageIcon( folder + "/3d.gif" ).getImage();
			image[4] = new ImageIcon( folder + "/4d.gif" ).getImage();
		}
		else if( chara == 4 ) //character images for character "Umaro"
		{
			image[0] = new ImageIcon( folder + "/0e.gif" ).getImage();
			image[1] = new ImageIcon( folder + "/1e.gif" ).getImage();
			image[2] = new ImageIcon( folder + "/2e.gif" ).getImage();
			image[3] = new ImageIcon( folder + "/3e.gif" ).getImage();
			image[4] = new ImageIcon( folder + "/4e.gif" ).getImage();
		}
	}
	
	 //class used to paint character image
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		g.drawImage( image[getImageIndex()], 0, 0, null );
	}
	
	 //check to see if key is pressed
	public void keyPressed( int code )
	{
		myDirection = code;
		keyPressed = true;
	}
	
	 //check to see if key is released
	public void keyReleased()
	{
		keyPressed = false;
	}
	
	//check to see if key equates to directional key
	public boolean validDirection( int direction )
	{
		return direction == up() || direction == down() || direction == right() || direction == left();
	}
	
	//moves character according to which directional keys are pressed
	public void act()
	{
		if( keyPressed ) //check if key is pressed
		{
			int x = getX(); //starting x coordinate
			int y = getY(); //starting y coordinate
			Point p = new Point( x, y ); //coordinate with x and y for use if there is a collision
			
			
			if( myDirection == up() )
				y = Math.max( 0, --y ); //if direction is up, subtract from coordinate x
			else if( myDirection == down() ) //if direction is down, add to coordinate y
				y = Math.min( myPanel.getHeight() - getHeight(), ++y );	
			else if( myDirection == left() ) //if direction is left, subtract from coordinate x
				x = Math.max( 0, --x );	
			else if( myDirection == right() ) //if direction is right, add to coordinate x
				x = Math.min( myPanel.getWidth() - getWidth(), ++x );	
				
			setLocation( x, y );
			
			if( collidesWith() != null ) //call function to check if there was a collision
			{
				setLocation(p); //collision stops movement from character
			}
		}
	}
	
	//return image index number
	public int getImageIndex()
	{
		if( myDirection == left() )
			return left;	
		else if( myDirection == right() )
			return right;	
		else if( myDirection == up() )
			return up;
		else if( myDirection == down() )
			return down;	
		else
			return idle;
	}
	
	//checks to see if character collides with object
	public Component collidesWith()
	{
		Component[] components = myPanel.getComponents(); //takes all components from panel	
		
		for(Component c: components) //checks to see if character collides with each componet
		{
			if(c != this && collision(c))
			{
				return c; //returns a value if a collision has occurred
			}
		}
		return null; //returns null otherwise
	}
	
	//compares character with each component on panel to see if they interest, thus resulting in a collision
	public boolean collision( Component c )
	{
		Rectangle thisRect = getBounds();
		Rectangle arguRect = c.getBounds();
		return thisRect.intersects( arguRect );
	}
	
	public abstract int left();
	public abstract int right();
	public abstract int down();
	public abstract int up();
	public abstract int idle();

	//sets character number
	public void setChara( int chara )
	{
		this.chara = chara;
	}

	//returns character number
	public int getChara() 
	{
		return chara;
	}
}