package nju.edu.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="T_CITY")
public class City extends BaseEntity {
    @Id
    @Column(name="F_CITY_ID")
    private String cityId;
    @Column(name="F_PROVINCE_ID")
    private String provinceId;
    @Column(name="F_CITY_NAME")
    private String cityName;
    @Column(name="F_CITY_PINYIN")
    private String cityPinyin;
    @Column(name="F_LONGITUDE")
    private long longitude;
    @Column(name="F_LATITUDE")
    private long latitude;
}
