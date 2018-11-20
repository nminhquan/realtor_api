package com.squirrel.realtor.api.dao;

import com.squirrel.realtor.api.model.dto.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

    List<House> findByAddress(String address);
}