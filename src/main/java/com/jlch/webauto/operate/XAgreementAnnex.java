package com.jlch.webauto.operate;

import org.testng.*;
import org.openqa.selenium.*;

import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.util.*;

public class XAgreementAnnex {
	public static void AgreementAnnex(WebDriver driver,String inputtext1){
//		PageElementOperate.selectById(driver, "selectUpload", selectUpload);//80054,协议附件归属债权
		PageElementOperate.selectByIdWithIndex(driver, "selectUpload", 1);//80054,协议附件归属债权
//		selectByIdWithIndex
		/**********************************附件上传********************************************/
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("document.getElementById('inputtext').removeAttribute('disabled');");
		PageElementOperate.waitTime(1);	
		driver.findElement(By.id("inputtext")).sendKeys("C:\\Chrysanthemum.jpg"); 
		driver.findElement(By.id("myfile")).sendKeys("C:\\Chrysanthemum.jpg"); 
//			PageElementOperate.setValueById(driver, "inputtext", "C:\\Chrysanthemum.jpg");
//			PageElementOperate.setValueById(driver, "myfile", "C:\\Chrysanthemum.jpg");
//			PageElementOperate.setValueById(driver, "agreementFile", "C:\\Chrysanthemum.jpg");		
		PageElementOperate.clickById(driver, "agreementFile");
		PageElementOperate.clickByXpath(driver, "//a[@class='m_btn4 blue_kuang ml20px' and @href = 'javascript:void(0)']");
		PageElementOperate.waitTime(10);
		PageElementOperate.clickByXpath(driver, ".//*[@id='MyDiv']/p[4]/input[1]");
		
	}

}
