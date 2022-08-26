package dvdcollection.dao;

import java.util.ArrayList;

import dvdcollection.dto.DVD;

public interface DVDCollectionDao {
	
	DVD addDVD(String DVDTitle, DVD newDVD) throws FilePersistenceException;
	
	DVD removeDVD(String DVDTitle) throws FilePersistenceException;

	DVD editDVDTitle(String oldTitle, String newTitle) throws FilePersistenceException;

	DVD editReleaseDate(String title, String newReleaseDate) throws FilePersistenceException;

	DVD editStudio(String title, String newStudio) throws FilePersistenceException;

	DVD editDirectorName(String title, String newDirectorName) throws FilePersistenceException;

	DVD editMpaaRating(String title, String newMpaaRating) throws FilePersistenceException;

	DVD editUserNote(String title, String newUserNote) throws FilePersistenceException;
	
	DVD getDVD(String title) throws FilePersistenceException;

	ArrayList<DVD> getCollection() throws FilePersistenceException;

}
