import javax.swing.*;

public class ScooterDriver{
	public static void main (String args[]){
	
	Scooter scooter = new Scooter();
	
	scooter.setName(JOptionPane.showInputDialog("Please enter a name"));
	scooter.setValue(Double.parseDouble(JOptionPane.showInputDialog("please enter the value")));
	scooter.setMake(JOptionPane.showInputDialog("please enter the make of the bike"));
	
	Scooter scooter2 = new Scooter();
	
	scooter2.setName(JOptionPane.showInputDialog("Please enter a name"));
	scooter2.setValue(Double.parseDouble(JOptionPane.showInputDialog("please enter the value" ))+ 10);
	scooter2.setMake(JOptionPane.showInputDialog("please enter the make of the scooter"));
	
	
		System.out.println("\n\n" + scooter.toString());	
		System.out.println("\n\n" + scooter2.toString());	
			
			
		
	}
}