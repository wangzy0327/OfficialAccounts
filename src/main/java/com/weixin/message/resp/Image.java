package com.weixin.message.resp;

/**
 * 类名: Image </br>
 * 描述: 图片 </br>
 * 发布版本：V1.0  </br>
 */
public class Image {
    private String MediaId;

    public Image(String mediaId) {
        MediaId = mediaId;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
