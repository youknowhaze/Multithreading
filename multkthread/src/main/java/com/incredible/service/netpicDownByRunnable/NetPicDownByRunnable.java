package com.incredible.service.netpicDownByRunnable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 多线程同步下载网络图片
 */
public class NetPicDownByRunnable implements Runnable{

    private String name;
    private String url;

    public NetPicDownByRunnable(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public void run() {
        WebDownLoaderByRunnable webDownLoader = new WebDownLoaderByRunnable();
        webDownLoader.download(url,name);
    }
}


class WebDownLoaderByRunnable{
    public void download(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，download方法出现异常"+e);
        }
    }
}