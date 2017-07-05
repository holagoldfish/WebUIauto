package com.jlch.webauto.operate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jlch.webauto.element.operate.PageElementOperate;

public class XFinanceProductRaise {
	public static void FinanceProductRaise(WebDriver driver,String Column,String excelfile,String sql,String product_name,String created_date,int addNum){//理财产品募资，按照Column选择第几行产品
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageElementOperate.clickById(driver, "000005");//账户中心
		PageElementOperate.clickById(driver, "003000");//资金管理
		PageElementOperate.clickById(driver, "003005");//资金管理
		PageElementOperate.clickById(driver, "003005");//资金管理
		Column = "3";
		PageElementOperate.clickByXpath(driver, selectColumn(Column));//第二行
		/***************************************************/
		product_name = "性能20";
		created_date = "28-8月 -14";		
		sql ="select count(*) C from PSD_ORDER o where o.product_name = '"+product_name+"' and o.flow_id = '待付款'and o.created_date >='"+created_date+"'";
		String count1=CommonOperate.DBreturnCount("C", sql);
		/**************************************************/
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript("document.getElementById('excelfileUrl').removeAttribute('disabled');");
		PageElementOperate.waitTime(1);
		excelfile="C:\\客户订单导入模板.xlsx";
		driver.findElement(By.id("excelfile")).sendKeys(excelfile); 
		/**************************************************/
		PageElementOperate.clickByXpath(driver, ".//*[@id='fileForm']/div/div/div[2]/a[1]");
		/**************************************************/
		String count2=CommonOperate.DBreturnCount("C", sql);
		System.out.println(count2);
		addNum = 1;
		int c1=Integer.parseInt(count1)+addNum;
		count1=String.valueOf(c1);
		Assert.assertTrue(count1.equalsIgnoreCase(count2));	
		driver.close();
		

	}
	public static String selectColumn(String Column){
		String result =null; 
		result = ".//*[@id='content']/div[1]/div[2]/div[4]/div[2]/div/table/tbody/tr["+Column+"]/td[10]/a[2]";
		return result;
	}
}
