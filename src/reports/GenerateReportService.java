package reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This is the service class responsible to generate each report. It is
 * architected in a way that once a new instance is created by passing a source
 * filepath, the entire service is ran through the execute method, which calls
 * the helper methods that perform the work.
 * 
 * @authors Lucas Castro  
 *  
 */
public class GenerateReportService {

	private String sizeSuffix; // this is used to determine the size of the report.

	private File dataFile; // the TimeDataSize.csv resource files

	private ArrayList<WorkLog> workLogs;
	private ArrayList<Employee> employees;
	private ArrayList<Client> clients;

	private HashSet<String> employeesNames;
	private HashSet<String> clientsNames;

	private HashMap<String, ArrayList<WorkLog>> employeesLogs;
	private HashMap<String, ArrayList<WorkLog>> clientsLogs;

	/**
	 * GenerateReportService class constructor
	 * 
	 * @param filePath - the string representing the filepath to the resource file
	 */
	public GenerateReportService(String filePath) {
		this.dataFile = new File(filePath);

		this.workLogs = new ArrayList<>();
		this.employees = new ArrayList<>();
		this.clients = new ArrayList<>();

		this.employeesNames = new HashSet<>();
		this.clientsNames = new HashSet<>();

		this.employeesLogs = new HashMap<>();
		this.clientsLogs = new HashMap<>();

		this.sizeSuffix = filePath.contains("Large") ? "Large.txt"
				: filePath.contains("Medium") ? "Medium.txt" : "Small.txt"; // This determines which type of report will
																			// be generated
	}

	/**
	 * This method executes the service by calling all other helper methods that
	 * manipulate and structure the data in order to generate the reports
	 */
	public void execute() {
		try {
			ArrayList<String> fileData = this.fileToStrings();

			this.mapWorkLogs(fileData);
			this.employeesToLogs();
			this.clientsToLogs();
			this.createEmployees();
			this.createClients();
			this.generateReports();

			System.out.println(this.sizeSuffix + " report generated successfully");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
	}

	/**
	 * Helper function that reads the resource file and converts it to an
	 * ArrayList<String> where each element represents a line of the file.
	 * 
	 * @return an ArrayList<String> of the lines of the file
	 * @throws FileNotFoundException
	 */
	private ArrayList<String> fileToStrings() throws FileNotFoundException {
		Scanner reader = new Scanner(this.dataFile);
		ArrayList<String> data = new ArrayList<>();

		String row = reader.nextLine(); // gets rid of the headers.

		while (reader.hasNextLine()) {
			row = reader.nextLine();
			data.add(row);
		}

		reader.close();

		return data;
	}

	/**
	 * This function received a the ArrayList<String> representation of the file,
	 * and then converts each line into a WorkLog object mapping them to the
	 * workLogs ArrayList<WorkLog>.
	 * 
	 * @param data - the ArrayList representation of the file contents.
	 */
	private void mapWorkLogs(ArrayList<String> data) {
		for (String row : data) {
			String[] record = row.split(",");

			String employeeName = record[0], info = record[1], service = record[2], clientName = record[3],
					startTime = record[4], endTime = record[5], startDate = record[6], endDate = record[7];

			WorkLog timeData = new WorkLog(employeeName, info, service, clientName, startTime, endTime, startDate,
					endDate);

			workLogs.add(timeData);
			this.employeesNames.add(timeData.getEmployeeName());
			if (!timeData.getClientName().equals(""))
				this.clientsNames.add(timeData.getClientName());
		}
	}

	/**
	 * This functions maps out all logs of each of the unique employees in the
	 * resource file to the employeesLogs HashMap.
	 */
	private void employeesToLogs() {
		for (String name : this.employeesNames) {
			ArrayList<WorkLog> employeeLogs = new ArrayList<>();

			for (WorkLog log : this.workLogs) {
				if (name.equals(log.getEmployeeName())) {
					employeeLogs.add(log);
				}
			}

			this.employeesLogs.put(name, employeeLogs);
		}
	}

	/**
	 * This functions maps out all logs of each of the unique clients in the
	 * resource file to the clientLogs HashMap.
	 */
	private void clientsToLogs() {
		for (String name : this.clientsNames) {
			ArrayList<WorkLog> clientLogs = new ArrayList<>();

			for (WorkLog log : this.workLogs) {
				if (name.equals(log.getClientName())) {
					clientLogs.add(log);
				}
			}

			this.clientsLogs.put(name, clientLogs);
		}
	}

	/**
	 * This function iterates over the entries of the employeesLogs HashMap to
	 * create the Employee objects. It also uses the DateTimeUtils utility class to
	 * calculate the total time worked for each employee.
	 */
	private void createEmployees() {
		for (String employee : this.employeesLogs.keySet()) {
			ArrayList<WorkLog> logs = this.employeesLogs.get(employee);
			long time = 0;

			for (WorkLog log : logs) {
				if (log.getInfo().equals("Clock In/Out"))
					time += log.getTimeDifference();

			}

			String timeWorked = DatetimeUtils.msToHoursAndMinutes(time);

			this.employees.add(new Employee(employee, timeWorked));
		}
		Collections.sort(this.employees);
	}

	/**
	 * This function iterates over the entries of the clientsLogs HashMap to create
	 * the Client objects. It also maps each client to an array of employee names.
	 */
	private void createClients() {
		for (String client : this.clientsLogs.keySet()) {
			ArrayList<WorkLog> logs = this.clientsLogs.get(client);
			HashSet<String> clientEmployees = new HashSet<>();

			for (WorkLog log : logs) {
				clientEmployees.add(log.getEmployeeName());
			}

			clients.add(new Client(client, clientEmployees));
		}
		Collections.sort(clients);
	}

	/**
	 * This function uses the employees and clients arrays to write the report
	 * files. A ClientWorkerReport is written as <br>
	 * "CLIENT: name --- Employees: [names] <br>
	 * An EmployeeTimeReport is written as "EMPLOYEE: name --- TIME: hh:mm"
	 * 
	 * @throws FileNotFoundException
	 */
	private void generateReports() throws FileNotFoundException {
		File clientReportFile = new File("Reports/ClientWorkerReport" + this.sizeSuffix);
		File timeReportFile = new File("Reports/EmployeeTimeReport" + this.sizeSuffix);

		PrintWriter clientReport = new PrintWriter(clientReportFile);
		PrintWriter timeReport = new PrintWriter(timeReportFile);

		for (Client client : this.clients) {
			clientReport.printf("CLIENT: %s --- EMPLOYEES: %s\r\n", client.getName(), client.getEmployees());
		}

		clientReport.flush();
		clientReport.close();

		for (Employee employee : this.employees) {
			timeReport.printf("EMPLOYEE: %s --- TIME: %s\r\n", employee.getName(), employee.getTimeWorked());
		}

		timeReport.flush();
		timeReport.close();
	}

}
