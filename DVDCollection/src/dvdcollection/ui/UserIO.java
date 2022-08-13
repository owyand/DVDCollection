package dvdcollection.ui;

public interface UserIO {

	// using the same UserIO interface from ClassRosterApp because i believe it is a
	// good starting point will add/delete what is necessary as i go

	void print(String msg);

	double readDouble(String prompt);
	double readDouble(String prompt, double min, double max);

	float readFloat(String prompt);
	float readFloat(String prompt, float min, float max);

	int readInt(String prompt);
	int readInt(String prompt, int min, int max);

	long readLong(String prompt);
	long readLong(String prompt, long min, long max);

	String readString(String prompt);

	public void close();

}
