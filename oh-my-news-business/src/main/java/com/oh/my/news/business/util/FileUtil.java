package com.oh.my.news.business.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

/**
 * Created by shj on 2017/4/13.
 */
@Component
public class FileUtil {

    private static final int max_loop = 1000000;
    private static int index = 0;
    @Value("${endpoint}")
    private String endpoint;
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;
    @Value("${bucketName}")
    private String bucketName;
    private static final Date expiration = new Date(new Date().getTime() + 2*3600l * 1000 * 24 * 365 * 10);
    private OSSClient ossClient;

    @PostConstruct
    public void init(){
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }




    private static synchronized String getKey(){
        return System.currentTimeMillis()+ "_" + String.valueOf(++index%max_loop);
    }

    public com.oh.my.news.model.po.File fileUpload(InputStream in)throws Exception{
        ObjectMetadata objectMetadata = new ObjectMetadata();
        String key = getKey();
        ossClient.putObject(this.bucketName,key,in);
        URL url = ossClient.generatePresignedUrl(bucketName,key,expiration);
        if(url!=null){
            return new com.oh.my.news.model.po.File(0,key,url.toString());
        }
        return null;
    }

}
