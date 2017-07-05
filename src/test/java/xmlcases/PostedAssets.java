package xmlcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.*;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.*;
import com.jlch.webauto.element.operate.PageElementOperate;
import com.thoughtworks.selenium.Wait.WaitTimedOutException;
/********************************************************************************/
public class PostedAssets extends DataOperate{
	WebDriver driver;
/*******************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
		driver = BrowserUtil.getInstance().getDriver();  
		}
/******************************************************************************/
	@Test(dataProvider = "DataCommon" /*,groups = {"PostedAssets","OK"}*/)
	public void PostedAssets_Ok(Map<?, ?> param){//登录成功
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); 
		System.out.println("Login_ok Start"); 	  
		String url = param.get("url").toString();
		String uname = param.get("uname").toString();
		String pword = param.get("pword").toString();
		String ExpectValue = param.get("uname").toString()+"，你好！";
		XLoginOperate.operate1_xml(driver,url,uname,pword,ExpectValue);
		System.out.println("Login_ok End");
	/*************************************************************************/
		PageElementOperate.waitTime(1);
	/*************************************************************************/	
		System.out.println("PostedAssets Start"); 
		String projectName = param.get("projectName").toString();
		String propertyType = param.get("propertyType").toString();
		String financingTerm = param.get("financingTerm").toString();
		String rate = param.get("rate").toString();
		String name = param.get("name").toString();
		String i = param.get("index").toString();
		int index = Integer.parseInt(i);
		String borrower0 = param.get("borrower0").toString();
		String borrowerCardId0 = param.get("borrowerCardId0").toString();
		String amount0 = param.get("amount0").toString();
		String transferAmount0 = param.get("transferAmount0").toString();
		String term0 = param.get("term0").toString();
		String value0 = param.get("value0").toString();
		String startDate = param.get("startDate").toString();
		String endDate = param.get("endDate").toString();
		String appointDeliveryMode = param.get("appointDeliveryMode").toString();
		String repaymentMode = param.get("repaymentMode").toString();
		String recommendedRating = param.get("recommendedRating").toString();
		String introduction = param.get("introduction").toString();
		String purposes = param.get("purposes").toString();
		XPostedAssets.PostedAssets(driver, projectName, propertyType, financingTerm, rate,name, index, borrower0, borrowerCardId0, amount0, transferAmount0,term0, value0, startDate, endDate, appointDeliveryMode,repaymentMode, recommendedRating, introduction, purposes);
		System.out.println("PostedAssets End"); 
     /************************************************************************/
		System.out.println("AgreementAnnex Start"); 
		//String selectUpload = param.get("selectUpload").toString();
		//System.out.println(selectUpload);
		String inputtext4 = param.get("inputtext4").toString();
		System.out.println(inputtext4);
		XAgreementAnnex.AgreementAnnex(driver,  inputtext4);
		String sql = "select count(*) C from poseidon.psd_asset a where a.project_name ='"+projectName+"'";//测试资产20001
		String count=CommonOperate.DBreturnCount("C", sql);
		System.out.println(count); 
		Assert.assertTrue(count.equalsIgnoreCase("1"));	
		System.out.println("AgreementAnnex End"); 
		driver.close();

	}
}