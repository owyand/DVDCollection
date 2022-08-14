package dvdcollection.controller;

import dvdcollection.dao.DVDCollectionDao;
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
					System.out.println("Not yet supported");
					break;
				case 2:
					System.out.println("Not yet supported");
					break;
				case 3:
					System.out.println("Not yet supported");
					break;
				case 4:
					System.out.println("Not yet supported");
					break;
				case 5:
					System.out.println("Not yet supported");
					break;
				case 6:
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

	private int displayMenuAndGetChoice() {
		return view.displayMenuAndGetChoice();
	}

}
