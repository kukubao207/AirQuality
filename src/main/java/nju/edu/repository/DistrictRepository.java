package nju.edu.repository;

import nju.edu.entity.District;
import org.springframework.data.repository.CrudRepository;

public interface DistrictRepository extends CrudRepository<District, Long> {
    District findByDistrictId(String districtId);
}
