package com.finki.emt.sport.repository;

import com.finki.emt.sport.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturersRepository extends JpaRepository<Manufacturer,Long> {
}
