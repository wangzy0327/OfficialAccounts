package com.weixin.service;

import com.weixin.message.resp.*;
import com.weixin.util.MenuUtil;
import com.weixin.util.MessageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MenuService {
    /**
     * 处理微信菜单发来的请求
     *
     * @param requestMap
     * @return xml
     */
    public static String processRequest(Map<String, String> requestMap) {
        // xml格式的消息数据
        String respXml = null;
        // 默认返回的文本消息内容
        String respContent = "未知的消息类型！";
        // 发送方帐号
        String fromUserName = requestMap.get("FromUserName");
        // 开发者微信号
        String toUserName = requestMap.get("ToUserName");
        //事件类型
        String event = requestMap.get("Event");
        //事件key值
        String eventKey = requestMap.get("EventKey");
        // 消息类型
        String msgType = requestMap.get("MsgType");

        // TODO 处理菜单点击事件
        if(eventKey.equals(MenuUtil.KEY_TEXT_RECOMMEND)){
            String title = "大辣娇--加1元再来1桶";
            String description = "我的青春\t我来定义\n";
            String picUrl = "http://wangzy.tunnel.qydev.com/OfficialAccounts/img/neUzquH.jpg";
            String url = "http://wangzy.tunnel.qydev.com/OfficialAccounts/neUzquH.html";
            Article article = MessageUtil.getArticle(title,description,picUrl,url);
            List<Article> list = new ArrayList<Article>();
            list.add(article);
            NewsMessage newsMessage = MessageUtil.getNewsMessage(fromUserName,toUserName,list);
            respXml = MessageUtil.messageToXml(newsMessage);
            return respXml;
        }else if(eventKey.equals(MenuUtil.KEY_MUSIC_RECOMMEND)){
//            Music music1 = new Music("See You Again","电影《速度与激情7》原声专辑","http://wangzy.tunnel.qydev.com/audio/See_You_Again.mp3","http://wangzy.tunnel.qydev.com/audio/See_You_Again.mp3","UkiEqDoyNZucWQq2NUajSBbDfhS-zMLFLSovXh34lLzO701gKrXYTUMEg1mW7aKA");
            Music music2 = new Music("铁血丹心","射雕英雄传主题曲","http://wangzy.tunnel.qydev.com/OfficialAccounts/audio/罗文,甄妮 - 世间始终你好.mp3","http://wangzy.tunnel.qydev.com/OfficialAccounts/audio/罗文,甄妮 - 世间始终你好.mp3","UkiEqDoyNZucWQq2NUajSBbDfhS-zMLFLSovXh34lLzO701gKrXYTUMEg1mW7aKA");
            MusicMessage musicMessage = MessageUtil.getMusicMessage(fromUserName,toUserName,music2);
            respXml = MessageUtil.messageToXml(musicMessage);
            System.out.println(respXml);
            return respXml;
        }else if(eventKey.equals(MenuUtil.KEY_INTRODUCTION)){
            String content = "每日推荐里有  好文推送 和 音乐欣赏\n" +
                    "回复消息可以返回消息类型\n" +
                    "消息类型有:文本消息、图片消息、地理位置消息、语音消息等\n";
            TextMessage textMessage = MessageUtil.getTextMessage(fromUserName,toUserName,content);
            respXml = MessageUtil.messageToXml(textMessage);
            return respXml;
        }
        return respXml;
    }
}
