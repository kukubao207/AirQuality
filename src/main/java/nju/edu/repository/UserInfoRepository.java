package nju.edu.repository;

import nju.edu.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<UserInfo,Long>{
    UserInfo findUserInfoByOwnerId(String ownerId);
}
