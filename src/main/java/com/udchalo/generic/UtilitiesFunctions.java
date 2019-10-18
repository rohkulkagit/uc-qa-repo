package com.udchalo.generic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @ScriptName : UtilitiesFunctions
 * @Description : This class contains UtilitiesFunctions function
 * @Author : udchalo QA Automation Developer
 */
public class UtilitiesFunctions {

	private  Pojo objPojo;
	

	public UtilitiesFunctions(Pojo pojo) {
		this.objPojo = pojo;
	}
	
	
	/**
	 * @Method : logReporter
	 * @Description : Reporter method
	 * @param :
	 *            Step - Step description, resultLog - result log pass/fail
	 *            (true/false), includeMobile - result for mobile(true/false)
	 * @author :udchalo QA Automation Developer
	 */
	@Step("Step Desc ---> " + "{0}")
	public  void logReporter(String step, boolean resultLog) {
		String strLog = step;
		this.addAssertTakeScreenShot(step, strLog, "", "", "", resultLog);
	}

	/**
	 * @Method : logReporter
	 * @Description : Reporter method
	 * @param :
	 *            Step - Step description, inputValue - Input value, resultLog -
	 *            result log pass/fail (true/false), includeMobile - result for
	 *            mobile(true/false)
	 * @author : udchalo QA Automation Developer
	 */
	@Step("Step Desc ---> " + "{0} - {1}")
	public  void logReporter(String step, String inputValue, boolean resultLog) {
		String strLog = step + "|| Input Value : " + inputValue;
		this.addAssertTakeScreenShot(step, strLog, inputValue, "", "", resultLog);
	}

	/**
	 * @Method : logReporter
	 * @Description : Reporter method
	 * @param :
	 *            Step - Step description, expectedValue - verification point
	 *            expected value, actualValue - verification point actual value,
	 *            resultLog - result log pass/fail (true/false), includeMobile -
	 *            result for mobile(true/false)
	 * @author :udchalo QA Automation Developer
	 */
	@Step("Step Desc ---> " + "{0} - {1} - {2}")
	public  void logReporter(String step, String expectedValue, String actualValue, boolean resultLog) {
		String strSuccessLog="";
		String strLog = step + " || Expected Result : " + expectedValue + " || Actual Result : " + actualValue;
		if(resultLog){
			strSuccessLog=step + " || Expected Result : " + expectedValue + " || Actual Result : " + expectedValue;
		this.addAssertTakeScreenShot(step, strSuccessLog, "", expectedValue, actualValue, resultLog);
		}else {
			
			this.addAssertTakeScreenShot(step, strLog, "", expectedValue, actualValue, resultLog);
		}
		
	}

	/**
	 * @Method : addAssertTakeScreenShot
	 * @Description :
	 * @param :
	 * @author : udchalo QA Automation Developer
	 */
	public  void addAssertTakeScreenShot(String step, String strLog, String inputValue, String expectedValue,
			String actualValue, boolean resultLog) {
		System.out.println("Step Description--> " + strLog);
		final Logger logger = Logger.getLogger(UtilitiesFunctions.class);
		String fileName = getDateInSpecifiedFormat("dd_MMM_yyyy_HH_mm_ss") + "_TCID_" + objPojo.getCurrent_TCID()
				+ ".png";
		String fileWithPath = System.getProperty("user.dir") + "\\target\\surefire-reports" + "\\ScreenShot\\"
				+ fileName;
		if (resultLog) {
			//String strSuccessLog=strLog.
			Reporter.log("Step Description--> " + strLog);
			logger.info("Step Description--> " + strLog);
			Assert.assertTrue(true);
		
		} else {
			Reporter.log("Step Description--> " + strLog);
			logger.error("Step Description--> " + strLog);
			this.takeScreenShot(objPojo.getDriver(), fileWithPath);
			Assert.assertEquals("ActualResult : "+actualValue, "ExpectedResult : " +expectedValue, "TEST FAILED ");
		}
	}

	/**
	 * @Method : fileToByte
	 * @Description : Converts image file to byte array for allure.
	 * @author :udchalo QA Automation Developer
	 * @throws :
	 *             IOException
	 */
	@Attachment(value = "Screenshot", type = "image/png")
	private  byte[] fileToByte(File file) throws IOException {
		if (file != null)
			return Files.readAllBytes(Paths.get(file.getPath()));
		else
			return new byte[0];
	}

	/*
	 * @Method : getDateInSpecifiedFormat
	 * 
	 * @Description : This method takes parameter of your required DateFormat
	 * Type Like: dd-mm-YYYY DD.MM.YYYY and in return it will give you today's
	 * date in specified date format
	 * 
	 * @param : dateFormat like : dd-MM-YYYY
	 * 
	 * @author : udchalo QA Automation Developer
	 * 
	 */
	public  String getDateInSpecifiedFormat(String dateFormat) {
		String current_date = "";
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		current_date = formatter.format(today);
		// System.out.println("getDateInSpecifiedFormat "+dateFormat + " -
		// "+current_date);
		return current_date;
	}

	/**
	 * @Method : takeScreenShot
	 * @Description : Take Screen shot for given web driver.
	 * @author :udchalo QA Automation Developer.
	 * 
	 */
	public  boolean takeScreenShot(WebDriver webDriver, String fileWithPath) {
		TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
		// Call getScreenshotAs method to create image file
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File destFile = new File(fileWithPath);
		// Copy file at destination
		try {
			FileUtils.moveFile(srcFile, destFile);
			this.fileToByte(destFile);
			return true;
		} catch (IOException iOException) {
			iOException.printStackTrace();
			return false;

		}
	}

