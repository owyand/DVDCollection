package dvdcollection.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dvdcollection.dao.DVDCollectionAuditDao;
import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dao.FilePersistenceException;
import dvdcollection.dto.DVD;

public class DVDCollectionServiceLayerImpl implements DVDCollectionServiceLayer {
	
	private final List<String> MPAARATINGS = new ArrayList<String>(Arrays.asList("G", "PG", "PG13", "R", "NC17"));
	
	private final DVDCollectionAuditDao audit;
	private final DVDCollectionDao dao;
	
	
	//constructor to use data access objects
	public DVDCollectionServiceLayerImpl(DVDCollectionDao dao, DVDCollectionAuditDao audit) {
		this.dao = dao;
		this.audit = audit;
	}

	@Override
	public void addDVD(String title, DVD newDVD) throws FilePersistenceException, DVDAlreadyExistsException,
			InvalidDVDTitleException, InvalidDVDMpaaRatingException {
		
		//check if it already exists
		if (dao.getDVD(title) != null) {
			throw new DVDAlreadyExistsException("ERROR: Could not create a new DVD entry. " + title + " already exists in collection.");
		}
		
		checkTitle(newDVD.getTitle());
		
		checkMpaa(newDVD.getMpaa());
		
		dao.addDVD(title, newDVD);
		
		audit.writeEntry("DVD " + newDVD.getTitle() + " CREATED");
	}

	@Override
	public void removeDVD(String title) throws FilePersistenceException, DVDDoesNotExistException {
		
		//check if it doesnt exist
		if (dao.getDVD(title) == null) {
			throw new DVDDoesNotExistException("ERROR: DVD does not exist.");
		}
		
		dao.removeDVD(title);
		
		audit.writeEntry("DVD " + title + " REMOVED");
	}

	@Override
	public ArrayList<DVD> listDVDCollection() throws FilePersistenceException {
		return dao.getCollection();
	}

	@Override
	public void editDVDInfo(String title) throws FilePersistenceException, DVDDoesNotExistException {
		
		//check that it exists
		if (dao.getDVD(title) == null) {
			throw new DVDDoesNotExistException("ERROR: DVD does not exist.");
		}
		
		//no return value - program will continue back to the controller if Exception is not thrown
	}

	@Override
	public void editTitle(String oldTitle, String newTitle) throws FilePersistenceException, InvalidDVDTitleException {
		
		//check that newTitle is valid 
		checkTitle(newTitle);
		
		dao.editDVDTitle(oldTitle, newTitle);
		
		editAuditLog(newTitle);
	}

	@Override
	public void editReleaseDate(String title, String newReleaseDate) throws FilePersistenceException {
		dao.editReleaseDate(title, newReleaseDate);
		editAuditLog(title);
	}

	@Override
	public void editStudio(String title, String newStudio) throws FilePersistenceException {
		dao.editStudio(title, newStudio);
		editAuditLog(title);
	}

	@Override
	public void editDirectorName(String title, String newDirectorName) throws FilePersistenceException {
		dao.editDirectorName(title, newDirectorName);
		editAuditLog(title);
	}

	@Override
	public void editMpaaRating(String title, String newMpaaRating)
			throws FilePersistenceException, InvalidDVDMpaaRatingException {
		
		//check that the mpaa rating is valid
		checkMpaa(newMpaaRating);
		
		dao.editMpaaRating(title, newMpaaRating);
		editAuditLog(title);
	}

	@Override
	public void editUserReview(String title, String newUserReview) throws FilePersistenceException {
		dao.editUserNote(title, newUserReview);
		editAuditLog(title);
	}

	@Override
	public DVD displayDVDInfo(String title) throws FilePersistenceException, DVDDoesNotExistException {
		
		if (dao.getDVD(title) != null) {
			return dao.getDVD(title);
		} else {
			throw new DVDDoesNotExistException("ERROR: DVD does not exist.");
		}
	}
	
	private void checkTitle(String title) throws InvalidDVDTitleException {
		
		if (title.trim().length() == 0 || title == null) {
			throw new InvalidDVDTitleException("ERROR: Title cannot be empty");
		}
	}
	
	private void checkMpaa(String mpaaRating) throws InvalidDVDMpaaRatingException {
		boolean isValid = false;
		
		for (String rating : MPAARATINGS) {
			if (mpaaRating.equals(rating)) {
				isValid = true;
				break;
			}
		}
		
		if (!isValid) {
			throw new InvalidDVDMpaaRatingException("ERROR: the rating does is not an accepted rating");
		}
	}
	
	private void editAuditLog(String title) throws FilePersistenceException {
		audit.writeEntry("DVD " + title + " EDITED");
	}

}
