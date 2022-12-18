package Exer8;

public class Hydrogen implements molecule {

	//data
	private String Name;
	private int moleculeNumber;
	private double weight;
	
	final String defu_name = "hydrogen";
	private int moleculeNumber_defu = 1;
	private double weight_defu = 1.00784;

	//constructor
	
	public Hydrogen(String Name, int moleculeNumber,double weight) {
		this.Name = Name;
		this.moleculeNumber = moleculeNumber;
		this.weight = weight;	
	}
	// copy constructor
	public Hydrogen(Hydrogen h) {
		h.Name = this.Name;
		h.moleculeNumber = this.moleculeNumber;
		h.weight = this.weight;		
		
	}
	
	// Defaults data for hydrogen
	public String getDefaultName() {
		return defu_name;
	}
	public int getDefaultNunber() {
		return moleculeNumber_defu;
	}
	public double getDefaultWeight() {
		return weight_defu;
	}
	
	
	public String getName() {
		return this.Name;
	}
	public int moleculeNumber() {
		return this.moleculeNumber;
	}
	
	public double weight() {
		return this.weight;
	}
	
	public void fullWeight() {
		System.out.println(weight() + "u");
	}

	public int getMoleculeNumber() {
		return moleculeNumber;
	}

	public void setMoleculeNumber(int moleculeNumber) {
		this.moleculeNumber = moleculeNumber;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setName(String name) {
		Name = name;
	}
	
	@Override
	public String toString() {
		return "hydrogen [Name=" + Name + ", moleculeNumber=" + moleculeNumber + ", weight=" + weight + ", defu_name="
				+ defu_name + ", moleculeNumber_defu=" + moleculeNumber_defu + ", weight_defu=" + weight_defu + "]";
	}
}
