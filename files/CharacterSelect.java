package perplexia;

import java.awt.*;
import javax.swing.*;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.net.URL;

public class CharacterSelect extends JFrame implements ActionListener
{
	/**
	 * This class is for displaying the character select menu
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox CharaSelect; //j combo box for character selection
	private JLabel label;
	private String names[] = { "Celes", "Gau", "Locke", "Terra", "Umaro", "Ghost" }; //character names
	private Icon icons[] = { new ImageIcon( getClass().getResource( "images/4a.gif" ) ), 
							 new ImageIcon( getClass().getResource( "images/4b.gif" ) ), 
							 new ImageIcon( getClass().getResource( "images/4.gif"  ) ), 
							 new ImageIcon( getClass().getResource( "images/4d.gif" ) ), 
							 new ImageIcon( getClass().getResource( "images/4e.gif" ) ),	
							 new ImageIcon( getClass().getResource( "images/4c.gif" ) ),	};
	private JButton button; //accept button
	private BorderLayout layout;
	private int charNum;
	private int level1;
		
	//character select constructor
	public CharacterSelect( int level )
	{		
		super( "Perplexia - Character Select" ); //imposes name at top of panel
		setLayout( new FlowLayout() );
		
		level1 = level;
		
		CharaSelect = new JComboBox( names ); //sets up j combo box
		CharaSelect.setMaximumRowCount( 6 ); //number of rows is 6
		
		CharaSelect.addItemListener( //selects character from index
			new ItemListener()
			{
				public void itemStateChanged( ItemEvent event )
				{
					if( event.getStateChange() == ItemEvent.SELECTED)
					{
						label.setIcon( icons[ CharaSelect.getSelectedIndex() ] );
						charNum = CharaSelect.getSelectedIndex();
					}
				}
			}
		);
		
		layout = new BorderLayout( 5, 5 ); //sets up a border layout
		setLayout( layout );

		add( CharaSelect, BorderLayout.CENTER ); //adds character select to panel
		
		label = new JLabel( icons[0] );
		add( label, BorderLayout.NORTH );
		
		button = new JButton( "BEGIN GAME" );
		button.addActionListener( this );
		add( button, BorderLayout.SOUTH );

		pack(); //makes sure panel encompasses all components
		setVisible( true ); //sets visibility to true so its visible
	}
	
	//class used to throw exception in case directory for image files is not found
	protected ImageIcon createImageIcon(String path, String description) 
	{
        URL imgURL = getClass().getResource(path);
        if (imgURL != null) 
        {
            return new ImageIcon(imgURL, description);
        } 
        else 
        {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
	
	//checks to see if button is pressed, confirming selection and starting new game
	public void actionPerformed( ActionEvent event )
	{
		Dimension myScreenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		
		if( event.getSource() == button )
		{		
			setVisible( false );
			
			if( level1 == 1 ) //if statement for which map size was chosen before charaselect was called
			{
				Level_1 l1 = new Level_1( charNum ); //starts new square maps game
				int width = l1.getSize().width;
				int height = l1.getSize().height;
				int x_cord = ( myScreenSize.width-width )/2;
				int y_cord = ( myScreenSize.height-height )/2;
				l1.setLocation( x_cord, y_cord );
				l1.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				l1.setResizable( false );	
			}
			else if( level1 == 2 )
			{
				Level_4 l4 = new Level_4( charNum ); //starts new tall maps game
				int width = l4.getSize().width;
				int height = l4.getSize().height;
				int x_cord = ( myScreenSize.width-width )/2;
				int y_cord = ( myScreenSize.height-height )/2;
				l4.setLocation( x_cord, y_cord );
				l4.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				l4.setResizable( false );	
			}
			else if( level1 == 3 )
			{				
				Level_7 l7 = new Level_7( charNum ); //starts new wide maps game			
				int width = l7.getSize().width;
				int height = l7.getSize().height;
				int x_cord = ( myScreenSize.width-width )/2;
				int y_cord = ( myScreenSize.height-height )/2;
				l7.setLocation( x_cord, y_cord );
				l7.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
				l7.setResizable( false );	
			}
			
		}
	}
}