package com.springboot.KteLabs.controller;

import com.springboot.KteLabs.entity.Ticket;
import com.springboot.KteLabs.service.PatientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientsService patientsService;

    @GetMapping("/{id}")
    public List<Ticket> findByAllTicketById(@PathVariable int id) {
        return this.patientsService.findById(id);
    }

    @GetMapping("/{uuid}")
    public List<Ticket> findByAllTicketByUUid(@PathVariable UUID id) {
        return this.patientsService.findByUuid(id);
    }
}
