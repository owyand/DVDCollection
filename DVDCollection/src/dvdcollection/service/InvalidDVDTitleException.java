package dvdcollection.service;

public class InvalidDVDTitleException extends Exception {

	/**
	 * added bc of serialization warning
	 */
	private static final long serialVersionUID = 1L;

	public InvalidDVDTitleException(String message) {
		super(message);
	}
	
	public InvalidDVDTitleException(String message, Throwable cause) {
		super(message, cause);
	}
}
