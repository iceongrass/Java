public class Test {
	public static void main (String [] args) {
		Animal dog =  new Animal();
		
		((Dog)dog).bark();
	}
}

class Animal {
	String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String input) {
		name =  input;
	}
			
}

class Dog extends Animal {
	public void bark() {
		System.out.println("Wang!Wang!Wang!");
	}
}
