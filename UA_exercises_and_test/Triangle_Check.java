package UA_exercises_and_test;

public class Triangle_Check {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Triangle T1 = new Triangle(3,4);
		Triangle T2 = new Triangle(T1);
		
		T1.setA(3);
		T1.setB(4);
		System.out.println(T1.getA());
		System.out.println(T1.toString());
		T2.setA(4);
		T2.setB(7);
		System.out.println(T2.toString());
	
		double serface = T2.Area();
		int area = (int)(T1.Area());
		
		System.out.println(area);
		System.out.println(serface);
		
		System.out.println(T1.isEqual(T1, T2));
	}

}
