# Company Reports

## Information
**Author**: Lucas Castro

**Duration**: 12/08/2020 - 12/08/2020 (1 week)

## Project Instructions

**Application**

In order to run the application, open this project directory on *eclipse IDE*.

Once you opened the projects and there are no errors or pressing warnings, run  `ReportsMain.java` as a Java Application. The console should output:
```
Small.txt report generated successfully
Medium.txt report generated successfully
Large.txt report generated successfully
```

This indicates that the reports for each of the `TimeDataSize.csv` file was created and now can be found in the `Reports` folder.

**Tests**

In addition to the `ReportsMain.java`, there are several JUnit test files to be executed. Most importantly, the test `GenerateReportServiceTest.java` is a test that compares the generated report with the answer key provided by the instructor. To verify the reports are being created correctly, run that test.