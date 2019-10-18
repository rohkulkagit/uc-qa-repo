package com.udchalo.pageFactory;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.udchalo.generic.Pojo;

/**
 * @ScriptName    : FlightSearchPage
 * @Description   : This class is dedicated for FlightSearchPage of udchalo.com.
 * 					It contains xpath of all the elements & its related methods
 * @Author        : udchalo QA Automation Developer
 * @since         : 16-Aug-2019
 */


public class FlightSearchPage {
	
				// Global Variables
				private Pojo objPojo;
				private String strUniqueKey = "";
				private String testData = ""; 
				private String strReturnVal = "";
				private int intReturnVal = 0;
				private boolean blnReturnStatus = false;
				private double dblReturnVal = 0.0;
				private List<WebElement> listReturnElement;
				private WebElement weReturnElement;
				
				
				public FlightSearchPage(Pojo pojo) {
					this.objPojo = pojo;
				}
				
				//Locators
				
				By loc_hdrFlightSearchPage=By.xpath("//div[@class='formHeading desktop-only' and text()=' Verify your Details'][@id='formHeading']");
				
				By loc_hdrFlightSearchPageActive=By.xpath("//div[@class='formHeading desktop-only' and text()=' Verify your Details']/ancestor::div[2]//div[2]");

				
				By loc_btnBook=By.xpath("//table[@class='table animation-on uc_box']//td/a/span[text()='Book'][1]");
				By loc_btnBookRoundTrip=By.xpath("//a[text()=' Book ']");
				By loc_iconGreenDefence = By.xpath("//span[text()=' DEF']");
				By loc_btnModifySearch = By.xpath("//a[contains(.,'Modify')]");
				By loc_rbRoundTrip = By.xpath("//input[@id='roundtrip']");
				By loc_rbOneWay = By.xpath("//input[@id='oneway']");
				By loc_inpOriginModifySearch = By.xpath("//label[text()='Origin*']/following::span[1]/input[@type='text']");
				By loc_inpDestinationModifySearch = By.xpath("//label[text()='Destination*']/following::span[1]/input[@type='text']");
				By loc_chkMSI_Am_From_The_Defence_Forces=By.xpath("//input[@id='isDefenceSearch'][@type='checkbox']");
				By loc_btnMSSearch = By.xpath("//span[.='Search']/parent::button");
				
				
				public void verify_FlightSearchOneway(){
										
					objPojo.getObjSeleniumFunctions().waitFor(5);
					String strURL = objPojo.getDriver().getCurrentUrl();
					objPojo.getObjUtilitiesFunctions().logReporter("Search results page loading...",strURL.contains("results"));
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnBook);
					objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Flight' search is successful.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnBook));
							
				}
	
	
				public void verify_RoundTrip_FlightSearch(){
					
					objPojo.getObjSeleniumFunctions().waitFor(5);
					String strURL = objPojo.getDriver().getCurrentUrl();
					objPojo.getObjUtilitiesFunctions().logReporter("Search results page loading...",strURL.contains("results"));
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnBookRoundTrip);
					objPojo.getObjUtilitiesFunctions().logReporter("Verify 'Flight' search is successful.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnBookRoundTrip));
								
				}
		
				public void VerifyDefenceFlagSeen(){
				
					objPojo.getObjUtilitiesFunctions().logReporter("Verify DEF icon present in the 'Search Results' page.", objPojo.getObjSeleniumFunctions().checkElementPresence(loc_iconGreenDefence));
				}
				

				public void VerifyDefenceFlagNOTSeen(){
					
					objPojo.getObjUtilitiesFunctions().logReporter("Verify DEF icon is NOT present in the 'Search Results' page.", !objPojo.getObjSeleniumFunctions().checkElementPresence(loc_iconGreenDefence));
					
				}
				public void GoToModifySearch(){
					
					objPojo.getObjUtilitiesFunctions().logReporter("Click on Modify Search button",this.objPojo.getObjSeleniumFunctions().click(loc_btnModifySearch));
					objPojo.getObjSeleniumFunctions().waitFor(10);
				}
				
				
				public void verifyFlightSearchResultsOnFlightSearchPage(String strOrigin,String strDestination,String strTripType,String category){
					
					By locFlightResultCounter=By.xpath("//table[@class='table animation-on']");
					By locFlightResultBySupplierName=By.xpath("//table[@class='table animation-on']//td/div[normalize-space(text()) = 'SpiceJet']");
					By locFlightResultBookButton=By.xpath("//table[@class='table animation-on']//td/div[normalize-space(text()) = 'SpiceJet']/parent::td[1]/following-sibling::td[@class='desktop-only ng-star-inserted']/a/span[normalize-space(text())='Book']");

					By locTotalNoOfFlightCountByUsingBookButton=By.xpath("//table[@class='table animation-on']//td[@class='desktop-only ng-star-inserted']/a/span[normalize-space(text())='Book']");
					By locNonStopFlightCount=By.xpath("//div[@class='stops--filter filters border-bottom']//div//label[contains(.,'Non-Stop')]/small[1]");
					By loc1StopFlightCount=By.xpath("//div[@class='stops--filter filters border-bottom']//div//label[contains(.,'1 Stop ')]/small[1]");
					By loc2PlusStopFlightCount=By.xpath("//div[@class='stops--filter filters border-bottom']//div//label[contains(.,'2+ Stops')]/small[1]");
				
					// Round trip
					By loc_FlightSearchResult=By.xpath("//div[@class='search--results ng-star-inserted']");
					By loc_FlightSearchTotalCount=By.xpath("//div[@class='search--results ng-star-inserted']//div[@class='ng-star-inserted']//table[@class='table animation-on isClickable']");
					By loc_ByDefaultSelectedFlightSearchResult=By.xpath("//div[@class='search--results ng-star-inserted']//div[@class='ng-star-inserted']//table[@class='table animation-on active isClickable']");
					By loc_BookButton=By.xpath("//a[normalize-space(text())='Book']");
					
					
					
					/*String strNotStop=objPojo.getObjSeleniumFunctions().getText(locNonStopFlightCount, "text").replaceAll("[^0-9]", "").trim();
					String str_1Stop=objPojo.getObjSeleniumFunctions().getText(loc1StopFlightCount, "text").replaceAll("[^0-9]", "").trim();
					String str_2Stop=objPojo.getObjSeleniumFunctions().getText(loc2PlusStopFlightCount, "text").replaceAll("[^0-9]", "").trim();
					int intNotStopCount=Integer.parseInt(strNotStop);
					int int_1Stop=Integer.parseInt(str_1Stop);
					int int_2Stop=Integer.parseInt(str_2Stop);
					int intFilterTotalCount=intNotStopCount+int_1Stop+int_2Stop;
					System.out.println("non stop : "+strNotStop+ " -1 stop : "+str_1Stop+ "- 2 stop : "+str_2Stop);*/
					
										
					String strOriginUpperCase = objPojo.getObjUtilitiesFunctions().createFirstLetterCapitalToTheString(strOrigin);
					String strDestinationUpperCase =objPojo.getObjUtilitiesFunctions().createFirstLetterCapitalToTheString(strDestination);
					String strGetOrigin="";
					String strGetDestination="";
					String[] strOriginSplit=null;
					String[] strDestinationSplit = null;

					String[] strOriginSplit_1=null;
					String[] strDestinationSplit_1 = null;

					strReturnVal=objPojo.getDriver().getTitle().toLowerCase().trim();
					
					String strTitle="Flights from "+strOrigin+" to "+strDestination+" | udChalo.com";

					if(strTripType.toLowerCase().equals("oneway")){	
					
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(locFlightResultCounter);
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(locTotalNoOfFlightCountByUsingBookButton);
					
					if(strTripType.toLowerCase().equals("oneway") && category.toLowerCase().equals("nondefence")){
						this.verify_FlightSearchOneway();
						this.VerifyDefenceFlagNOTSeen();
					}else {
						this.verify_FlightSearchOneway();
						this.VerifyDefenceFlagSeen();
					}
					
					int intCounter=objPojo.getDriver().findElements(locFlightResultCounter).size();
					int intBookButtonCountr=objPojo.getDriver().findElements(locTotalNoOfFlightCountByUsingBookButton).size();
					System.out.println("Total Floght count---> "+intCounter + "Total 'Book' button count ---> "+intBookButtonCountr);
				
				//	objPojo.getObjUtilitiesFunctions().logReporter("Verify flight booking 'Origin' and 'Destination' by using URL.", "Flight search result title url should be 'Origin' and 'Destination' along with udchalo.com", "Flight result title url not matched with as expected. ", strTitle.toLowerCase().equals(strReturnVal));
					objPojo.getObjUtilitiesFunctions().logReporter("Flight search count is more than '0' ", "Flight search count should be a more than '0'", "Flight not display on the screen.", intCounter>0);
					if(intCounter>0){
						
						objPojo.getObjUtilitiesFunctions().logReporter("Verify flight result count.", "Flight result count should be same as 'Book' button count.", "Flight result count and 'Book' button count is mistmatch.", intCounter==intBookButtonCountr);
						
						for (int intIndex = 1; intIndex <= intCounter; intIndex++) {
							
							By loc_AirportNameOrigin=By.xpath("//span[normalize-space(text()) = '"+strOriginUpperCase+"']");
							By loc_AirportNameDestination=By.xpath("//span[normalize-space(text()) = '"+strOriginUpperCase+"']/following::td/span[contains(.,'"+strDestinationUpperCase+"')]");
							By loc_TotalFlight=By.xpath("//div[@class='ng-star-inserted']["+intIndex+"]//table[@class='table animation-on']");
							
							if(objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_TotalFlight)){
								objPojo.getObjSeleniumFunctions().scrollToView(loc_TotalFlight);
							 strGetOrigin = objPojo.getObjSeleniumFunctions().getText(loc_AirportNameOrigin, "text").trim();
							 strGetDestination = objPojo.getObjSeleniumFunctions().getText(loc_AirportNameDestination, "text").trim();

							 strOriginSplit = strGetOrigin.split("\\s+");
							 strDestinationSplit = strGetDestination.split("\\s+");

							 if(strOrigin.toLowerCase().equals(strOriginSplit[0].toLowerCase()) && strDestination.toLowerCase().equals(strDestinationSplit[0].toLowerCase()))
							 System.out.println("Origin and Destination is same as expected.");
							 else
								 objPojo.getObjUtilitiesFunctions().logReporter("Verify search flight result by origin and destination airport name", "Search flight result origin "+strOrigin+" and Destination "+strDestination+" is same as expected.", "Search flight result  origin "+strOriginSplit[0].trim()+" and Destination "+strDestinationSplit[0].trim()+" is mistmatch", false);
							 
							}else {
								objPojo.getObjUtilitiesFunctions().logReporter("Verify search flight result by origin and destination airport name", "Search flight result origin "+strOrigin+" and Destination "+strDestination+" is same as expected.", "Search flight result  origin "+strOriginSplit[0].trim()+" and Destination "+strDestinationSplit[0].trim()+" is mistmatch", false);
							}
						}
						
					//	int intTotalFlightCount=intNotStopCount+int_1Stop+int_2Stop;	
					//	objPojo.getObjUtilitiesFunctions().logReporter("Verify flight result count by using filter 'Stop' count.", "Flight result count should be same as 'Book' button count.", "Flight result count and 'Book' button count is mistmatch.", intTotalFlightCount==intBookButtonCountr);
						
					}		
					}else {
						
						By loc_FlightSearchTableCount=By.xpath("//div[@class='search--results ng-star-inserted'][1]");
						int intMainTblCount=objPojo.getDriver().findElements(loc_FlightSearchTableCount).size();
						
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_BookButton);
						
						if(strTripType.toLowerCase().equals("roundtrip") && category.toLowerCase().equals("nondefence")){
							this.verify_RoundTrip_FlightSearch();
							this.VerifyDefenceFlagNOTSeen();
						}else {
							this.verify_RoundTrip_FlightSearch();
							this.VerifyDefenceFlagSeen();
						}
						
						int intCounter=objPojo.getDriver().findElements(loc_FlightSearchResult).size();
						int intUnselectedFlightCount=objPojo.getDriver().findElements(loc_FlightSearchTotalCount).size();
						int intSelectedFlightCount=objPojo.getDriver().findElements(loc_ByDefaultSelectedFlightSearchResult).size();
						
						
						int intTotalFlightCount=intUnselectedFlightCount+intSelectedFlightCount;
						System.out.println("intTotalCount ---> "+intTotalFlightCount);
						
						objPojo.getObjUtilitiesFunctions().logReporter("Verify flight search 'Book' button is enabled.", "Flight 'Book' button should be enabled.", "Flight 'Book' button is not enabled.", objPojo.getObjSeleniumFunctions().checkElementEnabled(loc_BookButton));
					//	objPojo.getObjUtilitiesFunctions().logReporter("Verify flight booking 'Origin' and 'Destination' by using URL.", "Flight search result title url should be 'Origin' and 'Destination' along with udchalo.com", "Flight result title url not matched with as expected. ", strTitle.toLowerCase().equals(strReturnVal));

						if(intCounter==4){
							
							objPojo.getObjUtilitiesFunctions().logReporter("Verify flight result count.", "Flight result count should be same as 'Filter' flight count.", "Flight result count and 'Filter' flight count is mistmatch.", intTotalFlightCount >0);
							
							By loc_ReturnFlight=By.xpath("//div[@class='depart-date light--text' and contains(.,'"+strDestinationUpperCase+"')]");
							By loc_ReturnFlight1=By.xpath("//div[@class='total-stops light--text']/span[text()=' "+strOriginUpperCase+" ']");
								
							String strGetOrigin_1 = objPojo.getObjSeleniumFunctions().getText(loc_ReturnFlight1, "text").trim();
							String strGetDestination_1 = objPojo.getObjSeleniumFunctions().getText(loc_ReturnFlight, "text").trim();
							 strOriginSplit_1 = strGetOrigin_1.split("\\s+");
							 strDestinationSplit_1 = strGetDestination_1.split("\\s+");

							 if(strOrigin.toLowerCase().equals(strOriginSplit_1[0].toLowerCase()) && strDestination.toLowerCase().equals(strDestinationSplit_1[0].toLowerCase()))
									System.out.println("Search Flight Passed");
							 else
							objPojo.getObjUtilitiesFunctions().logReporter("Verify round trip selected search fligt second side Origin and Destination. ", " Round trip selected search flight Origin : "+strOriginUpperCase+" and Destination : "+strDestinationUpperCase+ " .", "Search flight result not matched with As Expected ...Result Found Origin : "+strOriginSplit_1[0]+" and Destination : "+strDestinationSplit_1[0]+".", false);

								 
								 
							for (int intIndex = 1; intIndex <=intMainTblCount; intIndex++) {
							
							By loc_RoundTripBookFlight=By.xpath("//div[@class='footer-header__fixed animation-on desktop-only ng-star-inserted']//div[@class='search--results ng-star-inserted']["+intIndex+"]");
							By loc_RoundTripOrigin=By.xpath("//div[@class='footer-header__fixed animation-on desktop-only ng-star-inserted']//div[@class='search--results ng-star-inserted'][1]//div[@class='depart-date light--text' and contains(.,'"+strOriginUpperCase+"')]");
							By loc_RoundTripDestination=By.xpath("//div[@class='footer-header__fixed animation-on desktop-only ng-star-inserted']//div[@class='search--results ng-star-inserted'][1]//div/span[contains(.,'"+strDestinationUpperCase+" ')]");
							
							
							 strGetOrigin = objPojo.getObjSeleniumFunctions().getText(loc_RoundTripOrigin, "text").trim();
							 strGetDestination = objPojo.getObjSeleniumFunctions().getText(loc_RoundTripDestination, "text").trim();
							 strOriginSplit = strGetOrigin.split("\\s+");
							 strDestinationSplit = strGetDestination.split("\\s+");

							
							objPojo.getObjUtilitiesFunctions().logReporter("Verify round trip flight search two table displayed. ", "Search flight result should display in two table.", "Search flight result not display in two table.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_RoundTripBookFlight));
							
							 if(strOrigin.toLowerCase().equals(strOriginSplit[0].toLowerCase()) && strDestination.toLowerCase().equals(strDestinationSplit[0].toLowerCase()))
							System.out.println("Search Flight Passed");
							 else
							objPojo.getObjUtilitiesFunctions().logReporter("Verify round trip selected search fligt first side Origin and Destination. ", " Round trip selected search flight Origin : "+strOriginUpperCase+" and Destination : "+strDestinationUpperCase+ " .", "Search flight result not matched with As Expected ...Result Found Origin : "+strOriginSplit[0]+" and Destination : "+strDestinationSplit[0]+".", false);

							}
						}
					}
				}
			
				
