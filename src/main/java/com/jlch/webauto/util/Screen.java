/* 
 * author:胡 莹
 * 类描述：截屏
 * 
 */

package com.jlch.webauto.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screen {
 
	
	public Screen()
	{		
	}
	
	/*
	 * 用于截屏
	 */
	public static void GetPicture(WebDriver driver)
	{
		  try {
			    Date date=new Date();
		        File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // 执行屏幕截图，默认会把截图保存到temp目录
		        //FileUtils.copyFile(source_file, new File(dir_name + File.separator + time + ".png"));  // 这里将截图另存到我们需要保存的目录，例如screenshot\20120406-165210.png
		        FileUtils.copyFile(source_file, new File("img\\"+date.getTime() + ".png"));  
		    } catch (IOException e) {
		        e.printStackTrace();
		    }	
	}
}
