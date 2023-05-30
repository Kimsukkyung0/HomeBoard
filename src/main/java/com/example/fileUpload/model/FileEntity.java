package com.example.fileUpload.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class FileEntity {
    private int idx;
    private String path;
    private String uploader;
    private int levelValue;
    private int fIdx;

}
