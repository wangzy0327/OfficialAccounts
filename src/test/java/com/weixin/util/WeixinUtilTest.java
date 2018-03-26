package com.weixin.util;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import static org.junit.Assert.*;

public class WeixinUtilTest {
    @Test
    public void getSignature() throws Exception {
        String jsapi_ticket = "sM4AOVdWfPE4DxkXGEs8VMCPGGVi4C3VM0P37wVUCFvkVAy_90u5h9nbSlYy3-Sl-HhTdfl2fzFy1AOcHKP7qg";
        String nonceStr = "Wm3WZYTPz0wzccnW";
        String timestamp = "1414587457";
        String url = "http://mp.weixin.qq.com?params=value";
        String signature = "";
        // 注意这里参数名必须全部小写，且必须有序
        String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonceStr+ "&timestamp=" + timestamp + "&url=" + url;
        System.out.println("jsapi_ticket = "+jsapi_ticket);
        System.out.println("noncestr = "+nonceStr);
        System.out.println("timestamp = "+timestamp);
        System.out.println("url = "+url);
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(sign.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("signature:"+signature);
    }
    /**
     * 方法名：byteToHex</br>
     * 详述：字符串加密辅助方法 </br>
     * @param hash
     * @return 说明返回值含义
     */
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;

    }

}