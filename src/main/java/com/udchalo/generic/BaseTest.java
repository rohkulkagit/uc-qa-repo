package com.udchalo.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @ScriptName : BaseTest
 * @Description : This class will load all test data, load all objects,
 *              initialize web driver, start reports. Contains generic
 *              functionalities like open browser, login/logout
 * @Author : udchalo QA Automation Developer
 * @since : 25-July-2019
 */
public class BaseTest extends Pojo {

	// Global Variables
	private WebDriver webDriver;
	private Properties objConfig;
	private WebDriverWait webDriverWait;
	private String baseURL = "";
	private InitializeTearDownEnvironment objInitializeTearDownEnvironment;
	private UtilitiesFunctions objUtilitiesFunctions;
	private SeleniumFunctions objSeleniumFunctions;

	Hashtable<String, Hashtable<String, String>> testDataTable = new Hashtable<String, Hashtable<String, String>>();
	Hashtable<String, String> testDataForTest = new Hashtable<String, String>();

	/**
	 * @Method : initializeWebEnvironment
	 * @Description : This method initialize web driver for web application by
	 *              opening the browser and URL specified in config.properties
	 *              file
	 * @param :
	 *            strWebDriver - webdriver wait
	 * @author : udchalo QA Automation Developer
	 */
	public void initializeWebEnvironment(String testDataFilePath) {
		this.loadConfigProperties();
		this.loadDataProvider(testDataFilePath);
		objInitializeTearDownEnvironment = new InitializeTearDownEnvironment();
		webDriver = objInitializeTearDownEnvironment.initializeWebEnvironment(objConfig);
		this.setDriver(webDriver);
		setAfterClickwait(Integer.parseInt(objConfig.getProperty("AfterClickWait")));
		setScriptTimeoutWait(Integer.parseInt(objConfig.getProperty("ScriptTimeoutWait")));
		webDriverWait = new WebDriverWait(webDriver,
				Integer.parseInt(objConfig.getProperty("driver.WebDriverWait").trim()));
		this.setWebDriverWait(webDriverWait);
		objUtilitiesFunctions = new UtilitiesFunctions(this);
		this.setObjUtilitiesFunctions(objUtilitiesFunctions);
		objSeleniumFunctions = new SeleniumFunctions(this);
		this.setObjSeleniumFunctions(objSeleniumFunctions);
		baseURL = objConfig.getProperty("AUT_URL");
		this.setBaseURL(baseURL);

		this.loadBaseURL();

	}

	/**
	 * Open Base URL
	 * 
	 * @author : udchalo QA Automation Developer
	 */
	public void loadBaseURL() {
		try {

			webDriver.get(getBaseURL());
			getObjUtilitiesFunctions().logReporter("Loading web application URL:   ", getBaseURL(), true);

		} catch (Exception exception) {
			exception.printStackTrace();

		}
	}

