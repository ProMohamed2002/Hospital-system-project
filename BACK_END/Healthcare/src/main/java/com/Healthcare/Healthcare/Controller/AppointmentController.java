package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Appointment;
import com.Healthcare.Healthcare.Entity.Doctor;
import com.Healthcare.Healthcare.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/addAppointment")
    public Appointment postDetails(@RequestBody Appointment appointment) {
        return appointmentService.saveAppointment(appointment);
    }

    @GetMapping("/customFetchAppointment")
    public List<Appointment> fetchController() {
        return appointmentService.fetchAllAppointments();
    }

    @GetMapping("/customDoctorAndWeek")
    public List<Appointment> customFetch(@RequestParam String doctor, @RequestParam String week_day) {
        return appointmentService.fetchAppointmentsUsingDoctorAndWeek(doctor, week_day);
    }

    @DeleteMapping("/customDeleteAppointment")
    public void customDelete(@RequestParam String doctor, @RequestParam String day) {
        appointmentService.deleteAppointmentByDoctorAndDay(doctor, day);
    }
    /*
    @PutMapping("/customUpdateDoctor")
    public Doctor customUpdate(@RequestBody Doctor doctor) {
        return doctorService.updateDoctorByName(doctor);
    }*/
}
