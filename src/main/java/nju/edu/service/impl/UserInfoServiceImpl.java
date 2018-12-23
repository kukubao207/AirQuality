package nju.edu.service.impl;

import nju.edu.entity.*;
import nju.edu.repository.UserInfoRepository;
import nju.edu.service.UserInfoService;
import nju.edu.util.ResponseCode;
import nju.edu.util.ServiceHelpUtil;
import nju.edu.web.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRespository;

    @Override
    public ResultData saveUserInfo(UserInfo userInfo) {
        Object data = userInfoRespository.save(userInfo);
        return ServiceHelpUtil.helpReturn(data);
    }

    @Override
    public ResultData findUserInfoByOwnerId(String ownerId) {
        Object data = userInfoRespository.findUserInfoByOwnerId(ownerId);
        return ServiceHelpUtil.helpReturn(data);
    }

}
