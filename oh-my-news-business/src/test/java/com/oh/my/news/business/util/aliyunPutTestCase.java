package com.oh.my.news.business.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.*;
import java.util.Date;

/**
 * Created by shj on 2017/4/13.
 */
public class aliyunPutTestCase {

    private static String endpoint = "oss-cn-shanghai.aliyuncs.com";
    private static String accessKeyId = "LTAImvg3z9iZRy2n";
    private static String accessKeySecret = "n6qQC6BK7OGXRCuuKYKxHzMe5HgcsQ";
    private static String bucketName = "oh-my-news";
    private static String key = "testFile";
    public static void main(String[] args) {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        System.out.println("Getting Started with OSS SDK for Java\n");
        System.out.println("Uploading a new object to OSS from a file\n");
        try {
            PutObjectResult putObjectResult = ossClient.putObject(new PutObjectRequest(bucketName, key, createSampleFile()));
            System.out.println(putObjectResult.getETag());
            System.out.println(putObjectResult.getClientCRC());
            System.out.println(putObjectResult.getRequestId());
            System.out.println(putObjectResult.getResponse());
            System.out.println(putObjectResult.getServerCRC());
            Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
            System.out.println(ossClient.generatePresignedUrl(bucketName,key,expiration));
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    private static File createSampleFile() throws IOException {
        File file = File.createTempFile("oss-java-sdk-", ".txt");
        file.deleteOnExit();

        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("0123456789011234567890\n");
        writer.close();

        return file;
    }
}
