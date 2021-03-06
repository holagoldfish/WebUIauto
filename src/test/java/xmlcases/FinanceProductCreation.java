package xmlcases;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.XCheckMemberInfo;
import com.jlch.webauto.operate.XFinanceProductCreation;
import com.jlch.webauto.operate.XLoginOperate;
import com.jlch.webauto.operate.XMemberInfoOperate;
import com.jlch.webauto.util.BrowserUtil;

public class FinanceProductCreation extends DataOperate{
	WebDriver driver;
/*******************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
		driver=BrowserUtil.getInstance().getDriver(); 
		}
/*******************************************************************************/
	@Test(dataProvider = "DataCommon")
	public void FinanceProductCreation_ok(Map<?, ?> param){//理财产品定制
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
/********************************************************************************/
		System.out.println("Login_ok Start"); 	  
		String url = param.get("url").toString();
		String uname = param.get("uname").toString();
		String pword = param.get("pword").toString();
		String ExpectValue = param.get("uname").toString()+"，你好！";
		XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
		System.out.println("Login_ok End");
/********************************************************************************/
		
		System.out.println("FinanceProductCreation_ok Start");
		String productName = param.get("productName").toString();
		System.out.println(productName);

		String purchaseAmount = param.get("purchaseAmount").toString();
		System.out.println(purchaseAmount);

		XFinanceProductCreation.FinanceProductCreation(driver, uname, productName, purchaseAmount);
		System.out.println("FinanceProductCreation_ok End");
		driver.close();


	}
//	@AfterMethod
//	public void AfterMethod() {
//		driver.close();
//		}
}