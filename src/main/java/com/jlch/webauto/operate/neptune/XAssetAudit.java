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

import com.gargoylesoftware.htmlunit.Page;
import com.jlch.webauto.element.operate.PageElementOperate;
import com.jlch.webauto.util.Screen;

public class XAssetAudit {
	public static void MemberManager_ok(WebDriver driver,String ExpectValue){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		PageElementOperate.clickByXpath(driver, ".//*[@id='left_container']/div[2]/div[1]/div[1]");
		PageElementOperate.clickByXpath(driver, ".//*[@id='_easyui_tree_1']/span[3]");
		  /*******获取主frame***********/
		  // Back up main page's handler
		  String strMainHandler = driver.getWindowHandle();
		  // Go to iframe
		  WebElement tabs_content=driver.findElement(By.id("tabs_content"));//会员管理
		  driver.switchTo().frame(tabs_content);
			PageElementOperate.clickByXpath(driver, "//*[contains(.,'审核')]");
			PageElementOperate.selectById(driver, "assetRating", "00320001");
			PageElementOperate.selectById(driver, "remark", "测试");
			PageElementOperate.clickById(driver, ".//*[@id='divInFinancing']/div/div/div[2]/div[2]/div[2]");
			PageElementOperate.clickByXpath(driver, "html/body/div[4]/div[2]/div[4]/a");
		  /****************************************************************************/
		  // Go back to main frame
		  driver.switchTo().window(strMainHandler);
		  /**************************/
	}

}
