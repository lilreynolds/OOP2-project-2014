// Bicycle.java

import java.io.*;  // needed for saving arrays of scooter to file
/** minimal class which models a scooter */
public class Scooter implements Serializable{  // needed for saving
	
	private String owner;
	private double value;
	private String make;
	
	public  Scooter( String o, double v ){
		owner = o; //modifed
		make = " make is not known"; //modifed
		value = v;
	}
	
	public  Scooter( String o ){ //modifed
		owner = o; //modifed
		make = "make is not known"; //modifed
	}
	
	public  Scooter( ){
		owner = "unassigned"; 
		make = "make is not known"; //modifed
	}
	
	public void setOwner(String o){ //modifed
		owner = o; //modifed
	}
	
	public void setMake(String m){
		make = m;
	}
	
	public void setValue(double v){
		value = v;
	}
	
	public String getOwner(){
	  return owner;	
	}
	
	public String getMake(){
	  return make;	
	}
	
	public double getValue(){
	  return value;	
	}
	
	public String toString() {
		return owner + " " + make + " " + value;
	}
}
