package com.udchalo.pageFactory;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.udchalo.generic.Pojo;

/**
 * @ScriptName    : VerifyYourDetailsPage
 * @Description   : This class is dedicated for popup-page 'Verify Your Details' of udchalo.com.
 * 					It contains xpath of all the elements & its related methods
 * @Author        : udchalo QA Automation Developer
 * @since         : 12-Aug-2019
 */


public class VerifyYourDetailsPage {
	
	
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
			private int intRow = 0;
			private int intColumn = 0;

			
			public VerifyYourDetailsPage(Pojo pojo) {
				this.objPojo = pojo;
			}
	
			
			//Locators
			
			By loc_hdrVerifyYourDetails=By.xpath("//div[@class='formHeading desktop-only' and text()=' Verify your Details'][@id='formHeading']");
			
			By loc_hdrVerifyYourDetailsPageActive=By.xpath("//div[@class='formHeading desktop-only' and text()=' Verify your Details']/ancestor::div[2]//div[2]");
			
			By loc_inpIndianArmy=By.xpath("//label[text()='Army Number*']/following-sibling::input[1]");
			
			
			By loc_btnContinue=By.xpath("//button[@type='submit']/span[text()='Continue ']");
			
		
			
	//Methods related to the web elements on popup-page "Verify Your Details"		
			public void verifyVerifyYourDetailsPageActive(){
				objPojo.getObjUtilitiesFunctions().logReporter("'Verify your Details' page active", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_hdrVerifyYourDetailsPageActive));
			}
			
			public void verify_VerifyYourDetailsPage_Header_Displayed(){
				this.verifyVerifyYourDetailsPageActive();
				objPojo.getObjUtilitiesFunctions().logReporter("Verified ..! 'Verify your Details' page displayed.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_hdrVerifyYourDetails));	
			}
			
			
			public void setArmyNumber_On_VerifyYourDetailsPage(String strVerificationCode){
				
				objPojo.getObjUtilitiesFunctions().logReporter("set Indian Army verification code on 'Verify your Details' page.", strVerificationCode, objPojo.getObjSeleniumFunctions().setText(loc_inpIndianArmy, strVerificationCode));
			}
	
	public void click_Continue_On_VrifyYourDetailsPage(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("click on 'Continue' button on 'Verify your Details' page.", objPojo.getObjSeleniumFunctions().click(loc_btnContinue));
	}

}
