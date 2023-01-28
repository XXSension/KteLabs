package com.springboot.KteLabs.service.impl;

import com.springboot.KteLabs.dao.PatientRepository;
import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;
import com.springboot.KteLabs.exception_handling.NoSuchTicketException;
import com.springboot.KteLabs.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PatientsServiceImpl implements PatientsService {

    @Autowired
    private PatientRepository patientRepository;

    /*
     * Поиск всех слотов времени занятых одним пациентом по id
     *  */
    @Override
    public List<Ticket> findById(int id) {
        Optional<Patients> optional = this.patientRepository.findById(id);
        if(optional.isPresent()){
            Patients patient = optional.get();
            return patient.getDoctorsList();
        }
        return null;
    }

    /*
     * Поиск всех слотов времени занятых одним пациентом по uuid
     *  */
    @Override
    public List<Ticket> findByUuid(UUID uuid) {
        Patients patient = this.patientRepository.findByUuid(uuid);
        if (patient != null) {
            return patient.getDoctorsList();
        }
        return null;

    }
}
