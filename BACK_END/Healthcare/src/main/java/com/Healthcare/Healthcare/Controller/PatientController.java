package com.Healthcare.Healthcare.Controller;


import com.Healthcare.Healthcare.Entity.Patient;
import com.Healthcare.Healthcare.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/addPatient")
    public Patient postDetails(@RequestBody Patient patient) {
        return patientService.saveDetails(patient);
    }


    @GetMapping("/getPatient")
    public List<Patient> getDetails() {
        return patientService.getAllDetails();
    }

    @GetMapping("/getPatientByID/{id}")
    public Patient getDetailsById(@PathVariable int id) {
        return patientService.getPatientDetailsById(id);
    }

    @PutMapping("/updatePatientByNameAndCivilID")
    public Patient updatePatientDetails(@RequestBody Patient patient) {
        return patientService.updateDetails(patient);
    }

    @DeleteMapping("/deletePatient/{id}")
    public String deleteFunction(@PathVariable int id) {
        return patientService.deletePatient(id);
    }

    @GetMapping("/customFetchPatient")
    public List<Patient> fetchController() {
        return patientService.fetchAllPatients();
    }

    @GetMapping("/customPatientNameAndPassword")
    public Patient customFetch(@RequestParam String user_name, @RequestParam String password) {
        return patientService.fetchUsingNameAndPassword(user_name, password);
    }

}
