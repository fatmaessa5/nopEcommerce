package ReportManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class ReportManager {
    private static ExtentReports extent;



    public static ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("reports/extentReport.html");
            extent = new ExtentReports();

            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Your Name");
            extent.setSystemInfo("OS", "windows");
        }
        return extent;
    }


}
