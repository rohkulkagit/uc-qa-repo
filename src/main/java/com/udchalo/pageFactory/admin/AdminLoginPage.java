package com.udchalo.pageFactory.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;

public class AdminLoginPage {
	
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

				
				public AdminLoginPage(Pojo pojo) {
					this.objPojo = pojo;
				}
			
		
				By loc_inp_Email=By.xpath("//label[text()='Email*']/preceding-sibling::input[@formcontrolname='email']");
				By loc_inp_Password=By.xpath("//label[text()='Password*']/preceding-sibling::input[@formcontrolname='password']");
				By loc_btn_Login=By.xpath("//span[text()='Log In ']/parent::button[@type='submit']");
				By loc_iconLogo=By.xpath("//div[@class='navbar-brand navbar-brand-center site-gridmenu-toggle']/img[@class='navbar-brand-logo']");
				By loc_mouseHovarAdminProfile=By.xpath("//span[@class='avatar avatar-online']/parent::a[@class='navbar-avatar dropdown-toggle']");
				By loc_lnk_Logout=By.xpath("//  a[contains(.,' Logout')]");
				
				public void setUserEmailID(String strEmailID) {
					objPojo.getObjUtilitiesFunctions().logReporter("Set user name", strEmailID,
							objPojo.getObjSeleniumFunctions().setText(loc_inp_Email, strEmailID));
				}

				public void setUserPassword(String strPassword) {
					objPojo.getObjUtilitiesFunctions().logReporter("Set password", strPassword,
							objPojo.getObjSeleniumFunctions().setText(loc_inp_Password, strPassword));
				}

				public void clickLogIn() {
					objPojo.getObjUtilitiesFunctions().logReporter("Click 'Login' button",
							objPojo.getObjSeleniumFunctions().click(loc_btn_Login));
				}

				public void waitForApplicationLoginPageLoad() {

					if (objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_iconLogo)) {
						System.out.println("Url Page load Successfully.");

						if (objPojo.getObjSeleniumFunctions().checkElementPresence(loc_iconLogo)) {
							objPojo.getObjUtilitiesFunctions().logReporter("Verify pageload successfully.", true);

						}
					} else {

						objPojo.getObjUtilitiesFunctions().logReporter("Verify page load..", true);
					}

				}
				
				public void mouseHover_UserAdminProfile(){
					
					objPojo.getObjUtilitiesFunctions().logReporter("MouseHover over user profile ", "User can mouse hover on the user profile.", "Cannot mouse over on the user profile.", objPojo.getObjSeleniumFunctions().mouseHover(loc_mouseHovarAdminProfile));
					
				}
				
				public void verify_Admin_user_loggedIn_Successfully(){
					objPojo.getObjSeleniumFunctions().waitFor(3);
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnk_Logout);
					strReturnVal=objPojo.getObjSeleniumFunctions().getTextByUsingJavaScripts(loc_lnk_Logout);
					objPojo.getObjUtilitiesFunctions().logReporter("Verify Admin user logged into the system successfully.","user can see the 'logout' button.","user not able to see 'logout' button", strReturnVal.trim().equals("Logout"));

				}
				
				
				public void click_linkLogout(){
					objPojo.getObjSeleniumFunctions().waitFor(3);
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnk_Logout);
					objPojo.getObjUtilitiesFunctions().logReporter("Click on logout link in admin application ","user can click 'logout' button.","user not able to click on 'logout' button", objPojo.getObjSeleniumFunctions().click(loc_lnk_Logout) );
				}
				
				
				

}
