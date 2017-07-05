package com.jlch.webauto.operate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jlch.webauto.element.operate.PageElementOperate;

public class XFinanceProductCreation {
	public static void FinanceProductCreation(WebDriver driver,String uname,String productName,String purchaseAmount){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		PageElementOperate.clickById(driver, "000005");
		PageElementOperate.clickById(driver, "003000");
		PageElementOperate.clickById(driver, "003004");
		PageElementOperate.clickByXpath(driver, "//a[@class='reserve' and @onclick='releaseAsset()']");
		//PageElementOperate.clickByXpath(driver, "//a[@class='reserve' and @href='/appointment/book']");
		//PageElementOperate.clickByXpath(driver, "//*[contains(.,'" + content + "')]");
		String count=CommonOperate.DBreturnCount("c", "select count(*) from psd_appointment a,psd_user u where u.id=a.last_modified_by and u.username ='"+uname+"'");
		if(count.equalsIgnoreCase("0")){
			PageElementOperate.clickByXpath(driver, ".//*[@id='financeProductForm']/div[2]/div[1]/div[3]/a");
			PageElementOperate.clickByXpath(driver, "//*[contains(.,' 预订')]");
			PageElementOperate.clickByXpath(driver, ".//*[@id='assetInfo']/tbody/tr[6]/td[13]/a");
			PageElementOperate.clickByXpath(driver, ".//*[@id='content']/div/div[2]/p[2]/a[2]");
		}
		PageElementOperate.setValueById(driver, "productName", productName);
		PageElementOperate.setValueByName(driver, "purchaseAmount", purchaseAmount);
		PageElementOperate.clickById(driver, "raiseEndTime");
		/*******获取主frame***********/
		// Back up main page's handler  
		String strMainHandler = driver.getWindowHandle();
		// Go to iframe
		WebElement frame=driver.findElement(By.xpath("//iframe[@frameborder='0']"));
		driver.switchTo().frame(frame);
		PageElementOperate.clickById(driver, "dpTodayInput");
		// Go back to main frame  
		driver.switchTo().window(strMainHandler); 
		/**************************/
		//PageElementOperate.clickByXpath(driver, "//a[@href='/appointment/book']");
		PageElementOperate.waitTime(5);
		driver.findElement(By.name("configuredAccountList")).clear();
		PageElementOperate.setValueByName(driver, "configuredAccountList", "100000000");
		PageElementOperate.clickById(driver, "create_release_btn");
		
	}
}
