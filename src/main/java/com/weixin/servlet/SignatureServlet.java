package com.weixin.servlet;

import com.weixin.service.CoreService;
import com.weixin.util.RequestUtil;
import com.weixin.util.SignUtil;
import com.weixin.util.WeixinUtil;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "signatureServlet", urlPatterns = {"/signatureServlet"})
public class SignatureServlet extends HttpServlet{
    /**
     * 确认请求来自微信服务器
     */

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
    }

    /**
     * 处理微信服务器发来的消息
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO 消息的接收、处理、响应
        // 消息的接收、处理、响应
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Map<String, Object> paramMap = RequestUtil.parseRequest(request);
        String url = (String) RequestUtil.getRequestBodyValue(paramMap,
                "url");
            //do something
        System.out.println("url:"+url);
        Map<String,Object> map = WeixinUtil.getWxConfig(request,url);

        // 响应消息

        PrintWriter out = response.getWriter();
        if (map!=null) {
            JSONObject jsonObject = JSONObject.fromObject(map); //将实体对象转换为JSON Object转换
            System.out.println(jsonObject.toString());
            out.print(jsonObject.toString());
            out.flush();
            out.close();
        }
    }

}
