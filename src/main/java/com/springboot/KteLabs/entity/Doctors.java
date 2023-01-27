package com.springboot.KteLabs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "doctors")
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "fio")
    private String fio;

    @Column(name = "floor")
    private int floor;

    @Column(name = "cabinet")
    private int cabinet;

    @Column(name = "specialization")
    private String specialization;

    @OneToMany(mappedBy = "doctor")
    private List<Ticket> patientsList;

    public Doctors() {
    }

    public Doctors(String fio, int floor, int cabinet, String specialization) {
        this.fio = fio;
        this.floor = floor;
        this.cabinet = cabinet;
        this.specialization = specialization;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCabinet() {
        return cabinet;
    }

    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }


    @JsonBackReference
    public List<Ticket> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Ticket> patientsList) {
        this.patientsList = patientsList;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "id=" + id +
                ", uuid=" + uuid +
                ", fio='" + fio + '\'' +
                ", floor=" + floor +
                ", cabinet=" + cabinet +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
