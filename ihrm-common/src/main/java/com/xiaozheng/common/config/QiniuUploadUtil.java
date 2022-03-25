package com.xiaozheng.common.config;

import com.alibaba.fastjson.JSON;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

/**
 * What -- 七牛云配置文件
 * <br>
 * Describe --
 * <br>
 *
 * @author 小政同学    QQ:xiaozheng666888@qq.com
 * @ClassName MybatisPlusConfig
 * @CreateTime 2022/03/25 1:22
 */
public class QiniuUploadUtil {

    private static final String accessKey = "COuoDRVa7JLsuurzIvQSI_pEDceHDw3yGfJEmvwv";
    private static final String secretKey = "3RWpTjB5Jxg3QosUFr4mxbHXJ5JR2m6AHQqYsSlr";
    private static final String bucket = "ihrm-bucket";
    private static final String prix = "http://pkbivgfrm.bkt.clouddn.com/";
    private UploadManager manager;

    public QiniuUploadUtil() {
        //初始化基本配置
        Configuration cfg = new Configuration(Zone.zone0());
        //创建上传管理器
        manager = new UploadManager(cfg);
    }

	//文件名 = key
	//文件的byte数组
    public String upload(String imgName , byte [] bytes) {
        Auth auth = Auth.create(accessKey, secretKey);
        //构造覆盖上传token
        String upToken = auth.uploadToken(bucket,imgName);
        try {
            Response response = manager.put(bytes, imgName, upToken);
            DefaultPutRet putRet = JSON.parseObject(response.bodyString(), DefaultPutRet.class);
            //返回请求地址
            return prix+putRet.key+"?t="+System.currentTimeMillis();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}