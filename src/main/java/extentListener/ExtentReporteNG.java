package extentListener;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.ITestListener;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.IReporter;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.ITestContext;
import org.testng.ITestResult;




public class ExtentReporteNG implements ITestListener{

    ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReports.html");
    //public ExtentReports extent = new ExtentReports();
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub

    }
    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub

    }

}