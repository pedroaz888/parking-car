package com.api.parkingcar.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name="TB_PARKING_SPOT")
public class ParkingSpotModel implements Serializable {

    private static final long SerialVersionUID=1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    @Column(name = "parking_Spot_Number", nullable = false)
    private String parkingSpotNumber;
    @Column(name = "license_PlateCar", nullable = false)
    private String licensePlateCar;
    @Column(name= "brand_Car", nullable = false)
    private String brandCar;
    @Column(name= "model_Car",nullable = false)
    private String modelCar;
    @Column(name= "color_Car",nullable = false)
    private String colorCar;

    @Column(name= "responsible_Name", nullable = false)
    private String responsibleName;
    @Column(name= "apartment", nullable = false)
    private String apartment;
    @Column(name= "block",nullable = false)
    private String block;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getParkingSpotNumber() {
        return parkingSpotNumber;
    }

    public void setParkingSpotNumber(String parkingSpotNumber) {
        this.parkingSpotNumber = parkingSpotNumber;
    }

    public String getLicensePlateCar() {
        return licensePlateCar;
    }

    public void setLicensePlateCar(String licensePlateCar) {
        this.licensePlateCar = licensePlateCar;
    }

    public String getBrandCar() {
        return brandCar;
    }

    public void setBrandCar(String brandCar) {
        this.brandCar = brandCar;
    }

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public String getColorCar() {
        return colorCar;
    }

    public void setColorCar(String colorCar) {
        this.colorCar = colorCar;
    }



    public String getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(String responsibleName) {
        this.responsibleName = responsibleName;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
