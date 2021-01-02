package reports;

/**
 * This class represents an employee entity of the Landscape company. <br>
 * It inherits all attributes and methods from the Person class, while having a
 * new timeWorked attribute and a method to retrieve it.
 * 
 * @authors Lucas Castro  
 *  
 */
public class Employee extends Person {

	private String timeWorked;

	/**
	 * Employee class constructor.
	 * 
	 * @param name       - the employee's name
	 * @param timeWorked - a string representing the employee total time worked in
	 *                   hours and minutes
	 */
	public Employee(String name, String timeWorked) {
		super(name);
		this.timeWorked = timeWorked;
	}

	/**
	 * Returns the total time worked of the employee as a string in the format
	 * "HH:mm".
	 * 
	 * @return a time string in the format "HH:mm"
	 */
	public String getTimeWorked() {
		return this.timeWorked;
	}

}
