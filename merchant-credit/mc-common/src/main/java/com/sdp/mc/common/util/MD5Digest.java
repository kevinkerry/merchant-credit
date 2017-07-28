/**
 *
 */
package com.sdp.mc.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Digest {

    /**
    * MD5加密字符串，返回加密后的16进制字符串
    * @param text
    * @return
    */
    public static String getDigestString(String text) {
        return toHexString(getDigest(text, "UTF-8"));
    }

    public static String getDigestString(String text, String encoding) {
        return toHexString(getDigest(text, encoding));
    }

    /**
    * MD5加密字符串，返回加密后的字节数组
    * @param text
    * @return
    */
    public static byte[] getDigest(String text, String encoding) {
        try {
            return getDigest(text.getBytes(encoding));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
    * MD5加密字节数组，返回加密后的字节数组
    * @param bytes
    * @return
    */
    public static byte[] getDigest(byte[] bytes) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            return md.digest(bytes);
        } catch (NoSuchAlgorithmException e) {
            return new byte[0];
        }
    }

    public static String toHexString(byte[] b) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < b.length; ++i) {
            buffer.append(toHexString(b[i]));
        }
        return buffer.toString();
    }

    private static String toHexString(byte b) {
        char[] buffer = new char[2];
        buffer[0] = Character.forDigit((b >>> 4) & 0x0F, 16);
        buffer[1] = Character.forDigit(b & 0x0F, 16);
        return new String(buffer);
    }
    public static final String SIGN_ALGORITHMS = "MD5";

    /**
     * 使用{@code MD5}方式对字符串进行签名
     *
     * @param text 需要加签名的数据
     * @param key 对需要签名的的数据进行加盐
     * @param charset 数据的编码方式
     * @return 返回签名信息
     */
    public static String sign(String text, String key, String charset) {
        String message = text + key;

        MessageDigest digest = getDigest(SIGN_ALGORITHMS);
        digest.update(StringUtil.getContentBytes(message, charset));

        byte[] signed = digest.digest();

        return HexUtils.toHexString(signed);
    }
    /**
     * 返回实现指定摘要算法的 {@code MessageDigest} 对象。
     *
     * @param algorithm 信息摘要算法名称
     *
     * @return 返回摘要算法对象
     */
    private static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        }
        catch (final NoSuchAlgorithmException ex) {
            throw new IllegalArgumentException("Not support:" + algorithm, ex);
        }
    }
    /**
     * 使用{@code MD5}方式对签名信息进行验证
     *
     * @param text 需要加签名的数据
     * @param sign 签名信息
     * @param key 对需要签名的的数据进行加盐
     * @param charset 数据的编码方式
     * @return 是否验证通过。{@code True}表示通过
     */
    public static boolean verify(String text, String sign, String key, String charset) {
        String mysign = sign(text, key, charset);

        if (mysign.equals(sign)) {
            return true;
        }
        else {
            return false;
        }
    }
}
