package nju.edu.repository;

import nju.edu.entity.Province;
import org.springframework.data.repository.CrudRepository;

public interface ProvinceRepository extends CrudRepository<Province,Long> {
    Province findProvinceByProvinceId(String provinceId);
}
