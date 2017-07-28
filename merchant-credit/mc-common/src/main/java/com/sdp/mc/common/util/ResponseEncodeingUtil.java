package com.sdp.mc.common.util;

/**
 * 拼接输出文件的头文件
 * @author heyi.alex
 *
 */
public class ResponseEncodeingUtil {

	/**
	 * Utf-8 头文件
	 */
	private final static byte commonCsvHead[] = { (byte) 0xEF, (byte) 0xBB,
        (byte) 0xBF };

	/**
	 * 输出
	 * @return
	 */
	public static byte[] writeEncodingUtf8(String content){
		byte[] contentByte = content.getBytes();
		byte[] outputByte = new byte[commonCsvHead.length + contentByte.length];
		System.arraycopy(commonCsvHead, 0, outputByte, 0, commonCsvHead.length);
        System.arraycopy(contentByte, 0, outputByte, commonCsvHead.length, contentByte.length);
        return outputByte;
	}

}
