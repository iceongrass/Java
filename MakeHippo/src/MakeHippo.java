abstract class Animal {
	private String name;
	
	public String getName () {
		return name;
	}
	
	public Animal (String theName) {
		name = theName;
	}
}

class Hippo extends Animal {

	public Hippo(String theName) {
		super(theName);
		// TODO Auto-generated constructor stub
	}
	
}

public class MakeHippo {
	public static void main (String [] args) {
		Hippo h = new Hippo("Hi");
		System.out.println(h.getName());
	}
}