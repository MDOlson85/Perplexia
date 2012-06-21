package perplexia;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class MainMenu extends JFrame implements ActionListener
{
	/**
	 * This is the class creates the main menu for the program
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton buttons[]; //buttons used for menu
	private final String names[] = { "NEW GAME", "HIGH SCORES", "SET CONTROLS", "EXIT GAME" };
	private JButton buttons2[];
	private GridLayout layout;
	private JPanel panel;
	private Title title;
	private int up1;
	private int down1;
	private int left1;
	private int right1;
	private JPanel emptyPanel[];
	private int state = 0; //state is used to determine if menu has default buttons or "new game" menu buttons
	private File file = new File( "perplexia.sav" );

	public MainMenu()
	{	
		super( "Perplexia v1.2" );
		
		if( file.exists() ); //begins by checking if a save file exits and creates one if one doesn't exist
   		else
   		{
			JOptionPane.showMessageDialog( MainMenu.this,
				"A save file was not found.\n" +
				"A new save file was created.",
				"Save File", JOptionPane.INFORMATION_MESSAGE );
   		}
	
		ReadSaveFile saveFile = new ReadSaveFile();
		saveFile.openFile();

		setUp1(saveFile.getCtrlUp());
		setDown1(saveFile.getCtrlDown());
		setLeft1(saveFile.getCtrlLeft());
		setRight1(saveFile.getCtrlRight());
		
		JMenuBar bar = new JMenuBar(); //creates menu bar at top of screen
		setJMenuBar( bar );
		
		JMenu fileMenu = new JMenu( "File" );
		fileMenu.setMnemonic( 'F' );
		
		JMenu helpMenu = new JMenu( "Help" );
		helpMenu.setMnemonic( 'H' );
		
		JMenu subMenu = new JMenu("New...");
		subMenu.setMnemonic( 'N' );
		
		JMenuItem newItem = new JMenuItem( "Square Maps Game" ); //if user wants to start new square maps game
		newItem.setMnemonic( 'S' );
		subMenu.add( newItem );
		
		newItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{		
    				setVisible( false );
					CharacterSelect select = new CharacterSelect( 1 );
					select.setResizable( false );
					select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					select.setSize( 400, 120 );
					select.setVisible( true );
					select.setLocation( getBounds().x + 193, getBounds().y + 114 );
				}
			} 
		);
		
		JMenuItem newItem2 = new JMenuItem( "Tall Maps Game" ); //if user wants to start new tall maps game
		newItem2.setMnemonic( 'T' );
		subMenu.add( newItem2 );
		
		newItem2.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
    				setVisible( false );
					CharacterSelect select = new CharacterSelect( 2 );
					select.setResizable( false );
					select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					select.setSize( 400, 120 );
					select.setVisible( true );
					select.setLocation( getBounds().x + 193, getBounds().y + 114 );
				}
			} 
		);
		
		JMenuItem newItem3 = new JMenuItem( "Wide Maps Game" ); //if user wants to start new wide maps game
		newItem3.setMnemonic( 'W' );
		subMenu.add( newItem3 );
		
		newItem3.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
    				setVisible( false );
					CharacterSelect select = new CharacterSelect( 3 );
					select.setResizable( false );
					select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					select.setSize( 400, 120 );
					select.setVisible( true );
					select.setLocation( getBounds().x + 193, getBounds().y + 114 );
				}
			} 
		);
		
		fileMenu.add( subMenu );
		
		fileMenu.addSeparator();
		
		JMenuItem setItem = new JMenuItem( "Set Controls" );
		setItem.setMnemonic( 'S' );
		fileMenu.add( setItem );
		
		setItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					SetControls controls = new SetControls();
					controls.setResizable( false );
					controls.setSize( 300, 70 );
					controls.setVisible( true );
					controls.setLocation( getBounds().x + 243, getBounds().y + 139 );									
				}
			} 
		);
		
		JMenuItem highItem = new JMenuItem( "View High Scores" );
		highItem.setMnemonic( 'V' );
		fileMenu.add( highItem );
		
		highItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					HighScores scores = new HighScores();
					scores.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );								
				}
			} 
		);
		
		JMenuItem howItem = new JMenuItem( "How to Play" );
		howItem.setMnemonic( 'H' );
		helpMenu.add( howItem );
		
		howItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					JOptionPane.showMessageDialog( MainMenu.this,
						"Guide your avatar from the start point to the end point of each level\n" +
						"within the given time limit. There are a total of 3 levels for each map size.",
						"How to Play", JOptionPane.PLAIN_MESSAGE );
				}
			} 
		);
		
		helpMenu.addSeparator();
		
		JMenuItem aboutItem = new JMenuItem( "About" );
		aboutItem.setMnemonic( 'A' );
		helpMenu.add( aboutItem );
		
		aboutItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					JOptionPane.showMessageDialog( MainMenu.this,
						"Copyright © 2009 Three Guys Inc\n\n" +
						"Created by Michael Olson, Ron Simani, & Zane Skinner",
						"About", JOptionPane.PLAIN_MESSAGE );
				}
			} 
		);
		
		fileMenu.addSeparator();
		
		JMenuItem exitItem = new JMenuItem( "Exit" );
		exitItem.setMnemonic( 'E' );
		fileMenu.add( exitItem );
		exitItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					Object[] options = {"Yeah", "Not yet" };
				
					int option;
					
					option = JOptionPane.showOptionDialog( MainMenu.this, 
						"Do you want to exit the game?", "Exit", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, null );

    				if(option == 0)
       					System.exit( 0 );
       				else;
				}
			} 
		);
		
		bar.add( fileMenu );
		bar.add( helpMenu );
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		//this is where menu begins	
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout( new BorderLayout() );
		title = new Title();
		centerPanel.add( title );
		
		panel = new JPanel();
		layout = new GridLayout( 4, 3 );
		panel.setLayout( layout );
	
		JPanel spanel[] = new JPanel[8];
		Square squ[] = new Square[8];
			
		for( int x=0; x<8; x++ )
		{
			squ[x] = new Square( x );
			spanel[x] = new TitlePanel();
			spanel[x].add(squ[x]);
		}
		
		buttons = new JButton[ names.length ];
		for( int count = 0; count < names.length; count++ )
		{
			buttons[ count ] = new JButton( names[ count ] );
			buttons[ count ].addActionListener( this );
		}
		
		panel.add( spanel[0] ); //creates bottom half of main menu panel
		panel.add( buttons[0] );
		panel.add( spanel[1] );
		panel.add( spanel[2] );
		panel.add( buttons[1] );
		panel.add( spanel[3] );
		panel.add( spanel[4] );
		panel.add( buttons[2] );
		panel.add( spanel[5] );
		panel.add( spanel[6] );
		panel.add( buttons[3] );
		panel.add( spanel[7] );
		
		//this was incase we wanted to set color of buttons
		/*for( int x=0; x<4; x++ )
		{
			buttons[x].setBackground( Color.black );
			buttons[x].setForeground( Color.yellow );
		}*/
		
		buttons[0].addActionListener //changes buttons if "new game" is selected
		(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{	
					if(state == 0)
					{
						buttons[0].setText("SQUARE MAPS");
						buttons[1].setText("TALL MAPS");
						buttons[2].setText("WIDE MAPS");
						buttons[3].setText("GO BACK");
					}
				} 
			}
		);
		
		buttons[3].addActionListener //changes buttons back if "go back" is selected
		(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{	
					if(state == 1)
					{
						buttons[0].setText("NEW GAME");
						buttons[1].setText("HIGH SCORES");
						buttons[2].setText("SET CONTROLS");
						buttons[3].setText("EXIT GAME");
					}
				} 
			}
		);
		
		add( centerPanel, BorderLayout.CENTER );
		add( panel, BorderLayout.SOUTH );
		
		pack();
		setVisible( true );
	}
	
	public void actionPerformed( ActionEvent event ) //action listener for buttons
	{
		if( event.getSource() == buttons[0] )
		{	if( state == 1)		
			{	
				setVisible( false );
				CharacterSelect select = new CharacterSelect( 1 );
				select.setLocation( getBounds().x + 193, getBounds().y + 114 );
				select.setResizable( false );
				select.setSize( 400, 120 );
				select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				select.setVisible( true );
			}
			else if( state == 0)
			{
				state = 1;
			}
		}
		else if( event.getSource() == buttons[1] )
		{			
			if(state == 0)
			{		
				HighScores scores = new HighScores();
				scores.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
			}
			else if( state == 1)
			{
				setVisible( false );
				CharacterSelect select = new CharacterSelect( 2 );
				select.setLocation( getBounds().x + 193, getBounds().y + 114 );
				select.setResizable( false );
				select.setSize( 400, 120 );
				select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				select.setVisible( true );
			}
		}
		else if( event.getSource() == buttons[2] )
		{
			if( state == 0)
			{	
				SetControls controls = new SetControls();
				controls.setResizable( false );
				controls.setSize( 300, 70 );
				controls.setVisible( true );
				controls.setLocation( getBounds().x + 243, getBounds().y + 139 );
			}
			else if( state == 1)
			{
				setVisible( false );
				CharacterSelect select = new CharacterSelect( 3 );
				select.setLocation( getBounds().x + 193, getBounds().y + 114 );
				select.setResizable( false );
				select.setSize( 400, 120 );
				select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				select.setVisible( true );
			}
		}
		else if( event.getSource() == buttons[3] )
		{
			if(state == 1)
			{
				state = 0;
			}
			else if(state == 0) //this option is for exiting the game
			{					
				Object[] options = {"Yeah", "Not yet" };
				
				int option;
					
				option = JOptionPane.showOptionDialog( MainMenu.this, 
					"Do you want to exit the game?", "Exit", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE, null, options, null );

    			if(option == 0)
       				System.exit( 0 );
       			else;
			}
		}	
								
	}

	public void setUp1(int up1) { this.up1 = up1; } //return functions that Eclipse wanted us to have

	public int getUp1() { return up1; }

	public void setDown1(int down1) { this.down1 = down1; }

	public int getDown1() { return down1; }

	public void setLeft1(int left1) { this.left1 = left1; }

	public int getLeft1() { return left1; }

	public void setRight1(int right1) { this.right1 = right1; }

	public int getRight1() { return right1; }

	public void setEmptyPanel(JPanel emptyPanel[]) { this.emptyPanel = emptyPanel; }

	public JPanel[] getEmptyPanel() { return emptyPanel; }

	public void setButtons2(JButton buttons2[]) { this.buttons2 = buttons2; }

	public JButton[] getButtons2() { return buttons2;}
}

