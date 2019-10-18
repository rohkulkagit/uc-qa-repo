package com.udchalo.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.udchalo.generic.Pojo;
/**
 * @ScriptName    : HomePage
 * @Description   : This class is dedicated for HomePage of udchalo.com.
 * 					It contains xpath of all the elements & its related methods
 * @Author        : udchalo QA Automation Developer
 * @since         : 26-Aug-2019
 */

public class ModifySearchPage {
	
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

		
		public ModifySearchPage(Pojo pojo) {
			this.objPojo = pojo;
		}
	
	
	//locators
		
		By loc_inpOriginModifySearch = By.xpath("//label[text()='Origin*']/following::span[1]/input[@type='text']");
		By loc_inpDestinationModifySearch = By.xpath("//label[text()='Destination*']/following::span[1]/input[@type='text']");
		By loc_chkMSI_Am_From_The_Defence_Forces=By.xpath("//input[@id='isDefenceSearch'][@type='checkbox']");
		By loc_btnMSSearch = By.xpath("//span[.='Search']/parent::button");
		
		By loc_lnkIconSwap = By.xpath("//i[contains(@class,'swap-icon')]");
		
	//methods
		public void clickOnSwapIcon(){
			objPojo.getObjSeleniumFunctions().waitFor(1);
			objPojo.getObjUtilitiesFunctions().logReporter("Click on swap-icon on Modify Search",this.objPojo.getObjSeleniumFunctions().click(loc_lnkIconSwap));
		}
		
		public void getOriginInModifySearchPage(){
			objPojo.getObjSeleniumFunctions().waitFor(1);
			String value = this.objPojo.getObjSeleniumFunctions().getText(loc_inpOriginModifySearch, "value");
			objPojo.getObjUtilitiesFunctions().logReporter("Get Origin From Modify Search. value = "+value,!value.equals(null));
			objPojo.getObjSeleniumFunctions().waitFor(50);
		}
			
}
