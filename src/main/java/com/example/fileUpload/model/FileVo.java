package com.example.fileUpload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FileVo {
    private int fIdx;
    private String path;
    private String uploader;
    private int levelValue;
    private String uploadedAt;
}
