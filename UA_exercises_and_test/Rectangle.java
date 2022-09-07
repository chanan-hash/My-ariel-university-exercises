package UA_exercises_and_test;
//UA_Ex12 classes
public class Rectangle {

	private double w; //rectangle width
	private double h; //rectangle height

	public Rectangle(double w, double h){ // constructor - when I'm creating the rectangle object, the values that I'm putting in will connect and go to the 
		this.w = w;
		this.h = h;
	}

	public Rectangle(Rectangle r) { // copy constructor - putting the values in the object itself
	w = r.w;
	h = r.h;
	}
	
	public double perimeter() {
		return (2*w) + (2*h); // we can save it before in a variable and then return it, but it is more space in the memory
	}
	public double area(){
		double s = 0;
		s = Math.pow(w, 2) + Math.pow(h, 2); // we can also do instead using & counting on another class --> s = (w*w) + (h*h); 
		return s;
	}

	@Override
	public String toString() {
		return "Rectangle [w=" + w + ", h=" + h + "]";
	}

	
	double getW() {
		return w;
	}

	void setW(double w) {
		this.w = w;
	}

	double getH() {
		return h;
	}

	void setH(double h) {
		this.h = h;
	}
	
	public int compare(Rectangle r1,Rectangle r2) {
		if (r1.area()>r2.area())
			return 1;
		else if (r1.area()<r2.area())
			return 2;
		else
			return 0;
	} 
	
}