	/**
	 * @Method: dpString
	 * @Description:  this method returns data from the the previously loaded dataManagerPool
	 * @param columnHeader - excel file header column name
	 * @return - value for corresponding header 
	 * @author udchalo QA Automation Developer
	 
	 */
	public String dataManagerString(String columnHeader)
	{
		Hashtable<String , String> dataPoolHashTable = objPojo.getDataPoolHashTable();
		try
		{
			if(dataPoolHashTable.get(columnHeader) == null)
				return "";
			else
			{
				Log.info("I found, Key: "+columnHeader + " Value : " + dataPoolHashTable.get(columnHeader));
				return dataPoolHashTable.get(columnHeader);
			}
		}
		catch (Exception exception) 
		{
			objPojo.setCustomException("Developer Side Issue");
			throw new RuntimeException(exception);
		}
	}
	
	//getFutureDateInSpecifiedFormat("DD-MM-YYYY",5)
	public String getFutureOrBackDateInSpecifiedFormat(String dateFormat, int NoOfFutureDay) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, NoOfFutureDay);
		String futureDate = new SimpleDateFormat(dateFormat).format(c.getTime()).toString();
		return futureDate;
	}
	
	
	public String getCurrentDate(){
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd");  
	    Date date = new Date();  
		String currentDate=formatter.format(date);
		return currentDate;
	}
	
	/**
	 * @Method: dpStringTokenizer
	 * @Description:  this Method is Used for Only get Number in excel sheet.
	 * @param columnHeader - excel file header column name
	 * @return - value for corresponding header 
	 * @author udchalo QA Automation Developer
	 * 
	 */
	public String dpStringTokenizer(String columnHeader)
	{
		Hashtable<String , String> dataPoolHashTable = objPojo.getDataPoolHashTable();
		try
		{
			if(dataPoolHashTable.get(columnHeader) == null)
				return "";
			else
			{
				Log.info("I found, Key: "+columnHeader + " Value : " + dataPoolHashTable.get(columnHeader));
				String strReturnValue= dataPoolHashTable.get(columnHeader);
				StringTokenizer strTokenizer= new StringTokenizer(strReturnValue, ".");
				strReturnValue=strTokenizer.nextToken();
				return strReturnValue;
			}
		}
		catch (Exception exception) 
		{
			objPojo.setCustomException("Developer Side Issue");
			throw new RuntimeException(exception);
		}
	}

	
	 public String createFirstLetterCapitalToTheString ( String strStringVal )
	  {
	      String strGivenLetter = strStringVal.substring(0,1).toUpperCase();
	      String strRemainigLetters = strStringVal.substring(1).toLowerCase();
	      return strGivenLetter + strRemainigLetters;
	  }
	 
	 public String getAdultsTitlesForTravellersDetails() {
		    
		    Random rand = new Random();
		    String randomTitle="";
		    List<String> givenList = Arrays.asList("Mr","Ms","Mrs");
		 
		    int numberOfElements = 3;
		 
		    for (int i = 0; i < numberOfElements; i++) {
		        int randomIndex = rand.nextInt(givenList.size());
		        randomTitle = givenList.get(randomIndex);
		    }
		    
		    return randomTitle;
		}
	 
	 
	 
	 public String getChildsTitlesForTravellersDetails() {
		 
		    Random rand = new Random();
		    String randomTitle="";
		    List<String> givenList = Arrays.asList("Miss","Master");
		 
		    int numberOfElements = 2;
		 
		    for (int i = 0; i < numberOfElements; i++) {
		        int randomIndex = rand.nextInt(givenList.size());
		        randomTitle = givenList.get(randomIndex);
		    }
		    
		    return randomTitle;   
		}
	 
	 public String getInfantsTitlesForTravellersDetails() {
		    
		    Random rand = new Random();
		    String randomTitle="";
		    List<String> givenList = Arrays.asList("Miss","Master");
		 
		    int numberOfElements = 2;
		 
		    for (int i = 0; i < numberOfElements; i++) {
		        int randomIndex = rand.nextInt(givenList.size());
		        randomTitle = givenList.get(randomIndex);
		    }
		    
		    return randomTitle;
		    
		    
		}
	 
	
		public String getRandomStringWithSmallAndCapitalLetters(int lenght) 
		{
			String allowedChars = "abcdefghiklABCDEFGHIJKLMNOmnopqrstuvwxyz";
			String randomstring = "";
			for (int i=0; i < lenght; i++) 
			{
				int rnum = (int) Math.floor(Math.random() * allowedChars.length() );
				randomstring += allowedChars.substring(rnum,rnum+1);
			}
			return randomstring;
		}
		
		
	 
		 public String getRandomDatesFormList() {
			    
			    Random rand = new Random();
			    String randomDate="";
			    List<String> givenList = Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28");
			 
			    int numberOfElements = 28;
			 
			    for (int i = 0; i < numberOfElements; i++) {
			        int randomIndex = rand.nextInt(givenList.size());
			        randomDate = givenList.get(randomIndex);
			    }
			    return randomDate;
			}


	
	
}
