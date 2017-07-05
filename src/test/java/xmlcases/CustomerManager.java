package xmlcases;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.*;
import com.jlch.webauto.operate.XOrderManage;
import com.jlch.webauto.util.BrowserUtil;
import com.jlch.webauto.util.Screen;

public class CustomerManager extends DataOperate{
	WebDriver driver;
/*******************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
		driver = BrowserUtil.getInstance().getDriver();  
		}
/******************************************************************************/
	@Test(dataProvider = "DataCommon" /*,groups = {"PostedAssets","OK"}*/)
	public void CustomerManager_ok(Map<?, ?> param){//登录成功
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		System.out.println("Login_ok Start"); 	  
		String url = param.get("url").toString();
		String uname = param.get("uname").toString();
		String pword = param.get("pword").toString();
		String ExpectValue = param.get("uname").toString()+"，你好！";
		XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
		System.out.println("Login_ok End");
		/********************************/
		System.out.println("OrderManage Start"); 	  
		XCustomerManager.CustomerManager(driver);
		System.out.println("OrderManage End"); 	
		driver.close();
	 

		/********************************/
	}

}
