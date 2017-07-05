package xmlcases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.XCheckMemberInfo;
import com.jlch.webauto.operate.XLoginOperate;
import com.jlch.webauto.operate.XMemberInfoOperate;
import com.jlch.webauto.util.BrowserUtil;

public class CheckMemberInfo extends DataOperate{
	WebDriver driver;
/*******************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
		driver=BrowserUtil.getInstance().getDriver(); 
		}
/******************************************************************************/
	@Test(dataProvider = "DataCommon" ,groups = {"login","OK"})
	public void MemberInfo_AllOK(Map<?, ?> param){//登录成功
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
		System.out.println("CheckMemberInfo_OK Start");
		String companyName1 = param.get("companyName1").toString();
		String companyCode1 = param.get("companyCode1").toString();
		String inputtext1 = param.get("inputtext1").toString();
		String inputtext2 = param.get("inputtext2").toString();
		String inputtext3 = param.get("inputtext3").toString();		
		System.out.println(companyCode1);
		System.out.println("inputtext1");
		System.out.println("inputtext2");
		System.out.println("inputtext3");
		XCheckMemberInfo.CheckMemberInfo(driver, companyName1, companyCode1, inputtext1, inputtext2, inputtext3);
		System.out.println("CheckMemberInfo_OK End");
		driver.close();
	}
}
