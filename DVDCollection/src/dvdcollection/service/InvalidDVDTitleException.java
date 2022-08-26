package dvdcollection.service;

public class InvalidDVDTitleException extends Exception {

	public InvalidDVDTitleException(String message) {
		super(message);
	}
	
	public InvalidDVDTitleException(String message, Throwable cause) {
		super(message, cause);
	}
}
