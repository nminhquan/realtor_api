package com.squirrel.realtor.api.service.search;

import com.squirrel.realtor.api.model.dto.House;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SearchService {
    List<House> searchHouseByAddress(String address);
}
