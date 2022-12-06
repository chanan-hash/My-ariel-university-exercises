package CircleExer7;

public class Circle {

	// save as "Circle.java"
	   // private instance variable, not accessible from outside this class
	   private double radius;
	   private String color;
	   
	   // 1st constructor, which sets both radius and color to default
	   public Circle() {
	      this.radius = 1.0;
	      this.color = "red";
	   }
	   // 2nd constructor with given radius, but color default
	   public Circle(double r) {
	      this.radius = r;
	      this.color = "red";
	   }
	   
	   // constructor that can get both radius and color
	   public Circle (double r, String c) {
		   this.radius = r;
		   this.color = c;
	   }

	   
	   
	// A public method for retrieving the radius
	   public double getRadius() {
	     return radius; 
	   }
	   
	   // get color method
	   public String getColor() {
		   return this.color;
	   }

	   // A public method for computing the area of circle
	   public double getArea() {
	      return radius*radius*Math.PI;
	   }
	   
	   
	   public void setRadius(double r) {
		   this.radius = r;
	   }
	   
	   public void setColor(String s) {
		   this.color = s;
	   }
}




