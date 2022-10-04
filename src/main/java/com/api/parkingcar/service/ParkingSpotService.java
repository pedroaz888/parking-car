package com.api.parkingcar.service;

import com.api.parkingcar.models.ParkingSpotModel;
import com.api.parkingcar.repository.ParkingSpotRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class ParkingSpotService {

    @Autowired
    ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }


    public boolean existsByLicensePlateCar (String licensePlateCar){
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber){
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block){
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpotModel> findAll(Pageable sort){
        return parkingSpotRepository.findAll(sort);
    }

    public Optional<ParkingSpotModel> findById(Long id){
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotModel parkingSpotModel){
        parkingSpotRepository.delete(parkingSpotModel);
    }
}
