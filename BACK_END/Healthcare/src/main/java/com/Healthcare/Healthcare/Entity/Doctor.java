package com.Healthcare.Healthcare.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Data
@Table(name = "DOCTOR")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "USER_NAME")
    private String user_name;

    @Column(name = "EMAIL_ADDRESS")
    private String email_address;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "BIRTH_DATE")
    private Date birth_date;

    @Column(name = "CIVIL_ID")
    private String civil_id;

    @Column(name = "PHONE_NUMBER")
    private String phone_number;

    @Column(name = "HOSPITAL")
    private String hospital;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "DESCRIPTION")
    private String description;

}
