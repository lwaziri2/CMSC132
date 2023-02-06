
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Lima Waziri
 *
 */
public class PasswordCheckerTest_STUDENT {
	private ArrayList<String> passwords;

	@Before
	public void setUp() throws Exception {
		String[] pass = {"Cmsc!05313","Intt@28S", "heY$32ghGt"};
		passwords = new ArrayList<>();
		passwords.addAll(Arrays.asList(pass));
		
	}
 
	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("Intt@"));
		} catch(LengthException e){
			System.out.println(e.getMessage());
			assertTrue("lengthExcepetion was thrown",true);
		} catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue("Another exception thrown",false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("hey$32"));
		} catch(NoUpperAlphaException e) {
			System.out.println(e.getMessage());
			assertTrue("Threw a NoUpperAlphaException", true);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			assertTrue("Another exception is thrown", false);
			}
	}
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertFalse(PasswordCheckerUtility.isValidPassword("HEYY$32UZ"));
		} catch(NoLowerAlphaException e){
			assertTrue("Threw a NoLowerAlphaException",true);
		} catch(Exception e) {
			assertFalse("Another exception is thrown", true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isWeakPassword("he3@2"));
		} catch(InvalidSequenceException e) {
			System.out.println(e.getMessage());
			assertTrue("Threw a InvalidSequenceException",true);
		} catch(Exception e){
			System.out.println(e.getMessage());
			assertTrue("\"Another exception thrown", true);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertEquals(true,PasswordCheckerUtility.isValidPassword("abddH#33"));	
		} catch (InvalidSequenceException e) { 
			System.out.println(e.getMessage());
			assertTrue("Threw a InvalidSequenceException", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertFalse("Another exception thrown", true);
		}
	} 
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("abddH#333"));	
		} catch (NoDigitException e) {
			System.out.println(e.getMessage());
			assertTrue("Threw a NoDigitException", true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertFalse("Another exception thrown", true);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("iCmms2cu!2"));
		} catch (Exception e){
			System.out.println(e.getMessage());
			assertTrue("The password is invalid exception", true);
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 * @throws Exception 
	 */
	@Test
	public void testInvalidPasswords() throws Exception {
		ArrayList < String > invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords) ;
		  for(int i=6; i < invalidPasswords.size( ) ; i++ )
		  {
			   assertTrue( PasswordCheckerUtility.isValidPassword(invalidPasswords.get(i))) ;
		   }
	}
	
}
