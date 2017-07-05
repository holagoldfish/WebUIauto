package xmlcases;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.XLoginOperate;
import com.jlch.webauto.operate.XRegisterOperate;
import com.jlch.webauto.util.BrowserUtil;

public class RegisterAndLogin extends DataOperate{
	  
	WebDriver driver;
	 @BeforeMethod
	public void beforeMethod() {
	   driver=BrowserUtil.getInstance().getDriver(); 
	}

/*****************ע����¼********************************************/
	@Test(dataProvider = "DataCommon")
	public void RegisterAndLogin_OK(Map<?, ?> param){
		System.out.println("RegisterAndLogin Start"); 
		  /****************************************************************/		
		    String url = param.get("url").toString();
			String uname = param.get("uname").toString();
			String pword = param.get("pword").toString();
			String company = param.get("company").toString();
			String contact = param.get("contact").toString();
			String Prefix = param.get("Prefix").toString();
			String Telphone = param.get("Telphone").toString();
			String mobile = param.get("mobile").toString();
			String code = null;		
			String ExpectValue = param.get("ExpectValue").toString();
			String ExpectValue1 = param.get("uname").toString()+"，你好！";
		/****************************************************************/		
			XRegisterOperate.register(driver,url, uname, pword, company, contact, Prefix, Telphone, mobile, code, ExpectValue);
			XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue1);
			System.out.println("RegisterAndLogin End");
			
		    //driver.close();
	}
/***********************************************************************/
	

@AfterMethod
protected void afterMethod() {
  driver.quit();
}
}
