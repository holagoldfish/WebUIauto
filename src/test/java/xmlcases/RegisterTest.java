package xmlcases;

import org.testng.annotations.Test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.SLoginOperate;
import com.jlch.webauto.operate.XLoginOperate;
import com.jlch.webauto.operate.XRegisterOperate;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.*;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;

public class RegisterTest extends DataOperate{

WebDriver driver;
 @BeforeMethod
public void beforeMethod() {
   driver=BrowserUtil.getInstance().getDriver(); 
}	
/******************ע��ɹ�*******************************/
@Test(dataProvider = "DataCommon" ,groups = {"Register","OK"})
public void Register_OK(Map<?, ?> param){
	  System.out.println("Login_ok Start");  
	    String url = param.get("url").toString();//��ȡurl
		String uname = param.get("uname").toString();
		String pword = param.get("pword").toString();
		String company = param.get("company").toString();
		String contact = param.get("contact").toString();
		String Prefix = param.get("Prefix").toString();
		String Telphone = param.get("Telphone").toString();
		String mobile = param.get("mobile").toString();
		String code = null;
		String ExpectValue = param.get("ExpectValue").toString();
		XRegisterOperate.register(driver,url, uname, pword, company, contact, Prefix, Telphone, mobile, code, ExpectValue);
		System.out.println("Register_OK End");
	    driver.close();
}
/**************************************************************/
/******************ע����Ϣֻ�е绰����*******************************/
@Test(dataProvider = "DataCommon" ,groups = {"Register","OK"})
	public void Register_Error_OnlyMobile(Map<?, ?> param){
	  System.out.println("Register_Error_OnlyMobile Start");  
	    String url = param.get("url").toString();
		String uname = param.get("uname").toString();
		String pword = param.get("pword").toString();
		String company = param.get("company").toString();
		String contact = param.get("contact").toString();
		String Prefix = param.get("Prefix").toString();
		String Telphone = param.get("Telphone").toString();
		String mobile = param.get("mobile").toString();
		String code = null;
		String ExpectValue = param.get("uname").toString()+"����ã�";
		XRegisterOperate.register(driver,url, uname, pword, company, contact, Prefix, Telphone, mobile, code, ExpectValue);
		System.out.println(ExpectValue);

		System.out.println("Register_OK End");
	    driver.close();
}


@AfterMethod
protected void afterMethod() {
  driver.quit();
}
}
