package com.jlch.webauto.operate;

import java.sql.*;
import java.util.*;
import org.openqa.selenium.*;
import org.testng.*;

import com.jlch.webauto.dboperate.*;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.entity.*;

public class SRegisterOperate {

	public static ArrayList<RegisterPage> list=null;
	public SRegisterOperate() {
	}

	/*
	 * 获取需要执行所有用例
	 */
	public static ArrayList<RegisterPage> getALLCase() {
		if (list == null) {
			list = new ArrayList<RegisterPage>();
			String sql = "select * from t_RegisterPage order by id asc";
			try {
				ResultSet r = DBOperator.getResultSet(sql);
				ResultSetMetaData rsmd = r.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int rowCount = r.getRow();
				int n = 0;
				while (r.next()) {
					RegisterPage page = new RegisterPage();
					page.setId(r.getInt("Id"));
					page.setUi_url(Constr.Str(r.getString("Ui_url")));
					page.setText_url(Constr.Str(r.getString("Text_url")));
					page.setValue_url(Constr.Str(r.getString("Value_url")));
					page.setUi_name(Constr.Str(r.getString("Ui_name")));
					page.setText_name(Constr.Str(r.getString("Text_name")));
					page.setValue_name(Constr.Str(r.getString("Value_name")));
					page.setUi_checkname(Constr.Str(r.getString("Ui_checkname")));
					page.setText_checkname(Constr.Str(r
							.getString("Text_checkname")));
					page.setValue_checkname(Constr.Str(r
							.getString("Value_checkname")));
					page.setUi_pwd(Constr.Str(r.getString("Ui_pwd")));
					page.setText_pwd(Constr.Str(r.getString("Text_pwd")));
					page.setValue_pwd(Constr.Str(r.getString("Value_pwd")));
					page.setUi_checkpwd(Constr.Str(r.getString("Ui_checkpwd")));
					page.setText_checkpwd(Constr.Str(r
							.getString("Text_checkpwd")));
					page.setValue_checkpwd(Constr.Str(r
							.getString("Value_checkpwd")));
					page.setUi_repeatpwd(Constr.Str(r.getString("Ui_repeatpwd")));
					page.setText_repeatpwd(Constr.Str(r
							.getString("Text_repeatpwd")));
					page.setValue_repeatpwd(Constr.Str(r
							.getString("Value_repeatpwd")));
					page.setUi_checkrepeatpwd(Constr.Str(r
							.getString("Ui_checkrepeatpwd")));
					page.setText_checkrepeatpwd(Constr.Str(r
							.getString("Text_checkrepeatpwd")));
					page.setValue_checkrepeatpwd(Constr.Str(r
							.getString("Value_checkrepeatpwd")));
					page.setUi_company(Constr.Str(r.getString("Ui_company")));
					page.setText_company(Constr.Str(r.getString("Text_company")));
					page.setValue_company(Constr.Str(r
							.getString("Value_company")));
					page.setUi_checkcompany(Constr.Str(r
							.getString("Ui_checkcompany")));
					page.setText_checkcompany(Constr.Str(r
							.getString("Text_checkcompany")));
					page.setValue_checkcompany(Constr.Str(r
							.getString("Value_checkcompany")));
					page.setUi_contactname(Constr.Str(r
							.getString("Ui_contactname")));
					page.setText_contactname(Constr.Str(r
							.getString("Text_contactname")));
					page.setValue_contactname(Constr.Str(r
							.getString("Value_contactname")));
					page.setUi_checkcontactname(Constr.Str(r
							.getString("Ui_checkcontactname")));
					page.setText_checkcontactname(Constr.Str(r
							.getString("Text_checkcontactname")));
					page.setValue_checkcontactname(Constr.Str(r
							.getString("Value_checkcontactname")));
					page.setUi_prefixphone(Constr.Str(r
							.getString("Ui_prefixphone")));
					page.setText_prefixphone(Constr.Str(r
							.getString("Text_prefixphone")));
					page.setValue_prefixphone(Constr.Str(r
							.getString("Value_prefixphone")));
					page.setUi_checkprefixphone(Constr.Str(r
							.getString("Ui_checkprefixphone")));
					page.setText_checkprefixphone(Constr.Str(r
							.getString("Text_checkprefixphone")));
					page.setValue_checkprefixphone(Constr.Str(r
							.getString("Value_checkprefixphone")));
					page.setUi_fixphone(Constr.Str(r.getString("Ui_fixphone")));
					page.setText_fixphone(Constr.Str(r
							.getString("Text_fixphone")));
					page.setValue_fixphone(Constr.Str(r
							.getString("Value_fixphone")));
					page.setUi_checkfixphone(Constr.Str(r
							.getString("Ui_checkfixphone")));
					page.setText_checkfixphone(Constr.Str(r
							.getString("Text_checkfixphone")));
					page.setValue_checkfixphone(Constr.Str(r
							.getString("Value_checkfixphone")));
					page.setUi_mobile(Constr.Str(r.getString("Ui_mobile")));
					page.setText_mobile(Constr.Str(r.getString("Text_mobile")));
					page.setValue_mobile(Constr.Str(r.getString("Value_mobile")));
					page.setUi_checkmobile(Constr.Str(r
							.getString("Ui_checkmobile")));
					page.setText_checkmobile(Constr.Str(r
							.getString("Text_checkmobile")));
					page.setValue_checkmobile(Constr.Str(r
							.getString("Value_checkmobile")));
					page.setUi_validatecode(Constr.Str(r
							.getString("Ui_validatecode")));
					page.setText_validatecode(Constr.Str(r
							.getString("Text_validatecode")));
					page.setValue_validatecode(Constr.Str(r
							.getString("Value_validatecode")));
					page.setUi_checkvalidatecode(Constr.Str(r
							.getString("Ui_checkvalidatecode")));
					page.setText_checkvalidatecode(Constr.Str(r
							.getString("Text_checkvalidatecode")));
					page.setValue_checkvalidatecode(Constr.Str(r
							.getString("Value_checkvalidatecode")));
					page.setUi_validatecodebtn(Constr.Str(r
							.getString("Ui_validatecodebtn")));
					page.setText_validatecodebtn(Constr.Str(r
							.getString("Text_validatecodebtn")));
					page.setValue_validatecodebtn(Constr.Str(r
							.getString("Value_validatecodebtn")));
					page.setUi_isagree(Constr.Str(r.getString("Ui_isagree")));
					page.setText_isagree(Constr.Str(r.getString("Text_isagree")));
					page.setValue_isagree(Constr.Str(r
							.getString("Value_isagree")));
					page.setUi_subtn(Constr.Str(r.getString("Ui_subtn")));
					page.setText_subtn(Constr.Str(r.getString("Text_subtn")));
					page.setValue_subtn(Constr.Str(r.getString("Value_subtn")));
					page.setUi_subtnresult(Constr.Str(r
							.getString("Ui_subtnresult")));
					page.setText_subtnresult(Constr.Str(r
							.getString("Text_subtnresult")));
					page.setValue_subtnresult(Constr.Str(r
							.getString("Value_subtnresult")));
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
		return list;
	}
	
	public static RegisterPage getPage(int casenumber)
	{
		RegisterPage page=null;
		for(int i=0;i<list.size();i++)
		{ 
			RegisterPage p=list.get(i);
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
				RegisterPage page=getPage(casenumber);	
				ElementOperate operate=new ElementOperate();
			    operate.findElementOperate(driver,page.getUi_url(),page.getText_url(),page.getValue_url());             //点击注册链接
			    operate.findElementOperate(driver,page.getUi_name(),page.getText_name(),page.getValue_name());          //输入用户名					
				operate.findElementOperate(driver,page.getUi_isagree(),page.getText_isagree(),page.getValue_isagree());    //点击阅读规则
				operate.findElementOperate(driver,page.getUi_subtn(),page.getText_subtn(),page.getValue_subtn());          //点击提交
				operate.findElementOperate(driver,page.getUi_checkname(),page.getText_checkname(),page.getValue_checkname());    //用户名验证
								  
			}
			else
			{
				Assert.assertNotNull(list,"没有测试用例数据");
			}
	}
	
	public static void operate2_sql(WebDriver driver, int casenumber) {
		list=getALLCase();
			if(list!=null)
			{
				RegisterPage page=getPage(casenumber);	
				ElementOperate operate=new ElementOperate();
			    operate.findElementOperate(driver,page.getUi_url(),page.getText_url(),page.getValue_url());             //点击注册链接
			    operate.findElementOperate(driver,page.getUi_name(),page.getText_name(),page.getValue_name());          //输入用户名
			    operate.findElementOperate(driver,page.getUi_pwd(),page.getText_pwd(),page.getValue_pwd());                     //设置密码
			    operate.findElementOperate(driver,page.getUi_repeatpwd(),page.getText_repeatpwd(),page.getValue_repeatpwd());   //确认密码
			    operate.findElementOperate(driver,page.getUi_company(),page.getText_company(),page.getValue_company());         //公司名称
			    operate.findElementOperate(driver,page.getUi_contactname(),page.getText_contactname(),page.getValue_contactname());    //联系人姓名
			    operate.findElementOperate(driver,page.getUi_prefixphone(),page.getText_prefixphone(),page.getValue_prefixphone());    //固话1
			    operate.findElementOperate(driver,page.getUi_fixphone(),page.getText_fixphone(),page.getValue_fixphone());             //固话2
			    operate.findElementOperate(driver,page.getUi_mobile(),page.getText_mobile(),page.getValue_mobile());             //手机号码			    
			    operate.findElementOperate(driver,page.getUi_validatecodebtn(),page.getText_validatecodebtn(),page.getValue_validatecodebtn());   //点击发送验证码
			    operate.findElementOperate(driver,page.getUi_validatecode(),page.getText_validatecode(),CommonOperate.getPhoneCode(page.getValue_mobile()));  //手机验证码			    					
				operate.findElementOperate(driver,page.getUi_isagree(),page.getText_isagree(),page.getValue_isagree());    //点击阅读规则
				operate.findElementOperate(driver,page.getUi_checkname(),page.getText_checkname(),page.getValue_checkname());    //用户名验证   -----
				operate.findElementOperate(driver,page.getUi_subtn(),page.getText_subtn(),page.getValue_subtn());          //点击提交				
				operate.findElementOperate(driver,page.getUi_subtnresult(),page.getText_subtnresult(),page.getValue_subtnresult());          //提交成功后
				//operate.findElementOperate(driver,page.getUi_checkname(),page.getText_checkname(),page.getValue_checkname());    //用户名验证			
				  
			}
			else
			{
				Assert.assertNotNull(list,"没有测试用例数据");
			}
	}
	
	
	
	
	
	

	
}
