package com.udchalo.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.udchalo.generic.Pojo;
/**
 * @ScriptName    : HomePage
 * @Description   : This class is dedicated for HomePage of udchalo.com.
 * 					It contains xpath of all the elements & its related methods
 * @Author        : udchalo QA Automation Developer
 * @since         : 05-Aug-2019
 */

public class HomePage {
	
	// Global Variables
		private Pojo objPojo;
		private String strUniqueKey = "";
		private String strTestData = ""; 
		private String strReturnVal = "";
		private int intReturnVal = 0;
		private boolean blnReturnStatus = false;
		private double dblReturnVal = 0.0;
		private List<WebElement> listReturnElement;
		private WebElement weReturnElement;
		private int intRow = 0;
		private int intColumn = 0;

		
		public HomePage(Pojo pojo) {
			this.objPojo = pojo;
		}
	
	
	//locators
	By loc_btnLoginSignUp=By.xpath("//a[text()='Blog']/following-sibling::a[text()=' Login / Sign Up']");
	
	By loc_btnLoginInPopUp=By.xpath("//a[text()=' Sign Up']/preceding-sibling::a[text()='Log In']");
	
	By loc_rbLoginViaPassword=By.xpath("//input[@id='login_email']/parent::div/label[contains(.,'Login Via Password')]");
	
	By loc_inpEmailAddress=By.xpath("//input[@type='email']");
		
	By loc_inpPassword=By.xpath("//input[@type='password']");
	By loc_btnLoginButtonOnPopUpWindow=By.xpath("//span[text()='LogIn ']/parent::button[1]");
	By loc_chkImFromTheDefenceForces=By.xpath("//div[@class='control--checkbox text--align--left']/input[@id='isDefenceSearch'][@type='checkbox']/parent::div[1]");
	By loc_btnSearchFlights=By.xpath("//button[@type='`button']/span[text()='Search Flights ']");
	
	By loc_linkUserName=By.xpath("//div[contains(@class,'nav__item nav__item--signup')]");	
	By loc_linkLogOut = By.xpath("//li[contains(@class, 'nav__dropdown')]//a[text()='Log Out ']");
	By loc_messageErrorInvalidUser = By.xpath("//div[@id='toast-container']//div//div[contains(text(),'email/password is not valid')]");
	
	By loc_inpOrigin=By.xpath("//label[text()='Origin*']/following::span[1]/input[@type='text']");
	By loc_inpDestination=By.xpath("//label[text()='Destination*']/following::span[1]/input[@type='text']");
	By loc_inpTravellers=By.xpath("//label[text()='Travellers*']/following-sibling::input[1]");
	
	By loc_chkI_Am_From_The_Defence_Forces=By.xpath("//input[@id='isDefenceSearch'][@type='checkbox']");
	
	By loc_lnkFlight=By.xpath("//a[text()='Flights'][@routerlink='/flights']");
	By loc_UserProfile=By.xpath("//div[@class='profileCredits'][1]");
	
	By loc_txtOrigin=By.xpath("//label[text()='Origin*']");
	By loc_txt_Destination=By.xpath("//label[text()='Destination*']");
	By loc_txt_TravelDate=By.xpath("//label[text()='Travel Date*']");
	By loc_txt_Travellers=By.xpath("//label[text()='Travellers*']");
	By loc_txt_OriginMandatoryMsg=By.xpath("//label[text()='Origin*']/parent::div//div[text()='This field  is required.']");
	By loc_txt_DestinationMandatoryMsg=By.xpath("//label[text()='Destination*']/parent::div//div[text()='This field  is required.']");
	By loc_txt_TravelDateMandatoryMsg=By.xpath("//label[text()='Travel Date*']/parent::div//div[text()='This field  is required.']");
	By loc_txt_OnwardDate=By.xpath("//label[text()='Onward Date*']");
	By loc_txt_ReturnDate=By.xpath("//label[text()='Return Date*']");
	By loc_txt_OnwardDateErrorMsg=By.xpath("//label[text()='Onward Date*']/parent::div//div[text()='This field  is required.']");
	By loc_txt_ReturnDateErrorMsg=By.xpath("//label[text()='Return Date*']/parent::div//div[text()='This field  is required.']");

