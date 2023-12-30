package com.Healthcare.Healthcare.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "WORKING_HOURS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WorkingHours {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "WORK_START")
    private Time work_start;

    @Column(name = "WORK_END")
    private Time work_end;

    @Column(name = "WEEK_DAY")
    private String week_day;

    @Column(name = "DOCTOR")
    private String doctor;

}
