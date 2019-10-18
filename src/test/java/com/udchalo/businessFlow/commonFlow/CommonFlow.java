package com.udchalo.businessFlow.commonFlow;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;
import com.udchalo.pageFactory.HomePage;
import com.udchalo.pageFactory.LoginPage;

/**
 * @ScriptName    : CommonFlow
 * @Description   : This class covers common functionality flows   
 * 					
 * @Author        : udchalo QA Automation Developer
 * @since		  : 23-August-2019
 */

public class CommonFlow {

	// Global Variable
	private Pojo objPojo;
	
	// Reference object of Pages
	private LoginPage objLoginPage;
	private HomePage objHomePage;

	// Constructor of class
	public CommonFlow(Pojo objPojo) {
		this.objPojo = objPojo;
		objLoginPage = new LoginPage(objPojo);
		objHomePage = new HomePage(objPojo);

	}

	// This common method will Refresh whole page - F5
	public void refreshWholePageF5() {
		By lnkFlight=By.xpath("//a[@class='logo-top active'][@routerlinkactive='active']");
		objPojo.getObjSeleniumFunctions().pageRefresh(lnkFlight);
		this.clearTempDirectory();
		objPojo.getObjSeleniumFunctions().waitFor(5);
	}
	
	public void clearTempDirectory(){
		
		objPojo.getObjSeleniumFunctions().deleteAllBrowserCookies();
	}

}
