package com.Healthcare.Healthcare.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "HOSPITAL")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Hospital {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL_ADDRESS")
    private String email_address;

    @Column(name = "DOCTORS_NUMBER")
    private int doctors_number;

    @Column(name = "CLINICS_NUMBER")
    private int clinics_number;

    @Column(name = "INTENSIVE_CARE_BEDS")
    private int intensive_care_beds;

}