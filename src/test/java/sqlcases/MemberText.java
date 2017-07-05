package sqlcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.jlch.webauto.dboperate.DataOperate;
import com.jlch.webauto.operate.*;
import com.jlch.webauto.util.*;

public class MemberText{

  WebDriver driver=null;
	
 @BeforeMethod
  public void beforeMethod() {
	 driver=BrowserUtil.getInstance().getDriver();
  }


@Test
public void Member_ok() { 	
	int casenumber=42;
	//SRegisterOperate.operate2_sql(driver, casenumber);
	SLoginOperate.operate1_sql(driver, casenumber);
	SMemberOperate.operate1_sql(driver, casenumber);
	
	
	
	
}


@AfterMethod
public void afterMethod() {
	  driver.quit();
}


}
