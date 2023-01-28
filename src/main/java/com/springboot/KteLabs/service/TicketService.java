package com.springboot.KteLabs.service;

import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;
import com.springboot.KteLabs.interfaces.Timetable;

import java.util.List;

public interface TicketService {

    List<Ticket> createTimetable(Timetable params);

    List<Ticket> findAllByPatientIsNull(int id, String data);

    Ticket doctorsAppointment(int ticketId, int patientId);
//
//    List<Ticket> getAllFreeTimetable(String date);
//
//    Ticket saveTicket(int id);
//
//    List<Ticket> getTicketById(int id);
}
