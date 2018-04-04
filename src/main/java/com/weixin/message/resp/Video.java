package com.weixin.message.resp;

/**
 * 类名: Video </br>
 * 描述: 视频model </br>
 * 发布版本：V1.0  </br>
 */
public class Video {
    public Video(String mediaId, String thumbMediaId) {
        MediaId = mediaId;
        ThumbMediaId = thumbMediaId;
    }

    // 媒体文件id
    private String MediaId;
    // 缩略图的媒体id
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
}
