/**
 * This class respresents a course data base elements with a ID, CRN, number of
 * credits, room number, and insturctor name. This class implements the
 * Comparable interface for sorting elements by CRN
 * 
 * @see Comparable
 * @author Lima Waziri
 * @date 03/25/23
 */
public class CourseDBElement implements Comparable<CourseDBElement> {
	private String ID;
	private int CRN;
	private int credits;
	private String roomNum;
	private String instructorName;

	/**
	 * Default constructor for CourseDBElement and well set all variables to either
	 * 0 or null
	 * 
	 */
	public CourseDBElement() {
		this.ID = null;
		this.CRN = 0;
		this.credits = 0;
		this.roomNum = null;
		this.instructorName = null;

	}

	/**
	 * Second constructor for CourseDBElement
	 * 
	 * @param ID             the course ID
	 * @param CRN            the course CRN
	 * @param credits        the number of credits for course
	 * @param roomNum        the room number for the course
	 * @param instructorName the name of the insturctor who is teaching the course
	 */
	public CourseDBElement(String ID, int CRN, int credits, String roomNum, String instructorName) {
		this.ID = ID;
		this.CRN = CRN;
		this.credits = credits;
		this.roomNum = roomNum;
		this.instructorName = instructorName;
	}

	/**
	 * Compares the data of two CourseDBElements
	 * 
	 * @param element the element to compare to
	 * @return true of the elements have the same credits, ID, CRN, roomNum and
	 *         instructor, and will retrurn false otherwise
	 */
	public boolean compareData(CourseDBElement element) {
		return this.getCRN() == element.getCRN() && this.getRoomNum().equals(element.getRoomNum())
				&& this.getInstructor().equals(element.getInstructor()) && this.getID().equals(element.getID())
				&& this.getCredits() == element.getCredits();

	}

	/**
	 * Gets the CRN of the course
	 * 
	 * @return CRN
	 */
	public int getCRN() {
		return CRN;
	}

	/**
	 * Sets the CRN of the course
	 * 
	 * @param CRN the new CRN
	 */
	public void setCRN(int CRN) {
		this.CRN = CRN;

	}

	/**
	 * The strings representation of the course
	 * 
	 * @return a string containing the course ID, CRN, number of credits, instructor
	 *         name and room number
	 */
	public String toString() {
		return "Course:" + ID + " CRN:" + CRN + " Credits:" + credits + " Instructor:" + instructorName + " Room:"
				+ roomNum;
	}

	/**
	 * Gets the name of the instructor for the course
	 * 
	 * @return the instructor name
	 */
	public String getInstructor() {
		return instructorName;
	}

	/**
	 * Sets the name of the instructor for the course
	 * 
	 * @param instructorName the new instructor name
	 */
	public void setInstructor(String instructorName) {
		this.instructorName = instructorName;

	}

	/**
	 * Gets the ID of the course
	 * 
	 * @return ID the ID of the course
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Sets the ID of the course
	 * 
	 * @param ID the new ID of the course
	 */
	public void setID(String ID) {
		this.ID = ID;

	}

	/**
	 * Gets the credits of the course
	 * 
	 * @return credits the credits of the course
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * Sets the credits of the course
	 * 
	 * @param credits the new credits of the course
	 */
	public void setCredits(int credits) {
		this.credits = credits;
	}

	/**
	 * Gets the room number of the course
	 * 
	 * @return the room number of the course ID
	 */
	public String getRoomNum() {
		return roomNum;
	}

	/**
	 * Sets the room number of the course ID
	 * 
	 * @param roomNum the new room number
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;

	}

	/**
	 * Compares two CourseDBElement based on their CRN values
	 * 
	 * @param element the CourseDBElement to be compare
	 * @return integer value showing the results of the comparison
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return Integer.compare(element.getCRN(), this.getCRN());
	}

}
