package perplexia;

import javax.swing.*;
import java.awt.*;

public class GameOver extends JFrame
{
	/**
	 * This is the class displays the game over screen
	 */
	private static final long serialVersionUID = 1L;
	
	private Over title;

	public GameOver()
	{	
		super( "Game Over" ); //imposes title at top of panel
		
		JPanel overPanel = new JPanel();
		overPanel.setLayout( new BorderLayout() );
		title = new Over();
		overPanel.add( title );
		
		add( overPanel, BorderLayout.CENTER );
	}
}

class Over extends JPanel
{
	/**
	 *class that generates the arcs for pie char
	 */
	private static final long serialVersionUID = 1L;
	
	private Image image1;
	private String folder = "images";
	
	public Over()
	{
		setLayout( new BorderLayout() );
	}
	public void paintComponent( Graphics g )
	{
		image1 = new ImageIcon( folder + "/gameover.PNG" ).getImage();
		super.paintComponent( g );
		g.drawImage( image1, 0, 0, this );
	}	
}