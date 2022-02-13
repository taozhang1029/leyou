package com.kingsley.leyou.upload.controller;

import com.kingsley.leyou.upload.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author kingsley
 * @time 2022/2/12 22:18
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.upload.controller.UploadController
 * @desc 文件上传Controller
 */
@CrossOrigin
@Controller
@RequestMapping("upload")
public class UploadController {
    
    @Autowired
    private UploadService uploadService;
    
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = uploadService.uploadImage(file);
        if (StringUtils.isBlank(url)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(url);
    }
    
}
