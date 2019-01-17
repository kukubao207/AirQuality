package nju.edu.entity;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "T_USERINFO")
public class UserInfo extends BaseEntity {
    @Id
    @Column(name = "F_OWNERID")
    private String ownerId;
    @Column(name = "F_PHONE")
    private String phone;
    @Column(name = "password")
    private String password;
    @Column(name = "F_NICKNAME")
    private String nickName;
    @Column(name = "F_AVATARURL")
    private String avatarUrl;
    @Column(name = "F_GENDER")
    private int gender;
    @Column(name = "F_PROVINCE")
    private String province;
    @Column(name = "F_COUNTRY")
    private String country;
    @Column(name = "F_LANGUAGE")
    private String language;
    @Column(name = "F_INDIVIDUAL",length = 5000)
    private String individual;
}
