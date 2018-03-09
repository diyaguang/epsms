package com.dygstudio.epsms.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author: diyaguang
 * @date: 2018/03/02 下午2:33
 * @description: com.dygstudio.epsms.controller
 */
@Configuration
public class UploadController {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(new File("/upload/"+file.getOriginalFilename()),file.getBytes());
            return "OK";
        }catch (IOException e){
            e.printStackTrace();
            return "wrong";
        }
    }
}
