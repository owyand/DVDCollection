package dvdcollection.dao;

public class FilePersistenceException extends Exception {

	/**
	 * added bc of serialization warning
	 */
	private static final long serialVersionUID = 1L;

	public FilePersistenceException(String message) {
		super(message);
	}
	
	public FilePersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
}
