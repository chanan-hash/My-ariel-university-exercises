package UA_exercises_and_test;
// UA_Test 25/02/2018
public class Dice {

	private int p;
	private int []a;

	public Dice (int n) {
		this.p = n;
		this.a = new int[n];
		for (int i = 0; i<n; i++) {
			a[i] = (int)(Math.random()*2*n+1);
		}
	}
	public Dice(Dice other) {
		other.p = p;
		other.a = new int [other.a.length];
		for (int i = 0; i<other.a.length;i++) {
			a[i] = other.a[i];
		}
	}
	public int throwt() {
		int r = (int)Math.random()*this.p; // a random number of one of the sides
		return this.a[r]; // the number on the sides itself
	}
}
