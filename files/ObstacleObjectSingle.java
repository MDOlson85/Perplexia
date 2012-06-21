package perplexia;

import java.awt.*;

import javax.swing.*;

public class ObstacleObjectSingle extends JComponent
{
	/**
	 * This is the second class that generates other obstacles of various sizes
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObjectSingle( int x, int y, JPanel panel )
	{		
		setSize( 27, 27 );
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

class ObstacleObject2Long extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject2Long( int x, int y, JPanel panel )
	{		
		setSize( 32, 64 );
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

class ObstacleObject3Long extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject3Long( int x, int y, JPanel panel )
	{		
		setSize( 32, 96 );
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

class ObstacleObject4Long extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject4Long( int x, int y, JPanel panel )
	{		
		setSize( 32, 128 );
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

class ObstacleObject17Long extends JComponent
{
private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject17Long( int x, int y, JPanel panel )
	{		
		setSize( 32, 543 );
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

class ObstacleObject2Wide extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject2Wide( int x, int y, JPanel panel )
	{		
		setSize( 64, 32 );
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

class ObstacleObject3Wide extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject3Wide( int x, int y, JPanel panel )
	{		
		setSize( 95, 32 );
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

class ObstacleObject4Wide extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject4Wide( int x, int y, JPanel panel )
	{		
		setSize( 127, 32 );
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

class ObstacleObject14Wide extends JComponent
{
	private static final long serialVersionUID = 1L;
	
	private JPanel myPanel;
	private Image image;

	public ObstacleObject14Wide( int x, int y, JPanel panel )
	{		
		setSize( 445, 32 );
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