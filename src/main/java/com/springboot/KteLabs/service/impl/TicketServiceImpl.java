package com.springboot.KteLabs.service.impl;

import com.springboot.KteLabs.dao.DoctorRepository;
import com.springboot.KteLabs.dao.TicketRepository;
import com.springboot.KteLabs.entity.Doctors;
import com.springboot.KteLabs.entity.Patients;
import com.springboot.KteLabs.entity.Ticket;
import com.springboot.KteLabs.interfaces.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements com.springboot.KteLabs.service.TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Ticket> createTimetable(Timetable timetable) {
        LocalDateTime startOfWorking = this.getTimestampDateOfAppointment(timetable.getDateOfAppointment());
        LocalDateTime endOfWorking = this.getTimestampDateOfAppointment(timetable.getEndOfWork());
        int countTickets = this.numberOfTickets(startOfWorking,endOfWorking,timetable.getDurationTicket());
        List<Ticket> ticketList = this.createTicketList(
                this.createListTimetable(startOfWorking,countTickets,timetable.getDurationTicket()),
                timetable
                );
        ticketRepository.saveAll(ticketList);
        return ticketList;
    }

    @Override
    public List<Ticket> findAllByPatientIsNull(int id, String data) {
        List<Ticket> freeTicket = this.ticketRepository.findAllByPatientIsNullAndDoctorId(id);
        return freeTicket.stream().filter(ticket -> ticket.getAppointmentTime().getDayOfYear()
                == this.dateConversion(data).getDayOfYear()).collect(Collectors.toList());
    }


    /*
    * Запись к врачу по id
    * */
    @Override
    public Ticket doctorsAppointment(int id, Patients patient) {
        Optional<Ticket> optional = this.ticketRepository.findById(id);
        if (optional.isPresent()){
            Ticket ticket = optional.get();
            if(ticket.getPatient() != null){
                ticket.setPatient(patient);
            }
            return ticket;
        }
        return null;
    }


    /*
    * Конвертация стринга из запроса в LocalDateTime
    * */
    public LocalDateTime dateConversion(String data) {
        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        LocalDate dateTime = LocalDate.parse(data, date);
        LocalDateTime ldt = LocalDateTime.of(dateTime, LocalDateTime.now().toLocalTime());
        return ldt;
    }


    /*
    * Перевод строки с датой начала расписания слотов времени и датой окончания работы доктора в LocalDateTime
    * */
    public LocalDateTime getTimestampDateOfAppointment(String dateOfAppointment){
        DateTimeFormatter formatter
                = DateTimeFormatter.ofPattern("dd-MM-uuuu HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateOfAppointment, formatter);
        return dateTime;
    }


    /*
    * Количество талонов для записи на день к доктору
    * */
    public int numberOfTickets(LocalDateTime startOfWorkingHours, LocalDateTime endOfWorkingHours, int durationOfTickets){
        int startOfWorkingMinute = startOfWorkingHours.getHour() * 60 + startOfWorkingHours.getMinute();
        int endOfWorkingMinute = endOfWorkingHours.getHour() * 60 + startOfWorkingHours.getMinute();
        return (endOfWorkingMinute - startOfWorkingMinute) / durationOfTickets;
    }

    /*
    * Создание листа времени расписаний
    * */
    public List<LocalDateTime> createListTimetable(LocalDateTime startOfWorkingHours, int numberOfTickets, int durationOfTickets) {
        List<LocalDateTime> listTimetable = new ArrayList<>();
        int count = 0;
        int timeDuration = durationOfTickets;
        while(count < numberOfTickets) {
            listTimetable.add(startOfWorkingHours.plusMinutes(timeDuration));
            timeDuration += durationOfTickets;
            count++;
        }
        return listTimetable;
    }

    /*
    * Получение листа Ticket
    * */
    public List<Ticket> createTicketList(List<LocalDateTime> listTimetable, Timetable timetable){
        List<Ticket> ticketList = new ArrayList<>();
        Doctors doctor = null;
        Optional<Doctors> optional = this.doctorRepository.findById(timetable.getDoctorId());
        if(optional.isPresent()) {
            doctor = optional.get();
            for(int i = 0; i < listTimetable.size(); i++){
                Ticket ticket = new Ticket(
                        doctor,
                        null,
                        listTimetable.get(i));
                ticketList.add(ticket);
            }

        }
        return ticketList;
    }

}

