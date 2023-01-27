package com.springboot.KteLabs.interfaces;

import java.time.LocalDateTime;

public class Timetable {

    private String dateOfAppointment;


    private int doctorId;

    private int durationTicket;


    private String endOfWork;

    public Timetable() {
    }

    public Timetable(String dateOfAppointment, int doctorId, int durationTicket, String endOfWork) {
        this.dateOfAppointment = dateOfAppointment;
        this.doctorId = doctorId;
        this.durationTicket = durationTicket;
        this.endOfWork = endOfWork;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDateOfAppointment() {
        return dateOfAppointment;
    }

    public void setDateOfAppointment(String dateOfAppointment) {
        this.dateOfAppointment = dateOfAppointment;
    }


    public int getDurationTicket() {
        return durationTicket;
    }

    public void setDurationTicket(int durationTicket) {
        this.durationTicket = durationTicket;
    }


    public String getEndOfWork() {
        return endOfWork;
    }

    public void setEndOfWork(String endOfWork) {
        this.endOfWork = endOfWork;
    }
}
