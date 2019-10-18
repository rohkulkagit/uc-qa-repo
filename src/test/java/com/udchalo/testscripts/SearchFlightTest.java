package com.udchalo.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.udchalo.businessFlow.LoginLogoutFlow;
import com.udchalo.businessFlow.SearchFlightFlow;
import com.udchalo.businessFlow.commonFlow.CommonFlow;
import com.udchalo.generic.BaseTest;
import com.udchalo.pageFactory.FlightSearchPage;
import com.udchalo.pageFactory.HomePage;

import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

@Features("Feature ---> Flight Search and modify search")
public class SearchFlightTest extends BaseTest {

	private SearchFlightFlow objSearchFlightFlow;
	private  LoginLogoutFlow objLoginLogoutFlow;
	private HomePage objHomePage;
	private  FlightSearchPage objFlightSearchPage;
	private CommonFlow objCommonFlow;

	// Initialize Views
	public void initializeViewsAndPages() {
		objLoginLogoutFlow=new LoginLogoutFlow(this);
		objSearchFlightFlow = new SearchFlightFlow(this);
		objHomePage = new HomePage(this);
		objFlightSearchPage= new FlightSearchPage(this);
		objCommonFlow=new CommonFlow(this);
	}

	@BeforeClass(groups = { "P1", "P2", "P3" })
	public void initializeEnvironment() {
	//	this.initializeWebEnvironment("excel/RK");
	//	this.initializeViewsAndPages();
	//	 objLoginLogoutFlow.doLoginViaPassword();
	}

	@AfterClass(groups = { "P1", "P2", "P3" })
	public void tearDownEnvironment() {
		// this.tearDownWebEnvironment();

	}

	 @BeforeMethod
	  public void redirect_Me_To_HomePage_On_udChalo_Application() {
		 
		 this.initializeWebEnvironment("excel/AutomationTestDataInput");
			this.initializeViewsAndPages();
		  
		/* if (objHomePage.beforeMethodtoVerifyHomePageHeader()){
			//	objCommonFlow.refreshWholePageF5();
				objHomePage.beforeMethod_Click_Logo();
				objCommonFlow.clearTempDirectory();
				
		 }*/
		 
	  }
	 
	 @AfterMethod
	  public void afterMethod() {
		 
		 this.tearDownWebEnvironment();
	  }

	@Title("TCID201_SearchFlightOneWayNonDefence")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case Description --> " + "Verify Search Flight OneWay Non Defence")
	@Test(priority = 1, description = "Verify Search Flight OneWay non-Defence")
	@Stories("Story Name --> " + "Search Flight")
	public void TCID201_SearchFlightOneWayNonDefence() {

		this.loadTestData("TCID201_SearchFlightOneWayNonDefence");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();
		objSearchFlightFlow.searchFlightOnHomePage();
		objSearchFlightFlow.verifySearchFlightResultsOnFlightSearchPage();

	}


	
	  @Title("TCID202_SearchFlightOneWayDefence")
	  @Severity(SeverityLevel.BLOCKER)
	  @Description("Test Case Description --> " +
	  "Verify Search Flight OneWay Defence")  
	  @Test(priority = 2,description="Verify Search Flight OneWay Defence") 
	  @Stories("Story Name --> "+ "Search Flight")
	  public void TCID202_SearchFlightOneWayDefence() {
	  
		this.loadTestData("TCID202_SearchFlightOneWayDefence");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();
		objSearchFlightFlow.searchFlightOnHomePage();
		objSearchFlightFlow.verifySearchFlightResultsOnFlightSearchPage();


	  }
	  
	  @Title("TCID203_SearchFlightRoundTripNonDefence")
	  @Severity(SeverityLevel.BLOCKER)
	  @Description("Test Case Description --> " + "Verify Search Flight Roundtrip non Defence")  
	  @Test(priority = 3,description="Verify Search Flight Roundtrip non Defence") 
	  @Stories("Story Name --> "+ "Search Flight")
	  public void TCID203_SearchFlightRoundTripNonDefence() {
	  
		this.loadTestData("TCID203_SearchFlightRoundTripNonDefence");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();
		objSearchFlightFlow.searchFlightOnHomePage();
		objSearchFlightFlow.verifySearchFlightResultsOnFlightSearchPage();


	  }
	  
	  @Title("TCID204_SearchFlightRoundTripDefence")
	  @Severity(SeverityLevel.BLOCKER)
	  @Description("Test Case Description --> " + "Verify Search Flight Roundtrip Defence")  
	  @Test(priority = 4,description="Verify Search Flight Roundtrip Defence") 
	  @Stories("Story Name --> "+ "Search Flight")
	  public void TCID204_SearchFlightRoundTripDefence() {
	  
		this.loadTestData("TCID204_SearchFlightRoundTripDefence");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();
		objSearchFlightFlow.searchFlightOnHomePage();
		objSearchFlightFlow.verifySearchFlightResultsOnFlightSearchPage();


	  }
	  
	  
	  @Title("TCID205_ModifySearchFlightOneWayNonDefence")
	  @Severity(SeverityLevel.CRITICAL)
	  @Description("Test Case Description --> " + "Verify Modify Search ")  
	  @Test(priority = 5,description="Verify Modify Search Flight Functionality Onwway non-defence") 
	  @Stories("Story Name --> "+ "Search Flight")
	  public void TCID205_ModifySearchFlightOneWayNonDefence() {
	  
		this.loadTestData("TCID205_ModifySearchFlightOneWayNonDefence");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();
		objSearchFlightFlow.searchFlightOnHomePage();
		objSearchFlightFlow.VerifySearchFlightOneWayNonDefence();
		objSearchFlightFlow.ModifySearch();
	//	objSearchFlightFlow.VerifyModifySearchOneWayNonDefence();

	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
	
}

