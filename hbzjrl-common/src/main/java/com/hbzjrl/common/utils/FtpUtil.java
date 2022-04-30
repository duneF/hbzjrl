package com.hbzjrl.common.utils;

import com.tencentcloudapi.ams.v20200608.models.FileOutput;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;

/***
 *Author: Yc
 *Date:2022/4/26 9:40
 */

public class FtpUtil {
    /**
     * Cparam host FTP服务器hostname:
     * Cparam port FTP服务器端口
     * Cparam username FTP登录账号
     * Cparam password FTP登录密码
     * Cparam basePath FTP服务器基础目录
     * param filePath FTP服务器文件存放路径。例如分日期存放:/2015/01/01。文件的路径为basePath+filePat
     * Cparam filename 上传到FTP服务器上的文件名
     * Cparam input输入流
     * Creturn成功返回true，否则返回falset
     */
    public static boolean uploadFile(String host, int port, String userName, String passWord,
                                     String basePath, String filePaht, String fileName, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);//连接FTP服务器
            //如果采用默认端口,可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(userName, passWord);//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath + filePaht)) {
                //如果目录不存在创建目录
                String[] dirs = filePaht.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (dir == null || "".equals(dir)) continue;
                    {
                        tempPath += "/" + dir;
                        if (!ftp.changeWorkingDirectory(tempPath)) {
                            if (!ftp.makeDirectory((tempPath))) {
                                return result;
                            } else {
                                ftp.changeWorkingDirectory(tempPath);
                            }
                        }
                    }
                }
                //设置上传文件的类型为二进制类型
                ftp.setFileType(FTP.BINARY_FILE_TYPE);
                //上传文件
                if (!ftp.storeFile(fileName, input)) {
                    return result;
                }
                input.close();
                ftp.logout();
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

    /**
     * Description:从FTP服务器下载文件
     * Cparam host FTP服务器hostname
     * Cparam port FTP服务器端口
     * Cparam username FTP登录账号
     * Cparam password FTP登录密码
     * Cparam remotePath FTP服务器上的相对路径
     * CparamfileName要下载的文件名
     * Cparam localPath下载后保存到本地的路径,
     **/
    public static boolean downLoadFile(String host, int port, String userName, String passWord, String remotePath,
                                       String fileName, String localPath) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            //如果采用默认端口,可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(userName, passWord);//登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(remotePath);//转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFIle = new File(localPath + "/" + ff.getName());
                    OutputStream is = new FileOutputStream(localFIle);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }

  /*  public static void main(String[] args) {
        try {
            FileInputStream in = new FileInputStream(new File("\\E:\\桌面临时\\QQ图片20220424214018.jpg"));
            FileOutputStream fileOutputStream = new FileOutputStream("\\E:\\桌面临时\\111.jpg");
            boolean flag = uploadFile("43.138.80.85", 21, "ftpuserzf", "zf123", "/var/ftp/test", "/2022/4/26", "OK3.jpg", in);
            System.out.println(flag);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

      //      FileOutputStream outputStream = new FileOutputStream("\\E:\\桌面临时\\11.jpg");
        downLoadFile("43.138.80.85",21,"ftpuserzf","zf123",
                "/var/ftp/test/2022/4/26","OK3.jpg","\\E:\\桌面临时\\");
    }*/

}