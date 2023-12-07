package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Department;
import com.Healthcare.Healthcare.Entity.Hospital;
import com.Healthcare.Healthcare.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HospitalRepo  extends JpaRepository<Hospital, Integer> {

    @Query(value="SELECT s FROM Hospital s")
    List<Hospital> fetchAllFromCustom();

    @Query(value="SELECT s FROM Hospital s WHERE name = :name")
    List<Hospital> fetchHospitalsUsingName(@Param("name")String name);

    @Query(value="SELECT h FROM Hospital h WHERE name = :name")
    Hospital getHospitalByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM Hospital h WHERE h.name = :name")
    void deleteHospitalByName(@Param("name") String name);
}
