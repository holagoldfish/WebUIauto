package tool;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.jlch.webauto.dboperate.DBOperator;
import com.jlch.webauto.element.operate.ElementOperate;
import com.jlch.webauto.entity.LoginPage;
import com.jlch.webauto.entity.RegisterPage;
import com.jlch.webauto.util.Constr;

public class CreateSOperate_ok {
	private String packageOutPath = "com.jlch.webauto.operate";// 生成指定类所在包的路径	
	private static String CLASS_NAME = "SMemberOperate";
	private static String page = "MemberPage";	
	private static String CLASS_FILE = CLASS_NAME + "1.java";	
	

	private String[] colnames; // 列名数组
	private String[] colTypes; // 列名类型数组
	private int[] colSizes; // 列名大小数组

	public static void main(String args[]) {
		CreateSOperate_ok mtc = new CreateSOperate_ok();
		mtc.createClass();
		System.out.println("javac " + CLASS_FILE);
		// mtc.compileClass();
		System.out.println("java " + CLASS_NAME);
		// mtc.runClass();
	}

	public void createClass() {
		try {
			//new File(CLASS_FILE).delete();
			// String outputPath = directory.getAbsolutePath()+
			// "/src/main/java/"+this.packageOutPath.replace(".",
			// "/")+"/"+initcap(tablename) + ".java";

			File directory = new File("");
			String outputPath = directory.getAbsolutePath()
					+ "/src/main/java/"
					+ this.packageOutPath.replace(".", "/") + "/"
					+ initcap(CLASS_NAME) + ".java";
			
			//FileWriter fw = new FileWriter(outputPath);
			//FileWriter aWriter = new FileWriter(CLASS_FILE, true);
			
			FileWriter fw = new FileWriter(outputPath);
			PrintWriter aWriter = new PrintWriter(fw);

		    StringBuffer buffer = new StringBuffer();
			buffer.append("package "+packageOutPath+";");
			buffer.append("\r\n");
			buffer.append("import java.sql.*;");
			buffer.append("\r\n");
			buffer.append("import java.util.*;");
			buffer.append("\r\n");
			buffer.append("import org.openqa.selenium.*;");
			buffer.append("\r\n");
			buffer.append("import org.testng.*;");
			buffer.append("\r\n");
			buffer.append("import com.jlch.webauto.dboperate.*;");
			buffer.append("\r\n");
			buffer.append("import com.jlch.webauto.util.*;");
			buffer.append("\r\n");
			buffer.append("import com.jlch.webauto.element.operate.*;");
			buffer.append("\r\n");
			buffer.append("import com.jlch.webauto.entity.*;");
			buffer.append("\r\n");
			
			buffer.append("public class " + CLASS_NAME + "{");
			buffer.append("\r\n");
			buffer.append("public static ArrayList<" + page + "> list=null;");
			buffer.append("\r\n");
			buffer.append("public static ArrayList<" + page + "> getALLCase(){");
			buffer.append("\r\n");
			
			buffer.append("if (list == null) {");
			buffer.append("list=new ArrayList<" + page + ">();");
			buffer.append("String sql = \"select * from t_" + page
					+ " order by id asc\";");


			buffer.append("try {");
			buffer.append("ResultSet r = DBOperator.getResultSet(sql);");
			buffer.append("ResultSetMetaData rsmd = r.getMetaData();");
			buffer.append("int columnCount = rsmd.getColumnCount();");
			buffer.append("int rowCount = r.getRow();");
			buffer.append("int n = 0;");
			buffer.append("while (r.next()) {");
			buffer.append("" + page + " page = new " + page + "();");

			String sql = "select * from t_"+page;

			DBOperator operator = new DBOperator();
		
				ResultSet rSet = operator.getResultSet(sql);
				ResultSetMetaData rsmd = rSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				int rowCount = rSet.getRow();
				int n = 0;

				int size = rsmd.getColumnCount(); // 统计列
				colnames = new String[size];
				colTypes = new String[size];
				colSizes = new int[size];
				for (int i = 0; i < size; i++) {
					String newstr="";
					String ss=rsmd.getColumnName(i + 1);
					newstr=ss.substring(0,1).toUpperCase()+ss.substring(1).toLowerCase();
					colnames[i] =newstr; 
					colTypes[i] = rsmd.getColumnTypeName(i + 1);
					System.out.println(colTypes[i] );
					if(colTypes[i]=="NUMBER")
					{
			           buffer.append("page.set"+colnames[i]+"(r.getInt(\""+colnames[i]+"\"));");
					}
					else
					{
						buffer.append("page.set"+colnames[i]+"(Constr.Str(r.getString(\""+colnames[i]+"\")));");
					}
				}


			buffer.append("list.add(page);");
			buffer.append("n++;");
			buffer.append("}");
			buffer.append("} catch (Exception ex) {");
			buffer.append("}}");
			buffer.append("return list;");

			buffer.append("}");
			
			buffer.append("\r\n");
			buffer.append("\r\n");
			
			
			buffer.append("public static "+page+" getPage(int casenumber)");
			buffer.append("{");
			buffer.append("\r\n");
			buffer.append(""+page+" page=null;");
			buffer.append("\r\n");
			buffer.append("for(int i=0;i<list.size();i++)");
			buffer.append("{");
			buffer.append(""+page+" p=list.get(i);");
			buffer.append("if(p.getId()==casenumber)");
			buffer.append("\r\n");
			buffer.append("{");
			buffer.append("page=p;");
			buffer.append("break;");	
			buffer.append("}");		
			buffer.append("}");			   
			buffer.append("return page;");	
			buffer.append("}");	
			
			//---------------------------操作
			buffer.append("public static void operate1_sql(WebDriver driver, int casenumber) {");	
			buffer.append("\r\n");
			buffer.append("list=getALLCase();");
			buffer.append("if(list!=null)");
			buffer.append("\r\n");
			buffer.append("{");
			buffer.append("\r\n");
			buffer.append(""+page+" page=getPage(casenumber);");
			buffer.append("ElementOperate operate=new ElementOperate();");
						
             for (int i = 1; i < size-1; i++) {
				
				String c1=rsmd.getColumnName(i + 1);
				String c2=rsmd.getColumnName(i + 2);
				String c3=rsmd.getColumnName(i + 3);
				
				String v1=c1.substring(0,1).toUpperCase()+c1.substring(1).toLowerCase();
				String v2=c2.substring(0,1).toUpperCase()+c2.substring(1).toLowerCase();
				String v3=c3.substring(0,1).toUpperCase()+c3.substring(1).toLowerCase();
				i+=2;
				size-=2;				
						
				String str1="page.get"+v1+"()";
				String str2="page.get"+v2+"()";
				String str3="page.get"+v3+"()";
				
				System.out.println(str1);
				System.out.println(str2);
				System.out.println(str3);
				
				buffer.append("operate.findElementOperate(driver,"+str1+","+str2+","+str3+");");
				
			}
									
					
			
			
			buffer.append("}");
			buffer.append("\r\n");
			buffer.append("else");
			buffer.append("\r\n");
			buffer.append("{");
			buffer.append("\r\n");
			buffer.append("Assert.assertNotNull(list,\"没有测试用例数据\");");
			buffer.append("}");	
			buffer.append("}");	
			
			
			//---------------------------end操作
	
		
		
		
		
		
		
			
			buffer.append("}");

			aWriter.write(buffer.toString());

			aWriter.flush();
			aWriter.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 功能：将输入字符串的首字母改成大写
	 * 
	 * @param str
	 * @return
	 */
	private String initcap(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}
	

	/*
	 * public void compileClass() { String filePath = new
	 * File(CreateClass.class.
	 * getClassLoader().getResource("").getFile()).getAbsolutePath();
	 * System.out.println("ff: "+filePath); String[] source = { "-d", filePath,
	 * new String(CLASS_FILE) }; System.out.println("javac out:"+
	 * com.sun.tools.javac.Main.compile(source)); }
	 * 
	 * public void runClass() { try { Class params[] = {}; Object paramsObj[] =
	 * {}; Class testClass = Class.forName(CLASS_NAME); Object iClass =
	 * testClass.newInstance(); Method thisMethod =
	 * testClass.getDeclaredMethod("println", params); thisMethod.invoke(iClass,
	 * paramsObj); } catch (Exception e) { e.printStackTrace(); } }
	 */
}
