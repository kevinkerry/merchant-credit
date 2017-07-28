package com.sdp.mc.ma.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 文件操作
 * @author easy
 *
 */
public class FileUtils {
	
    /**
     * 创建一个空文件
     * @param file	文件
     * @param data	要写入的文本
     * @param encode	文本编码
     * @throws IOException
     */
    public static void writeFile(File file,String data,String encode) throws IOException{
		if(file.isDirectory())
			throw new IllegalArgumentException("must be file!");    	
    	if(!file.getParentFile().exists())
    		file.getParentFile().mkdirs();
    	FileOutputStream fos = null;
    	try{
    		fos = new FileOutputStream(file);
    		if(data!=null)
    			fos.write(data.getBytes(encode));
    	}finally{
    		if(fos!=null)
    			fos.close();
    	}
    }
    
    /**
     * 创建一个空文件
     * @param file	文件
     * @param data	要写入的数据
     * @throws IOException
     */
    public static void writeFile(File file,byte[] data) throws IOException{
		if(file.isDirectory())
			throw new IllegalArgumentException("must be file!");    	
    	if(!file.getParentFile().exists())
    		file.getParentFile().mkdirs();
    	FileOutputStream fos = null;
    	try{
    		fos = new FileOutputStream(file);
    		if(data!=null)
    			fos.write(data);
    	}finally{
    		if(fos!=null)
    			fos.close();
    	}
    } 	
    
    /**
     * 写入文件
     * @param file	文件
     * @param is	输入流
     * @throws IOException
     */
    public static void writeFile(File file,InputStream is) throws IOException{
		if(file.isDirectory())
			throw new IllegalArgumentException("must be file!");    	
    	if(!file.getParentFile().exists())
    		file.getParentFile().mkdirs();

    	FileOutputStream fos = null;
    	try {
    		if(!file.getParentFile().exists())
    			file.getParentFile().mkdirs();    		
			fos = new FileOutputStream(file);
			if(is!=null){
				int bytesRead;
				byte[] buffer = new byte[1024];
				while ((bytesRead = is.read(buffer)) != -1) {
					fos.write(buffer, 0, bytesRead);
				}
			}
		}finally{
			if(fos!=null)
				fos.close();
		}
    }
    
    /**
     * 以行写入的方式，一行行写入文件
     * @param file	文件
     * @param data	文件内容
     * @throws IOException
     */
    public static void writeLineFile(File file,String[] data) throws IOException{
    	writeLineFile(file,data,null);
    }
    /**
     * 以行写入的方式，一行行写入文件
     * @param file	文件
     * @param data	文件内容
     * @param encode	文件编码
     * @throws IOException
     */
    public static void writeLineFile(File file,String[] data,String encode) throws IOException{
		if(file.isDirectory())
			throw new IllegalArgumentException("must be file!");      	
		PrintWriter writer = null;
		OutputStreamWriter osw = null;
		try {
			if(!file.getParentFile().exists())
				file.getParentFile().mkdirs();			
			if(encode==null)
				osw = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
			else
				osw = new OutputStreamWriter(new FileOutputStream(file),encode);
			writer = new PrintWriter(osw);
			if(data!=null){
				for(String line:data){
					writer.println(line);
				}
			}
		}finally{
			if(osw!=null)
				osw.close();
			if(writer!=null)
				writer.close();
		}	    	
    }
    
    /**
     * 以行读的方式，一行行的读出文件
     * @param file	文件
     * @param encode	文件编码
     * @return	文件内容
     * @throws IOException
     */
    public static String[] readLineFile(File file) throws IOException{
    	return readLineFile(file,null,1);
    }
    
    /**
     * 以行读的方式，一行行的读出文件
     * @param file	文件
     * @param encode	文件编码
     * @return	文件内容
     * @throws IOException
     */
    public static String[] readLineFile(File file,String encode) throws IOException{
    	return readLineFile(file,encode,1);
    }
    
    /**
     * 以行读的方式，一行行的读出文件
     * @param file	文件
     * @param encode	文件编码
     * @param start 起始行号
     * @return	文件内容
     * @throws IOException
     */
    public static String[] readLineFile(File file,String encode,int start) throws IOException{
    	return readLineFile(file,encode,1,0);
    }
    
