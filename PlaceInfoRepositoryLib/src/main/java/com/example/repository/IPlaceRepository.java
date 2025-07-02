package com.example.repository;

import com.example.entity.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceRepository extends CrudRepository<Place, String> {
}