	By loc_icon_TravelDate=By.xpath("//label[text()='Travel Date*']/following::div//i[@class='fa fa-calendar']");
	By loc_icon_ForwardAndBackwardArrow=By.xpath("//label[text()='Origin*']/following::span[1]/input[@type='text']/ancestor::div[1]/following-sibling::i[1]");
	
	By loc_locatorOnward =By.xpath("//label[text()='Onward Date*']/following::div//i[@class='fa fa-calendar']");
	By loc_locatorReturn=By.xpath("//label[text()='Return Date*']/following::div//i[@class='fa fa-calendar']");
	
	
	//methods	
	public void click_SignUpLogin_Button(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("click SignUpLogin button ","user can click 'Signup/Login' button should clickable","user not able to click 'Signup/Login' button.", objPojo.getObjSeleniumFunctions().click(loc_btnLoginSignUp) );

	}
	
	public void click_PopUpWindow_Login_Button(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("click popup window login button ","user can click 'login' button on popup window.","user not able to click 'login' button on popup window.", objPojo.getObjSeleniumFunctions().click(loc_btnLoginInPopUp) );

	}
	
	
	public void select_LoginVia_Password(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("select radio button 'login via password'.","user can select 'login via password' radio button ","user not able to select 'login via password' radio button ", objPojo.getObjSeleniumFunctions().click(loc_rbLoginViaPassword));

	}
	
	public void set_Email_Address(String strEmailAddress){
		
		objPojo.getObjUtilitiesFunctions().logReporter("set email address : ", strEmailAddress, objPojo.getObjSeleniumFunctions().setText(loc_inpEmailAddress, strEmailAddress));
		
	}
	
	public void set_Email_Password(String strEmailPassword){
		
		objPojo.getObjUtilitiesFunctions().logReporter("set password : ", strEmailPassword, objPojo.getObjSeleniumFunctions().setText(loc_inpPassword, strEmailPassword));

	}
	
	public void click_doLogin(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("click login button for login into the system ","user can click on 'login' button on popup window.","user not able to click on 'login' button on popup window.", objPojo.getObjSeleniumFunctions().click(loc_btnLoginButtonOnPopUpWindow) );

	}
	
	public void mouseHover_userName(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("MouseHover over user profile ", "User can mouse hover on the user profile.", "Cannot mouse over on the user profile.", objPojo.getObjSeleniumFunctions().mouseHover(loc_linkUserName));
		
	}
	
	public void verify_user_loggedIn_Successfully(){
		
		strReturnVal=objPojo.getObjSeleniumFunctions().getTextByUsingJavaScripts(loc_linkLogOut).trim();
		objPojo.getObjUtilitiesFunctions().logReporter("Verify user logged into the system successfully.","user can see the 'logout' button.","user not able to see 'logout' button", strReturnVal.trim().equals("Log Out"));

	}
	
	public void IsVisibleLogoutButton(){
		strReturnVal=objPojo.getObjSeleniumFunctions().getTextByUsingJavaScripts(loc_linkLogOut).trim();
		objPojo.getObjUtilitiesFunctions().logReporter("Logout button present.  ","user can see the 'logout' button.","user not able to see 'logout' button",strReturnVal.trim().equals("Log Out"));
	}
	
	public void IsInVisibleLogoutButton(){
		objPojo.getObjUtilitiesFunctions().logReporter("Logout button not present.  ","user can not see 'logout' button","user can see the 'logout' button",objPojo.getObjSeleniumFunctions().checkElementNOTDisplayed(loc_linkLogOut));
	}
	
	
	public void click_linkLogout(){
		objPojo.getObjUtilitiesFunctions().logReporter("Click on logout link ","user can click 'logout' button.","user not able to click on 'logout' button", objPojo.getObjSeleniumFunctions().click(loc_linkLogOut) );
		objPojo.getObjSeleniumFunctions().waitFor(2);
	}
	
	
	public void select_Trip_Type_OneWay_or_Round(String locTripTypeID,String journeytype){
		
		By loc_locator=By.xpath("//form[@id='searchFlights']//input[@id='"+locTripTypeID+"']/following-sibling::label[1]");
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locator);
		objPojo.getObjUtilitiesFunctions().logReporter("Verify trip type radion button is enabled ", objPojo.getObjSeleniumFunctions().checkElementEnabled(loc_locator));
		if(objPojo.getObjSeleniumFunctions().isRadioButtonSelected(loc_locator))
			objPojo.getObjUtilitiesFunctions().logReporter("oneway trip radio button is already selected.", journeytype,true);
		
