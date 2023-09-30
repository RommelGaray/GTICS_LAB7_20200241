package com.example.lab7gtics.repository;

import com.example.lab7gtics.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
