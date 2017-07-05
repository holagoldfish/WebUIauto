/*
 * Author: 宋祺
 */
package com.jlch.webauto.element.operate;


import org.dom4j.util.IndexedElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.jlch.webauto.util.BrowserUtil;

public class PageElementOperate {
	/*****************************************************************/	
    /*********************清除栏位后赋值***********************************/
	   public static void setValueById(WebDriver driver,String Id,String Value){
		   driver.findElement(By.id(Id)).clear();
			driver.findElement(By.id(Id)).sendKeys(Value);
			waitTime(1);
		}
		public static void setValueByName(WebDriver driver,String Name,String Value){
			driver.findElement(By.name(Name)).clear();
			driver.findElement(By.name(Name)).sendKeys(Value);
			waitTime(1);
			
		}
	/*********************上传文件***********************************/	
		   public static void upLoadById(WebDriver driver,String Id,String Path){
				driver.findElement(By.id(Id)).sendKeys(Path);
				waitTime(1);
			}
			public static void upLoadByName(WebDriver driver,String Name,String Path){
				driver.findElement(By.name(Name)).sendKeys(Path);
				waitTime(1);
				
			}
	/******************************************************************/
		public static void clickById(WebDriver driver,String Id){
			driver.findElement(By.id(Id)).click();
			waitTime(1);
		}
		public static void clickByXpath(WebDriver driver,String Xpath){
			driver.findElement(By.xpath(Xpath)).click();
			waitTime(1);
		}
	/******************************************************************/
		public static void selectById(WebDriver driver,String Id,String Value){
		   	Select selectAge = new Select(driver.findElement(By.id(Id)));
		 	//selectAge.selectByValue("中国工商银行");
		   selectAge.selectByValue(Value);
		}
		public static void selectByIdWithText(WebDriver driver,String Id,String Text){
		   	Select selectAge = new Select(driver.findElement(By.id(Id)));
		   selectAge.selectByVisibleText(Text);
		}
		public static void selectByIdWithIndex(WebDriver driver,String Id,int Index){
		   	Select selectAge = new Select(driver.findElement(By.id(Id)));
		   selectAge.selectByIndex(Index);
		}
		public static void selectByName(WebDriver driver,String Name,String Value){
		   	Select selectAge = new Select(driver.findElement(By.name(Name)));
		 	//selectAge.selectByValue("中国工商银行");
		   selectAge.selectByValue(Value);
		}
		public static void selectByNameWithText(WebDriver driver,String Name,String Text){
		   	Select selectAge = new Select(driver.findElement(By.name(Name)));
		   selectAge.selectByVisibleText(Text);
		}
		public static void selectByNameWithIndex(WebDriver driver,String Name,int Index){
		   	Select selectAge = new Select(driver.findElement(By.name(Name)));
		   selectAge.selectByIndex(Index);
		}
	/******************************************************************/	
		public static void waitTime(long i){
		    try {
				Thread.sleep(i*100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	/************************����*************************************/
		public  boolean TextPresent(WebDriver driver,String what) {
			try{  
				return driver.findElement(By.tagName("body")).getText().contains(what);// ����body�ڵ��µ����нڵ� ȡ���ı�ֵ ���ж��Ƿ�� �ı� what
			}
			catch (Exception e){
				//WebDriver driver= Allocator.getInstance(EngineType.WebDriverFirefox).getDriver();
				//snapshot((TakesScreenshot)driver,ExpectValue+".png");
			return false;// û�и��ı� �� ���� false
			}
		}
	/****************************************************************/	
		public boolean isElementExsit(WebDriver driver, By locator) {  
	        boolean flag = false;  
	        try {  
	            WebElement element=driver.findElement(locator);  
	            flag=null!=element;  
	        } catch (NoSuchElementException e) {  
	            System.out.println("Element:" + locator.toString()  
	                    + " is not exsit!");  
	        }  
	        return flag;  
	    } 
	/****************************************************************/
//        public static IWebElement SpecCell(IWebElement webtable, int rowno, int colno)
//        {
//
//            //MessageBox.Show("//tr[" + rowno + "]");
//            String rowstring = ".//tr[" + rowno.ToString() + "]";
//            String colstring = ".//td[" + colno.ToString() + "]";
//            IWebElement SpecRow = webtable.FindElement(By.XPath(rowstring));
//            IWebElement SpecCell = SpecRow.FindElement(By.XPath(colstring));
//            return SpecCell;
//        }
		
}
