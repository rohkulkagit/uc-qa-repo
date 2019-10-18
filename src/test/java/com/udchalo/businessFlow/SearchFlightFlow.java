package com.udchalo.businessFlow;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;
import com.udchalo.pageFactory.FlightSearchPage;
import com.udchalo.pageFactory.HomePage;
import com.udchalo.pageFactory.VerifyYourDetailsPage;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @ScriptName    : SearchFlightFlow
 * @Description   : This class covers all the flows related to flight search functionality.   
 * 					
 * @Author        : udchalo QA Automation Developer
 * @since		  : 02-Aug-2019
 */
public class SearchFlightFlow {
	
	
	// Global Variables
		private Pojo objPojo;
		private String strUniqueKey = "";
		private String testData = "",testData1="", testData2="",testData3="";
		private String locTestData="";
		private Integer intTestData = null;
		private String strReturnVal = "",strReturnVal_1="";
		private int intReturnVal = 0;
		private boolean blnReturnStatus = false;
		private double dblReturnVal = 0.0;
		private List<WebElement> listReturnElement;
		private WebElement weReturnElement;
		private int intRow = 0;
		private int intColumn = 0;

		// Reference object of Pages
		private HomePage objHomePage;
		private VerifyYourDetailsPage objVerifyYourDetailsPage;
		private  FlightSearchPage objFlightSearchPage;

		public SearchFlightFlow(Pojo pojo) {
			this.objPojo = pojo;
			objHomePage = new HomePage(objPojo);
			objVerifyYourDetailsPage=new VerifyYourDetailsPage(objPojo);
			objFlightSearchPage = new FlightSearchPage(objPojo);

		}

