package nju.edu.service;

import nju.edu.entity.UserInfo;
import nju.edu.web.vo.ResultData;

public interface UserInfoService {
    ResultData saveUserInfo(UserInfo userInfo);
    ResultData findUserInfoByOwnerId(String ownerId);
    ResultData findUserInfoByPhone(String phone);
}
