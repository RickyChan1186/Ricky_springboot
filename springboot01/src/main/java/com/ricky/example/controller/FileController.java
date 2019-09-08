package com.ricky.example.controller;

import com.ricky.example.entity.JsonData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ricky
 * @create 2019-09-02 20:36
 */
@RestController
public class FileController {

    @Value("${user.filePath}")
    private String filePath;

    @PostMapping(value = "/upload")
    public JsonData upload(@RequestParam("head_img") MultipartFile file, HttpServletRequest request){
        file.isEmpty();
        file.getSize();
        System.out.println(filePath);
        String name = request.getParameter("name");
        System.out.println("用户名："+name);

        String fileName = file.getOriginalFilename();
        System.out.println("上传文件的名称"+fileName);

        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传文件的后缀名："+suffixName);

        fileName = UUID.randomUUID() + suffixName;
        System.out.println("转换后的文件名称："+fileName);

        File dest =  new File(filePath + fileName);

        try {
            file.transferTo(dest);
            return new JsonData(1,fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JsonData(-1,null,"fail to upload");
    }

}
