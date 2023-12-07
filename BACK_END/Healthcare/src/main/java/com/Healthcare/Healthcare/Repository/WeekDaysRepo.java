package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Entity.WeekDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WeekDaysRepo  extends JpaRepository<WeekDays, Integer> {

    @Query(value="SELECT s FROM WeekDays s")
    List<WeekDays> fetchAllFromCustom();

    @Query(value="SELECT s FROM WeekDays s WHERE s.doctor = :doctor")
    List<WeekDays> fetchWeekDaysUsingDoctor(@Param("doctor")String doctor);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM WeekDays w WHERE w.name = :name and w.doctor = :doctor")
    void deleteByNameAndDoctor(@Param("name") String name, @Param("doctor") String doctor);
}
