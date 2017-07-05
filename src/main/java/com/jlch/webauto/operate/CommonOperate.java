package com.jlch.webauto.operate;

import java.sql.*;
import com.jlch.webauto.dboperate.*;
import com.jlch.webauto.util.*;

public class CommonOperate {
	
	/*
	 * 获取验证码
	 */
	public static String getPhoneCode(String phone)
	{
		String newPhone=phone;
		System.out.println("fdddddd: "+phone);
		if(phone.contains("[sendKeys]"))
		{
			System.out.println("p: "+phone);
			newPhone=phone.substring(10,phone.length());
			System.out.println("new :"+newPhone);
		}
		String sql="select * from psd_validate_code t where t.mobile='"+newPhone+"'";
		String validateValue="";
		try
		{	
		   ResultSet rSet=WebDBOperator.getResultSet(sql);
		   ResultSetMetaData rsmd = rSet.getMetaData();
		   int columnCount = rsmd.getColumnCount(); 
		   int rowCount =rSet.getRow();
		   int n=0;
		   while(rSet.next()) { 
			   validateValue=Constr.Str(rSet.getString("code"));
			   break;
		   }				    
		}catch(Exception ex)
		{				
		}	
		System.out.println(validateValue);
		return validateValue;
	}
	/*
	 * 查询数据库
	 */
	public static String DBreturn(String code,String Value,String sql){
		//String newCode = code;
		System.out.println("code: "+code);
		System.out.println("sql: "+sql);

		String validateValue="";
		try
		{	
		   ResultSet rSet=WebDBOperator.getResultSet(sql);
		   //ResultSetMetaData rsmd = rSet.getMetaData();
		   //int columnCount = rsmd.getColumnCount(); 
		   //int rowCount =rSet.getRow();
		   //int n=0;
		   while(rSet.next()) { 
			   validateValue=Constr.Str(rSet.getString(Value));
			   break;
	   }				    
		}catch(Exception ex)
		{				
		}	
		System.out.println(validateValue);		
		return validateValue;		
	}
	public static String DBreturnCount(String Value,String sql){
		System.out.println("sql: "+sql);
		String validateValue="";
		try
		{	
		   ResultSet rSet=WebDBOperator.getResultSet(sql);
		   while(rSet.next()) { 
			   validateValue=Constr.Str(rSet.getString(Value));
			   break;
	   }				    
		}catch(Exception ex)
		{				
		}	
		System.out.println(validateValue);		
		return validateValue;		
	}
}
