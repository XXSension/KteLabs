package com.springboot.KteLabs.service.impl;

import com.springboot.KteLabs.dao.PatientRepository;
import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;
import com.springboot.KteLabs.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientsServiceImpl implements PatientsService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Ticket> findById(int id) {
        return this.patientRepository.findById(id).getDoctorsList();
    }

    @Override
    public List<Ticket> findByUuid(UUID uuid) {
        return this.patientRepository.findByUuid(uuid).getDoctorsList();
    }
}
