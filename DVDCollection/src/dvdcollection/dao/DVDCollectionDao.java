package dvdcollection.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dvdcollection.dto.DVD;

public interface DVDCollectionDao {
	
	DVD addDVD(String DVDTitle, DVD newDVD) throws FileNotFoundException, IOException;
	
	DVD removeDVD(String DVDTitle) throws FileNotFoundException, IOException;

	DVD editDVDTitle(String oldTitle, String newTitle) throws FileNotFoundException, IOException;

	DVD editReleaseDate(String title, String newReleaseDate) throws FileNotFoundException, IOException;

	DVD editStudio(String title, String newStudio) throws FileNotFoundException, IOException;

	DVD editDirectorName(String title, String newDirectorName) throws FileNotFoundException, IOException;

	DVD editMpaaRating(String title, String newMpaaRating) throws FileNotFoundException, IOException;

	DVD editUserNote(String title, String newUserNote) throws FileNotFoundException, IOException;
	
	DVD getDVD(String title) throws FileNotFoundException, IOException;

	ArrayList<DVD> getCollection() throws FileNotFoundException, IOException;

}
