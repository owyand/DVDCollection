package dvdcollection.service;

public class InvalidDVDMpaaRatingException extends Exception {

	public InvalidDVDMpaaRatingException(String message) {
		super(message);
	}
	
	public InvalidDVDMpaaRatingException(String message, Throwable cause) {
		super(message, cause);
	}
}
