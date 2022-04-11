package A;

public class UA_Test_9_2_2015_Q5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UA_Test_9_2_2015_Q5BalloonContainer bc = new UA_Test_9_2_2015_Q5BalloonContainer();
		
		UA_Test_9_2_2015_Q4Balloon b0 = new UA_Test_9_2_2015_Q4Balloon (2,1,2,3);
		UA_Test_9_2_2015_Q4Balloon b1 = new UA_Test_9_2_2015_Q4Balloon (2,2,3,1);
		UA_Test_9_2_2015_Q4Balloon b2 = new UA_Test_9_2_2015_Q4Balloon (2,1,5,8);
		UA_Test_9_2_2015_Q4Balloon b3 = new UA_Test_9_2_2015_Q4Balloon (2,7,1,10);
		UA_Test_9_2_2015_Q4Balloon b4 = new UA_Test_9_2_2015_Q4Balloon (2,5,6,1);
		UA_Test_9_2_2015_Q4Balloon b5 = new UA_Test_9_2_2015_Q4Balloon (2,2,8,4);
	
		bc.add(b0);
		bc.add(b1);
		bc.add(b2);
		bc.add(b3);
		bc.add(b4);
		bc.add(b5);
		System.out.println(bc);
//		bc.removeSmallest(b, b2);
	}

}
