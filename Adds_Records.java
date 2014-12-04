// most code in this program is from BicycleFrame2.java 
//  Add records and store in an array: display the array
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/** manages an array of scooters: add and display implemented, but only for owner name */
public class Adds_Records extends JFrame implements ActionListener{
	
	 // private instance variables
    private JButton rentButton;
    private JLabel welcomeLabel;
     JMenu fileMenu,scooterMenu,rentMenu;
     Scooter [] scooters; // an array of scooters
     int count=0; // number of valid scooters in the array

    // driver
    public static void main( String[] args ) {
        Adds_Records frame = new Adds_Records();
        frame.setVisible(true);
    }

    // constructor
    public Adds_Records( ) {
        newSystem(); // create the array and set the count to 0
        //set the frame default properties
        setTitle     ( "Scooter shop system" ); //modified
        setSize      ( 1000,400 ); //modified
        setResizable (false); //modified
        setLocation  ( 350,250 ); //modified
     
       
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );  
        
        // get the content pane 
         Container cPane = getContentPane( );
        cPane.setLocation(350,200);
        	                  
		//add JLabel object
		welcomeLabel = new JLabel( "Welcome to Rent a Scooter. On our site you can rent a scooter and add a scooter to the system. ");
        cPane.add(welcomeLabel);

        createFileMenu();
        createScooterMenu();
        createRentMenu();
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
         // setting the backgroung color of the menubar to yellow
        menuBar.setBackground(Color.yellow); //modified
        menuBar.add(fileMenu);
        menuBar.add(scooterMenu);
        menuBar.add(rentMenu); //modified
     }

      public void newSystem() {
      	scooters = new Scooter[10];
      	count = 0;
      }

      /** adds a new scooter to the system, getting the details from the user
       */   // NEW
      public void addScooter(){
      	Scooter temp = new Scooter();
      	temp.setOwner(JOptionPane.showInputDialog("Who owns this scooter?")); //modified
      	temp.setMake(JOptionPane.showInputDialog("What is the make of this scooter?")); //modified
      	temp.setValue(Integer.parseInt(JOptionPane.showInputDialog("How much is this scooter?"))); //modified
      	scooters[count] = temp; // 'default scooter
      	// set the attributes: ask the user for owner name 
      	count++; // now there is one more scooter in the system
      }
      
      /** records the date of the rental and the return date getting the details
        from the user and using a date forumla also calcuting the cost of the rental**/
        
      public void rentScooter(){
      	   // Get an instance of a Calendar, using the current time.

        
			Calendar cal = Calendar.getInstance();
			
			
		int	days= Integer.parseInt(JOptionPane.showInputDialog("How many days would you like to rent the scooter for? ")); //modified


                       JOptionPane.showMessageDialog(null,"The rental date is: "+cal.getTime());
                       cal.add(Calendar.DATE, days);                                  //added the amount of days the user wants to rent for //modified
                       JOptionPane.showMessageDialog(null,"The return date : "+cal.getTime());
  					JOptionPane.showMessageDialog(null,"The cost of the rental is: € " + days *30); //modified
  						
  	// below goten from sample program MyJFrame3.java
  						     	 
         // get the content pane and set properties
        Container contentPane = getContentPane();
        
      	 // construct a button and make this Adds_Records listen for
        // and  handle button events
        rentButton = new JButton("Rent");
        rentButton.setBounds(110,230,80,40);
	    rentButton.addActionListener(this);
        contentPane.add(rentButton);
  
  // get the content pane //// next 2 lines goten from sample program MyJFrame3.java
   Container cPane2 = getContentPane( );
        cPane2.setLayout(new FlowLayout());
  
  //create and place button on the frame
        rentButton = new JButton("Rent");
        cPane2.add(rentButton);

        //register this frame as an action listener of the two buttons
        rentButton.addActionListener(this);
}
      /*****************************************************
*    Title: Java Date and Calendar Examples
*    Author: Anil Nivargi     at  8/17/2014 11:40:00 pm
*    Site owner/sponsor:  Core Java Interview Questions with Answers
*    Date: 2014
*    Code version: 
*    Availability: http://adnjavainterview.blogspot.in/2014/08/java-date-and-calendar-examples.html
*    Modified: 27/11/2014 changing the word Date to DATE , adding in the users input so it an be any amount of days for rental
*****************************************************/ 




      //Displays a list of all scooters in a JTextArea
        
      public void displayScooters(){
      	JTextArea area = new JTextArea();
      	if (count>0) {
      	  area.setText("Scooter List: \n\n");
      	  for (int i = 0; i<count; i++) // loop over existing scooters, rather than array size
      	    area.append("scooter no: " + i + " " +scooters[i].toString()+"\n");
      	  showMessage(area);
      	}
      	else
      	    showMessage("No Scooters in the system");
      } // end display
      
      

      public void actionPerformed (ActionEvent e) {
      	if (e.getActionCommand() .equals ("Quit")){
      	 showMessage("Shutting down the system");
      	 System.exit(0);
      	}// else if
      	else if (e.getActionCommand() .equals ("Add")){
      	   addScooter(); // branch to a separate method
      	}// else if
      	else if (e.getActionCommand() .equals ("Display")){
           displayScooters();
      	}// else if
      	else if (e.getActionCommand() .equals ("New File")){
      		newSystem();
        }// else if
      	else if (e.getActionCommand() .equals ("Save")){
      		
      	 showMessage("Save has been made");
      	}// else if

      	else if (e.getActionCommand() .equals ("Open")){
      	 showMessage("Open not implemented yet");
      	}// else if
      	else if (e.getActionCommand() .equals ("Rent scooter")){
      		rentScooter(); // branch to a separate method
      	}// else
      	else
      	  showMessage("I have no idea what you clicked");
      } // actionPerformed

        private void createFileMenu(){
         // create