package com.jlch.webauto.operate;

import org.testng.*;

import com.jlch.webauto.util.*;
import com.jlch.webauto.element.operate.*;
import com.opera.core.systems.scope.protos.ExecProtos.ActionList.Action;
import com.thoughtworks.selenium.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByXPath;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class XPostedAssets {//资产发布
	public static void PostedAssets(WebDriver driver,String projectName,String propertyType,String financingTerm,String rate,String name,int index,String borrower0,String borrowerCardId0,String amount0,String transferAmount0,String term0,String value0,String startDate,String endDate,String appointDeliveryMode,String repaymentMode,String recommendedRating,String introduction,String purposes){
		PageElementOperate.clickById(driver, "000005");//账户中心
		PageElementOperate.clickById(driver, "002000");//资产管理
		PageElementOperate.clickByXpath(driver, "//a[@class='reserve' and @onclick='releaseAsset()']");//资产管理
		PageElementOperate.waitTime(1);
		PageElementOperate.setValueById(driver, "projectName", projectName);
		PageElementOperate.selectByIdWithText(driver, "type", propertyType);//选择资产类型
		PageElementOperate.selectByIdWithText(driver, "term", financingTerm);//选择融资期限
		PageElementOperate.setValueById(driver, "rate", rate);//融资利率
		/*******出让人信息***********/
		PageElementOperate.setValueByName(driver, "name", name);
		PageElementOperate.clickByXpath(driver, "/html/body/div[2]/div/ul/li/h3");//选择出让人
		PageElementOperate.setValueByName(driver, "creditors[0].borrower", borrower0);
		PageElementOperate.setValueByName(driver, "creditors[0].borrowerCardId", borrowerCardId0);	
		PageElementOperate.setValueByName(driver, "creditors[0].amount", amount0);
		PageElementOperate.setValueByName(driver, "creditors[0].transferAmount", transferAmount0);
		PageElementOperate.setValueByName(driver, "creditors[0].term", term0);
		PageElementOperate.selectByName(driver, "creditors[0].purpose", value0);
		/************************/
		PageElementOperate.setValueById(driver, "startDate", startDate);
		PageElementOperate.setValueById(driver, "endDate", endDate);//enddata之后需要一个回车，完成约定交割日
		PageElementOperate.waitTime(5);
		/*******获取主frame***********/
		// Back up main page's handler  
		String strMainHandler = driver.getWindowHandle();
		// Go to iframe
		WebElement frame=driver.findElement(By.xpath("//iframe[@frameborder='0']"));
		driver.switchTo().frame(frame);
		PageElementOperate.clickById(driver, "dpOkInput");
		// Go back to main frame  
		driver.switchTo().window(strMainHandler); 
		/**************************/
		PageElementOperate.selectById(driver, "appointDeliveryMode", appointDeliveryMode);
		PageElementOperate.selectById(driver, "repaymentMode", repaymentMode);
		PageElementOperate.selectById(driver, "recommendedRating", recommendedRating);
		PageElementOperate.setValueByName(driver, "introduction", introduction);
		PageElementOperate.setValueByName(driver, "purposes", introduction);
		PageElementOperate.clickById(driver, "submit_btn");
	}
}
