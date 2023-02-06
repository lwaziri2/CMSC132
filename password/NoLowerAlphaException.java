/**
 * 
 */

/**
 * @author Lima Waziri
 * @date 01/31/2023
 */
public class NoLowerAlphaException extends Exception{
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");

	}

}
