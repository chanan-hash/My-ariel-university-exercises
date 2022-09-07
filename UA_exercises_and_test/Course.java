package UA_exercises_and_test;
// UA Test 18/07/2019

public class Course {

	private int number;
	private String name;
	private int points; 
	private int grade;

	public Course ( int number, String name, int points, int grade) { // we can initialize the object by giving the arguments
		this.number = number;
		this.name = name;
		this.points = points;
		this.grade = grade;
	}
	public Course (Course other) { //we can give a object itself an assign the values one to each other
		other.number = number;
		other.name = name;
		other.points = points;
		other.grade = grade;
		//   this(other.number, other.name, other.points);
	}

	int getNumber() {
		return number;
	}

	void setNumber(int number) {
		this.number = number;
	}

	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	String getName() {
		return name;
	}

	void setName (String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [number=" + number + ", name=" + name + ", points=" + points + ", grade=" + grade + "]";
	}
}
