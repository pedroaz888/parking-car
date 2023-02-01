package com.api.parkingcar.repository;


import com.api.parkingcar.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    @Query(value = "select p from ParkingSpotModel p where upper (p.modelCar) like %?1%")
    List<ParkingSpotModel> buscarPorNome (String name);


    boolean existsByLicensePlateCar(String licensePlateCar);
    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);






}
