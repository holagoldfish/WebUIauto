package other;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import com.jlch.webauto.dboperate.DBOperator;
import com.jlch.webauto.entity.*;
import com.jlch.webauto.util.Constr;

public class CreateClass {
	private static String CLASS_NAME = "CreateClassTest1";
	private static String CLASS_FILE = CLASS_NAME + "1.java";
	private static String page = "LoginPage";
	private static String table = "select * from t_LoginPage order by id asc";

	private String[] colnames; // 列名数组
	private String[] colTypes; // 列名类型数组
	private int[] colSizes; // 列名大小数组

	public static void main(String args[]) {
		CreateClass mtc = new CreateClass();
		mtc.createClass();
		System.out.println("javac " + CLASS_FILE);
		// mtc.compileClass();
		System.out.println("java " + CLASS_NAME);
		// mtc.runClass();
	}

	public void createClass() {
		try {
			new File(CLASS_FILE).delete();
			// String outputPath = directory.getAbsolutePath()+
			// "/src/main/java/"+this.packageOutPath.replace(".",
			// "/")+"/"+initcap(tablename) + ".java";

			FileWriter aWriter = new FileWriter(CLASS_FILE, true);

			/*
			 * aWriter.write("public   class   " + CLASS_NAME + "{");
			 * aWriter.write("public   void   println()   {"); //
			 * aWriter.write("System.out.println("=" + CLASS_NAME + "=");"); //
			 * aWriter.write("}}"); aWriter.write(
			 * "System.out.println(\"hello wgfdgfdgfdghdfhfghfghorld\");");
			 * aWriter.write("}}");
			 */

			StringBuffer buffer = new StringBuffer();
			buffer.append("import java.sql.*;");
			buffer.append("import java.util.ArrayList;");
			buffer.append("import com.jlch.webauto.entity.*;");
			buffer.append("import com.jlch.webauto.dboperate.*;");

			buffer.append("public class " + CLASS_NAME + "{");
			buffer.append("static ArrayList<" + page + "> list;");
			buffer.append("public static ArrayList<" + page + "> getALLCase(){");

			buffer.append("if (list == null) {");
			buffer.append("list=new ArrayList<" + page + ">();");
			buffer.append("String sql = \"select * from t_" + page
					+ " order by id asc\";");

			// / String sql = "select * from t_LoginPage order by id asc";

			buffer.append("try {");
			buffer.append("ResultSet r = DBOperator.getResultSet(sql);");
			buffer.append("ResultSetMetaData rsmd = r.getMetaData();");
			buffer.append("int columnCount = rsmd.getColumnCount();");
			buffer.append("int rowCount = r.getRow();");
			buffer.append("int n = 0;");
			buffer.append("while (r.next()) {");
			buffer.append("" + page + " page = new " + page + "();");

			String sql = "select * from t_LoginPage";

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
					//ss.substring(0,1).toUpperCase()+str.substring(1);
					//colnames[i] = rsmd.getColumnName(i + 1).toLowerCase();
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

			//buffer.append("page.setId(r.getInt(\"ID\"));");

			buffer.append("list.add(page);");
			buffer.append("n++;");
			buffer.append("}");
			buffer.append("} catch (Exception ex) {");
			buffer.append("}}");
			buffer.append("return list;");

			/*
			 * page.setUi_url(Constr.Str(r.getString("ui_url")));
			 * page.setText_url(Constr.Str(r.getString("text_url")));
			 * page.setValue_url(Constr.Str(r.getString("value_url")));
			 * 
			 * page.setUi_username(Constr.Str(r.getString("ui_username")));
			 * page.setText_username(Constr.Str(r.getString("text_username")));
			 * page
			 * .setValue_username(Constr.Str(r.getString("value_username")));
			 * 
			 * page.setUi_loginbtn(Constr.Str(r.getString("ui_loginbtn")));
			 * page.setText_loginbtn(Constr.Str(r.getString("ui_loginbtn")));
			 * page
			 * .setValue_loginbtn(Constr.Str(r.getString("value_loginbtn")));
			 */

			/*
			 * page.set(Constr.Str(r.getString("ui_loginbtn")));
			 * page.setText_loginbtn(Constr.Str(r.getString("ui_loginbtn")));
			 * page
			 * .setValue_loginbtn(Constr.Str(r.getString("value_loginbtn")));
			 */

			/*
			 * list.add(page); n++; } } catch (Exception ex) { } } return list;
			 */

			buffer.append("}");
			buffer.append("}");

			aWriter.write(buffer.toString());

			aWriter.flush();
			aWriter.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
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
