package com.jlch.webauto.operate;

import org.testng.*;
import org.openqa.selenium.*;

import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.util.*;

public class XCheckMemberInfo{//客户信息上传
	public static void CheckMemberInfo(WebDriver driver,String companyName1,String companyCode1,String inputtext1,String inputtext2,String inputtext3){
		PageElementOperate.clickById(driver, "myState");
		PageElementOperate.setValueById(driver, "companyCode1", companyCode1);
		JavascriptExecutor j= (JavascriptExecutor)driver;
		System.out.println("removeAttribute");
		j.executeScript("document.getElementById('inputtext1').removeAttribute('disabled');");
		PageElementOperate.waitTime(1);
		j.executeScript("document.getElementById('inputtext2').removeAttribute('disabled');");
		PageElementOperate.waitTime(1);
		j.executeScript("document.getElementById('inputtext3').removeAttribute('disabled');");
		PageElementOperate.waitTime(1);
		driver.findElement(By.id("inputtext1")).sendKeys(inputtext1); 
		driver.findElement(By.id("inputtext2")).sendKeys(inputtext2); 
		driver.findElement(By.id("inputtext3")).sendKeys(inputtext3); 
		driver.findElement(By.id("imgFile1")).sendKeys(inputtext1);
		driver.findElement(By.id("imgFile2")).sendKeys(inputtext2);
		driver.findElement(By.id("imgFile3")).sendKeys(inputtext3);
		PageElementOperate.clickById(driver, "determine1");
	}
}
