package com.springboot.KteLabs.dao;

import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patients,Integer> {
    Patients findByUuid(UUID uuid);
}