    /**
     * 以行读的方式，一行行的读出文件
     * @param file	文件
     * @param encode	文件编码
     * @param start 起始行号
     * @param max 最大行数
     * @return	文件内容
     * @throws IOException
     */
    public static String[] readLineFile(File file,String encode,int start,int max) throws IOException{
		if(file.isDirectory())
			throw new IllegalArgumentException("must be file!");      	
		FileInputStream fin = null;
		InputStreamReader isr = null;
		LineNumberReader lnr = null;
		try{
			fin = new FileInputStream(file);
			if(encode==null)
				isr = new InputStreamReader(fin);
			else
				isr = new InputStreamReader(fin,encode);
			lnr = new LineNumberReader(isr);
			String line = null;
			List<String> dataList = new ArrayList<String>();
			int index = 0;
			while((line=lnr.readLine())!=null){
				index++;
				if(index>=start)
					dataList.add(line);
				if(max>0 && dataList.size()>=max)
					break;
			}
			if(dataList.size()==0)
				return null;
			else
				return dataList.toArray(new String[dataList.size()]);
		}finally{
			if(lnr!=null)
				lnr.close();
			if(isr!=null)
				isr.close();
			if(fin!=null)
				fin.close();
		}
    }
    /**
     * 以字节流读取文件内容
     * @param file	文件
     * @return	文件内容（字节方式）
     * @throws IOException
     */
    public static byte[] readFile(File file) throws IOException{ 	
    	if(file.exists()){
    		if(file.isDirectory())
    			throw new IllegalArgumentException("must be file!");      		
    		FileInputStream fis = null;
    		ByteArrayOutputStream bos = null;
    		try{
    			fis = new FileInputStream(file);
    			bos = new ByteArrayOutputStream();
				byte[] buffer = new byte[1024];
				int bytesRead = 0;
				while ((bytesRead = fis.read(buffer)) != -1) {
					bos.write(buffer, 0, bytesRead);
				}
				return bos.toByteArray();
    		}finally{
    			if(bos!=null)
    				bos.close();
    			if(fis!=null)
    				fis.close();
    		}
    	}else
    		return null;
    }
    
    /**
     * 以某编码读取文件的内容
     * @param file	文件
     * @param encode	文本编码
     * @return
     * @throws IOException
     */
    public static String readFile(File file,String encode) throws IOException{
    	byte[] data = readFile(file);
    	if(data==null)
    		return null;
    	else
    		return new String(data,encode);
    }
    
    /**
     * 创建一个空文件
     * @param filePath
     * @return true：文件不存在并且成功 false：文件己存在
     * @throws IOException
     */
    public static boolean createFile(String filePath) throws IOException{
    	File file = new File(filePath);
    	if(!file.getParentFile().exists())
    		file.getParentFile().mkdirs();
		return file.createNewFile();
    }    
    
    /**
     * 将指定名称的文件从源目录移动到目标目录
     * @param name 文件名
     * @param srcFolder	源目录
     * @param destFolder	目标目录
     * @throws IOException
     */
	public static void moveFile(String name,String srcFolder,String destFolder) throws IOException{
		moveFile(name,new File(srcFolder),new File(destFolder));
	}

    /**
     * 将指定名称的文件从源目录移动到目标目录
     * @param name 文件名
     * @param srcFolder	源目录
     * @param destFolder	目标目录
     * @throws IOException
     */
	public static void moveFile(String name,File srcFolder,File destFolder) throws IOException{
		if(srcFolder.isFile())
			throw new IllegalArgumentException("source folder must be folder!");
		if(destFolder.isFile())
			throw new IllegalArgumentException("destination folder must be folder!");			
		copyFile(name,srcFolder,destFolder);
		File srcFile = new File(srcFolder,name);
		srcFile.delete();
	}
	
	/**
	 * 移动文件
	 * @param srcFile 源文件
	 * @param destFile	目标文件
	 * @throws IOException
	 */
	public static void moveFile(String srcFile,String destFile) throws IOException{
		moveFile(new File(srcFile),new File(destFile));
	}
	
	/**
	 * 移动文件
	 * @param srcFile 源文件
	 * @param destFile	目标文件
	 * @throws IOException
	 */
	public static void moveFile(File srcFile,File destFile) throws IOException{
		if(srcFile.isDirectory())
			throw new IllegalArgumentException("source file must be file!");
		if(destFile.isDirectory())
			throw new IllegalArgumentException("destination file must be file!");				
		copyFile(srcFile,destFile);
		srcFile.delete();
	}
	
	/**
	 * 将指定名称的文件从源目录复制到目标目录
	 * @param name	文件名
	 * @param srcFolder	源路径
	 * @param destFolder	目标路径
	 * @throws IOException
	 */
	public static void copyFile(String name,String srcFolder,String destFolder) throws IOException{
		copyFile(name,new File(srcFolder),new File(destFolder));
	}
	
	/**
	 * 将指定名称的文件从源目录复制到目标目录
	 * @param name	文件名
	 * @param srcFolder	源路径
	 * @param destFolder	目标路径
	 * @throws IOException
	 */
	public static void copyFile(String name,File srcFolder,File destFolder) throws IOException{
		if(srcFolder.isFile())
			throw new IllegalArgumentException("source folder must be folder!");
		if(destFolder.isFile())
			throw new IllegalArgumentException("destination folder must be folder!");		
		
		copyFile(new File(srcFolder,name),new File(destFolder,name));
	}
	
	/**
	 * 复制文件
	 * @param srcFile	源文件
	 * @param destFile	目标文件
	 * @throws IOException
	 */
	public static void copyFile(String srcFile,String destFile) throws IOException{
		copyFile(new File(srcFile),new File(destFile));
	}
	
