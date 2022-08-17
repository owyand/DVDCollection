package dvdcollection.controller;

import java.util.ArrayList;

import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dto.DVD;
import dvdcollection.ui.DVDCollectionView;

public class DVDCollectionController {

	private DVDCollectionDao dao;
	private DVDCollectionView view;
	
	public DVDCollectionController(DVDCollectionView view, DVDCollectionDao dao) {
		this.dao = dao;
		this.view = view;
	}

	public void run() {
		// this is where everything is controlled from
		boolean menu = true;
		//1. loop a menu
		try {
			while (menu) {
				int choice = displayMenuAndGetChoice();
				
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
					//exit
					menu = false;
					break;
				default:
				}
				
			}
		} catch (NumberFormatException e) {
			
		}
		//2. switch statements
		//3. create methods for each user case

	}

	private void displayDVDInfo() {
		view.displayDVDInfoBanner();
		String title = view.getDVDTitle();
		view.displayDVDInfo(dao.displayDVDInfo(title));
		view.successfulBanner();
	}

	private void listDVDCollection() {
		view.listDVDCollectionBanner();
		ArrayList<DVD> DVDs = dao.getCollection();
		view.listDVDCollection(DVDs);
		view.successfulBanner();
	}

	private int displayMenuAndGetChoice() {
		return view.displayMenuAndGetChoice();
	}
	
	private void addDVD() {
		view.addDVDBanner();
		DVD newDVD = view.addDVD();
		dao.addDVD(newDVD.getTitle(), newDVD);
		view.successfulBanner();
	}
	
	private void removeDVD() {
		view.removeDVDBanner();
		String title = view.getDVDTitle();
		//DVD oldDVD = 
		dao.removeDVD(title);
		view.successfulBanner();
		//get name
		//search
		//if there delete
	}
	
	private void editDVD() {
		view.editDVDBanner();
		String title = view.getDVDTitle();
		boolean editMenu = true;
		try {
			while (editMenu) {
				int choice = displayEditMenuAndGetChoice();
				
				switch(choice) {
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
		}catch (NumberFormatException e){
			
		}
	}

	private void editUserNote(String title) {
		view.editUserNoteBanner();
		String newUserNote = view.getUserNote();
		//DVD theDVD = 
		dao.editUserNote(title, newUserNote);
		view.successfulBanner();
	}

	private void editMpaaRating(String title) {
		view.editMpaaRatingBanner();
		String newMpaaRating = view.getMpaaRating();
		//DVD theDVD = 
		dao.editMpaaRating(title, newMpaaRating);
		view.successfulBanner();
	}

	private void editDirectorName(String title) {
		view.editDirectorNameBanner();
		String newDirectorName = view.getDirectorName();
		//DVD theDVD = 
		dao.editDirectorName(title, newDirectorName);
		view.successfulBanner();
	}

	private void editStudio(String title) {
		view.editStudioBanner();
		String newStudio = view.getStudio();
		//DVD theDVD = 
		dao.editStudio(title, newStudio);
		view.successfulBanner();
	}

	private void editReleaseDate(String title) {
		view.editReleaseDateBanner();
		String newReleaseDate = view.getReleaseDate();
		//DVD theDVD = 
		dao.editReleaseDate(title, newReleaseDate);
		view.successfulBanner();
	}

	private void editTitle(String oldTitle) {
		view.editTitleBanner();
		String newTitle = view.getDVDTitle();
		//DVD theDVD = 
		dao.editDVDTitle(oldTitle, newTitle);
		view.successfulBanner();
	}

	private int displayEditMenuAndGetChoice() {
		
		return view.displayEditMenuAndGetChoice();
	}

}