public void verifyFlightSearchResultsOnFlightSearchPageForTerminalTest(String strOrigin,String strDestination,String strTripType,String category,String strFlightSupplierName,String strFlightNo,String strTerminal){
					
					By locFlightResultCounter=By.xpath("//table[@class='table animation-on']");
					By locTotalNoOfFlightCountByUsingBookButton=By.xpath("//table[@class='table animation-on']//td[@class='desktop-only ng-star-inserted']/a/span[normalize-space(text())='Book']");
					
					By locFlightResultBySupplierName=By.xpath("//table[@class='table animation-on']//td/div[normalize-space(text()) = '"+strFlightSupplierName+"']");
					By locFlightResultBookButton=By.xpath("//table[@class='table animation-on']//td/div[normalize-space(text()) = 'SpiceJet']/parent::td[1]/following-sibling::td[@class='desktop-only ng-star-inserted']/a/span[normalize-space(text())='Book']");
					By loc_FlightNoLocator=By.xpath("//table[@class='table animation-on']//td/div[normalize-space(text()) = '"+strFlightSupplierName+"']/span[text() ='"+strFlightNo+" ']");
					By loc_FlightTerminalLocator=By.xpath("//table[@class='table animation-on']//td/div[normalize-space(text()) = '"+strFlightSupplierName+"']/parent::td/following-sibling::td//span[text()='"+strTerminal+"']");
					
					
					// Round trip
					By loc_FlightSearchResult=By.xpath("//div[@class='search--results ng-star-inserted']");
					By loc_FlightSearchTotalCount=By.xpath("//div[@class='search--results ng-star-inserted']//div[@class='ng-star-inserted']//table[@class='table animation-on isClickable']");
					By loc_ByDefaultSelectedFlightSearchResult=By.xpath("//div[@class='search--results ng-star-inserted']//div[@class='ng-star-inserted']//table[@class='table animation-on active isClickable']");
					By loc_BookButton=By.xpath("//a[normalize-space(text())='Book']");
					
					
				
										
					String strOriginUpperCase = objPojo.getObjUtilitiesFunctions().createFirstLetterCapitalToTheString(strOrigin);
					String strDestinationUpperCase =objPojo.getObjUtilitiesFunctions().createFirstLetterCapitalToTheString(strDestination);
					String strGetOrigin="";
					String strGetDestination="";
					
					strReturnVal=objPojo.getDriver().getTitle().toLowerCase().trim();
					

					if(strTripType.toLowerCase().equals("oneway")){	
					
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(locFlightResultCounter);
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(locTotalNoOfFlightCountByUsingBookButton);
					
					if(strTripType.toLowerCase().equals("oneway") && category.toLowerCase().equals("nondefence")){
						this.verify_FlightSearchOneway();
						this.VerifyDefenceFlagNOTSeen();
					}else {
						this.verify_FlightSearchOneway();
						this.VerifyDefenceFlagSeen();
					}
					
					int intCounter=objPojo.getDriver().findElements(locFlightResultBySupplierName).size();
					System.out.println("intCounter Value ----> "+intCounter);
					objPojo.getObjUtilitiesFunctions().logReporter("Flight search count is more than '0' ", "Flight search count should be a more than '0'", "Flight not display on the screen.", intCounter>0);
				
					if(intCounter>0){
						
						
						for (int intIndex = 1; intIndex <= intCounter; intIndex++) {
							
							By loc_AirportNameOrigin=By.xpath("//span[normalize-space(text()) = '"+strOriginUpperCase+"']");
							By loc_AirportNameDestination=By.xpath("//span[normalize-space(text()) = '"+strOriginUpperCase+"']/following::td/span[contains(.,'"+strDestinationUpperCase+"')]");
							By loc_TotalFlight=By.xpath("//div[@class='ng-star-inserted']["+intIndex+"]//table[@class='table animation-on']");
							
							if(objPojo.getObjSeleniumFunctions().checkElementDisplayed(locFlightResultBySupplierName)){
								objPojo.getObjSeleniumFunctions().scrollToView(locFlightResultBySupplierName);
							 strGetOrigin = objPojo.getObjSeleniumFunctions().getText(loc_AirportNameOrigin, "text").trim();
							 System.out.println("strGetOrigin Array ---> "+strGetOrigin);
							 strGetDestination = objPojo.getObjSeleniumFunctions().getText(loc_AirportNameDestination, "text").trim();
							 System.out.println("strGetDestination Array ---> "+strGetDestination);
							 		 
							 System.out.println("Terminal ---> "+strTerminal);
							 System.out.println("strOrigin ---> "+strOrigin);
							 
							 if(strOrigin.toLowerCase().trim().equals(strGetOrigin.toLowerCase().trim()) && strTerminal.toLowerCase().trim().equals(strGetDestination.toLowerCase().trim())){
								 objPojo.getObjUtilitiesFunctions().logReporter("Verify flight FlightSupplierName with Destination terminal", "Flight Flight Supplier Name :" +strFlightSupplierName +" and Detsination Terminal  Name : " +strTerminal + "displayed As Expected.", "Flight Flight Supplier Name :" +strFlightSupplierName +" and Detsination Terminal  Name : " +strTerminal + " mistmatch", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_FlightTerminalLocator));
								 System.out.println("count");
							 }
							 else
								 objPojo.getObjUtilitiesFunctions().logReporter("Verify search flight result by origin and destination airport name", "Search flight result origin "+strOrigin+" and Destination "+strDestination+" is same as expected.", "Search flight result  origin "+strGetOrigin.trim()+" and Destination "+strGetDestination.trim()+" is mistmatch", true);
							 
							}else {
								objPojo.getObjUtilitiesFunctions().logReporter("Verify search flight result by origin and destination airport name", "Search flight result origin "+strOrigin+" and Destination "+strDestination+" is same as expected.", "Search flight result  origin "+strGetOrigin.trim()+" and Destination "+strGetDestination.trim()+" is mistmatch", false);
							}
						}
						
					}		
					}else {
						
						By loc_FlightSearchTableCount=By.xpath("//div[@class='search--results ng-star-inserted'][1]");
						int intMainTblCount=objPojo.getDriver().findElements(loc_FlightSearchTableCount).size();
						
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_BookButton);
						
						if(strTripType.toLowerCase().equals("roundtrip") && category.toLowerCase().equals("nondefence")){
							this.verify_RoundTrip_FlightSearch();
							this.VerifyDefenceFlagNOTSeen();
						}else {
							this.verify_RoundTrip_FlightSearch();
							this.VerifyDefenceFlagSeen();
						}
						
						int intCounter=objPojo.getDriver().findElements(loc_FlightSearchResult).size();
						int intUnselectedFlightCount=objPojo.getDriver().findElements(loc_FlightSearchTotalCount).size();
						int intSelectedFlightCount=objPojo.getDriver().findElements(loc_ByDefaultSelectedFlightSearchResult).size();
						
						
						int intTotalFlightCount=intUnselectedFlightCount+intSelectedFlightCount;
						System.out.println("intTotalCount ---> "+intTotalFlightCount);
						
						objPojo.getObjUtilitiesFunctions().logReporter("Verify flight search 'Book' button is enabled.", "Flight 'Book' button should be enabled.", "Flight 'Book' button is not enabled.", objPojo.getObjSeleniumFunctions().checkElementEnabled(loc_BookButton));

						if(intCounter==4){
							
							objPojo.getObjUtilitiesFunctions().logReporter("Verify flight result count.", "Flight result count should be same as 'Filter' flight count.", "Flight result count and 'Filter' flight count is mistmatch.", intTotalFlightCount >0);
							
							By loc_ReturnFlight=By.xpath("//div[@class='depart-date light--text' and contains(.,'"+strDestinationUpperCase+"')]");
							By loc_ReturnFlight1=By.xpath("//div[@class='total-stops light--text']/span[text()=' "+strOriginUpperCase+" ']");
								
							String strGetOrigin_1 = objPojo.getObjSeleniumFunctions().getText(loc_ReturnFlight1, "text").trim();
							String strGetDestination_1 = objPojo.getObjSeleniumFunctions().getText(loc_ReturnFlight, "text").trim();

							 if(strOrigin.toLowerCase().equals(strGetOrigin_1.toLowerCase()) && strDestination.toLowerCase().equals(strGetDestination_1.toLowerCase()))
									System.out.println("Search Flight Passed");
							 else
							objPojo.getObjUtilitiesFunctions().logReporter("Verify round trip selected search fligt second side Origin and Destination. ", " Round trip selected search flight Origin : "+strOriginUpperCase+" and Destination : "+strDestinationUpperCase+ " .", "Search flight result not matched with As Expected ...Result Found Origin : "+strGetOrigin_1+" and Destination : "+strGetDestination_1+".", false);

								 
								 
							for (int intIndex = 1; intIndex <=intMainTblCount; intIndex++) {
							
							By loc_RoundTripBookFlight=By.xpath("//div[@class='footer-header__fixed animation-on desktop-only ng-star-inserted']//div[@class='search--results ng-star-inserted']["+intIndex+"]");
							By loc_RoundTripOrigin=By.xpath("//div[@class='footer-header__fixed animation-on desktop-only ng-star-inserted']//div[@class='search--results ng-star-inserted'][1]//div[@class='depart-date light--text' and contains(.,'"+strOriginUpperCase+"')]");
							By loc_RoundTripDestination=By.xpath("//div[@class='footer-header__fixed animation-on desktop-only ng-star-inserted']//div[@class='search--results ng-star-inserted'][1]//div/span[contains(.,'"+strDestinationUpperCase+" ')]");
							
							
							 strGetOrigin = objPojo.getObjSeleniumFunctions().getText(loc_RoundTripOrigin, "text").trim();
							 strGetDestination = objPojo.getObjSeleniumFunctions().getText(loc_RoundTripDestination, "text").trim();

							
							objPojo.getObjUtilitiesFunctions().logReporter("Verify round trip flight search two table displayed. ", "Search flight result should display in two table.", "Search flight result not display in two table.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_RoundTripBookFlight));
							
							 if(strOrigin.toLowerCase().equals(strGetOrigin.toLowerCase()) && strDestination.toLowerCase().equals(strGetDestination.toLowerCase()))
							System.out.println("Search Flight Passed");
							 else
							objPojo.getObjUtilitiesFunctions().logReporter("Verify round trip selected search fligt first side Origin and Destination. ", " Round trip selected search flight Origin : "+strOriginUpperCase+" and Destination : "+strDestinationUpperCase+ " .", "Search flight result not matched with As Expected ...Result Found Origin : "+strGetOrigin+" and Destination : "+strGetDestination+".", false);

							}
						}
					}
				}
			
				

	public void clickBookButton(){
	
	By btnBook=By.xpath("//span[text()='Book'][1]");
	By btnContinue=By.xpath("//a[text()='Go Back']/following-sibling::a[text()='Continue to add travellers ']");
	objPojo.getObjUtilitiesFunctions().logReporter("click on Book button.", objPojo.getObjSeleniumFunctions().click(btnBook));
	objPojo.getObjSeleniumFunctions().waitFor(5);
	objPojo.getObjUtilitiesFunctions().logReporter("click on Continue button.", objPojo.getObjSeleniumFunctions().click(btnContinue));


}

				
				
				
				
				
				
}
