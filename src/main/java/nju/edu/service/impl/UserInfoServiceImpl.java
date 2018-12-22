package nju.edu.service.impl;

import nju.edu.entity.*;
import nju.edu.repository.UserInfoRepository;
import nju.edu.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRespository;

    @Override
    public UserInfo saveUserInfo(UserInfo userInfo) {
        return userInfoRespository.save(userInfo);
    }

    @Override
    public UserInfo findUserInfoByOwnerId(String ownerId) {
        return userInfoRespository.findUserInfoByOwnerId(ownerId);
    }

}
