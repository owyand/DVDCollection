/**
 * 
 */
package dvdcollection.service;

/**
 * @author Oliver Wyand
 *
 */
public class DVDDoesNotExistException extends Exception {

	/**
	 * added bc of serialization warning
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public DVDDoesNotExistException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DVDDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
