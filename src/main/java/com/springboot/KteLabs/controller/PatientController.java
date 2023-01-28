package com.springboot.KteLabs.controller;

import com.springboot.KteLabs.entity.Ticket;
import com.springboot.KteLabs.exception_handling.NoSuchTicketException;
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

    /*
     * Поиск всех слотов времени занятых одним пациентом по id
     *  */
    @GetMapping("/{id}")
    public List<Ticket> findByAllTicketById(@PathVariable int id) {
        List<Ticket> ticketList =  this.patientsService.findById(id);
        if(ticketList == null) {
            throw new NoSuchTicketException("There is no patient with id = "
                    + id + " in Database");
        }
        return ticketList;
    }

    /*
     * Поиск всех слотов времени занятых одним пациентом по uuid
     *  */
    @GetMapping("/uuid/{uuid}")
    public List<Ticket> findByAllTicketByUUid(@PathVariable("uuid") UUID id) {
        List<Ticket> ticketList =  this.patientsService.findByUuid(id);
        if(ticketList == null) {
            throw new NoSuchTicketException("There is no patient with uuid = "
                    + id + "in Database");
        }
        return ticketList;
    }
}
