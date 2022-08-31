package dvdcollection.test;

import java.util.ArrayList;

import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dao.FilePersistenceException;
import dvdcollection.dto.DVD;

public class DVDCollectionDaoStubImpl implements DVDCollectionDao {
	
	public DVD onlyDVD;
	
	//constructors
	public DVDCollectionDaoStubImpl() {
		onlyDVD = new DVD("The Lion King");
		onlyDVD.setReleaseDate("1994");
		onlyDVD.setStudio("Disney");
		onlyDVD.setDirectorName("Roger Allers");
		onlyDVD.setMpaa("PG");
		onlyDVD.setUserReview("Good Movie");
	}
	
	public DVDCollectionDaoStubImpl(DVD testDVD) {
		this.onlyDVD = testDVD;
	}

	@Override
	public DVD addDVD(String DVDTitle, DVD newDVD) throws FilePersistenceException {
		if (DVDTitle.equals(onlyDVD.getTitle())) {
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD removeDVD(String DVDTitle) throws FilePersistenceException {
		if (DVDTitle.equals(onlyDVD.getTitle())) {
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD editDVDTitle(String oldTitle, String newTitle) throws FilePersistenceException {
		if (oldTitle.equals(onlyDVD.getTitle())) {
			DVD newDVD = new DVD(newTitle);
			newDVD.setDirectorName(onlyDVD.getDirectorName());
			newDVD.setMpaa(onlyDVD.getMpaa());
			newDVD.setReleaseDate(onlyDVD.getReleaseDate());
			newDVD.setStudio(onlyDVD.getStudio());
			newDVD.setUserReview(onlyDVD.getUserReview());
			
			return newDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD editReleaseDate(String title, String newReleaseDate) throws FilePersistenceException {
		if (title.equals(onlyDVD.getTitle())) {
			onlyDVD.setReleaseDate(newReleaseDate);
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD editStudio(String title, String newStudio) throws FilePersistenceException {
		if (title.equals(onlyDVD.getTitle())) {
			onlyDVD.setStudio(newStudio);
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD editDirectorName(String title, String newDirectorName) throws FilePersistenceException {
		if (title.equals(onlyDVD.getTitle())) {
			onlyDVD.setDirectorName(newDirectorName);
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD editMpaaRating(String title, String newMpaaRating) throws FilePersistenceException {
		if (title.equals(onlyDVD.getTitle())) {
			onlyDVD.setMpaa(newMpaaRating);
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD editUserNote(String title, String newUserNote) throws FilePersistenceException {
		if (title.equals(onlyDVD.getTitle())) {
			onlyDVD.setUserReview(newUserNote);
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public DVD getDVD(String title) throws FilePersistenceException {
		if (title.equals(onlyDVD.getTitle())) {
			return onlyDVD;
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<DVD> getCollection() throws FilePersistenceException {
		ArrayList<DVD> collection = new ArrayList<>();
		collection.add(onlyDVD);
		return collection;
	}
	


}
