package perplexia;

import java.awt.*;
import javax.swing.*;

public class ObstacleObject extends JComponent
{
	/**
	 * This class generates the some of the obstacle objects
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	//constructor is used to determine size and shape of each obstacle
	public ObstacleObject( int x, int y, JPanel panel, String folder, int object )
	{		
		if(object == 3)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 38, 24 );
		}
		else if(object == 4)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 27, 95 );
		}
		else if(object == 5)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 63, 24 );
		}
		else if(object == 6)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 59, 42 );
		}
		else if(object == 7)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 94, 65 );
		}
		else if(object == 8)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 55, 51 );
		}
		else if(object == 9)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 35, 62 );
		}
		else if(object == 10)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 24, 61 );
		}
		else if(object == 11)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 32, 62 );
		}	
		else if(object == 12)
		{
			image = new ImageIcon( folder + "/noimage" ).getImage();
			setSize( 140, 14 );
		}
	
		setLocation( x, y );
		setMyPanel( panel );
	}
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent( g );
		g.drawImage( image, 0, 0, null );
	}
	
	public void changeLocation( int x, int y ) 
	{
		setLocation( x, y );
	}

	public void setImage( Image image ) 
	{
		this.image = image;
	}

	public Image getImage() 
	{
		return image;
	}

	public void setMyPanel( JPanel myPanel ) 
	{
		this.myPanel = myPanel;
	}

	public JPanel getMyPanel() 
	{
		return myPanel;
	}
}