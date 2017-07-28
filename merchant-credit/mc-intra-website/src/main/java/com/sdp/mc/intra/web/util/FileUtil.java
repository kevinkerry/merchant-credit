package com.sdp.mc.intra.web.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件下载
 * @author mindong
 * 2014年12月16日17:37:20
 *
 */
public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FastSettleConverterUtil.class);
	public FileUtil() {
	}


	/**
	 * 文件下载
	 *
	 * @param file
	 * @param response
	 * @throws Exception
	 */
	public static void download(File file, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		try {
			long fileLength = file.length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ java.net.URLEncoder.encode(file.getName(), "UTF-8"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	public static void download(File file,String downloadName, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		java.io.BufferedInputStream bis = null;
		java.io.BufferedOutputStream bos = null;
		try {
			long fileLength = file.length();
			response.setContentType("application/x-msdownload;");
			response.setHeader("Content-disposition", "attachment; filename="
					+ java.net.URLEncoder.encode(downloadName, "UTF-8"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(file));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		} finally {
			if (bis != null)
				bis.close();
			if (bos != null)
				bos.close();
		}
	}

	/**
	 * 文件下载
	 * mindong.wang
	 * @param file
	 * @param response
	 * @throws Exception
	 */
	public static void download(String reportPath,String fileName, HttpServletRequest request,HttpServletResponse response)
			throws Exception {
		 response.setContentType("text/html;charset=utf-8");
	        request.setCharacterEncoding("UTF-8");
	        java.io.BufferedInputStream bis = null;
	        java.io.BufferedOutputStream bos = null;

	        String downLoadPath = reportPath+fileName;
	        try {
	            long fileLength = new File(downLoadPath).length();
	            response.setContentType("application/x-msdownload;");
	            response.setHeader("Content-disposition", "attachment; filename="
	                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
	            response.setHeader("Content-Length", String.valueOf(fileLength));
	            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
	            bos = new BufferedOutputStream(response.getOutputStream());
	            byte[] buff = new byte[2048];
	            int bytesRead;
	            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	                bos.write(buff, 0, bytesRead);
	            }
	        } catch (Exception e) {
	        	logger.error(e.getMessage(),e);
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
	public static String readTxt(String filePathAndName, String encoding)
			throws IOException {
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
				logger.error(e.getMessage(),e);
				str.append(e.toString());
			}
			st = str.toString();
		} catch (IOException es) {
			logger.error(es.getMessage(),es);
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
			logger.error(e.getMessage(),e);
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
			logger.error("创建目录操作出错！",e);
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
	public static void createFile(String filePathAndName, String fileContent,boolean cover,String encoding) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath,cover);
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
			resultFile.close();
		} catch (Exception e) {
			logger.error("创建文件操作出错",e);
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
	public static void createFile(String filePathAndName, String fileContent,
			String encoding) {

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
			logger.error("创建文件操作出错",e);
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
				logger.info(filePathAndName + "<br>删除文件操作出错");
			}
		} catch (Exception e) {
			logger.error("创建文件操作出错",e);
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
			e.printStackTrace();
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
			logger.error("复制单个文件操作出错",e);
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
					FileOutputStream output = new FileOutputStream(newPath
							+ "/" + (temp.getName()).toString());
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
			logger.error("复制整个文件夹内容操作出错",e);
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
				e.printStackTrace();
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
		}else{
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
			e.printStackTrace();
		}
		return txt;
	}

	/**
	 *
	 * @param string
	 * @param hasSymbol
	 * @throws IOException
	 */
	public static void WriteFile(String filename, String content,boolean cover,String encoding) throws IOException {
		writeStringToFile(filename, content, encoding, cover);
	}

	/**
	 *
	 * @param string
	 * @param encoding
	 * @return
	 */
	public static List<String> ReadFileToListForString(String filename, String encoding) {
		List<String> array = new ArrayList<String>();
		FileIsExist(filename);
		try {
			FileInputStream fs = new FileInputStream(filename);
			InputStreamReader isr = new InputStreamReader(fs, encoding);
			br2 = new BufferedReader(isr);
			String data = "";
			while ((data = br2.readLine()) != null) {
                array.add(data);
            }

        }catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return array;
	}

	/**
	 * 在文件中追加文件
	 * @param filename
	 * @param content
//
	 * @throws IOException */
//	public static void FileAdd(String filename, String content) {
//		FileIsExist(filename);
//		BufferedWriter out = null;
//		Writer write=null;
//		OutputStream outs=null;
//		   try {
//			outs=new FileOutputStream(filename, true);
//			write=new OutputStreamWriter(outs);
//		    out = new BufferedWriter(write);
//		    out.write(content);
//		    out.write("\r\n");
//		   } catch (Exception e) {
//		    e.printStackTrace();
//		   } finally {
//		    try {
//		    	if(out != null){
//		    		out.close();
//		    	}
//		    	if(outs!=null){
//		    		outs.close();
//		    	}
//		    	if(write!=null){
//		    		write.close();
//		    	}
//		    } catch (IOException e) {
//		     e.printStackTrace();
//		    }
//		   }
//	}


	public static boolean writeStringToFile(String fileName,String content,String enc,boolean cover) throws IOException {
		File file = new File(fileName);
		OutputStreamWriter os = null;
		try {
			if(enc==null||enc.length()==0){
				os = new OutputStreamWriter(new FileOutputStream(file,cover));
			}else{
				os = new OutputStreamWriter(new FileOutputStream(file,cover),enc);
			}
			os.write(content);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			if(os!=null){
			os.close();
			}
		}
		return true;
	}

//	public static List<String> checkRepeat(String filename,String encoding){
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
//				if(!array.contains(data) && !data.equals("")){
//					array.add(data);
//				}
//
//            }
//
//        }catch (NumberFormatException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally{
//			try {
//			if(br!=null){
//
//					br.close();
//
//			}
//			if(isr!=null){
//				isr.close();
//			}
//			if(fs!=null){
//				fs.close();
//			}} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return array;
//
//	}

	private static List<String> list=new ArrayList<String>();

	private static BufferedReader br;

	private FileOutputStream fs;

	private static BufferedReader br2;
	public static void main(String[] args) {
		String str="C:/Users/zqkj/Desktop/所有群成员号12月";

		File file=new File(str);

		tempReadFile(file, "GBK");

		System.out.println(list.size());
		int j=0;
		for (String s : list) {
			s=s.replace("(", "");
			s=s.replace(")", "");
//			System.out.println(s);
			if(isNumeric(s)){
//				WriteFile("d://qqmail-12.txt", s+"@qq.com,", true, "gbk");
			}	else{
				j++;
			}
		}
		System.out.println(j);
//		String city="%E5%B8%B8%E5%B7%9E%E5%B8%82";
//
//		System.out.println(URLDecoder.decode(city));
	}


	public static boolean isNumeric(String str){
	     Pattern pattern = Pattern.compile("[0-9]*");
	     return pattern.matcher(str).matches();
	}


	public static void tempReadFile(File file,String encoding){

		if(file.isDirectory()){
			 File[] flist=file.listFiles();
			 for (File file2 : flist) {
				 tempReadFile(file2,encoding);
			}
		}else{
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
					while ((data = br.readLine()) != null ) {
						if(data.contains("(")){
							if(!list.contains(data)){
								list.add(data);
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (IOException es) {
				es.printStackTrace();
			}
		}
	}
}
