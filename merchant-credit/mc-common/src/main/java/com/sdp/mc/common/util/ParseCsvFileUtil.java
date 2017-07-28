package com.sdp.mc.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 解析CVS
 *
 * @author zhangyulong
 *
 */
public class ParseCsvFileUtil {
	private static Logger logger = LoggerFactory.getLogger(ParseCsvFileUtil.class);

	/**
	 * csv文件读取<BR/>
	 * 读取绝对路径为argPath的csv文件数据，并以List返回。
	 *
	 * @param argPath
	 *            csv文件绝对路径
	 * @return csv文件数据（List<String[]>）
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static List<String[]> readCsvFile(File file, String encoding) {
		if (file == null) {
			logger.info("ParseCsvFileUtil.readCsvFile.file is null");
			return null;
		}

		List<String[]> list = new ArrayList<String[]>();
		FileInputStream input = null;
		InputStreamReader reader = null;
		BufferedReader bReader = null;
		try {
			input = new FileInputStream(file);
			if (StringUtils.isBlank(encoding)) {
				reader = new InputStreamReader(input);
			} else {
				reader = new InputStreamReader(input, encoding);
			}
			bReader = new BufferedReader(reader);
			String strTitle = "";

			String str1 = "";
			Pattern pCells = Pattern.compile("(\"[^\"]*(\"{2})*[^\"]*\")*[^,]*,");
			while ((strTitle = bReader.readLine()) != null) {
				// if (!strTitle.endsWith(",")) {
				strTitle = strTitle + ",";
				// }
				Matcher mCells = pCells.matcher(strTitle);
				List<String> listTemp = new ArrayList<String>();
				// 读取每个单元格
				while (mCells.find()) {

					str1 = mCells.group();
					str1 = str1.replaceAll("(?sm)\"?([^\"]*(\"{2})*[^\"]*)\"?.*,", "$1");
					// str1 = str1.replaceAll("(?sm)(\"(\"))", "$2");
					logger.info("readCsvFile,cell content:{}", str1);
					listTemp.add(str1);

				}
				list.add((String[]) listTemp.toArray(new String[listTemp.size()]));

			}
		} catch (FileNotFoundException e) {
			logger.error("ParseCsvFileUtil.readCsvFile.FileNotFoundException" + e.getMessage(), e);
		} catch (IOException e) {
			logger.error("ParseCsvFileUtil.readCsvFile.IOException" + e.getMessage(), e);
		} finally {
			if (null != input) {
				try {
					input.close();
				} catch (IOException e) {
					logger.error("ParseCsvFileUtil.readCsvFile.finally.input.close.IOException" + e.getMessage(), e);
				}
			}
			if (null != bReader) {

				try {
					bReader.close();
				} catch (IOException e) {
					logger.error("ParseCsvFileUtil.readCsvFile.finally.bReader.close.IOException" + e.getMessage(), e);
				}
			}
		}

		return list;
	}

	public static void main(String[] args) {
		String argPath = "F:/daikou_xxx_2016xxxxxxxx - 副本.csv";
		File file = new File(argPath);
		List<String[]> s = readCsvFile(file, "gb2312");
		for (String[] strings : s) {
			for (int i = 0; i < strings.length; i++) {
				System.out.println(strings[i]);
			}
		}
	}
}
