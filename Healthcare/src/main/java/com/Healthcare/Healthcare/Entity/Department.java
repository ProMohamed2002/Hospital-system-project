package com.Healthcare.Healthcare.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "DEPARTMENT")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "HOSPITAL")
    private String hospital;
}
