package dvdcollection.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dvdcollection.dto.DVD;

public class DVDCollectionDaoFileImpl implements DVDCollectionDao {

	final Map<String, DVD> DVDCollection = new HashMap<>();
	public static final String COLLECTION = "collection.txt";
	public static final String DELIMITER = "::";

	public DVDCollectionDaoFileImpl() {

	}

	@Override
	public DVD addDVD(String DVDTitle, DVD newDVD) throws FileNotFoundException, IOException {
		loadCollection();
		DVD addedDVD = DVDCollection.put(DVDTitle, newDVD);
		writeCollection();
		return addedDVD;
	}

	@Override
	public DVD removeDVD(String DVDTitle) throws FileNotFoundException, IOException {
		loadCollection();
		DVD oldDVD = DVDCollection.remove(DVDTitle);
		writeCollection();
		return oldDVD;
	}

	@Override
	public DVD editDVDTitle(String oldTitle, String newTitle) throws FileNotFoundException, IOException{
		loadCollection();
		
		//get old and new DVD objects
		DVD oldDVD = DVDCollection.remove(oldTitle);
		DVD newDVD = new DVD(newTitle);
		//set the values from the old to the new
		newDVD.setDirectorName(oldDVD.getDirectorName());
		newDVD.setMpaa(oldDVD.getMpaa());
		newDVD.setReleaseDate(oldDVD.getReleaseDate());
		newDVD.setStudio(oldDVD.getStudio());
		newDVD.setUserReview(oldDVD.getUserReview());

		//add the new to the Collection
		DVDCollection.put(newDVD.getTitle(), newDVD);
		
		writeCollection();
		
		return newDVD;
	}

	@Override
	public DVD editReleaseDate(String title, String newReleaseDate) throws FileNotFoundException, IOException {
		DVD theDVD = getDVD(title);
		theDVD.setReleaseDate(newReleaseDate);
		return theDVD;
	}

	@Override
	public DVD editStudio(String title, String newStudio) throws FileNotFoundException, IOException{
		DVD theDVD = getDVD(title);
		theDVD.setStudio(newStudio);
		return theDVD;
	}

	@Override
	public DVD editDirectorName(String title, String newDirectorName) throws FileNotFoundException, IOException {
		DVD theDVD = getDVD(title);
		theDVD.setDirectorName(newDirectorName);
		return theDVD;
	}

	@Override
	public DVD editMpaaRating(String title, String newMpaaRating) throws FileNotFoundException, IOException {
		DVD theDVD = getDVD(title);
		theDVD.setMpaa(newMpaaRating);
		return theDVD;
	}

	@Override
	public DVD editUserNote(String title, String newUserNote) throws FileNotFoundException, IOException{
		DVD theDVD = getDVD(title);
		theDVD.setUserReview(newUserNote);
		return theDVD;
	}

	@Override
	public ArrayList<DVD> getCollection() throws FileNotFoundException, IOException {
		loadCollection();
		ArrayList<DVD> DVDCollectionArrayList = new ArrayList<DVD>(DVDCollection.values());
		writeCollection();
		return DVDCollectionArrayList;
	}

	public DVD getDVD(String title) throws FileNotFoundException, IOException {
		loadCollection();
		DVD theDVD = DVDCollection.get(title);
		writeCollection();
		return theDVD;
	}

	private void loadCollection() throws FileNotFoundException {
		Scanner fromCollection = null;

		try {
			// FileReader can cause FileNotFoundException so wrapped in try catch
			fromCollection = new Scanner(new BufferedReader(new FileReader(COLLECTION)));

			while (fromCollection.hasNextLine()) {
				String DVDLine = fromCollection.nextLine();
				DVD currentDVD = readDVDFromFile(DVDLine);

				// add to Map in memory
				DVDCollection.put(currentDVD.getTitle(), currentDVD);
			}
		} catch (FileNotFoundException e) {
			System.out.println("create nice error here");
			/*
			 * TODO: create a new class of error so that it throws nicely
			 */
		} finally {
			// closes the scanner if it opened
			if (fromCollection != null) {
				fromCollection.close();
			}
		}
	}

	private DVD readDVDFromFile(String DVDLine) {

		String[] DVDElements = DVDLine.split(DELIMITER);
		// read line into the attributes of a DVD Object
		DVD theDVD = new DVD(DVDElements[0]);
		theDVD.setReleaseDate(DVDElements[1]);
		theDVD.setStudio(DVDElements[2]);
		theDVD.setDirectorName(DVDElements[3]);
		theDVD.setMpaa(DVDElements[4]);
		theDVD.setUserReview(DVDElements[5]);

		return theDVD;
	}

	private void writeCollection() throws IOException {
		// write to the file
		PrintWriter toFile = null;

		// could throw an IOException because of FileWriter
		try {
			toFile = new PrintWriter(new FileWriter(COLLECTION));
			// create list of DVD Objects
			List<DVD> DVDList = new ArrayList<>(DVDCollection.values());

			String DVDLine;
			// iterate over DVDList and create a string representing that DVD Object to
			// write to file
			for (DVD currentDVD : DVDList) {
				//calls a private method to create this String
				DVDLine = createLine(currentDVD);
				//write to File (overwriting all existing)
				toFile.println(DVDLine);
			}

		} catch (IOException e) {
			System.out.println("ERROR: create a nice error here");
			/*TODO:
			 * create a nice error here that calls special class to throw nicely
			 */
		} finally {
			if (toFile != null) {
				toFile.close();
			}
		}
	}

	private String createLine(DVD currentDVD) {
		String DVDLine;

		// Title::ReleaseDate::Studio::DirectorsName::MPAARating::UserReview
		DVDLine = currentDVD.getTitle() + DELIMITER + currentDVD.getReleaseDate() + DELIMITER + currentDVD.getStudio()
				+ DELIMITER + currentDVD.getDirectorName() + DELIMITER + currentDVD.getMpaa() + DELIMITER
				+ currentDVD.getUserReview();
		return DVDLine;
	}

}
