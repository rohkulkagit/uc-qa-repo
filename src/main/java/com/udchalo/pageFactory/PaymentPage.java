package com.udchalo.pageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.udchalo.generic.Pojo;

public class PaymentPage {
	
	
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

				
				public PaymentPage(Pojo pojo) {
					this.objPojo = pojo;
				
				}
			
				By loc_hdrRazorPayPaymentPageActive=By.xpath("//div[@class='content payment-form selected']");	
				By loc_hdr_PayUPaymentPageActive=By.xpath("//div[@class='pcpPanel ui-tabs-panel ui-widget-content ui-corner-bottom']//div[@id='payment-box']");
				
				By loc_inp_CardNumber=By.xpath("//label[text()='Card Number']/following-sibling::input[@type='tel']");
				By loc_inp_ExpiryDate=By.xpath("//label[text()='Expiry Date']/following-sibling::input[@type='tel']");
				By loc_inp_CVV=By.xpath("//label[text()='CVV']/following-sibling::input[@type='password']");
				By loc_inp_CardHoldersName=By.xpath("//button[text()='Pay Now']/preceding::div[1]/input[@name='card[name]']");
				By loc_btn_PayNow=By.xpath("//button[text()='Pay Now'][@id='pay-now']");
				By loc_btnSuccess_RazorPay=By.xpath("//button[@class='success' and text()='Success']");
				
				// Pay U
				By loc_inp_CC_CardNumber=By.xpath("//label[text()='Card Number']/following-sibling::input[@id='ccard_number']");
				By loc_inp_CC_NameOnCard=By.xpath("//label[text()='Name on Card']/following-sibling::input[@id='cname_on_card']");
				By loc_inp_CC_CVVNumber=By.xpath("//label[text()='CVV Number']/following-sibling::input[@id='ccvv_number']");
				By loc_drp_CC_ExpiryDateMonth=By.xpath("//select[@id='cexpiry_date_month']");
				By loc_drp_CC_ExpiryDateYear=By.xpath("//select[@id='cexpiry_date_year']");
				By loc_btn_CC_PayNow=By.xpath("//span[text()=' or Go back to ']/preceding-sibling::input[@id='pay_button'][@name='pay_button'][1]");
				
				
	public String getPaymentPageTitle(){
		
		objPojo.getObjSeleniumFunctions().waitFor(2);
		strReturnVal=objPojo.getDriver().getTitle().trim();
		return strReturnVal;
	}
	
