package com.jlch.webauto.operate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.util.Screen;

public class XCustomerManager {//订单管理
	public static void CustomerManager(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		PageElementOperate.clickById(driver, "000005");//账户中心
		PageElementOperate.clickById(driver, "004000");//客户管理
		PageElementOperate.clickByXpath(driver, ".//*[@id='content']/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[2]/a");//批量导入客户信息，缺id
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("document.getElementById('fileUrl').removeAttribute('disabled');");
		PageElementOperate.waitTime(1);
		String count1=CommonOperate.DBreturnCount("C", "select count(*) C from PSD_CUSTOMER");
		System.out.println(count1);
		driver.findElement(By.id("fileUrl")).sendKeys("C:\\customInfo.xlsx"); 
		driver.findElement(By.id("imageFile")).sendKeys("C:\\customInfo.xlsx");
		PageElementOperate.clickById(driver, "buttonCode");
		String count2=CommonOperate.DBreturn("c", "C", "select count(*) c from PSD_CUSTOMER");
		System.out.println(count2);
		int c1=Integer.parseInt(count1)+1;
		count1=String.valueOf(c1);
		Assert.assertTrue(count1.equalsIgnoreCase(count2));	
		driver.close();

		
	}
}
