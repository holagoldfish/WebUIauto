package com.jlch.webauto.operate;

import java.sql.*;
import java.util.*;
import org.openqa.selenium.*;
import org.testng.*;
import com.jlch.webauto.dboperate.*;
import com.jlch.webauto.util.*;
import com.jlch.webauto.element.operate.*;
import com.jlch.webauto.entity.*;

public class SMemberOperate {
	public static ArrayList<MemberPage> list = null;

	public static ArrayList<MemberPage> getALLCase() {
		if (list == null) {
			list = new ArrayList<MemberPage>();
			String sql = "select * from t_MemberPage order by id asc";
			try {
				ResultSet r = DBOperator.getResultSet(sql);
				ResultSetMetaData rsmd = r.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int rowCount = r.getRow();
				int n = 0;
				while (r.next()) {
					MemberPage page = new MemberPage();
					page.setId(r.getInt("Id"));
					page.setUi_url(Constr.Str(r.getString("Ui_url")));
					page.setText_url(Constr.Str(r.getString("Text_url")));
					page.setValue_url(Constr.Str(r.getString("Value_url")));
					page.setUi_memberurl(Constr.Str(r.getString("Ui_memberurl")));
					page.setText_memberurl(Constr.Str(r
							.getString("Text_memberurl")));
					page.setValue_memberurl(Constr.Str(r
							.getString("Value_memberurl")));
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
					page.setUi_companyname(Constr.Str(r
							.getString("Ui_companyname")));
					page.setText_companyname(Constr.Str(r
							.getString("Text_companyname")));
					page.setValue_companyname(Constr.Str(r
							.getString("Value_companyname")));
					page.setUi_checkcompanyname(Constr.Str(r
							.getString("Ui_checkcompanyname")));
					page.setText_checkcompanyname(Constr.Str(r
							.getString("Text_checkcompanyname")));
					page.setValue_checkcompanyname(Constr.Str(r
							.getString("Value_checkcompanyname")));
					page.setUi_fixedtelphoneprefix(Constr.Str(r
							.getString("Ui_fixedtelphoneprefix")));
					page.setText_fixedtelphoneprefix(Constr.Str(r
							.getString("Text_fixedtelphoneprefix")));
					page.setValue_fixedtelphoneprefix(Constr.Str(r
							.getString("Value_fixedtelphoneprefix")));
					page.setUi_checkfixedtelphoneprefix(Constr.Str(r
							.getString("Ui_checkfixedtelphoneprefix")));
					page.setText_checkfixedtelphoneprefix(Constr.Str(r
							.getString("Text_checkfixedtelphoneprefix")));
					page.setValue_checkfixedtelphoneprefix(Constr.Str(r
							.getString("Value_checkfixedtelphoneprefix")));
					page.setUi_fixedtelphone(Constr.Str(r
							.getString("Ui_fixedtelphone")));
					page.setText_fixedtelphone(Constr.Str(r
							.getString("Text_fixedtelphone")));
					page.setValue_fixedtelphone(Constr.Str(r
							.getString("Value_fixedtelphone")));
					page.setUi_checkfixedtelphone(Constr.Str(r
							.getString("Ui_checkfixedtelphone")));
					page.setText_checkfixedtelphone(Constr.Str(r
							.getString("Text_checkfixedtelphone")));
					page.setValue_checkfixedtelphone(Constr.Str(r
							.getString("Value_checkfixedtelphone")));
					page.setUi_province(Constr.Str(r.getString("Ui_province")));
					page.setText_province(Constr.Str(r
							.getString("Text_province")));
					page.setValue_province(Constr.Str(r
							.getString("Value_province")));
					page.setUi_city(Constr.Str(r.getString("Ui_city")));
					page.setText_city(Constr.Str(r.getString("Text_city")));
					page.setValue_city(Constr.Str(r.getString("Value_city")));
					page.setUi_checkcity(Constr.Str(r.getString("Ui_checkcity")));
					page.setText_checkcity(Constr.Str(r
							.getString("Text_checkcity")));
					page.setValue_checkcity(Constr.Str(r
							.getString("Value_checkcity")));
					page.setUi_companyaddress(Constr.Str(r
							.getString("Ui_companyaddress")));
					page.setText_companyaddress(Constr.Str(r
							.getString("Text_companyaddress")));
					page.setValue_companyaddress(Constr.Str(r
							.getString("Value_companyaddress")));
					page.setUi_checkcompanyaddress(Constr.Str(r
							.getString("Ui_checkcompanyaddress")));
					page.setText_checkcompanyaddress(Constr.Str(r
							.getString("Text_checkcompanyaddress")));
					page.setValue_checkcompanyaddress(Constr.Str(r
							.getString("Value_checkcompanyaddress")));
					page.setUi_contactemail(Constr.Str(r
							.getString("Ui_contactemail")));
					page.setText_contactemail(Constr.Str(r
							.getString("Text_contactemail")));
					page.setValue_contactemail(Constr.Str(r
							.getString("Value_contactemail")));
					page.setUi_department(Constr.Str(r
							.getString("Ui_department")));
					page.setText_department(Constr.Str(r
							.getString("Text_department")));
					page.setValue_department(Constr.Str(r
							.getString("Value_department")));
					page.setUi_position(Constr.Str(r.getString("Ui_position")));
					page.setText_position(Constr.Str(r
							.getString("Text_position")));
					page.setValue_position(Constr.Str(r
							.getString("Value_position")));
					page.setUi_companyindustry(Constr.Str(r
							.getString("Ui_companyindustry")));
					page.setText_companyindustry(Constr.Str(r
							.getString("Text_companyindustry")));
					page.setValue_companyindustry(Constr.Str(r
							.getString("Value_companyindustry")));
					page.setUi_companywebsite(Constr.Str(r
							.getString("Ui_companywebsite")));
					page.setText_companywebsite(Constr.Str(r
							.getString("Text_companywebsite")));
					page.setValue_companywebsite(Constr.Str(r
							.getString("Value_companywebsite")));
					page.setUi_banknames(Constr.Str(r.getString("Ui_banknames")));
					page.setText_banknames(Constr.Str(r
							.getString("Text_banknames")));
					page.setValue_banknames(Constr.Str(r
							.getString("Value_banknames")));
					page.setUi_checkbanknames(Constr.Str(r
							.getString("Ui_checkbanknames")));
					page.setText_checkbanknames(Constr.Str(r
							.getString("Text_checkbanknames")));
					page.setValue_checkbanknames(Constr.Str(r
							.getString("Value_checkbanknames")));
					page.setUi_subbranch(Constr.Str(r.getString("Ui_subbranch")));
					page.setText_subbranch(Constr.Str(r
							.getString("Text_subbranch")));
					page.setValue_subbranch(Constr.Str(r
							.getString("Value_subbranch")));
					page.setUi_checksubbranch(Constr.Str(r
							.getString("Ui_checksubbranch")));
					page.setText_checksubbranch(Constr.Str(r
							.getString("Text_checksubbranch")));
					page.setValue_checksubbranch(Constr.Str(r
							.getString("Value_checksubbranch")));
					page.setUi_account(Constr.Str(r.getString("Ui_account")));
					page.setText_account(Constr.Str(r.getString("Text_account")));
					page.setValue_account(Constr.Str(r
							.getString("Value_account")));
					page.setUi_checkaccount(Constr.Str(r
							.getString("Ui_checkaccount")));
					page.setText_checkaccount(Constr.Str(r
							.getString("Text_checkaccount")));
					page.setValue_checkaccount(Constr.Str(r
							.getString("Value_checkaccount")));
					page.setUi_btn(Constr.Str(r.getString("Ui_btn")));
					page.setText_btn(Constr.Str(r.getString("Text_btn")));
					page.setValue_btn(Constr.Str(r.getString("Value_btn")));
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

	public static MemberPage getPage(int casenumber) {
		MemberPage page = null;
		for (int i = 0; i < list.size(); i++) {
			MemberPage p = list.get(i);
			if (p.getId() == casenumber) {
				page = p;
				break;
			}
		}
		return page;
	}

	public static void operate1_sql(WebDriver driver, int casenumber) {
		list = getALLCase();
		if (list != null) {
			MemberPage page = getPage(casenumber);
			ElementOperate operate = new ElementOperate();
			operate.findElementOperate(driver, page.getUi_url(),page.getText_url(), page.getValue_url());
			operate.findElementOperate(driver, page.getUi_memberurl(),page.getText_memberurl(), page.getValue_memberurl());
			//operate.findElementOperate(driver, page.getUi_contactname(),page.getText_contactname(), page.getValue_contactname());
			//operate.findElementOperate(driver, page.getUi_checkcontactname(),page.getText_checkcontactname(),page.getValue_checkcontactname());
			//operate.findElementOperate(driver, page.getUi_companyname(),page.getText_companyname(), page.getValue_companyname());
			//operate.findElementOperate(driver, page.getUi_checkcompanyname(),page.getText_checkcompanyname(),page.getValue_checkcompanyname());
			//operate.findElementOperate(driver,page.getUi_fixedtelphoneprefix(),page.getText_fixedtelphoneprefix(),page.getValue_fixedtelphoneprefix());
			//operate.findElementOperate(driver,page.getUi_checkfixedtelphoneprefix(),page.getText_checkfixedtelphoneprefix(),page.getValue_checkfixedtelphoneprefix());
			//operate.findElementOperate(driver, page.getUi_fixedtelphone(),/page.getText_fixedtelphone(), page.getValue_fixedtelphone());
			//operate.findElementOperate(driver, page.getUi_checkfixedtelphone(),page.getText_checkfixedtelphone(),page.getValue_checkfixedtelphone());
			operate.findElementOperate(driver, page.getUi_province(),page.getText_province(), page.getValue_province());
			operate.findElementOperate(driver, page.getUi_city(),page.getText_city(), page.getValue_city());
			//operate.findElementOperate(driver, page.getUi_checkcity(),page.getText_checkcity(), page.getValue_checkcity());
			operate.findElementOperate(driver, page.getUi_companyaddress(),page.getText_companyaddress(),page.getValue_companyaddress());
			//operate.findElementOperate(driver,page.getUi_checkcompanyaddress(),page.getText_checkcompanyaddress(),page.getValue_checkcompanyaddress());
			//operate.findElementOperate(driver, page.getUi_contactemail(),page.getText_contactemail(), page.getValue_contactemail());
			//operate.findElementOperate(driver, page.getUi_department(),page.getText_department(), page.getValue_department());
			operate.findElementOperate(driver, page.getUi_banknames(),page.getText_banknames(), page.getValue_banknames());
			operate.findElementOperate(driver, page.getUi_subbranch(),page.getText_subbranch(), page.getValue_subbranch());
			operate.findElementOperate(driver, page.getUi_account(),page.getText_account(), page.getValue_account());
			operate.findElementOperate(driver, page.getText_btn(),page.getText_btn(), page.getValue_btn());
			
		} else {
			Assert.assertNotNull(list, "没有测试用例数据");
		}
	}
}