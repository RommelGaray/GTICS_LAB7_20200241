package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
