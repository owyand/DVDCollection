package dvdcollection.service;

public class DVDAlreadyExistsException extends Exception {

	/**
	 * added bc of serialization warning
	 */
	private static final long serialVersionUID = 1L;

	public DVDAlreadyExistsException(String message) {
		super(message);
	}
	
	public DVDAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
