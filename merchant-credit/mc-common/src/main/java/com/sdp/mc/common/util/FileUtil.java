package com.sdp.mc.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.sdp.mc.common.vo.ExcelEntity;

/**
 * 文件下载
 *
 * @author mindong 2014年12月16日17:37:20
 *
 */
@SuppressWarnings("deprecation")
public class FileUtil {
	private static final Logger log = LoggerFactory.getLogger(FileUtil.class);
	/**
	 * Excel 2003
	 */
	private final static String XLS = "xls";

	/**
	 * Excel 2007
	 */
	private final static String XLSX = "xlsx";

	public FileUtil() {
	}

	/**
	 * 文件下载
	 *
	 * @param file
	 * @param response
	 * @throws Exception
	 */
	public static void download(File file, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		try {
			long fileLength = file.length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			log.error("FileUtil.download.error" + e.getMessage(), e);
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	public static void download(File file, String downloadName, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		try {
			long fileLength = file.length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(downloadName, "UTF-8"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			log.error("FileUtil.download.error" + e.getMessage(), e);
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	/**
	 * 文件下载 mindong.wang
	 *
	 * @param file
	 * @param response
	 * @throws Exception
	 */
	public static void download(String reportPath, String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;

		String downLoadPath = reportPath + fileName;
		try {
			long fileLength = new File(downLoadPath).length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename=" + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			log.error("文件下载ERROR:" + e.getMessage());
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	/**
	 * 读取文本文件内容
	 *
	 * @param filePathAndName
	 *            带有完整绝对路径的文件名
	 * @param encoding
	 *            文本文件打开的编码方式
	 * @return 返回文本文件的内容
	 */
	public static String readTxt(String filePathAndName, String encoding) throws IOException {
		FileIsExist(filePathAndName);
		encoding = encoding.trim();
		StringBuffer str = new StringBuffer("");
		String st = "";

		try {
			FileInputStream fs = new FileInputStream(filePathAndName);
			InputStreamReader isr;
			if (encoding.equals("")) {
				isr = new InputStreamReader(fs);
			} else {
				isr = new InputStreamReader(fs, encoding);
			}
			br = new BufferedReader(isr);
			try {
				String data = "";
				while ((data = br.readLine()) != null) {
					str.append(data + "\r\n");
				}
			} catch (Exception e) {
				str.append(e.toString());
			}
			st = str.toString();
		} catch (Exception es) {
			log.error("读取文本文件内容ERROR:" + es.getMessage());
		}
		return st;
	}

	/**
	 * 新建目录
	 *
	 * @param folderPath
	 *            目录
	 * @return 返回目录创建后的路径
	 */
	public static String createFolder(String folderPath) {
		String txt = folderPath;
		try {
			java.io.File myFilePath = new java.io.File(txt);
			txt = folderPath;
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
		} catch (Exception e) {
			log.error("新建目录ERROR:" + e.getMessage());
		}
		return txt;
	}

	/**
	 * 多级目录创建
	 *
	 * @param folderPath
	 *            准备要在本级目录下创建新目录的目录路径 例如 c:myf
	 * @param paths
	 *            无限级目录参数，各级目录以单数线区分 例如 a|b|c
	 * @return 返回创建文件后的路径 例如 c:myfac
	 */
	public String createFolders(String folderPath, String paths) {
		String txts = folderPath;
		try {
			String txt;
			txts = folderPath;
			StringTokenizer st = new StringTokenizer(paths, "|");
			for (; st.hasMoreTokens();) {
				txt = st.nextToken().trim();
				if (txts.lastIndexOf("/") != -1) {
					txts = createFolder(txts + txt);
				} else {
					txts = createFolder(txts + txt + "/");
				}
			}
		} catch (Exception e) {
			log.error("创建目录操作出错！" + e.getMessage());
		}
		return txts;
	}

	/**
	 * 新建文件
	 *
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @return
	 */
	public static void createFile(String filePathAndName, String fileContent, boolean cover, String encoding) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath, cover);
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
			resultFile.close();
		} catch (Exception e) {
			log.error("创建文件操作出错" + e.getMessage());
		}
	}

	/**
	 * 有编码方式的文件创建
	 *
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @param fileContent
	 *            文本文件内容
	 * @param encoding
	 *            编码方式 例如 GBK 或者 UTF-8
	 * @return
	 */
	public static void createFile(String filePathAndName, String fileContent, String encoding) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
		} catch (Exception e) {
			log.error("创建文件操作出错" + e.getMessage());
		}
	}

	/**
	 * 删除文件
	 *
	 * @param filePathAndName
	 *            文本文件完整绝对路径及文件名
	 * @return Boolean 成功删除返回true遭遇异常返回false
	 */
	public static boolean delFile(String filePathAndName) {
		boolean bea = false;
		try {
			String filePath = filePathAndName;
			File myDelFile = new File(filePath);
			if (myDelFile.exists()) {
				myDelFile.delete();
				bea = true;
			} else {
				bea = false;
				log.info(filePathAndName + "<br>删除文件操作出错");
			}
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
		return bea;
	}

	/**
	 * 删除文件夹
	 *
	 * @param folderPath
	 *            文件夹完整绝对路径
	 * @return
	 */
	public static boolean delFolder(String folderPath) {
		try {
			delAllFile(folderPath); // 删除完里面所有内容
			String filePath = folderPath;
			filePath = filePath.toString();
			java.io.File myFilePath = new java.io.File(filePath);
			myFilePath.delete(); // 删除空文件夹
		} catch (Exception e) {
			log.error("删除文件夹ERROR:" + e.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * 删除指定文件夹下所有文件
	 *
	 * @param path
	 *            文件夹完整绝对路径
	 * @return
	 * @return
	 */
	public static boolean delAllFile(String path) {
		boolean bea = false;
		File file = new File(path);
		if (!file.exists()) {
			return bea;
		}
		if (!file.isDirectory()) {
			return bea;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);// 先删除文件夹里面的文件
				delFolder(path + "/" + tempList[i]);// 再删除空文件夹
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * 复制单个文件
	 *
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param newPathFile
	 *            拷贝到新绝对路径带文件名
	 * @return
	 */
	public void copyFile(String oldPathFile, String newPathFile) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
				fs = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			log.error("复制单个文件操作出错" + e.getMessage(),e);
		}
	}

	/**
	 * 复制整个文件夹的内容
	 *
	 * @param oldPath
	 *            准备拷贝的目录
	 * @param newPath
	 *            指定绝对路径的新目录
	 * @return
	 */
	public void copyFolder(String oldPath, String newPath) {
		try {
			new File(newPath).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
		} catch (Exception e) {
			log.error("复制整个文件夹内容操作出错" + e.getMessage());
		}
	}

	/**
	 * 移动文件
	 *
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public void moveFile(String oldPath, String newPath) {
		copyFile(oldPath, newPath);
		delFile(oldPath);
	}

	/**
	 * 移动目录
	 *
	 * @param oldPath
	 * @param newPath
	 * @return
	 */
	public void moveFolder(String oldPath, String newPath) {
		copyFolder(oldPath, newPath);
		delFolder(oldPath);
	}


	/**
	 * 文件不存在则创建文件
	 *
	 * @param filename
	 */
	public static void FileIsExist(String filename) {
		File f = new File(filename);
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				log.error("FileUtil.FileIsExist.error" + e.getMessage(), e);
			}
		}
	}

	/**
	 * 文件是否存在 不创建文件
	 *
	 * @param filename
	 */
	public static boolean IsExist(String filename) {
		File f = new File(filename);
		if (f.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新建目录
	 *
	 * @param folderPath
	 *            目录
	 * @return 返回目录创建后的路径
	 */
	public static String createFolders(String folderPath) {
		String txt = folderPath;
		try {
			java.io.File myFilePath = new java.io.File(txt);
			txt = folderPath;
			if (!myFilePath.exists()) {
				myFilePath.mkdirs();
			}
		} catch (Exception e) {
			log.error("新建目录ERROR" + e.getMessage());
		}
		return txt;
	}

	/**
	 *
	 * @param string
	 * @param hasSymbol
	 */
//	public static void WriteFile(String filename, String content, boolean cover, String encoding) {
//		writeStringToFile(filename, content, encoding, cover);
//	}

	/**
	 *
	 * @param string
	 * @param encoding
	 * @return
	 */
	public static List<String> ReadFileToListForString(String filename, String encoding) {
		List<String> array = new ArrayList<String>();
		FileIsExist(filename);
		FileInputStream fs = null;
		InputStreamReader isr = null;
		try {
			fs = new FileInputStream(filename);
			isr = new InputStreamReader(fs, encoding);
			br2 = new BufferedReader(isr);
			String data = "";
			while ((data = br2.readLine()) != null) {
				array.add(data);
			}

		} catch (Exception e) {
			log.error("读取文件ERROR" + e.getMessage());
		} finally {
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					log.error("CloseFileInput ERROR" + e.getMessage());
				}
			}
			if (isr != null) {
				try {
					isr.close();
				} catch (IOException e) {
					log.error("Close InputStreamReader ERROR" + e.getMessage());
				}
			}
		}

		return array;
	}

	/**
	 * 在文件中追加文件
	 *
	 * @param filename
	 * @param content
	 */
//	public static void FileAdd(String filename, String content) {
//		FileIsExist(filename);
//		BufferedWriter out = null;
//		OutputStream outs=null;
//		try {
//			outs=new FileOutputStream(filename, true);
//			out = new BufferedWriter(new OutputStreamWriter(outs));
//			out.write(content);
//			out.write("\r\n");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(out != null){
//					out.close();
//				}
//				if(outs!=null){
//					outs.close();
//				}
//			} catch (IOException e) {
//				message = "Close BufferedWriter ERROR";
//				log.error(message + e.getMessage());
//			}
//		}
//	}

//	public static boolean writeStringToFile(String fileName, String content, String enc, boolean cover) {
//		File file = new File(fileName);
//
//		OutputStreamWriter os = null;
//		try {
//			// if(file.isFile()){
//			// file.deleteOnExit();
//			// file = new File(file.getAbsolutePath());
//			// }
//			if (enc == null || enc.length() == 0) {
//				os = new OutputStreamWriter(new FileOutputStream(file, cover));
//			} else {
//				os = new OutputStreamWriter(new FileOutputStream(file, cover), enc);
//			}
//			os.write(content);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		} finally {
//			if (os != null) {
//				try {
//					os.close();
//				} catch (IOException e) {
//					message = "Close OutputStreamWriter ERROR";
//					log.error(message + e.getMessage());
//				}
//			}
//		}
//		return true;
//	}

//	public static List<String> checkRepeat(String filename, String encoding) {
//		List<String> array = new ArrayList<String>();
//		FileInputStream fs = null;
//		InputStreamReader isr = null;
//		BufferedReader br = null;
//		try {
//			fs = new FileInputStream(filename);
//			isr = new InputStreamReader(fs, encoding);
//			br = new BufferedReader(isr);
//			String data = "";
//			while ((data = br.readLine()) != null) {
//				if (!array.contains(data) && !data.equals("")) {
//					array.add(data);
//				}
//
//			}
//
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (br != null) {
//					br.close();
//				}
//				if (isr != null) {
//					isr.close();
//				}
//				if (fs != null) {
//					fs.close();
//				}
//			} catch (IOException e) {
//				message = "Close Inputstream ERROR";
//				log.error(message + e.getMessage());
//			}
//		}
//
//		return array;
//
//	}

	private static List<String> list = new ArrayList<String>();

	private static BufferedReader br;

	private FileOutputStream fs;

	private static BufferedReader br2;

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	public static void tempReadFile(File file, String encoding) {

		if (file.isDirectory()) {
			File[] flist = file.listFiles();
			for (File file2 : flist) {
				tempReadFile(file2, encoding);
			}
		} else {
			try {
				FileInputStream fs = new FileInputStream(file.getPath());
				InputStreamReader isr;

				if (encoding.equals("")) {
					isr = new InputStreamReader(fs);
				} else {
					isr = new InputStreamReader(fs, encoding);
				}
				br = new BufferedReader(isr);
				try {
					String data = "";
					while ((data = br.readLine()) != null) {
						if (data.contains("(")) {
							if (!list.contains(data)) {
								list.add(data);
							}
						}
					}
				} catch (Exception e) {
					log.error("FileUtil.tempReadFile.error" + e.getMessage(), e);
				}
			} catch (IOException es) {
				log.error("FileUtil.tempReadFile.error" + es.getMessage(), es);
			}
		}
	}

	/**
	 * 创建Excel表格
	 *
	 * @param object
	 * @param outStream
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void exportExcel(ExcelEntity object, OutputStream outStream) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(object.getSheetName());
		HSSFRow row = sheet.createRow(0);// 创建第一行
		HSSFCell cell = row.createCell(0);// 创建第一行的第一个单元格
		cell.setCellValue("序号");
		String[] colNames = object.getColumnNames();
		String[] propertys = object.getPropertyNames();
		for (int i = 0; i < colNames.length; i++) { // 添加列名，从第一行的第二个单元格开始添加
			row.createCell(i + 1).setCellValue(colNames[i]);
		}
		Iterator it = object.getResultList().iterator();
		int rowNum = 1; // 从第二行开始添加数据
		while (it.hasNext()) {
			Map map = (Map) it.next();
			HSSFRow rw = sheet.createRow(rowNum);
			rw.createCell(0).setCellValue(rowNum); // 添加序号
			rowNum++;
			for (int x = 0; x < propertys.length; x++) {
				String property = propertys[x];
				if (map.containsKey(property)) {
					Object value = map.get(propertys[x]); // 根据属性名称得到属性值
					if (value == null || "null".equalsIgnoreCase(value.toString())) {
						value = "";
					}
					rw.createCell(x + 1).setCellValue(value + "");
				} else {
					rw.createCell(x + 1).setCellValue("");
				}
			}
		}
		try {
			wb.write(outStream);
			outStream.flush();
			outStream.close();
		} catch (IOException e) {
			if (outStream != null) {
				outStream.close();
			}
			log.error("FileUtil.exportExcel.error" + e.getMessage(), e);
		}
	}

	/**
	 * 导出Excel
	 *
	 * @param response
	 * @param list
	 * @param columns
	 * @param propertyNames
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static void exportView(HttpServletResponse response, List<Map> list, String[] columns, String[] propertyNames) throws IOException, UnsupportedEncodingException,
			Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		ExcelEntity entity = new ExcelEntity();
		entity.setColumnNames(columns);
		entity.setPropertyNames(propertyNames);
		entity.setResultList(list);
		entity.setSheetName(sdf.format(new Date()));

		OutputStream outStream = response.getOutputStream();
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		String fileName = sdf.format(new Date()) + ".xls";
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("GBK"), "iso8859-1"));
		exportExcel(entity, outStream);
	}

	/**
	 * 创建通用EXCEL头部
	 *
	 * @param headString
	 *            头部显示的字符
	 * @param colSum
	 *            该报表的列数
	 */
	public void createNormalHead(String headString, int colSum, String sheetName) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFRow row = sheet.createRow(0);

		// 设置第一行
		HSSFCell cell = row.createCell(0);
		row.setHeight((short) 400);

		// 定义单元格为字符串类型
		cell.setCellType(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue(new HSSFRichTextString(headString));

		// 指定合并区域
//		sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) colSum));

		HSSFCellStyle cellStyle = wb.createCellStyle();

		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 指定单元格居中对齐
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 指定单元格垂直居中对齐
		cellStyle.setWrapText(true);// 指定单元格自动换行

		// 设置单元格字体
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 300);
		cellStyle.setFont(font);

		cell.setCellStyle(cellStyle);
	}

	/**
	 * 由Excel文件的Sheet导出至List
	 *
	 * @param file
	 *            导入的excel文件
	 * @param sheetNum
	 *            excel工作空间,一般情况为0
	 * @return
	 */
	public static List<Map<String, Object>> exportListFromExcel(File file, int sheetNum) throws IOException {
		return exportListFromExcel(new FileInputStream(file), FilenameUtils.getExtension(file.getName()), sheetNum);
	}

	/**
	 * 由Excel流的Sheet导出至List
	 *
	 * @param is
	 * @param extensionName
	 * @param sheetNum
	 * @return
	 * @throws IOException
	 */
	public static List<Map<String, Object>> exportListFromExcel(InputStream is, String extensionName, int sheetNum) throws IOException {
		Workbook workbook = null;
		if (extensionName.toLowerCase().equals(XLS)) {
			workbook = new HSSFWorkbook(is);
		} else if (extensionName.toLowerCase().equals(XLSX)) {
			workbook = new XSSFWorkbook(is);
		}

		return readCell(workbook, sheetNum);
	}

	/**
	 * 读取Cell的值
	 *
	 * @param sheet
	 * @return
	 */
	public static List<Map<String, Object>> readCell(Workbook workbook, int sheetNum) {
		Sheet sheet = workbook.getSheetAt(sheetNum);
		// 解析公式结果
		// FormulaEvaluator evaluator =
		// workbook.getCreationHelper().createFormulaEvaluator();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		// 遍历所有行 除去表头即第一行
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			// 便利所有列
			for (Cell cell : row) {
				// 获取单元格的类型
				CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
				String key = cellRef.formatAsString();
				switch (cell.getCellType()) {
				// 字符串
				case Cell.CELL_TYPE_STRING:
					map.put(key, cell.getRichStringCellValue().getString());
					break;
				// 数字
				case Cell.CELL_TYPE_NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						map.put(key, cell.getDateCellValue());
					} else {
						map.put(key, cell.getNumericCellValue());
					}
					break;
				// boolean
				case Cell.CELL_TYPE_BOOLEAN:
					map.put(key, cell.getBooleanCellValue());
					break;
				// 方程式
				case Cell.CELL_TYPE_FORMULA:
					map.put(key, cell.getCellFormula());
					break;
				case Cell.CELL_TYPE_BLANK:
					break;
				case Cell.CELL_TYPE_ERROR:
					break;
				// 空值
				default:
					// map.put(key, "");
				}
			}
			list.add(map);
		}
		return list;
	}
	/**
	 * MultipartFileTOFile
	 * @param file
	 * @return
	 */
	public static File MultipartFileTOFile(MultipartFile file){
		File tmpFile = null;
		try {
			tmpFile = File.createTempFile(file.getOriginalFilename(), ".tmp");
			FileUtils.copyInputStreamToFile(file.getInputStream(), tmpFile);
		} catch (IOException e) {
			log.error("FileUtil.MultipartFileTOFile.error" + e.getMessage(), e);
		}
		return tmpFile;
	}
	/**
	 * byte 转文件
	 * @param buf
	 * @param filePath
	 * @param fileName
	 */
	public static void byte2File(byte[] buf, String filePath, String fileName)
    {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try
        {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory())
            {
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(buf);
        }
        catch (Exception e)
        {
        	log.error("FileUtil.byte2File.error" + e.getMessage(), e);
        }
        finally
        {
            if (bos != null)
            {
                try
                {
                    bos.close();
                }
                catch (IOException e)
                {
                	log.error("FileUtil.byte2File.error" + e.getMessage(), e);
                }
            }
            if (fos != null)
            {
                try
                {
                    fos.close();
                }
                catch (IOException e)
                {
                	log.error("FileUtil.byte2File.error" + e.getMessage(), e);
                }
            }
        }
    }

	/**
	 * 文件 转 byte
	 * @param buf
	 * @param filePath
	 * @param fileName
	 */
	public static byte[] File2byte(String filePath)
    {
        byte[] buffer = null;
        try
        {
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1)
            {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        }
        catch (FileNotFoundException e)
        {
        	log.error("FileUtil.File2byte.error" + e.getMessage(), e);
        }
        catch (IOException e)
        {
        	log.error("FileUtil.File2byte.error" + e.getMessage(), e);
        }
        return buffer;
    }
}
