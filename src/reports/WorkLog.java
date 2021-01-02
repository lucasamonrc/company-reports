package reports;

/**
 * This class represents an data record of the TimeDate resource files. <br>
 * All of its attributes represent a column of csv file.
 * 
 * @authors Lucas Castro  
 *  
 */
public class WorkLog implements Comparable<WorkLog> {
	private String employeeName;
	private String info;
	private String service;
	private String clientName;
	private String startTime;
	private String endTime;
	private String startDate;
	private String endDate;

	/**
	 * The WorkLog class constructor
	 * 
	 * @param employeeName - the name of the employee
	 * @param info         - the time of the activity performed
	 * @param service      - a short description of the activity
	 * @param clientName   - the client serviced
	 * @param startTime    - the start time as "HH:mm AM"
	 * @param endTime      - the end time as "HH:mm PM"
	 * @param startDate    - the start date as "MM/dd/yyyy"
	 * @param endDate      - the end date as "MM/dd/yyyy"
	 */
	public WorkLog(String employeeName, String info, String service, String clientName, String startTime,
			String endTime, String startDate, String endDate) {
		this.employeeName = employeeName;
		this.info = info;
		this.service = service;
		this.clientName = clientName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/**
	 * @return the employee's name
	 */
	public String getEmployeeName() {
		return this.employeeName;
	}

	/**
	 * @return the client's name
	 */
	public String getClientName() {
		return this.clientName;
	}

	/**
	 * @return the info string
	 */
	public String getInfo() {
		return this.info;
	}

	/**
	 * @return the service activity description
	 */
	public String getService() {
		return this.service;
	}

	/**
	 * This function converts both start date and and date into the ISO datetime
	 * format
	 * 
	 * @return a ISO string of the start datetime
	 */
	public String getStartDatetime() {
		return DatetimeUtils.toISOString(this.startDate, this.startTime);
	}

	/**
	 * This function converts both end date and end time into the ISO datetime
	 * format
	 * 
	 * @return a ISO string of the end datetime
	 */
	public String getEndDatetime() {
		return DatetimeUtils.toISOString(this.endDate, this.endTime);

	}

	/**
	 * This function calculates the time difference in miliseconds between the start
	 * and the end time of the activity
	 * 
	 * @return the start and end time difference in miliseconds
	 */
	public long getTimeDifference() {
		return DatetimeUtils.timeDifferenceInMili(this.getStartDatetime(), this.getEndDatetime());
	}

	/**
	 * This function overrides the Comparable.compareTo(T o) method, to allow the
	 * WorkLog object to be sorted by the employeeName attribute
	 * 
	 * @param other - The other person that will be compared
	 * @return 1 is it is greater, 0 if it is equal, -1 if it is lesser
	 */
	@Override
	public int compareTo(WorkLog other) {
		return this.employeeName.compareTo(other.getEmployeeName());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Log for: " + this.employeeName;
	}

}
