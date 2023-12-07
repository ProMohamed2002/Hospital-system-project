package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Department;
import com.Healthcare.Healthcare.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartmentRepo  extends JpaRepository<Department, Integer> {

    @Query(value="SELECT s FROM Department s")
    List<Department> fetchAllFromCustom();

    @Query(value="SELECT s FROM Department s WHERE hospital = :hospital")
    List<Department> fetchDepartmentsUsingHospital(@Param("hospital") String hospital);

    @Query(value="SELECT s FROM Department s WHERE hospital = :hospital AND name = :name")
    Department getDepartmentByName(@Param("hospital") String name, @Param("name") String hospital);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM Department d WHERE d.name = :name AND d.hospital = :hospital")
    void deleteDepartmentByName(@Param("name") String name, @Param("hospital") String hospital);
}
