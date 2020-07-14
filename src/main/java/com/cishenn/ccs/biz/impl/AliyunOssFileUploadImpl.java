package com.cishenn.ccs.biz.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ObjectMetadata;
import com.cishenn.ccs.biz.IFileUploadBiz;
import com.cishenn.ccs.exception.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class AliyunOssFileUploadImpl implements IFileUploadBiz {

    @Value("${aliyun.oss.endpoint-domain}")
    private String endpointDomain;

    @Value("${aliyun.oss.access-key.id}")
    private String accessKeyId;

    @Value("${aliyun.oss.access-key.secret}")
    private String accessKeySecret;

    @Value("${aliyun.oss.bucket}")
    private String bucket;

    private final Logger logger = LoggerFactory.getLogger(AliyunOssFileUploadImpl.class);

    @Override
    public String uploadFile(MultipartFile file) {
        try {
            if (file == null || file.isEmpty()) {
                throw new FileUploadException("文件为空，无法上传");
            }
            String originalFilename = file.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentDisposition("attachment;filename=\"" + originalFilename + "\"");
            String archiveFilename = getArchiveFilename(originalFilename, "upload/");
            return doUploadFile(archiveFilename, file.getInputStream(), metadata);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileUploadException("文件上传失败", e);
        }
    }

    @Override
    public String uploadImage(MultipartFile image) {
        try {
            if (image == null || image.isEmpty()) {
                throw new FileUploadException("文件为空，无法上传");
            }
            String originalFilename = image.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();
            String archiveFilename = getArchiveFilename(originalFilename, "assets/");
            return doUploadFile(archiveFilename, image.getInputStream(), metadata);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileUploadException("文件上传失败", e);
        }
    }

    private String getArchiveFilename(String originalFilename, String prefix) {
        String[] splitFilenameParts = originalFilename == null ? new String[]{} : originalFilename.split("\\.(?=[^\\.]+$)");
        String fileBasename = UUID.randomUUID().toString();
        String fileExtension = splitFilenameParts.length > 1 ? "." + splitFilenameParts[1] : "";
        return prefix + fileBasename + fileExtension;
    }

    private String doUploadFile(String filename, InputStream inputStream, ObjectMetadata metadata) {
        OSS ossClient = new OSSClientBuilder().build("https://" + endpointDomain, accessKeyId, accessKeySecret);
        try {
            ossClient.putObject(bucket, filename, inputStream, metadata);
            return ("https://" + bucket + "." + endpointDomain + "/" + filename);
        } catch (OSSException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("An upload request made it to OSS, but was rejected for some reason");
                System.err.println("Error Message: " + e.getErrorMessage());
                System.err.println("Error Code:    " + e.getErrorCode());
                System.err.println("Request ID:    " + e.getRequestId());
                System.err.println("Host ID:       " + e.getHostId());
            }
            throw new FileUploadException("OSS 远端拒绝了上传请求");
        } catch (ClientException e) {
            if (logger.isWarnEnabled()) {
                logger.warn("Client has encountered a problem communicating with OSS");
                System.err.println("Error Message: " + e.getMessage());
            }
            throw new FileUploadException("连接 OSS 时出错");
        } finally {
            ossClient.shutdown();
        }
    }
}
