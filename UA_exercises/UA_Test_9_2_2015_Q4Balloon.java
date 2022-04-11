package A;
//First semester test 1, Q4

public class UA_Test_9_2_2015_Q4Balloon {

	// Q4.1
	private double x, y, z;  
	private double radius;	

	public UA_Test_9_2_2015_Q4Balloon(double x,double y,double z,double r) {
		this.x = x;
		this.y = y;
		this.z = z;
		radius = r;
	}

	/* The way Eclipse does it
	  public UA_Test_9_2_2015_Q4Balloon(double x, double y, double z, double radius) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.radius = radius;
	}
	*/
	
	public UA_Test_9_2_2015_Q4Balloon(UA_Test_9_2_2015_Q4Balloon other) {
		x = other.x;
		y = other.y;
		z = other.z;
		radius = other.radius;
	}
	// Q4.2
	public double volume(){
		return 4/3.0*Math.PI * Math.pow(radius, 3);
	}

	// Q4.3
	public boolean isIn(double x, double y, double z){
		double distance = 
				Math.pow(this.x-x, 2) +
				Math.pow(this.y-y, 2) +
				Math.pow(this.z-z, 2); 
		return (distance <= radius);
	}

	
	
	// Q4.4
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getRadius() {
		return this.radius;
	}
 
	@Override
	public String toString() {
		return "[r=" + radius + ",(" + x + "," + y + "," + z + ")]" ; 
	}
	

}
