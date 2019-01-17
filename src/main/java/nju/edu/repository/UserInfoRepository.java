package nju.edu.repository;

import nju.edu.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "userinfo", path = "userinfo")
public interface UserInfoRepository extends CrudRepository<UserInfo, String>{
    UserInfo findUserInfoByOwnerId(String ownerId);
    UserInfo findUserInfoByPhone(String phone);
}
