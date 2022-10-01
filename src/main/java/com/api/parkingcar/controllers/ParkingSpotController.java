package com.api.parkingcar.controllers;

import com.api.parkingcar.dtos.ParkingSpotDto;
import com.api.parkingcar.models.ParkingSpotModel;
import com.api.parkingcar.service.ParkingSpotService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping ("/api")
@Api(value="API REST parking")

public class ParkingSpotController {

    @Autowired
    ParkingSpotService parkingSpotService;

    @PostMapping("/parking-spot")
    @ApiOperation(value="Salva as vagas")
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){

        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicensePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Essa placa já foi registrada");
        }

        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse número já está sendo usado");
        }

        if(parkingSpotService.existsByApartmentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getBlock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse morador já foi cadastrado");
        }

        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        //metodo para converter dto em model//
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);


        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

/*    @GetMapping("/parking-spot/listar")
    @ApiOperation(value="Lista todos os registros de vagas")
    public ResponseEntity<Page<ParkingSpotModel>>getAllParkingSpots(Principal principal){

        PageRequest paginacao = PageRequest.of(0,7);

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll(paginacao));
    }*/


    @GetMapping("/parking-spot/listar")
    @ApiOperation(value="Lista todos os registros de vagas")
    public ResponseEntity<List<ParkingSpotModel>>getAllParkingSpots(){

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findAll());
    }

    @GetMapping("/parking-spot/{id}")
    @ApiOperation(value="Busca infos da vaga pelo ID")
    public ResponseEntity<Object>getOneParkingSpots(@PathVariable(value = "id") Long id){

        Optional<ParkingSpotModel>parkingSpotModelOptional = parkingSpotService.findById(id);

        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    @DeleteMapping("parking-spot/{id}")
    @ApiOperation(value="Deleta as vagas")
    public ResponseEntity<Object>deleteParkingSpots(@PathVariable(value = "id") Long id){

        Optional<ParkingSpotModel>parkingSpotModelOptional = parkingSpotService.findById(id);

        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada!");
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso!");
    }

    @PutMapping("parking-spot/{id}")
    @ApiOperation(value="Atualiza as vagas")
    public ResponseEntity<Object>updateParkingSpot(@PathVariable(value="id")Long id,
                                                @RequestBody @Valid ParkingSpotDto parkingSpotDto){
    Optional<ParkingSpotModel>parkingSpotModelOptional = parkingSpotService.findById(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não encontrada");
        }
      ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());


            return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
        }

}



