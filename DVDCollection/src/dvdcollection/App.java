/**
 * 
 */
package dvdcollection;

import dvdcollection.controller.DVDCollectionController;
import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dao.DVDCollectionDaoFileImpl;
import dvdcollection.ui.DVDCollectionView;
import dvdcollection.ui.UserIO;
import dvdcollection.ui.UserIOConsoleImpl;

/**
 * @author Oliver Wyand
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//implements the User IO
		UserIO AppIo = new UserIOConsoleImpl();
		//implements the view and UI wired with User IO
		DVDCollectionView AppView = new DVDCollectionView(AppIo);
		//implements the DAO for CRUD usage
		DVDCollectionDao AppDao = new DVDCollectionDaoFileImpl();
		
		//implements the controller passing through the view and DAO
		DVDCollectionController controller = new DVDCollectionController(AppView, AppDao);
		controller.run();

	}

}
