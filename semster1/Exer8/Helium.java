package Exer8;

public class Helium implements ZeppelinGas, molecule{

	// data
	
	private String Name;
	private int moleculeNumber;
	private double weight;
	
//	final String defu_name = "Helium";
//	final private int moleculeNumber_defu = 2;
//	final private double weight_defu = 4.002602;
//	final private double gasPressure = 25;
//	final private boolean isFlammable_defu = true;
//	

	//constructor
	public Helium() {
		final String defu_name = "Helium";
		 int moleculeNumber_defu = 2;
		 double weight_defu = 4.002602;
		 double gasPressure = 25;
		 boolean isFlammable_defu = true;
	}
	
	public Helium(String Name, int moleculeNumber,double weight) {
		this.Name = Name;
		this.moleculeNumber = moleculeNumber;
		this.weight = weight;	
	}
	// copy constructor
	public Helium(Helium h) {
		h.Name = this.Name;
		h.moleculeNumber = this.moleculeNumber;
		h.weight = this.weight;		
		
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
	public double gasPressure() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int moleculeNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double weight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFlammable() {
		// TODO Auto-generated method stub
		return false;
	}

}
