package com.example.repository;

import com.example.entity.PlaceInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceInfoRepository extends CrudRepository<PlaceInfo,Long> {

}
