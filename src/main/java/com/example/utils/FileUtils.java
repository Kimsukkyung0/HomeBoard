package com.example.utils;

import java.util.UUID;

public class FileUtils {
    //확장자만! 리턴하는 메서드
    public static String getExt(String file){
        return file.substring(file.lastIndexOf(".")+1);
    }

    //파일명만 리턴
    public static String getFileName(String file){
        return file.substring(0,file.lastIndexOf("."));
    }

    //uuid이용, 랜덤값 파일리턴
    public static String makeRandomFileName(String file){
        return UUID.randomUUID()+"."+getExt(file);
    }
}
