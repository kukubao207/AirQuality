package nju.edu.service.impl;

import nju.edu.entity.City;
import nju.edu.repository.CityRepository;
import nju.edu.service.CityService;
import nju.edu.util.ServiceHelpUtil;
import nju.edu.web.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public ResultData getCityList() {
        List<City> cityList = cityRepository.findCitiesByCityIdLike("%");
        return ServiceHelpUtil.helpReturn(cityList);
    }
}
