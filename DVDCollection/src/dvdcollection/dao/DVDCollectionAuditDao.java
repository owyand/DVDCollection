package dvdcollection.dao;

public interface DVDCollectionAuditDao {
	
	public void writeEntry(String entry) throws FilePersistenceException;

}
