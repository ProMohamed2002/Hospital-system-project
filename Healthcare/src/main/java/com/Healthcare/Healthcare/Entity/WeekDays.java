package com.Healthcare.Healthcare.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "WEEK_DAYS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WeekDays {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DOCTOR")
    private String doctor;


}