	public void verifyRazorPayPaymentPageIsActive(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("Razor Pay payment page is active.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_hdrRazorPayPaymentPageActive));
		
	}
	
	public void verifyPayUPaymentPageIsActive(){
		
		objPojo.getObjUtilitiesFunctions().logReporter("PayU payment page is active.", objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_hdr_PayUPaymentPageActive));
		
	}
	
	
	
	
	
	
	public void doPaymentForRazorPay(String strPaymentMethodText,String strCardNaumber,String strExpiryDate,String strCVV,String strCardHolderName){
		
		By loc_payment_Method=By.xpath("//span[text()='"+strPaymentMethodText+"']");
		By loc_CreditAndDebitCardIsSelected=By.xpath("//li[@class='active']");
		objPojo.getObjSeleniumFunctions().waitFor(3);
		objPojo.getObjUtilitiesFunctions().logReporter("Razor Pay payment page is opened....", true);
	//	this.verifyRazorPayPaymentPageIsActive();
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_payment_Method);
		if(objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_CreditAndDebitCardIsSelected)){
			objPojo.getObjUtilitiesFunctions().logReporter("'Credit/Debit Card' payment method is selected.", true);
		}else {
			objPojo.getObjUtilitiesFunctions().logReporter("click on 'Credit/Debit Card' payment method on razor pay payment page.", "user can click on 'Credit/Debit Card' option in payment method on razr pay payment page.", "User not able to click on 'Credit/Debit Card' option on razor pay payment page.", objPojo.getObjSeleniumFunctions().click(loc_payment_Method));
		}
		
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_CardNumber);
		objPojo.getObjUtilitiesFunctions().logReporter("set card number on razor pay payment page.","user can set card number on razor pay payment page.", "user not able to set card number on razor pay payment page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_CardNumber, strCardNaumber));
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_ExpiryDate);
		objPojo.getObjUtilitiesFunctions().logReporter("set card expiry date on razor pay payment page.","user can set card expiry date on razor pay payment page.", "user not able to set card expiry date on razor pay payment page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_ExpiryDate, strExpiryDate));
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_CVV);
		objPojo.getObjUtilitiesFunctions().logReporter("set card 'CVV' number on razor pay payment page.","user can set card 'CVV' number on razor pay payment page.", "user not able to set card 'CVV' number on razor pay payment page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_CVV, strCVV));
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_CardHoldersName);
		objPojo.getObjUtilitiesFunctions().logReporter("set card 'Card HolderName' on razor pay payment page.","user can set cardholder name on razor pay payment page.", "user not able to set cardholder name on razor pay payment page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_CardHoldersName, strCardHolderName));
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btn_PayNow);
		objPojo.getObjUtilitiesFunctions().logReporter("click on 'Pay Now' button on razor pay payment page.", "user can click 'Pay Now' button on razor pay payment page.", "user naot able to click on 'Pay Now' button on razor pay payment page.", objPojo.getObjSeleniumFunctions().click(loc_btn_PayNow));
		
	}
	
	
	public void doPaymentForPayU(String locCCPaymentMethodText,String strCreditCardNaumber,String strNameOnCard,String strCVVNumber,String strMonthExpiry,String strYearExpiry){
		
		By loc_payment_Method=By.xpath("//a[text()='"+locCCPaymentMethodText+"']");
		By loc_CreditAndDebitCardIsSelected=By.xpath("//li[@class='ui-state-default ui-corner-top ui-tabs-selected ui-state-active']");
		objPojo.getObjSeleniumFunctions().waitFor(3);
		objPojo.getObjUtilitiesFunctions().logReporter("Pay U payment page is opened....", true);
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_payment_Method);
		if(objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_CreditAndDebitCardIsSelected)){
			objPojo.getObjUtilitiesFunctions().logReporter("'Credit Card' payment method is selected.", true);
		}else {
			objPojo.getObjUtilitiesFunctions().logReporter("click on 'Credit Card' payment method on Pay U payment page.", "user can click on 'Credit Card' option in payment method on Pay U payment page.", "User not able to click on 'Credit Card' option on Pay U payment page.", objPojo.getObjSeleniumFunctions().click(loc_payment_Method));
		}
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_CC_CardNumber);
		objPojo.getObjUtilitiesFunctions().logReporter("set credit card number on Pay U payment page.","user can set credit card number on Pay U payment page.", "user not able to set credit card number on Pay U payment page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_CC_CardNumber, strCreditCardNaumber));
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_CC_NameOnCard);
		objPojo.getObjUtilitiesFunctions().logReporter("set 'Name on Card' on Pay U payment page.","user can set  name on Pay U payment page.", "user not able to set name on Pay U payment page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_CC_NameOnCard, strNameOnCard));
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_inp_CC_CVVNumber);
		objPojo.getObjUtilitiesFunctions().logReporter("set CVV' number on Pay U payment page.","user can set 'CVV' number on Pay U payment page.", "user not able to set 'CVV' number on Pay U payment page.", objPojo.getObjSeleniumFunctions().setText(loc_inp_CC_CVVNumber, strCVVNumber));
		
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_drp_CC_ExpiryDateMonth);
		objPojo.getObjUtilitiesFunctions().logReporter("set card expiry date for month on pay U pay payment page.","user can set expiry date for month on Pay U payment page.", "user not able to set  expiry date for month on Pay U payment page.", objPojo.getObjSeleniumFunctions().selectDropDownOption(loc_drp_CC_ExpiryDateMonth, strMonthExpiry,"Text"));
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_drp_CC_ExpiryDateYear);
		objPojo.getObjUtilitiesFunctions().logReporter("set card expiry date for year on pay U pay payment page.","user can set expiry date for year on Pay U payment page.", "user not able to set  expiry date for year on Pay U payment page.", objPojo.getObjSeleniumFunctions().selectDropDownOption(loc_drp_CC_ExpiryDateYear, strYearExpiry,"Value"));
		
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btn_CC_PayNow);
		objPojo.getObjUtilitiesFunctions().logReporter("click on 'Pay Now' button on pay U payment page.", "user can click 'Pay Now' button on pay U payment page.", "user naot able to click on 'Pay Now' button on pay U payment page.", objPojo.getObjSeleniumFunctions().click(loc_btn_CC_PayNow));
		
	}
	
	
	public boolean isRazorPaySuccessButtonIsDisplayed(){
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnSuccess_RazorPay);
		return objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnSuccess_RazorPay);
		
	}
	
	public void clickOnSuccessButtonOnRezorPay(){
		
		objPojo.getObjSeleniumFunctions().checkElementDisplayed(loc_btnSuccess_RazorPay);
		objPojo.getObjUtilitiesFunctions().logReporter("click on 'Success' button on razor pay payment page.","user can click 'Success'on razor pay button on razor pay payment page.", "user not able to click on 'Success' razor pay button on razor pay page.", objPojo.getObjSeleniumFunctions().click(loc_btnSuccess_RazorPay));
	}
	

}
