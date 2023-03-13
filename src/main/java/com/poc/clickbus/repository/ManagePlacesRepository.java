package com.poc.clickbus.repository;

import com.poc.clickbus.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagePlacesRepository extends JpaRepository<Place, Long> {
}
