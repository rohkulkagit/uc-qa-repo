package com.udchalo.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.udchalo.businessFlow.LoginLogoutFlow;
import com.udchalo.businessFlow.commonFlow.CommonFlow;
import com.udchalo.generic.BaseTest;
import com.udchalo.pageFactory.HomePage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Features("Feature ---> Login and Logout")
public class LoginTest extends BaseTest {


		// Global variables

			private  HomePage objHomePage;
			private  LoginLogoutFlow objLoginLogoutFlow;
			private CommonFlow objCommonFlow;
			

			// Initialize Views
			public void initializeViewsAndPages() {
				objHomePage=new HomePage(this);
				objLoginLogoutFlow=new LoginLogoutFlow(this);
				objCommonFlow=new CommonFlow(this);
			}

			@BeforeClass(groups = { "P1", "P2", "P3" })
			public void initializeEnvironment() {
				this.initializeWebEnvironment("excel/AutomationTestDataInput");
				this.initializeViewsAndPages();
			}

			
			@AfterClass(groups = { "P1", "P2", "P3" })
			public void tearDownEnvironment() {
				this.tearDownWebEnvironment();
				objHomePage = null;
				objLoginLogoutFlow = null;
				
			}
			
			 @BeforeMethod
			  public void redirect_Me_To_HomePage_On_udChalo_Application() {
				  
				 if (!objHomePage.beforeMethodtoVerifyHomePageHeader())
						objCommonFlow.refreshWholePageF5();
				 
			  }
			 

			@Title("TCID101_LoginUsingEmailIdValidCase")
			@Severity(SeverityLevel.BLOCKER)
			@Description("Test Case Description --> " + "Verify Login using valid email id and password.")
			@Test(priority = 1,description="Verify user login into the system.")
			@Stories("Story Name --> "+ "To check login functionality.")
			public void TCID101_LoginUsingEmailIdValidCase() {
				this.loadTestData("TCID101_LoginUsingEmailIdValidCase");
				
				objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
				objLoginLogoutFlow.doLoginViaPassword();	
				objLoginLogoutFlow.showUserProfileMenu();
				objLoginLogoutFlow.checkIfLoggedIn();
			}

			@Title("TCID102_VerifyLogout")
			@Severity(SeverityLevel.NORMAL)
			@Description("Test Case Description --> " + "Verify Logout functionality")
			@Test(priority = 2,description="Verify user can logout application into the system.")
			@Stories("Story Name --> "+ "To check Logout functionality.")
			public void TCID102_VerifyLogout() {
				objLoginLogoutFlow.doLogout();
			}

			@Title("TCID102A_VerifyLogoutCaseToFail")
			@Severity(SeverityLevel.MINOR)
			@Description("Test Case Description --> " + "Verify Logout when no logout is present. This is failed for showig reporting capebility.")
			@Test(priority = 3,description="Purposely Failed")
			@Stories("Story Name --> "+ "To check Logout functionality.")
			public void TCID102A_VerifyLogoutCaseToFail() {
				
				objLoginLogoutFlow.doLogout();
			}
			
			
			@Title("TCID103_LoginUsingEmailIdInValidCase")
			@Severity(SeverityLevel.NORMAL)
			@Description("Test Case Description --> " + "Verify error message if invalid credentials are entered.")
			@Test(priority = 4,description="Verify user login into the system.")
			@Stories("Story Name --> "+ "To check login functionality.")
			public void TCID103_LoginUsingEmailIdInValidCase() {
				this.loadTestData("TCID103_LoginUsingEmailIdInValidCase");
				objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
				objLoginLogoutFlow.doLoginViaPassword();	
				objLoginLogoutFlow.checkInvalidUserErrorMessage();
				
			}			
			
		}
