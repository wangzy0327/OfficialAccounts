package com.weixin.util;

import com.weixin.menu.Button;
import com.weixin.menu.CommonButton;
import com.weixin.menu.ComplexButton;
import com.weixin.menu.Menu;
import com.weixin.pojo.Token;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class MenuUtilTest {
    private static Logger log = LoggerFactory.getLogger(MenuUtil.class);

    public static final String KEY_RECOMMEND = "recommend";
    public static final String KEY_TEXT_RECOMMEND = "text_recommend";
    public static final String KEY_MUSIC_RECOMMEND = "music_recommend";
    public static final String KEY_FORECAST = "forecast";
    public static final String KEY_INTRODUCTION= "introduction";
    @Test
    public void createMenu() throws Exception {
        // 第三方用户唯一凭证
        String appId = "wx88ddca24ac18c8b8";
        // 第三方用户唯一凭证密钥
        String appSecret = "1c11b34596f06d6874dfa7b2439e5d0f";

        // 调用接口获取access_token
        Token token = CommonUtil.getToken(appId,appSecret);

        System.out.println("accessToken:"+token.getAccessToken());

        if (null != token) {
            // 调用接口创建菜单
            int result = CommonUtil.createMenu(getMenu(), token.getAccessToken());

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     *
     * @return
     */
    private static Menu getMenu() {
        CommonButton btn11 = new CommonButton();
        btn11.setName("好文推送");
        btn11.setType("click");
        btn11.setKey(MenuUtil.KEY_TEXT_RECOMMEND);

        CommonButton btn12 = new CommonButton();
        btn12.setName("音乐推荐");
        btn12.setType("click");
        btn12.setKey(MenuUtil.KEY_MUSIC_RECOMMEND);

        /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */

        ComplexButton mainBtn1 = new ComplexButton();
        mainBtn1.setName("每日推荐");
        //一级下有2个子菜单
        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12});


        CommonButton mainBtn2 = new CommonButton();
        mainBtn2.setName("使用介绍");
        mainBtn2.setType("click");
        mainBtn2.setKey(MenuUtil.KEY_INTRODUCTION);


        CommonButton mainBtn3 = new CommonButton();
        mainBtn3.setName("天气预报");
        mainBtn3.setType("click");
        mainBtn3.setKey(MenuUtil.KEY_FORECAST);

        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });

        return menu;
    }

}