		objPojo.getObjUtilitiesFunctions().logReporter("Select trip type By loc_radio button ",journeytype, objPojo.getObjSeleniumFunctions().selectRadioButton(loc_locator, true));
	}
	
	
	public void set_Origin_On_HomePage(String origin){
			
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inpOrigin);
		objPojo.getObjUtilitiesFunctions().logReporter("set origin on home page", origin, objPojo.getObjSeleniumFunctions().setBootStrapInputText(loc_inpOrigin, origin));
	}
		
		
	public void set_Destination_On_HomePage(String destination){
	
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inpDestination);
		objPojo.getObjUtilitiesFunctions().logReporter("set destination on home page", destination, objPojo.getObjSeleniumFunctions().setBootStrapInputText(loc_inpDestination, destination));

		}
	
	public void set_Traveldate(String date){
	
	}
	
	/*public void set_Travellers(String noOfAdults,String noOfChildren, String noOfInfants){
		
		By loc_locator=By.xpath("//label[text()='Travellers*']/following-sibling::input[1]");
		By loc_locTravellersPopUp=By.xpath("//label[text()='Travellers*']/following-sibling::udchalo-overlaypanel/div[@class='ui-overlaypanel ui-widget ui-widget-content ui-corner-all ui-shadow']");
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locator);
		strReturnVal=objPojo.getObjSeleniumFunctions().getText(loc_locator, "text");
		System.out.println("return Val ---> "+strReturnVal);	
	}*/
	
