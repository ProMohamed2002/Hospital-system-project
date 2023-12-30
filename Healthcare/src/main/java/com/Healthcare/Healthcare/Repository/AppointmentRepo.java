package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {

    @Query(value="SELECT s FROM Appointment s")
    public List<Appointment> fetchAllFromCustom();

    @Query(value="SELECT a FROM Appointment a WHERE a.doctor = :doctor AND a.week_day = :weekday and a.session_date = :day_date")
    public List<Appointment> fetchAppointmentsUsingDoctorAndWeek(@Param("doctor") String doctor, @Param("weekday") String weekDay, @Param("day_date") Date date);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM Appointment a WHERE a.doctor = :doctor and a.week_day = :day")
    void deleteAppointmentByDoctorAndDay(@Param("doctor") String doctor, @Param("day") String day);
}
