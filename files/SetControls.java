package perplexia;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SetControls extends JFrame implements KeyListener
{
	/**
	 * This class creates a panel for changing the controls
	 */
	private static final long serialVersionUID = 1L;

	private String line1 = ""; // first line of text area
   	private String line2 = ""; // second line of text area
   	private JTextArea textArea; // text area to display output
   	private String line3 = ""; 
   	
   	private int up = 38;
   	private int down = 40;
   	private int left = 37;
   	private int right = 39;
   	
   	private int tempUp;
   	private int tempDown;
   	private int tempLeft;
   	private int tempRight;
   	
   	private boolean first;
   	private boolean second;
   	private boolean third;
   	private boolean fourth;
   	private boolean fifth;
   	
   	private ReadSaveFile saveFile;
		
	public SetControls()
	{
		super( "Set Controls" );
		
		textArea = new JTextArea( 10, 15 );
		textArea.setText( "Enter the key for 'Up': " );
      	textArea.setEnabled( false );
      	textArea.setDisabledTextColor( Color.BLACK );
   
      	first = false;
   		second = false;
   		third = false;
   		fourth = false;
   		fifth = false;
		
		add( textArea, BorderLayout.CENTER );
		addKeyListener( this );

		pack();
		setVisible( true );
	}
	
	public void keyPressed( KeyEvent event )
   	{
   		if( first == false )
   		{
      		line1 = String.format( "Enter the key for 'Up': %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		up = event.getKeyCode();
      		
      		if( up == KeyEvent.VK_ALT )
      		{	
      			up = KeyEvent.VK_UP;
      		}
      		
      		first = true;
      		setLines2and3( event );
   		}
   		else if( second == false )
   		{
      		line1 = String.format( "Enter the key for 'Down': %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		down = event.getKeyCode();
      		
      		if( down == KeyEvent.VK_ALT || down == up )
      		{	
      			down = KeyEvent.VK_DOWN;
      		}
      		
      		if( down == up && up == KeyEvent.VK_DOWN )
      		{
      			up = KeyEvent.VK_UP;
      		}

      		second = true;
      		setLines2and3( event );
   		}
   		else if( third == false )
   		{
      		line1 = String.format( "Enter the key for 'Left': %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		left = event.getKeyCode();
      		
      		if( left == KeyEvent.VK_ALT || left == down || left == up )
      		{	
      			left = KeyEvent.VK_LEFT;
      		}
      		
      		third = true;
      		setLines2and3( event );
   		}
   		else if( fourth == false )
   		{
      		line1 = String.format( "Enter the key for 'Right': %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		right = event.getKeyCode();
      		
      		if( right == KeyEvent.VK_ALT || right == down || right == up || right == left)
      		{	
      			right = KeyEvent.VK_RIGHT;
      		}
      		
      		fourth = true;
      		setLines2and3( event );
   		}
   		else if( fourth == true && fifth == false )
   		{	
			//setVisible( false );
			
			saveFile = new ReadSaveFile();
			
			tempUp = saveFile.getCtrlUp();
			tempDown = saveFile.getCtrlDown();
			tempLeft = saveFile.getCtrlLeft();
			tempRight = saveFile.getCtrlRight();
			
			String prevUp = String.format( "%s", KeyEvent.getKeyText( tempUp ) );
			String prevDown = String.format( "%s", KeyEvent.getKeyText( tempDown ) );
			String prevLeft = String.format( "%s", KeyEvent.getKeyText( tempLeft ) );
			String prevRight = String.format( "%s", KeyEvent.getKeyText( tempRight ) );
			
   			Object[] options = {"Keep new settings", "Revert to previous settings", "Revert to default settings" };
				
			int option;
					
			option = JOptionPane.showOptionDialog( SetControls.this, 
				"Are you sure you want to keep these key settings?\n" +
				"The default key settings are Up, Down, Left, and Right.\n" +		
				"The previous key settings were " + prevUp + ", " + prevDown + ", " + prevLeft + 
				", and " + prevRight + ".\n", "Controls", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2] );

    		if( option == 0 )
    		{
    			saveFile.setCtrlUp( up );
				saveFile.setCtrlDown( down );
				saveFile.setCtrlLeft( left );
				saveFile.setCtrlRight( right );
				saveFile.openFile();
    		}
       		else if( option == 1 )
       		{			
				saveFile.setCtrlUp( tempUp );
				saveFile.setCtrlDown( tempDown );
				saveFile.setCtrlLeft( tempLeft );
				saveFile.setCtrlRight( tempRight );
				saveFile.openFile();
       		}
       		else if( option == 2 )
       		{			
				saveFile.setCtrlUp( 38 );
				saveFile.setCtrlDown( 40 );
				saveFile.setCtrlLeft( 37 );
				saveFile.setCtrlRight( 39 );
				saveFile.openFile();
       		}
       		
       		setVisible( false );
		}
   	} 
   	
	public void keyReleased( KeyEvent event )
   	{  	
   		if( first == true && second == false )
   		{
      		line1 = String.format( "The key for 'Up' is set to: %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		setLines2and3( event );
   		}
      	else if( second == true && third == false )
      	{
      		line1 = String.format( "The key for 'Down' is set to: %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		setLines2and3( event );
      	}	
      	else if( third == true && fourth == false )
      	{
      		line1 = String.format( "The key for 'Left' is set to: %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		setLines2and3( event );
      	}
      	else if( fourth == true && fifth == false )
      	{
      		line1 = String.format( "The key for 'Right' is set to: %s", KeyEvent.getKeyText( event.getKeyCode() ) );
      		setLines2and3( event );
		}
  	} 
   
   	public void keyTyped( KeyEvent event )
   	{

   	}
   
   	private void setLines2and3( KeyEvent event )
	{
   		if( first == true && second == false )
   		{
      		line2 = String.format( "Now set the key for 'Down'. " );
   		}
   		else if( second == true && third == false )
   		{
   			line2 = String.format( "Now set the key for 'Left'. " );
   		}
   		else if( third == true && fourth == false )
   		{
   			line2 = String.format( "Now set the key for 'Right'. " );
   		}
   		else if( fourth == true && fifth == false )
   		{
   			line2 = String.format( "All keys have been set. Press any key to continue..." );   			
   		}

      	line3 = String.format( "" );

      	textArea.setText( String.format( "%s\n%s\n%s\n", 
        line1, line2, line3 ) );
   	}
}