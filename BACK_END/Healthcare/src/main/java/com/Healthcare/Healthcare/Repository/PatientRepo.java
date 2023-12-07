package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Manager;
import com.Healthcare.Healthcare.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Integer> {


    @Query(value="SELECT s FROM Patient s")
    public List<Patient> fetchAllFromCustom();

    @Query(value="SELECT s FROM Patient s WHERE user_name = :userName and password = :password")
    Patient fetchPatientUsingNameAndPassword(@Param("userName")String userName, @Param("password")String password);


    @Query(value="SELECT s FROM Patient s WHERE user_name = :userName and civil_id = :civil_id")
    Patient fetchPatientUsingNameAndCivilID(@Param("userName") String userName, @Param("civil_id") String civilID);
}
