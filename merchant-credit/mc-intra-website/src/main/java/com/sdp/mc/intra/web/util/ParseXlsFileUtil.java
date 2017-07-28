package com.sdp.mc.intra.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;import org.slf4j.LoggerFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 解析CVS
 * @author liyantao
 *
 */
public class ParseXlsFileUtil {
	private static Logger logger = LoggerFactory.getLogger(ParseXlsFileUtil.class);
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
	public static List<String[]> readXlsFile(File file, String encoding) {
		if(file == null){
			logger.info("ParseXlsFileUtil.readXlsFile.file is null");
			return null;
		}
		InputStream stream = null;
		Workbook wb = null;
//		String type = file.getName().substring(file.getName().lastIndexOf(".") + 1);
		List<String[]> list = new ArrayList<String[]>();
		try{
		stream = new FileInputStream(file);
//		if ("xls".equals(type)) { // 2003
			wb = new HSSFWorkbook(stream);
//		}  else {
//			return null;
//		}
		Sheet sheet1 = wb.getSheetAt(0);
		for (Row row : sheet1) {
			// TODO:是否跳过首行
			Iterator<Cell> cells = row.cellIterator(); // 获得第一行的迭代器
			int cellNum=row.getLastCellNum();
			String[] arr=new String[cellNum];
			int i=0;
			while (cells.hasNext()) {
				Cell cell = cells.next();
				if(cell.getCellType()==Cell.CELL_TYPE_STRING){
				    arr[i]=cell.getStringCellValue();
				}else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
					arr[i]=cell.getNumericCellValue() + "";
				}
				i++;
				/*if (cell.getColumnIndex() == 0) {
					quotaVO.setQuotaDate(cell.getStringCellValue());
				} else if (cell.getColumnIndex() == 1) {
					quotaVO.setAmountStr(cell.getNumericCellValue() + "");
				}
				continue;*/
			}
			list.add(arr);
		}
		} catch (FileNotFoundException e) {
			logger.error("ParseXlsFileUtil.readXlsFile.FileNotFoundException",e);
		} catch (IOException e) {
			logger.error("ParseXlsFileUtil.readXlsFile.IOException",e);
		} finally {
			if (null != stream) {
				try {
					stream.close();
				} catch (IOException e) {
					logger.error("ParseXlsFileUtil.readXlsFile.finally.IOException",e);
				}
			}
		}

		return list;
	}


	    public static void main(String[] args)
	    {
	        String argPath = "E:/limittrialTemplate.xls";
			File file = new File(argPath);
			List<String[]> list= readXlsFile(file, "gbk");
			System.out.println(list);
	    }
}