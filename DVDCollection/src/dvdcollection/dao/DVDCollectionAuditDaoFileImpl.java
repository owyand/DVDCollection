package dvdcollection.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class DVDCollectionAuditDaoFileImpl implements DVDCollectionAuditDao {

	public static final String AUDIT_FILE = "audit.txt";
	
	@Override
	public void writeEntry(String entry) throws FilePersistenceException {
		
		//declare a PrintWriter
		PrintWriter out = null;
		
		try {
			//two argument constructor with boolean mean to append not overwrite like in the DVDCollection DAO
			out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
			LocalDateTime timestamp = LocalDateTime.now();
			out.println(timestamp + " : " + entry);
		} catch (IOException e) {
			throw new FilePersistenceException("ERROR: Could not make an audit entry.", e);
		}finally {
			if (out != null) {
				out.close();
			}
		}

	}

}
