package dvdcollection.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dvdcollection.dao.DVDCollectionDao;
import dvdcollection.dao.DVDCollectionDaoFileImpl;
import dvdcollection.dto.DVD;

class DVDCollectionDaoFileImplTest {
	
	DVDCollectionDao testDao;
	
	public DVDCollectionDaoFileImplTest() {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		String testFile = "testfile.txt";
		new FileWriter(testFile);
		testDao = new DVDCollectionDaoFileImpl(testFile);
		
	}

	@Test
	public void addDVDgetDVDTest() throws Exception{
		//arrange
		String DVDTitle = "The Lion King";
		DVD entry1 = new DVD(DVDTitle);
		entry1.setReleaseDate("1994");
		entry1.setStudio("Disney");
		entry1.setDirectorName("Roger Allers");
		entry1.setMpaa("PG");
		entry1.setUserReview("Good movie");
		
		//act
		testDao.addDVD(DVDTitle, entry1);
		DVD gotDVD = testDao.getDVD(DVDTitle);
		
		//assert
		assertEquals(entry1.getTitle(), gotDVD.getTitle(), "Checking title");
		assertEquals(entry1.getReleaseDate(), gotDVD.getReleaseDate(), "Checking release date");
		assertEquals(entry1.getStudio(), gotDVD.getStudio(), "Checking studio");
		assertEquals(entry1.getDirectorName(), gotDVD.getDirectorName(), "Checking director name");
		assertEquals(entry1.getMpaa(), gotDVD.getMpaa(), "Checking MPAA");
		assertEquals(entry1.getUserReview(), gotDVD.getUserReview(), "Checking user review");
	}
	
	@Test
	public void removeDVDTest() throws Exception {
		//arrange
		String DVDTitle = "The Lion King";
		DVD entry1 = new DVD(DVDTitle);
		entry1.setReleaseDate("1994");
		entry1.setStudio("Disney");
		entry1.setDirectorName("Roger Allers");
		entry1.setMpaa("PG");
		entry1.setUserReview("Good movie");
		testDao.addDVD(DVDTitle, entry1);
		
		String DVDTitle2 = "The Little Mermaid";
		DVD entry2 = new DVD(DVDTitle2);
		entry2.setReleaseDate("1989");
		entry2.setStudio("Disney");
		entry2.setDirectorName("John Musker");
		entry2.setMpaa("PG");
		entry2.setUserReview("Good movie");
		testDao.addDVD(DVDTitle2, entry2);
		
		//act and assert
		DVD removed1 = testDao.removeDVD(DVDTitle);
		assertNotNull(testDao.getCollection());
		assertEquals(1, testDao.getCollection().size(), "number of entries should be 1");
		assertEquals(entry1, removed1, "removed DVD should be Lion King");
		assertFalse(testDao.getCollection().contains(entry1), "the DVD left should not be the Lion King");
		assertTrue(testDao.getCollection().contains(entry2), "the DVD left should be th eLittle Mermaid");
		
		DVD removed2 = testDao.removeDVD(DVDTitle2);
		assertEquals(entry2, removed2, "removed DVD should be the Little Mermaid");
		assertTrue(testDao.getCollection().isEmpty());
				
		assertNull(testDao.removeDVD(DVDTitle));
		assertNull(testDao.removeDVD(DVDTitle2));
	}
	
	@Test
	public void editDVDAllMethodsTest() throws Exception {
		//arrange
		String title = "The Lion King";
		String releaseDate = "1994";
		String studio = "Disney";
		String directorName = "Roger Allers";
		String mpaa = "PG";
		String userReview = "Good movie";
		
		String title2 = "title";
		String releaseDate2 = "releaseDate";
		String studio2 = "studio";
		String directorName2 = "directorName";
		String mpaa2 = "mpaa";
		String userReview2 = "userReview";
		
		String DVDTitle = title;
		DVD entry1 = new DVD(DVDTitle);
		entry1.setReleaseDate(releaseDate);
		entry1.setStudio(studio);
		entry1.setDirectorName(directorName);
		entry1.setMpaa(mpaa);
		entry1.setUserReview(userReview);
		testDao.addDVD(DVDTitle, entry1);
		
		//act and assert
		////user note
		DVD edited = testDao.editUserNote(DVDTitle, userReview2);
		assertEquals(userReview2, edited.getUserReview(), "user review should have changed");
		////mpaa
		entry1 = testDao.editMpaaRating(DVDTitle, mpaa2);
		assertEquals(mpaa2, entry1.getMpaa(), "mpaa should have changed");
		////director name
		entry1 = testDao.editDirectorName(DVDTitle, directorName2);
		assertEquals(directorName2, entry1.getDirectorName(), "director name should have changed");
		////studio
		entry1 = testDao.editStudio(DVDTitle, studio2);
		assertEquals(studio2, entry1.getStudio(), "studio should have changed");
		////release date
		entry1 = testDao.editReleaseDate(DVDTitle, releaseDate2);
		assertEquals(releaseDate2, entry1.getReleaseDate(), "release date should have changed");
		////title
		entry1 = testDao.editDVDTitle(DVDTitle, title2);
		assertEquals(title2, entry1.getTitle(), "title should have been changed");
	}
	
	@Test
	public void getCollectionTest() throws Exception {
		//arrange
		String DVDTitle = "The Lion King";
		DVD entry1 = new DVD(DVDTitle);
		entry1.setReleaseDate("1994");
		entry1.setStudio("Disney");
		entry1.setDirectorName("Roger Allers");
		entry1.setMpaa("PG");
		entry1.setUserReview("Good movie");
		testDao.addDVD(DVDTitle, entry1);
		
		String DVDTitle2 = "The Little Mermaid";
		DVD entry2 = new DVD(DVDTitle2);
		entry2.setReleaseDate("1989");
		entry2.setStudio("Disney");
		entry2.setDirectorName("John Musker");
		entry2.setMpaa("PG");
		entry2.setUserReview("Good movie");
		testDao.addDVD(DVDTitle2, entry2);
		
		//act and assert
		List<DVD> collection = testDao.getCollection();
		assertFalse(collection.isEmpty(), "collection should return two object and not be empty");
		assertEquals(2, collection.size(), "collection should have exactly 2 entries");
		assertTrue(collection.contains(entry1), "the Lion King should be returned");
		assertTrue(collection.contains(entry2), "the Little Mermaid should be returned");
		
		testDao.removeDVD(DVDTitle);
		testDao.removeDVD(DVDTitle2);
		assertTrue(testDao.getCollection().isEmpty(), "after removing the objects the collection should be empty");
		
	}


}
