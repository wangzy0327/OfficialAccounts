package com.weixin.util;

import com.weixin.pojo.WeixinUserInfo;
import com.weixin.thread.TokenThread;
import org.junit.Test;

import java.sql.SQLException;

import static com.weixin.util.CommonUtil.getUserInfo;


public class CommonUtilTest {
    /**
     * 方法名：testgetConnection</br>
     * 详述：测试是否连接</br>
     *
     * @throws SQLException
     * @throws
     */
    @Test
    public void testgetConnection() throws SQLException {
        DBUtility db = new DBUtility();
        System.out.println(db.getConnection());
    }

    @Test
    public void testgetUserInfo() {
        // 获取接口访问凭证
//        String accessToken = TokenThread.accessToken.getAccessToken();
        String accessToken = CommonUtil.getToken("wx88ddca24ac18c8b8", "1c11b34596f06d6874dfa7b2439e5d0f").getAccessToken();
//        System.out.println(accessToken);
        /**
         * 获取用户信息
         */
        WeixinUserInfo user = CommonUtil.getUserInfo(accessToken, "ohIIkv2yQrt-o1QVnf5U1V2HgUQI");
        System.out.println("OpenID：" + user.getOpenId());
        System.out.println("关注状态：" + user.getSubscribe());
        System.out.println("关注时间：" + user.getSubscribeTime());
        System.out.println("昵称：" + user.getNickname());
        System.out.println("性别：" + user.getSex());
        System.out.println("国家：" + user.getCountry());
        System.out.println("省份：" + user.getProvince());
        System.out.println("城市：" + user.getCity());
        System.out.println("语言：" + user.getLanguage());
        System.out.println("头像：" + user.getHeadImgUrl());
    }
}