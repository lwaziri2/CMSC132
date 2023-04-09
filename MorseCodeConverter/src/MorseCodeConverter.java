
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The purpose of this class is to be to convert from Morse to English and to
 * print the tree. This class has to two static methods with same name
 * convertToEnglish. The first method takes in a string with morse code and
 * converts it to English, while the other one takes in a file that needs to be
 * converted from morse code to english.
 * 
 * @author Lima Waziri
 * @see LinkedConverterTreeInterface<String>
 * @Date April 5, 2023
 */
public class MorseCodeConverter {
	private static MorseCodeTree tre = new MorseCodeTree();

	/**
	 * the toArrayList method in MorseCodeTree It should return the data in this
	 * order: "h s v i f u e l r a p w j b d x n c k y t z g q m o" Note the extra
	 * space between j and b - that is because there is an empty string that is the
	 * root, and in the LNR traversal, the root would come between the right most
	 * child of the left tree (j) and the left most child of the right tree (b).
	 * This is used for testing purposes to make sure the MorseCodeTree has been
	 * built properly
	 * 
	 * @return - the data in the tree in LNR order separated by a space
	 */
	public static String printTree() {
		String tree = "";
		ArrayList<String> treeList = tre.toArrayList();
		for (int i = 0; i < treeList.size(); i++) {
			tree += treeList.get(i) + " ";
		}
		return tree.trim();
	}

	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’. Example: code = ".... . .-.. .-.. --- / .--
	 * --- .-. .-.. -.." string returned = "Hello World"
	 * 
	 * @param code - the morse code
	 * @return - the English translation
	 */
	public static String convertToEnglish(String code) {
		String[] words = code.split(" / ");
		String text = "";
		for (int i = 0; i < words.length; i++) {
			String[] letters = words[i].split(" ");
			for (int w = 0; w < letters.length; w++) {
				if (tre.fetch(letters[w]) != null) {
					text += tre.fetch(letters[w]);
				}
			}
			text += " ";
		}
		return text.trim();
	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a
	 * space (‘ ‘). Each word is delimited by a ‘/’. Example: a file that contains
	 * ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." string returned = "Hello World"
	 * 
	 * @param codeFile - name of the file that contains Morse Code
	 * @return - the english translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		String code = "";
		try {
			Scanner scanFile = new Scanner(codeFile);
			code = scanFile.nextLine();
			scanFile.close();
			code = convertToEnglish(code);
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		System.out.print(code);
		return code;

	}
}
