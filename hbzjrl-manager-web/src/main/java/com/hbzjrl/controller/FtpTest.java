package com.hbzjrl.controller;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import org.junit.Test;

/***
 *Author: Yc
 *Date:2022/4/25 20:58
 *Description:
 */
public class FtpTest {
    @Test
    public  void FtpTestClient()throws Exception{
        //创建一个FtpClient对象
        FTPClient ftpClient = new FTPClient();
         //创建连接
        ftpClient.connect("43.138.80.85",21);
        //登录服务器,使用账号密码
        ftpClient.login("ftpuserzf","zf123");
        //上传文件
        //读取本地文件
        FileInputStream inputStream = new FileInputStream(new File("\\E:\\桌面临时\\QQ图片20220424214018.jpg"));
        //设置上传路径
        ftpClient.changeWorkingDirectory("/var/ftp/test");
        //设置上传格式
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数:服务器端文档名字
        //第二个参数:上传文档的inputStream
        ftpClient.storeFile("OK2.jpg",inputStream);
        //关闭连接
        ftpClient.logout();


    }

}
