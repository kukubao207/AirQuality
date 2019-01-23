package nju.edu.web.controller;

import nju.edu.service.CityService;
import nju.edu.util.LocationUtil;
import nju.edu.web.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("location")
public class LocationController {

    @Autowired
    private CityService cityService;

    //根据ip解析地址
    @PostMapping("/ip/resolve")
    public ResultData ip2address(String ip) {
        return LocationUtil.ip2address(ip);
    }

    //根据地址解析经纬度
    @PostMapping("/address/resolve")
    public ResultData geocoder(String address) {
        return LocationUtil.geocoder(address);
    }

    //获取城市列表
    @GetMapping("city/list")
    public ResultData getCityList(){
        return cityService.getCityList();
    }

}
