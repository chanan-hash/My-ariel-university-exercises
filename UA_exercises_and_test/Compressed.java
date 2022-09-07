package UA_exercises_and_test;

public class Compressed {

	private int value;
	private int length;
	
	public Compressed (int value, int length) {
		this.value = value;
		this.length = length;
	}
	
	public Compressed (Compressed other) {
		other.value = value;
		other.length = length;
	}
	
	int getValue() {
		return value;
	}
	void setValue(int value) {
		this.value = value;
	}
	
	int getLength() {
		return length;
	}

	void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString () {
		return "(value= " + value + ", length= " + length + ")";
	}
}
