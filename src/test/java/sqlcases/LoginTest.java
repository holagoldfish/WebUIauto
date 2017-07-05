package sqlcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.*;
import com.jlch.webauto.util.*;

public class LoginTest{

  WebDriver driver=null;
	
 @BeforeMethod
  public void beforeMethod() {
	 driver=BrowserUtil.getInstance().getDriver();
  }

/*

 *  【用例1】：登录异常——用户密码都为空  
 *  步骤：点击“登录”链接——>点击“提交”，查看验证提示
*/ 
@Test(groups = {"login","error"})
public void LoginText_error_allNull() { 
	    int casenumber=1;
	    SLoginOperate.operate1_sql(driver, casenumber);
}

/*
 *  【用例2】：登录异常——用户有值、密码为空   
 *  步骤：点击“登录”链接——>输入用户名——>输入密码——>点击“提交”，查看用户名验证提示
 */
@Test(groups = {"login","error"})
public void LoginText_error_pwdIsNull() { 	
	int casenumber=2;
	SLoginOperate.operate1_sql(driver, casenumber);
}

/*
 *  【用例3】：登录异常——用户名密码不存在 
 *  步骤：点击“登录”链接——>输入用户名——>输入密码，查看用户名验证提示
*/ 
@Test(groups = {"login","error"})
public void LoginText_error_namepwd() { 
	int casenumber=3;
	SLoginOperate.operate1_sql(driver, casenumber);
}

/*
 *  【用例4】：登录正常——正确的用户名密码  
 *  步骤：点击“登录”链接——>输入用户名——>输入密码，查看用户名验证提示
*/ 
@Test
public void LoginText_ok() { 	
	int casenumber=4;
	SLoginOperate.operate1_sql(driver, casenumber);
}


@AfterMethod
public void afterMethod() {
	  driver.quit();
}


}
