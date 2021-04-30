package com.qa.orangeHRM.report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.qa.orangeHRM.common.base;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	public WebDriver driver;
	Logger log = LogManager.getLogger(Report.class);
	public ExtentTest test;
	SoftAssert Assert = new SoftAssert();

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public void setTest(ExtentTest test) {
		this.test = test;
	}
	
	public void reportStatus(String status, String strmsg) {
		if(status.equalsIgnoreCase("PASS")) {
			test.log(LogStatus.PASS, strmsg);
			log.info(strmsg);
			Assert.assertTrue(true, strmsg);
			System.out.println("Passed: "+ strmsg);
		}else if(status.equalsIgnoreCase("FAIL")) {
			test.log(LogStatus.FAIL, strmsg);
			log.info(strmsg);
			Assert.assertTrue(false, strmsg);
			System.out.println("Failed: "+ strmsg);
		}
	}

}
