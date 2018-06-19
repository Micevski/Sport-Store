package com.finki.emt.sport.service;
import com.finki.emt.sport.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    List<Manufacturer> getManufacturers();
    Optional<Manufacturer> getManufacture(Long id);
    Manufacturer save(String name);
}
