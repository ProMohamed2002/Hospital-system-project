package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Doctor;
import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Service.DoctorService;
import com.Healthcare.Healthcare.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/addDoctor")
    public Doctor postDetails(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("/customFetchDoctor")
    public List<Doctor> fetchController() {
        return doctorService.fetchAllDoctors();
    }

    @GetMapping("/customHospitalAndDepartment")
    public List<Doctor> customFetch(@RequestParam String hospital, @RequestParam String department) {
        return doctorService.fetchDoctorsUsingHospitalAndDepartment(hospital, department);
    }

    @GetMapping("/customDoctorNameAndPassword")
    public Doctor customUserNameAndPassword(@RequestParam String user_name, @RequestParam String password) {
        return doctorService.getDoctorByNameAndPassword(user_name, password);
    }

    @DeleteMapping("/customDeleteDoctor")
    public void customDelete(@RequestParam String user_name, @RequestParam String hospital, @RequestParam String department) {
        doctorService.deleteDoctorByName(user_name, hospital, department);
    }

    @PutMapping("/customUpdateDoctor")
    public Doctor customUpdate(@RequestBody Doctor doctor) {
        return doctorService.updateDoctorByName(doctor);
    }
}
