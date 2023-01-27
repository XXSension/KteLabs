package com.springboot.KteLabs.dao;

import com.springboot.KteLabs.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctors, Integer> {

}
