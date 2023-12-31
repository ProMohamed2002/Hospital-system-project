package com.Healthcare.Healthcare.Service;

import com.Healthcare.Healthcare.Entity.Appointment;
import com.Healthcare.Healthcare.Repository.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;
    public Appointment saveAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    public List<Appointment> fetchAllAppointments() {
        return appointmentRepo.fetchAllFromCustom();
    }

    public List<Appointment> fetchAppointmentsUsingDoctorAndWeek(String doctor, String weekDay, Date day_date) {
        return appointmentRepo.fetchAppointmentsUsingDoctorAndWeek(doctor, weekDay, day_date);
    }

    public void deleteAppointmentByDoctorAndDay(String doctor, String day) {
        appointmentRepo.deleteAppointmentByDoctorAndDay(doctor, day);
    }
}
