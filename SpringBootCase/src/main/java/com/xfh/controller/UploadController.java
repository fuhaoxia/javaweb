package com.xfh.controller;

import com.xfh.domain.Result;
import com.xfh.utils.AliyunOSSOperator;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    @Resource
    private AliyunOSSOperator aliyunOSSOperator;

    @PostMapping("/upload")
    public Result upLoadImage(MultipartFile file) throws Exception {
        String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
        return Result.success(url);
    }
}
