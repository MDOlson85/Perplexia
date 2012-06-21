package perplexia;

import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class Level_5 extends JFrame
{
	/**
	 * This is the class contains the fifth level of the program
	 */
	private static final long serialVersionUID = 1L;
	
	private EasyPanel panel;
	private Timer timer1;
	private Timer timer;
	private Character player1;
	private int cordx;
	private int cordy;
	private int char1;
	
	private ObstacleObjectSingle obs1, obs2, obs3, obs4, obs5, obs6, obs7, obs8, obs9, obs10, obs11, obs12, obs82, obs83, obs84, obs85;
	private ObstacleObject2Wide obs13, obs14, obs15, obs16, obs17, obs18, obs19, obs20, obs21, obs22, obs23, obs24, obs25, obs26, obs27, obs86, obs87, obs115, obs116;
	private ObstacleObject2Wide obs28, obs29, obs30, obs31, obs32, obs33, obs34, obs35, obs36, obs37, obs38, obs39, obs40, obs41, obs42, obs88, obs89, obs90;
	private ObstacleObject2Long obs43, obs44, obs45, obs91, obs92, obs93, obs94;
	private ObstacleObject3Wide obs46, obs47, obs48, obs49, obs50, obs51, obs52, obs53, obs54, obs55, obs56, obs57, obs81;
	private ObstacleObject3Wide obs95, obs96, obs97, obs98, obs99, obs100, obs101, obs102, obs103;
	private ObstacleObject3Long obs58, obs59, obs60, obs104;
	private ObstacleObject4Wide obs61, obs62, obs63, obs64, obs65, obs66, obs67, obs68, obs69, obs70, obs71, obs72, obs73, obs74, obs75, obs76, obs105, obs106, obs107, obs108, obs109;
	private ObstacleObject4Long obs77, obs78, obs79, obs110, obs111, obs112, obs113;
	private ObstacleObject14Wide obs114;
	private ObstacleObject17Long obs80;
	
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
	
	public Level_5( final int charNum, final int score1 )
	{	
		super( "Perplexia - Tall Maps: Level 2 (Garden)" );
		saveFile = new ReadSaveFile();
		panel = new EasyPanel( 5 );
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
					
					option = JOptionPane.showOptionDialog( Level_5.this, 
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
					
					option = JOptionPane.showOptionDialog( Level_5.this, 
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
					
					option = JOptionPane.showOptionDialog( Level_5.this, 
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
					JOptionPane.showMessageDialog( Level_5.this,
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
					JOptionPane.showMessageDialog( Level_5.this,
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
					
					option = JOptionPane.showOptionDialog( Level_5.this, 
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
		
		player1 = new CharacterControl( 294, 7, KeyEvent.VK_DOWN, panel, char1 );
		panel.add( player1 );
		
		obsEnd = new ObstacleObject( 279, 928, panel, "images", 8 );
		
		player1.keyPressed( KeyEvent.VK_DOWN + KeyEvent.VK_UP );
		player1.keyPressed( KeyEvent.VK_DOWN + KeyEvent.VK_UP );
		
		obs1 = new ObstacleObjectSingle( 32, 160, panel );
		obs2 = new ObstacleObjectSingle( 32, 447, panel );
		obs3 = new ObstacleObjectSingle( 64, 95, panel );
		obs4 = new ObstacleObjectSingle( 318, 95, panel );
		obs5 = new ObstacleObjectSingle( 445, 479, panel );
		obs6 = new ObstacleObjectSingle( 476, 415, panel );
		obs7 = new ObstacleObjectSingle( 540, 64, panel );
		obs8 = new ObstacleObjectSingle( 540, 192, panel );
		obs9 = new ObstacleObjectSingle( 540, 575, panel );
		obs10 = new ObstacleObjectSingle( 572, 95, panel );
		obs11 = new ObstacleObjectSingle( 572, 288, panel );
		obs12 = new ObstacleObjectSingle( 572, 607, panel );
		obs82 = new ObstacleObjectSingle( 349, 737, panel );
		obs83 = new ObstacleObjectSingle( 476, 673, panel );
		obs84 = new ObstacleObjectSingle( 32, 769, panel );
		obs85 = new ObstacleObjectSingle( 0, 832, panel );
		
		obs13 = new ObstacleObject2Wide( 32, 383, panel );
		obs14 = new ObstacleObject2Wide( 32, 415, panel );
		obs15 = new ObstacleObject2Wide( 32, 479, panel );
		obs16 = new ObstacleObject2Wide( 32, 511, panel );
		obs17 = new ObstacleObject2Wide( 159, 192, panel );
		obs18 = new ObstacleObject2Wide( 159, 223, panel );
		obs19 = new ObstacleObject2Wide( 159, 256, panel );
		obs20 = new ObstacleObject2Wide( 159, 415, panel );
		obs21 = new ObstacleObject2Wide( 222, 32, panel );
		obs22 = new ObstacleObject2Wide( 222, 64, panel );
		obs23 = new ObstacleObject2Wide( 222, 351, panel );
		obs24 = new ObstacleObject2Wide( 222, 863, panel );
		obs25 = new ObstacleObject2Wide( 222, 895, panel );
		obs26 = new ObstacleObject2Wide( 222, 927, panel );
		obs27 = new ObstacleObject2Wide( 254, 160, panel );
		obs28 = new ObstacleObject2Wide( 318, 32, panel );
		obs29 = new ObstacleObject2Wide( 318, 415, panel );
		obs30 = new ObstacleObject2Wide( 318, 447, panel );
		obs31 = new ObstacleObject2Wide( 318, 479, panel );
		obs32 = new ObstacleObject2Wide( 318, 543, panel );
		obs33 = new ObstacleObject2Wide( 318, 863, panel );
		obs34 = new ObstacleObject2Wide( 318, 895, panel );
		obs115 = new ObstacleObject2Wide( 318, 927, panel );
		obs116 = new ObstacleObject2Wide( 413, 543, panel );
		obs35 = new ObstacleObject2Wide( 413, 927, panel );
		obs36 = new ObstacleObject2Wide( 445, 0, panel );
		obs37 = new ObstacleObject2Wide( 476, 128, panel );
		obs38 = new ObstacleObject2Wide( 476, 383, panel );
		obs39 = new ObstacleObject2Wide( 508, 160, panel );
		obs40 = new ObstacleObject2Wide( 508, 479, panel );
		obs41 = new ObstacleObject2Wide( 508, 543, panel );
		obs42 = new ObstacleObject2Wide( 445, 64, panel );
		obs86 = new ObstacleObject2Wide( 254, 575, panel );
		obs87 = new ObstacleObject2Wide( 318, 543, panel );
		obs88 = new ObstacleObject2Wide( 318, 575, panel );
		obs89 = new ObstacleObject2Wide( 445, 705, panel );
		obs90 = new ObstacleObject2Wide( 445, 737, panel );
		
		obs43 = new ObstacleObject2Long( 159, 511, panel );
		obs44 = new ObstacleObject2Long( 540, 415, panel );
		obs45 = new ObstacleObject2Long( 603, 575, panel );
		obs91 = new ObstacleObject2Long( 254, 737, panel );
		obs92 = new ObstacleObject2Long( 318, 705, panel );
		obs93 = new ObstacleObject2Long( 603, 895, panel );
		obs94 = new ObstacleObject2Long( 159, 863, panel );
		
		obs46 = new ObstacleObject3Wide( 32, 543, panel );
		obs47 = new ObstacleObject3Wide( 95, 543, panel );
		obs48 = new ObstacleObject3Wide( 127, 607, panel );
		obs49 = new ObstacleObject3Wide( 191, 479, panel );
		obs50 = new ObstacleObject3Wide( 254, 223, panel );
		obs51 = new ObstacleObject3Wide( 254, 256, panel );
		obs52 = new ObstacleObject3Wide( 254, 288, panel );
		obs53 = new ObstacleObject3Wide( 318, 351, panel );
		obs54 = new ObstacleObject3Wide( 381, 223, panel );
		obs55 = new ObstacleObject3Wide( 381, 288, panel );
		obs56 = new ObstacleObject3Wide( 413, 575, panel );
		obs57 = new ObstacleObject3Wide( 476, 223, panel );
		obs81 = new ObstacleObject3Wide( 476, 288, panel );
		obs95 = new ObstacleObject3Wide( 222, 543, panel );
		obs96 = new ObstacleObject3Wide( 381, 862, panel );
		obs97 = new ObstacleObject3Wide( 381, 927, panel );
		obs98 = new ObstacleObject3Wide( 445, 641, panel );
		obs99 = new ObstacleObject3Wide( 476, 863, panel );
		obs100 = new ObstacleObject3Wide( 476, 800, panel );
		obs101 = new ObstacleObject3Wide( 32, 737, panel );
		obs102 = new ObstacleObject3Wide( 127, 673, panel );
		obs103 = new ObstacleObject3Wide( 127, 737, panel );
		
		obs58 = new ObstacleObject3Long( 127, 479, panel );
		obs59 = new ObstacleObject3Long( 191, 288, panel );
		obs60 = new ObstacleObject3Long( 254, 383, panel );
		obs104 = new ObstacleObject3Long( 318, 673, panel );
		
		obs61 = new ObstacleObject4Wide( 0, 320, panel );
		obs62 = new ObstacleObject4Wide( 0, 607, panel );
		obs63 = new ObstacleObject4Wide( 32, 0, panel );
		obs64 = new ObstacleObject4Wide( 32, 192, panel );
		obs65 = new ObstacleObject4Wide( 32, 223, panel );
		obs66 = new ObstacleObject4Wide( 32, 256, panel );
		obs67 = new ObstacleObject4Wide( 64, 64, panel );
		obs68 = new ObstacleObject4Wide( 64, 128, panel );
		obs69 = new ObstacleObject4Wide( 159, 0, panel );
		obs70 = new ObstacleObject4Wide( 191, 128, panel );
		obs71 = new ObstacleObject4Wide( 318, 0, panel );
		obs72 = new ObstacleObject4Wide( 318, 64, panel );
		obs73 = new ObstacleObject4Wide( 349, 128, panel );
		obs74 = new ObstacleObject4Wide( 349, 160, panel );
		obs75 = new ObstacleObject4Wide( 445, 351, panel );
		obs76 = new ObstacleObject4Wide( 508, 0, panel );
		obs105 = new ObstacleObject4Wide( 318, 641, panel );
		obs106 = new ObstacleObject4Wide( 476, 927, panel );
		obs107 = new ObstacleObject4Wide( 0, 673, panel );
		obs108 = new ObstacleObject4Wide( 32, 863, panel );
		obs109 = new ObstacleObject4Wide( 32, 895, panel );
		
		obs77 = new ObstacleObject4Long( 0, 0, panel );
		obs78 = new ObstacleObject4Long( 127, 320, panel );
		obs79 = new ObstacleObject4Long( 413, 383, panel );
		obs110 = new ObstacleObject4Long( 254, 607, panel );
		obs111 = new ObstacleObject4Long( 540, 673, panel );
		obs112 = new ObstacleObject4Long( 603, 641, panel );
		obs113 = new ObstacleObject4Long( 603, 769, panel );
		
		obs114 = new ObstacleObject14Wide( 32, 800, panel );
		
		obs80 = new ObstacleObject17Long( 603, 32, panel );
		
		panel.add( obs1 ); panel.add( obs24 ); panel.add( obs47 );
		panel.add( obs2 ); panel.add( obs25 ); panel.add( obs48 );
		panel.add( obs3 ); panel.add( obs26 ); panel.add( obs49 );
		panel.add( obs4 ); panel.add( obs27 ); panel.add( obs50 );
		panel.add( obs5 ); panel.add( obs28 ); panel.add( obs51 );
		panel.add( obs6 ); panel.add( obs29 ); panel.add( obs52 );
		panel.add( obs7 ); panel.add( obs30 ); panel.add( obs53 );
		panel.add( obs8 ); panel.add( obs31 ); panel.add( obs54 );
		panel.add( obs9 ); panel.add( obs32 ); panel.add( obs55 );
		panel.add( obs10 ); panel.add( obs33 ); panel.add( obs56 );
		panel.add( obs11 ); panel.add( obs34 ); panel.add( obs57 );
		panel.add( obs12 ); panel.add( obs35 ); panel.add( obs58 );
		panel.add( obs13 ); panel.add( obs36 ); panel.add( obs59 );
		panel.add( obs14 ); panel.add( obs37 ); panel.add( obs60 );
		panel.add( obs15 ); panel.add( obs38 ); panel.add( obs61 );
		panel.add( obs16 ); panel.add( obs39 ); panel.add( obs62 );
		panel.add( obs17 ); panel.add( obs40 ); panel.add( obs63 );
		panel.add( obs18 ); panel.add( obs41 ); panel.add( obs64 );
		panel.add( obs19 ); panel.add( obs42 ); panel.add( obs65 );
		panel.add( obs20 ); panel.add( obs43 ); panel.add( obs66 );
		panel.add( obs21 ); panel.add( obs44 ); panel.add( obs67 );
		panel.add( obs22 ); panel.add( obs45 ); panel.add( obs68 );
		panel.add( obs23 ); panel.add( obs46 ); panel.add( obs69 );
		panel.add( obs70 ); panel.add( obs71 ); panel.add( obs72 );
		panel.add( obs73 ); panel.add( obs74 ); panel.add( obs75 );
		panel.add( obs76 ); panel.add( obs77 ); panel.add( obs78 );
		panel.add( obs79 ); panel.add( obs80 ); panel.add( obs81 );
		panel.add( obs82 ); panel.add( obs83 ); panel.add( obs84 );
		panel.add( obs85 ); panel.add( obs86 ); panel.add( obs87 );
		panel.add( obs88 ); panel.add( obs89 ); panel.add( obs90 );
		panel.add( obs91 ); panel.add( obs92 ); panel.add( obs93 );
		panel.add( obs94 ); panel.add( obs95 ); panel.add( obs96 );
		panel.add( obs97 ); panel.add( obs98 ); panel.add( obs99 );
		panel.add( obs100 ); panel.add( obs101 ); panel.add( obs102 );
		panel.add( obs103 ); panel.add( obs104 ); panel.add( obs105 );
		panel.add( obs106 ); panel.add( obs107 ); panel.add( obs108 );
		panel.add( obs109 ); panel.add( obs110 ); panel.add( obs111 );
		panel.add( obs112 ); panel.add( obs113 ); panel.add( obs114 );
		panel.add( obs115 ); panel.add( obs116 ); 
		
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
					
					JOptionPane.showMessageDialog( Level_5.this, "You beat the second level!\nYour current score is " + score + ".",
							"Winning", JOptionPane.PLAIN_MESSAGE );
					
					setVisible( false );
			
					Level_6 l3 = new Level_6( charNum, score );
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
					
					JOptionPane.showMessageDialog( Level_5.this, "You did not reach the goal in the time limit. You lose.",
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