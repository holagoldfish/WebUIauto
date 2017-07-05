package com.jlch.webauto.operate;

import org.openqa.jetty.html.List;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.jna.platform.win32.Netapi32Util.User;
import com.thoughtworks.selenium.Wait;
public class Xtest {
	public static void point(WebDriver driver,String content){
		WebElement ele = driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));
		String result = ((Object) ele).getElementIndex(content);
		System.out.println(result);
//		WebElement webElement = driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));
//	    List<WebElement> listLink = webElement.findElements(By.tagName("a"));  
//
//	    for (int i = 0; (i + 2) < 50; i += 2) {  
//	        System.out.println(listLink.get(i).getAttribute("href") + "/" + listLink.get(i + 1).getText()); 
//	    }
	}
	public boolean isContentAppeared(WebDriver driver,String content) {
		boolean status = false;
		try {
			driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));
			System.out.println(content + " is appeard!");
			status = true;
		} catch (NoSuchElementException e) {
			status = false;
			System.out.println("'" + content + "' doesn't exist!");
		}
		return status;
	}

/*	public void waitForElementLoad(final String waiting) {//等待ajax加载
		new Wait() {
			public boolean until() {
				//return User.isElementPresent(waiting);
				return user.isElementPresent(waiting);  
			}
		}.wait(waiting + " not found", 50000);

	}*/

	  public static void main(String[] args) {
		  WebDriver dr = new FirefoxDriver();
		  dr.get("https://172.16.200.60/neptune/");
		  point(dr,"登录");
	  }
}
