/* 
 * 
 * author:胡 莹
 * 类描述：界面元素操作
 * 
 */

package com.jlch.webauto.element.operate;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Copy_2_of_ElementOperate {
		
	public void findElementOperate(WebDriver driver,String ui, String text, String value)
	{
		  if(ui.equals("By.linkText([参数])"))
			{
			    By locator = By.linkText(text);  
			    isElementExsit(driver,locator,value);			   
			}
		  if (ui.equals("By.id([参数])")) 
		    {						
			    By locator = By.id(text);  
			    isElementExsit(driver,locator,value);  
			}
		  if (ui.equals("By.cssSelector([参数])")) 
		    {						
			    By locator = By.cssSelector(text);  
			    isElementExsit(driver,locator,value); 		
			}
		  if (ui.equals("By.name([参数])"))
		    {						
			    By locator = By.name(text);  
			    isElementExsit(driver,locator,value); 	
			}
		  if (ui.equals("By.xpath([参数])"))
		    {						
			    By locator = By.xpath(text);  
			    isElementExsit(driver,locator,value); 	
			}
	}
	
    public boolean isElementExsit(WebDriver driver, By locator,String value) {  
        boolean flag = false;  
        try {          	
            WebElement element=driver.findElement(locator);
            try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
            flag=null!=element;
            Action(element,value);
        } catch (NoSuchElementException e) {  
            System.out.println("Element:" + locator.toString()+ " is not exsit!");  
            if(value.equals("[result]"))
            {
            	Assert.fail("预期结果值与实际结果值不一致");
            }
            else
            {
            	Assert.fail("不存在的元素 :" + locator.toString()+ " is not exsit!");
            }
        }          
        return flag;  
    }  
	    
    public void Action(WebElement element,String value)
	{
		if(value.equals("[click]"))
		{
			  element.click();
		}
		else if(!value.equals("[click]") && !value.equals("[result]") && !value.contains("[result:text]") && !value.contains("[clear:text]:"))
		{
			element.sendKeys(value);
		}
		else if(value.equals("[result]"))
		{
			 if(element==null)
			 {
				 Assert.fail("预期结果值与实际结果值不一致");
			 }
		}
		else if(value.contains("[result:text]"))
		{
		   // String[] arr=value.split("[result:text]:");
		    String expected=value.substring(13,value.length());
		    String actual=element.getText();
		    if(!actual.equals(expected))
		    {
		    	String failStr="预期结果值与实际结果值不一致 \r\n";
		    	failStr+="预期结果："+expected+"\r\n";
		    	failStr+="实际结果："+actual;		    	
		    	Assert.fail(failStr);
		    }
		}
		else if(value.contains("[clear:text]"))
		{
			   // String[] arr=value.split("[clear:text]:");
			    //String expected=value.substring(13,value.length());
			   // String actual=element.getText();
			    
			    element.clear();
			    element.sendKeys(value.substring(13,value.length()));
		}
		else if(value.contains("[clear:text]:"))
		{
			   // String[] arr=value.split("[clear:text]:");
			    //String expected=value.substring(13,value.length());
			   // String actual=element.getText();
			    
			    element.clear();
			    element.sendKeys(value.substring(13,value.length()));
		}
		else if(value.contains("[select]"))//待加强
		{
			   // String[] arr=value.split("[clear:text]:");
			    //String expected=value.substring(13,value.length());
			   // String actual=element.getText();
			   	Select selectAge = new Select(element);
			   selectAge.selectByValue(value.substring(9,value.length()));
		}
		
		try {
			Thread.sleep(450);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
