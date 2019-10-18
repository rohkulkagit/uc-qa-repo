package com.udchalo.generic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
/**
 * @ScriptName    : InitializeTearDownEnvironment
 * @Description   : This class is for test environment setup as well as terminate the setup.
 * @Author        : udchalo QA Automation Developer
 * @since         : 05-Aug-2019
 */
public class InitializeTearDownEnvironment {
	private WebDriver webDriver;

	/**
	 * @Method : setUpDesktopEnvironment
	 * @Description : This method initialize web driver for web application by
	 *              opening the browser and URL specified in config.properties and Excel sheets.
	 *              file
	 * @author : udchalo QA Automation Developer
	 */

	public WebDriver initializeWebEnvironment(Properties objConfig) {
		try {
			
			String browser = objConfig.getProperty("web.browser").trim().toLowerCase();
			String strExecutionMode=objConfig.getProperty("Execution.Mode.Headless").toLowerCase();
			boolean blnFlag = Boolean.parseBoolean(strExecutionMode);

			switch (browser) {
			case "ie": // If specified browser is Internet Explorer
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + objConfig.getProperty("webdriver.ie.driver").trim());
				
				 webDriver = new InternetExplorerDriver();

				break;

			case "firefox": // If specified browser is Firefox
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + objConfig.getProperty("webdriver.gecko.driver").trim());
				
				webDriver = new FirefoxDriver();
				break;

			case "chrome": // If specified browser is Chrome
				
				ChromeOptions options = new ChromeOptions();
				 DesiredCapabilities cap = DesiredCapabilities.chrome();
				options.addArguments("--no-sandbox");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-notifications");
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-extensions");
                options.setExperimentalOption("useAutomationExtension", false);
                
				
				if(System.getProperty("os.name").toLowerCase().contains("win")){
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + objConfig.getProperty("webdriver.chrome.driver.windows").trim());
				
				options.setHeadless(blnFlag);
				
				}
				else{
					
					options.setBinary("/usr/bin/google-chrome");
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + objConfig.getProperty("webdriver.chrome.driver.linux").trim());
					
					
					File file = new File(System.getProperty("user.dir") + objConfig.getProperty("webdriver.chrome.driver.linux").trim());
					options.setHeadless(true);
					setPermission(file);
					
				}
				webDriver = new ChromeDriver(options);
				break;

			default:
				webDriver = new FirefoxDriver();
			}
			// Set the minimum width and height to ensure there is no
			// unintentional overlap of UI elements
			webDriver.manage().window().maximize();
			// Wait for ui-elements to potentially load, up to a second.
			webDriver.manage().timeouts().implicitlyWait(
					Integer.parseInt(objConfig.getProperty("driver.implicitlyWait").trim()), TimeUnit.SECONDS);
			// limit how much time a driver should wait for a page to load
			webDriver.manage().timeouts().pageLoadTimeout(
					Integer.parseInt(objConfig.getProperty("driver.pageLoadTimeout").trim()), TimeUnit.SECONDS);

			return webDriver;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	
	public WebDriver initializeWebEnvironmentForAdmin(Properties objConfig) {
		try {
			
			String browser = objConfig.getProperty("web.browser").trim().toLowerCase();
			String strExecutionMode=objConfig.getProperty("Execution.Mode.Headless").toLowerCase();
			boolean blnFlag = Boolean.parseBoolean(strExecutionMode);

			switch (browser) {
			case "ie": // If specified browser is Internet Explorer
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + objConfig.getProperty("webdriver.ie.driver").trim());
				
				 webDriver = new InternetExplorerDriver();

				break;

			case "firefox": // If specified browser is Firefox
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + objConfig.getProperty("webdriver.gecko.driver").trim());
				
				webDriver = new FirefoxDriver();
				break;

			case "chrome": // If specified browser is Chrome
				
				ChromeOptions options = new ChromeOptions();
				 DesiredCapabilities cap = DesiredCapabilities.chrome();
				options.addArguments("--no-sandbox");
                options.addArguments("disable-infobars");
                options.addArguments("--disable-notifications");
                cap.setCapability(ChromeOptions.CAPABILITY, options);
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-extensions");
                options.setExperimentalOption("useAutomationExtension", false);
                
				
				if(System.getProperty("os.name").toLowerCase().contains("win")){
					options.addArguments("--incognito");
					System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + objConfig.getProperty("webdriver.chrome.driver.windows").trim());
				
				options.setHeadless(blnFlag);
				
				}
				else{
					options.addArguments("--incognito");
					options.setBinary("/usr/bin/google-chrome");
					System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + objConfig.getProperty("webdriver.chrome.driver.linux").trim());
					
					
					File file = new File(System.getProperty("user.dir") + objConfig.getProperty("webdriver.chrome.driver.linux").trim());
					options.setHeadless(true);
					setPermission(file);
					
				}
				webDriver = new ChromeDriver(options);
				break;

			default:
				webDriver = new FirefoxDriver();
			}
			// Set the minimum width and height to ensure there is no
			// unintentional overlap of UI elements
			webDriver.manage().window().maximize();
			// Wait for ui-elements to potentially load, up to a second.
			webDriver.manage().timeouts().implicitlyWait(
					Integer.parseInt(objConfig.getProperty("driver.implicitlyWait").trim()), TimeUnit.SECONDS);
			// limit how much time a driver should wait for a page to load
			webDriver.manage().timeouts().pageLoadTimeout(
					Integer.parseInt(objConfig.getProperty("driver.pageLoadTimeout").trim()), TimeUnit.SECONDS);

			return webDriver;
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public void setPermission(File file) throws IOException{
	    Set<PosixFilePermission> perms = new HashSet<>();
	    perms.add(PosixFilePermission.OWNER_READ);
	    perms.add(PosixFilePermission.OWNER_WRITE);
	    perms.add(PosixFilePermission.OWNER_EXECUTE);

	    perms.add(PosixFilePermission.OTHERS_READ);
	    perms.add(PosixFilePermission.OTHERS_WRITE);
	    perms.add(PosixFilePermission.OTHERS_EXECUTE);

	    perms.add(PosixFilePermission.GROUP_READ);
	    perms.add(PosixFilePermission.GROUP_WRITE);
	    perms.add(PosixFilePermission.GROUP_EXECUTE);

	    Files.setPosixFilePermissions(file.toPath(), perms);
	}

}