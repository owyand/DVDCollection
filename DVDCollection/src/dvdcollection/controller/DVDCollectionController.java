package dvdcollection.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dao.FilePersistenceException;
import dvdcollection.dto.DVD;
import dvdcollection.service.DVDDoesNotExistException;
import dvdcollection.service.DVDAlreadyExistsException;
import dvdcollection.service.DVDCollectionServiceLayer;
import dvdcollection.service.DVDCollectionServiceLayerImpl;
import dvdcollection.service.InvalidDVDMpaaRatingException;
import dvdcollection.service.InvalidDVDTitleException;
import dvdcollection.ui.DVDCollectionView;

public class DVDCollectionController {

	private DVDCollectionServiceLayer service;
	private DVDCollectionView view;

	// constructor which sets the specified implementations of DAO and View passed
	// through the App
	public DVDCollectionController(DVDCollectionView view, DVDCollectionServiceLayer service) {
		this.service = service;
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
					//idk if i need this
				}

			}
		} catch (FilePersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DVDAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DVDDoesNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private int displayMenuAndGetChoice() {
		// pass through
		return view.displayMenuAndGetChoice();
	}

	private void addDVD() throws FilePersistenceException, DVDAlreadyExistsException {

		boolean tryAgain = false;
		do {
			view.addDVDBanner();
			DVD newDVD = view.addDVD();

			// try catch here in case an invalid entry is given so that we can re-prompt
			// instead of throwing all the way to main menu
			try {
				service.addDVD(newDVD.getTitle(), newDVD);
				view.successfulBanner();
			} catch (InvalidDVDTitleException e) {
				/*
				 * TODO: make a catch call to view here
				 */
				tryAgain = true;
			} catch (InvalidDVDMpaaRatingException e) {
				/*
				 * TODO: make a catch call to view here
				 */
				tryAgain = true;
			}
		} while (tryAgain);
	}

	private void removeDVD() throws FilePersistenceException, DVDDoesNotExistException {
		view.removeDVDBanner();
		String title = view.getDVDTitle();
		service.removeDVD(title);
		view.addDVDSuccessfulBanner(title);

	}

	private void displayDVDInfo() throws FilePersistenceException, DVDDoesNotExistException {
		view.displayDVDInfoBanner();
		String title = view.getDVDTitle();
		view.displayDVDInfo(service.displayDVDInfo(title));
		view.successfulBanner();
	}

	private void listDVDCollection() throws FilePersistenceException {
		view.listDVDCollectionBanner();
		ArrayList<DVD> DVDs = service.listDVDCollection();
		view.listDVDCollection(DVDs);
		view.successfulBanner();
	}

	private void editDVD() throws FilePersistenceException{
		view.editDVDBanner();
		String title = view.getDVDTitle();

		boolean editMenu = true;
		
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

	}

	private void editUserNote(String title) throws FilePersistenceException {
		view.editUserNoteBanner();
		String newUserNote = view.getUserNote();
		service.editUserReview(title, newUserNote);
		view.editUserNoteSuccessfulBanner();
	}

	private void editMpaaRating(String title) throws FilePersistenceException{
		boolean tryAgain = false;
		
		//loop if input was invalid
		do {
			view.editMpaaRatingBanner();
			String newMpaaRating = view.getMpaaRating();
			try {
				service.editMpaaRating(title, newMpaaRating);
				view.editMpaaRatingSuccessfulBanner();
			} catch (InvalidDVDMpaaRatingException e){
				/*TODO:
				 * create a nice message here
				 */
			}
		} while (tryAgain);
	}

	private void editDirectorName(String title) throws FilePersistenceException {
		view.editDirectorNameBanner();
		String newDirectorName = view.getDirectorName();
		service.editDirectorName(title, newDirectorName);
		view.editDirectorNameSuccessfulBanner();
	}

	private void editStudio(String title) throws FilePersistenceException {
		view.editStudioBanner();
		String newStudio = view.getStudio();
		service.editStudio(title, newStudio);
		view.editStudioSuccessfulBanner();
	}

	private void editReleaseDate(String title) throws FilePersistenceException {
		view.editReleaseDateBanner();
		String newReleaseDate = view.getReleaseDate();
		service.editReleaseDate(title, newReleaseDate);
		view.editReleaseDateSuccessfulBanner();
	}

	private void editTitle(String oldTitle) throws FilePersistenceException {
		boolean tryAgain = false;
		
		//loop if input is invalid
		do {
			view.editTitleBanner();
			String newTitle = view.getDVDTitle();
			try {
				service.editTitle(oldTitle, newTitle);
				view.editTitleSuccessfulBanner(oldTitle, newTitle);
			} catch (InvalidDVDTitleException e) {
				/*TODO:
				 * create a nice message here error here
				 */
				tryAgain = true;
			}
		}while (tryAgain);

	}

	private int displayEditMenuAndGetChoice() {

		return view.displayEditMenuAndGetChoice();
	}

}
