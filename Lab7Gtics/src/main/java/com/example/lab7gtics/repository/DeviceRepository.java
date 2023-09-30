package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
}
