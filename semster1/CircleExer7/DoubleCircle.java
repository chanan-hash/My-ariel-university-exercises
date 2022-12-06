package CircleExer7;

public class DoubleCircle {

	private Circle c1;
	private Circle c2;
	
		public DoubleCircle (Circle c1,Circle c2) {
			this.c1 = c1;
			this.c2 = c2;
		}
	public DoubleCircle(DoubleCircle other) {
		this.c1 = other.c1;
		this.c2 = other.c2;
	}
	
	public double bigR() {
		if(this.c1.getRadius() == this.c2.getRadius()) {
			return 1;
		}
		else if (c1.getRadius() > c2.getRadius()){
			return 1;
		}
		else {
			return 2;
		}
	}

	public boolean isColorEqual(){
		return this.c1.getColor() == this.c2.getColor();
	}
	
}