class Title extends JPanel
{
	/**
	 *This class displays the title image at top of main menu
	 */
	private static final long serialVersionUID = 1L;
	
	private String titleImage = "/title.PNG";
	private Image image;
	private String folder = "images";
	
	public Title()
	{
		setLayout( new BorderLayout() );
	}
	
	public void paintComponent( Graphics g )
	{
		image = new ImageIcon( folder + titleImage ).getImage();
		super.paintComponent( g );
		g.drawImage( image, 0, 0, this );
	}
}

class Square extends JPanel
{
	/**
	 *This class determines images for bottom half of main menu
	 */
	private static final long serialVersionUID = 1L;
	
	private Image image;
	private String folder = "images";
	private int pict;
	
	public Square( int num )
	{
		pict = num;
		setLayout( new BorderLayout() );
	}
	
	public void paintComponent( Graphics g )
	{
		if( pict == 0)
			image = new ImageIcon( folder + "/piece1.PNG" ).getImage();
		else if( pict == 1)
			image = new ImageIcon( folder + "/piece5.PNG" ).getImage();
		else if( pict == 2)
			image = new ImageIcon( folder + "/piece2.PNG" ).getImage();
		else if( pict == 3)
			image = new ImageIcon( folder + "/piece6.PNG" ).getImage();
		else if( pict == 4)
			image = new ImageIcon( folder + "/piece3.PNG" ).getImage();
		else if( pict == 5)
			image = new ImageIcon( folder + "/piece7.PNG" ).getImage();
		else if( pict == 6)
			image = new ImageIcon( folder + "/piece4.PNG" ).getImage();
		else if( pict == 7)
			image = new ImageIcon( folder + "/piece8.PNG" ).getImage();
			
		super.paintComponent( g );
		g.drawImage( image, 0, 0, this );
	}	
}

class TitlePanel extends JPanel
{
	/**
	 *class that generates the main panel
	 */
	private static final long serialVersionUID = 1L;

	public TitlePanel() 
	{			
		setLayout( new BorderLayout() );
	}
}