package com.example.fileUpload;

import com.example.fileUpload.model.FileEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileUploadMapper {
    int inProfilePhoto(FileEntity fenti);

}
