package dvdcollection.dao;

import java.util.ArrayList;

import dvdcollection.dto.DVD;

public interface DVDCollectionDao {
	
	DVD addDVD(String DVDTitle, DVD newDVD);
	
	DVD removeDVD(String DVDTitle);

	DVD editDVDTitle(String oldTitle, String newTitle);

	DVD editReleaseDate(String title, String newReleaseDate);

	DVD editStudio(String title, String newStudio);

	DVD editDirectorName(String title, String newDirectorName);

	DVD editMpaaRating(String title, String newMpaaRating);

	DVD editUserNote(String title, String newUserNote);

	ArrayList<DVD> getCollection();

	DVD displayDVDInfo(String title);

}
