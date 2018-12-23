package nju.edu.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import nju.edu.util.HttpClientUtil;
import nju.edu.util.LocationUtil;
import nju.edu.util.ResponseCode;
import nju.edu.web.vo.ResultData;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("location")
public class LocationController {

    //根据ip解析地址
    @RequestMapping(method = RequestMethod.POST, value = "/ip/resolve")
    public ResultData ip2address(String ip) {
        return LocationUtil.ip2address(ip);
    }
    //根据地址解析经纬度
    @RequestMapping(method = RequestMethod.POST, value = "/address/resolve")
    public ResultData geocoder(String address) {
        return LocationUtil.geocoder(address);
    }

}
