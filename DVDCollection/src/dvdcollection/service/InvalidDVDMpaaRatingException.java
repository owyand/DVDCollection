package dvdcollection.service;

public class InvalidDVDMpaaRatingException extends Exception {

	/**
	 * added bc of serialization warning
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDVDMpaaRatingException(String message) {
		super(message);
	}
	
	public InvalidDVDMpaaRatingException(String message, Throwable cause) {
		super(message, cause);
	}
}
