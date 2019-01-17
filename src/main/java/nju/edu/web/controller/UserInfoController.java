package nju.edu.web.controller;

import nju.edu.entity.UserInfo;
import nju.edu.service.UserInfoService;
import nju.edu.util.IDGenerator;
import nju.edu.util.ResponseCode;
import nju.edu.web.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("info")
    public ResultData getUserInfo(String ownerId) {
        return userInfoService.findUserInfoByOwnerId(ownerId);
    }


    @PostMapping("register")
    public ResultData registerUser(String phone, String password, String nickName, int gender, String country, String province, String individual) {
        ResultData result = new ResultData();
        //1.检查输入
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("用户名和密码不可为空");
            return result;
        }
        //2.检查手机号是否被注册过
        ResultData response = userInfoService.findUserInfoByPhone(phone);
        if (response.getResponseCode() != ResponseCode.RESPONSE_NULL) {
            result.setResponseCode(response.getResponseCode());
            result.setDescription("服务器错误或手机号被注册过");
            return result;
        }

        //3.存入数据库
        UserInfo userInfo = new UserInfo();
        userInfo.setOwnerId(IDGenerator.generate("USR"));
        userInfo.setPhone(phone);
        userInfo.setPassword(password);
        userInfo.setLanguage("ch");
        if(!StringUtils.isEmpty(nickName)){
            userInfo.setNickName(nickName);
        }
        if(!StringUtils.isEmpty(gender)){
            userInfo.setGender(gender);
        }
        if(!StringUtils.isEmpty(country)){
            userInfo.setCountry(country);
        }
        if(!StringUtils.isEmpty(province)){
            userInfo.setProvince(province);
        }
        if(!StringUtils.isEmpty(individual)){
            userInfo.setIndividual(individual);
        }
        response = userInfoService.saveUserInfo(userInfo);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(response.getResponseCode());
            result.setDescription("注册录入信息时出错");
            return result;
        }
        result.setDescription("注册成功");
        result.setData(userInfo);
        return result;
    }

    @PostMapping("login")
    public ResultData login(String phone, String password) {
        ResultData result = new ResultData();
        //1.检查输入
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription("用户名和密码不可为空");
            return result;
        }
        ResultData response = userInfoService.findUserInfoByPhone(phone);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            result.setResponseCode(response.getResponseCode());
            result.setDescription("找不到该用户");
            return result;
        }
        UserInfo userInfo = (UserInfo) response.getData();
        if (userInfo.getPassword().equals(password)) {
            result.setData(userInfo);
            return result;
        } else {
            result.setData(ResponseCode.RESPONSE_NULL);
            result.setDescription("密码错误");
            return result;
        }
    }

    @PostMapping("info/save")
    public ResultData saveUserInfo(String ownerId, String picUrl, String country, int gender, String individual, String language, String nickName, String province) {
        UserInfo userInfo = new UserInfo();
        userInfo.setOwnerId(ownerId);
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
