package com.finki.emt.sport.service.impl;

import com.finki.emt.sport.model.Manufacturer;
import com.finki.emt.sport.repository.ManufacturersRepository;
import com.finki.emt.sport.service.ManufacturerService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturersRepository repository;

    public ManufacturerServiceImpl(ManufacturersRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Manufacturer> getManufacturers() {
        return repository.findAll();
    }

    @Override
    public Optional<Manufacturer> getManufacture(Long id) {
        return repository.findById(id);
    }

    @Override
    public Manufacturer save(String name) {
        Manufacturer manufacturer = new Manufacturer(name);
        return repository.save(manufacturer);
    }
}
