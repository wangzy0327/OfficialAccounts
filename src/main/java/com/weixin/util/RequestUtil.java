package com.weixin.util;

import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RequestUtil {
    private static Logger log = LoggerFactory.getLogger(RequestUtil.class);

    /**
     * 解析request的输入流
     * @param request
     * @return 请求的json字符串
     */
    public static synchronized String getRequestBody(HttpServletRequest request) {
        String str = null;
        try {
            str = IOUtils.toString(request.getInputStream());
        } catch (IOException e) {
            log.info(e.getMessage());
            log.error("输入输出异常：{}", e);
            e.printStackTrace();
        }
        return str;
    }



    /**
     * 解析request的json数据
     * @param request
     * @return Map
     */
    public static synchronized Map<String, Object> parseRequest(
            HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>() ;
        try {
            String req = getRequestBody(request);
            if(StringUtils.isNotBlank(req)){
                JSONObject jsonObject = JSONObject.fromObject(req);
                for (Iterator iter = jsonObject.keys(); iter.hasNext();) {
                    String key = (String) iter.next();
                    map.put(key, jsonObject.get(key));
                }
            }
            log.info(map.toString());

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
            log.error("异常：{}", e);
        }
        return map;
    }




    /**
     * 获取map的value
     * @param map
     * @param key
     * @return
     */
    public static Object getRequestBodyValue(
            Map<String, Object> map, String key) {
        if (map != null && StringUtils.isNotBlank(key) && map.containsKey(key)) {
            return map.get(key);
        }
        return null;
    }
}
