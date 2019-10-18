package com.udchalo.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;

public class TravellersDetailsPage {
	
	
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

			
			public TravellersDetailsPage(Pojo pojo) {
				this.objPojo = pojo;
			
			}
		
			
			By loc_chkPayFromUdchaloCredits=By.xpath("//div[@class='pay-from-wallet ng-star-inserted']/p[text()='Pay From udChalo Credits']/following-sibling::input/parent::div/label[contains(.,'Pay from udChalo Credits.')]/preceding-sibling::input[1]");
			By loc_rb_CreditCardsWalletUPI=By.xpath("//div[@class='payment-methods']//i[@class='icon md-check text-success mobile-only ng-star-inserted']/preceding::label[@for='payu_method'][contains(.,'Credit Cards/Wallet/UPI ')]");
			By loc_btn_ProceedToPay=By.xpath("//i[@class='icon md-chevron-right mobile-only']/preceding-sibling::span[text()='Proceed to pay '][1]");
			
			
			
			
			public void commonAddTravellersDetailsOnTravellersDetailsPage(String strAdults,String strChilds,String strInfants){

				int intCounter=0;
				String strTitle="";
				
				
				if(Integer.parseInt(strAdults) >=1){
					
					String strFirstName="FN";
					String strLastName="LN";
					
					while (true) {
						
						intCounter++;
						strTitle=objPojo.getObjUtilitiesFunctions().getAdultsTitlesForTravellersDetails();
						System.out.println("Random Titles ----> "+objPojo.getObjUtilitiesFunctions().getAdultsTitlesForTravellersDetails());
					    By drpSelectTitle=By.xpath("//div[normalize-space(text()) ='Adult "+intCounter+"']/following-sibling::div//label[text()='Select Title']/parent::div[1]");
					    By inpFirstName=By.xpath("//div[normalize-space(text()) ='Adult "+intCounter+"']/following-sibling::div//label[text()='First Name*']/following-sibling::input[@placeholder='First Name*']");
						By inpLastName=By.xpath("//div[normalize-space(text()) ='Adult "+intCounter+"']/following-sibling::div//label[text()='Last Name*']/following-sibling::input[@placeholder='Last Name*']");
					    
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(drpSelectTitle);
						objPojo.getObjSeleniumFunctions().scrollToView(drpSelectTitle);
						objPojo.getObjSeleniumFunctions().waitFor(2);
						objPojo.getObjUtilitiesFunctions().logReporter("set traveller adult title", strAdults, objPojo.getObjSeleniumFunctions().setBootStrapInputTextDropdown(drpSelectTitle,strTitle));
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(inpFirstName);
						objPojo.getObjUtilitiesFunctions().logReporter("Set Traveller adult First Name. ", "User can add adult First Name in travellers details ","User not able to set adult First Name in travellers details.", objPojo.getObjSeleniumFunctions().setText(inpFirstName, strFirstName+objPojo.getObjUtilitiesFunctions().getRandomStringWithSmallAndCapitalLetters(6)));
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(inpLastName);
						objPojo.getObjUtilitiesFunctions().logReporter("Set Traveller Last Name. ", "User can add adult Last Name in travellers details ","User not able to set adult Last Name in travellers details.", objPojo.getObjSeleniumFunctions().setText(inpLastName, strLastName+objPojo.getObjUtilitiesFunctions().getRandomStringWithSmallAndCapitalLetters(6)));

						System.out.println("counter ++  val ---> "+intCounter);
						if(intCounter < Integer.parseInt(strAdults)){
							objPojo.getObjUtilitiesFunctions().logReporter("Set Next Adult Title.", true);
							continue;
						}else {
							System.out.println("In Else ");
							intCounter=0;
							break;
						}
					}	
					
				} 	if(Integer.parseInt(strChilds) >=1){
				
					String strFirstName="FN";
					String strLastName="LN";
				
					while (true) {
						
						intCounter++;
					    By drpSelectTitle=By.xpath("//div[normalize-space(text()) ='Child "+intCounter+"']/following-sibling::div//label[text()='Select Title']/parent::div[1]");
					    By inpFirstName=By.xpath("//div[normalize-space(text()) ='Child "+intCounter+"']/following-sibling::div//label[text()='First Name*']/following-sibling::input[@placeholder='First Name*']");
					    By inpLastName=By.xpath("//div[normalize-space(text()) ='Child "+intCounter+"']/following-sibling::div//label[text()='Last Name*']/following-sibling::input[@placeholder='Last Name*']");
					    
						strTitle=objPojo.getObjUtilitiesFunctions().getChildsTitlesForTravellersDetails();
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(drpSelectTitle);
						objPojo.getObjSeleniumFunctions().scrollToView(drpSelectTitle);
						objPojo.getObjSeleniumFunctions().waitFor(2);
						objPojo.getObjUtilitiesFunctions().logReporter("set travellers title ", strChilds, objPojo.getObjSeleniumFunctions().setBootStrapInputTextDropdown(drpSelectTitle,strTitle));
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(inpFirstName);
						objPojo.getObjUtilitiesFunctions().logReporter("Set Traveller child First Name. ", "User can add child First Name in travellers details ","User not able to set child First Name in travellers details.", objPojo.getObjSeleniumFunctions().setText(inpFirstName, strFirstName+objPojo.getObjUtilitiesFunctions().getRandomStringWithSmallAndCapitalLetters(6)));
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(inpLastName);
						objPojo.getObjUtilitiesFunctions().logReporter("Set Traveller child Last Name. ", "User can add child Last Name in travellers details ","User not able to set child Last Name in travellers details.", objPojo.getObjSeleniumFunctions().setText(inpLastName, strLastName+objPojo.getObjUtilitiesFunctions().getRandomStringWithSmallAndCapitalLetters(6)));
			
						if(intCounter < Integer.parseInt(strChilds)){
							
							objPojo.getObjUtilitiesFunctions().logReporter("Set Next Child Title.", true);
							continue;
						}else {
							System.out.println("In Else ");
							intCounter=0;
							break;
						}
						
					}

					
				}	if(Integer.parseInt(strInfants) >=1){
				
					String strFirstName="FN";
					String strLastName="LN";
				
					while (true) {
						
						intCounter++;
					    By drpSelectTitle=By.xpath("//div[normalize-space(text()) ='Infant "+intCounter+"']/following-sibling::div//label[text()='Select Title']/parent::div[1]");
					    By inpFirstName=By.xpath("//div[normalize-space(text()) ='Infant "+intCounter+"']/following-sibling::div//label[text()='First Name*']/following-sibling::input[@placeholder='First Name*']");
					    By inpLastName=By.xpath("//div[normalize-space(text()) ='Infant "+intCounter+"']/following-sibling::div//label[text()='Last Name*']/following-sibling::input[@placeholder='Last Name*']");
					    By iconDatePicker=By.xpath("//div[normalize-space(text()) ='Infant "+intCounter+"']/following-sibling::div[@class='float-group text--align--left']//input[@aria-label='Date input field']/following-sibling::i[1]");
					    
						strTitle=objPojo.getObjUtilitiesFunctions().getInfantsTitlesForTravellersDetails();
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(drpSelectTitle);
						objPojo.getObjSeleniumFunctions().scrollToView(drpSelectTitle);
						objPojo.getObjSeleniumFunctions().waitFor(2);
						objPojo.getObjUtilitiesFunctions().logReporter("set traveller Infants title ", strChilds, objPojo.getObjSeleniumFunctions().setBootStrapInputTextDropdown(drpSelectTitle, strTitle));
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(inpFirstName);
						objPojo.getObjUtilitiesFunctions().logReporter("Set Traveller Infants First Name. ", "User can add Infants First Name in travellers details ","User not able to set Infants First Name in travellers details.", objPojo.getObjSeleniumFunctions().setText(inpFirstName, strFirstName+objPojo.getObjUtilitiesFunctions().getRandomStringWithSmallAndCapitalLetters(6)));
						objPojo.getObjSeleniumFunctions().checkElementDisplayed(inpLastName);
						objPojo.getObjUtilitiesFunctions().logReporter("Set Traveller Infants Last Name. ", "User can add Infants Last Name in travellers details ","User not able to set Infants Last Name in travellers details.", objPojo.getObjSeleniumFunctions().setText(inpLastName, strLastName+objPojo.getObjUtilitiesFunctions().getRandomStringWithSmallAndCapitalLetters(6)));
						objPojo.getObjUtilitiesFunctions().logReporter("Set Infants date of birth ", "User can set date of birth of infants in traveller details. ","User not able to set date of birth in travellers details.",objPojo.getObjSeleniumFunctions().datePickerForInfants(iconDatePicker));

						if(intCounter < Integer.parseInt(strInfants)){
							
							objPojo.getObjUtilitiesFunctions().logReporter("Set Next Infants Title.", true);
							continue;
						}else {
							System.out.println("In Else ");
							intCounter=0;
							break;
						}
						
						
					}

					
				}	
				
				
			}
			
			
			public void uncheckPayFromUdchaloCredit(){
				
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_chkPayFromUdchaloCredits);
				objPojo.getObjUtilitiesFunctions().logReporter("deselect pay from udchalo credit", "user deselect pay from udchalo credit checkbox","User not able to deselect pay from udchalo credit checkbox.", objPojo.getObjSeleniumFunctions().selectCheckBox(loc_chkPayFromUdchaloCredits, false));	
			
			}
			

			public void selctPaymentMethod(String strPaymentMethodText){
				By loc_rbPaymentMethod=By.xpath("//div[@class='payment-methods']//i[@class='icon md-check text-success mobile-only ng-star-inserted']/preceding::label[contains(.,'"+strPaymentMethodText+" ')]");
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_rbPaymentMethod);
				objPojo.getObjUtilitiesFunctions().logReporter("Select payment method on travellers details page. ","User can select payment method on travellers details page.","User not able to select payment method on travellers details page.", objPojo.getObjSeleniumFunctions().selectRadioButton(loc_rbPaymentMethod, true));
			
			}
			
			
			public void clickOnProceedToPayOnTravellersDetailsPage(){
				
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btn_ProceedToPay);
				objPojo.getObjUtilitiesFunctions().logReporter("click on 'PROCEED TO PAY' button on travellers details page.", "usercan click on 'PROCEED TO PAY' button on travellers details page.", "user not able to click on 'PROCEED TO PAY' button on travellers details page.", objPojo.getObjSeleniumFunctions().click(loc_btn_ProceedToPay));
				
			}
	
			
				
				
			
			
			

}
