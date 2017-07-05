package xmlcases;

import org.testng.annotations.Test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.*;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.*;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;
public class LoginTest extends DataOperate{
	
WebDriver driver;
 @BeforeMethod
public void beforeMethod() {
   driver=BrowserUtil.getInstance().getDriver(); 
}


/******************正常登录*******************************/
@Test(dataProvider = "DataCommon" ,groups = {"login","OK"})
	public void Login_ok(Map<?, ?> param){//登录成功
	System.out.println("Login_ok Start"); 	  
	String url = param.get("url").toString();
	String uname = param.get("uname").toString();
	String pword = param.get("pword").toString();
	String ExpectValue = param.get("uname").toString()+"，你好！";
	XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
	System.out.println("Login_ok End");
}
/*********************************************************/
/******************用户名为空********************************/
@Test(dataProvider = "DataCommon",groups = {"login","error"}) 
public void Login_UnameIsNull(Map<?, ?> param){
	System.out.println("Login_UnameIsNull Start");
	String url = param.get("url").toString();
	String uname = param.get("uname").toString();
	String pword = param.get("pword").toString();
	String ExpectValue = param.get("ExpectValue").toString();
	XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
	System.out.println("Login_UnameIsNull End");
}
/*********************************************************/
/******************密码为空**********************************/
@Test(dataProvider = "DataCommon",groups = {"login","error"}) 
public void Login_PwordIsNull(Map<?, ?> param){
	System.out.println("Login_PwordIsNull Start");
	String url = param.get("url").toString();
	String uname = param.get("uname").toString();
	String pword = param.get("pword").toString();
	String ExpectValue = param.get("ExpectValue").toString();
	XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
	System.out.println("Login_PwordIsNull End");
}
/*********************************************************/


@AfterMethod
protected void afterMethod() {
  driver.quit();
}

}

