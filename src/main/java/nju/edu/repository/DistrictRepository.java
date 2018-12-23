package nju.edu.repository;

import nju.edu.entity.District;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "district", path = "district")
public interface DistrictRepository extends CrudRepository<District, String> {
    District findByDistrictId(String districtId);
}
