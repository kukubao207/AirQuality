package nju.edu.service.impl;

import nju.edu.entity.City;
import nju.edu.entity.Province;
import nju.edu.repository.ProvinceRepository;
import nju.edu.service.ProvinceService;
import nju.edu.util.ServiceHelpUtil;
import nju.edu.web.vo.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public ResultData getProvinceList() {
        List<Province> provinceList = provinceRepository.findProvincesByProvinceIdLike("%");
        return ServiceHelpUtil.helpReturn(provinceList);
    }
}
