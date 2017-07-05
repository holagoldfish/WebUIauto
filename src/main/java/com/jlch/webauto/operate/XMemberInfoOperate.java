package com.jlch.webauto.operate;

import org.testng.*;

import com.jlch.webauto.util.*;
import com.jlch.webauto.element.operate.*;

import org.openqa.selenium.*;


public class XMemberInfoOperate {//客户信息填写
	
	public static void MemberInfo(WebDriver driver,String contactName,String companyName,String fixedTelphonePrefix,String fixedTelphone,String province,String city,String companyAddress,String bankNames,String subbranch,String account  ){
		PageElementOperate.clickById(driver, "000005");
		PageElementOperate.clickByXpath(driver, "//a[@class='apply' and @href='/memberInfoForm']");
		PageElementOperate.setValueById(driver, "contactName", contactName);
		PageElementOperate.setValueById(driver, "companyName", companyName	);
		PageElementOperate.setValueById(driver, "fixedTelphonePrefix", fixedTelphonePrefix);
		PageElementOperate.setValueById(driver, "fixedTelphone", fixedTelphone);
		PageElementOperate.selectById(driver,"province", province);
		PageElementOperate.selectById(driver,"city", city);
		PageElementOperate.setValueById(driver, "companyAddress", companyAddress);
		PageElementOperate.setValueById(driver, "bankNames", bankNames);
		PageElementOperate.setValueById(driver, "subbranch", subbranch);
		PageElementOperate.setValueById(driver, "account", account);
		PageElementOperate.clickById(driver, "next_btn");
		
	}
	
	
	private static boolean TextPresent(WebDriver driver,String what) {
	try{
		return driver.findElement(By.tagName("body")).getText().contains(what);// ����body�ڵ��µ����нڵ� ȡ���ı�ֵ ���ж��Ƿ�� �ı� what
	}
	catch (Exception e){
		Screen.GetPicture(driver);
	return false;
	}
}
	

}
