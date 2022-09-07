package UA_exercises_and_test;

// UA Test 07/08/2018 q4

public class LocalTime {

	private String City;
	private int UTC;
	// private Clock time;

	public LocalTime (String City, int UTC) {
		this.City = City;
		if (UTC<=12 && UTC >= -12)
			this.UTC = UTC;
		else UTC = 0;
	}
	public LocalTime(LocalTime LT) {
		this.City = LT.City;
		this.UTC = LT.UTC;
	}

	void setCity (String City) {
		City = this.City;	
	}
	public String getCity() {
		return City;
	}
	/*public void setCity(String city) {
		City = city;
	}
	 */

	public void setUTC(int UTC) {
		this.UTC = UTC;
	}
	public int getUTC() {
		return UTC;
	}

	@Override
	public String toString() {
		return "LocalTime [City=" + City + ", UTC=" + UTC + "]";
	}

}
