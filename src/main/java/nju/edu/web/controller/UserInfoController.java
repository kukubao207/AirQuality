package nju.edu.web.controller;

import nju.edu.entity.UserInfo;
import nju.edu.service.UserInfoService;
import nju.edu.util.IDGenerator;
import nju.edu.web.vo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value= "info/save")
    public Message<UserInfo> info(String picUrl,String country,int gender,String individual,String language,String nickName,String province){
        UserInfo userInfo = new UserInfo();
        userInfo.setAvatarUrl(picUrl);
        userInfo.setCountry(country);
        userInfo.setGender(gender);
        userInfo.setIndividual(individual);
        userInfo.setLanguage(language);
        userInfo.setNickName(nickName);
        userInfo.setProvince(province);
        userInfo.setOwnerId(IDGenerator.generate("USE"));
        userInfo = userInfoService.saveUserInfo(userInfo);
        return new Message<>(userInfo,200,"用户保存信息成功!");
    }
    @GetMapping(value = "info/{ownerId}")
    public Message<UserInfo> info(@PathVariable("ownerId")String ownerId){
        UserInfo userInfo = userInfoService.findUserInfoByOwnerId(ownerId);
        if(userInfo!=null){
            return new Message<>(userInfo,200,"查询用户信息成功!");
        }else {
            return new Message<>(null,400,"用户信息不存在！");
        }
    }
}
