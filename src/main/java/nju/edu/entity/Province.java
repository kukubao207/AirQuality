package nju.edu.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "T_PROVINCE")
public class Province extends BaseEntity{
    @Id
    @Column(name="F_PROVINCE_ID")
    private String provinceId;
    @Column(name="F_PROVINCE_NAME")
    private String provinceName;
    @Column(name="F_PROVINCE_PINYIN")
    private String pinyin;
    @Column(name="F_PROVINCE_LONGITUDE")
    private long longitude;
    @Column(name="F_PROVINCE_LATITUDE")
    private long latitude;
}
