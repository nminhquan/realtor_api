package com.squirrel.realtor.api.service.house;

import com.squirrel.realtor.api.dao.HouseDAO;
import com.squirrel.realtor.api.dao.mysql.HouseRepository;
import com.squirrel.realtor.api.dto.mysql.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseRepository houseRepository;
    @Autowired
    HouseDAO houseDAO;

    @Override
    public House addAHouse(@ModelAttribute House s) {
        return houseDAO.addNewHouse(s);
    }

    @Override
    public Optional<House> getHouseById(long id) {
        return houseRepository.findById(id);
    }

    @Override
    public List<House> getAllHouses() {
        List<House> listHouse = new ArrayList<>();
        Iterable<House> houses = houseRepository.findAll();
        for (House s : houses) listHouse.add(s);
        return listHouse;
    }

    @Override
    public List<House> getNearbyHouses(String address) {
        return houseDAO.searchNearByHouse(address);
    }

    @Override
    public void removeHouse(long id) {
        houseRepository.deleteById(id);
    }

    @Override
    public House updateHouseAddress(long id, String address) {
        House h = houseRepository.findById(id).get();
        h.setAddress(address);
        return houseRepository.save(h);
    }

}
