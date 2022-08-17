package dvdcollection.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import dvdcollection.dto.DVD;

public class DVDCollectionDaoFileImpl implements DVDCollectionDao {

	final Map<String, DVD> DVDCollection = new HashMap<>();
	
	public DVDCollectionDaoFileImpl() {

	}

	@Override
	public DVD addDVD(String DVDTitle, DVD newDVD) {
		DVD addedDVD = DVDCollection.put(DVDTitle, newDVD);
		return addedDVD;
	}

	@Override
	public DVD removeDVD(String DVDTitle) {
		DVD oldDVD = null;
		Set<String> keys = DVDCollection.keySet();
		for (String key : keys) {
			if (!key.equals(DVDTitle)) {
				break;
			} else {
				oldDVD = DVDCollection.remove(DVDTitle);
			}
		}
		return oldDVD;
	}

	@Override
	public DVD editDVDTitle(String oldTitle, String newTitle) {
		
		DVD oldDVD = DVDCollection.remove(oldTitle);
		DVD newDVD = new DVD(newTitle);
		newDVD.setDirectorName(oldDVD.getDirectorName());
		newDVD.setMpaa(oldDVD.getMpaa());
		newDVD.setReleaseDate(oldDVD.getReleaseDate());
		newDVD.setStudio(oldDVD.getStudio());
		newDVD.setUserReview(oldDVD.getUserReview());
		
		DVDCollection.put(newDVD.getTitle(), newDVD);
		return newDVD;
	}

	@Override
	public DVD editReleaseDate(String title, String newReleaseDate) {
		DVD theDVD = getDVD(title);
		theDVD.setReleaseDate(newReleaseDate);
		return theDVD;
	}

	@Override
	public DVD editStudio(String title, String newStudio) {
		DVD theDVD = getDVD(title);
		theDVD.setStudio(newStudio);
		return theDVD;
	}

	@Override
	public DVD editDirectorName(String title, String newDirectorName) {
		DVD theDVD = getDVD(title);
		theDVD.setDirectorName(newDirectorName);
		return theDVD;
	}

	@Override
	public DVD editMpaaRating(String title, String newMpaaRating) {
		DVD theDVD = getDVD(title);
		theDVD.setMpaa(newMpaaRating);
		return theDVD;
	}

	@Override
	public DVD editUserNote(String title, String newUserNote) {
		DVD theDVD = getDVD(title);
		theDVD.setUserReview(newUserNote);
		return theDVD;
	}

	@Override
	public ArrayList<DVD> getCollection() {
		
		return new ArrayList<DVD>(DVDCollection.values());
	}

	@Override
	public DVD displayDVDInfo(String title) {
		DVD theDVD = getDVD(title);
		return theDVD;
	}

	private DVD getDVD(String title) {
		DVD theDVD = DVDCollection.get(title);
		return theDVD;
	}


}
