package dvdcollection.ui;

public class DVDCollectionView {

	// set the interface to private and use a constructor that will determine the
	// type of implementation being used in the program (e.g. fileImpl)
	private UserIO io;

	public DVDCollectionView(UserIO io) {
		this.io = io;
	}

	public int displayMenuAndGetChoice() {
		// 1. print menu
		io.print("*Menu*");
		io.print("1. add DVD");
		io.print("2. remove DVD");
		io.print("3. edit DVD information");
		io.print("4. list DVD collection");
		io.print("5. display DVD information");
		io.print("6. Exit");
		
		// 2. ask for input
		// 3. read input
		// 4. return to the caller
		return io.readInt("Enter your choice: ", 1, 6);
	}
	
	/*
	 * TODO: create banners and anything that is displayed to the console print
	 * using io interface which will user whatever impl is initialized
	 */

}
