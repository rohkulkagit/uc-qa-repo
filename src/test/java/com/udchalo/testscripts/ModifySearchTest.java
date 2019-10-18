package com.udchalo.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.udchalo.businessFlow.LoginLogoutFlow;
import com.udchalo.businessFlow.ModifySearchFlow;
import com.udchalo.businessFlow.SearchFlightFlow;
import com.udchalo.businessFlow.commonFlow.CommonFlow;
import com.udchalo.generic.BaseTest;
import com.udchalo.pageFactory.HomePage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Features("Feature ---> Modify Search - Flights")
public class ModifySearchTest extends BaseTest {

		// Global variables

			private  HomePage objHomePage;
			private  LoginLogoutFlow objLoginLogoutFlow;
			private CommonFlow objCommonFlow;
			private SearchFlightFlow objSearchFlightFlow;
			private ModifySearchFlow objModifySearchFlow;
			

			// Initialize Views
			public void initializeViewsAndPages() {
				objHomePage=new HomePage(this);
				objLoginLogoutFlow=new LoginLogoutFlow(this);
				objCommonFlow=new CommonFlow(this);
				objSearchFlightFlow = new SearchFlightFlow(this);
				objModifySearchFlow = new ModifySearchFlow(this);
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
			 
			 @Title("TCID205_ModifySearchFlightOneWayNonDefence")
			  @Severity(SeverityLevel.CRITICAL)
			  @Description("Test Case Description --> " + "Verify Modify Search ")  
			  @Test(priority = 1,description="Verify Modify Search Flight Functionality Onwway non-defence") 
			  @Stories("Story Name --> "+ "Modify Search Flight")
			  public void TCID205_ModifySearchFlightOneWayNonDefence() {
			  
				this.loadTestData("TCID205_ModifySearchFlightOneWayNonDefence");
				objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
				objLoginLogoutFlow.doLoginViaPassword();
				objSearchFlightFlow.searchFlightOnHomePage();
				objSearchFlightFlow.VerifySearchFlightOneWayNonDefence();
				objSearchFlightFlow.ModifySearch();		
				//objModifySearchFlow.SwapOriginDestination();
			 }
			 
			 @Title("TCID206_ModifySearchToggleIconTest")
			  @Severity(SeverityLevel.CRITICAL)
			  @Description("Test Case Description --> " + "Verify Origin Destination Swap Icon inModify Search.")  
			  @Test(priority = 5,description="Verify Origin Destination Swap Icon inModify Search.") 
			  @Stories("Story Name --> "+ "Modify Search Flight")
			  public void TCID206_ModifySearchToggleIconTest() {
			  
				//this.loadTestData("TCID205_ModifySearchFlightOneWayNonDefence");
						
				objModifySearchFlow.SwapOriginDestination();
			 }
			
		}
