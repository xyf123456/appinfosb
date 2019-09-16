package com.bdqn.appinfosb.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ClassName: MD5Utils
 * create by:  xyf
 * description: TODO 加密的相关工具类
 * create time: 2019/9/16 22:16
 */
public class MDUtils {

    /**
     * description: TODO 64位MD5加密
     * create time: 2019/9/16 22:16
     * [str]
     * @return java.lang.String
     */
    public static String EncodedByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
//        加密字符串
        String newstr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
}
