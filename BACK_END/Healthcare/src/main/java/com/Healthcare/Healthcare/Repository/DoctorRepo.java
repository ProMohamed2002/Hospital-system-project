package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Doctor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepo  extends JpaRepository<Doctor, Integer> {

    @Query(value="SELECT d FROM Doctor d")
    List<Doctor> fetchAllFromCustom();

    @Query(value="SELECT d FROM Doctor d WHERE hospital = :hospital AND department = :department")
    List<Doctor> fetchDoctorsUsingHospitalAndDepartment(@Param("hospital")String hospital,@Param("department") String department);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM Doctor d WHERE d.user_name = :user_name AND d.hospital = :hospital AND d.department = :department")
    void deleteDoctorByName(@Param("user_name") String user_name, @Param("hospital") String hospital, @Param("department") String department);

    @Query(value="SELECT d FROM Doctor d WHERE hospital = :hospital AND department = :department AND user_name = :user_name")
    Doctor getDoctorByName(@Param("user_name")String userName, @Param("hospital")String hospital, @Param("department")String department);

    @Query(value="SELECT d FROM Doctor d WHERE d.user_name = :user_name AND d.password = :password")
    Doctor getDoctorByNameAndPassword(@Param("user_name") String user_name,@Param("password") String password);


}
