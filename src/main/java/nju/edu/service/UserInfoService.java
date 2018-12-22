package nju.edu.service;

import nju.edu.entity.UserInfo;

public interface UserInfoService {
    UserInfo saveUserInfo(UserInfo userInfo);
    UserInfo findUserInfoByOwnerId(String ownerId);
}
