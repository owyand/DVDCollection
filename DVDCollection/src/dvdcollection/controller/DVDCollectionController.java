package dvdcollection.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dto.DVD;
import dvdcollection.ui.DVDCollectionView;

public class DVDCollectionController {

	private DVDCollectionDao dao;
	private DVDCollectionView view;

	// constructor which sets the specified implementations of DAO and View passed
	// through the App
	public DVDCollectionController(DVDCollectionView view, DVDCollectionDao dao) {
		this.dao = dao;
		this.view = view;
	}

	// 'main' controller method where everything is orchestrated
	public void run() {
		boolean menu = true;
		// loop a menu can return Exceptions so it is enclosed in a try-catch
		try {
			while (menu) {
				// private call to View could throw a NumberFormatException
				int choice = displayMenuAndGetChoice();

				// menu method calls
				switch (choice) {
				case 1:
					addDVD();
					break;
				case 2:
					removeDVD();
					break;
				case 3:
					editDVD();
					break;
				case 4:
					listDVDCollection();
					break;
				case 5:
					displayDVDInfo();
					break;
				case 6:
					// exit
					menu = false;
					break;
				default:
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: create a nice error here to throw nicely");
			/*
			 * TODO: create a class Exception
			 */
		} catch (IOException e) {
			System.out.println("ERROR: create a nice error here to throw nicely");
			/*
			 * TODO: create a class Exception
			 */
		}

	}

	private int displayMenuAndGetChoice() {
		// pass through
		return view.displayMenuAndGetChoice();
	}

	private void addDVD() throws FileNotFoundException, IOException {
		view.addDVDBanner();
		DVD newDVD = view.addDVD();
		dao.addDVD(newDVD.getTitle(), newDVD);
		view.successfulBanner();
	}

	private void removeDVD() throws FileNotFoundException, IOException {
		view.removeDVDBanner();
		String title = view.getDVDTitle();
		DVD oldDVD = dao.removeDVD(title);
		view.successfulBanner();
		System.out.println(oldDVD.getTitle() + "was removed");
		/*
		 * TODO: refactor to display through view
		 */
	}

	private void displayDVDInfo() throws FileNotFoundException, IOException {
		view.displayDVDInfoBanner();
		String title = view.getDVDTitle();
		view.displayDVDInfo(dao.getDVD(title));
		view.successfulBanner();
		// no need to display anything else besides successful banner
	}

	private void listDVDCollection() throws FileNotFoundException, IOException {
		view.listDVDCollectionBanner();
		ArrayList<DVD> DVDs = dao.getCollection();
		view.listDVDCollection(DVDs);
		view.successfulBanner();
	}

	private void editDVD() {
		view.editDVDBanner();
		String title = view.getDVDTitle();
		boolean editMenu = true;
		try {
			while (editMenu) {
				int choice = displayEditMenuAndGetChoice();

				switch (choice) {
				case 1:
					editTitle(title);
					break;
				case 2:
					editReleaseDate(title);
					break;
				case 3:
					editStudio(title);
					break;
				case 4:
					editDirectorName(title);
					break;
				case 5:
					editMpaaRating(title);
					break;
				case 6:
					editUserNote(title);
					break;
				case 7:
					editMenu = false;
				default:
				}

			}
			// i think catching here would be correct so that we can loop this sub-menu even
			// though they are the same exceptions
		} catch (NumberFormatException e) {
			System.out.println("ERROR");
			/*
			 * TODO: create an exception class so it throws nicely
			 */
		} catch (IOException e) {
			System.out.println("ERROR");
			/*
			 * TODO: create an exception class so it throws nicely
			 */
		}
	}

	private void editUserNote(String title) throws FileNotFoundException, IOException {
		view.editUserNoteBanner();
		String newUserNote = view.getUserNote();
		DVD theDVD = dao.editUserNote(title, newUserNote);
		view.successfulBanner();
		System.out.println(theDVD.getTitle() + "'s User Note was changed to " + theDVD.getUserReview());
		/*TODO:
		 * refactor so that this uses the view
		 */
	}

	private void editMpaaRating(String title) throws FileNotFoundException, IOException {
		view.editMpaaRatingBanner();
		String newMpaaRating = view.getMpaaRating();
		DVD theDVD = dao.editMpaaRating(title, newMpaaRating);
		view.successfulBanner();
		System.out.println(theDVD.getTitle() + "'s MPAA Rating was changed to " + theDVD.getMpaa());
		/*TODO:
		 * refactor so that this uses the view
		 */
	}

	private void editDirectorName(String title) throws FileNotFoundException, IOException{
		view.editDirectorNameBanner();
		String newDirectorName = view.getDirectorName();
		DVD theDVD = dao.editDirectorName(title, newDirectorName);
		view.successfulBanner();
		System.out.println(theDVD.getTitle() + "'s Director was changed to " + theDVD.getDirectorName());
		/*TODO:
		 * refactor so that this uses the view
		 */
	}

	private void editStudio(String title) throws FileNotFoundException, IOException{
		view.editStudioBanner();
		String newStudio = view.getStudio();
		DVD theDVD = dao.editStudio(title, newStudio);
		view.successfulBanner();
		System.out.println(theDVD.getTitle() + "'s Studio was changed to " + theDVD.getStudio());
		/*TODO:
		 * refactor so that this uses the view
		 */
	}

	private void editReleaseDate(String title) throws FileNotFoundException, IOException {
		view.editReleaseDateBanner();
		String newReleaseDate = view.getReleaseDate();
		DVD theDVD = dao.editReleaseDate(title, newReleaseDate);
		view.successfulBanner();
		System.out.println(theDVD.getTitle() + "'s Release Date was changed to " + theDVD.getReleaseDate());
		/*TODO:
		 * refactor so that this uses the view
		 */
	}

	private void editTitle(String oldTitle) throws FileNotFoundException, IOException {
		view.editTitleBanner();
		String newTitle = view.getDVDTitle();
		DVD theDVD = dao.editDVDTitle(oldTitle, newTitle);
		view.successfulBanner();
		System.out.println(oldTitle + " was changed to " + theDVD.getTitle());
		/*
		 * TODO: refactor to use the view
		 */
	}

	private int displayEditMenuAndGetChoice() {

		return view.displayEditMenuAndGetChoice();
	}

}
