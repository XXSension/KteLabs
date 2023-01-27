package com.springboot.KteLabs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class Patients {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "fio")
    private String fio;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "snils")
    private int snils;

    @Column(name = "passport_id")
    private int passportId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "patient")
    private List<Ticket> doctorsList;

    public Patients() {
    }

    public Patients(String fio, Date dateOfBirth, int snils, int passportId, String phoneNumber) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.snils = snils;
        this.passportId = passportId;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getSnils() {
        return snils;
    }

    public void setSnils(int snils) {
        this.snils = snils;
    }

    public int getPassportId() {
        return passportId;
    }

    public void setPassportId(int passportId) {
        this.passportId = passportId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @JsonBackReference
    public List<Ticket> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Ticket> doctorsList) {
        this.doctorsList = doctorsList;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", fio='" + fio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", snils=" + snils +
                ", passportId=" + passportId +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
