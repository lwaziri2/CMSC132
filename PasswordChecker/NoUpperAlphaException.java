/**
 * 
 */

/**
 * @author Lima Waziri
 * @date 01/31/2023
 */
public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");

	}

}
