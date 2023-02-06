import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author Lima waziri
 * @date 01/28/23
 */
public class PasswordCheckerUtility {

	
	/*
	 * will check if password is at least 6 characters long
	 * @param password
	 * @return true if password is at least 6 characters long and false otherwise
	 */
	 public static boolean isValidLength(String password) throws LengthException{
		if((password.length() < 6)) {
			throw new LengthException();
		} 
		return true;
	}
	
	/*
	 * will check if password has 1 numeric character
	 * @param password
	 * @return true if password has 1 numeric character and false otherwise
	 */
	public static boolean hasDigits(String password) throws NoDigitException {
		int numericCount = 0;
		for(int i =0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				numericCount++; 
			} if(numericCount <= 0) {
				throw new NoDigitException();
			}
		}
		return true;
	}
	
	/*
	 * will check if there is at least 1 upper case
	 * @param password
	 * @return true if password has at least one 1 upper case letter and false otherwise
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))) {
				return true;

			}
		}
		throw new NoUpperAlphaException();
	}
	/*
	 * will check if there is at least 1 lower case 
	 * @param password
	 * @return true if password has at least one lower case password and false otherwise
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		for(int i = 0; i < password.length(); i++){
			if(Character.isLowerCase(password.charAt(i))) {
				return true;	
			} 
		}
		throw new NoLowerAlphaException();
	}
	
	/*
	 * will check to see if no more than 2 of the same characters occur in a sequence
	 * @param password
	 * @return true if there is no more than 2 of the same characters that occur in a sequence 
	 */
	 public static boolean twoCharacterInSequence(String password) throws InvalidSequenceException {
		int count = 0;
		int sameChar = 1;
		while(count < password.length()-1) {
			if(password.charAt(count) == password.charAt(count +1)) {
				sameChar += 1;
				if(sameChar > 2) {
					throw new InvalidSequenceException();
				}
				
			} else {
				sameChar =1;
			}
			count++;
		}
		return true;
	}
	
	/*
	 * Checks if password is weak
	 * @param string
	 * @return true if password is between 6 and 9 characters 
	 */
	public static boolean weakPassword(String password) {
		if((password.length() >= 6 && password.length() <=9 )) {
			return true;
		}
			return false;	
	
	}
	
	
	
	/*
	 * @param password
	 * check for a special character 
	 * @return true if there is at least one character and false otherwise
	 */
	 public static boolean specialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
		Matcher matcher = pattern.matcher(password);
			if(matcher.find()) {
				return true;
			}
			throw new NoSpecialCharacterException ();

	}
	
	
	
	/*
	 * Will check the validity of one password, will throw one or more exceptions
	 * @param String password
	 * @return true if password is valid, otherwise return false if password is invalid
	 * @throw WeakPasswordException LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException, WeakPasswordException {
		if(!isValidLength(password)) {
			throw new LengthException();
		} if(!hasDigits(password)) {
			throw new NoDigitException();
		} if(!hasUpperAlpha(password)) {
			throw new NoUpperAlphaException();
		} if(!hasLowerAlpha(password)) {
			throw new NoLowerAlphaException();
		} if(!twoCharacterInSequence(password)) {
			throw new InvalidSequenceException();
		} if(!specialChar(password)){
			throw new NoSpecialCharacterException();
		} if(!weakPassword(password)) {
			throw new WeakPasswordException();
		}
		return true;
	}
	
	/*
	 * @param String password
	 * will check if password is valid and the length is not between 6-9 characters
	 * @return false if password is valid and length of password id not between 6-9 characters
	 * @throw WeakPasswordException LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException {
		if(isValidPassword(password) && (weakPassword(password) == false)){
			return false;
		} else {
			throw new WeakPasswordException();
		}
	}
	
	/*
	 * @param : ArrayList of passwords
	 * @return ArrayList with status of any invalid passwords
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList <String> status = new ArrayList<String>();
		for(int i =0; i < passwords.size(); i++) {
			try {
				isValidPassword(passwords.get(i));	
			}
			catch(Exception e) {
				status.add(passwords.get(i) + " " + e.getMessage());
			}
					
		}
		return status;
	}
	/*
	 * @param password, passwordC
	 * throws an exception if password aren't the same
	 * @throws UnmatchedException
	 */
	
	public static boolean comparePasswords(String password, String passwordC) throws UnmatchedException {
		if(password.equals(passwordC)) {
			return true;
		}
		throw new UnmatchedException();
	}
	
	
	/*
	 * @password, passwordC
	 * @return true if passwords match and false otherwise
	 * 
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordC) {
		if(password.equals(passwordC)) {
			return true;
		}
		return false;
	}
	
}
	

	
	
	
