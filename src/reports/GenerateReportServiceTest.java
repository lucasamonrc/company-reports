package reports;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class GenerateReportServiceTest {
	@Test
	void testExecuteMedium() throws FileNotFoundException {
		GenerateReportService service = new GenerateReportService("Resources/TimeDataMedium.csv");
		service.execute();

		Scanner clientReport = new Scanner(new File("Reports/ClientWorkerReportMedium.txt"));
		Scanner clientSolution = new Scanner(new File("Resources/Solution/ClientWorkerReportMedium.txt"));
		Scanner employeeReport = new Scanner(new File("Reports/EmployeeTimeReportMedium.txt"));
		Scanner employeeSolution = new Scanner(new File("Resources/Solution/EmployeeTimeReportMedium.txt"));

		clientReport.useDelimiter("\\z");
		clientSolution.useDelimiter("\\z");
		employeeReport.useDelimiter("\\z");
		employeeSolution.useDelimiter("\\z");

		String clientWorkerReport = clientReport.next();
		String clientWorkerSolution = clientSolution.next();
		String employeeTimeReport = employeeReport.next();
		String employeeTimeSolution = employeeSolution.next();

		clientReport.close();
		clientSolution.close();
		employeeReport.close();
		employeeSolution.close();

		assertEquals(clientWorkerSolution, clientWorkerReport);
		assertEquals(employeeTimeSolution, employeeTimeReport);
	}

	@Test
	void testExecuteSmall() throws FileNotFoundException {
		GenerateReportService service = new GenerateReportService("Resources/TimeDataSmall.csv");
		service.execute();

		Scanner clientReport = new Scanner(new File("Reports/ClientWorkerReportSmall.txt"));
		Scanner clientSolution = new Scanner(new File("Resources/Solution/ClientWorkerReportSmall.txt"));
		Scanner employeeReport = new Scanner(new File("Reports/EmployeeTimeReportSmall.txt"));
		Scanner employeeSolution = new Scanner(new File("Resources/Solution/EmployeeTimeReportSmall.txt"));

		clientReport.useDelimiter("\\z");
		clientSolution.useDelimiter("\\z");
		employeeReport.useDelimiter("\\z");
		employeeSolution.useDelimiter("\\z");

		String clientWorkerReport = clientReport.next();
		String clientWorkerSolution = clientSolution.next();
		String employeeTimeReport = employeeReport.next();
		String employeeTimeSolution = employeeSolution.next();

		clientReport.close();
		clientSolution.close();
		employeeReport.close();
		employeeSolution.close();

		assertEquals(clientWorkerSolution, clientWorkerReport);
		assertEquals(employeeTimeSolution, employeeTimeReport);
	}

}
