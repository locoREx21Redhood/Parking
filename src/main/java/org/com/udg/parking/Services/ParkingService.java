package org.com.udg.parking.Services;

import org.com.udg.parking.Models.ParkingModel;
import org.com.udg.parking.Repositories.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ParkingService {
    @Autowired
    ParkingRepository repository;

    //CRUD

    public ParkingModel saveParking(ParkingModel parking){
        if(repository.findParkingBymodelo(parking.getModelo()).toString().equals("Optional[[]]")){
            return repository.save(parking);
        }else{
            //retornar un error de repetido
            ParkingModel parkingError = new ParkingModel();
            parkingError.setId(-1L);
            return parkingError;
        }
    }
    public ArrayList<ParkingModel> vehicles(){
        return (ArrayList<ParkingModel>) repository.findAll();
    }

    public Optional<ParkingModel> findParkingById(Long id){
        return repository.findById(id);
    }



    public ParkingModel editParking(ParkingModel parking){
        return repository.save(parking);
    }

    public String deleteParkingById(Long id){

        if(findParkingById(id).isPresent()){
            repository.deleteById(id);
            return "Parking fue eliminado correctamente";
        }else {
            return "Parking con id="+ id+ " no encontrado";
        }
    }

    public Optional<ArrayList<ParkingModel>> findParkingBymodelo(String modelo){
        return repository.findParkingBymodelo(modelo);
    }
    public Optional<ArrayList<ParkingModel>> findParkingByccolor(String ccolor){
        return repository.findParkingByccolor(ccolor);
    }
}
