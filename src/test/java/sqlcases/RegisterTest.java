package sqlcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.jlch.webauto.operate.SLoginOperate;
import com.jlch.webauto.operate.*;
import com.jlch.webauto.util.BrowserUtil;
	
public class RegisterTest {
	
WebDriver driver=null;
	
@BeforeMethod
public void beforeMethod() {
  driver=BrowserUtil.getInstance().getDriver();
}
	
/*
 *  【用例1】：注册异常——输入框都为空  
 *  步骤：点击“注册”链接——>点击“阅读规则”，查看验证提示
*/
@Test(groups = {"register","error"})
public void Register_error_allNull() { 
	   int casenumber=1;
	   SRegisterOperate.operate1_sql(driver, casenumber);		
 }	

/*
 *  【用例2】：注册异常——存在的用户名  
 *  步骤：点击“注册”链接——>输入用户名——>点击“阅读”规则——>点击“提交按钮”，查看用户名验证提示
 */	
@Test(groups = {"register","error"})
public void Register_error_registeredName() { 
	int casenumber=2;
	SRegisterOperate.operate1_sql(driver, casenumber);		
 }
	
/*
 *  【用例3】：注册正常 
 *  步骤：点击“注册”链接——>
 */
@Test(groups = {"register","error"})
public void Register_ok() { 
	int casenumber=20;
	SRegisterOperate.operate2_sql(driver, casenumber);				
 }
	
/*
 *  【业务流程测试】： 注册——>登录——>会员申请
 */
@Test(groups = {"register","ok"})
public void Register_Login_ok()
{
	int casenumber=41;
	SRegisterOperate.operate2_sql(driver, casenumber);	
	SLoginOperate.operate1_sql(driver, casenumber);
}
	

@AfterMethod
protected void afterMethod() {
    driver.quit();
}
	
}
