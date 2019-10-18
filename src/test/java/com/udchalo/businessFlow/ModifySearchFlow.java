package com.udchalo.businessFlow;

import java.util.List;

import org.openqa.selenium.WebElement;
import com.udchalo.generic.Pojo;
import com.udchalo.pageFactory.HomePage;
import com.udchalo.pageFactory.ModifySearchPage;
import com.udchalo.pageFactory.VerifyYourDetailsPage;

import ru.yandex.qatools.allure.annotations.Step;

/**
 * @ScriptName    : ModifySearchFlow
 * @Description   : This class covers all the flows related to modify search functionality.   
 * 					
 * @Author        : udchalo QA Automation Developer
 * @since		  : 26-Aug-2019
 */
public class ModifySearchFlow {
	
	
	// Global Variables
		private Pojo objPojo;
		private String strUniqueKey = "";
		private String testData = "",testData1="", testData2="",testData3="";
		private String locTestData="";
		private Integer intTestData = null;
		private String strReturnVal = "";
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
		private  ModifySearchPage objModifySearchPage;

		public ModifySearchFlow(Pojo pojo) {
			this.objPojo = pojo;
			objHomePage = new HomePage(objPojo);
			objVerifyYourDetailsPage=new VerifyYourDetailsPage(objPojo);
			objModifySearchPage = new ModifySearchPage(objPojo);

		}
		/**
		 * @MethodName:	 SwapOriginDestination
		 * @Description: This method swap Origin & Destination on 'Modify Search' page.
		 * @since:		 26-Aug-2019
		 * @author : 	 udChalo QA Automation developer
		 */
		@Step("Steps Details --> " + "Swap Origin Destination On Modify Search page")
		public void SwapOriginDestination(){
		
			objModifySearchPage.clickOnSwapIcon();
			objModifySearchPage.getOriginInModifySearchPage();
			//objFlightSearchPage.EnterOrigin();
			//objFlightSearchPage.EnterDestination();
			//objFlightSearchPage.
			//VerifyModifySearchOneWayNonDefence();
		}
	
}
