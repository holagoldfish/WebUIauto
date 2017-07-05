package com.jlch.webauto.operate.neptune;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jlch.webauto.element.operate.PageElementOperate;
import com.jlch.webauto.util.Screen;

public class XMemberManager {
	public static void MemberManager_ok(WebDriver driver,String ExpectValue){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 

		PageElementOperate.clickByXpath(driver, ".//*[@id='left_container']/div[1]/div[1]/div[1]");//会员管理
		PageElementOperate.clickByXpath(driver, ".//*[@id='_easyui_tree_1']/span[3]");//会员管理
		  /*******获取主frame***********/
		  // Back up main page's handler
		  String strMainHandler = driver.getWindowHandle();
		  // Go to iframe
		  WebElement tabs_content=driver.findElement(By.id("tabs_content"));//会员管理
		  driver.switchTo().frame(tabs_content);	
		  PageElementOperate.clickById(driver, "status1");//选择待审核
		  PageElementOperate.clickByXpath(driver, ".//*[@id='paramForm']/table/tbody/tr[1]/td[5]/a/span/span[2]");//点击查询
		  PageElementOperate.clickByXpath(driver, ".//*[@id='datagrid-row-r1-2-0']/td[10]/div/a[3]");//点击审核按钮，审核第一列
		  PageElementOperate.selectById(driver, "flowId", "审核通过");
		  PageElementOperate.setValueById(driver, "auditRemark", "自动化测试");
		  PageElementOperate.clickById(driver, "submit");
		  /******************************/
		  PageElementOperate.waitTime(5);
		  Assert.assertTrue(TextPresent(driver, ExpectValue));
		  PageElementOperate.clickByXpath(driver, "html/body/div[1]/div[2]/div[4]/a");
		  // Go back to main frame
		  driver.switchTo().window(strMainHandler);
		  /**************************/
	}

	private static boolean TextPresent(WebDriver driver,String what) {
		try{
			return driver.findElement(By.tagName("body")).getText().contains(what);
		}
		catch (Exception e){
			Screen.GetPicture(driver);
		return false;// 
		}
	}
	
}
