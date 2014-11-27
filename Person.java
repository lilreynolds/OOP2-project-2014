
public class Person {
	private String name;
	private int age;
	private char gender;
	
	public int getAge() { return age;}
	public char getGender() { return gender;}
	public String getName() { return name;}
	
	public void setAge (int age) {
				this.age = age;
	}
	
	public void setName( String name) {
				this.name = name;
	}
	
	public void setGender(char gender) {
				this.gender = gender;
	}
	
	
	public Person(String name, int age, char gender) {
				setName(name);
				setAge(age);
				setGender(gender);
	}
	
	
	public Person() {
				this("Not Given",0,'U');
	}
	
	
	public String toString() {
				return getName() + " " + getAge() + " " + getGender();
	}
}