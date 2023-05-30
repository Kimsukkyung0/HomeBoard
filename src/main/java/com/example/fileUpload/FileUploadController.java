package com.example.fileUpload;


import com.example.fileUpload.model.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    private final FileUploadService service;
    @Autowired
    public FileUploadController(FileUploadService service){
        this.service = service;
    }
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public void PostProfilePhoto(@RequestPart FileEntity fenti, @RequestPart MultipartFile mfile){
       service.inProfilePhoto(fenti, mfile);
    }
}
