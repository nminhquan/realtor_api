package com.squirrel.realtor.api.dao.mysql;

import com.squirrel.realtor.api.dto.mysql.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends CrudRepository<House, Long> {

}