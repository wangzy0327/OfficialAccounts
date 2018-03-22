package com.weixin.servlet;

import com.weixin.pojo.SNSUserInfo;
import com.weixin.pojo.WeixinOauth2Token;
import com.weixin.util.AdvancedUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 类名: OAuthServlet </br>
 * 描述: 授权后的回调请求处理 </br>
 * 发布版本：V1.0  </br>
 */
@WebServlet(name = "oauthServlet",urlPatterns = {"/oauthServlet"})
public class OAuthServlet extends HttpServlet {
    private static final long serialVersionUID = -1847238807216447030L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        System.out.println("code:"+code);
        System.out.println("state:"+state);

        // 用户同意授权
        if (!"authdeny".equals(code)) {
            // 获取网页授权access_token
            WeixinOauth2Token weixinOauth2Token = AdvancedUtil.getOauth2AccessToken("wx88ddca24ac18c8b8", "1c11b34596f06d6874dfa7b2439e5d0f", code);
            // 网页授权接口访问凭证
            String accessToken = weixinOauth2Token.getAccessToken();
            System.out.println("accessToken(网页授权):"+accessToken);
            // 用户标识
            String openId = weixinOauth2Token.getOpenId();
            // 获取用户信息
            SNSUserInfo snsUserInfo = AdvancedUtil.getSNSUserInfo(accessToken, openId);

            // 设置要传递的参数
            request.setAttribute("snsUserInfo", snsUserInfo);
            request.setAttribute("state", state);
        }
        // 跳转到index.jsp
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
