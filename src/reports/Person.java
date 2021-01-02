package reports;

/**
 * This superclass aggregates the common attributes and methods of the Client
 * and Employee entities of the Landscape company. <br>
 * 
 * @authors Lucas Castro  
 *  
 */
public abstract class Person implements Comparable<Person> {

	protected String name;

	/**
	 * Person class constructor
	 * 
	 * @param name - the person's name
	 */
	public Person(String name) {
		this.name = name;
	}

	/**
	 * @return the name attribute of the instance
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * This function overrides the Comparable.compareTo(T o) method, to allow the
	 * Person object to be sorted by the name attribute
	 * 
	 * @param other - The other person that will be compared
	 * @return 1 is it is greater, 0 if it is equal, -1 if it is lesser
	 */
	@Override
	public int compareTo(Person other) {
		return this.name.compareTo(other.getName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
