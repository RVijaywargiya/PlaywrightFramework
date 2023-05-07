package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReporter {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void setupReports() {
        // Create a SparkReporter object and configure it
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/report.html");
        sparkReporter.config().setDocumentTitle("My Test Report");
        sparkReporter.config().setReportName("Test Results");

        // Create an ExtentReports object and attach the SparkReporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void startTest(String testName) {
        // Create a new ExtentTest object for the given test
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        test.info(message);
    }

    public static void logPass(String message) {
        test.pass(message);
    }

    public static void logFail(String message) {
        test.fail(message);
    }

    public static void endTest() {
        // End the current test and update the report
        extent.flush();
    }

}
