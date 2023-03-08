package com.wc.reportutility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportUtility{
	private ExtentTest test;
	private ExtentReports report;
	
	public ReportUtility(String path,String title,String reportname,String browserName) {
		ExtentSparkReporter spark=new ExtentSparkReporter(path);
		spark.config().setDocumentTitle(title); 
		spark.config().setReportName(reportname);
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser",browserName);
		report.setSystemInfo("OS", System.getProperty("os.name"));
		
	
	}
	
	public void createTest(String testName) {
		test=report.createTest(testName);
	}
	public void pass(String message) {
		test.pass(message);
		System.out.println(message);
	}
	public void skip(String message) {
		test.skip(message);
		System.out.println(message);
	}
	public void info(String message) {
		test.info(message);
		System.out.println(message);
	}
	public void saveReport() {
		report.flush();
	}
	
	public void fail(String message) {
		test.fail(message);
		System.out.println(message);
	}
	public void fail(Throwable t) {
		test.fail(t);
	}
	public void addAuthor(String...author) {
		test.assignAuthor(author);
	}
	public void addcategory(String...category) {
		test.assignCategory(category);
	}
	
	public void attachScreenshot(String base64,String title) {
		test.addScreenCaptureFromBase64String(base64, title);
	}
	
	
	


}

