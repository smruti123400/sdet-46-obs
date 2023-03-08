package com.wc.reportutility;

import org.testng.IClassListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mysql.cj.conf.PropertyKey;
import com.obs.genericutility.BaseClass;
import com.obs.genericutility.PropertyFileUtility;
import com.obs.genericutilityenum.Propertyfile;

import freemarker.template.Configuration;

public class Listner implements ISuiteListener, ITestListener,IClassListener{
	private ReportUtility report;
	@Override
	public void onBeforeClass(ITestClass testClass) {
		System.out.println("onBeforeClass");
	}

	@Override
	public void onAfterClass(ITestClass testClass) {
		System.out.println("onAfterClass");

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		report.createTest(result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		report.pass(result.getMethod().getMethodName()+" is pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//	Object c=result.getMethod().getInstance();
		//	Configuration.class.cast(c).screenshotUtility.getScreenshot(null, null);
		//	
		//		Configuration.class.cast(result.getMethod().getInstance()).screenshotUtility
		//		.getScreenshot(result.getMethod().getRealClass().getSimpleName(),
		//				Configuration.class.cast(result.getMethod().getInstance()).javaUtility);
		//		System.out.println("onTestFailure");
		report.fail(result.getMethod().getMethodName()+" is fail");
		report.fail(result.getThrowable());
		String path=BaseClass.class.cast(result.getMethod().getInstance()).screenshotutility.getScreenshot();
		report.attachScreenshot(path, result.getMethod().getMethodName()); 

	}


	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
		report.fail(result.getMethod().getMethodName()+" is skip");
		report.fail(result.getThrowable());
		String path=BaseClass.class.cast(result.getMethod().getInstance()).screenshotutility.getScreenshot();
		report.attachScreenshot(path, result.getMethod().getMethodName()); 
	}


	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("onTestFailedWithTimeout");

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("onStartTest");
		PropertyFileUtility p=new PropertyFileUtility();
		report=new ReportUtility(p.getPropertyData(Propertyfile.REPORTFILEPATH),p.getPropertyData(Propertyfile.REPORTTITLE),p.getPropertyData(Propertyfile.REPORTNAME), p.getPropertyData(Propertyfile.browser));

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinishTest");
		report.saveReport();
	}


	@Override
	public void onStart(ISuite suite) {
		System.out.println("onStartSuite");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("onFinishSuite");
	}


}


