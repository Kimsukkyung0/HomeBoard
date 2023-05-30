package com.example.fileUpload;

import com.example.fileUpload.model.FileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {

    @Value("${file.dir}")               //injection the value into the variable.
    private String fileDir;
    FileUploadMapper mapper;
    @Autowired
    public FileUploadService(FileUploadMapper mapper){
        this.mapper = mapper;
    }

    public void inProfilePhoto (FileEntity fenti, MultipartFile mfile){     //REASON why the type of class is void is OKAY?
        String originalFileName = mfile.getOriginalFilename(); //Getting the object filename and save under the variable.

        String getEx = originalFileName.substring(originalFileName.indexOf(".")); //Getting the name of extension in file
        String uuid = UUID.randomUUID().toString(); //Generate UUID to get the unique file name

        String savedFileName = uuid+getEx;
        String savedFilePath = fileDir+savedFileName;
        // result : name = directory address + filename(uuid) + extention

        File file = new File(savedFileName);

        try{
            mfile.transferTo(file);

            FileEntity enti = FileEntity.builder()
                    .path(savedFileName)
                    .uploader(fenti.getUploader())
                    .levelValue(fenti.getLevelValue())
                    .build();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
