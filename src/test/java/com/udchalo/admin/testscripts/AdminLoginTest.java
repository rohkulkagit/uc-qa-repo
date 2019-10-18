package com.udchalo.admin.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.udchalo.admin.businessFlow.AdminDashboardFlow;
import com.udchalo.admin.businessFlow.AdminLoginLogoutFlow;
import com.udchalo.generic.BaseTest;
import com.udchalo.pageFactory.admin.AdminDashboardPage;
import com.udchalo.pageFactory.admin.AdminLoginPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Features("Feature ---> Login and Logout")
public class AdminLoginTest extends BaseTest{
	
			// Global variables

				private AdminLoginPage objAdminLoginPage;
				private AdminLoginLogoutFlow objAdminLoginLogoutFlow;
				private AdminDashboardFlow objAdminDashboardFlow;
				private AdminDashboardPage objAdminDashboardPage;
				

				// Initialize Views
				public void initializeViewsAndPages() {
					objAdminLoginPage=new AdminLoginPage(this);
					objAdminLoginLogoutFlow=new AdminLoginLogoutFlow(this);
					objAdminDashboardFlow=new AdminDashboardFlow(this);
					objAdminDashboardPage=new AdminDashboardPage(this);
					
				}

				@BeforeClass(groups = { "P1", "P2", "P3" })
				public void initializeEnvironment() {
					 this.initializeWebEnvironmentIncognitoForAdmin(("excel/AutomationTestDataInput"));
					 this.initializeViewsAndPages();
					 
				}

				
				@AfterClass(groups = { "P1", "P2", "P3" })
				public void tearDownEnvironment() {
				//	this.tearDownWebEnvironment();
					objAdminLoginPage = null;
					objAdminLoginLogoutFlow=null;
										
				}
				
				 @BeforeMethod
				  public void redirect_Me_To_HomePage_On_udChalo_Application() {
					  
					 
					 
				  }
				 

				@Title("TCID101_LoginUsingEmailIdValidCase")
				@Severity(SeverityLevel.BLOCKER)
				@Description("Test Case Description --> " + "Verify Login using valid email id and password.")
				@Test(priority = 1,description="Verify user login into the system.")
				@Stories("Story Name --> "+ "To check login functionality.")
				public void TCID101_LoginUsingEmailId() {
					this.loadTestData("TCID_101_AdminLogin");
					
					objAdminLoginLogoutFlow.doAdminLogin();
					objAdminLoginLogoutFlow.verifyAdminUserLoggedInSUccessfully();
					
					objAdminDashboardFlow.goToLNBTMenuTabs();
					objAdminDashboardFlow.commonGlobalSearchInAdmin();
					objAdminDashboardPage.verifyUserName();
					
					
				}

				@Title("TCID102_VerifyLogout")
				@Severity(SeverityLevel.NORMAL)
				@Description("Test Case Description --> " + "Verify Logout functionality")
				@Test(priority = 2,description="Verify user can logout application into the system.")
				@Stories("Story Name --> "+ "To check Logout functionality.")
				public void TCID102_VerifyLogout() {
				
					objAdminLoginLogoutFlow.doLogout();
				}

							
			}
