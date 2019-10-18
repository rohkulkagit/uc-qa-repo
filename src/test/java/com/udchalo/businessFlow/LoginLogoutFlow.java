package com.udchalo.businessFlow;


import com.udchalo.generic.Pojo;
import com.udchalo.pageFactory.FlightSearchPage;
import com.udchalo.pageFactory.HomePage;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @ScriptName : LoginLogoutFlow
 * @Description : This class covers all the flight booking flows
 * 
 * @Author : udchalo QA Automation Developer
 * @since : 25-July-2019
 */
public class LoginLogoutFlow {

	// Global Variables
	private Pojo objPojo;
	private String testData = "";
	
	// Reference object of Pages
	private HomePage objHomePage;
	

	public LoginLogoutFlow(Pojo pojo) {
		this.objPojo = pojo;
		objHomePage = new HomePage(objPojo);	
	}
	
	/**
	 * @MethodName:	 gotoLoginWithEmailPage
	 * @Description: This method select login via password option
	 * @since:		 23-Aug-2019
	 * @author : 	 udChalo QA Automation developer
	 */
	@Step("Steps Details --> " + "Go to Login With Email popup")
	public void gotoLoginWithEmailMobilePage(){
		objHomePage.click_SignUpLogin_Button();
		objHomePage.click_PopUpWindow_Login_Button();
		objHomePage.select_LoginVia_Password();
	}


	/**
	 * @MethodName:	 doLoginViaPassword
	 * @Description: This method enters emailid & password and click on login
	 * @since:		 23-Aug-2019
	 * @author : 	 udChalo QA Automation developer
	 */
	@Step("Steps Details --> " + "Enter email & password and click on login")
	public void doLoginViaPassword() {
				
		testData=objPojo.getObjUtilitiesFunctions().dataManagerString("loginid");
		if (!testData.equals(""))
			objHomePage.set_Email_Address(testData);
	
		testData=objPojo.getObjUtilitiesFunctions().dataManagerString("password");
		if (!testData.equals(""))
			objHomePage.set_Email_Password(testData);
	
		objHomePage.click_doLogin();
		
	}

	/**
	 * @MethodName:	 showUserProfileMenu
	 * @Description: This method shows user profile dropdown menu
	 * @since:		 23-Aug-2019
	 * @author : 	 udChalo QA Automation developer
	 */

	@Step("Steps Details --> " + "Show user profile menu")
	public void showUserProfileMenu(){
		objHomePage.mouseHover_userName();
	}
	
	/**
	 * @MethodName:	 checkIfLoggedIn
	 * @Description: This method checks if user has logged in
	 * @since:		 23-Aug-2019
	 * @author : 	 udChalo QA Automation developer
	 */
	@Step("Steps Details --> " + "Check whether logged in")
	public void checkIfLoggedIn(){
		objHomePage.IsVisibleLogoutButton();
		objPojo.getObjUtilitiesFunctions().logReporter("Logged in successfully", true);
	}
	

	/**
	 * @MethodName:	 doLogout
	 * @Description: This method helps user to logout
	 * @since:		 23-Aug-2019
	 * @author : 	 udChalo QA Automation developer
	 */
	@Step("Steps Details --> " + "Logout application")
	public void doLogout(){
		
		objHomePage.mouseHover_userName();
		objHomePage.verify_user_loggedIn_Successfully();
		objHomePage.click_linkLogout();	
	}
	
	/**
	 * @MethodName:	 checkInvalidUserErrorMessage
	 * @Description: This method verifies error message thrown by the system
	 * @since:		 23-Aug-2019
	 * @author : 	 udChalo QA Automation developer
	 */
	@Step("Steps Details --> " + "Verify Error message if unregistered user logs in")
	public void checkInvalidUserErrorMessage(){
		testData=objPojo.getObjUtilitiesFunctions().dataManagerString("expectedErrorMessage");
		if (!testData.equals(""))
		objHomePage.IsVisibleInvalidUserErrorMessage(testData);
		objHomePage.IsInVisibleLogoutButton();
		
	}
	
	
	
	
}
