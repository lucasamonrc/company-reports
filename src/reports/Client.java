package reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * This class represents a client entity of the Landscape company. <br>
 * It inherits all attributes and methods from the Person class, while having a
 * new employees attribute and a method to retrieve them.
 * 
 * @authors Lucas Castro
 */
public class Client extends Person {

	private HashSet<String> employees;

	/**
	 * Client class constructor.
	 * 
	 * @param name      - the client's name
	 * @param employees - a hash set with unique names of all employees that
	 *                  serviced this client
	 */
	public Client(String name, HashSet<String> employees) {
		super(name);
		this.employees = employees;
	}

	/**
	 * Returns the names of each employee as an array list of strings.
	 * 
	 * @return an array list of strings of each employee name
	 */
	public ArrayList<String> getEmployees() {
		ArrayList<String> employees = new ArrayList<String>();

		for (String employee : this.employees) {
			employees.add(employee);
		}
		Collections.sort(employees);

		return employees;
	}
}
