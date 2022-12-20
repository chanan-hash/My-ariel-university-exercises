package Exer9;

public class Dog extends Animal{

	private String type; 
	
	/** To understand how the super works Ctrl + mouse click on every super
	*/
	
	// Constructors
	// Default constructor
	public Dog() {
		super(); // turns to the default constructor
		this.setType("regular");	
	}
	
	public Dog(String type) {
		super("dog",2);      // Turns to one of Animal constructor
		this.type = type;
	}

	// constructor
	public Dog(Dog d) {
		super(d.getName(),d.getAge()); 	//super("n",3); --> turns to the first constructor
		this.type = d.type;
	}
	
	public Dog(String name, int age, String type) {
		// we can access "name" and "age, because it extends animal
		this.name = name;
		this.age = age;
		
		this.type = type;
	}
	
	
	// copy constructor
	public Dog(String type,Animal a) { // need to copy from Animal object
		// TODO check if animal is instance of Dog because then we cannot create this constructor	

		super(a); //super(a); --> turns to the copy constructor
		this.type = type;	
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Dog [type=" + type + "]";
	}
	
	@Override
	public void sleep() {
		System.out.println("I love to sleep");
	}
	@Override
	public void makeSound() {
		System.out.println("Whoof");
	}
	
	// Class function to create dog
	public static Dog createDog() {
		Dog dog = new Dog("name", 1,"regular");
		return dog;
	}
	
}
