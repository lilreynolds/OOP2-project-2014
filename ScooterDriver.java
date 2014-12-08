// from BicycleDriver.java 

import javax.swing.*;

public class ScooterDriver{
	public static void main (String args[]){
	
	Scooter scooter = new Scooter(); //modifed
	
	scooter.setOwner(JOptionPane.showInputDialog("Please enter a name"));
	scooter.setValue(Double.parseDouble(JOptionPane.showInputDialog("please enter the value")));
	scooter.setMake(JOptionPane.showInputDialog("please enter the make of the scooter"));
	
		System.out.println("\n\n" + scooter.toString());	
	
			
			
		
	}
}