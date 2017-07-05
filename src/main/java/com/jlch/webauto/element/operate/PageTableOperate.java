package com.jlch.webauto.element.operate;

public class PageTableOperate {
	public static String selectColumnByXpath(String Xpath1,String Column,String Xpath2){
		String result =null; 
		result = Xpath1+Column+Xpath2;
		return result;
	}
	public static String selectRowByXpath(String Xpath1,String Row,String Xpath2){
		String result =null; 
		result = Xpath1+Row+Xpath2;
		return result;
	}
}
