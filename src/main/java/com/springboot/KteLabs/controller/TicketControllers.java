package com.springboot.KteLabs.controller;

import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;
import com.springboot.KteLabs.exception_handling.NoSuchTicketException;
import com.springboot.KteLabs.interfaces.Timetable;
import com.springboot.KteLabs.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timetable")
public class TicketControllers {

    @Autowired
    private TicketService ticketService;

    /*
     * Создание расписание слотов времени к врачу по правилу
     **/
    @PostMapping
    public List<Ticket> createTimetable(@RequestBody Timetable timetable) {
        return ticketService.createTimetable(timetable);
    }


    /*
     * получение свободных слотов времени к указанному врачу на указанную дату
     **/
    @GetMapping("/freeticket/{doctorId}/{data}")
    public List<Ticket> findByFreeTicket(@PathVariable int doctorId, @PathVariable String data){
        List<Ticket> ticketList = ticketService.findAllByPatientIsNull(doctorId,data);
        if(ticketList == null) {
            throw new NoSuchTicketException("There is no doctor with id = "
                    + doctorId + "in Database");
        }
        return ticketList;
    }

    /*
     * занятие слота времени по его id свободного слота и id пациента
     **/
    @PutMapping("/entryticket/{ticketId}/{patientId}")
    public Ticket doctorsAppointment(@PathVariable int ticketId, @PathVariable int patientId) {

        Ticket ticket = this.ticketService.doctorsAppointment(ticketId,patientId);
        if (ticket == null) {
            throw new NoSuchTicketException("There is no doctor with id = "
                    + ticketId + " in Database");
        }
        return ticket;
    }
}
