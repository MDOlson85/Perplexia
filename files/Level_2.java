package perplexia;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class Level_2 extends JFrame
{
	/**
	 * This is the class contains the second level of the program
	 */
	private static final long serialVersionUID = 1L;
	
	private EasyPanel panel;
	private Timer timer1;
	private Timer timer;
	private Character player1;
	private int cordx;
	private int cordy;
	private int char1;
	private ObstacleObjectSingle obs1, obs2, obs3, obs4, obs5, obs6, obs7, obs8, obs9, obs10;
	private ObstacleObject2Long obs11, obs12, obs13, obs14, obs15, obs16, obs17, obs18;
	private ObstacleObject3Wide obs19, obs20, obs21;
	private ObstacleObject3Long obs22, obs23, obs24, obs25, obs26, obs27, obs28, obs29;
	private ObstacleObject4Wide obs30, obs31, obs32, obs33, obs34, obs35, obs36, obs37, obs38, obs39;
	private ObstacleObject4Long obs40, obs41, obs42, obs43, obs44, obs45;
	private ObstacleObject14Wide obs46, obs47;
	private ObstacleObject17Long obs48, obs49;
	private ObstacleObject obsEnd;
	private boolean endNum = false;
	private int score;
	private int num1 = 0;
	private JFormattedTextField textArea;
	private Formatter formatter;
	String formatString;
	private int num2;
	private int num3;
	private double calculate;
	private boolean check1, check2, check3;
	private ReadSaveFile saveFile;
	private SetControls controls;
	private boolean yo = true;	
	
	public Level_2( final int charNum, final int score1 )
	{	
		super( "Perplexia - Square Maps: Level 2 (Sewers)" );
		saveFile = new ReadSaveFile();
		panel = new EasyPanel( 2 );
		char1 = charNum;
		
		//begin menu bar
		
		JMenuBar bar = new JMenuBar();
		setJMenuBar( bar );
		
		JMenu fileMenu = new JMenu( "File" );
		fileMenu.setMnemonic( 'F' );
		
		JMenu helpMenu = new JMenu( "Help" );
		helpMenu.setMnemonic( 'H' );
		
		JMenu subMenu = new JMenu("New...");
		subMenu.setMnemonic( 'N' );
		
		JMenuItem newItem = new JMenuItem( "Square Maps Game" );
		newItem.setMnemonic( 'S' );
		subMenu.add( newItem );
		
		newItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					timer1.stop();
					
					Object[] options = {"Yep", "Nah, I change my mind." };
				
					int option;
					
					option = JOptionPane.showOptionDialog( Level_2.this, 
						"Are you sure you want to leave your current game?", "New Game", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, null );

    				if(option == 0)
    				{			
    					setVisible( false );
						CharacterSelect select = new CharacterSelect( 1 );
						select.setResizable( false );
						select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						select.setSize( 400, 120 );
						select.setVisible( true );
						select.setLocation( getBounds().x + 118, getBounds().y + 260 );
    				}
    				else
    					timer1.start();
				}
			} 
		);
		
		JMenuItem newItem2 = new JMenuItem( "Tall Maps Game" );
		newItem2.setMnemonic( 'T' );
		subMenu.add( newItem2 );
		
		newItem2.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					timer1.stop();
					
					Object[] options = {"Yep", "Nah, I change my mind." };
				
					int option;
					
					option = JOptionPane.showOptionDialog( Level_2.this, 
						"Are you sure you want to leave your current game?", "New Game", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, null );

    				if(option == 0)
    				{			
    					setVisible( false );
						CharacterSelect select = new CharacterSelect( 2 );
						select.setResizable( false );
						select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						select.setSize( 400, 120 );
						select.setVisible( true );
						select.setLocation( getBounds().x + 118, getBounds().y + 260 );
    				}
    				else
    					timer1.start();
				}
			} 
		);
		
		JMenuItem newItem3 = new JMenuItem( "Wide Maps Game" );
		newItem3.setMnemonic( 'W' );
		subMenu.add( newItem3 );
		
		newItem3.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					timer1.stop();
					
					Object[] options = {"Yep", "Nah, I change my mind." };
				
					int option;
					
					option = JOptionPane.showOptionDialog( Level_2.this, 
						"Are you sure you want to leave your current game?", "New Game", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, null );

    				if(option == 0)
    				{			
    					setVisible( false );
						CharacterSelect select = new CharacterSelect( 3 );
						select.setResizable( false );
						select.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
						select.setSize( 400, 120 );
						select.setVisible( true );
						select.setLocation( getBounds().x + 118, getBounds().y + 260 );
    				}
    				else
    					timer1.start();
				}
			} 
		);
		
		fileMenu.add( subMenu );
		
		fileMenu.addSeparator();
		
		JMenuItem setItem = new JMenuItem( "Set Controls" );
		setItem.setMnemonic( 'S' );
		fileMenu.add( setItem );
		
		controls = new SetControls();
		controls.setVisible( false );
		
		setItem.addActionListener(
			new ActionListener()
			{
				public void actionPerformed( ActionEvent event )
				{
					controls = new SetControls();
					controls.setResizable( false );
					controls.setSize( 300, 70 );
					controls.setVisible( true );
					controls.setLocation( getBounds().x + 168, getBounds().y + 285 );										
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
					timer1.stop();
					HighScores scores = new HighScores();
					scores.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					timer1.start();									
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
					timer1.stop();
					JOptionPane.showMessageDialog( Level_2.this,
						"Guide your avatar from the start point to the end point of each level\n" +
						"within the given time limit. There are a total of 3 levels for each map size.",
						"How to Play", JOptionPane.PLAIN_MESSAGE );
					timer1.start();
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
					timer1.stop();
					JOptionPane.showMessageDialog( Level_2.this,
						"Copyright © 2009 Three Guys Inc\n\n" +
						"Created by Michael Olson, Ron Simani, & Zane Skinner",
						"About", JOptionPane.PLAIN_MESSAGE );
					timer1.start();
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
					timer1.stop();
					Object[] options = {"Yeah", "Not yet" };
				
					int option;
					
					option = JOptionPane.showOptionDialog( Level_2.this, 
						"Do you want to exit the game?", "Exit", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options, null );

    				if(option == 0)
       					System.exit( 0 );
       				else
       					timer1.start();
				}
			} 
		);
		
		bar.add( fileMenu );
		bar.add( helpMenu );
		
		//end menu bar
		
		player1 = new CharacterControl( 293, 607, KeyEvent.VK_DOWN, panel, char1 );
		panel.add( player1 );
		
		obsEnd = new ObstacleObject( 270, 0, panel, "images", 5 );
		
		player1.keyPressed( KeyEvent.VK_DOWN + KeyEvent.VK_UP );
		player1.keyPressed( KeyEvent.VK_DOWN + KeyEvent.VK_UP );
		
		obs1 = new ObstacleObjectSingle( 32, 160, panel );
		obs2 = new ObstacleObjectSingle( 32, 320, panel );
		obs3 = new ObstacleObjectSingle( 64, 351, panel );
		obs4 = new ObstacleObjectSingle( 95, 415, panel );
		obs5 = new ObstacleObjectSingle( 254, 351, panel );
		obs6 = new ObstacleObjectSingle( 349, 383, panel );
		obs7 = new ObstacleObjectSingle( 508, 256, panel );
		obs8 = new ObstacleObjectSingle( 540, 320, panel );
		obs9 = new ObstacleObjectSingle( 572, 351, panel );
		obs10 = new ObstacleObjectSingle( 572, 511, panel );
		
		obs11 = new ObstacleObject2Long( 32, 223, panel );
		obs12 = new ObstacleObject2Long( 64, 415, panel );
		obs13 = new ObstacleObject2Long( 254, 575, panel );
		obs14 = new ObstacleObject2Long( 318, 575, panel );
		obs15 = new ObstacleObject2Long( 349, 288, panel );
		obs16 = new ObstacleObject2Long( 381, 415, panel );
		obs17 = new ObstacleObject2Long( 540, 223, panel );
		obs18 = new ObstacleObject2Long( 572, 415, panel );
		
		obs19 = new ObstacleObject3Wide( 32, 95, panel );
		obs20 = new ObstacleObject3Wide( 32, 575, panel );
		obs21 = new ObstacleObject3Wide( 222, 383, panel );
		
		obs22 = new ObstacleObject3Long( 95, 288, panel );
		obs23 = new ObstacleObject3Long( 159, 288, panel );
		obs24 = new ObstacleObject3Long( 159, 383, panel );
		obs25 = new ObstacleObject3Long( 222, 0, panel );
		obs26 = new ObstacleObject3Long( 286, 288, panel );
		obs27 = new ObstacleObject3Long( 349, 0, panel );
		obs28 = new ObstacleObject3Long( 381, 288, panel );
		obs29 = new ObstacleObject3Long( 508, 447, panel );
		
		obs30 = new ObstacleObject4Wide( 127, 95, panel );
		obs31 = new ObstacleObject4Wide( 127, 447, panel );
		obs32 = new ObstacleObject4Wide( 127, 575, panel );
		obs33 = new ObstacleObject4Wide( 254, 223, panel );
		obs34 = new ObstacleObject4Wide( 254, 447, panel );
		obs35 = new ObstacleObject4Wide( 349, 95, panel );
		obs36 = new ObstacleObject4Wide( 349, 575, panel );
		obs37 = new ObstacleObject4Wide( 381, 223, panel );
		obs38 = new ObstacleObject4Wide( 476, 95, panel );
		obs39 = new ObstacleObject4Wide( 476, 575, panel );
		
		obs40 = new ObstacleObject4Long( 95, 160, panel );
		obs41 = new ObstacleObject4Long( 159, 160, panel );
		obs42 = new ObstacleObject4Long( 222, 223, panel );
		obs43 = new ObstacleObject4Long( 445, 256, panel );
		obs44 = new ObstacleObject4Long( 445, 383, panel );
		obs45 = new ObstacleObject4Long( 508, 320, panel );
		
		obs46 = new ObstacleObject14Wide( 64, 511, panel );
		obs47 = new ObstacleObject14Wide( 127, 160, panel );
		
		obs48 = new ObstacleObject17Long( 0, 64, panel );
		obs49 = new ObstacleObject17Long( 603, 64, panel );
				
		panel.add( obs1 ); panel.add( obs24 ); 
		panel.add( obs47 );
		panel.add( obs2 ); panel.add( obs25 ); 
		panel.add( obs48 );
		panel.add( obs3 ); panel.add( obs26 ); 
		panel.add( obs49 );
		panel.add( obs4 ); panel.add( obs27 ); 
		panel.add( obs5 ); panel.add( obs28 ); 
		panel.add( obs6 ); panel.add( obs29 ); 
		panel.add( obs7 ); panel.add( obs30 ); 
		panel.add( obs8 ); panel.add( obs31 ); 
		panel.add( obs9 ); panel.add( obs32 ); 
		panel.add( obs10 ); panel.add( obs33 );
		panel.add( obs11 ); panel.add( obs34 );
		panel.add( obs12 ); panel.add( obs35 );
		panel.add( obs13 ); panel.add( obs36 );
		panel.add( obs14 ); panel.add( obs37 );
		panel.add( obs15 ); panel.add( obs38 );
		panel.add( obs16 ); panel.add( obs39 );
		panel.add( obs17 ); panel.add( obs40 );
		panel.add( obs18 ); panel.add( obs41 );
		panel.add( obs19 ); panel.add( obs42 );
		panel.add( obs20 ); panel.add( obs43 );
		panel.add( obs21 ); panel.add( obs44 );
		panel.add( obs22 ); panel.add( obs45 );
		panel.add( obs23 ); panel.add( obs46 ); 
		
		num1 = 3;
		num2 = 59;
		num3 = 60;
		check1 = false;
		check2 = false;
	 	check3 = false;
		
		
		formatter = new Formatter();
		formatter.format( " Score: %d            		                                                                 "
						+ "           Time Remaining: " + "%d:" + "00:" + "00", score1, num1, num2, num3 );
		formatString = formatter.toString();
		textArea = new JFormattedTextField( NumberFormat.getIntegerInstance() );
		textArea.setDisabledTextColor( Color.RED );		
		
		textArea.setText( formatString );
		textArea.setEnabled( false );
		textArea.setDisabledTextColor( Color.BLACK );
		add( textArea, BorderLayout.SOUTH );
		
		java.util.Timer timer = new java.util.Timer();
		java.util.TimerTask task = new java.util.TimerTask() { public void run() 
		{ 
			if( controls.isVisible() == true )
			{
				timer1.stop();
				yo = false;
			}
			else if( controls.isVisible() == false && yo == false )
			{
				yo = true;
				panel.remove( player1 );
				player1 = new CharacterControl( cordx, cordy, KeyEvent.VK_DOWN, panel, char1 );
				panel.add( player1 );
				timer1.start();
			}
				
				
		} };
		timer.scheduleAtFixedRate( task, 1, 1 );
		
		timer1 = new Timer( 1, new ActionListener()
		{
			public void actionPerformed( ActionEvent e )
			{			
				player1.act();
				player1.act();
				player1.act();
				
				/*
				player1.act();
				player1.act();
				player1.act();
				player1.act();
				player1.act();
				player1.act();
				player1.act();
				player1.act();
				player1.act();
				*/
				
				cordx = player1.getX();
				cordy = player1.getY();
				
				formatString = " ";				
				
				if( num2 == 59 && check1 == false )
				{
					num1--;
					check1 = true;
				}
				
				if( num2 == 1 )
				{
					check1 = false;
				}
				
				num3--;
				
				if( num3 == 0 )
				{
					num2--;
					num3 = 59;
				}
				
				if( num2 == 00 )
					num2 = 59;
				
				formatter = new Formatter();
				
				if( num3 <= 9 && num2 >= 10 )
				{
					formatter.format( " Score: %d            		                                                                 "
									+ "           Time Remaining: " + "%d:" + "%d:" + "0" + "%d", score1, num1, num2, num3 );
				}
				else if( num2 <= 9 && num3 >= 10 )
				{
					formatter.format( " Score: %d            		                                                                 "
									+ "           Time Remaining: " + "%d:" + "0" + "%d:" + "%d", score1, num1, num2, num3 );
				}
				else if( num2 <= 9 && num3 <= 9 )
				{
					formatter.format( " Score: %d            		                                                                 "
									+ "           Time Remaining: " + "%d:" + "0" + "%d:" + "0" + "%d", score1, num1, num2, num3 );
				}
				else if( num1 <= -1 )
				{
					formatter.format( " Score: %d            		                                                                 "
					 				+ "           Time Remaining: 00:00:00", score1 );
				}
				else
				{
					formatter.format( " Score: %d            		                                                                 "		  
									+ "           Time Remaining: " + "%d:" + "%d:" + "%d", score1, num1, num2, num3 );
				}
				
				if( num1 <= 0 && num2<=29 )
					textArea.setDisabledTextColor( Color.RED );
					
				Rectangle thisRect = player1.getBounds();
				Rectangle arguRect = obsEnd.getBounds();
				
				if( thisRect.intersects( arguRect ) && (endNum == false) )
				{									
					panel.remove( player1 );
					endNum = true;
					
					calculate = ( ( num2 * 1111 )/60 );
					
					score = ( ( num1 * 1111 ) + ( (int)calculate ) ) + score1;
					
					JOptionPane.showMessageDialog( Level_2.this, "You beat the second level!\nYour current score is " + score + ".",
							"Winning", JOptionPane.PLAIN_MESSAGE );
					
					setVisible( false );
			
					Level_3 l3 = new Level_3( charNum, score );
					l3.setLocation( getBounds().x, getBounds().y );
					l3.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					l3.setResizable( false );
					
					timer1.stop();
				}
				
				if( (num1 <= -1) && (endNum == false) )
				{			
					formatString = " ";
					formatter = new Formatter();
					formatter.format( " Score: 0000            		                                                                 "
					 				+ "           Time Remaining: 0:00:00" );
					formatString = formatter.toString();
					textArea.setText( formatString );
					
					
					Dimension myScreenSize = Toolkit.getDefaultToolkit().getScreenSize(); 	
					GameOver over = new GameOver();
					over.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					over.setSize( 635, 189 );
					over.setResizable( false );
					int width = over.getSize().width;
					int height = over.getSize().height;
					int x_cord = ( myScreenSize.width-width )/2;
					int y_cord = ( myScreenSize.height-height )/2;
					over.setLocation( x_cord, y_cord );		
					over.setVisible( true );
					
					JOptionPane.showMessageDialog( Level_2.this, "You did not reach the goal in the time limit. You lose.",
							"Losing", JOptionPane.PLAIN_MESSAGE );
							
					setVisible( false );
					
					try
					{
						Thread.sleep(1000);
					}
					catch(Exception ie){}
										
					over.setVisible( false );
					
					MainMenu menu = new MainMenu();
					menu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
					menu.setSize( 786, 348 );
					menu.setResizable( false );
					width = menu.getSize().width;
					height = menu.getSize().height;
					x_cord = ( myScreenSize.width-width )/2;
					y_cord = ( myScreenSize.height-height )/2;
					menu.setLocation( x_cord, y_cord );
					menu.setVisible( true );
					
					
					timer1.stop();
				}		
				
				formatString = formatter.toString();
				textArea.setText( formatString );
			}
		} );

		addKeyListener( new KeyAdapter()
		{
			public void keyPressed( KeyEvent e)
			{
				int code = e.getKeyCode();
				
				if( player1.validDirection( code ) )
				{
					player1.keyPressed( code );
				}
			}
			public void keyReleased( KeyEvent e )
			{
				int code = e.getKeyCode();
								
				if( player1.validDirection( code ) )
				{
					player1.keyReleased();
				}
			}
		} );

		add( panel, BorderLayout.CENTER );
		pack();
		setVisible( true );
		timer1.start();
	}
	
	public void setTimer(Timer timer) { this.timer = timer; }
	public Timer getTimer() { return timer; }
	public void setSaveFile(ReadSaveFile saveFile) { this.saveFile = saveFile; }
	public ReadSaveFile getSaveFile() { return saveFile; }
	public void setCheck2(boolean check2) { this.check2 = check2; }
	public boolean isCheck2() { return check2; }
	public void setCheck3(boolean check3) { this.check3 = check3; }
	public boolean isCheck3() { return check3; }
}