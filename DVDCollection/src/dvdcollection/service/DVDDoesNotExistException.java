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
