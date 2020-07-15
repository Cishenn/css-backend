package com.cishenn.ccs.controller;

import com.cishenn.ccs.biz.IFileUploadBiz;
import com.cishenn.ccs.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@CrossOrigin
public class FileUploadController {

    @Autowired
    private IFileUploadBiz fileUploadBiz;

    @PostMapping("/file")
    public Result uploadFile(@RequestBody MultipartFile file) {
        String uploadedFileUrl = fileUploadBiz.uploadFile(file);
        return Result.ok(uploadedFileUrl);
    }

    @PostMapping("/image")
    public Result uploadImage(@RequestBody MultipartFile file) {
        String uploadedImageUrl = fileUploadBiz.uploadImage(file);
        return Result.ok(uploadedImageUrl);
    }

}