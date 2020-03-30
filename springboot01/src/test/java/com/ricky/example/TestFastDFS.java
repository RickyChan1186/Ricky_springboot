package com.ricky.example;

import com.alibaba.fastjson.JSON;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * @author ricky
 * @create 2020-03-30 22:26
 */
public class TestFastDFS {

    @Test
    public void TestUpload(){
        try {
            //加载fastdfs-client.properties文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
            System.out.println("charset=" + ClientGlobal.g_charset);

            //创建tracker客户端
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            //创建storage客户端
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            //文件元信息
            NameValuePair[] metaList = new NameValuePair[1];
            metaList[0] = new NameValuePair("fileName", "1.jpg");
            String fileId = client.upload_file1("C:\\Users\\Ricky\\Desktop\\1.jpg", "jpg", metaList);
            System.out.println("upload success. file id is: " + fileId);

            /*int i = 0;
            while (i++ < 10) {
                byte[] result = client.download_file1(fileId);
                System.out.println(i + ", download result is: " + result.length);
            }*/

            //关闭tracker服务
            trackerServer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void TestQuery(){

        try {
            //加载fastdfs-client.properties文件
            ClientGlobal.initByProperties("config/fastdfs-client.properties");
            System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
            System.out.println("charset=" + ClientGlobal.g_charset);

            //创建tracker客户端
            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
            StorageServer storageServer = null;
            //创建storage客户端
            StorageClient1 client = new StorageClient1(trackerServer, storageServer);

            FileInfo fileInfo = client.query_file_info("group1","M00/00/00/gcxK5F6CA3iADzseAAAL-H0BZjM276.jpg");
            FileInfo fileInfo1 = client.query_file_info1("group1/M00/00/00/gcxK5F6CA3iADzseAAAL-H0BZjM276.jpg");
            System.out.println("查询结果fileInfo："+fileInfo);
            System.out.println("查询结果fileInfo1："+fileInfo1);

            //查询元信息
            NameValuePair[] metaList = client.get_metadata1("group1/M00/00/00/gcxK5F6CA3iADzseAAAL-H0BZjM276.jpg");
            System.out.println("元信息："+ JSON.toJSONString(metaList));

            //关闭tracker服务
            trackerServer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
