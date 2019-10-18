package com.udchalo.generic;
import java.util.Hashtable;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;





/**
 * @ScriptName    : Pojo
 * @Description   : This class will used to set common properties 
 * 					like webdriver and properties files.
 * @Author        : udchalo QA Automation Developer
 * @since		  : 25-Jul-2019
 */
public class Pojo 
{

	private WebDriver webDriver;
	private WebDriverWait webDriverWait;
	private Properties objConfig;
	private String strTestDataFilePath = "";
	private String testCaseID = "";
	private String baseURL = "";
	private int afterClickwait = 0;
	private String resourceName = "Undefined";
	private String customException = " ";
	private String current_TCID = "";
	private UtilitiesFunctions objUtilitiesFunctions;
	private SeleniumFunctions objSeleniumFunctions;
	private Hashtable<String , String> dataPoolHashTable;

	
	

public void setWebDriver(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	
	public void setAfterClickwait(int afterClickwait) {
		this.afterClickwait = afterClickwait;
	}


	public String getCustomException() {
		return customException;
	}

	public void setCustomException(String customException) {
		this.customException = customException;
	}

	
	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	private int scriptTimeoutWait = 0;

	public int getScriptTimeoutWait() {
		return scriptTimeoutWait;
	}

	public void setScriptTimeoutWait(int scriptTimeoutWait) {
		this.scriptTimeoutWait = scriptTimeoutWait;
	}

	public Integer getAfterClickwait() {
		return afterClickwait;
	}

	public void setAfterClickwait(Integer afterClickwait) {
		this.afterClickwait = afterClickwait;
	}

	public void setDriver(WebDriver webDriver)
	{
		this.webDriver = webDriver;
	}

	public WebDriver getDriver()
	{
		return webDriver;
	}
	
	public String getStrTestDataFilePath()
	{
		return strTestDataFilePath;
	}

	public void setStrTestDataFilePath(String strTestDataFilePath)
	{
		this.strTestDataFilePath = strTestDataFilePath;
	}


	public void setWebDriverWait(WebDriverWait webDriverWait)
	{
		this.webDriverWait = webDriverWait;
	}

	public WebDriverWait getWebDriverWait()
	{
		return webDriverWait;
	}

	
	public void setObjConfig(Properties objConfig)
	{
		this.objConfig = objConfig;
	}

	public Properties getObjConfig()
	{
		return objConfig;
	}

	
	public String getTestCaseID() 
	{
		return testCaseID;
	}

	public void setTestCaseID(String testCaseID) 
	{
		this.testCaseID = testCaseID;
	}

	
	
	public void setBaseURL(String baseURL) 
	{
		this.baseURL = baseURL;
	}
	
	public String getBaseURL() {
		return baseURL;
	}
	
	public String getCurrent_TCID() {
		return current_TCID;
	}

	public void setCurrent_TCID(String current_TCID) {
		this.current_TCID = current_TCID;
	}


	public UtilitiesFunctions getObjUtilitiesFunctions() {
		return objUtilitiesFunctions;
	}


	public void setObjUtilitiesFunctions(UtilitiesFunctions objUtilitiesFunctions) {
		this.objUtilitiesFunctions = objUtilitiesFunctions;
	}
	
	public SeleniumFunctions getObjSeleniumFunctions() {
		return objSeleniumFunctions;
	}


	public void setObjSeleniumFunctions(SeleniumFunctions objSeleniumFunctions) {
		this.objSeleniumFunctions = objSeleniumFunctions;
	}
	
	public Hashtable<String, String> getDataPoolHashTable() {
		return dataPoolHashTable;
	}


	public void setDataPoolHashTable(Hashtable<String, String> dataPoolHashTable) {
		this.dataPoolHashTable = dataPoolHashTable;
	}

	
}
