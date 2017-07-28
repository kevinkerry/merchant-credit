package com.shengpay.mcl.btc.util;

import com.sdo.common.lang.StringUtil;

/**
 * <p>文件摘要算法</p>
 * @author Eric.fu
 * @version $Id: FileDigestAlgorithm.java, v 0.1 2012-4-15 下午01:48:07 fuyangbiao Exp $
 */
public enum FileDigestAlgorithm {
    MD5,

    SHA,

    RSA,

    DES;

    /**
     * 根据代码获取ENUM
     * @param code
     * @return
     */
    public static FileDigestAlgorithm getByCode(String code) {
        if (StringUtil.isBlank(code)) {
            return null;
        }

        for (FileDigestAlgorithm param : FileDigestAlgorithm.values()) {
            if (param.name().equals(code.toUpperCase())) {
                return param;
            }
        }

        return null;
    }
}
