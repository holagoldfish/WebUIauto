/* 
 * author:胡 莹
 * 类描述：读取资源文件内容
 * 
 */
package com.jlch.webauto.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class PropertiesFile {
	
	private static final String propertiesPath="bin\\application.test.properties";
	private static final String DriverType = "DriverType";
	private static final String InitDriver = "InitDriver";
	private static final String DefaultURL = "DefaultURL";
	
	public static String DriverType_Value ="";                      //driver类型
	public static String InitDriver_Value ="";                      //资源文件里驱动值	
	public static String DefaultURL_Value ="";                      //访问地址
		
	//构造函数
	public PropertiesFile()
	{
		readProperties(propertiesPath);
	}
	
	/*
	 * 读取资源文件内容
	 */
	public static void readProperties(String filePath) {		  
	      Properties props = new Properties();
	      try {
	          InputStream in = new BufferedInputStream(new FileInputStream(filePath));
	          props.load(in);
	          Enumeration<?> en = props.propertyNames();
	          while (en.hasMoreElements()) {
	              String key = (String) en.nextElement();
	              if(key.equals(DriverType))
	              {
	            	  DriverType_Value=props.getProperty(key);
	              }
	              if(key.equals(InitDriver))
	              {
	            	 InitDriver_Value=props.getProperty(key);
	              }
	              if(key.equals(DefaultURL))
	              {
	            	  DefaultURL_Value=props.getProperty(key);
	              }	              
	          }
	      } catch (Exception e) {
	          e.printStackTrace();
	      }
	  }	
}
