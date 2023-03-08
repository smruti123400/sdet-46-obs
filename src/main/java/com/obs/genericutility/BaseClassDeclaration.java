package com.obs.genericutility;

import org.openqa.selenium.WebDriver;

import com.wc.reportutility.ScreenshotUtility;

import banking.onlinebankingsystem.OnlineAccountOpeningForm;

public class BaseClassDeclaration {
	protected PropertyFileUtility propertyfileutility;
	protected ExcelUtility excelutilty;
	public     ScreenshotUtility screenshotutility;
	protected Webdriverutility webdriverutility;
	protected Waitutility waitutility;
	protected Verificationutility verification;
	protected OnlineAccountOpeningForm o;
	protected SelectUtility selectu;
	protected Javautility javautil;
	protected Action act;
	protected String browser;
	protected  String url;
	protected String username;
	protected String password;
	protected WebDriver driver;
}
