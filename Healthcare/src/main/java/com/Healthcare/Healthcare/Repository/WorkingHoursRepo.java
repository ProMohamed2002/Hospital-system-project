package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Entity.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkingHoursRepo extends JpaRepository<WorkingHours, Integer> {

    @Query(value="SELECT s FROM WorkingHours s")
    List<WorkingHours> fetchAllFromCustom();


    @Query(value="SELECT s FROM WorkingHours s WHERE s.week_day = :weekDay AND s.doctor = :doctor")
    List<WorkingHours> fetchWorkingHoursUsingDayAndDoctor(@Param("weekDay")String weekDay, @Param("doctor")String doctor);

    @Query(value="DELETE FROM WorkingHours w WHERE w.week_day = :day and w.doctor = :doctor")
    void deleteWorkingHoursByDayAndDoctor(@Param("day") String day, @Param("doctor") String doctor);
}
