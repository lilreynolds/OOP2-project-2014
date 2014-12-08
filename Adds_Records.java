// most code in this program is from BicycleFrame2.java author John Walsh

//  Add records and store in an array: display the array
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat; //Reference Java Date and Calendar Examples
import java.util.Calendar; //Reference Java Date and Calendar Examples
import java.io.*; //References BicycleFrame3.java 

/**Has 3 menus. Manages an array of scooters: add and display implemented 
 *and stores and calculates the rental date */

public class Adds_Records extends JFrame implements ActionListener{
	
	// private instance variables including JButton,JLabel,JMenu
    private JButton rentButton; //modified from 
    private JLabel welcomeLabel; //modified
    private JMenuBar item; //modified
    private JMenu fileMenu;
    private JMenu scooterMenu;
    private JMenu rentMenu; //modified
    
     Scooter [] scootersArray; // an array of scooters //modified
     int count; // number of valid scooters in the array //modified

    // driver
    public static void main( String[] args ) {
        Adds_Records frame = new Adds_Records(); //modified
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
        
        //modified from TextFieldLabelExample.java	                  
		//add JLabel object
		welcomeLabel = new JLabel( "Welcome to Rent a Scooter. On our site you can rent a scooter and add a scooter to the system. "); 
        
            /*****************************************************
*    Title: How to center the text in a JLabel?
*    Author: ramsey0 answered Feb 7 at 21:53 
*    Site owner/sponsor:  Stackoverflow
*    Date: 2014
*    Code version: 
*    Availability: http://stackoverflow.com/questions/6810581/how-to-center-the-text-in-a-jlabel
*    Modified: 4/12/2014 
*****************************************************/  
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		      /*****************************************************
*    Title: How do I set the colour of a label (coloured text) in Java?
*    Author: Raven Dreamer answered Jun 3 '10 at 13:27 
*    Site owner/sponsor:  Stackoverflow
*    Date: 2014
*    Code version: 
*    Availability: http://stackoverflow.com/questions/2966334/how-do-i-set-the-colour-of-a-label-coloured-text-in-java
*    Modified: 6/12/2014  changed to red
*****************************************************/  
		welcomeLabel.setForeground(Color.red);
		
			
		      /*****************************************************
*    Title: How to change the size of the font of a JLabel to take the maximum size
*    Author: Asaf David answered Apr 26 '10 at 16:33 
*    Site owner/sponsor:  Stackoverflow
*    Date: 2014
*    Code version: 
*    Availability: http://stackoverflow.com/questions/2715118/how-to-change-the-size-of-the-font-of-a-jlabel-to-take-the-maximum-size
*    Modified: 6/12/2014  changed to 20
*****************************************************/  
		welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        
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
      	scootersArray = new Scooter[10];
      	count = 0;
      }

		//from BicycleFrame3.java
		/** writes the array of scooters to the file "Scooter.dat"
       */   
      public void save() throws IOException {
      	ObjectOutputStream os;
      	os = new ObjectOutputStream(new FileOutputStream ("Scooter.dat")); //modifed
      	os.writeObject(scootersArray); //modifed
      	os.close();
      }
      
      /** loads an array of scooters from the file "Scooter.dat" //modifed
       */  
      public void open() {
      	count = 0;
      	try{
      	  ObjectInputStream is;
      	  is = new ObjectInputStream(new FileInputStream ("Scooter.dat")); //modifed
         	scootersArray  = (Scooter []) is.readObject(); //modifed
      	  is.close(); 
      	}
      	catch(Exception e){
      		JOptionPane.showMessageDialog(null,"open is not working at the moment"); //modifed
      		e.printStackTrace();
      	}
      	
      	// how many valid scooter records?
      	while (scootersArray[count] !=null) //modifed
      	   count++;
      } // end open()




      /** creating a new scooter to the system, getting the details from the user
       *adding a scooter to the array
       */   
      public void addScooter(){
      	Scooter temp = new Scooter();
      	temp.setOwner(JOptionPane.showInputDialog("Who owns this scooter?")); //modified
      	temp.setMake(JOptionPane.showInputDialog("What is the make of this scooter?")); //modified
      	temp.setValue(Integer.parseInt(JOptionPane.showInputDialog("How much is this scooter?"))); //modified
      	scootersArray[count] = temp; // 'default scooter
      	// set the attributes: ask the user for owner name , make of scooter and the cost
      	count++; // now there is one more scooter in the system
      }
      
