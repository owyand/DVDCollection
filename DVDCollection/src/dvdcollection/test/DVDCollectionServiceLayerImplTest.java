package dvdcollection.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dvdcollection.dao.DVDCollectionAuditDao;
import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dao.FilePersistenceException;
import dvdcollection.dto.DVD;
import dvdcollection.service.DVDAlreadyExistsException;
import dvdcollection.service.DVDCollectionServiceLayer;
import dvdcollection.service.DVDCollectionServiceLayerImpl;
import dvdcollection.service.DVDDoesNotExistException;
import dvdcollection.service.InvalidDVDMpaaRatingException;
import dvdcollection.service.InvalidDVDTitleException;

class DVDCollectionServiceLayerImplTest {
	
	private DVDCollectionServiceLayer service;
	
	public DVDCollectionServiceLayerImplTest() {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		DVDCollectionDao dao = new DVDCollectionDaoStubImpl();
		DVDCollectionAuditDao audit = new DVDCollectionAuditDaoStubImpl();
		
		service = new DVDCollectionServiceLayerImpl(dao, audit);
	}

	@Test
	void addDVDTest () throws FilePersistenceException {
		
		//arrange
		String DVDTitle = "The Lion King";
		DVD entry1 = new DVD(DVDTitle);
		entry1.setReleaseDate("1994");
		entry1.setStudio("Disney");
		entry1.setDirectorName("Roger Allers");
		entry1.setMpaa("PG");
		entry1.setUserReview("Good movie");
		
		String DVDTitle2 = "The Little Mermaid";
		DVD entry2 = new DVD(DVDTitle2);
		entry2.setReleaseDate("1989");
		entry2.setStudio("Disney");
		entry2.setDirectorName("John Musker");
		entry2.setMpaa("PG");
		entry2.setUserReview("Good movie");
		
		String DVDTitle3 = "";
		DVD entry3 = new DVD(DVDTitle3);
		entry3.setReleaseDate("1989");
		entry3.setStudio("Disney");
		entry3.setDirectorName("John Musker");
		entry3.setMpaa("PG");
		entry3.setUserReview("Good movie");
		
		String DVDTitle4 = "The Little Mermaid";
		DVD entry4 = new DVD(DVDTitle4);
		entry4.setReleaseDate("1989");
		entry4.setStudio("Disney");
		entry4.setDirectorName("John Musker");
		entry4.setMpaa("25");
		entry4.setUserReview("Good movie");
		
		//act and assert
		try {
			service.addDVD(DVDTitle2, entry2);
		} catch (InvalidDVDTitleException | InvalidDVDMpaaRatingException | DVDAlreadyExistsException e) {
			fail("valid entry - no exception should be thrown");
		}
		
		try {
			service.addDVD(DVDTitle, entry1);
			fail("DVDAlreadyExistsException should have been thrown");
		} catch (InvalidDVDTitleException | InvalidDVDMpaaRatingException e) {
			fail("wrong error was thrown");
		} catch (DVDAlreadyExistsException e) {
			return;
		}
		
		try {
			service.addDVD(DVDTitle3, entry3);
			fail("InvalidDVDTitleException should have been thrown");
		} catch (InvalidDVDMpaaRatingException | DVDAlreadyExistsException e) {
			fail("Wrong error was thrown");
		} catch (InvalidDVDTitleException e) {
			return;
		}
		
		try {
			service.addDVD(DVDTitle4, entry4);
			fail("InvalidDVDMpaaRatingException should have been thrown");
		} catch (InvalidDVDTitleException | DVDAlreadyExistsException e) {
			fail("Wrong error was thrown");
		} catch ( InvalidDVDMpaaRatingException e) {
			return;
		}
	}
	
	@Test
	void removeDVDTest() throws FilePersistenceException {
		//arrange
		String DVDTitle = "The Lion King";
		String DVDTitle2 = "Jaws";
		
		//act and assert
		try {
			service.removeDVD(DVDTitle);
		} catch (DVDDoesNotExistException e) {
			fail("the dvd does exist");
		}
		
		try {
			service.removeDVD(DVDTitle2);
			fail("This dvd does not exist");
		} catch (DVDDoesNotExistException e) {
			return;
		}
		
	}
	
	@Test
	public void listDVDsTest() throws FilePersistenceException {
		//arrange
		String DVDTitle = "The Lion King";
		DVD entry1 = new DVD(DVDTitle);
		entry1.setReleaseDate("1994");
		entry1.setStudio("Disney");
		entry1.setDirectorName("Roger Allers");
		entry1.setMpaa("PG");
		entry1.setUserReview("Good Movie");
		//act and assert
		
		ArrayList<DVD> collection = service.listDVDCollection();
		assertFalse(collection.isEmpty(), "the array should not be empty");
		assertEquals(1, collection.size(), "the size of the returned array should be 1");
		assertEquals(entry1, collection.get(0), "the array should contain the Lion King");
		
	}
	
	@Test
	public void displayInfoDVDTest() throws FilePersistenceException {
		//arrange
		String title = "The Lion King";
		String title2 = "Jaws";
		//act and assert
		
		try {
			DVD theReturned = service.displayDVDInfo(title);
			assertNotNull(theReturned, "the DVD exists and should not return null");
		}catch (DVDDoesNotExistException e) {
			fail("The DVD exists");
		}
		
		try {
			DVD theReturned = service.displayDVDInfo(title2);
			assertNull(theReturned, "the DVD does not exist and should be null");
		} catch (DVDDoesNotExistException e) {
			return;
		}
	}

}
