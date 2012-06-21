package perplexia;

import java.awt.*;
import javax.swing.*;

public class EasyPanel extends JPanel
{
	/**
	 * This class generates the panel used as background for levels
	 */
	private static final long serialVersionUID = 1L;
	
	private Image image; 
	private String folder = "images";
	private int map1;

	//used to determine map size depending on game type chosen
	public EasyPanel( int map )
	{		
		map1 = map;
		if( map == 1 || map == 2 || map == 3 )
		{
			setPreferredSize( new Dimension( 635, 639 ) );	
		}
		else if( map == 4 || map == 5 || map == 6 )
		{
			setPreferredSize( new Dimension( 635, 959 ) );	
		}
		else if( map == 7 || map == 8 || map == 9 )
		{
			setPreferredSize( new Dimension( 959, 639 ) );	
		}
		setLayout( null );
	}
	
	//used to generate background image depending on which level is displayed
	public void paintComponent( Graphics g )
	{
		if( map1 == 1 )
		{
			image = new ImageIcon( folder + "/level1.gif" ).getImage();
		}
		else if( map1 == 2 )
		{
			image = new ImageIcon( folder + "/level2.gif" ).getImage();
		}
		else if( map1 == 3 )
		{
			image = new ImageIcon( folder + "/level3.gif" ).getImage();
		}
		else if( map1 == 4 )
		{
			image = new ImageIcon( folder + "/level4.gif" ).getImage();
		}
		else if( map1 == 5 )
		{
			image = new ImageIcon( folder + "/level5.gif" ).getImage();
		}
		else if( map1 == 6 )
		{
			image = new ImageIcon( folder + "/level6.gif" ).getImage();
		}
		else if( map1 == 7 )
		{
			image = new ImageIcon( folder + "/level7.gif" ).getImage();
		}
		else if( map1 == 8 )
		{
			image = new ImageIcon( folder + "/level8.gif" ).getImage();
		}
		else if( map1 == 9 )
		{
			image = new ImageIcon( folder + "/level9.gif" ).getImage();
		}
		super.paintComponent( g );
		g.drawImage( image, 0, 0, this );
	}
}