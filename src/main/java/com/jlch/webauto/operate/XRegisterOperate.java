package com.jlch.webauto.operate;

import org.testng.*;
import org.openqa.selenium.*;
import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.util.*;

public class XRegisterOperate {
	/*
	 *ע用户注册
	 */
	public static void register(WebDriver driver,String Url,String uname,String pword,String company,String contact,String Prefix,String Telphone,String mobile,String code,String ExpectValue){
		System.out.println("Register start");
		PageElementOperate.clickByXpath(driver,"/html/body/div/div/div/div/ul/li[4]/a");
		PageElementOperate.setValueById(driver,"username", uname);
		PageElementOperate.setValueById(driver,"password", pword);
		PageElementOperate.setValueById(driver,"confirmPassword", pword);
		PageElementOperate.setValueById(driver,"companyName", company);
		PageElementOperate.setValueById(driver,"contactName", contact);
		PageElementOperate.setValueById(driver,"fixedTelphonePrefix", Prefix);
		PageElementOperate.setValueById(driver,"fixedTelphone", Telphone);
		PageElementOperate.setValueById(driver,"contactMobile", mobile);
		PageElementOperate.clickById(driver,"buttonCode");
		//code = getPhoneCode(mobile);//����ֻ�����ȡ��֤��
		code=CommonOperate.getPhoneCode(mobile);
		PageElementOperate.setValueById(driver,"validateCode", code);
		PageElementOperate.clickById(driver,"isAgree");
		PageElementOperate.clickById(driver,"subtn");
		Assert.assertTrue(TextPresent(driver,ExpectValue));
		System.out.println(ExpectValue);
	}

	
	/*
	 * �����жϣ�ҳ���Ƿ���������ı� 
	 */
	private static boolean TextPresent(WebDriver driver,String what) {
		try{ 
			return driver.findElement(By.tagName("body")).getText().contains(what);// ����body�ڵ��µ����нڵ� ȡ���ı�ֵ ���ж��Ƿ�� �ı� what
		}
		catch (Exception e){ 
			Screen.GetPicture(driver);
		return false;// û�и��ı� �� ���� false
		}
	}
}
