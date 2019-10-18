package com.udchalo.pageFactory.admin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;

public class AdminDashboardPage {
	
	
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

			
			public AdminDashboardPage(Pojo pojo) {
				this.objPojo = pojo;
			}
		
			
			
			public void commonClickLNBTTabsOnAdminDashboardPage(String strLocMenuLinkText,String strLocDrpSubMenuLinkText,String strLocOpenedHeaderPageText){
				
				By loc_LNBT_Menubar=By.xpath("//div[@class='site-menubar']//ul[@class='site-menu']");
				By loc_Arrow_Locator=By.xpath("//a[@role='button']/i/span[text()='Toggle menubar']/parent::i[1]");
				By loc_lnk_Locators=By.xpath("//div[@class='site-menubar']//ul/li/a/span[text()='"+strLocMenuLinkText+"']");
				By loc_lnk_drp_sublinkLocators=By.xpath("//div[@class='site-menubar']//ul/li/a/span[text()='"+strLocMenuLinkText+"']/ancestor::li/ul/li/a/i/following-sibling::span[text()='"+strLocDrpSubMenuLinkText+"']");
				By loc_hdr_verifyOpenPage=By.xpath("//div[@class='page-header page-header-bordered']/h1[text()='"+strLocOpenedHeaderPageText+"']");
				
				
				
				objPojo.getObjSeleniumFunctions().waitFor(5);
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_LNBT_Menubar);
			
				if(objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_LNBT_Menubar)){
					
					objPojo.getObjUtilitiesFunctions().logReporter("LNBT navigation menu sidebar displayed ", true);
				}else {
					objPojo.getObjUtilitiesFunctions().logReporter("click on arrow for displaying menubar.", objPojo.getObjSeleniumFunctions().click(loc_Arrow_Locator));
				}
				
				if(strLocMenuLinkText.trim().equals("Bookings")|| strLocMenuLinkText.trim().equals("Suppliers")){
					
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnk_Locators);
					objPojo.getObjUtilitiesFunctions().logReporter("click on LNBT menulink "+ strLocMenuLinkText, "user can click on LNBT menu link - " +strLocMenuLinkText +" As expected.", "user not able to click on LNBT link - "+ strLocMenuLinkText, objPojo.getObjSeleniumFunctions().click(loc_lnk_Locators));
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnk_Locators);
					objPojo.getObjUtilitiesFunctions().logReporter("click on LNBT sub menulink "+ strLocDrpSubMenuLinkText, "user can click on LNBT sub menu link - " +strLocDrpSubMenuLinkText +" As expected.", "user not able to click on LNBT link - "+ strLocDrpSubMenuLinkText, objPojo.getObjSeleniumFunctions().click(loc_lnk_drp_sublinkLocators));

				}else {
					
					objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_lnk_Locators);
					objPojo.getObjUtilitiesFunctions().logReporter("click on LNBT menulink "+ strLocMenuLinkText, "user can click on LNBT menu link - " +strLocMenuLinkText +" As expected.", "user not able to click on LNBT link - "+ strLocMenuLinkText, objPojo.getObjSeleniumFunctions().click(loc_lnk_Locators));
				}
				
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_hdr_verifyOpenPage);
				strReturnVal=objPojo.getObjSeleniumFunctions().getText(loc_hdr_verifyOpenPage, "text");
				objPojo.getObjUtilitiesFunctions().logReporter("Verify opened page header- "+ strLocOpenedHeaderPageText, "user can see the new opened page header - " +strLocOpenedHeaderPageText +" As expected.", "user not able to see the opened page header - "+ strLocOpenedHeaderPageText,strReturnVal.trim().equals(strLocOpenedHeaderPageText.trim()) );

				
			
			}
			
			
			
			public void commonGlobalSearch(String strUserDrpOption,String strEmailDrpOption,String strSearchText){
				
				By loc_globalSearchBarLocator=By.xpath("//div[@id='site-navbar-collapse']//ul[@class='nav navbar-toolbar navbar-toolbar-form']");
				By loc_Drp_UserDropdownLocator=By.xpath("//div[@id='site-navbar-collapse']//ul[@class='nav navbar-toolbar navbar-toolbar-form']//udchalo-dropdown[@formcontrolname='option']/parent::div[@class='form-group']//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']/span[@class='icon md-chevron-down ui-c']");

				By loc_Drp_EmailLocators=By.xpath("//div[@id='site-navbar-collapse']//ul[@class='nav navbar-toolbar navbar-toolbar-form']//udchalo-dropdown[@formcontrolname='searchKey']/parent::div[@class='form-group']//div[@class='ui-dropdown-trigger ui-state-default ui-corner-right']/span[@class='icon md-chevron-down ui-c']");
				By loc_inp_globalSearchLocators=By.xpath("//div[@id='site-navbar-collapse']//ul[@class='nav navbar-toolbar navbar-toolbar-form']//udchalo-dropdown[@formcontrolname='searchKey']/parent::div[@class='form-group']/following-sibling::div[1]/input[@type='text']");
				By loc_btn_SearchLocator=By.xpath("//span[text()='Search']/parent::button[@type='submit']");
				
								
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_globalSearchBarLocator);
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_Drp_UserDropdownLocator);
				objPojo.getObjUtilitiesFunctions().logReporter("Select User dropdown option - "+ strUserDrpOption,"user can select user dropdown options on admin page.", "user not able to select user dropdown options on admin page.", objPojo.getObjSeleniumFunctions().setBootStrapInputTextForAdmin(loc_Drp_UserDropdownLocator, strUserDrpOption));
				
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_Drp_EmailLocators);
				objPojo.getObjUtilitiesFunctions().logReporter("Select Email dropdown option - "+ strEmailDrpOption,"user can select email dropdown options on admin page.", "user not able to select email dropdown options on admin page.", objPojo.getObjSeleniumFunctions().setBootStrapInputTextForAdmin(loc_Drp_EmailLocators, strEmailDrpOption));
				
				objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_globalSearchLocators);
				objPojo.getObjUtilitiesFunctions().logReporter("set serach text in searchbox on admin page - "+ strSearchText,"user can set search text in global search textbox on admin page", "user not able to set search text in global search textbox on admin page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_globalSearchLocators, strSearchText));

				if(objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btn_SearchLocator))
					objPojo.getObjUtilitiesFunctions().logReporter("click on global search 'Search' button on admin page", "user can click on search button on admin page As expected.", "user not able to click on search button on admin page.", objPojo.getObjSeleniumFunctions().click(loc_btn_SearchLocator));

				
				
			}
			
			
	public void verifyUserName(){
		By txtUserName=By.xpath("//span[text()='Yogesh Khachane']");
		objPojo.getObjUtilitiesFunctions().logReporter("Verify user profile name ", objPojo.getObjSeleniumFunctions().checkElementDisplayed(txtUserName));
	}
			
	

}
