package dvdcollection.ui;

import java.util.ArrayList;
import java.util.List;

import dvdcollection.dto.DVD;

public class DVDCollectionView {

	// set the interface to private and use a constructor that will determine the
	// type of implementation being used in the program (e.g. fileImpl)
	private UserIO io;

	public DVDCollectionView(UserIO io) {
		this.io = io;
	}

	public int displayMenuAndGetChoice() {
		// print menu using the IO
		io.print("*Menu*");
		io.print("1. add DVD");
		io.print("2. remove DVD");
		io.print("3. edit DVD information");
		io.print("4. list DVD collection");
		io.print("5. display DVD information");
		io.print("6. Exit");

		// call to User IO to parse and make sense of the user input, returns a number
		// between 1 and 6
		return io.readInt("Enter your choice: ", 1, 6);
	}

	public void addDVDBanner() {
		io.print("=== ADD DVD ===");
	}

	public DVD addDVD() {
		String title = io.readString("Enter the DVD title: ");

		DVD createdDVD = new DVD(title);

		String releaseDate = io.readString("Enter the DVD release Date: ");
		createdDVD.setReleaseDate(releaseDate);
		String studio = io.readString("Enter the DVD studio: ");
		createdDVD.setStudio(studio);
		String directorName = io.readString("Enter the DVD director's name: ");
		createdDVD.setDirectorName(directorName);
		// the user is told what is accepted before the addDVD method is called so that
		// the List of accepted MPAAs can be called and passed through
		String mpaaRating = io.readString("Enter the DVD MPAA rating: ");
		createdDVD.setMpaa(mpaaRating);
		String userReview = io.readString("Enter any personal note or review on the DVD: ");
		createdDVD.setUserReview(userReview);

		return createdDVD;
	}

	public void addDVDSuccessfulBanner(String title) {
		successfulBanner();
		io.print(title + " was successfully added to DVD Collection");
	}

	public void editUserNoteSuccessfulBanner() {
		successfulBanner();
		io.print("User's Review was updated.");
	}

	public void editMpaaRatingSuccessfulBanner() {
		successfulBanner();
		io.print("MPAA Rating was updated.");
	}

	public void editDirectorNameSuccessfulBanner() {
		successfulBanner();
		io.print("Director's name was updated.");
	}

	public void editStudioSuccessfulBanner() {
		successfulBanner();
		io.print("Studio was updated.");
	}

	public void editReleaseDateSuccessfulBanner() {
		successfulBanner();
		io.print("Release Date was updated.");
	}

	public void editTitleSuccessfulBanner(String oldTitle, String newTitle) {
		successfulBanner();
		io.print(oldTitle + " was updated to " + newTitle);
	}

	public void successfulBanner() {
		io.print("=== SUCCESSFUL ===");
	}

	public void removeDVDBanner() {
		io.print("=== REMOVE DVD ===");
	}

	public String getDVDTitle() {
		String title = io.readString("Enter the title of the DVD: ");
		return title;
	}

	public void editDVDBanner() {
		io.print("=== EDIT DVD ===");
	}

	public int displayEditMenuAndGetChoice() {
		// 1. print menu
		io.print("*Edit Menu*");
		io.print("1. DVD title");
		io.print("2. DVD release date");
		io.print("3. DVD studio");
		io.print("4. DVD director's name");
		io.print("5. DVD MPAA rating");
		io.print("6. DVD userNote");
		io.print("7. Exit");

		return io.readInt("Enter what you would like to edit: ", 1, 7);
	}

	public void editTitleBanner() {
		io.print("=== EDIT TITLE ===");
	}

	public void editReleaseDateBanner() {
		io.print("=== EDIT RELEASE DATE ===");
	}

	public String getReleaseDate() {
		return io.readString("Enter the release date: ");
	}

	public void editStudioBanner() {
		io.print("=== EDIT STUDIO ===");
	}

	public String getStudio() {
		return io.readString("Enter the studio: ");
	}

	public void editDirectorNameBanner() {
		io.print("=== EDIT DIRECTOR NAME ===");
	}

	public String getDirectorName() {
		return io.readString("Enter the director's name: ");
	}

	public void editMpaaRatingBanner() {
		io.print("=== EDIT MPAA RATING ===");
	}

	public String getMpaaRating() {
		return io.readString("Enter the MPAA rating: ");
	}

	public void editUserNoteBanner() {
		io.print("=== EDIT USER NOTE ===");
	}

	public String getUserNote() {
		return io.readString("Enter the user note: ");
	}

	public void listDVDCollectionBanner() {
		io.print("=== LIST DVD COLLECTION ===");
	}

	public void listDVDCollection(ArrayList<DVD> DVDs) {
		for (DVD dvd : DVDs) {
			io.print(dvd.getTitle());
		}
	}

	public void displayDVDInfoBanner() {
		io.print("=== DISPLAY DVD INFO ===");
	}

	public void displayDVDInfo(DVD theDVD) {

		io.print("Title: " + theDVD.getTitle());
		io.print("Release Date: " + theDVD.getReleaseDate());
		io.print("Studio :" + theDVD.getStudio());
		io.print("Director: " + theDVD.getDirectorName());
		io.print("MPAA Rating: " + theDVD.getMpaa());
		io.print("User Review: " + theDVD.getUserReview());
	}

	public void errorMessage(String msg) {
		io.print(msg);
	}

	public void displayMpaaRatings(List<String> ratings) {
		io.print("Accepted MPAA Ratings");
		for (String rating : ratings) {
			io.print(rating);
		}
		io.print("======");
	}

}
