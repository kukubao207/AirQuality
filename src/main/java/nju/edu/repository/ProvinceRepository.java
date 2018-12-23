package nju.edu.repository;

import nju.edu.entity.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "province", path = "province")
public interface ProvinceRepository extends CrudRepository<Province, String> {
    Province findProvinceByProvinceId(String provinceId);
}
