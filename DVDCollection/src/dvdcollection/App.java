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

		UserIO AppIo = new UserIOConsoleImpl();
		DVDCollectionView AppView = new DVDCollectionView(AppIo);
		DVDCollectionDao AppDao = new DVDCollectionDaoFileImpl();
		
		DVDCollectionController controller = new DVDCollectionController(AppView, AppDao);
		controller.run();

	}

}