      /** uses a customer method ,records the date of the rental and the return date getting the details
        from the user and using a date forumla also calcuting the cost of the rental**/
            /*****************************************************
*    Title: Java Date and Calendar Examples
*    Author: Anil Nivargi     at  8/17/2014 11:40:00 pm
*    Site owner/sponsor:  Core Java Interview Questions with Answers
*    Date: 2014
*    Code version: 
*    Availability: http://adnjavainterview.blogspot.in/2014/08/java-date-and-calendar-examples.html
*    Modified: 27/11/2014 changing the word Date to DATE , adding in the users input so it an be any amount of days for rental
*****************************************************/  
 
      public void rentScooter(){
     
     //input 	
      	Customer temp2 = new Customer(); //modified from BicycleDriver.java
      	temp2.setName(JOptionPane.showInputDialog("What is your name?")); //modified from BicycleDriver.java
      	temp2.setAddress(JOptionPane.showInputDialog("What is your address?")); //modified from BicycleDriver.java
      	temp2.setAge(Integer.parseInt(JOptionPane.showInputDialog("What is your age"))); //modified from BicycleDriver.java
      
      	
      	   // Get an instance of a Calendar, using the current time.

			Calendar cal = Calendar.getInstance();
		
	//input
		int	days= Integer.parseInt(JOptionPane.showInputDialog("How many days would you like to rent the scooter for? ")); //modified
		
                    //the output
                       	JOptionPane.showMessageDialog(null,"The customer details: " + temp2.toString()); //modified from BicycleDriver.java
                       JOptionPane.showMessageDialog(null,"The rental date is: "+cal.getTime());
                       cal.add(Calendar.DATE, days);                                  //added the amount of days the user wants to rent for //modified
                       JOptionPane.showMessageDialog(null,"The return date : "+cal.getTime());
  					JOptionPane.showMessageDialog(null,"The cost of the rental is: € " + days *30); //modified
  						
  	// below goten from MyJFrame3.java
  						     	 
         // get the content pane and set properties
        Container contentPane = getContentPane();
        
      	 // construct a button and make this Adds_Records listen for
        // and  handle button events
        rentButton = new JButton("Rent"); //modifed
        rentButton.setBounds(110,230,80,40);
	    rentButton.addActionListener(this);
        contentPane.add(rentButton); //modifed
  
 // next 2 lines goten from sample program MyJFrame3.java
  // get the content pane 
   Container cPane2 = getContentPane( );
        cPane2.setLayout(new FlowLayout());
  
  //create and place button on the frame
        rentButton = new JButton("Rent");
        cPane2.add(rentButton);

        //register this frame as an action listener of the button
        rentButton.addActionListener(this); //modifed
}

      //Displays a list of all scooters in a JTextArea
        
      public void displayScooters(){ //modifed
      	JTextArea area = new JTextArea();
      	if (count>0) {
      	  area.setText("Scooter List: \n\n"); //modifed
      	  for (int i = 0; i<count; i++) // loop over existing scooters, rather than array size
      	    area.append("scooter no: " + i + " " +scootersArray[i].toString()+"\n"); //modifed
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
      	   addScooter(); // branch to a separate method //modifed
      	}// else if
      	else if (e.getActionCommand() .equals ("Display")){
           displayScooters(); //modifed
      	}// else if
      	else if (e.getActionCommand() .equals ("New File")){
      		newSystem();
        }// else if
      	else if (e.getActionCommand() .equals ("Save")){
      	 // from BicycleFrame3.java
      	 try{
      	 	save();
      	 	showMessage("Data saved successfully");
      	 } // try
      	 catch (IOException f){
      	 	showMessage("Not able to save the file:\n"+
      	 	"Check the console printout for clues to why ");
      	 	f.printStackTrace();
      	 }// catch
      	}// else if

      	else if (e.getActionCommand() .equals ("Open")){
      	 open();
         displayScooters(); //modifed
      	}// else if
      	else if (e.getActionCommand() .equals ("Rent scooter")){ //modifed
      		rentScooter(); // branch to a separate method //modifed
      	}// else
      	else
      	  showMessage("I have no idea what you clicked");
      } // actionPerformed

        private void createFileMenu(){
         // create
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
      
       //modifed 
       private void createRentMenu(){
      	// create the menu
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