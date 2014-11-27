// version 2 Add records and store in an array: display the array
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/** manages an array of scooters: add and display implemented, but only for owner name */
public class Adds_Records extends JFrame implements ActionListener{

     JMenu fileMenu,scooterMenu,rentMenu;
     Scooter [] scooters; // an array of scooters
     int count; // number of valid scooters in the array

    // driver
    public static void main( String[] args ) {
        Adds_Records frame = new Adds_Records();
        frame.setVisible(true);
    }

    // constructor
    public Adds_Records( ) {
        newSystem(); // create the array and set the count to 0
        //set the frame default properties
        setTitle     ( "Scooter shop system" );
        setSize      ( 600,200 );
        setLocation  ( 200,200 );
        Container pane = getContentPane();
      //  pane.setBackground(Color.blue);
        pane.setBackground(new Color(240,210,240));
        //register 'Exit upon closing' as a default close operation
        setDefaultCloseOperation( EXIT_ON_CLOSE );                    

        createFileMenu();
        createScooterMenu();
        createRentMenu();
        //and add them to the menubar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(scooterMenu);
        menuBar.add(rentMenu);
     }

      public void newSystem() {
      	scooters = new Scooter[10];
      	count = 0;
      }

      /** adds a new scooter to the system, getting the details from the user
       */   // NEW
      public void addScooter(){
      	Scooter temp = new Scooter();
      	temp.setOwner(JOptionPane.showInputDialog("Who owns this scooter?"));
      	scooters[count] = temp; // 'default bike
      	// set the attributes: ask the user for owner name etc
      	count++; // now there is one more scooter in the system
      }
      
      /** records the date of the rental and the return date getting the details
        from the user and usign a date forumla **/
        
      public void rentScooter(){
      	   // Get an instance of a Calendar, using the current time.

                                 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

                                Calendar calendar = Calendar.getInstance();

                                System.out.println(dateFormat.format(calendar.getTime()));

        
			Calendar cal = Calendar.getInstance();
			
			
		int	days= Integer.parseInt(JOptionPane.showInputDialog("How many days would you like to rent the scooter for? "));


                       System.out.println("The rental date is: "+cal.getTime());
                       cal.add(Calendar.DATE, days);                                  //added the amount of days the user wants to rent for
                       System.out.println("The return date : "+cal.getTime());
  
  

      /*****************************************************
*    Title: Java Date and Calendar Examples
*    Author: Anil Nivargi     at  8/17/2014 11:40:00 pm
*    Site owner/sponsor:  Core Java Interview Questions with Answers
*    Date: 2014
*    Code version: 
*    Availability: http://adnjavainterview.blogspot.in/2014/08/java-date-and-calendar-examples.html
*    Modified: 27/11/2014 changing the word Date to DATE , adding in the users input so it an be any amount of days for rental
*****************************************************/ 
}



      /** Displays a list of all scooters in a JTextArea
       */  // NEW
      public void display(){
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
      	}
      	else if (e.getActionCommand() .equals ("Add")){
      	   addScooter(); // branch to a separate method
      	}
      	else if (e.getActionCommand() .equals ("Display")){
           display();
      	}
      	else if (e.getActionCommand() .equals ("New File")){
      		newSystem();
        }
      	else if (e.getActionCommand() .equals ("Save")){
      	 showMessage("Save not implemented yet");
      	}// else if

      	else if (e.getActionCommand() .equals ("Open")){
      	 showMessage("Open not implemented yet");
      	}
      	else if (e.getActionCommand() .equals ("Rent scooter")){
      		rentScooter(); // branch to a separate method
      	}
      	else
      	  showMessage("I have no idea what you clicked");
      } // actionPerformed

        private void createFileMenu(){
         // create the menu
      	fileMenu = new JMenu("File");
      	// declare a menu item (re-usable)
      	JMenuItem item;
      	
      	item = new JMenuItem("Save");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	
      	item = new JMenuItem("Open");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	
      	item = new JMenuItem("New File");
      	item.addActionListener(this);
      	fileMenu.add(item);
      	
      	// create the 'quit' option
      	fileMenu.addSeparator();
      	item = new JMenuItem("Quit");
      	item.addActionListener(this);
      	fileMenu.add(item);
      }

      private void createScooterMenu(){
      	// create the menu
      	scooterMenu = new JMenu("Scooter");
      	// declare a menu item (re-usable)
      	JMenuItem item;

      	item = new JMenuItem("Add");
      	item.addActionListener(this);
      	scooterMenu.add(item);

      	item = new JMenuItem("Display");
      	item.addActionListener(this);
      	scooterMenu.add(item);
      }
      
      private void createRentMenu(){
      	//create the menu
      	rentMenu = new JMenu("Rent");
      	// declare a menu item (re-usable)
      		JMenuItem item;

      	item = new JMenuItem("Rent scooter");
      	item.addActionListener(this);
      	rentMenu.add(item);

      }
      
    
       /** utility methods to make the code simpler */
      public void showMessage (String s){
      	JOptionPane.showMessageDialog(null,s);
      }

      public void showMessage (JTextArea s){
      	JOptionPane.showMessageDialog(null,s);
      }
}

