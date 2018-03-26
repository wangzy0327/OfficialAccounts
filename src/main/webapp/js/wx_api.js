$(function () {
    var url = location.href.split('#').toString();//url不能写死
    alert(url);
    console.log(url);
    $.ajax({
        type: "POST",
        url: "/signatureServlet",
        dataType: "json",
        async: false,
        data: JSON.stringify({"url": url}),
        success: function (data) {
            console.log(data.appId);
            wx.config({
                debug: true,////生产环境需要关闭debug模式
                appId: data.appId,//appId通过微信服务号后台查看
                timestamp: data.timestamp,//生成签名的时间戳
                nonceStr: data.nonceStr,//生成签名的随机字符串
                signature: data.signature,//签名
                jsApiList: [//需要调用的JS接口列表
//                        'checkJsApi',//判断当前客户端版本是否支持指定JS接口
                    'onMenuShareTimeline',//分享给好友
                    'onMenuShareAppMessage',//分享到朋友圈
                    'onMenuShareQQ',        //分享到QQ好友
                    'onMenuShareWeibo',     //分享到微博
                    'onMenuShareQZone'      //分享到QQ空间
                ]
            });
        },
        error: function (xhr, status, error) {
            //alert(status);
            //alert(xhr.responseText);
        }
    })

    wx.ready(function () {
        // 获取“分享到朋友圈”按钮点击状态及自定义分享内容接口
        wx.onMenuShareTimeline({
            title: '大辣椒', // 分享标题
            link: "http://wangzy.tunnel.qydev.com/neUzquH.html",
            imgUrl: "http://wangzy.tunnel.qydev.com/img/neUzquH.jpg" // 分享图标
        });
        // 获取“分享给朋友”按钮点击状态及自定义分享内容接口
        wx.onMenuShareAppMessage({
            title: '大辣椒', // 分享标题
            desc: "大辣椒--加一元再来一桶", // 分享描述
            link: "http://wangzy.tunnel.qydev.com/neUzquH.html",
            imgUrl: "http://wangzy.tunnel.qydev.com/img/neUzquH.jpg", // 分享图标
            type: 'link', // 分享类型,music、video或link，不填默认为link
        });

        //获取“分享到QQ”按钮点击状态及自定义分享内容接口
        wx.onMenuShareQQ({
            title: '大辣椒', // 分享标题
            desc: '大辣椒--加一元再来一桶', // 分享描述
            link: 'http://wangzy.tunnel.qydev.com/neUzquH.html', // 分享链接
            imgUrl: 'http://wangzy.tunnel.qydev.com/img/neUzquH.jpg', // 分享图标
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });

        //获取“分享到腾讯微博”按钮点击状态及自定义分享内容接口
        wx.onMenuShareWeibo({
            title: '大辣椒', // 分享标题
            desc: '大辣椒--加一元再来一桶', // 分享描述
            link: 'http://wangzy.tunnel.qydev.com/neUzquH.html', // 分享链接
            imgUrl: 'http://wangzy.tunnel.qydev.com/img/neUzquH.jpg', // 分享图标
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });

        //获取“分享到QQ空间”按钮点击状态及自定义分享内容接口
        wx.onMenuShareQZone({
            title: '大辣椒', // 分享标题
            desc: '大辣椒--加一元再来一桶', // 分享描述
            link: 'http://wangzy.tunnel.qydev.com/neUzquH.html', // 分享链接
            imgUrl: 'http://wangzy.tunnel.qydev.com/img/neUzquH.jpg', // 分享图标
            success: function () {
                // 用户确认分享后执行的回调函数
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
            }
        });
    });

});
//    // 微信信息的以及调用的配置
//    wx.config({
//        debug: true,
//        appId: '${appId}',
//        timestamp: '${timestamp}',
//        nonceStr: '${nonceStr}',
//        signature: '${signature}',
//        jsApiList: ['onMenuShareTimeline', 'onMenuShareAppMessage','onMenuShareQQ','onMenuShareWeibo','onMenuShareQZone']
//    });
// 微信信息的以及调用的配置
