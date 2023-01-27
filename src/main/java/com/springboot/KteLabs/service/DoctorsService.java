package com.springboot.KteLabs.service;

import com.springboot.KteLabs.entity.Doctors;

import java.util.List;
import java.util.Optional;

public interface DoctorsService {
    List<Doctors> findAllDoctors();
    Optional<Doctors> findById(int id);
    Doctors saveDoctors(Doctors employeeDoctors);
    Doctors updateDoctors(Doctors employeeDoctors);
    void deleteDoctors(int id);
}
