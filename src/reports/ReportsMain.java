package reports;

/**
 * The entry point file of the project that created the services and executes
 * them to generate the reports.
 * 
 * @authors Lucas Castro  
 *  
 */
public class ReportsMain {

	public static void main(String[] args) {
		GenerateReportService[] services = { new GenerateReportService("Resources/TimeDataSmall.csv"),
				new GenerateReportService("Resources/TimeDataMedium.csv"),
				new GenerateReportService("Resources/TimeDataLarge.csv") };

		for (int i = 0; i < services.length; i++) {
			services[i].execute();
		}
	}
}
