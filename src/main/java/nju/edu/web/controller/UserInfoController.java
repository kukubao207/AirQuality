package nju.edu.web.controller;

import nju.edu.entity.UserInfo;
import nju.edu.service.UserInfoService;
import nju.edu.util.IDGenerator;
import nju.edu.web.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("info")
    public ResultData getUserInfo(String ownerId){
        return userInfoService.findUserInfoByOwnerId(ownerId);
    }

    @PostMapping("info/save")
    public ResultData saveUserInfo(String picUrl,String country,int gender,String individual,String language, String nickName,String province){
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatarUrl(picUrl);
        userInfo.setCountry(country);
        userInfo.setGender(gender);
        userInfo.setIndividual(individual);
        userInfo.setLanguage(language);
        userInfo.setNickName(nickName);
        userInfo.setProvince(province);
        userInfo.setOwnerId(IDGenerator.generate("USR"));
        return userInfoService.saveUserInfo(userInfo);
    }
}
