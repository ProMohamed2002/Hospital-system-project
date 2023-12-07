package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Hospital;
import com.Healthcare.Healthcare.Entity.Manager;
import com.Healthcare.Healthcare.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ManagerRepo  extends JpaRepository<Manager, Integer> {

    @Query(value="SELECT s FROM Manager s")
    List<Manager> fetchAllFromCustom();

    @Query(value="SELECT s FROM Manager s WHERE user_name = :userName AND password = :password")
    Manager fetchManagersUsingNameAndPassword(@Param("userName")String userName, String password);

    @Query(value="SELECT s FROM Manager s WHERE user_name = :userName AND civil_id = :civil_id")
    Manager getManagerByNameAndCivilID(@Param("userName") String userName, @Param("civil_id") String civilID);
}
