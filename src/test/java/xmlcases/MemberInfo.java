package xmlcases;

import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.*;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.*;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;
/********************************************************************************/
public class MemberInfo extends DataOperate{
	WebDriver driver;
/*******************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
		driver=BrowserUtil.getInstance().getDriver(); 
		}
/******************************************************************************/
	@Test(dataProvider = "DataCommon" ,groups = {"login","OK"})
	public void MemberInfo_OK(Map<?, ?> param){//登录成功
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		System.out.println("Login_ok Start"); 	  
		String url = param.get("url").toString();
		String uname = param.get("uname").toString();
		String pword = param.get("pword").toString();
		String ExpectValue = param.get("uname").toString()+"，你好！";
		XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
		System.out.println("Login_ok End");
//}
/***********************************************************************************/
		System.out.println("MemberInfo_OK Start");
		String contactName = param.get("contactName").toString();
		String companyName = param.get("companyName").toString();
		String fixedTelphonePrefix = param.get("fixedTelphonePrefix").toString();
		String fixedTelphone = param.get("fixedTelphone").toString();
		String province = param.get("province").toString();
		String city = param.get("city").toString();
		String companyAddress = param.get("companyAddress").toString();
		String bankNames = param.get("bankNames").toString();
		String subbranch = param.get("subbranch").toString();
		String account = param.get("account").toString();										
		XMemberInfoOperate.MemberInfo(driver, contactName, companyName, fixedTelphonePrefix, fixedTelphone, province, city, companyAddress, bankNames, subbranch, account);
		System.out.println("MemberInfo_OK End");
/**********************************************************************************/
//		System.out.println("CheckMemberInfo_OK Start");
//
//		System.out.println("CheckMemberInfo_OK End");

	}

}