	/**
	 * 复制文件
	 * @param srcFile	源文件
	 * @param destFile	目标文件
	 * @throws IOException
	 */
	public static void copyFile(File srcFile,File destFile) throws IOException{
		if(srcFile.isDirectory())
			throw new IllegalArgumentException("source file must be file!");
		if(destFile.isDirectory())
			throw new IllegalArgumentException("destination file must be file!");		
		if(srcFile.exists()){
			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			FileInputStream fin = null;
			FileOutputStream fout = null;
			try{
				fin = new FileInputStream(srcFile);
				if(!destFile.getParentFile().exists())
					destFile.getParentFile().mkdirs();					
				fout=new FileOutputStream(destFile);
				while ((bytesRead = fin.read(buffer)) != -1) {
					fout.write(buffer, 0, bytesRead);
				}		
			}finally{
				if(fin!=null)
					fin.close();
				if(fout!=null)
					fout.close();					
			}
		}	
	}
	
	/**
	 * 将源目录中的所有文件复制到目标目录中
	 * @param srcfolder	源目录
	 * @param dstFolder	目标目录
	 * @throws IOException
	 */
	public static void copyFolder(File srcFolder,File destFolder) throws IOException{
		if(srcFolder.isFile())
			throw new IllegalArgumentException("source folder must be folder!");
		if(destFolder.isFile())
			throw new IllegalArgumentException("destination folder must be folder!");
		
		File[] files = srcFolder.listFiles();
		for(int i=0;files!=null && i<files.length;i++){
			if(files[i].isFile()){
				//复制文件
				copyFile(files[i].getName(),files[i].getParentFile(),destFolder);
			}else{
				//复制目录
				copyFolder(files[i],new File(destFolder,files[i].getName()));
			}
		}
	}
	
	/**
	 * 查询目录中指定后缀名称的文件
	 * @param folder	目录
	 * @param suffixes	后缀名，不指定则返回所有文件
	 * @return	文件数组
	 */
	public static File[] seekFile(File folder,String[] suffixes){
		List<File> fileList = new ArrayList<File>();
		seekFile(folder,suffixes,fileList);
		if(fileList.size()==0)
			return null;
		else
			return fileList.toArray(new File[fileList.size()]);
	}
	
	/**
	 * 查询目录中指定后缀名称的文件
	 * @param folder	目录
	 * @param suffixes	后缀名，不指定则返回所有文件
	 * @param fileList	查找到的文件列表
	 * @return
	 */	
	public static void seekFile(File folder,String[] suffixes,List<File> fileList){
		if(folder.isFile())
			throw new IllegalArgumentException("must be folder!");		
		File[] files = folder.listFiles();
		for(int i=0;files!=null && i<files.length;i++){
			if(files[i].isDirectory()){
				seekFile(files[i],suffixes,fileList);
			}else{
				if(suffixes==null)
					fileList.add(files[i]);
				else{
					for(String suffix:suffixes){
						if(suffix!=null && suffix.length()>0 && files[i].getName().toLowerCase().endsWith(suffix.toLowerCase())){
							fileList.add(files[i]);
							break;
						}
					}
				}
			}
		}
	}
	
	/**
	 * 删除目录或文件，如果目录中包含子目录一起删除
	 * @param path
	 */
	public static void delete(String path){
		File file=new File(path);
		
		delete(file);
	}
	/**
	 * 删除目录或文件，如果目录中包含子目录一起删除
	 * @param path
	 */
	public static void delete(File file){
		if(!file.exists())
			return;
		if(file.isFile()){
			file.delete();
		}else{
			File[] fl=file.listFiles();
			for(int i=0;fl!=null && i<fl.length;i++){
				delete(fl[i]);
			}
			file.delete();
		}		
	}
	
	/**
	 * 删除所有子目录，不包含指定目录
	 * @param file
	 */
	public static void deleteChildFolder(File folder){
		if(folder.isFile())
			throw new IllegalArgumentException("must be folder!");
		
		File[] files = folder.listFiles();
		for(int i=0;files!=null && i<files.length;i++){
			delete(files[i]);
		}
	}
    
	/**
	 * 删除所有空的子目录，不包括自己本身
	 * @param file		指定的目录
	 * @param seconds	删除创建时间在多少秒以前的空目录
	 */
	public static void deleteEmptyChildFolder(File file,int seconds){
		if(file.isDirectory()){
			File files[] = file.listFiles();
			for(int i=0;files!=null && i<files.length;i++){
				if(files[i].isDirectory()){
					if(Calendar.getInstance().getTime().getTime()-seconds*1000>files[i].lastModified())
						deleteEmptyFolder(files[i]);
				}
			}
		}
	}	
	
	/**
	 * 删除目录中所有的空目录，不包括指定目录
	 * @param file
	 */
	public static void deleteAllEmptyChildFolder(File file){
		deleteEmptyChildFolder(file,0);
	}		
	
	/**
	 * 删除目录下空目录
	 * @param file	要删除的目录
	 */
	private static boolean deleteEmptyFolder(File file){
		int num=0;
		File[] fl=file.listFiles();
		for(int i=0;fl!=null && i<fl.length;i++){
			if(fl[i].isFile()){
				num++;
			}else{
				if(!deleteEmptyFolder(fl[i]))
					num++;
			}
		}
		if(num==0){
			file.delete();
			return true;
		}
		return false;
	}	
}
