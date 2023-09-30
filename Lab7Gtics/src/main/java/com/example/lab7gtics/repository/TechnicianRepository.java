package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.Technician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
}
