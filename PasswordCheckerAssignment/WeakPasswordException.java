/**
 * 
 */

/**
 * @author Lima Waziri
 * @date 01/31/2023
 */
public class WeakPasswordException extends Exception {
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}

}
