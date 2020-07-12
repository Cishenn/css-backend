package com.cishenn.ccs.biz;

import org.springframework.web.multipart.MultipartFile;

public interface IFileUploadBiz {

    String uploadFile(MultipartFile file);

    String uploadImage(MultipartFile image);

}