	/**
	 * @Method : tearDownWebEnvironment
	 * @Description : quit webdriver
	 * @author : udchalo QA Automation Developer
	 */
	public void tearDownWebEnvironment() {

		Process process;

		if (System.getProperty("os.name").toLowerCase().contains("win")) {

			try {
				// Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
				webDriver.manage().deleteAllCookies();

				try {
					File file = new File(System.getProperty("java.io.tmpdir"));
					FileUtils.cleanDirectory(file);
				} catch (IOException e) {
					// Do nothing since we do not worry about the files that
					// cannot be deleted
					// Include exception handler logic if you want to
				}

				webDriver.quit();
				objUtilitiesFunctions = null;
				objSeleniumFunctions.waitFor(2);
				Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				Thread.sleep(1500);
				// Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
				Thread.sleep(1500);
				System.out.println("Kill Chrome Browser.!!!!!!");
			} catch (Exception exception) {
				try {
					// Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
					Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				exception.printStackTrace();
				if (System.getProperty("web.browser").trim().equalsIgnoreCase("IE")
						|| System.getProperty("web.browser").trim().equalsIgnoreCase("Chrome"))
					killBrowserAndDriver(objConfig);
			}
			objSeleniumFunctions = null;
		} else {

			try {
				process = Runtime.getRuntime().exec("killall chrome");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/**
	 * @Method : killBrowserAndDriver
	 * @Description : this method close the web browser
	 * @author : udchalo QA Automation Developer
	 */
	protected void killBrowserAndDriver(Properties objConfig) {
		String browser = System.getProperty("web.browser").trim();
		String browserProcess = "";
		String driverProcess = "";

		if (!browser.equals("") && browser.equalsIgnoreCase("IE")) {
			browserProcess = "iexplore";
			driverProcess = "IEDriverServer.exe";
		} else if (!browser.equals("") && browser.equalsIgnoreCase("Chrome")) {
			browserProcess = browser;
			driverProcess = "chromedriver.exe";
		}

		try {
			Process procDriver = Runtime.getRuntime().exec("taskkill /F /T /IM " + driverProcess);
			Process procIE = Runtime.getRuntime().exec("taskkill /F /T /IM " + browserProcess + ".exe");
			procDriver.waitFor();
			procIE.waitFor();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @Method : loadConfigProperties
	 * @Description : load config properties
	 * @author : udchalo QA Automation Developer
	 */
	public void loadConfigProperties() {
		try {
			objConfig = new Properties();
			objConfig.load(new FileInputStream(
					System.getProperty("user.dir") + "/src/test/resources/configuration/config.properties"));
			this.setObjConfig(objConfig);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Returns the value of given property from config.properties file
	 * 
	 * @param key
	 *            - ConfigParamvalue that requires to be returned from
	 *            Config.properties file
	 * @return - return ConfigValue
	 * @Author : udchalo QA Automation Developer
	 */
	public String getProperty(String key) {
		String strValue = "";
		if (key != "") {
			this.loadConfigProperties();
			try {
				if (!objConfig.getProperty(key).trim().isEmpty())
					strValue = objConfig.getProperty(key).trim();
			} catch (NullPointerException exception) {
				objUtilitiesFunctions.logReporter("Config property file data does not exist.", true);
				exception.printStackTrace();
			}
		} else {
			objUtilitiesFunctions.logReporter("Config proprty key cannot be null..", true);

		}
		return strValue;
	}

	/**
	 * @Method: createLo4jLogerDirectory
	 * @author : udchalo QA Automation Developer
	 */
	public void createLo4jLogerDirectory() {
		String logFilePath = System.getProperty("user.dir") + "/target/custom-reports/log4j-Logger.log";
		File reportFile = new File(logFilePath);
		try {
			// If file not exist create for running script details
			if (!reportFile.exists()) {
				new File(System.getProperty("user.dir") + "/target/custom-reports").mkdir();
				reportFile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Method : loadDataProvider
	 * @param :
	 *            testCaseID - test case id
	 * @param :
	 *            testDataFile - test data file
	 * @Description : Load Data from Excel for the running testCase and return
	 *              as Object array
	 * @author : udchalo QA Automation Developer
	 */
	public void loadDataProvider(String testDataFilePath) {
		if (!testDataFilePath.equals("")) {
			this.loadConfigProperties();
			testDataFilePath = System.getProperty("user.dir") + "/src/test/resources/testData/" + testDataFilePath
					+ ".xlsx";
			DataManagerPool objDataPool = new DataManagerPool();
			testDataTable = objDataPool.loadTestData(testDataFilePath);
			// System.out.println("testDataTable------>" + testDataTable);
		}
	}

	/**
	 * @Method : loadTestData
	 * @param :
	 *            runID - test case run id
	 * @param :
	 *            dataSet - test data hash table
	 * @Description : Load data from excel for the running testCase and return
	 *              as Object array
	 * @author : udchalo QA Automation Developer
	 */
	public void loadTestData(String TCIDRowNumber) {
		testDataForTest = testDataTable.get(TCIDRowNumber);
		System.out.println("testDataForTest------->" + testDataForTest);
		setDataPoolHashTable(testDataForTest);
		objUtilitiesFunctions = new UtilitiesFunctions(this);
		this.setObjUtilitiesFunctions(objUtilitiesFunctions);
		final Logger logger = Logger.getLogger(UtilitiesFunctions.class);
		logger.info(
				"------------------------------------------------------------------------------------------------------");
		logger.info("TCID " + TCIDRowNumber + " STARTED AT "
				+ objUtilitiesFunctions.getDateInSpecifiedFormat("dd-MMM-yyyy-HH-mm-ss"));
		this.setCurrent_TCID(TCIDRowNumber);
	}

	/**
	 * Description : Delete all files Under that directory
	 * 
	 * @author : udchalo QA Automation Developer
	 */

	public boolean cleanDonloadsDirectory() {
		try {
			String downloadFilesLocation = System.getProperty("user.dir")
					+ objConfig.getProperty("downloads.path").trim();
			File directory = new File(downloadFilesLocation);
			FileUtils.cleanDirectory(directory);
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}

		return true;
	}

	public void TCID_Status_Report(String strLog) {

		final Logger logger = Logger.getLogger(UtilitiesFunctions.class);
		logger.info("TEST CASE STATUS --> " + strLog);

	}

	
	/**
	 * @Method : initializeWebEnvironmentForAdmin
	 * @Description : This method initialize web driver for web application by
	 *              opening the browser and URL specified in config.properties
	 *              file
	 * @param :
	 *            strWebDriver - webdriver wait
	 * @author : udchalo QA Automation Developer
	 */
	public void initializeWebEnvironmentIncognitoForAdmin(String testDataFilePath) {
		this.loadConfigProperties();
		this.loadDataProvider(testDataFilePath);
		objInitializeTearDownEnvironment = new InitializeTearDownEnvironment();
		webDriver = objInitializeTearDownEnvironment.initializeWebEnvironmentForAdmin(objConfig);
		this.setDriver(webDriver);
		setAfterClickwait(Integer.parseInt(objConfig.getProperty("AfterClickWait")));
		setScriptTimeoutWait(Integer.parseInt(objConfig.getProperty("ScriptTimeoutWait")));
		webDriverWait = new WebDriverWait(webDriver,
				Integer.parseInt(objConfig.getProperty("driver.WebDriverWait").trim()));
		this.setWebDriverWait(webDriverWait);
		objUtilitiesFunctions = new UtilitiesFunctions(this);
		this.setObjUtilitiesFunctions(objUtilitiesFunctions);
		objSeleniumFunctions = new SeleniumFunctions(this);
		this.setObjSeleniumFunctions(objSeleniumFunctions);
		baseURL = objConfig.getProperty("AUT_ADMIN_URL");
		this.setBaseURL(baseURL);

		this.loadBaseURL();

	}

	
}
