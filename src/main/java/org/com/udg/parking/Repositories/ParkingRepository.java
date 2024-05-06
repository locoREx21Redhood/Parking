package org.com.udg.parking.Repositories;

import org.com.udg.parking.Models.ParkingModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;
public interface ParkingRepository extends CrudRepository<ParkingModel, Long>{

    public Optional<ArrayList<ParkingModel>> findParkingBymodelo(String modelo);

    public Optional<ArrayList<ParkingModel>> findParkingByccolor(String ccolor);
}
