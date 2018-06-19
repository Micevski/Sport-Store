package com.finki.emt.sport.controller.rest;

import com.finki.emt.sport.model.Manufacturer;
import com.finki.emt.sport.service.ManufacturerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/manufacturer")
public class ManufacturerResources {

    private final ManufacturerService service;

    public ManufacturerResources(ManufacturerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Manufacturer> getManufacturers(){
        return service.getManufacturers();
    }



    @PostMapping
    public Manufacturer create(@RequestBody String name){
        return service.save(name);
    }
}
