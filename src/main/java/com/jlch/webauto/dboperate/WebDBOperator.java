/* 
 * 
 * author:胡 莹
 * 类描述：数据操作
 * 
 */
package com.jlch.webauto.dboperate;

import java.sql.*;

public class WebDBOperator{
	
	  private final static String DB_URL = "jdbc:oracle:thin:@172.16.200.71:1521:test01";
	  private final static String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";	    
	  private final static String DB_USERNAME = "poseidon";
	  private final static String DB_PASSWORD = "123456";
	  static Connection conn = null;
	  
/*
 * 数据库连接
 */
  public static Connection getConnection(){	  
     try{
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        }catch(Exception ex){
          ex.printStackTrace();
         }
         return conn;
     }

 /*
   * 数据库关闭
   */
public static void closeConnection(Connection conn){
	        try{
	         if(conn!=null){
            if(!conn.isClosed()){
                   conn.close();
	              }
	            }
	      }catch(Exception ex){
	           ex.printStackTrace();
	       }
  }
	 
/*
 * 查询结果集
 */
 public static ResultSet getResultSet(String sql)
 {
	 ResultSet rs=null;
	 try
	 {			 			
		 conn=getConnection();			 
		 if(conn!=null)
		 {
		   Statement sm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		   rs = sm.executeQuery(sql);			   
		 }
	}catch(Exception ex){
	           ex.printStackTrace();
	       }
	 return rs;
 }
	 

}

