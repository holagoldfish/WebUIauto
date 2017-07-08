package com.jlch.webauto.util;
import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;
public class BrowserUtil {	
    public static WebDriver driver=null;
    public PropertiesFile proFile=null;
    private static BrowserUtil allocator;   
    private BrowserUtil(){
        initDriver();
    }
    
    public static WebDriver getDriver()
    {    	
    	return driver;
    }  	    
    public static BrowserUtil getInstance(){
    	 allocator=new BrowserUtil();
    	 return allocator;
    }    
    
	 public WebDriver initDriver(){	
		 PropertiesFile proFile=new PropertiesFile();
	       switch (proFile.DriverType_Value){
	           case "WebDriverFirefox":
	               driver=getFirefoxDriver(proFile.InitDriver_Value,proFile.DefaultURL_Value);
	               break;
	           case "WebDriverIE":
	               driver=getIEDriver(proFile.InitDriver_Value,proFile.DefaultURL_Value);
	               break;
	           case "WebDriverChrome":
	               driver=getChromeDriver(proFile.InitDriver_Value,proFile.DefaultURL_Value);
	               break;
	           default:
	               driver=getHtmlUnit(proFile.InitDriver_Value,proFile.DefaultURL_Value);
	       }
	        return driver;
	    }
	
	
    /*
     * IE浏览器
     */
	public static WebDriver getIEDriver(String driverFilePath, String url) {
		File file = new File(driverFilePath);
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
		DesiredCapabilities capabilities = DesiredCapabilities
				.internetExplorer();
		capabilities
				.setCapability(
						InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
		capabilities.setCapability("ignoreZoomSetting", true);
		/*
		 * capabilities.setCapability("enableElementCacheCleanup", true);
		 * capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
		 */
		WebDriver d= new InternetExplorerDriver(capabilities);
		d.get(url);
		// 跳过IE安全证书
		d.get("javascript:document.getElementById('overridelink').click();");		
		return d;
	}

	/*
     * 火狐浏览器
     */
	public static WebDriver getFirefoxDriver(String driverFilePath, String url) {
		File file = new File(driverFilePath);
		System.setProperty("webdriver.firefox.bin", file.getAbsolutePath());
		WebDriver d = new FirefoxDriver();
		d.get(url);
		return d;
	}
	
	/*
     * Chrome浏览器 【】
     */
	public static WebDriver getChromeDriver(String driverFilePath, String url) {
		File file = new File(driverFilePath);
		WebDriver d = new ChromeDriver();		
		return d;
	}
	
	/*
     * HtmlUnit浏览器
     */
	public static WebDriver getHtmlUnit(String driverFilePath, String url) {
		File file = new File(driverFilePath);
		WebDriver d = new ChromeDriver();
		return d;
	}
	
	/*
     * 关闭浏览器驱动
     */
	public static void closeDriver(WebDriver driver)
	{
		driver.quit();
	}

}
