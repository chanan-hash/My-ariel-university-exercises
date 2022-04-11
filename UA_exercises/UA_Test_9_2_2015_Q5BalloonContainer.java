package A;

public class UA_Test_9_2_2015_Q5BalloonContainer {

	private UA_Test_9_2_2015_Q4Balloon[] bArray; // in Q4 we've made a class that define a Balloon with all kind of qualities. here we want to make a container/ array of those Balloons 
	private int size;

	public UA_Test_9_2_2015_Q5BalloonContainer() {
		this.size = 3;
		this.bArray = new UA_Test_9_2_2015_Q4Balloon[this.size]; // the length of the array is the size. we could have also just write - new UA_Test_9_2_2015_Q4Balloon[3];
	}

	public void add(UA_Test_9_2_2015_Q4Balloon b) // The method is getting an object of the Balloon, like an int or a String
	{
		for (int i = 0; i<bArray.length; i++)
			if (bArray[i] == null) // if the argument in index 'i' is nothing so add a new one.
				bArray[i] = new UA_Test_9_2_2015_Q4Balloon(b);		
	}	

	private void resize(UA_Test_9_2_2015_Q5BalloonContainer b, int newSize){
		this.size = newSize;		
	}
	
	public void removeSmallest(UA_Test_9_2_2015_Q5BalloonContainer b, UA_Test_9_2_2015_Q4Balloon b2) {
		for (int i = 0; i<bArray.length; i++)
			if (b2.getRadius()< 1)
				bArray[i] = null;			
	}
	public int size (UA_Test_9_2_2015_Q5BalloonContainer b) {
		return this.size;
	}

}
