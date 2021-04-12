package com.ricky.example.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

/**
 * @author ricky
 * @create 2021-04-12 16:39
 */
public class mainTest {
    public static void main(String[] args) {


// 生成指定url对应的二维码到文件，宽和高都是300像素
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("d:/qrcode.jpg"));

    }
}
