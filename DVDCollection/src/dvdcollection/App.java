/**
 * 
 */
package dvdcollection;

import dvdcollection.controller.DVDCollectionController;
import dvdcollection.dao.DVDCollectionAuditDao;
import dvdcollection.dao.DVDCollectionAuditDaoFileImpl;
import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dao.DVDCollectionDaoFileImpl;
import dvdcollection.service.DVDCollectionServiceLayer;
import dvdcollection.service.DVDCollectionServiceLayerImpl;
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
		//implements the audit DAO for maintaining a log of usage
		DVDCollectionAuditDao AppAudit = new DVDCollectionAuditDaoFileImpl();
		//implements the service layer for business logic wired with DAO
		DVDCollectionServiceLayer AppService = new DVDCollectionServiceLayerImpl(AppDao, AppAudit);
		
		//implements the controller passing through the view and service layer
		DVDCollectionController controller = new DVDCollectionController(AppView, AppService);
		controller.run();

	}

}
