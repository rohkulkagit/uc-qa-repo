package com.udchalo.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SeleniumFunctions extends LoadableComponent<SeleniumFunctions> {
	private Pojo objPojo;
	private RobotClass objRobotClass;

	public SeleniumFunctions(Pojo pojo) {
		this.objPojo = pojo;
		objRobotClass = new RobotClass();
	}

	/**
	 * @Description : This is wrapper method wait for element presence located
	 * @param :
	 *            locator - By identification of element
	 * @Author : udchalo QA Automation Developer
	 */
	public void waitForElementPresence(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * @Description : This is wrapper method wait for element presence located
	 * @param :
	 *            locator - By identification of element
	 * @Author : udchalo QA Automation Developer
	 */
	public void waitForPresenceOfNestedElementLocated(WebElement webElement, By sub_locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.presenceOfNestedElementLocatedBy(webElement, sub_locator));
	}

	/**
	 * @Description : This is wrapper method wait for element presence located
	 * @param :
	 *            locator - By identification of element
	 * @Author : udchalo QA Automation Developer
	 */
	public void waitForPresenceOfNestedElementsLocated(By locator, By sub_locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.presenceOfNestedElementsLocatedBy(locator, sub_locator));
	}

	/**
	 * @Description : This is wrapper method wait for element to be clickable
	 * @param :
	 *            locator - By identification of element
	 * @Author : udchalo QA Automation Developer
	 */
	public void waitForElementToBeClickable(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * @Description : This is wrapper method wait for visibility of element
	 *              located
	 * @param :
	 *            locator - By identification of element
	 * @Author : udchalo QA Automation Developer
	 */
	public void waitForElementVisibilityLocated(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForElementVisibility(WebElement webElement) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
	}

	/**
	 * @Description : This is wrapper method wait for visibility of element
	 *              located
	 * @param :
	 *            locator - By identification of element
	 * @Author : udchalo QA Automation Developer
	 */
	public void waitForElementInVisibilityLocated(By locator) throws NotFoundException {
		objPojo.getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void waitAfterEachClick() {
		waitFor(objPojo.getAfterClickwait());
		System.out.println("After Click wait is " + objPojo.getAfterClickwait());
	}

	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param :
	 *            timeUnitSeconds - wait time seconds
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean waitFor(int timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(timeUnitSeconds, TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : waitFor
	 * @Description : Waits for the specified amount of [timeInMilliseconds].
	 * @param :
	 *            timeUnitSeconds - wait time seconds
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean waitFor(String timeUnitSeconds) {
		try {
			Thread.sleep(TimeUnit.MILLISECONDS.convert(Integer.parseInt(timeUnitSeconds), TimeUnit.SECONDS));
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean checkElementDisplayed(By locator) {
		try {
			this.waitForElementVisibilityLocated(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 * 
	 */
	public boolean checkElementDisplayed(WebElement webElement) {
		try {

			this.waitForElementVisibility(webElement);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("arguments[0].style.height='auto'; arguments[0].style.visibility='visible';",
					getElementFluent(webElement));
			return webElement.isDisplayed();

		} catch (NotFoundException exception) {

			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;

		} catch (Exception exception) {

			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean checkElementPresence(By locator) {
		try {
			this.waitForElementPresence(locator);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean isElementDisplayed(By locator) {
		try {
			objPojo.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean checkElementVisibile(By locator) {
		try {
			this.waitForElementVisibilityLocated(locator);
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 */

	public boolean checkElementInVisibile(By locator) {
		try {
			this.waitForElementInVisibilityLocated(locator);
			return !objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return true;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is
	 *              displayed on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean waitForElementDisplayed(By locator, int timeInMiliSeconds) {
		try {
			WebDriverWait webDriverWait = new WebDriverWait(objPojo.getDriver(), timeInMiliSeconds);
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return objPojo.getDriver().findElement(locator).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	/**
	 * @Description : This is wrapper method to check the web element is enabled
	 *              on the page
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if element present
	 * @Author : udchalo QA Automation Developer
	 */
	public boolean checkElementEnabled(By locator) {
		try {
			this.waitForElementVisibilityLocated(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			return objPojo.getDriver().findElement(locator).isEnabled();
		} catch (Exception exception) {
			return false;
		}
	}

	public WebElement getElementFluent(final By locator) throws NoSuchElementException, TimeoutException {
		System.out.println("**************** into getElementFluent");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(objPojo.getDriver())
				.withTimeout(Integer.parseInt(objPojo.getObjConfig().getProperty("driver.WebDriverWait")),
						TimeUnit.SECONDS)
				.pollingEvery(Integer.parseInt(objPojo.getObjConfig().getProperty("driver.FluentWaiPulling")),
						TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).ignoring(InvalidElementStateException.class);

		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return objPojo.getDriver().findElement(locator);
			}
		});

		return webElement;
	}

	public WebElement getNestedElementFluent(final WebElement parentWebElement, final By locator)
			throws NoSuchElementException, TimeoutException {
		// System.out.println("**************** into getNestedElementFluent");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(objPojo.getDriver())
				.withTimeout(Integer.parseInt(objPojo.getObjConfig().getProperty("driver.WebDriverWait")),
						TimeUnit.SECONDS)
				.pollingEvery(Integer.parseInt(objPojo.getObjConfig().getProperty("driver.FluentWaiPulling")),
						TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).ignoring(InvalidElementStateException.class);

		WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return parentWebElement.findElement(locator);
			}
		});

		return webElement;
	}

	public WebElement getElementFluent(final WebElement webElement) throws NoSuchElementException, TimeoutException {
		System.out.println("**************** into getElementFluent");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(objPojo.getDriver())
				.withTimeout(Integer.parseInt(objPojo.getObjConfig().getProperty("driver.WebDriverWait")),
						TimeUnit.SECONDS)
				.pollingEvery(Integer.parseInt(objPojo.getObjConfig().getProperty("driver.FluentWaiPulling")),
						TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).ignoring(InvalidElementStateException.class);

		WebElement weElement = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return webElement;
			}
		});

		return webElement;
	}

	/**
	 * @Method : click
	 * @Description : This is wrapper method to click on web element
	 * @param :
	 *            locator - By identification of element
	 * @return : - true if click successful
	 * @author : udchalo QA Automation Developer
	 */
	public boolean click(By locator) {
		try {
			this.waitForElementPresence(locator);
			// this.waitForElementToBeClickable(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			objPojo.getDriver().manage().timeouts().setScriptTimeout(objPojo.getScriptTimeoutWait(), TimeUnit.SECONDS);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			js.executeScript("return arguments[0].click()", getElementFluent(locator));
			waitAfterEachClick();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			try {
				waitForElementPresence(locator);
				waitForElementToBeClickable(locator);
				getElementFluent(locator).click();
				waitAfterEachClick();
				return true;
			} catch (Exception exceptionJavascript) {
				objPojo.setCustomException("NoSuchElement Exception");
				return false;
			}
		}
	}

	/**
	 * @Method : setText
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : udchalo QA Automation Developer
	 */
	public boolean setText(By locator, String fieldValue) {
		try {
			/*
			 * waitForElementPresence(locator);
			 * waitForElementVisibilityLocated(locator);
			 */
			WebElement webElement = getElementFluent(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			clearText(webElement);
			// webElement.clear();
			webElement.sendKeys(fieldValue);
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public void clearText(WebElement webElement) {

		webElement.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
	}

	/**
	 * @Method : mouseHover
	 * @Description : This is wrapper method used for Mouse Hovering to the
	 *              element
	 * @param :
	 *            locator - By identification of element
	 * @author :udchalo QA Automation Developer
	 */
	public boolean mouseHover(By locator) {
		try {
			waitForElementPresence(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			WebElement webElement = objPojo.getDriver().findElement(locator);
			Actions actionBuilder = new Actions(objPojo.getDriver());
			actionBuilder.moveToElement(webElement).build().perform();
			return true;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectRadioButton
	 * @Description : This is Selenium Function method select/deselect radio
	 *              button
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            status - select/deselect
	 * @author :udchalo QA Automation Developer
	 */
	public boolean selectRadioButton(By locator, boolean status) {
		try {
			waitForElementPresence(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("class").contains("radio")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : isRadioButtonSelected
	 * @Description : This is Selenium Function RadioButton is selected or not
	 * @param :
	 *            locator - By identification of element
	 * @author :udchalo QA Automation Developer
	 */
	public boolean isRadioButtonSelected(By locator) {
		boolean state = false;
		try {
			waitForElementPresence(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("class").contains("radio"))
				state = webElement.isSelected();

			return state;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : setBootStrapDivSpan
	 * @Description : This is SeleniumFunction method to set text for input
	 *              element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : udchalo QA Automation Developer
	 */
	public boolean setBootStrapInputText(By locator, String fieldValue) {
		try {
			boolean selected = false;
			WebElement input = getElementFluent(locator);
			clearText(input);
			input.sendKeys(fieldValue);
			WebElement ul = input.findElement(By.xpath(".//parent::span//div/ul"));
			waitForPresenceOfNestedElementLocated(ul, By.xpath(".//li/div/span[2]"));
			List<WebElement> list = ul.findElements(By.xpath(".//li/div/span[2]"));
			System.out.println("list------------>" + list.size());
			for (WebElement expectedLink : list) {
				System.out.println("innerHTML---> " + expectedLink.getText());
				if (expectedLink.getText().trim().toLowerCase().contains(fieldValue.toLowerCase())) {
					waitAfterEachClick();
					this.setHighlight(expectedLink);
					expectedLink.click();
					selected = true;
					break;
				}
			}
			return selected;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public boolean datePicker(By locator, String strNoOfFutureDayFromCurrentDate) {
		try {

			boolean selected = false;
			ArrayList<String> arrayList = new ArrayList<String>();
			String strNoOfDayInMonth = "", strCalHeader = "", strCurrentYear = "", strCurrentMonth = "",
					strSetDate = "", strVal = "", strFinalDate1 = "", strDate = "", strFinalDate = "";
			int intDate, intSelectDate, intActiveDateCounter;

			List<WebElement> activeDatesInMonth = null;
			By divCalendarPopup = By.xpath("//div[@class='selector ng-star-inserted']");
			By allActiveDatesInMonth = By.xpath(
					"//div[@class='selector ng-star-inserted']//table//td[@class='daycell currmonth tablesingleday ng-star-inserted']");
			By calHeader = By.xpath(
					"//label[text()='Travel Date*']/following-sibling::udchalo-datepicker//div/table[@class='ui-header']");
			By monthNextButton = By.xpath(
					"//button[@class='headerbtn icon md-caret-right headerbtnenabled'][@aria-label='Next Month']");
			By setDateLocator = By.xpath(
					"//input[@class='text-input inputnoteditable ng-star-inserted' and @autocomplete='off'][@aria-label='Date input field']");
			By tripTypeLocator = By.xpath("//label[text()='Onward Date*']");
			By calHeaderRound = By.xpath(
					"//label[text()='Onward Date*']/following-sibling::udchalo-datepicker//div/table[@class='ui-header']");

			objPojo.getObjUtilitiesFunctions().logReporter("Click on calendar icon", this.click(locator));
			objPojo.getObjUtilitiesFunctions().logReporter("Verify calendar popup displayed",
					this.checkElementDisplayed(divCalendarPopup));

			activeDatesInMonth = objPojo.getDriver().findElements(allActiveDatesInMonth);
			intActiveDateCounter = activeDatesInMonth.size();
			System.out.println("Active dates in month counts ----> " + activeDatesInMonth.size());

			intDate = Integer.parseInt(objPojo.getObjUtilitiesFunctions().getCurrentDate())
					+ Integer.parseInt(strNoOfFutureDayFromCurrentDate);
			strFinalDate = String.valueOf(intDate);
			System.out.println("Current Date -----> " + objPojo.getObjUtilitiesFunctions().getCurrentDate());
			for (WebElement expectedDateLink : activeDatesInMonth) {
				arrayList.add(expectedDateLink.getText());
			}

			if (objPojo.getObjSeleniumFunctions().checkElementDisplayed(tripTypeLocator)) {

				strCalHeader = this.getText(calHeaderRound, "text");
				strCurrentYear = strCalHeader.replaceAll("[^0-9]", "").trim();
				System.out.println("Current Year -----> " + strCurrentYear);
			} else {

				strCalHeader = this.getText(calHeader, "text");
				strCurrentYear = strCalHeader.replaceAll("[^0-9]", "").trim();
				System.out.println("Current Year -----> " + strCurrentYear);
			}

			strCurrentMonth = strCalHeader.replaceAll("[^a-zA-Z_]", "").trim();
			System.out.println("Current Month -----> " + strCurrentMonth);
			strNoOfDayInMonth = arrayList.get(arrayList.size() - 1);
			System.out.println("Total No of day In current month ----> " + strNoOfDayInMonth);
			intSelectDate = Integer.parseInt(strNoOfDayInMonth) - intDate;
			strFinalDate1 = String.valueOf(intSelectDate);
			strVal = strFinalDate1.replaceFirst("-", "").trim();

			if (intDate >= Integer.parseInt(strNoOfDayInMonth)) {

				if (Integer.parseInt(strVal) >= 30)
					this.click(monthNextButton);

			} else {

				if (intDate < Integer.parseInt(strNoOfDayInMonth)) {

					for (WebElement expectedDateLink : activeDatesInMonth) {

						if (expectedDateLink.getText().trim().equals(strFinalDate)) {
							this.setHighlight(expectedDateLink);
							expectedDateLink.click();
							strSetDate = this.getText(setDateLocator, "value");
							objPojo.getObjUtilitiesFunctions().logReporter("Set Date in DatePicker ", strSetDate, true);
							selected = true;
							break;
						}
					}
				}
			}

			while (intDate >= Integer.parseInt(strNoOfDayInMonth)) {
				this.click(monthNextButton);

				objPojo.getObjUtilitiesFunctions().logReporter("Verify calendar popup displayed",
						this.checkElementDisplayed(divCalendarPopup));

				if (Integer.parseInt(strVal) <= 31) {

					activeDatesInMonth = objPojo.getDriver().findElements(allActiveDatesInMonth);

					for (WebElement expectedDateLink : activeDatesInMonth) {

						if (expectedDateLink.getText().trim().equals(strVal)) {
							this.setHighlight(expectedDateLink);
							expectedDateLink.click();
							strSetDate = this.getText(setDateLocator, "value");
							objPojo.getObjUtilitiesFunctions().logReporter("Set Date in DatePicker ", strSetDate, true);
							selected = true;
							break;

						}
					}
				}

				activeDatesInMonth = null;
				this.waitFor(3);
				activeDatesInMonth = objPojo.getDriver().findElements(allActiveDatesInMonth);
				for (WebElement expectedDateLink : activeDatesInMonth) {
					arrayList.add(expectedDateLink.getText());
				}
				strNoOfDayInMonth = arrayList.get(arrayList.size() - 1);
				intSelectDate = Integer.parseInt(strNoOfDayInMonth) - Integer.parseInt(strVal);
				strDate = String.valueOf(intSelectDate).replaceFirst("-", "").trim();
				this.waitFor(5);
				if (Integer.parseInt(strDate) <= Integer.parseInt(strNoOfDayInMonth)) {

					this.waitFor(3);
					for (WebElement expectedDateLink : activeDatesInMonth) {

						if (expectedDateLink.getText().trim().equals(strDate)) {
							this.setHighlight(expectedDateLink);
							expectedDateLink.click();
							selected = true;
							break;
						}
					}

					strSetDate = this.getText(setDateLocator, "value");
					if (!strSetDate.equals("")) {
						objPojo.getObjUtilitiesFunctions().logReporter("Set Date in DatePicker ", strSetDate, true);

						break;

					} else {

					}

				}

			}
			return selected;

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public boolean datePickerReturn(By locator, String futureDate) {
		try {

			boolean selected = false;
			String strSetDate = "", strFinalDate = "";
			int intDate, intActiveDateCounter;
			List<WebElement> activeDatesInMonth = null;
			By divCalendarReturnDatePopUp = By.xpath("//div[@class='selector alignselectorright ng-star-inserted']");
			By allActiveDatesInMonth = By.xpath(
					"//div[@class='selector alignselectorright ng-star-inserted']//table//td[@class='daycell currmonth tablesingleday ng-star-inserted']");
			By monthNextButton = By.xpath(
					"//button[@class='headerbtn icon md-caret-right headerbtnenabled'][@aria-label='Next Month']");
			By setDateLocator = By.xpath(
					"//label[text()='Return Date*']/parent::div[1]//input[@autocomplete='off' and @class='text-input ng-star-inserted inputnoteditable'][@aria-label='Date input field']");

			objPojo.getObjUtilitiesFunctions().logReporter("Verify calendar popup displayed",
					this.checkElementDisplayed(divCalendarReturnDatePopUp));

			activeDatesInMonth = objPojo.getDriver().findElements(allActiveDatesInMonth);
			intActiveDateCounter = activeDatesInMonth.size();
			System.out.println("Active dates in month counts ----> " + activeDatesInMonth.size());

			if (intActiveDateCounter == 0) {
				this.click(monthNextButton);
				activeDatesInMonth = null;
				activeDatesInMonth = objPojo.getDriver().findElements(allActiveDatesInMonth);
				intActiveDateCounter = activeDatesInMonth.size();
				System.out.println("Active dates in month counts ----> " + activeDatesInMonth.size());

				intDate = 0 + Integer.parseInt(futureDate);
				System.out.println("intDate -----> " + intDate);
				strFinalDate = String.valueOf(intDate);

				for (WebElement expectedDateLink : activeDatesInMonth) {

					if (expectedDateLink.getText().trim().equals(strFinalDate)) {
						this.setHighlight(expectedDateLink);
						expectedDateLink.click();
						strSetDate = this.getText(setDateLocator, "value");
						objPojo.getObjUtilitiesFunctions().logReporter("Set Return Date in DatePicker ", strSetDate,
								true);
						selected = true;
						break;
					}
				}

			} else {

				activeDatesInMonth = objPojo.getDriver().findElements(allActiveDatesInMonth);
				intActiveDateCounter = activeDatesInMonth.size();
				System.out.println("Active dates in month counts ----> " + activeDatesInMonth.size());
				intDate = Integer.parseInt(objPojo.getObjUtilitiesFunctions().getCurrentDate())
						+ Integer.parseInt(futureDate);
				strFinalDate = String.valueOf(intDate);

				for (WebElement expectedDateLink : activeDatesInMonth) {

					if (expectedDateLink.getText().trim().equals(strFinalDate)) {
						this.setHighlight(expectedDateLink);
						expectedDateLink.click();
						strSetDate = this.getText(setDateLocator, "value");
						objPojo.getObjUtilitiesFunctions().logReporter("Set Return Date in DatePicker ", strSetDate,
								true);
						selected = true;
						break;
					}
				}
			}

			return selected;

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public String getText(By locator) {
		try {
			this.fluentwaitForElement(locator);
			// this.waitForElementPresence(locator);
			// this.waitForElementVisibilityLocated(locator);
			WebElement element = objPojo.getDriver().findElement(locator);
			return element.getText();

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public void fluentwaitForElement(final By locator) {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(objPojo.getDriver()).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class, TimeoutException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(locator);
				return element;
			}
		});
	}

	public boolean checkElementNOTDisplayed(By locator) {

		try {

			this.waitForElementPresence(locator);
			return !(objPojo.getDriver().findElement(locator).isDisplayed());
		} catch (Exception e) {

			// e.printStackTrace();
			return true;
		}

	}

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to extract the text value of an
	 *              webelement : This method is used for dom
	 * 
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            textBy - String - "value" or "text"
	 * @return : text value of the passed locator
	 * @author : udchalo QA Automation Developer
	 * 
	 */
	public String getText(By locator, String textBy) {
		String strText = "";
		try {
			waitForElementPresence(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			WebElement webElement = this.objPojo.getDriver().findElement(locator);
			switch (textBy.toLowerCase()) {
			case "value":
				strText = webElement.getAttribute("value");
				break;

			case "text":
				strText = webElement.getText();
				break;
			default:
				strText = webElement.getText();
				break;
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
		}
		return strText;
	}

	/**
	 * @Method : selectCheckBox
	 * @Description : This is wrapper method select/deselect checkbox
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            status - select/deselect
	 * @author : udchalo QA Automation Developer
	 */
	public boolean selectCheckBox(By locator, boolean status) {
		try {
			waitForElementPresence(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("checkbox")) {
				if ((webElement.isSelected() && !status) || (!webElement.isSelected() && status))
					webElement.click();
				return true;
			} else
				return false;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method : isCheckBoxSelected
	 * @Description : This is wrapper checkbox is selected or not
	 * @param :
	 *            locator - By identification of element
	 * @author : udchalo QA Automation Developer
	 */
	public boolean isCheckBoxSelected(By locator) {
		boolean state = false;
		try {
			waitForElementPresence(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			WebElement webElement = objPojo.getDriver().findElement(locator);
			if (webElement.getAttribute("type").equals("checkbox"))
				state = webElement.isSelected();

			return state;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			return false;
		}
	}

	/**
	 * @Method Highlights on current working element or locator
	 * @param Webdriver
	 *            instance
	 * @param WebElement
	 * @return void (nothing)
	 */
	public void setHighlight(WebElement element) {

		if (objPojo.getObjConfig().getProperty("HighlightElements").equalsIgnoreCase("true")) {
			String attributevalue = "background: yellow; border: 2px solid red;";
			// String attributevalue = "border:3px solid red;";
			JavascriptExecutor executor = (JavascriptExecutor) objPojo.getDriver();
			String getattrib = element.getAttribute("style");
			executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, attributevalue);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				objPojo.getObjUtilitiesFunctions().logReporter("Interruppted exception occured.", true);
			}
			executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, getattrib);
		}
	}

	public void pageRefresh(By locator) {
		objPojo.getDriver().findElement(locator).sendKeys(Keys.F5);
		// objPojo.getDriver().navigate().refresh();
		objPojo.getObjUtilitiesFunctions().logReporter("Page is Getting refreshed....", true);
	}

	// Below code will delete all cookies of your browser
	// DISCUSS WITH YOUR SUPERIOR BEFORE CALLING THIS METHOD.
	public void deleteAllBrowserCookies() {
		objPojo.getDriver().manage().deleteAllCookies();
	}

	/**
	 * Scroll element to view using javascript
	 */
	public boolean scrollToView(By locator) {
		try {
			waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			return true;
		} catch (Exception exception) {
			// exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : getText
	 * @Description : This is wrapper method to extract the text value of an
	 *              webelement : This method is used for dom
	 * 
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            textBy - String - "value" or "text"
	 * @return : text value of the passed locator
	 * @author : udchalo QA Automation Developer
	 * 
	 */
	public String getTextByUsingJavaScripts(By locator) {
		String strText = "";
		try {
			waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			JavascriptExecutor js = (JavascriptExecutor) objPojo.getDriver();
			strText = (String) js.executeScript("return arguments[0].text;", webElement);

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
		}
		return strText;
	}

	public boolean setTravellers(String noOfAdults, String noOfChildrens, String noOfInfants) {

		try {

			String strAdults = "", strChildrens = "", strInfants = "", strReturnVal = "";
			List<WebElement> allList = null;
			ArrayList<String> arrayList = new ArrayList<String>();

			By loc_locator = By.xpath("//label[text()='Travellers*']/following-sibling::input[1]");
			By loc_locTravellersPopUp = By.xpath(
					"//label[text()='Travellers*']/following-sibling::udchalo-overlaypanel/div[@class='ui-overlaypanel ui-widget ui-widget-content ui-corner-all ui-shadow']");
			By loc_List = By.xpath("//span[@class='ui-spinner ui-widget ui-corner-all']/input[@type='text']");
			By loc_Adults_Plus_Button = By.xpath("//a[text()='Adults (Above 12 years)']/following-sibling::a[1]");
			By loc_Childrens_Plus_Button = By.xpath("//a[text()='Children (2-12 years)']/following-sibling::a[1]");
			By loc_Infants_Plus_Button = By.xpath("//a[text()='Infants (Below 2 years)']/following-sibling::a[1]");

			objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locator);
			objPojo.getObjUtilitiesFunctions().logReporter("click on travellers ",
					"user can click on travellers textbox ", "user not able to click on travellers textbox",
					objPojo.getObjSeleniumFunctions().click(loc_locator));

			if (objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locTravellersPopUp)) {

				allList = objPojo.getDriver().findElements(loc_List);

				for (WebElement webElement : allList) {
					arrayList.add(webElement.getAttribute("value"));
				}
				strAdults = arrayList.get(0);
				strChildrens = arrayList.get(1);
				strInfants = arrayList.get(2);

				objPojo.getObjUtilitiesFunctions().logReporter("Default Adults in travellers ---> " + strAdults, true);
				objPojo.getObjUtilitiesFunctions().logReporter("Default Childrens in travellers ---> " + strChildrens,
						true);
				objPojo.getObjUtilitiesFunctions().logReporter("Default Infants in travellers ---> " + strInfants,
						true);

				if (Integer.parseInt(noOfAdults) > 1) {
					for (int i = 0; i < Integer.parseInt(noOfAdults) - 1; i++) {

						objPojo.getDriver().findElement(loc_Adults_Plus_Button).click();

						this.waitFor(5);
					}
				}
				if (Integer.parseInt(noOfChildrens) > 0) {
					this.waitFor(3);
					for (int i = 0; i < Integer.parseInt(noOfChildrens); i++) {

						objPojo.getDriver().findElement(loc_Childrens_Plus_Button).click();

						this.waitFor(5);
					}
				}
				if (Integer.parseInt(noOfInfants) > 0) {
					this.waitFor(5);
					for (int i = 0; i < Integer.parseInt(noOfInfants); i++) {

						objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_Infants_Plus_Button);
						objPojo.getDriver().findElement(loc_Infants_Plus_Button).click();

						this.waitFor(5);
					}

				}

			}
			this.click(loc_locator);
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_locator, "value");
			objPojo.getObjUtilitiesFunctions().logReporter("Set Travellers for search flight ", strReturnVal, true);

			return true;

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
		}
		return false;
	}

	/**
	 * @Method : setBootStrapDivText
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : udchalo QA Automation Developer
	 */
	public boolean setBootStrapInputTextDropdown(By locator, String fieldValue) {
		try {
			boolean selected = false;
			WebElement input = getElementFluent(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			this.click(locator);
			WebElement ul = input.findElement(By.xpath(".//parent::div/ul"));
			waitForPresenceOfNestedElementLocated(ul, By.xpath(".//li/span"));
			List<WebElement> list = ul.findElements(By.xpath(".//li/span"));
			System.out.println("list------------>" + list.size());
			for (WebElement expectedLink : list) {
				System.out.println("innerHTML---> " + expectedLink.getAttribute("innerHTML"));
				if (expectedLink.getAttribute("innerHTML").trim().equals(fieldValue.trim())) {
					waitAfterEachClick();
					this.checkElementDisplayed(expectedLink);
					expectedLink.click();
					selected = true;
					break;
				}
			}
			return selected;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	public boolean datePickerForInfants(By locator) {
		try {

			boolean selected = false;
			String strDate = objPojo.getObjUtilitiesFunctions().getRandomDatesFormList();
			System.out.println("strDate Date ----> " + strDate);
			By divCalendarPopup = By.xpath("//div[@class='selector alignselectorright ng-star-inserted']");
			By allActiveDatesInMonth = By.xpath(
					"//div[@class='selector alignselectorright ng-star-inserted']//table//td[@class='daycell currmonth tablesingleday ng-star-inserted']");
			By monthNextButton = By.xpath(
					"//button[@class='headerbtn icon md-caret-right headerbtnenabled'][@aria-label='Next Month']");
			By nextYearButton = By.xpath(
					"//button[@class='headerbtn icon md-caret-right headerbtnenabled'][@aria-label='Next Year']");

			objPojo.getObjUtilitiesFunctions().logReporter("Click on calendar icon", this.click(locator));
			objPojo.getObjUtilitiesFunctions().logReporter("Verify calendar popup displayed",
					this.checkElementDisplayed(divCalendarPopup));
			objPojo.getObjUtilitiesFunctions().logReporter("click on years next icon button.",
					this.click(nextYearButton));
			objPojo.getObjUtilitiesFunctions().logReporter("click on month next icon button.",
					this.click(monthNextButton));

			List<WebElement> activeDatesInMonth = objPojo.getDriver().findElements(allActiveDatesInMonth);
			System.out.println("Active dates in month counts ----> " + activeDatesInMonth.toString());

			for (WebElement expectedDateLink : activeDatesInMonth) {
				System.out.println("Active Dates---> " + expectedDateLink.getText());

				if (expectedDateLink.getText().trim().equals(strDate)) {
					this.setHighlight(expectedDateLink);
					// this.checkElementDisplayed(expectedDateLink);
					expectedDateLink.isEnabled();
					expectedDateLink.click();
					selected = true;
					break;
				}
			}
			return selected;

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * @Method : selectDropDownOption
	 * @Description : This is wrapper method select drop down element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            option - drop down element (user may specify text/value/index)
	 * @param :
	 *            selectType - select dorp down element by Text/Value/Index
	 * @author : udchalo QA Automation Developer
	 */
	public boolean selectDropDownOption(By locator, String option, String... selectType) {
		try {
			waitForElementPresence(locator);
			WebElement webElement = objPojo.getDriver().findElement(locator);
			waitForElementVisibility(webElement);
			Select sltDropDown = new Select(webElement);
			if (selectType.length > 0 && !selectType[0].equals("")) {
				if (selectType[0].equalsIgnoreCase("Value"))
					sltDropDown.selectByValue(option);
				else if (selectType[0].equalsIgnoreCase("Text"))
					sltDropDown.selectByVisibleText(option);
				else if (selectType[0].equalsIgnoreCase("Index"))
					sltDropDown.selectByIndex(Integer.parseInt(option));

				// webElement.sendKeys(Keys.TAB);
				return true;
			} else {
				// Web elements from dropdown list
				List<WebElement> options = sltDropDown.getOptions();
				boolean blnOptionAvailable = false;
				int iIndex = 0;
				for (WebElement weOptions : options) {
					if (weOptions.getText().trim().equals(option)) {
						sltDropDown.selectByIndex(iIndex);
						blnOptionAvailable = true;
						break;
					} else
						iIndex++;
				}
				// webElement.sendKeys(Keys.TAB);
				return blnOptionAvailable;
			}

		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (NotFoundException exception) {
			objPojo.setCustomException("NotFound Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotVisibleException exception) {
			objPojo.setCustomException("ElementNotVisibleException");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotInteractableException exception) {
			objPojo.setCustomException("ElementNotInteractableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (ElementNotSelectableException exception) {
			objPojo.setCustomException("ElementNotSelectableException Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	// 11 Oct 19

	/**
	 * @Method : setBootStrapDivText
	 * @Description : This is wrapper method to set text for input element
	 * @param :
	 *            locator - By identification of element
	 * @param :
	 *            fieldValue - field value as string
	 * @return : - true if text entered successfully
	 * @author : udchalo QA Automation Developer
	 */
	public boolean setBootStrapInputTextForAdmin(By locator, String fieldValue) {
		try {
			boolean selected = false;
			WebElement input = getElementFluent(locator);
			this.setHighlight(objPojo.getDriver().findElement(locator));
			this.click(locator);
			WebElement ul = input.findElement(By.xpath(".//ancestor::div/ul[2]"));
			waitForPresenceOfNestedElementLocated(ul, By.xpath(".//li/span"));
			List<WebElement> list = ul.findElements(By.xpath(".//li/span"));
			System.out.println("list------------>" + list.size());
			for (WebElement expectedLink : list) {
				System.out.println("innerHTML---> " + expectedLink.getAttribute("innerHTML"));
				if (expectedLink.getAttribute("innerHTML").trim().equals(fieldValue.trim())) {
					waitAfterEachClick();
					this.scrollToView(expectedLink);
					this.setHighlight(expectedLink);
					expectedLink.click();
					selected = true;
					break;
				}
			}
			return selected;
		} catch (NoSuchElementException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got no such " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (TimeoutException exception) {
			objPojo.setCustomException("Timeout & NoSuchElement Exception");
			System.out.println("I got timeout " + exception.getMessage());
			exception.printStackTrace();
			return false;
		} catch (Exception exception) {
			objPojo.setCustomException("NoSuchElement Exception");
			exception.printStackTrace();
			return false;
		}
	}

	/**
	 * Scroll element to view using javascript
	 */
	public boolean scrollToView(WebElement webElement) {
		try {
			this.waitForElementVisibility(webElement);
			((JavascriptExecutor) objPojo.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
			return true;
		} catch (Exception exception) {
			// exception.printStackTrace();
			return false;
		}
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

	}

}