package xmlcasesNeptune;

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
import com.jlch.webauto.operate.neptune.*;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.*;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;

public class LoginNepture extends DataOperate{

WebDriver driver;
 @BeforeMethod
public void beforeMethod() {
   driver=BrowserUtil.getInstance().getDriver(); 
   driver.get("https://172.16.200.60/neptune/login");
}	
/******************ע��ɹ�*******************************/
@Test(dataProvider = "DataCommon" )
public void LoginNepture_OK(Map<?, ?> param){
	  System.out.println("LoginNepture_ok Start");  
	  String name = param.get("name").toString();
	  System.out.println(name);  

	  String password = param.get("password").toString();	
	  System.out.println(password);  

	  XLoginNeptune.LoginNeptune(driver, name, password);
	  System.out.println("LoginNepture_ok End"); 
	  
/********************************************************/
	 // XMemberManager.MemberManager_ok(driver);

}
}