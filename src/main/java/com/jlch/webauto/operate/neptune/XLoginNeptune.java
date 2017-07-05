package com.jlch.webauto.operate.neptune;
import java.util.concurrent.TimeUnit;

import org.testng.*;

import com.jlch.webauto.util.*;
import com.jlch.webauto.element.operate.*;

import org.openqa.selenium.*;
public class XLoginNeptune {
	public static void LoginNeptune(WebDriver driver,String name,String password){
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		PageElementOperate.setValueById(driver, "name", name);
		PageElementOperate.setValueById(driver, "password", password);
		PageElementOperate.clickById(driver, "submit");
		Assert.assertTrue(TextPresent(driver,name+",您好!"));			
		System.out.println(name+",您好!");
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
