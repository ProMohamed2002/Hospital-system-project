package com.Healthcare.Healthcare.Repository;

import com.Healthcare.Healthcare.Entity.Appointment;
import com.Healthcare.Healthcare.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
    @Query(value="SELECT s FROM Appointment s WHERE s.doctor = :doctor")
    public List<Appointment> fetchAppointmentsUsingDoctor(@Param("doctor") String doctor);
    @Query(value="SELECT s FROM Appointment s")
    public List<Appointment> fetchAllFromCustom();

    @Query(value="SELECT s FROM Appointment s WHERE s.doctor =: doctor AND s.week_day =: weekday")
    public List<Appointment> fetchAppointmentsUsingDoctorAndWeek(@Param("doctor") String doctor, @Param("weekday") String weekDay);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM Appointment a WHERE a.doctor = :doctor and a.week_day = :day")
    void deleteAppointmentByDoctorAndDay(@Param("doctor") String doctor, @Param("day") String day);
}
