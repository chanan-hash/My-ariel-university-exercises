package Exer9;

public class Animal {

	static int counter = 0; // When we're creating another animals such as dog,etc.. 
							// So they going inside the constructor to the super() and there they referring
							// To Animal constructor and updating the counter to ++

	// So only the son class will have the permission for that
	protected String name;
	protected int age;

	// Constructor
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
		counter++;
	}

	// Copy constructor
	public Animal(Animal a) {
		// the current object getting from the given object
		this.name = a.name;
		this.age = a.age;
		counter++;
	}

	// default constructor
	public Animal() {
		this.setName("name");
		this.setAge(1);
		counter++;
	}		

	// get&set for name
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	// get&set for age
	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	// The functions
	protected void sleep() {
		System.out.println("I am sleeping");
	}
	protected void makeSound() {
		System.out.println("sound");
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", age=" + age + "]";
	}

}
