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

public class XVerifyingProductPrice{
	public static void XVerifyingProductPrice_ok(WebDriver driver,String ExpectValue){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageElementOperate.clickByXpath(driver, ".//*[@id='left_container']/div[2]/div[1]/div[1]");//资产管理
		PageElementOperate.clickByXpath(driver, ".//*[@id='_easyui_tree_4']/span[3]");//理财产品管理
		/*******获取主frame***********/
		// Back up main page's handler
		String strMainHandler = driver.getWindowHandle();
		// Go to iframe
		WebElement tabs_content=driver.findElement(By.id("tabs_content"));//会员管理
		driver.switchTo().frame(tabs_content);
		PageElementOperate.waitTime(10);
		PageElementOperate.clickByXpath(driver, ".//*[@id='flowId2']");
		PageElementOperate.waitTime(30);
		PageElementOperate.clickByXpath(driver, ".//*[@id='datagrid-row-r2-2-0']/td[10]/div/a[2]");
		PageElementOperate.setValueById(driver, "saleCommFactor", "2");
		PageElementOperate.clickByXpath(driver, ".//*[@id='dlg-buttons']/a[1]/span/span[1]");
		Assert.assertTrue(TextPresent(driver,ExpectValue));
		PageElementOperate.clickByXpath(driver, "html/body/div[5]/div[2]/div[4]/a");
		//PageElementOperate.clickByXpath(driver, ".//*[@id='loginForm']/div/div/div[2]/div[1]/h3");
		// Go back to main frame
		driver.switchTo().window(strMainHandler);
		/**************************/
		//PageElementOperate.clickByXpath(driver, "html/body/div[5]/div[2]/div[4]/a");
		//driver.close();
	}
	private static boolean TextPresent(WebDriver driver,String what) {
		try{
			return driver.findElement(By.tagName("body")).getText().contains(what);
		}
		catch (Exception e){
			Screen.GetPicture(driver);
		return false;// û�и��ı� �� ���� false
		}
	}
}
