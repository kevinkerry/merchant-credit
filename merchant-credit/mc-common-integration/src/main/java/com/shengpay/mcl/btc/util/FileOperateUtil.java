package com.shengpay.mcl.btc.util;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shengpay.mcl.btc.util.BasicConstants;
import com.shengpay.mcl.btc.util.FileDigestAlgorithm;

/**
 * <p>文件操作工具类</p>
 * @author Eric.fu
 * @version $Id: FileOperatorUtil.java, v 0.1 2012-3-9 下午02:58:30 fuyangbiao Exp $
 */
public class FileOperateUtil implements BasicConstants {
	private static Logger log = LoggerFactory.getLogger(FileOperateUtil.class);

    /**
     * 生成文件摘要
     * @param filePath
     * @param digest
     * @return
     */
    public static String generateFileDigest(String filePath, FileDigestAlgorithm digest) {
    	FileInputStream ins = null;
    	try {
            ins = new FileInputStream(filePath);
            switch (digest) {
                case MD5:
                    return String.valueOf(DigestUtils.md5Hex(ins));
                case SHA:
                    return String.valueOf(DigestUtils.shaHex(ins));
                default:
                    throw new IllegalArgumentException("摘要类型不支持");
            }
        } catch (Exception e) {
            throw new RuntimeException("生成文件摘要异常", e);
        }finally{
            
            // releases all system resources from the streams
            if(ins!=null)
            {
            	try {
					ins.close();
				} catch (IOException e) {
					log.error("FileOperateUtil.generateFileDigest.error", e);
				}
            }
         }
    }

}
