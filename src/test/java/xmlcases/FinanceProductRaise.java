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
import com.jlch.webauto.operate.XFinanceProductRaise;
import com.jlch.webauto.operate.XLoginOperate;
import com.jlch.webauto.operate.XMemberInfoOperate;
import com.jlch.webauto.util.BrowserUtil;

public class FinanceProductRaise extends DataOperate{
	WebDriver driver;
/*******************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
		driver=BrowserUtil.getInstance().getDriver(); 
		}
/*******************************************************************************/
	@Test(dataProvider = "DataCommon",groups ={"OK"})
	public void FinanceProductRaise_OK(Map<?, ?> param){//理财产品定制
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
/********************************************************************************/
		System.out.println("Login_ok Start"); 	  
		String url = param.get("url").toString();
		String uname = param.get("uname").toString();
		String pword = param.get("pword").toString();
		String ExpectValue = param.get("uname").toString()+"，你好！";
		XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
		System.out.println("Login_ok End");
/*******************************************************************************/
		System.out.println("FinanceProductRaise_OK Start");
		String Column = param.get("Column").toString();
		String excelfile = param.get("excelfile").toString();
		String sql = param.get("sql").toString();
		String product_name = param.get("product_name").toString();
		String created_date = param.get("created_date").toString();
		String Addnum = param.get("Addnum").toString();
		int addNum = Integer.parseInt(Addnum);
		XFinanceProductRaise.FinanceProductRaise(driver, Column, excelfile, sql, product_name, created_date, addNum);
		System.out.println("FinanceProductRaise_OK End");
		driver.close();


	}
}
