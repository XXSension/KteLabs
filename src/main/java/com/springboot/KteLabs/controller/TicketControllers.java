package com.springboot.KteLabs.controller;

import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;
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

    @PostMapping
    public List<Ticket> createTimetable(@RequestBody Timetable timetable) {
        return ticketService.createTimetable(timetable);

    }

    @GetMapping("/freeticket/{doctorId}/{data}")
    public List<Ticket> findByFreeTicket(@PathVariable int doctorId, @PathVariable String data){
        return ticketService.findAllByPatientIsNull(doctorId,data);
    }

    @PutMapping("/entryticket/{id}")
    public Ticket doctorsAppointment(@PathVariable int id, @RequestBody Patients patients) {
        return this.ticketService.doctorsAppointment(id,patients);
    }


}
