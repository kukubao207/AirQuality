package nju.edu.repository;

import nju.edu.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
    City findCityByCityId(String cityId);
}
