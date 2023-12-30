package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Doctor;
import com.Healthcare.Healthcare.Entity.Hospital;
import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Service.HospitalService;
import com.Healthcare.Healthcare.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;


    @PostMapping("/addHospital")
    public Hospital postDetails(@RequestBody Hospital hospital) {
        return hospitalService.saveHospital(hospital);
    }

    @GetMapping("/customFetchHospital")
    public List<Hospital> fetchController() {
        return hospitalService.fetchAllHospitals();
    }

    @GetMapping("/customName")
    public Hospital customFetch(@RequestParam String name) {
        return hospitalService.fetchHospitalsUsingName(name);
    }

    @DeleteMapping("/customDeleteHospital")
    public void customDelete(@RequestParam String name) {
        hospitalService.deleteHospitalByName(name);
    }

    @PostMapping("/customUpdateHospital")
    public Hospital customUpdate(@RequestBody Hospital hospital) {
        return hospitalService.updateHospitalByName(hospital);
    }
}
