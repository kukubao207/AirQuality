package nju.edu.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="T_DISTRICT")
public class District extends BaseEntity{
    @Column(name="F_DISTRICT_ID")
    private String districtId;
    @Column(name="F_CITY_ID")
    private String cityId;
    @Column(name="F_DISTRICT_NAME")
    private String districtName;
}
