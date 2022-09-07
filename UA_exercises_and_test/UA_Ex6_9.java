package UA_exercises_and_test;

public class UA_Ex6_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "hello";
		String str2 = "olelh";
		System.out.println(str.contains("h"));
		System.out.println(str.charAt(3));
		System.out.println(str.indexOf("e"));
				
		for(int i = 0; i<str.length();i++) {
			if(str.contains(str2.substring(i,i+1))) {
				System.out.println("true");					
			}	
			else {
				System.out.println("false");
				break;
				}
		}
		
	}

}
