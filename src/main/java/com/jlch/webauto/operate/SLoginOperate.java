package com.jlch.webauto.operate;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;

import org.openqa.selenium.*;
import org.testng.Assert;

import com.jlch.webauto.dboperate.*;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.entity.*;

public class SLoginOperate {

	public static ArrayList<LoginPage> list=null;
	public SLoginOperate() {
	}

	/*
	 * 获取需要执行所有用例
	 */
	public static ArrayList<LoginPage> getALLCase() {
		if (list == null) {
			list = new ArrayList<LoginPage>();
			String sql = "select * from t_LoginPage ";
			//if(casenumber!=0)
			//  sql+=" where id="+casenumber;
			try {
				ResultSet r = DBOperator.getResultSet(sql);
				ResultSetMetaData rsmd = r.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int rowCount = r.getRow();
				int n = 0;
				while (r.next()) {
					LoginPage page = new LoginPage();
					page.setId(r.getInt("Id"));
					page.setUi_url(Constr.Str(r.getString("Ui_url")));
					page.setText_url(Constr.Str(r.getString("Text_url")));
					page.setValue_url(Constr.Str(r.getString("Value_url")));
					page.setUi_username(Constr.Str(r.getString("Ui_username")));
					page.setText_username(Constr.Str(r
							.getString("Text_username")));
					page.setValue_username(Constr.Str(r
							.getString("Value_username")));
					page.setUi_pwd(Constr.Str(r.getString("Ui_pwd")));
					page.setText_pwd(Constr.Str(r.getString("Text_pwd")));
					page.setValue_pwd(Constr.Str(r.getString("Value_pwd")));
					page.setUi_loginbtn(Constr.Str(r.getString("Ui_loginbtn")));
					page.setText_loginbtn(Constr.Str(r
							.getString("Text_loginbtn")));
					page.setValue_loginbtn(Constr.Str(r
							.getString("Value_loginbtn")));
					page.setUi_result(Constr.Str(r.getString("Ui_result")));
					page.setText_result(Constr.Str(r.getString("Text_result")));
					page.setValue_result(Constr.Str(r.getString("Value_result")));
					page.setRe_expected(Constr.Str(r.getString("Re_expected")));
					page.setRe_actual(Constr.Str(r.getString("Re_actual")));
					page.setRe_picture(Constr.Str(r.getString("Re_picture")));
					page.setRe_option(Constr.Str(r.getString("Re_option")));
					page.setRe_memo(Constr.Str(r.getString("Re_memo")));
					list.add(page);
					n++;
				}
			} catch (Exception ex) {
			}
		}
		System.out.println("数据库用例总数："+list.size());
		return list;
	}

	
	public static LoginPage getPage(int casenumber)
	{
		 LoginPage page=null;
		for(int i=0;i<list.size();i++)
		{ 
			LoginPage p=list.get(i);
			if(p.getId()==casenumber)
			{
			   page=p;
			   break;
			}
		}
		return page;
	}

	public static void operate1_sql(WebDriver driver, int casenumber) {
		list=getALLCase();
			if(list!=null)
			{
				
				LoginPage page=getPage(casenumber);	
				ElementOperate operate=new ElementOperate();						
			    operate.findElementOperate(driver,page.getUi_url(),page.getText_url(),page.getValue_url());                       //点击登录链接    ok
			    operate.findElementOperate(driver,page.getUi_username(),page.getText_username(),page.getValue_username());	      //输入用户名
			    operate.findElementOperate(driver,page.getUi_pwd(),page.getText_pwd(),page.getValue_pwd());	                      //输入密码
			    Screen.GetPicture(driver);
			    operate.findElementOperate(driver,page.getUi_loginbtn(),page.getText_loginbtn(),page.getValue_loginbtn());	      //点击登录
			    Screen.GetPicture(driver);
			    operate.findElementOperate(driver,page.getUi_result(),page.getText_result(),page.getValue_result());	          //查询结果			    
			}
			else
			{
				Assert.assertNotNull(list,"没有测试用例数据");
			}
	}
	
	

}
