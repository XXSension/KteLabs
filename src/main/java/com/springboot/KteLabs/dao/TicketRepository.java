package com.springboot.KteLabs.dao;

import com.springboot.KteLabs.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    public List<Ticket> findAllByPatientIsNullAndDoctorId(int id);

}
