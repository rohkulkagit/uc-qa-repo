package com.udchalo.admin.businessFlow;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;
import com.udchalo.pageFactory.admin.AdminDashboardPage;
import com.udchalo.pageFactory.admin.AdminLoginPage;

public class AdminDashboardFlow {
	
	// Global Variable
			private Pojo objPojo;
			private String strUniqueKey = "";
			private String testData = "", testData1 = "",testData2="";
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
			private AdminLoginPage objAdminLoginPage;
			private AdminDashboardPage objAdminDashboardPage;
		

			// Constructor of class
			public AdminDashboardFlow(Pojo pojo) {
				this.objPojo = pojo;
				objAdminLoginPage = new AdminLoginPage(objPojo);
				objAdminDashboardPage = new AdminDashboardPage(objPojo);
			}
			
			
			
			
			public void goToLNBTMenuTabs(){
				
				
				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("strLocMenuLinkText");
				testData1=objPojo.getObjUtilitiesFunctions().dataManagerString("strLocDrpSubMenuLinkText");
				testData2=objPojo.getObjUtilitiesFunctions().dataManagerString("strLocOpenedHeaderPageText");
				if (!testData.equals(""))
				objAdminDashboardPage.commonClickLNBTTabsOnAdminDashboardPage(testData, testData1, testData2);
				
			}
			
			
			public void commonGlobalSearchInAdmin(){
				
				testData=objPojo.getObjUtilitiesFunctions().dataManagerString("strUserDrpOption");
				testData1=objPojo.getObjUtilitiesFunctions().dataManagerString("strEmailDrpOption");
				testData2=objPojo.getObjUtilitiesFunctions().dataManagerString("strSearchText");
				if (!testData.equals(""))
				objAdminDashboardPage.commonGlobalSearch(testData, testData1, testData2);
			}
	
	
	
	

}
