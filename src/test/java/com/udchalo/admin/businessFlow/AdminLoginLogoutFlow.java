package com.udchalo.admin.businessFlow;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.udchalo.generic.Pojo;
import com.udchalo.pageFactory.admin.AdminLoginPage;
import ru.yandex.qatools.allure.annotations.Step;

public class AdminLoginLogoutFlow {
	
	// Global Variable
		private Pojo objPojo;
		private String strUniqueKey = "";
		private String testData = "", testData2 = "";
		private Integer intTestData = null;
		private String strReturnVal = "";
		private int intReturnVal = 0;
		private boolean blnReturnStatus = false;
		private double dblReturnVal = 0.0;
		private List<WebElement> listReturnElement;
		private WebElement weReturnElement;
		private int intRow = 0;
		private int intColumn = 0;

		// Reference object of Pages
		private AdminLoginPage objAdminLoginPage;
	

		// Constructor of class
		public AdminLoginLogoutFlow(Pojo pojo) {
			this.objPojo = pojo;
			objAdminLoginPage = new AdminLoginPage(objPojo);
			
		}
		
		
		/**
		 * @MethodName:	 doLoginViaPassword
		 * @Description: This method enters emailid & password and click on login
		 * @since:		 10-Oct-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Admin application Login into the system.")
		public void doAdminLogin() {
					
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("AdminLoginid");
			if (!testData.equals(""))
				objAdminLoginPage.setUserEmailID(testData);
		
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("AdminPassword");
			if (!testData.equals(""))
				objAdminLoginPage.setUserPassword(testData);
		
			objAdminLoginPage.clickLogIn();
			objAdminLoginPage.waitForApplicationLoginPageLoad();
		}
		
		
		
		@Step("Steps Details --> " + "Verify Admin user loggedIn Successfully.")
		public void verifyAdminUserLoggedInSUccessfully(){
			
			objAdminLoginPage.mouseHover_UserAdminProfile();
			objAdminLoginPage.verify_Admin_user_loggedIn_Successfully();
		}
		
		/**
		 * @MethodName:	 doLogout
		 * @Description: This method helps user to logout
		 * @since:		 10-OCT-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Logout Admin application")
		public void doLogout(){
			
			objAdminLoginPage.mouseHover_UserAdminProfile();
			objAdminLoginPage.click_linkLogout();
		}
		
		
		
			
	}
