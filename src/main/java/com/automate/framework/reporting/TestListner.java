package com.automate.framework.reporting;

import org.apache.log4j.PropertyConfigurator;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import com.automate.framework.iConstants.FrameworkConstant;

public class TestListner implements ITestListener {

	static Logger logger = Logger.getLogger(TestListner.class);

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		logger.info("Test execution ended " + arg0.getEndDate() + "All test methods " + arg0.getAllTestMethods()
				+ "getPassedTests " + arg0.getPassedTests() + "getFailedTests name" + arg0.getFailedTests());

	}

	public void onStart(ITestContext arg0) {
		PropertyConfigurator.configure(FrameworkConstant.LOG4J_PATH);
		logger.info("Test execution date " + arg0.getStartDate() + "All test methods "
				+ arg0.getAllTestMethods().toString() + "suite name" + arg0.getName());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult arg0) {
		logger.info("onTestFailure >>Test name is " + arg0.getName() + "Result " + arg0.isSuccess() + "Error "
				+ arg0.getThrowable().getStackTrace().toString() + "error message " + arg0.getThrowable().getMessage());

	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("onTestSkipped >> Test name is " + arg0.getName() + "Result " + arg0.isSuccess()
				+ "error message " + arg0.getThrowable().getMessage());

	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult arg0) {
		logger.info("onTestSuccess >>>> Test name is " + arg0.getName() + "Result " + arg0.isSuccess() + "Started  "
				+ arg0.getStartMillis() + "End " + arg0.getEndMillis());

	}

}
