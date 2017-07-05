package tool;

public class Createsql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String table="RegisterPage";
		String[] str={"url","name","pwd","checkpwd","repeatpwd","checkrepeatpwd"};
		
		
		
		 StringBuffer buffer = new StringBuffer();
	     buffer.append("create table t_"+table);
	     buffer.append("\r\n");
	     buffer.append("  ID    NUMBER(11)   not null,");
	     buffer.append("\r\n");
	     for(int i=0;i<str.length;i++)
	     {
	    	 buffer.append("  ui_"+str[i]+"       VARCHAR(100),");
	    	 buffer.append("\r\n");
	    	 buffer.append("  text_"+str[i]+"     VARCHAR(300),");
	    	 buffer.append("\r\n");
	    	 buffer.append("  value_"+str[i]+"    VARCHAR(300),");
	    	 buffer.append("\r\n");
	     }
	     buffer.append("  re_expected          VARCHAR(90),");
	     buffer.append("\r\n");
	     buffer.append("  re_actual            VARCHAR(90),");
	     buffer.append("\r\n");
	     buffer.append("  re_picture           VARCHAR(300),");
	     buffer.append("\r\n");
	     buffer.append("  re_option            VARCHAR(4),");
	     buffer.append("\r\n");
	     buffer.append("  re_memo              VARCHAR(300),");
	     buffer.append("\r\n");
	     buffer.append("  constraint PK_t_"+table+" primary key (ID)");
	     buffer.append("\r\n");
	     buffer.append(");");
	     buffer.append("\r\n");     
	     System.out.println(buffer.toString());
	     
	}

}
