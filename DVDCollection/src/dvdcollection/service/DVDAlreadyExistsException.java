package dvdcollection.service;

public class DVDAlreadyExistsException extends Exception {

	public DVDAlreadyExistsException(String message) {
		super(message);
	}
	
	public DVDAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
