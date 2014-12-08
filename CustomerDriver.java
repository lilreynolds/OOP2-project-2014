// from BicycleDriver.java 

import javax.swing.*;

public class CustomerDriver{
	public static void main (String args[]){
	
		Customer temp2 = new Customer();
		
      	temp2.setName(JOptionPane.showInputDialog("What is your name?")); //modified  
      	temp2.setAddress(JOptionPane.showInputDialog("What is your address?")); //modified  
      	temp2.setAge(Integer.parseInt(JOptionPane.showInputDialog("What is your age"))); //modified 
      	
			System.out.println("\n\n" + temp2.toString());	
	}
}