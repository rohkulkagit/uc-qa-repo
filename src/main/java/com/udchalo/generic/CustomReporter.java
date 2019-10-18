package com.udchalo.generic;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
/**
 * @Description :	custom reporter 
 * @Author 		:   udchalo QA Automation Developer
 * @since		  : 02-Aug-2019
 */
public class CustomReporter extends CustomReporterHelper implements ITestListener
{


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		new BaseTest().TCID_Status_Report("TEST PASSED");
		System.out.println("TEST PASSED");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		new BaseTest().TCID_Status_Report("TEST FAILED");
		System.out.println("TEST FAILED");

	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		new BaseTest().TCID_Status_Report("TEST SKIPPED");
		System.out.println("TEST SKIPPED");

		
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
