
/**This is an instantiable Customer class.
 @author Lil Reynolds
 @version 1.0 */ 
 	
import java.io.*;  // needed for saving arrays of scooter to file
/** minimal class which models a scooter */ 
public class Customer implements Serializable{  // needed for saving

	//attributes
	private String name;
	private int age;
	private String address; 
	
	/** acessor method to return the customer age
	 *@return the age of the customer */
	 public int getAge() { 
		return age;}
		
	/** acessor method to return the customer name
	 *@return the name of the customer */
	 public String getName() { 
		return name;}
		
	/** acessor method to return the customer address
	 *@return the address of the customer */
	 public String getAddress() {  //modified
		return address;
	}
	
		/** mutator method to set the customer age
	 *@param name the age of the customer */
	public void setAge (int age) {
				this.age = age;
	}
	
		/** mutator method to set the customer name
	 *@param name the name of the customer */
	public void setName( String name) {
				this.name = name;
	}
	
		/** mutator method to set the customer address
	 *@param name the address of the customer */
	public void setAddress(String address) { 
				this.address = address;
	}
	
		/** all argument constructor method
	 @param all the details of the customer */
	public Customer(String name, int age, String address) { 
				setName(name);
				setAge(age);
				setAddress(address); 
	}
	
		/** no argument constructor method
	 @param name the full name of the student */
	public Customer() {
				this("Not Given",0,"Not Given"); 
	}
	
	/** toString method to return the customers details
	 *@return the name ,address and age of the customer as a string */
	public String toString() {
				return (getName() + " " + getAddress() + " " + getAge() + " " ); 
	}
	
}//end class