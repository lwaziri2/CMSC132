import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * The CourseDBManager allows the user to read the courses from a file or to
 * enter the data by hand and use Alert to print out the database elements. The
 * input is then read from the file and is added to the data structure
 * (CourseDBStructure) using the add method.
 * 
 * The CourseDBManager class implements the CourseDBManagerInterface which
 * provide functionalities to manage the CourseDBStructure. The CourseDBManager
 * can add courses to the structure, retrieve a course based on the CRN and
 * display all the courses in the data structure as well.
 * <p>
 * 
 * This class has one default constructor that initializes new CourseDBStructure
 * object
 * </p>
 * <p>
 * 
 * 
 * @see CourseDBManagerInterface
 * @see CourseDBStructure
 * @see CourseDBElement
 * @author Lima Waziri
 * @date 03/25/2023
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	CourseDBStructure structure;
	CourseDBElement tem;

	/**
	 * This constructor initializes new CourseDBStructure object with the maximum
	 * capacity of 100
	 */
	public CourseDBManager() {
		structure = new CourseDBStructure(100);
	}

	/**
	 * Adds a course (CourseDBElement) with the given information to
	 * CourseDBStructure.
	 * 
	 * @param id         course id
	 * @param crn        course crn
	 * @param credits    number of credits
	 * @param roomNum    course room number
	 * @param instructor name of the instructor
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		tem = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(tem);

	}

	/**
	 * finds CourseDBElement based on the crn key
	 * 
	 * @param crn course crn (key)
	 * @return a CourseDBElement object
	 * 
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			tem = structure.get(crn);
		} catch (IOException e) {
			tem = null;
		}
		return tem;
	}

	/**
	 * Reads the information of courses from a test file and adds them to the
	 * CourseDBStructure data structure
	 * 
	 * @param input input file
	 * @throws FileNotFoundException if file does not exists
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(input)) {
			while (scanner.hasNext()) {
				String courseID = scanner.next();
				int crn = (int) Integer.valueOf(scanner.next());
				int credits = (int) Integer.valueOf(scanner.next());
				String roomNum = scanner.next();
				String instructor = scanner.nextLine();
				add(courseID, crn, credits, roomNum, instructor);
			}
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}

	/**
	 * @return an array list of string representation of each course in the data
	 *         structure separated by a new line. Refer to the following example:
	 *         Course:CMSC500 CRN:39999 Credits:4 Instructor:Nobody InParticular
	 *         Room:SC100 Course:CMSC600 CRN:4000 Credits:4 Instructor:Somebody
	 *         Room:SC200
	 */
	@Override
	public ArrayList<String> showAll() {
		return structure.showAll();
	}

}
