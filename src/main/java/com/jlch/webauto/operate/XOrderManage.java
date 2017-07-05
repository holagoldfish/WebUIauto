package com.jlch.webauto.operate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.util.Screen;

public class XOrderManage {//订单管理
	public static void OrderManage(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		PageElementOperate.clickById(driver, "000005");//账户中心
		PageElementOperate.clickById(driver, "003000");//资金管理
		PageElementOperate.clickById(driver, "003006");//订单管理

		PageElementOperate.selectById(driver, "multiFlowId", "待付款");
		String code = driver.findElement(By.xpath(".//*[@id='orderLi']/div[3]/div/table/tbody/tr[2]/td[1]")).getText();
		System.out.println(code);	
		PageElementOperate.clickByXpath(driver, ".//*[@id='orderLi']/div[3]/div/table/tbody/tr[2]/td[12]/a[2]");
		String status = CommonOperate.DBreturn(code, "FLOW_ID", "select p.flow_id from poseidon.psd_order p where p.code ="+code);
		//System.out.println(status);
		Assert.assertTrue(status.equalsIgnoreCase("已付款"));	
	}
}