		/**
		 * @MethodName:	 searchFlightOnHomePage
		 * @Description: This method sets the origin, destination,
		 * 				 journey type(one way/round trip), travel date and clicks Search Flights button
		 * @since:		 20-Aug-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Click on Search button on Home Page.")
		public void searchFlightOnHomePage(){
			
			String strCategory="defence";
			
			locTestData=objPojo.getObjUtilitiesFunctions().dataManagerString("locTripTypeID");
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("journeytype");
			if (!testData.equals("") && testData1.equals(""))
			objHomePage.select_Trip_Type_OneWay_or_Round(locTestData, testData);
			
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("origin");
			if (!testData.equals(""))
				objHomePage.set_Origin_On_HomePage(testData);
			
			
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("destination");
			if (!testData.equals(""))
				objHomePage.set_Destination_On_HomePage(testData);
			
			testData=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("traveldate");
			testData2=objPojo.getObjUtilitiesFunctions().dataManagerString("journeytype");
			
			if(testData2.trim().toLowerCase().equals("oneway")){
			
				objHomePage.setDate_For_Oneway_Trip(testData);
			}else {
				testData1=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("returndate");
				objHomePage.setDate_For_Round_Trip(testData, testData1);
			}
			
			testData=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("adult");
			testData1=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("child");
			testData2=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("infant");
			if (!testData.equals("") && !testData1.equals("") && !testData2.equals("")){
				objHomePage.set_Travellers(testData, testData1, testData2);
			}
			
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("category");
			if(!strCategory.toLowerCase().equals(testData.toLowerCase())){
				objHomePage.setDefenceCategory(testData);
				objHomePage.click_SearchFlights();		

			}else {
				objHomePage.click_SearchFlights();		
				objVerifyYourDetailsPage.verify_VerifyYourDetailsPage_Header_Displayed();
				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("strVerificationCode");
				if (!testData.equals(""))
				objVerifyYourDetailsPage.setArmyNumber_On_VerifyYourDetailsPage(testData);
				
				objVerifyYourDetailsPage.click_Continue_On_VrifyYourDetailsPage();
				
			}
			
		}



		
		/**
		 * @MethodName:	 VerifySearchFlightOneWayNonDefence
		 * @Description: This method verifies the search results page for 
		 * 				 search criteria result for oneway non-defence
		 * @since:		 20-Aug-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Verify Search Flight Results page for oneway non defence.")
		public void VerifySearchFlightOneWayNonDefence(){
			
			objFlightSearchPage.verify_FlightSearchOneway();
			objFlightSearchPage.VerifyDefenceFlagNOTSeen();
		}
		
		/**
		 * @MethodName:	 VerifySearchFlightOneWayDefence
		 * @Description: This method verifies the search results page for 
		 * 				 search criteria result for oneway defence
		 * @since:		 20-Aug-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Verify Search Flight Results page for oneway defence.")
		public void VerifySearchFlightOneWayDefence(){
			
			objFlightSearchPage.verify_FlightSearchOneway();
			objFlightSearchPage.VerifyDefenceFlagSeen();
		}
		
		/**
		 * @MethodName:	 VerifySearchFlightRoundTripNonDefence
		 * @Description: This method verifies the search results page for 
		 * 				 search criteria result for round-trip non-defence
		 * @since:		 20-Aug-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Verify Search Flight Results page for round trip non-defence.")
		public void VerifySearchFlightRoundTripNonDefence(){
			
			objFlightSearchPage.verify_RoundTrip_FlightSearch();
			objFlightSearchPage.VerifyDefenceFlagNOTSeen();
		}
		
		/**
		 * @MethodName:	 VerifySearchFlightRoundTripDefence
		 * @Description: This method verifies the search results page for 
		 * 				 search criteria result for round-trip defence
		 * @since:		 20-Aug-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Verify Search Flight Results page for round trip defence.")
		public void VerifySearchFlightRoundTripDefence(){
			
			objFlightSearchPage.verify_RoundTrip_FlightSearch();
			objFlightSearchPage.VerifyDefenceFlagSeen();
		}
	
		/**
		 * @MethodName:	 ModifySearch
		 * @Description: This method carries out the 'Modify Search'
		 * @since:		 26-Aug-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Open Modify Search page")
		public void ModifySearch(){
		
			objFlightSearchPage.GoToModifySearch();
			//objFlightSearchPage.EnterOrigin();
			//objFlightSearchPage.EnterDestination();
			//objFlightSearchPage.
			//VerifyModifySearchOneWayNonDefence();
		}
			
		@Step("Steps Details --> " + "Verify Search Flight Results Page.")
		public void verifySearchFlightResultsOnFlightSearchPage(){
		
		objHomePage.waitForGettingMoreFlightsSpinnerToDisappear();
		testData=objPojo.getObjUtilitiesFunctions().dataManagerString("origin");
		testData1=objPojo.getObjUtilitiesFunctions().dataManagerString("destination");
		testData2=objPojo.getObjUtilitiesFunctions().dataManagerString("journeytype");
		testData3=objPojo.getObjUtilitiesFunctions().dataManagerString("category");
		if (!testData.equals("")&& !testData1.equals(""))
		objFlightSearchPage.verifyFlightSearchResultsOnFlightSearchPage(testData, testData1, testData2, testData3);
		

	}
	
		// AUTHOR : Yogesh Khachane
		// EXCEL PARAMETER KEYS : OriginMandatoryMessage,DestinationMandatoryMessage,,TravelDateMandatoryMessage.
		// BUSINESS LOGIC USED : Use below method to verify oneway trip mandatory fields with * present.
		
		@Step("Steps Details --> " + "Verify Mandatory Fields With Astricks And Error Message On Flight HomePage")
		public void verifyMandatoryFieldsWIthAstricksAndErrorMessageOnFlightHomePage(){
			
			objHomePage.verifyOriginMandatoryField();
			objHomePage.verifyDestinationMandatoryField();
			objHomePage.verifyTravelDateMandatoryField();
			objHomePage.verifyTravellersMandatoryField();
			objHomePage.click_SearchFlights();
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("OriginMandatoryMessage");
			strReturnVal=objHomePage.getOriginMandatoryFieldErrorMessage();
			System.out.println("strReturn Val ----> "+strReturnVal);
			System.out.println("strReturn testData ----> "+testData);
			if (!testData.equals(""))
			objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Origin' mandatory field error message.", "user can see 'Origin' field mandatory messge.", "user not able to see 'Origin' field mandatory messge.", strReturnVal.trim().toLowerCase().equals(testData.toLowerCase().trim()));
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("DestinationMandatoryMessage");
			strReturnVal=objHomePage.getDestinationMandatoryFieldErrorMessage();
			if (!testData.equals(""))
			objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Destination' mandatory field error message.", "user can see 'Destination' field mandatory messge.", "user not able to see 'Destination' field mandatory messge.", strReturnVal.trim().toLowerCase().equals(testData.toLowerCase().trim()));
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("TravelDateMandatoryMessage");
			strReturnVal=objHomePage.getTravelDateMandatoryFieldErrorMessage();
			if (!testData.equals(""))
				objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Travel Date' mandatory field error message.", "user can see 'Travel Date' field mandatory messge.", "user not able to see 'Travel Date' field mandatory messge.", strReturnVal.trim().toLowerCase().equals(testData.toLowerCase().trim()));

			
		}
		
		
		
		// AUTHOR : Yogesh Khachane
		// EXCEL PARAMETER KEYS : locTripTypeID,journeytype,,journeytype,OnwardDateErrorMsg ,ReturnDateErrorMsg
		// BUSINESS LOGIC USED : Use below method to verify oneway and round trip date picker Icons and mandatory fields.
		
		@Step("Steps Details --> " + "Verify 'oneway' and round trip travel date 'date picker' icon on search flight page.")
		public void verify_Oneway_And_RoundTrip_DatePickerIcon_On_SearchFlightPage(){
			
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("journeytype");
			if(testData.toLowerCase().equals("oneway")){
				
				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("locTripTypeID");
				testData1=objPojo.getObjUtilitiesFunctions().dataManagerString("journeytype");
				if (!testData.equals("") && !testData1.equals(""))
				objHomePage.select_Trip_Type_OneWay_or_Round(testData, testData1);
			
				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("journeytype");
				if (!testData.equals(""))
				objHomePage.verifyTravelDate_DatePickerIcon_For_OnewayAndRoundTrip(testData);

			}else {
				
				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("locTripTypeID");
				testData1=objPojo.getObjUtilitiesFunctions().dataManagerString("journeytype");
				if (!testData.equals("") && !testData1.equals(""))
				objHomePage.select_Trip_Type_OneWay_or_Round(testData, testData1);
				objHomePage.verifyOnwardDateMandatoryField();
				objHomePage.verifyReturnDateMandatoryField();
				objHomePage.click_SearchFlights();
				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("OnwardDateErrorMsg");
				strReturnVal=objHomePage.getOnwardDateMandatoryFieldErrorMessage();
				if (!testData.equals(""))
					objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Onward Date' mandatory field error message.", "user can see 'Onward Date' field mandatory messge.", "user not able to see 'Onward Date' field mandatory messge.", strReturnVal.trim().toLowerCase().equals(testData.toLowerCase().trim()));

				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("ReturnDateErrorMsg");
				strReturnVal=objHomePage.getReturnDateMandatoryFieldErrorMessage();
				if (!testData.equals(""))
					objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Return Date' mandatory field error message.", "user can see 'Return Date' field mandatory messge.", "user not able to see 'Return Date' field mandatory messge.", strReturnVal.trim().toLowerCase().equals(testData.toLowerCase().trim()));

			}
			
		}
		
		
		
		public void verifyForwardAndBackwardArrowFunctionalityOnFlightHomePage(){
			
			testData=objPojo.getObjUtilitiesFunctions().dataManagerString("origin");
			if (!testData.equals(""))
				objHomePage.set_Origin_On_HomePage(testData);
			
			testData1=objPojo.getObjUtilitiesFunctions().dataManagerString("destination");
			if (!testData1.equals(""))
				objHomePage.set_Destination_On_HomePage(testData1);
			strReturnVal=objHomePage.getOriginName().trim();
			strReturnVal_1=objHomePage.getDestinationName().trim();
			objPojo.getObjUtilitiesFunctions().logReporter("Verify set 'Origin' and 'Destination' properly.", "user can set 'origin' and 'destination' properly as expected.", "user not able to set 'Origin' and 'Destination' properly.", strReturnVal.toLowerCase().equals(testData.toLowerCase()) && strReturnVal_1.toLowerCase().equals(testData1.toLowerCase()));
			objHomePage.clickForwardAndBackwardArrowInBetweenOriginAndDestination();
			strReturnVal=objHomePage.getOriginName().trim();
			strReturnVal_1=objHomePage.getDestinationName().trim();
			objPojo.getObjUtilitiesFunctions().logReporter("Verify set 'Origin' and 'Destination' after click on forward and backward arrow vice versa properly.", "user can set 'origin' and 'destination' properly as expected.", "user not able to set 'Origin' and 'Destination' properly.", strReturnVal.toLowerCase().equals(testData1.toLowerCase()) && strReturnVal_1.toLowerCase().equals(testData.toLowerCase()));

			
			
		}
		
		
		


}
