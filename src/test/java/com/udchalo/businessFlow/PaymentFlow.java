package com.udchalo.businessFlow;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;
import com.udchalo.pageFactory.HomePage;
import com.udchalo.pageFactory.PaymentPage;

/**
 * @ScriptName    : PaymentFlow
 * @Description   : This class covers all the manage flight booking flows   
 * 					
 * @Author        : udchalo QA Automation Developer
 * @since		  : 02-Aug-2019
 */
public class PaymentFlow {
	
	
	// Global Variables
			private Pojo objPojo;
			private String strUniqueKey = "";
			private String testData = "",testData1="", testData2="",testData3="",testData4="",testData5="";
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
			private PaymentPage objPaymentPage;
			
			public PaymentFlow(Pojo pojo) {
				this.objPojo = pojo;
				objHomePage = new HomePage(objPojo);
				objPaymentPage=new PaymentPage(objPojo);

			}

	
			public void doPayment(){
				
				if(objPaymentPage.getPaymentPageTitle().equals("Payment Page · Razorpay")){
					
					testData=objPojo.getObjUtilitiesFunctions().dataManagerString("locPaymentMethodText");
					System.out.println("testData ---> "+testData);
					testData1=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("strCardNaumber");
					System.out.println("testData1 ---> "+testData1);
					testData2=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("strExpiryDate");
					System.out.println("testData2 ---> "+testData2);
					testData3=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("strCVV");
					System.out.println("testData3 ---> "+testData3);
					testData4=objPojo.getObjUtilitiesFunctions().dataManagerString("strCardHolderName");
					System.out.println("testData4 ---> "+testData4);
					if (!testData.equals("") && !testData1.equals("") && !testData2.equals("")&& !testData3.equals("") && !testData4.equals(""))
					objPaymentPage.doPaymentForRazorPay(testData, testData1, testData2, testData3, testData4);
			
				}
				if (objPaymentPage.getPaymentPageTitle().equals("PayUbiz")) {
					
					testData=objPojo.getObjUtilitiesFunctions().dataManagerString("locCCPaymentMethodText");
					System.out.println("testData ---> "+testData);
					testData1=objPojo.getObjUtilitiesFunctions().dataManagerString("strCreditCardNaumber");
					System.out.println("testData1 ---> "+testData1);
					testData2=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("strNameOnCard");
					System.out.println("testData2 ---> "+testData2);
					testData3=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("strCVVNumber");
					System.out.println("testData3 ---> "+testData3);
					testData4=objPojo.getObjUtilitiesFunctions().dataManagerString("strMonthExpiry");
					System.out.println("testData4 ---> "+testData4);
					testData5=objPojo.getObjUtilitiesFunctions().dpStringTokenizer("strYearExpiry");
					System.out.println("testData5 ---> "+testData5);
					if (!testData.equals("") && !testData1.equals("") && !testData2.equals("")&& !testData3.equals("") && !testData4.equals("") &&!testData5.equals(""))
					objPaymentPage.doPaymentForPayU(testData,"5123456789012346" ,testData2 ,testData3,testData4, testData5);
					
				}
				
				if(objPaymentPage.isRazorPaySuccessButtonIsDisplayed())
					objPaymentPage.clickOnSuccessButtonOnRezorPay();
				
				
			}
			
			
	
	
	
	
	
	

}
