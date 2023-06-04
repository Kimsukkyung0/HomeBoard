package com.example.user;

import com.example.user.model.*;
import com.example.utils.FileUtils;
import com.green.boardver3.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


@Service
public class UserService {
    private final UserMapper mapper;

    @Value("${file.dir}")
    private String fileDir;
    @Autowired
    public UserService(UserMapper mapper){
        this.mapper = mapper;
    }
    public int insBoard(UserInsDto dto){
        CommonUtils utils = new CommonUtils();

        dto.setUpw(utils.encodeSha256(dto.getUpw()));
        return mapper.insUser(dto);
    }

    public int upUserInfo(UserUpInfoDto iDto){
        return mapper.upUserInfo(iDto);
    }
    public int delBoard(UserEntity entity){return mapper.delUser(entity);}
    public List<UserVo> selBoardAllPaging(UserIdx uidx){
        uidx.setStartIdx((uidx.getPage()-1)*uidx.getRow());
        return mapper.selAllUsers(uidx);
    }
    public UserVo selById(UserDto dto) {return mapper.selById(dto);}

    public int upUserPhotoDto(MultipartFile pic,UserUpPhotoDto pDto){
        // user/pk/uuid.jpg
        // user/1/abcd.jpg
        String upperPath = String.format("/user/%d",pDto.getIdx());
        String lowerPath = String.format("/%s/%s",fileDir,upperPath);
        //ex) lowerPath = D:/download/user/1012

        File file = new File(lowerPath);
        if(!file.exists()){
            file.mkdirs();
        }
        //If at the directory doesn't exist the folder, make.

        String originalFileName = pic.getOriginalFilename();
        String savedFileName = FileUtils.makeRandomFileName(originalFileName);
        //final result : randomUuid.ext

        String savedFilePath = String.format("%s/%s",upperPath,savedFileName);
        //sub result : user/1012/randomUuid.ext
        String targetPath = String.format("%s/%s", fileDir,savedFilePath);
        //final result : D:/download/user/1012/randomUuid.ext
        File target = new File(targetPath);
        //generating object holding the targetting path

        try{
        pic.transferTo(target);}
        catch(Exception e){
            return 0;
        }

        pDto.setMainPic(savedFileName);
        //user/1012/randomUuid.ext

        try{
            int result = mapper.upUserPhoto(pDto);
            if(result == 0){
                throw new Exception("프로필 사진을 등록할 수 없습니다");
            }
        }
        catch(Exception e){
            //등록불가능시, 파일삭제기능
            target.delete();
            return 0;
        }
        return 1;

    }

}
