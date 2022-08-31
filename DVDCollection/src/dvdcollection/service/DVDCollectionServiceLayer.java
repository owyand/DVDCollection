/**
 * 
 */
package dvdcollection.service;

import java.util.ArrayList;
import java.util.List;

import dvdcollection.dao.FilePersistenceException;

import dvdcollection.dto.DVD;

/**
 * @author Oliver Wyand
 *
 */
public interface DVDCollectionServiceLayer {
	
	//checks existence
	//title empty/whitespace
	//MPAA rating is legal
	//runs the audit log
	void addDVD(String title, DVD newDVD)throws FilePersistenceException, DVDAlreadyExistsException, InvalidDVDTitleException, InvalidDVDMpaaRatingException;
	 
	//checks against existence
	//runs the audit log
	void removeDVD(String title)throws FilePersistenceException, DVDDoesNotExistException;
	 
	//pass through
	ArrayList<DVD> listDVDCollection() throws FilePersistenceException;
	 
	//checks that it exists
	//runs the audit log
	void editDVDInfo(String title)throws FilePersistenceException, DVDDoesNotExistException;
	 
	//sub menu that is just pass-through except title and mpaa
	void editTitle(String OldTitle, String newTitle)throws FilePersistenceException, InvalidDVDTitleException;
	
	void editReleaseDate(String title, String newReleaseDate)throws FilePersistenceException;

	void editStudio(String title, String newStudio)throws FilePersistenceException;
	
	void editDirectorName(String title, String newDirectorName)throws FilePersistenceException;
	
	void editMpaaRating(String title, String newMpaaRating) throws FilePersistenceException, InvalidDVDMpaaRatingException;
	
	void editUserReview(String title, String newUserReview)throws FilePersistenceException;
	
	//simply gets the DVD object
	//checks against existence
	DVD displayDVDInfo(String title)throws FilePersistenceException, DVDDoesNotExistException;

	List<String> getMpaaRatings();
}
