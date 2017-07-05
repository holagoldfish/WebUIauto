package com.jlch.webauto.operate;

import java.lang.reflect.Method;
import java.util.Map;
import org.testng.Assert;

//import org.junit.Assert;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.lang.reflect.*;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.operate.*;

public class XLoginOperate{
	


public static void operate1_xml(WebDriver driver,String Url,String uname,String pword,String ExpectValue)
{	//登录，输入用户名，密码，检查条件
	PageElementOperate.clickByXpath(driver,"/html/body/div/div[1]/div/div/ul/li[2]/a");
	PageElementOperate.setValueById(driver,"phone", uname); 
	PageElementOperate.setValueById(driver,"password_label", pword);
	PageElementOperate.clickById(driver,"next_btn");
	Assert.assertTrue(TextPresent(driver,ExpectValue));
	System.out.println(ExpectValue);
	
	 
	
}
/*�ж�ֻ����private��*/
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
