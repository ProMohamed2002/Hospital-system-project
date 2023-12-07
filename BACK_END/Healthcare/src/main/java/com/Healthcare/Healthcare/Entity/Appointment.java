package com.Healthcare.Healthcare.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "APPOINTMENT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Appointment {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "BOOKING_DATE")
    private Date booking_date;

    @Column(name = "BOOKING_NUMBER")
    private int booking_number;

    @Column(name = "SESSION_START")
    private Timestamp session_start;

    @Column(name = "SESSION_END")
    private Timestamp session_end;

    @Column(name = "DOCTOR")
    private String doctor;

    @Column(name = "PATIENT")
    private String patient;

    @Column(name = "WEEK_DAY")
    private String week_day;

    @Column(name = "FEES")
    private float fees;


}
