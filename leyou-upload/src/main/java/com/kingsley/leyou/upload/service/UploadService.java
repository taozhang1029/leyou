package com.kingsley.leyou.upload.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kingsley
 * @time 2022/2/12 22:21
 * @ide IntelliJ IDEA
 * @name com.kingsley.leyou.upload.service.UploadService
 * @desc 文件上传
 */
@Slf4j
@Service
public class UploadService {
    
    private static final Set<String> CONTENT_TYPES = new HashSet<>(Arrays.asList("image/jpg", "image/jpeg", "image/gif", "image/png"));
    
    public String uploadImage(MultipartFile file) {
        String filename = file.getOriginalFilename();
        // 1. 校验文件类型
        String contentType = file.getContentType();
        if (!CONTENT_TYPES.contains(contentType)) {
            log.warn("文件上传失败：{}，文件类型不合法！", filename);
            return null;
        }
        
        try {
            // 2. 校验文件类容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if (bufferedImage == null || bufferedImage.getWidth() <= 0 || bufferedImage.getHeight() <= 0) {
                log.warn("文件上传失败：{}，文件内容不合法！", filename);
                return null;
            }
            
            // 3. 保存文件
            file.transferTo(new File("/Users/kingsley/WebServer/leyou/images/" + filename));
            
            // 4. 返回文件url
            return "http://image.leyou.com/" + filename;
        } catch (IOException e) {
            log.warn("文件上传失败：{}，服务器异常！", filename);
            e.printStackTrace();
        }
        return null;
    }
}
