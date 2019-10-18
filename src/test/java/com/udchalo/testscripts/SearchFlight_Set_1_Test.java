package com.udchalo.testscripts;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.itextpdf.text.log.SysoCounter;
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

@Features("Feature ---> Search Flight home page test scripts.")
public class SearchFlight_Set_1_Test extends BaseTest {

	private String strApplicationName="Flights";
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

	@BeforeClass(groups = { "Regression Test", "Smoke Test", "Sanity Test" })
	public void initializeEnvironment() {
		
		 this.initializeWebEnvironment("excel/AutomationTestDataInput");
		 this.initializeViewsAndPages();
		 
	}

	@AfterClass(groups = { "Regression Test", "Smoke Test", "Sanity Test" })
	public void tearDownEnvironment() {
		 this.tearDownWebEnvironment();

	}

	 @BeforeMethod(groups = { "Regression Test", "Smoke Test", "Sanity Test" })
	  public void redirect_Me_To_HomePage_On_udChalo_Application() {
		 
			objHomePage.commonClickHeaderDesktopTabs(strApplicationName);
				
	  }
	 
	 @AfterMethod(groups = { "Regression Test", "Smoke Test", "Sanity Test" })
	  public void afterMethod() {
		 
	//	 this.tearDownWebEnvironment();
	  }

	@Title("TCID_003_TS_007_VerifyMandatoryFields")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description --> " + "Verify mandatory fields on Search Flight page")
	@Test(priority = 1, description = "Verify mandatory fields on Search Flight page")
	@Stories("Story Name --> " + "Verify fields on flight home page.")
	public void TCID_003_TS_007_VerifyMandatoryFields() {

		this.loadTestData("TCID_003_TS_007_VerifyMandatoryFields");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();	
		objSearchFlightFlow.verifyMandatoryFieldsWIthAstricksAndErrorMessageOnFlightHomePage();
		objLoginLogoutFlow.doLogout();
	}

	
	@Title("TCID_004_TS_007_VerifyOneWayTripOnlyOneTravelDatePickerIconDisplayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description --> " + "Verify one way trip 'one' Travel Date 'Date Picker' field")
	@Test(priority = 2, description = "Verify one way trip 'one' travel date 'Date Picker' field.")
	@Stories("Story Name --> " + "Verify fields on flight home page.")
	public void TCID_004_TS_007_VerifyOneWayTripOnlyOneTravelDatePickerIconDisplayed() {

		this.loadTestData("TCID_004_TS_007_VerifyOneWayTripOnlyOneTravelDatePickerIconDisplayed");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();	
		objSearchFlightFlow.verify_Oneway_And_RoundTrip_DatePickerIcon_On_SearchFlightPage();
		objLoginLogoutFlow.doLogout();
		
	}
	
	@Title("TCID_005_TS_007_VerifyRoundTripOnwardsAndReturnDatePickerIconDisplayed")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description --> " + "Verify round trip Onward and return datePicker icon")
	@Test(priority = 3, description = "Verify round trip Onward and return datePicker icon")
	@Stories("Story Name --> " + "Verify fields on flight home page.")
	public void TCID_005_TS_007_VerifyRoundTripOnwardsAndReturnDatePickerIconDisplayed() {

		this.loadTestData("TCID_005_TS_007_VerifyRoundTripOnwardsAndReturnDatePickerIconDisplayed");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();	
		objSearchFlightFlow.verify_Oneway_And_RoundTrip_DatePickerIcon_On_SearchFlightPage();
		objLoginLogoutFlow.doLogout();
	}

	@Title("TCID_006_TS_007_VerifyForwardAndBackwordArrowFunctionalityInBetweenOriginAndDestination")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description --> " + "Verify forward and backword arrow functionality in between Origin and Destination")
	@Test(priority = 3, description = "Verify forward and backword arrow functionality in between Origin and Destination")
	@Stories("Story Name --> " + "Verify fields on flight home page.")
	public void TCID_006_TS_007_VerifyForwardAndBackwordArrowFunctionalityInBetweenOriginAndDestination() {

		this.loadTestData("TCID_006_TS_007_VerifyForwardAndBackwordArrowFunctionalityInBetweenOriginAndDestination");
		objLoginLogoutFlow.gotoLoginWithEmailMobilePage();
		objLoginLogoutFlow.doLoginViaPassword();	
		objSearchFlightFlow.verifyForwardAndBackwardArrowFunctionalityOnFlightHomePage();
		objLoginLogoutFlow.doLogout();
	}
		
	
	
	
	
	
	
	
	
	
	
}