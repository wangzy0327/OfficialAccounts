package com.weixin.util;

import java.io.UnsupportedEncodingException;

public class TestURL {

    /**
     * URL编码（utf-8）
     *
     * @param source
     * @return
     */
    public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 方法名：main</br>
     * 详述：生成URL编码 </br>
     * @param args 说明返回值含义
     */
//    public static void main(String[] args) {
//        String source="https://20e2b18746.iask.in/oauthServlet";
//        System.out.println(CommonUtil.urlEncodeUTF8(source));
//    }
}