public void set_Travellers(String noOfAdults,String noOfChildrens, String noOfInfants){
		
		objPojo.getObjUtilitiesFunctions().logReporter("Set Travellers on homepage for serach flight.", "Adults : "+noOfAdults + "Childrens : " +noOfChildrens +"Infants : "+ noOfInfants, objPojo.getObjSeleniumFunctions().setTravellers(noOfAdults, noOfChildrens, noOfInfants));
	}

	

	public void setDate_For_Oneway_Trip(String strNoOfFutureDayFromCurrentDate){
		
		By loc_locator =By.xpath("//label[text()='Travel Date*']/following::div//i[@class='fa fa-calendar']");
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locator);
		objPojo.getObjUtilitiesFunctions().logReporter("set date for one way trip ", strNoOfFutureDayFromCurrentDate, objPojo.getObjSeleniumFunctions().datePicker(loc_locator, strNoOfFutureDayFromCurrentDate));
		
		
	}
	
	
	public void setDate_For_Round_Trip(String strNoOfFutureDayFromCurrentDateForOnward,String strNoOfFutureDayFromCurrentDateForReturn){
		
		By loc_locatorOnward =By.xpath("//label[text()='Onward Date*']/following::div//i[@class='fa fa-calendar']");
		By loc_locatorReturn=By.xpath("//label[text()='Return Date*']/following::div//i[@class='fa fa-calendar']");
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorOnward);
		objPojo.getObjUtilitiesFunctions().logReporter("set onward date for round trip ", strNoOfFutureDayFromCurrentDateForOnward, objPojo.getObjSeleniumFunctions().datePicker(loc_locatorOnward, strNoOfFutureDayFromCurrentDateForOnward));
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorReturn);
		objPojo.getObjUtilitiesFunctions().logReporter("set return date for round trip ", strNoOfFutureDayFromCurrentDateForReturn, objPojo.getObjSeleniumFunctions().datePickerReturn(loc_locatorReturn, strNoOfFutureDayFromCurrentDateForReturn));
		
	}
		

	public void setDefenceCategory(String Category){
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_chkI_Am_From_The_Defence_Forces);
		objPojo.getObjUtilitiesFunctions().logReporter("deselect I am from the defence checkbox", Category, objPojo.getObjSeleniumFunctions().selectCheckBox(loc_chkI_Am_From_The_Defence_Forces, false));
	}
	
	public void click_SearchFlights(){
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnSearchFlights);
		objPojo.getObjUtilitiesFunctions().logReporter("click Search Flights button on home page ", objPojo.getObjSeleniumFunctions().click(loc_btnSearchFlights) );
	}

	public void IsVisibleInvalidUserErrorMessage(String expectedErrorMessage){
		
		System.out.println("IsVisibleInvalidUserErrorMessage");
		objPojo.getObjSeleniumFunctions().waitFor(2);
		
		objPojo.getObjUtilitiesFunctions().logReporter("Error Message appeared ",objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_messageErrorInvalidUser));
		
		String actualError = objPojo.getObjSeleniumFunctions().getText(loc_messageErrorInvalidUser);
		boolean flag = expectedErrorMessage.trim().equalsIgnoreCase(actualError);
		objPojo.getObjUtilitiesFunctions().logReporter("Checking error message", expectedErrorMessage,	actualError, flag);
		
	}
	
	
	public boolean beforeMethodtoVerifyHomePageHeader() {
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnkFlight);
		return objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnkFlight);
	}
	
	public void beforeMethod_Click_Logo() {
		By loc_logo_Locator=By.xpath("//a[text()='Flights']/ancestor::div[@class='header desktop-only']//a[@class='logo-top active' and @routerlinkactive='active']");
		objPojo.getObjUtilitiesFunctions().logReporter("click 'Flight' tab ", objPojo.getObjSeleniumFunctions().click(loc_logo_Locator));
	}
	

	
	
	// This method waits for load after search flight spinner to disappear
		public void waitForGettingMoreFlightsSpinnerToDisappear() {
			
			By primaryLoaderLocator=By.xpath("//div[@class='search--results--section search--results--loading ng-star-inserted']");
			By secondaryLoaderLocator=By.xpath("//p[text()='Getting more flights...' or text()='Hold on...']");
			
			if (objPojo.getObjSeleniumFunctions().checkElementVisibile(primaryLoaderLocator)) {
				if (objPojo.getObjSeleniumFunctions().checkElementInVisibile(primaryLoaderLocator))
					objPojo.getObjUtilitiesFunctions().logReporter("Verify please wait while we find best flight option for your search spinner is disappeared", true);
				else if (objPojo.getObjSeleniumFunctions().checkElementVisibile(secondaryLoaderLocator))
					if(objPojo.getObjSeleniumFunctions().checkElementInVisibile(secondaryLoaderLocator))
						objPojo.getObjUtilitiesFunctions().logReporter("Verify getting more flights single line loader is disappeared", true);
				else
					objPojo.getDriver().navigate().refresh();
					objPojo.getObjUtilitiesFunctions().logReporter("Page is Getting refreshed....", true);
					objPojo.getObjUtilitiesFunctions().logReporter("Verify please wait while we find best flight option for your search spinner is disappeared",
							"waiting for "+objPojo.getObjConfig().getProperty("spinner.wait")+" sec", true);
				
			} else {
				objPojo.getObjUtilitiesFunctions().logReporter("Verify getting more flights loader is disappeared", true);
			}
		}
	
	
	
		/* Verify * mandatory field in Origin- By Yogesh */
		public void verifyOriginMandatoryField(){
			strReturnVal= objPojo.getObjSeleniumFunctions().getText(loc_txtOrigin,"text");
			blnReturnStatus=strReturnVal.endsWith("*");
			objPojo.getObjUtilitiesFunctions().logReporter("Verify '*' astriks symbol in Origin field.","Astricks '*' should present in origin mandatory field on flight home page. ","Astricks '*' not displayed in origin mandatory fields on flight home page.", blnReturnStatus);
			objPojo.getObjUtilitiesFunctions().logReporter("Verify Origin filed on flight home page.", "User can see 'Origin' fields on flight home page.", "User not able to see 'Origin' field on flight home page.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inpOrigin));
		}
		
		/* Verify * mandatory field in Destination- By Yogesh */
		public void verifyDestinationMandatoryField(){
			
			strReturnVal= objPojo.getObjSeleniumFunctions().getText(loc_txt_Destination,"text");
			blnReturnStatus=strReturnVal.endsWith("*");
			objPojo.getObjUtilitiesFunctions().logReporter("Verify '*' astriks symbol in Destination field.","Astricks '*' should present in Destination mandatory field on flight home page. ","Astricks '*' not displayed in Destination mandatory fields on flight home page.", blnReturnStatus);
			objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Destination' filed on flight home page.", "User can see 'Destination' fields on flight home page.", "User not able to see 'Destination' field on flight home page.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inpDestination));
			
		}
		
		/* Verify * mandatory field in travel date- By Yogesh */
		public void verifyTravelDateMandatoryField(){
			
			strReturnVal= objPojo.getObjSeleniumFunctions().getText(loc_txt_TravelDate,"text");
			blnReturnStatus=strReturnVal.endsWith("*");
			objPojo.getObjUtilitiesFunctions().logReporter("Verify '*' astriks symbol in Travel Date field.","Astricks '*' should present in travel Date mandatory field on flight home page. ","Astricks '*' not displayed in Travel date mandatory fields on flight home page.", blnReturnStatus);
			objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Travel Date' filed on flight home page.", "User can see 'Travel Date' fields on flight home page.", "User not able to see 'Travel Date' field on flight home page.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_icon_TravelDate));
			
			
		}
		
		/* Verify * mandatory field in Travellers details - By Yogesh */
		public void verifyTravellersMandatoryField(){
			
			strReturnVal= objPojo.getObjSeleniumFunctions().getText(loc_txt_Travellers,"text");
			blnReturnStatus=strReturnVal.endsWith("*");
			objPojo.getObjUtilitiesFunctions().logReporter("Verify '*' astriks symbol in travellers field.","Astricks '*' should present in travellers mandatory field on flight home page. ","Astricks '*' not displayed in travellers mandatory fields on flight home page.", blnReturnStatus);
			objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Travellers' filed on flight home page.", "User can see 'Travellers' fields on flight home page.", "User not able to see 'Travellers' field on flight home page.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inpTravellers));
			
		}
		
		/* Get Origin Mandatory field error Message- By Yogesh */
		public String getOriginMandatoryFieldErrorMessage() {
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_txt_OriginMandatoryMsg, "text");
			objPojo.getObjUtilitiesFunctions().logReporter("Get 'Origin' mandatory field error message.", strReturnVal, !strReturnVal.equals(""));
			return strReturnVal;
		}
		
		/* Get Destination Mandatory field error Message- By Yogesh */
		public String getDestinationMandatoryFieldErrorMessage() {
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_txt_DestinationMandatoryMsg, "text");
			objPojo.getObjUtilitiesFunctions().logReporter("Get 'Destination' mandatory field error message.", strReturnVal, !strReturnVal.equals(""));
			return strReturnVal;
		}
		
		/* Get Travel Date Mandatory field error Message- By Yogesh */
		public String getTravelDateMandatoryFieldErrorMessage() {
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_txt_TravelDateMandatoryMsg, "text");
			objPojo.getObjUtilitiesFunctions().logReporter("Get 'Travel Date' mandatory field error message.", strReturnVal, !strReturnVal.equals(""));
			return strReturnVal;
		}
		
		
		/* Verify travel date datepicker icon for oneway and round trip- By Yogesh */
		public void verifyTravelDate_DatePickerIcon_For_OnewayAndRoundTrip(String strTripType){
			
			By loc_locator =By.xpath("//label[text()='Travel Date*']/following::div//i[@class='fa fa-calendar']");
			By loc_locatorOnward =By.xpath("//label[text()='Onward Date*']/following::div//i[@class='fa fa-calendar']");
			By loc_locatorReturn=By.xpath("//label[text()='Return Date*']/following::div//i[@class='fa fa-calendar']");
			

			
			if(strTripType.toLowerCase().equals("oneway")){
				
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locator);
				objPojo.getObjUtilitiesFunctions().logReporter("Verify travel date for oneway trip on search flight home page. ", "user can see only one datepicker icon for 'oneway' trip on search flight home page.", "user not able to see only one datepicker icon for 'oneway' trip on search flight home page", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locator));
				
			}else {
				
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorOnward);
				objPojo.getObjUtilitiesFunctions().logReporter("Verify travel date for round trip on search flight home page. ", "user can see onward datepicker icon for 'round' trip on search flight home page.", "user not able to see 'onward' datepicker icon for 'round' trip on search flight home page", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorOnward));
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorReturn);
				objPojo.getObjUtilitiesFunctions().logReporter("Verify travel date for round trip on search flight home page. ", "user can see Return datepicker icon for 'round' trip on search flight home page.", "user not able to see 'Return' datepicker icon for 'round' trip on search flight home page", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorReturn));
				
			}
		}
		
		
		/* Verify * mandatory field in onward date- By Yogesh */
		public void verifyOnwardDateMandatoryField(){
			
			strReturnVal= objPojo.getObjSeleniumFunctions().getText(loc_txt_OnwardDate,"text");
			blnReturnStatus=strReturnVal.endsWith("*");
			objPojo.getObjUtilitiesFunctions().logReporter("Verify '*' astriks symbol in 'Onward' date field.","Astricks '*' should present in 'Onward' date mandatory field on flight home page. ","Astricks '*' not displayed in 'Onward' date mandatory fields on flight home page.", blnReturnStatus);
			objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Onward' date filed on round trip flight home page.", "User can see 'Onward' date fields on round trip flight home page.", "User not able to see 'Onward' date field on round trip flight home page.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorOnward));
			
		}
		
		/* Verify * mandatory field in return date- By Yogesh */
		public void verifyReturnDateMandatoryField(){
			
			strReturnVal= objPojo.getObjSeleniumFunctions().getText(loc_txt_ReturnDate,"text");
			blnReturnStatus=strReturnVal.endsWith("*");
			objPojo.getObjUtilitiesFunctions().logReporter("Verify '*' astriks symbol in 'Return' date field.","Astricks '*' should present in 'Return' date mandatory field on flight home page. ","Astricks '*' not displayed in 'Return' date mandatory fields on flight home page.", blnReturnStatus);
			objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Return' date filed on round trip flight home page.", "User can see 'Return' date fields on round trip flight home page.", "User not able to see 'Return' date field on round trip flight home page.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_locatorReturn));
			
		}
		
		/* Get Onward Date Mandatory field error Message- By Yogesh */
		public String getOnwardDateMandatoryFieldErrorMessage() {
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_txt_OnwardDateErrorMsg, "text");
			objPojo.getObjUtilitiesFunctions().logReporter("Get 'Onward Date' mandatory field error message.", strReturnVal, !strReturnVal.equals(""));
			return strReturnVal;
		}
		
		/* Get Return Date Mandatory field error Message- By Yogesh */
		public String getReturnDateMandatoryFieldErrorMessage() {
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_txt_ReturnDateErrorMsg, "text");
			objPojo.getObjUtilitiesFunctions().logReporter("Get 'Return Date' mandatory field error message.", strReturnVal, !strReturnVal.equals(""));
			return strReturnVal;
		}
	
		/* Common click on desktop header menu link tab on home page- By Yogesh */
		public void commonClickHeaderDesktopTabs(String strApplicationName){
			By loc_lnk_DesktopUpperTab=By.xpath("//div[@class='header desktop-only']//ul/li/a[text()='"+strApplicationName+"']");
			objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnk_DesktopUpperTab);
			objPojo.getObjUtilitiesFunctions().logReporter("click on desktop header link  tab on flight home page.", "user can click on desktop header links tab on home page.", "user not able to click on desktop header link tab on home page.", objPojo.getObjSeleniumFunctions().click(loc_lnk_DesktopUpperTab));
		
		}
		
		/* click on forward and backword arrow in between Origin and Destination on home page- By Yogesh */
		public void clickForwardAndBackwardArrowInBetweenOriginAndDestination(){
			
			objPojo.getObjUtilitiesFunctions().logReporter("click on forward and backward arrow.", "user can click on forward and backward arrow on flight home page.", "user not able to click forward and backward arrow on flight home page.", objPojo.getObjSeleniumFunctions().click(loc_icon_ForwardAndBackwardArrow));
		}
		
		
		/* Get Origin name on flight home page- By Yogesh */
		public String getOriginName() {
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_inpOrigin, "value");
			objPojo.getObjUtilitiesFunctions().logReporter("Get 'Origin' name on flight home page.", strReturnVal, !strReturnVal.equals(""));
			return strReturnVal;
		}
		
		/* Get Destination name on flight home page- By Yogesh */
		public String getDestinationName() {
			strReturnVal = objPojo.getObjSeleniumFunctions().getText(loc_inpDestination, "value");
			objPojo.getObjUtilitiesFunctions().logReporter("Get 'Destination' name on flight home page.", strReturnVal, !strReturnVal.equals(""));
			return strReturnVal;
		}
		
		
		
}
