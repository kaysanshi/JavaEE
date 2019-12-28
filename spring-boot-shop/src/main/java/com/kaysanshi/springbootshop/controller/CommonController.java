package com.kaysanshi.springbootshop.controller;

import com.kaysanshi.springbootshop.config.UploadConfig;
import com.kaysanshi.springbootshop.dto.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

/**
 * @Author kay三石
 * @date:2019/11/25
 */
@RequestMapping("/common")
@Controller
public class CommonController {

    @Autowired
    private UploadConfig uploadConfig;


    /**
     * 文件上传
     * @param file
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public BaseResult upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        if(!file.isEmpty()){
            String fileName=file.getOriginalFilename();
            System.out.println(fileName);
            String newFileName= UUID.randomUUID().toString()+fileName.substring(file.getOriginalFilename().lastIndexOf("."));
            File saveFile = new File(uploadConfig.getPimgPath() + "/" + newFileName);
            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdirs();
            }
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
                out.write(file.getBytes());
                out.flush();
                out.close();
                return BaseResult.success("http://localhost:" + uploadConfig.getPort() + "/image/" + newFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return BaseResult.error("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("文件不能为空");
        }
        return null;

    }
}
