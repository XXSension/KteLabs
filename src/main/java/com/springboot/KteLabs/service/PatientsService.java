package com.springboot.KteLabs.service;

import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;

import java.util.List;
import java.util.UUID;

public interface PatientsService {
    List<Ticket> findById(int id);

    List<Ticket> findByUuid(UUID uuid);
}
