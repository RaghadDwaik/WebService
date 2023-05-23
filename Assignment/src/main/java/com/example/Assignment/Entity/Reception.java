package com.example.Assignment.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table
public class Reception {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String patientName;

    @Column
    private String doctorName;

    @Column
    private Date appointmentDate;



    public Reception() {

    }

    public Reception(String patientName, String doctorName, Date appointmentDate) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getAppointmentTime() {
        return appointmentDate;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentDate = appointmentDate;
    }
}
