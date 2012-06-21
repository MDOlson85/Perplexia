package perplexia;

import javax.swing.*;
import java.applet.*;
import java.awt.*;

public class MainProgram extends Applet
{
	/**
	 * This class contains the main class which starts the program
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main( String [] args ) //main function
	{				
		Dimension myScreenSize = Toolkit.getDefaultToolkit().getScreenSize(); //gets screen size
		MainMenu menu = new MainMenu(); //creates new main menu
		menu.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); //main menu closes on exit
		menu.setSize( 786, 348 ); //sets size of main menu
		menu.setResizable( false ); //main menu is not resizable
		int width = menu.getSize().width; 
		int height = menu.getSize().height; //determines placement of main menu
		int x_cord = ( myScreenSize.width-width )/2;
		int y_cord = ( myScreenSize.height-height )/2;
		menu.setLocation( x_cord, y_cord ); //main menu is placed directly in center of screen
		menu.setVisible( true ); //sets visibility of main menu to true
	}
}